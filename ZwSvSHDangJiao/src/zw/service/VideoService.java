package zw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





import zw.dao.VideoDao;
import zw.model.WiredVideo;

@Transactional
@Service
public class VideoService {
    
    @Autowired
    public VideoDao videoDao;

    public WiredVideo getVideoInfoById(int i) {
	// TODO Auto-generated method stub
	return videoDao.getVideoInfoById(i);
    }

    public List<WiredVideo> getAllVideoInfo() {
	// TODO Auto-generated method stub
	return videoDao.getAllVideoInfo();
    }

    public int getTotalNum() {
	// TODO Auto-generated method stub
	return videoDao.getTotalNum();
    }

}
