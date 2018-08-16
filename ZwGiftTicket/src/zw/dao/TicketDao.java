package zw.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 * 继承父类  实现书籍的增删改查
 * @author zhaowei
 */
@Repository
public class TicketDao extends BaseDao {
    
    /**
     * 对视图进行查询   注意是视图，不是表！
     * @param tvn
     * @param entity_type
     * @return 返回观影券数组
     */
    public List<Map<String, Object>> queryTicket(String tvn, String entity_type) {
	// TODO Auto-generated method stub
	@SuppressWarnings("unchecked")
	List<Map<String, Object>> ticket = (List<Map<String, Object>>) super.sessionFactory
		.getCurrentSession()
		.createSQLQuery(
			" SELECT * FROM gift_ticket_entity g WHERE g.get_tvn='" + tvn + "' AND g.entity_type= '" + entity_type + "'" )
		.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP)
		.list();
		
	return ticket;
    } 
}
