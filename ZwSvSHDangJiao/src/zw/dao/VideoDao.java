package zw.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zw.model.WiredVideo;

@Repository
public class VideoDao {

    @Autowired
    public SessionFactory sessionFactory;

    private Session getSession() {
	return sessionFactory.getCurrentSession();
    }

    /**
     * 根据id进行模糊查询！
     * @param id
     * @return
     */
    public List<WiredVideo> getVideoInfoById(int id) {
	// TODO Auto-generated method stub
	return (List<WiredVideo>) this.getSession()
		.createQuery("from WiredVideo w where w.videoId like '%"+id+"%'")
		.list();
    }
    
    /**
     * 根据五个参数进行模糊查询！其中page、rows参数用于分页
     *   SELECT * FROM wired_Video w WHERE w.VideoId like '%123%' AND w.AssetId LIKE '%VODC%' AND w.AssetName LIKE '%国%' 
     * @param videoId
     * @param assetId
     * @param assetName
     * @param rows 
     * @param page 
     * @return
     */
    public List<WiredVideo> getVideoInfoManyPara(int videoId,String assetId,String assetName, String page, String rows) {
	// TODO Auto-generated method stub
	
	// 当为缺省值的时候进行赋值
	int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
				: page);// 第几页
	int pagesize = Integer.parseInt((rows == null || rows == "0") ? "15"
				: rows);// 每页多少行
	
	return (List<WiredVideo>) this.getSession()
		.createQuery("from WiredVideo w where w.videoId like '%"+videoId+"%' and w.assetId like '%"+assetId+"%' and w.assetName like '%"+assetName+"%'" )
		.setFirstResult((currentpage - 1) * pagesize)
		.setMaxResults(pagesize)
		.list();
    }
    
    /**
     * 根据两个参数进行查询
     * SELECT * FROM wired_Video w WHERE w.AssetId LIKE '%VODC%' AND w.AssetName LIKE '%国%'
     * @param assetId
     * @param assetName
     * @param rows 
     * @param page 
     * @return
     */
    public List<WiredVideo> getVideoInfoManyPara(String assetId,String assetName, String page, String rows) {
	// TODO Auto-generated method stub
	
	// 当为缺省值的时候进行赋值
	int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
			: page);// 第几页
	int pagesize = Integer.parseInt((rows == null || rows == "0") ? "15"
			: rows);// 每页多少行
	
	return (List<WiredVideo>) this.getSession()
		.createQuery("from WiredVideo w where w.assetId like '%"+assetId+"%' and w.assetName like '%"+assetName+"%'" )
		.setFirstResult((currentpage - 1) * pagesize)
		.setMaxResults(pagesize)
		.list();
    }
    
    /**
     * 查询结果总数
     * @param videoId
     * @param assetId
     * @param assetName
     * @return
     */
    public int getVideoInfoManyParaTotalNum(int videoId,String assetId,String assetName) {
	// TODO Auto-generated method stub
	return this.getSession()
		.createQuery("from WiredVideo w where w.videoId like '%"+videoId+"%' and w.assetId like '%"+assetId+"%' and w.assetName like '%"+assetName+"%'" )
		.list().size();
    }
    
    /**
     * 查询结果总数
     * @param assetId
     * @param assetName
     * @return
     */
    public int getVideoInfoManyParaTotalNum(String assetId,String assetName) {
	// TODO Auto-generated method stub
	return this.getSession()
		.createQuery("from WiredVideo w where w.assetId like '%"+assetId+"%' and w.assetName like '%"+assetName+"%'" )
		.list().size();
    }
    
    

    /**
     * 获取所有视频信息
     * @return
     */
    public List<WiredVideo> getAllVideoInfo() {
	// TODO Auto-generated method stub
	return (List<WiredVideo>) this.getSession()
		.createQuery("from WiredVideo").list();
    }
    
    

    /**
     * 获取当前页面数据
     * @param page
     * @param rows
     * @return
     */
    public List<WiredVideo> getCurrentPageVideoList(String page, String rows) {
	// TODO Auto-generated method stub
	// 当为缺省值的时候进行赋值
	int currentpage = Integer.parseInt((page == null || page == "0") ? "1"
		: page);// 第几页
	int pagesize = Integer.parseInt((rows == null || rows == "0") ? "15"
		: rows);// 每页多少行

	List<WiredVideo> list = this.getSession()
		.createQuery("from WiredVideo")
		.setFirstResult((currentpage - 1) * pagesize)
		.setMaxResults(pagesize).list();

	return list;
    }
    
    /**
     * 获取表中视频总数
     * @return
     */
    public int getTotalNum() {
	// TODO Auto-generated method stub
	return this.getSession().createQuery("from WiredVideo").list().size();
    }
}
