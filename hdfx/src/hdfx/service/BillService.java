package hdfx.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hdfx.dao.BillDao;
import hdfx.entity.Bill;

@Transactional
@Service
public class BillService {
    
    // 注入dao
    @Autowired
    public BillDao billDao;

	public List<Bill> getCurrentPageDataList(int start, int size) {
		// TODO Auto-generated method stub
		return billDao.getCurrentPageDataList(start,size);
	}

	public int getTotalNum() {
		// TODO Auto-generated method stub
		return billDao.getTotalNum();
	}



}
