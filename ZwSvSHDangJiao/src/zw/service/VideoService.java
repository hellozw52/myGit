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

    /**
     * 根据id查询视频信息
     * @param i
     * @return WiredVideo
     */
    public WiredVideo getVideoInfoById(int i) {
	// TODO Auto-generated method stub
	return videoDao.getVideoInfoById(i);
    }

    /**
     * 获取所有视频信息
     * @return List<WiredVideo>
     */
    public List<WiredVideo> getAllVideoInfo() {
	// TODO Auto-generated method stub
	return videoDao.getAllVideoInfo();
    }

    /**
     * 获取总数
     * @return int
     */
    public int getTotalNum() {
	// TODO Auto-generated method stub
	return videoDao.getTotalNum();
    }

}
