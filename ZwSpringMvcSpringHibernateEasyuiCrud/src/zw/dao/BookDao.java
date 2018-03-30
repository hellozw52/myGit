package zw.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zw.model.SsmBook;

@Repository
public class BookDao {

    // 注入sessionfactory
    @Autowired
    public SessionFactory sessionFactory;

    // 获取当前session
    private Session getSession() {
	return sessionFactory.getCurrentSession();
    }
    
    /**
     * 获取当前页面数据
     * @param page
     * @param rows
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SsmBook> getCurrentPageDataList(String page, String rows) {
	// TODO Auto-generated method stub
	// 当为缺省值的时候进行赋值
	int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
		: page);// 第几页
	int pagesize = Integer.parseInt((rows == null || rows == "0") ? "15"
		: rows);// 每页多少行

	List<SsmBook> list = this.getSession()
		.createQuery("from SsmBook")
		.setFirstResult((currentpage - 1) * pagesize)
		.setMaxResults(pagesize).list();

	return list;
    }
    
    /**
     * 总数
     * @return
     */
    public int getTotalNum() {
	// TODO Auto-generated method stub
	return this.getSession().createQuery("from SsmBook").list().size();
    }

    
    /**
     * 增加
     * @param book
     */
    public void add(SsmBook book) {
	// TODO Auto-generated method stub
	this.getSession().save(book);
    }

    /**
     * 修改
     * @param book
     */
    public void update(SsmBook book) {
	// TODO Auto-generated method stub
	this.getSession().update(book);
    }

    /**
     * 删除
     * @param book
     */
    public void delete(SsmBook book) {
	// TODO Auto-generated method stub
	this.getSession().delete(book);
	
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public SsmBook getById(int id) {
	// TODO Auto-generated method stub
	return (SsmBook)this.getSession().get(SsmBook.class, id);
    }

    /**
     * 多条件模糊查询
     * @param params
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SsmBook> search(Map<String, Object> params) {
	// TODO Auto-generated method stub
	
	//获取参数
	String id = (String) params.get("id");
	String isbn = (String) params.get("isbn");
	String title = (String) params.get("title");
	
	//转为int类型
	int page = Integer.parseInt((String) params.get("page"));
	int rows = Integer.parseInt((String) params.get("rows"));
		
	return (List<SsmBook>) this.getSession()
		.createQuery("from SsmBook s where s.id like '%"+id+"%' and s.isbn like '%"+isbn+"%' and s.title like '%"+title+"%'" )
		.setFirstResult((page - 1) * rows)
		.setMaxResults(rows)
		.list();
    }

    /**
     * 查询结果的个数
     * @param params
     * @return
     */
    public int getTotalNum(Map<String, Object> params) {
	// TODO Auto-generated method stub
	
	//获取参数
	String id = (String) params.get("id");
	String isbn = (String) params.get("isbn");
	String title = (String) params.get("title");
			
	return this.getSession()
		.createQuery("from SsmBook s where s.id like '%"+id+"%' and s.isbn like '%"+isbn+"%' and s.title like '%"+title+"%'" )
		.list()
		.size();
    }

}
