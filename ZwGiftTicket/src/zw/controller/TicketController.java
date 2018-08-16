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
     * 接口测试：http://172.30.37.13:7001/ZwGiftTicket/ticket/query_ticket?tvn=12345678&entity_type=院线-观影券
     * @param tvn 机顶盒tvn号
     * @param entity_type 奖品类型
     * @return List<Map<String, Object>>
     */
    @ResponseBody
    @RequestMapping("/query_ticket")
    public List<Map<String, Object>> query(
	    @RequestParam("tvn") String tvn, 
	    @RequestParam("entity_type") String entity_type) {
	
	List<Map<String, Object>> tickets = ticketService.queryTicket(tvn,entity_type);
	
	// 返回json数据
	return tickets;
    }
    
    
}
