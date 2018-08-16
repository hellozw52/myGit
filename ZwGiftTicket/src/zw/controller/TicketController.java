package zw.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 与前端easyui进行交互
 * CRUD
 * @author zhaowei 
 */
@Controller
@RequestMapping("/ticket")
public class TicketController extends BaseController{

    /**
     * 对视图进行查询  根据tvn和entity_type 查询用户卡券信息
     * @param tvn
     * @param entity_type
     * @return
     */
    @ResponseBody
    @RequestMapping("/query_ticket")
    public List<Map<String, Object>> query(
	    @RequestParam("tvn") String tvn, 
	    @RequestParam("entity_type") String entity_type) {
	//去掉前后两端的中文引号
//	entity_type = entity_type.substring(1,entity_type.length()-1);
	
	List<Map<String, Object>> tickets = ticketService.queryTicket(tvn,entity_type);

//	// 实例化data 存放数据
//	data = new HashMap<String, Object>();
//	data.put("result", tickets);
	
	// 返回json数据
	return tickets;
    }
    
    
}
