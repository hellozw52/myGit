package zw.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import zw.model.SsmBook;

/**
 * 继承父类  实现书籍的增删改查
 * @author zhaowei
 */
@Repository
public class BookDao extends BaseDao {
    
    /***********************基础 增删改 采用父类方法实现！**********************/
    
    /**
     * 获取当前页面数据
     * @param start
     * @param size
     * @return
     */
    public List<SsmBook> getCurrentPageDataList(int start, int size) {
	// TODO Auto-generated method stub
	List<SsmBook> list = super.list(SsmBook.class, start, size,null);
	return list;
    }
    
    /**
     * 总数
     * @return
     */
    public int getTotalNum() {
	// TODO Auto-generated method stub
	return super.count(SsmBook.class);
    }

    
    /**
     * 增加
     * @param book
     */
    public void add(SsmBook book) {
	// TODO Auto-generated method stub
	super.saveOrUpdate(book);
    }

    /**
     * 修改
     * @param book
     */
    public void update(SsmBook book) {
	// TODO Auto-generated method stub
	super.update(book);
    }

    /**
     * 删除
     * @param book
     */
    public void delete(SsmBook book) {
	// TODO Auto-generated method stub
	super.delete(book);
	
    }

    /**
     * 根据id查找
     * @param id
     * @return
     */
    public SsmBook getById(int id) {
	// TODO Auto-generated method stub
	return super.get(SsmBook.class, id);
    }
    
    
    /***********************基础 增删改 采用父类方法实现！**********************/
    
    
    
    
    
    
    /***********************多条件模糊查询  采用自己写的方法实现！**********************/
    

    /**
     * 多条件模糊查询  未用父类方法！
     * @param params
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SsmBook> search(Map<String, Object> params) {
	// TODO Auto-generated method stub
	
	//获取参数
	String id = (String) params.get("id");
	String isbn = (String) params.get("isbn");
	String title = (String) params.get("title");
	
	//转为int类型
	int start = (int) params.get("start");
	int size = (int) params.get("size");
		
	return (List<SsmBook>) super.getSession()
		.createQuery("from SsmBook s where s.id like '%"+id+"%' and s.isbn like '%"+isbn+"%' and s.title like '%"+title+"%'" )
		.setFirstResult(start * size)
		.setMaxResults(size)
		.list();
    }

    /**
     * 查询结果的个数  未用父类方法！
     * @param params
     * @return
     */
    public int getTotalNum(Map<String, Object> params) {
	// TODO Auto-generated method stub
	
	//获取参数
	String id = (String) params.get("id");
	String isbn = (String) params.get("isbn");
	String title = (String) params.get("title");
			
	return super.getSession()
		.createQuery("from SsmBook s where s.id like '%"+id+"%' and s.isbn like '%"+isbn+"%' and s.title like '%"+title+"%'" )
		.list()
		.size();
	
    }
    
    /***********************多条件模糊查询  采用自己写的方法实现！**********************/

}
