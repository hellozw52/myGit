package com.ssh.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("siteDao")
@Transactional
public class SiteDao {

    // 注入sessionFactory
    @Resource
    private SessionFactory sessionFactory;

    // 获取当前tvn号所属站点名称
    public String getCurrentTvnSiteName(String tvn) {
	// TODO Auto-generated method stub

	String sitename = ((SQLQuery) this.sessionFactory
		.getCurrentSession()
		.createSQLQuery(
			"SELECT p.PublishmentSystemName FROM siteserver_PublishmentSystem p WHERE p.EnterpriseUserCode = (SELECT e.EnterpriseUserCode FROM wired_EnterpriseUser e WHERE e.EnterpriseUserId = (SELECT w.EnterpriseUserId FROM wired_TVN w WHERE w.TVN = ?))")
		.setParameter(0, tvn)).addScalar("PublishmentSystemName", Hibernate.STRING).uniqueResult().toString();

	return sitename;
    }

    public boolean isTvnExist(String tvn) {
	// TODO Auto-generated method stub
	// 查询到的tvn个数
	int tvncount =  (Integer) this.sessionFactory
	.getCurrentSession()
	.createSQLQuery(
		"SELECT COUNT(*) FROM wired_TVN w WHERE w.TVN = ?")
	.setParameter(0, tvn).uniqueResult();
	
	//存在1个tvn号
	if(tvncount==1){
	    return true;
	}
	//不存在tvn号
	else{
	    return false;
	}
    }

}
