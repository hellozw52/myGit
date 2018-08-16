package zw.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.dao.TicketDao;

@Transactional
@Service
public class TicketService {
    
    // 注入bookDao
    @Autowired
    public TicketDao giftTicketDao;
    
    /**
     * @param tvn 机顶盒tvn号
     * @param entity_type 奖品类型
     * @return
     */
    public List<Map<String, Object>> queryTicket(String tvn, String entity_type) {
	// TODO Auto-generated method stub
	return giftTicketDao.queryTicket(tvn,entity_type);
    }

}
