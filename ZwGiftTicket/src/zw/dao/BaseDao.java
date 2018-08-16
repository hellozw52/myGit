package zw.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * SpringMVC+Hibernate +MySql+ EasyUI ---CRUD
 * dao层的共有父类，提供了常用的数据库操作方法
 */

public class BaseDao {
    private static Log log = LogFactory.getLog(BaseDao.class);
    @Resource
    protected SessionFactory sessionFactory; //注意！需要注入sessionfactory 使用@Resource进行注入
    
    protected JdbcTemplate jdbcTemplate;

    public Session getSession() {
	// 事务必须是开启的(Required)，否则获取不到
	return sessionFactory.getCurrentSession();
    }

    /**
     * 根据主键，返回实体
     * 
     * @param id
     *            主键
     * @return 实体或空（如果没有查到）
     */
    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> entityClass, Serializable id) {
	if (null == id) {
	    return null;
	}
	T t = null;
	try {
	    t = (T) getSession().get(entityClass, id);
	} catch (Exception e) {
	    if (log.isErrorEnabled()) {
		log.error("通过主键查询实体失败", e);
	    }
	}
	return t;
    }

    /**
     * 保存实体对象，返回主键
     * 
     * @param model
     * @return
     */
    public Serializable save(Object model) {
	return getSession().save(model);
    }

    /**
     * 更新实体对象，不返回值
     * 
     * @param entity
     */
    public void update(Object model) {
	getSession().update(model);
    }

    /**
     * 执行更新或插入语句，返回受影响的行数
     * 
     * @param sql
     *            纯sql语句
     * @param param
     * @return
     */
    public int update(String sql, Object[] param) {
	return jdbcTemplate.update(sql, param);
    }

    /**
     * 删除指定对象，不返回值
     * 
     * @param model
     */
    public void delete(Object model) {
	getSession().delete(model);
    }

    /**
     * 删除对象列表，不返回值
     * 
     * @param list
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void deleteAll(List list) {
	if (null != list && list.size() > 0) {
	    for (Iterator<Object> iter = list.iterator(); iter.hasNext();) {
		delete(iter.next());
	    }
	}
    }

    /**
     * 删除对象列表，不返回值
     * 
     * @param objectArray
     */
    public void deleteAll(Object[] objectArray) {
	if (null != objectArray) {
	    for (int i = 0; i < objectArray.length; i++) {
		delete(objectArray[i]);
	    }
	}
    }

    /**
     * 根据主键删除
     * 
     * @param id
     */
    public void delete(Class<?> entityClass, Serializable id) {
	if (null == id) {
	    return;
	}
	getSession().delete(this.get(entityClass, id));

    }

    /**
     * 保存或更新
     * 
     * @param model
     *            实体类
     */
    public void saveOrUpdate(Object model) {
	getSession().saveOrUpdate(model);
    }

    /**
     * 根据查询条件返回唯一一条记录 如果查询出多条，返回第一条
     * 
     * @param hql
     * @param param
     * @return 如果查不到东西返回null
     */
    public Object unique(final String hql, final Object[] param) {
	Query query = getSession().createQuery(hql);
	setParameters(query, param);
	return query.setMaxResults(1).uniqueResult();
    }

    /**
     * 
     * @param hql
     *            普通hql语句
     * @param param
     *            参数
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List list(String hql, Object[] param) {
	return list(hql, param, -1, -1, null);
    }

    /**
     * 分页查询方法
     * 
     * @param entity
     *            任意实体
     * @param start
     *            分页起始数，第1页应为0
     * @param size
     *            每个分页大小
     * @param order
     *            排序语句,本方法会自动加上" order by "关键字
     * @return 封装有所查询实体类的列表,可能返回null
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> entity, int start, int size,
	    String order) {
	String sql = " from " + entity.getSimpleName();
	return list(sql, null, start, size, order);
    }

    /**
     * 分页查询
     * 
     * @param entity
     *            任意实体
     * @param condition
     *            查询条件
     * @param param
     *            参数
     * @return 封装有所查询实体类的列表,可能返回null
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> entity, String condition, Object[] param) {
	String sql = " from " + entity.getSimpleName();
	if (null != condition && condition.length() > 0) {
	    sql += " where " + condition;
	}
	return list(sql, param, 0, 0, null);
    }

    /**
     * 分页查询
     * 
     * @param entity
     *            任意实体
     * @param condition
     *            查询条件
     * @param param
     *            参数
     * @param start
     *            分页起始数，第1页应为0
     * @param size
     *            每个分页大小
     * @param order
     *            排序语句,本方法会自动加上" order by "关键字
     * @return 封装有所查询实体类的列表,可能返回null
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> entity, String condition, Object[] param,
	    int start, int size, String order) {
	String sql = " from " + entity.getSimpleName();
	if (null != condition && condition.length() > 0) {
	    sql += " where " + condition;
	}
	return list(sql, param, start, size, order);
    }

    /**
     * 按照查询条件，查出统计数
     * 
     * @param entity
     * @param condition
     *            查询条件，可为空
     * @param param
     * @return
     */
    public int count(Class<?> entity, String condition, Object[] param) {
	String sql = "select count(*) from " + entity.getSimpleName();
	if (null != condition && condition.length() > 0) {
	    sql += " where " + condition;
	}

	return count(sql, param);
    }

    /**
     * 返回个数
     * 
     * @param entity
     *            任意实体
     * @return
     */
    public int count(Class<?> entity) {
	String sql = " select count(*) from " + entity.getSimpleName();
	return count(sql, null);
    }

    /**
     * 返回个数
     * 
     * @param hql
     *            符合HQL语法的count语句
     * @param param
     *            参数
     * @return 查询的结果,如果出错,返回0
     */
    public int count(String hql, Object[] param) {
	Query query = getSession().createQuery(hql);
	setParameters(query, param);
	Object o = query.setMaxResults(0).uniqueResult();
	int count = 0;
	try {
	    count = Integer.parseInt(o.toString());
	} catch (Exception e) {
	    e.printStackTrace();
	    return 0;
	}
	return count;
    }

    /**
     * 分页查询方法
     * 
     * @param hql
     *            要求为hql语句
     * @param param
     *            参数
     * @param start
     *            分页起始数，第1页应为0
     * @param size
     *            每个分页大小
     * @param order
     *            排序语句,本方法会自动加上" order by "关键字
     * @return 封装有所查询实体类的列表,可能返回null
     */
    @SuppressWarnings("rawtypes")
    public List list(String hql, Object[] param, int start, int size,
	    String order) {
	if (null != order && order.length() > 0) {
	    hql += " order by " + order;
	}
	Query query = getSession().createQuery(hql);
	setParameters(query, param);
	if (start >= 0) { // 开始页数不小于0才进行分页
	    if (size > 0) { // 每页限制数量大于0才进行分页,不然无意义
		query.setFirstResult(start * size);
		query.setMaxResults(size);
	    } else { // 每页限制数量不大于0时,分页无意义
		query.setFirstResult(0);
	    }
	}
	return query.list();
    }

    @SuppressWarnings("rawtypes")
    public List criteriaList(Criteria criteria, int start, int size,
	    String order, List<Integer> schoolIdList) {
	if (order != null && order.length() > 0) {
	    String[] orders = order.split(" ");
	    if ("desc".equals(orders[1])) {
		criteria.addOrder(Order.desc(orders[0]));
	    } else {
		criteria.addOrder(Order.asc(orders[0]));
	    }
	}
	if (start >= 0) { // 开始页数不小于0才进行分页
	    if (size > 0) { // 每页限制数量大于0才进行分页,不然无意义
		criteria.setFirstResult(start * size);
		criteria.setMaxResults(size);
	    } else { // 每页限制数量不大于0时,分页无意义
		criteria.setFirstResult(0);
	    }
	}
	return criteria.list();
    }

    /**
     * 纯sql的分页
     * 
     * @param sql
     *            纯sql语句
     * @param param
     *            参数
     * @param start
     *            分页起始数
     * @param size
     *            每页个数
     * @param order
     *            排序语句,本方法会自动加上" order by "关键字
     * @return 以Map<String,Object>组成的列表,可能返回null
     */
    public List<Map<String, Object>> listByNative(String sql, Object[] param,
	    int start, int size, String order) {
	if (null != order && order.trim().length() > 0) {
	    sql += " order by " + order;
	}
	sql = getLimitString(sql, start, size);
	return jdbcTemplate.queryForList(sql, param);
    }

    /**
     * 纯sql的count方法
     * 
     * @param sql
     *            纯sql语句
     * @param param
     *            参数
     * @return 正常的个数,如果出错或为空,返回0
     */
    public int countByNative(String sql, Object[] param) {
	return jdbcTemplate.queryForObject(sql, param, Integer.class);
    }

    /**
     * 把普通sql语句,处理成分页语句</br>
     * 
     * @param sql
     *            纯sql语句
     * @param start
     *            起始页码
     * @param size
     *            每页个数
     * @return
     */
    public String getLimitString(String sql, int start, int size) {
	// 只有在页数不为负且每页为正的时候,才进行分页
	if (start >= 0 && size > 0) {
	    sql = sql + " limit " + start * size + ", " + size;
	}
	return sql;
    }

    /**
     * 删除操作
     * 
     * @param hql
     *            HQL语句
     * @param param
     */
    public void delete(final String hql, Object[] param) {
	Query query = getSession().createQuery(hql);
	setParameters(query, param);
	query.executeUpdate();
    }

    /**
     * 查出所有相关实体的信息
     * 
     * @param entityClass
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> entityClass) {
	Criteria criteria = getSession().createCriteria(entityClass);
	return criteria.list();
    }

    public int execte(final String hql, final Object... paramlist) {
	Query query = getSession().createQuery(hql);
	setParameters(query, paramlist);
	return query.executeUpdate();
    }

    /**
     * 批量更新多个实体。
     * 
     * @param list
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void batchUpdate(List list) {
	if (null != list && list.size() > 0) {
	    for (Iterator<Object> iter = list.iterator(); iter.hasNext();) {
		update(iter.next());
	    }
	}
    }

    protected void setParameters(Query query, Object[] paramlist) {
	if (paramlist != null) {
	    for (int i = 0; i < paramlist.length; i++) {
		if (paramlist[i] instanceof Date) {
		    // 难道这是bug 使用setParameter不行？？
		    query.setTimestamp(i, (Date) paramlist[i]);
		} else {
		    query.setParameter(i, paramlist[i]);
		}
	    }
	}
    }

    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }

    public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
    }
}
