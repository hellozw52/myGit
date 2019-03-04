package hdfx.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import hdfx.dao.UserDao;
import hdfx.entity.User;

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
    public int login(User user) {
	// TODO Auto-generated method stub
	return userDao.login(user);
    }



}
