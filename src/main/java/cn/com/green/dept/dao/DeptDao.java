package cn.com.green.dept.dao;

import java.util.List;

import cn.com.green.dept.bean.Dept;


public interface DeptDao {
	void insertDept(Dept dept);
	List<Dept> selectAll();
	void deleteById(Integer id);
}
