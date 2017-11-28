package com.ssh.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.ssh.model.Vote;
import com.ssh.until.StringUtil;

@Scope("prototype")
@Controller("voteAciton")
public class VoteAciton extends BaseAction<Vote> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    // 投票结果标识： true为投票成功 false为投票失败 初始化为false
    boolean voteflag = false;
    // 设置日期格式
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 投票方法
     * 
     * @param tvn
     *            待投票tvn号
     * @param voteid
     *            投票队号 1红队 2蓝队
     * @throws IOException
     */
    public void beginVote() throws IOException {
	
	// model获取传递的参数
	model.setTvn(request.getParameter("tvn"));
	model.setVoteid(request.getParameter("voteid"));
	
	String tvn = model.getTvn();
	String voteid = model.getVoteid();

	// 如果参数不为空
	if (tvn != null && voteid != null && !"".equals(tvn)
		&& !"".equals(voteid)) {
	    // 获取今天的时间
	    String today = df.format(new Date());
	    
	    // 判断今天是否已投票 已投票返回true;反之返回false;
	    if (voteService.isVotedToday(tvn,today)) {
		// 已经投票 投票失败 给前端显示结果 {"vote":"false"}
		result = "{\"vote\":\"false\"}";
		StringUtil.writeToWeb(result, "html",
			ServletActionContext.getResponse());
	    } else {// 没有投票 开始投票！

		// 投票日期 投票地点
		String votedate = df.format(new Date());
		String votespace = "default space";
		// 开始投票 voteflag = true 成功 false 失败
		voteflag = voteService.beginVote(tvn, voteid, votedate,
			votespace);
		if (voteflag) {
		    // 投票成功  给前端显示结果 {"vote":"success"}
		    result = "{\"vote\":\"success\"}";
		    StringUtil.writeToWeb(result, "html",
			    ServletActionContext.getResponse());
		} else {
		    // 投票失败  给前端显示结果 {"vote":"false"}
		    result = "{\"vote\":\"false\"}";
		    StringUtil.writeToWeb(result, "html",
			    ServletActionContext.getResponse());
		}

	    }

	} else {
	    // 传参异常 返回 {"param":"error"};
	    result = "{\"param\":\"error\"}";
	    StringUtil.writeToWeb(result, "html",
		    ServletActionContext.getResponse());
	}
    }
}
