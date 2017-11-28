package service;

import java.util.List;

import entity.Students;

public interface StudentsDAO {
	
	/**
	 * 分页查询学生
	 * @param page 第几页
	 * @param pageSize 每页个数
	 * @return
	 */
	public List<Students> queryPagerStudents(int page,int pageSize);
	
	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Students> queryAllStudents();
	
	/**
	 * 根据sid查询学生
	 * @param sid 学号
	 * @return
	 */
	public Students queryStudentsBySid(String sid);
	
	/**
	 * 学生总数
	 * @return
	 */
	public int countStudents();
	
	/**
	 * 新增学生
	 * @param s 学生
	 * @return
	 */
	public boolean addStudents(Students s);
	
	/**
	 * 修改学生信息
	 * @param s 学生
	 * @return
	 */
	public boolean updateStudents(Students s);
	
	/**
	 * 根据sid删除学生
	 * @param sid 学号
	 * @return
	 */
	public boolean deleteStudents(String sid);
}
