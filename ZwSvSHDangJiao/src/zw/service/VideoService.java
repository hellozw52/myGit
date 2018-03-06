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
     * 根据多个参数查询结果
     * @param videoId
     * @param assetId
     * @param assetName
     * @return List<WiredVideo>
     */
    public List<WiredVideo> getVideoInfoManyPara(int videoId,String assetId,String assetName) {
	// TODO Auto-generated method stub
	return videoDao.getVideoInfoManyPara(videoId,assetId,assetName);
    }
    
    /**
     * 根据两个参数查询结果
     * @param assetId
     * @param assetName
     * @return
     */
    public List<WiredVideo> getVideoInfoManyPara(String assetId,
	    String assetName) {
	// TODO Auto-generated method stub
	return videoDao.getVideoInfoManyPara(assetId,assetName);
    }

    /**
     * 获取所有视频信息
     * @return 
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

    public List<WiredVideo> getCurrentPageVideoList(String page, String rows) {
	// TODO Auto-generated method stub
	return videoDao.getCurrentPageVideoList(page,rows);
    }

}
