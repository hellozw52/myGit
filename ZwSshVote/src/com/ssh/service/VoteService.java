package com.ssh.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssh.dao.VoteDao;

@Service
public class VoteService {
    
    //注入dao
    @Resource
    private VoteDao voteDao;

    /**
     * 判断今天是否已经投票
     * @param tvn 待投票盒子tvn号
     * @param today 今天日期
     * @return true 已经投票  false 没有投票
     */
    public boolean isVotedToday(String tvn,String today) {
	// TODO Auto-generated method stub
	if(voteDao.isVotedToday(tvn,today)){
	    //已经投票
	    return true;
	}else{
	    //没有投票
	    return false;
	}
    }

    /**
     * 开始投票
     * @param tvn 投票盒子tvn号
     * @param voteid 投票支持队伍   1.红队 2.蓝队
     * @param votedate 投票时间
     * @param votespace 投票地点
     * @return true 投票成功   false 投票失败
     */
    public boolean beginVote(String tvn, String voteid, String votedate,
	    String votespace) {
		
	// TODO Auto-generated method stub
	if(voteDao.beginVote(tvn,voteid,votedate,votespace)){
	    // 投票成功，即插入数据成功
	    return true;
	}else{
	    // 投票失败
	    return false;
	}
	
    }

}
