package zw.model;

/**
 * Vote 数据表 抽象为类
 * @author zhaowei
 */
public class Vote
{
	private String tvn;// tvn号
	private String voteid;// 投票队伍id
	private String votetime;// 投票时间
	private String address;// 用户地址

	public String getTvn()
	{
		return tvn;
	}

	public void setTvn(String tvn)
	{
		this.tvn = tvn;
	}

	public String getVoteid()
	{
		return voteid;
	}

	public void setVoteid(String voteid)
	{
		this.voteid = voteid;
	}

	public String getVotetime()
	{
		return votetime;
	}

	public void setVotetime(String votetime)
	{
		this.votetime = votetime;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * @param tvn 用户tvn号
	 * @param voteid 投票队伍id
	 * @param votetime 投票时间
	 * @param address  用户地址
	 */
	public Vote(String tvn, String voteid, String votetime, String address)
	{
		this.tvn = tvn;
		this.voteid = voteid;
		this.votetime = votetime;
		this.address = address;
	}

	public Vote()
	{
		// TODO Auto-generated constructor stub
	}


}
