package cn.com.green.dept.service;

import java.util.List;

import cn.com.green.dept.bean.Dept;


public interface IDeptService {
	void addDept(Dept dept);
	List<Dept> getAll();
	void removeDept(Integer id);
}
