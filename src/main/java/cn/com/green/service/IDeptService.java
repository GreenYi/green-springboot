package cn.com.green.service;

import java.util.List;

import cn.com.green.bean.Dept;

public interface IDeptService {
	void addDept(Dept dept);
	List<Dept> getAll();
	void removeDept(Integer id);
}
