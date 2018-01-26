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
	return (WiredVideo) this.getSession().createQuery("from WiredVideo where videoId=?").setParameter(0, i).uniqueResult();
    }

    public List<WiredVideo> getAllVideoInfo() {
	// TODO Auto-generated method stub
	return (List<WiredVideo>)this.getSession().createQuery("from WiredVideo").list();
    }

    public int getTotalNum() {
	// TODO Auto-generated method stub
	return this.getSession().createQuery("from WiredVideo").list().size();
    }

}
