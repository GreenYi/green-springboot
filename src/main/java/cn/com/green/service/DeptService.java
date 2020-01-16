package cn.com.green.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.green.bean.Dept;
import cn.com.green.dao.DeptDao;

@Service
public class DeptService implements IDeptService{
	@Resource
	private DeptDao deptDao;
	public void addDept(Dept dept) {
		deptDao.insertDept(dept);
	}
	public List<Dept> getAll() {
		//调用持久层的方法，返回list
		return deptDao.selectAll();
	}
	public void removeDept(Integer id) {
		//调用持久层方法
		deptDao.deleteById(id);
	}
}
