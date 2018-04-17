package zw.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import zw.model.SsmUser;

/**
 * 继承父类，实现增删改查等常用操作
 * @author zhaowei
 */
@Repository
public class UserDao extends BaseDao {

    /**
     * 判断该用户是否在数据库中存在
     * @param user
     * @return 存在 返回1
     */
    public int login(SsmUser user) {
	// TODO Auto-generated method stub
	
	// 获取登录信息
	String username = user.getUserName();
	String password = user.getPassword();
	
	// 查询数据库  采用sql语句进行查询
	int usercount = super.getSession()
		.createSQLQuery("select * from ssm_user user where user.userName = '"+username+"' and user.password = '"+password+"'")
		.list().size();
		
	return usercount;
    }
    
    /**
     * 获取当前页面数据  通过父类实现
     * @param start
     * @param size
     * @return
     */
    public List<SsmUser> getCurrentPageDataList(int start, int size) {
	// TODO Auto-generated method stub
	List<SsmUser> list = super.list(SsmUser.class, start, size,null);
	return list;
    }

    /**
     * 获取总数  通过父类实现
     * @return
     */
    public int getTotalNum() {
	// TODO Auto-generated method stub
	return super.count(SsmUser.class);
	
    }
    
    /**
     * 获取某个  通过父类实现
     * @param id
     * @return
     */
    public SsmUser getById(int id) {
	// TODO Auto-generated method stub
	return super.get(SsmUser.class, id);
    }

    /**
     * 增   通过父类实现
     * @param user
     * @return
     */
    public void add(SsmUser user) {
	// TODO Auto-generated method stub
	super.saveOrUpdate(user);
    }

    /**
     * 改  通过父类实现
     * @param user
     */
    public void update(SsmUser user) {
	// TODO Auto-generated method stub
	super.update(user);
    }

    /**
     * 删  通过父类实现
     * @param user
     */
    public void delete(SsmUser user) {
	// TODO Auto-generated method stub
	super.delete(user);
    }

}
