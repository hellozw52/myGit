package zw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.dao.BookDao;
import zw.model.SsmBook;

@Transactional
@Service
public class BookService {
    
    // 注入dao
    @Autowired
    public BookDao bookDao;
    
    /**
     * 获取当前页数据
     * @param page 用于分页
     * @param rows
     * @return
     */
    public List<SsmBook> getCurrentPageBookList(String page, String rows) {
	// TODO Auto-generated method stub
	return bookDao.getCurrentPageBookList(page,rows);
    }
    
    /**
     * 总数
     * @return int
     */
    public int getTotalNum() {
	// TODO Auto-generated method stub
	return bookDao.getTotalNum();
    }

    /**
     * 新增
     * @param book
     */
    public void add(SsmBook book) {
	// TODO Auto-generated method stub
	bookDao.add(book);
	
    }

    /**
     * 修改
     * @param book
     */
    public void update(SsmBook book) {
	// TODO Auto-generated method stub
	bookDao.update(book);
	
    }

    /**
     * 删除
     * @param book
     */
    public void delete(SsmBook book) {
	// TODO Auto-generated method stub
	bookDao.delete(book);
	
    }

    /**
     * 通过id获取条目
     * @param i
     * @return SsmBook
     */
    public SsmBook getById(int i) {
	return bookDao.getById(i);
    }

//    /**
//     * 根据三个参数查询结果（分页）其中page，rows用于分页
//     * @param videoId
//     * @param assetId
//     * @param assetName
//     * 
//     * @param page
//     * @param rows
//     * @return
//     */
//    public List<WiredVideo> getVideoInfoManyPara(int videoId,String assetId,String assetName,String page, String rows) {
//	// TODO Auto-generated method stub
//	return videoDao.getVideoInfoManyPara(videoId,assetId,assetName,page,rows);
//    }
//    
//    /**
//     * 根据两个参数查询结果（分页）其中page，rows用于分页
//     * @param assetId
//     * @param assetName
//     * 
//     * @param rows 
//     * @param page 
//     * @return
//     */
//    public List<WiredVideo> getVideoInfoManyPara(String assetId,String assetName, String page, String rows) {
//	// TODO Auto-generated method stub
//	return videoDao.getVideoInfoManyPara(assetId,assetName,page,rows);
//    }
//    
//    /**
//     * 根据两个参数查询的结果总数
//     * @param assetId
//     * @param assetName
//     * @return
//     */
//    public int getVideoInfoManyParaTotalNum(String assetId, String assetName) {
//	// TODO Auto-generated method stub
//	return videoDao.getVideoInfoManyParaTotalNum(assetId, assetName);
//    }
//
//    /**
//     * 根据三个参数查询的结果总数
//     * @param videoId
//     * @param assetId
//     * @param assetName
//     * @return
//     */
//    public int getVideoInfoManyParaTotalNum(int videoId, String assetId,String assetName) {
//	// TODO Auto-generated method stub
//	return videoDao.getVideoInfoManyParaTotalNum(videoId, assetId, assetName);
//    }
//
//    /**
//     * 获取所有视频信息
//     * @return 
//     */
//    public List<WiredVideo> getAllVideoInfo() {
//	// TODO Auto-generated method stub
//	return videoDao.getAllVideoInfo();
//    }

}
