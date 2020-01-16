package cn.com.green.dao;

import java.util.List;

import cn.com.green.bean.Dept;

public interface DeptDao {
	void insertDept(Dept dept);
	List<Dept> selectAll();
	void deleteById(Integer id);
}
