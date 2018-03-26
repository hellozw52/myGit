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
     * 通过id获取条目
     * @param i
     * @return SsmBook
     */
    public SsmBook getById(int i) {
	return bookDao.getById(i);
    }
}
