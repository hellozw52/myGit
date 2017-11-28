package service.impl;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import entity.Students;

import service.StudentsDAO;

public class TestStudentsDAOImpl {

    @Test
    public void testQueryAllStudents() {
	StudentsDAO sdao = new StudentsDAOImpl();
	List<Students> list = sdao.queryAllStudents();

	for (int i = 0; i < list.size(); i++) {
	    System.out.println(list.get(i).toString());
	}
    }

    @Test
    public void testGetNewSid() {
	StudentsDAOImpl sdao = new StudentsDAOImpl();
	System.out.println(sdao.getNewSid());
    }

    @Test
    public void testAddStudents() {
	Students s = new Students();
	s.setSname("张三丰");
	s.setGender("男");
	s.setBirthday(new Date());
	s.setAddress("武当山");

	StudentsDAOImpl sdao = new StudentsDAOImpl();
	Assert.assertEquals(true, sdao.addStudents(s));
    }

    // 批量添加学生数据
    @Test
    public void testAddManyStudents() {

	int num = 0;// 计数使用

	for (int i = 0; i < 1000; i++) {
	    Students s = new Students();
	    s.setSname("测试学生-No" + (i + 1));
	    s.setGender("男");
	    s.setBirthday(new Date());
	    s.setAddress("火星");

	    StudentsDAOImpl sdao = new StudentsDAOImpl();
	    // 添加学生
	    sdao.addStudents(s);
	    // 自增
	    num++;
	}
	System.out.println("添加完成！共添加 " + num + " 条学生记录！");
    }

    // 分页查询
    @Test
    public void testQueryPagerStudents() {
	StudentsDAOImpl sdao = new StudentsDAOImpl();
	// 查询前10条记录 page为第几页 pageSize为一页多少数据 (page-1)*pageSize,pageSize 即
	// (1-1)*10,10
	List<Students> list = sdao.queryPagerStudents(1, 10);
	for (int i = 0; i < list.size(); i++) {
	    // 打印前十条学生的学号
	    System.out.println(list.get(i).getSid());
	}
    }

    // 分页查询
    @Test
    public void testCountStudents() {
	StudentsDAOImpl sdao = new StudentsDAOImpl();
	int i = sdao.countStudents();
	System.out.println(i);
    }

}
