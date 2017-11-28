package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import service.impl.UserDAOImpl;

import com.opensymphony.xwork2.ModelDriven;

import entity.Users;

//用户Action
public class UsersAction extends SuperAction implements ModelDriven<Users>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Users user = new Users();
	
	//用户登录方法
	public String login()
	{
		UsersDAO udao = new UserDAOImpl();
		if(udao.usersLogin(user))
		{
			//将登陆用户name存在session中
			session.setAttribute("loginUserName", user.getUsername());
			return "login_success";
		}
		else
		{
			return "login_failure";
		}
	}
	
	@SkipValidation
	//用户注销方法
	public String logout()
	{
		if(session.getAttribute("loginUserName")!=null)
		{
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if("".equals(user.getUsername().trim()))
		{
			this.addFieldError("usernameError", "用户名错误");
		}
		if(user.getPassword().length()<6)
		{
			this.addFieldError("passwordError", "密码长度不足");
		}
		
	}

	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
