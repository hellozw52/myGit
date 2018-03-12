package zw.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 登录功能
 * @author zhaowei 
 */
//将参数username的值存入到session中
@SessionAttributes(value = "username")
@Controller
@RequestMapping("/userlogin")
public class LoginUserController {
    
    @RequestMapping("/login")
    public String dologin(
	    @RequestParam("username") String username,
	    @RequestParam("password") String password, 
	    Map<String, Object> map) throws IOException {
	
	// 设置登录账户和密码
	String userName = "admin";
	String passWord = "admin";
	
	// 模拟查询数据库进行登录
	if (username.equals(userName) && password.equals(passWord)) {
		map.put("username", username);//存放在request请求域中
		/**
		 * 类上加上@SessionAttributes({"username"}) 同时也会存放在 session域中
		 * @SessionAttributes 除了可以通过属性名指定需要存放到会话中的属性外(使用的是value属性值)
		 * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是types属性值),
		 */
		return "frame";
	}else{
	    return "error";
	}
	
    }
}
