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
     * 根据三个参数查询结果（分页）其中page，rows用于分页
     * @param videoId
     * @param assetId
     * @param assetName
     * 
     * @param page
     * @param rows
     * @return
     */
    public List<WiredVideo> getVideoInfoManyPara(int videoId,String assetId,String assetName,String page, String rows) {
	// TODO Auto-generated method stub
	return videoDao.getVideoInfoManyPara(videoId,assetId,assetName,page,rows);
    }
    
    /**
     * 根据两个参数查询结果（分页）其中page，rows用于分页
     * @param assetId
     * @param assetName
     * 
     * @param rows 
     * @param page 
     * @return
     */
    public List<WiredVideo> getVideoInfoManyPara(String assetId,String assetName, String page, String rows) {
	// TODO Auto-generated method stub
	return videoDao.getVideoInfoManyPara(assetId,assetName,page,rows);
    }
    
    /**
     * 根据两个参数查询的结果总数
     * @param assetId
     * @param assetName
     * @return
     */
    public int getVideoInfoManyParaTotalNum(String assetId, String assetName) {
	// TODO Auto-generated method stub
	return videoDao.getVideoInfoManyParaTotalNum(assetId, assetName);
    }

    /**
     * 根据三个参数查询的结果总数
     * @param videoId
     * @param assetId
     * @param assetName
     * @return
     */
    public int getVideoInfoManyParaTotalNum(int videoId, String assetId,String assetName) {
	// TODO Auto-generated method stub
	return videoDao.getVideoInfoManyParaTotalNum(videoId, assetId, assetName);
    }
    
    /**
     * 获取当前页面的视频信息，page,rows参数用于分页
     * @param page
     * @param rows
     * @return
     */
    public List<WiredVideo> getCurrentPageVideoList(String page, String rows) {
	// TODO Auto-generated method stub
	return videoDao.getCurrentPageVideoList(page,rows);
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
     * 获取所有视频总个数
     * @return int
     */
    public int getTotalNum() {
	// TODO Auto-generated method stub
	return videoDao.getTotalNum();
    }
}
