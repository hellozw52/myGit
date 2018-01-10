package zw.dao;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NavigatorDao {
    
    @Autowired
    public SessionFactory sessionFactory;
    
    /**
     * 获取当前会话
     * @return
     */
    private Session getSession() {
	return sessionFactory.getCurrentSession();
    }

    // 获取当前tvn号所属站点名称
    public String getCurrentTvnSiteName(String tvn) {
	
	String sitename = ((SQLQuery) getSession()
		.createSQLQuery(
			"SELECT p.PublishmentSystemName FROM siteserver_PublishmentSystem p WHERE p.EnterpriseUserCode = (SELECT e.EnterpriseUserCode FROM wired_EnterpriseUser e WHERE e.EnterpriseUserId = (SELECT w.EnterpriseUserId FROM wired_TVN w WHERE w.TVN = ?))")
		.setParameter(0, tvn)).addScalar("PublishmentSystemName", StringType.INSTANCE).uniqueResult().toString().trim();

	return sitename;
    }

    public boolean isTvnExist(String tvn) {
	
	// 最终结果  true or false
	boolean result;
	
	// 查询到的tvn个数
	int tvncount =  (Integer) getSession()
	.createSQLQuery(
		"SELECT COUNT(*) AS COUNT FROM wired_TVN w WHERE w.TVN = ?")
	.setParameter(0, tvn).uniqueResult();
	
	//存在1个tvn号
	if(tvncount==1){
	    result=true;
	}
	//不存在tvn号
	else{
	    result=false;
	}
	return result;
    }

}
