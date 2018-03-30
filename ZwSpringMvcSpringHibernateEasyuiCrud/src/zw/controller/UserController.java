package zw.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import zw.model.SsmUser;
import zw.tools.MD5Util;

/**
 * @author zhaowei
 */
// 将参数username的值存入到session中
@SessionAttributes("username")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    /**
     * 用户登录
     * @param username 账号
     * @param password 密码
     * @param map 存放参数
     * @return
     * @throws IOException
     */
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
	    @RequestParam("password") String password, Map<String, Object> map)
	    throws IOException {

	// 记录查询结果数   默认为0
	int resultcount = 0;

	if (!username.isEmpty() && !password.isEmpty()) {
	    // 实例化一个user  
	    SsmUser user = new SsmUser();
	    // 密码采用MD5加密
	    String MD5pwd = MD5Util.MD5Encode(password, "UTF-8");
	    // 设置账户和密码
	    user.setUserName(username);
	    user.setPassword(MD5pwd);

	    // 查询的结果数据
	    resultcount = userService.login(user);
	    // 有结果
	    if (resultcount == 1) {
		map.put("username", username);// 存放在request请求域中
		// 跳转至登录成功界面
		return "frame";
	    } else {
		// 没有查到结果，跳转至登录失败界面
		return "error";
	    }
	}else{
	    // 没有传递登录参数，跳转至登录失败界面
	    return "error";
	}
    }
}
