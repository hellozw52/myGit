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

//    /**
//     * 根据三个参数查询结果（分页）其中page，rows用于分页
//     * @param id
//     * @param isbn
//     * @param title
//     * 
//     * @param page
//     * @param rows
//     * @return
//     */
//    public List<SsmBook> getBookInfoManyPara(int id,String isbn,String title,String page, String rows) {
//	// TODO Auto-generated method stub
//	return bookDao.getBookInfoManyPara(id,isbn,title,page,rows);
//    }
//    
//    /**
//     * 根据两个参数查询结果（分页）其中page，rows用于分页
//     * @param isbn
//     * @param title
//     * 
//     * @param rows 
//     * @param page 
//     * @return
//     */
//    public List<SsmBook> getBookInfoManyPara(String isbn,String title,String page, String rows) {
//	// TODO Auto-generated method stub
//	return bookDao.getBookInfoManyPara(isbn,title,page,rows);
//    }
//
//    /**
//     * 根据三个参数查询的结果总数
//     * @param id
//     * @param isbn
//     * @param title
//     * @return
//     */
//    public int getBookInfoManyParaTotalNum(int id,String isbn,String title) {
//	// TODO Auto-generated method stub
//	return bookDao.getBookInfoManyParaTotalNum(id, isbn, title);
//    }
//    
//    /**
//     * 根据两个参数查询的结果总数
//     * @param isbn
//     * @param title
//     * @return
//     */
//    public int getBookInfoManyParaTotalNum(String isbn,String title) {
//	// TODO Auto-generated method stub
//	return bookDao.getBookInfoManyParaTotalNum(isbn, title);
//    }

}
