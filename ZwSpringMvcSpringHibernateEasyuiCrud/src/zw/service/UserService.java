package zw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.dao.UserDao;
import zw.model.SsmUser;

@Transactional
@Service
public class UserService {
    
    // 注入dao
    @Autowired
    public UserDao userDao;

    /**
     * 判断该用户是否可以登录
     * @param user
     * @return 可以登录返回1
     */
    public int login(SsmUser user) {
	// TODO Auto-generated method stub
	return userDao.login(user);
    }

    /**
     * 获取当前页面数据
     * @param start  开始位置
     * @param size   每页个数
     * @return
     */
    public List<SsmUser> getCurrentPageDataList(int start, int size) {
	// TODO Auto-generated method stub
	return userDao.getCurrentPageDataList(start,size);
    }

    /**
     * 获取总数
     * @return
     */
    public int getTotalNum() {
	// TODO Auto-generated method stub
	return userDao.getTotalNum();
    }
    
    /**
     * getbyid
     * @param id
     * @return
     */
    public SsmUser getById(int id) {
	// TODO Auto-generated method stub
	return userDao.getById(id);
    }

    /**
     * 增
     * @param user
     */
    public void add(SsmUser user) {
	// TODO Auto-generated method stub
	userDao.add(user);
    }

    /**
     * 改
     * @param user
     */
    public void update(SsmUser user) {
	// TODO Auto-generated method stub
	userDao.update(user);
    }

    /**
     * 删
     * @param user
     */
    public void delete(SsmUser user) {
	// TODO Auto-generated method stub
	userDao.delete(user);
    }

}
