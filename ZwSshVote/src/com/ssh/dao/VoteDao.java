package com.ssh.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.model.Vote;

@Repository
@Transactional
public class VoteDao {

    // 注入sessionFactory
    @Resource
    private SessionFactory sessionFactory;
    // 获取投票记录
    private Vote vote;

    /**
     * 今天是否已投票
     * 
     * @param tvn
     *            待投票盒子tvn号
     * @param today
     *            今天的日期
     * @return true 已经投票 false 没有投票
     */
    public boolean isVotedToday(String tvn, String today) {
	// TODO Auto-generated method stub

	// 查询是否存在投票记录
	vote = (Vote) sessionFactory
		.getCurrentSession()
		.createQuery(
			"FROM Vote v WHERE v.tvn =:tvn AND SUBSTR(votetime,1,10)=:votetime ")
		.setParameter("tvn", tvn).setParameter("votetime", today)
		.uniqueResult();
	// 存在记录，当天已投票
	if (vote != null) {
	    return true;
	} else {
	    // 当天未投票
	    return false;
	}
    }

    /**
     * 投票即插入一条投票记录
     * 
     * @param tvn
     *            投票盒子tvn号
     * @param voteid
     *            支持队伍编号
     * @param votedate
     *            投票时间
     * @param votespace
     *            投票地点
     * @return true 投票成功 false 投票失败
     */
    public boolean beginVote(String tvn, String voteid, String votedate,
	    String votespace) {
	// TODO Auto-generated method stub
	if (tvn != null && voteid != null && votedate != null
		&& votespace != null && !"".equals(tvn) && !"".equals(voteid)
		&& !"".equals(votedate) && !"".equals(votespace)) {

	    // 实例化要插入的vote
	    vote = new Vote();
	    vote.setTvn(tvn);
	    vote.setVoteid(voteid);
	    vote.setVotetime(votedate);
	    vote.setAddress(votespace);
	    // 插入数据
	    sessionFactory.getCurrentSession().save(vote);
	    
	    return true;
	    
	} else {
	    //参数异常，插入失败
	    return false;
	}

    }

}
