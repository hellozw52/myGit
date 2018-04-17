package zw.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zw.dao.BookDao;
import zw.model.SsmBook;

@Transactional
@Service
public class BookService {
    
    // 注入bookDao
    @Autowired
    public BookDao bookDao;
    
    /**
     * 通过id获取条目
     * @param id
     * @return SsmBook
     */
    public SsmBook getById(int id) {
	return bookDao.getById(id);
    }
    
    /**
     * 获取当前页数据
     * @param start
     * @param size
     * @return
     */
    public List<SsmBook> getCurrentPageDataList(int start, int size) {
	// TODO Auto-generated method stub
	return bookDao.getCurrentPageDataList(start,size);
    }

    /**
     * 增加
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
     * 获取总数
     * @return int
     */
    public int getTotalNum() {
	// TODO Auto-generated method stub
	return bookDao.getTotalNum();
    }

    /**
     * 多条件模糊查询
     * @param params 查询条件
     * @return
     */
    public List<SsmBook> search(Map<String, Object> params) {
	// TODO Auto-generated method stub
	return bookDao.search(params);
    }
    
    /**
     * 获取查询结果个数
     * @param params
     * @return
     */
    public int getTotalNum(Map<String, Object> params) {
	// TODO Auto-generated method stub
	return bookDao.getTotalNum(params);
    }
}
