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

    public WiredVideo getVideoInfoById(int i) {
	// TODO Auto-generated method stub
	return (WiredVideo) this.getSession()
		.createQuery("from WiredVideo where videoId=?")
		.setParameter(0, i).uniqueResult();
    }

    public List<WiredVideo> getAllVideoInfo() {
	// TODO Auto-generated method stub
	return (List<WiredVideo>) this.getSession()
		.createQuery("from WiredVideo").list();
    }

    public int getTotalNum() {
	// TODO Auto-generated method stub
	return this.getSession().createQuery("from WiredVideo").list().size();
    }

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

}
