package zw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import zw.model.SsmUser;
import zw.tools.StringUtil;

/**
 * @author zhaowei
 */
// 将参数username的值存入到session中
@SessionAttributes("username")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    /**
     * 跳转至user.jsp页面
     * @return
     */
    @RequestMapping("/goToUserTab")
    public String goToUserTab() {
	return "user";
    }
    
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
//	    String MD5pwd = MD5Util.MD5Encode(password, "UTF-8");
	    
	    // 设置账户和密码
	    user.setUserName(username);
	    user.setPassword(password);

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
    
    /**
     * 接收前端传递的数据page，rows 获取当前页数据 返回json数据
     * @param page
     * @param rows
     * @return @ResponseBody json
     */
    @ResponseBody
    @RequestMapping("/list")
    public Map<String, Object> list(
	    @RequestParam("page") String page, 
	    @RequestParam("rows") String rows) {
	// 获取当前页数据
	List<SsmUser> userlist = userService.getCurrentPageDataList(page,rows);
	// 获取总数
	int usercount = userService.getTotalNum();

	// 实例化data 存放数据
	data = new HashMap<String, Object>();
	data.put("rows", userlist);
	data.put("total", usercount);
	// 返回json数据
	return data;
    }
    
    /**
     * 增
     * @param request
     * @param response
     * @param userName
     * @param password
     * @param roleName
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    public String add(
	    HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam("userName") String userName, 
	    @RequestParam("password") String password,
	    @RequestParam("roleName") String roleName
	    ) throws Exception {
	try {
	    SsmUser user = new SsmUser();
	    user.setUserName(userName);
	    user.setPassword(password);
	    user.setRoleName(roleName);
	    
	    // 新增
	    this.userService.add(user);
	    // 给前端返回{"success":true}
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",response);
	} catch (Exception e) {
	    // 给前端返回{"errorMsg":"保存失败"}
	    result = "{\"errorMsg\":\"保存失败\"}";
	    StringUtil.writeToWeb(result, "html",response);
	}
	return null;
    }
    
    /**
     * 改
     * @param request
     * @param response
     * @param id
     * @param userName
     * @param password
     * @param roleName
     * @return
     * @throws Exception
     */
    @RequestMapping("/update")
    public String update(
	    HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam("id") String id,
	    @RequestParam("userName") String userName, 
	    @RequestParam("password") String password,
	    @RequestParam("roleName") String roleName
	    ) throws Exception {
	try {
	    //获取待修改的条目
	    SsmUser user = userService.getById(Integer.parseInt(id));
	    
	    user.setUserName(userName);
	    user.setPassword(password);
	    user.setRoleName(roleName);
	    
	    //更新
	    this.userService.update(user);
	    // 给前端返回{"success":true}
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",response);
	} catch (Exception e) {
	    // 给前端返回{"errorMsg":"修改失败"}
	    result = "{\"errorMsg\":\"修改失败\"}";
	    StringUtil.writeToWeb(result, "html",response);
	}
	return null;
    }

    /**
     * 删
     * @param request
     * @param response
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String delete(
	    HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam("id") String id
	    ) throws Exception {
	try {
	    // 获取待删除条目
	    SsmUser user = this.userService.getById(Integer.parseInt(id));
	    // 删除条目
	    this.userService.delete(user);
	    result = "{\"success\":true}";
	    StringUtil.writeToWeb(result, "html",response);
	} catch (Exception e) {
	    result = "{\"errorMsg\":\"删除失败\"}";
	    StringUtil.writeToWeb(result, "html",response);
	}
	return null;
    }
}
