package hdfx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import hdfx.entity.Bill;

/**
 * 继承父类，实现增删改查等常用操作
 * 
 * @author zhaowei
 */
@Repository
public class BillDao extends BaseDao {

	/**
	 * 获取当前页面数据
	 * 
	 * @param start
	 * @param size
	 * @return
	 */
	public List<Bill> getCurrentPageDataList(int start, int size) {
		// TODO Auto-generated method stub
		List<Bill> list = super.list(Bill.class, start, size, null);
		return list;
	}

	/**
	 * 总数
	 * 
	 * @return
	 */
	public int getTotalNum() {
		// TODO Auto-generated method stub
		return super.count(Bill.class);
	}

}
