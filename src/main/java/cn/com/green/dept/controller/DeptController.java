package cn.com.green.dept.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.green.dept.bean.Dept;
import cn.com.green.dept.service.IDeptService;


@Controller
@RequestMapping("/dept")
public class DeptController {
	@Resource
	private IDeptService deptService;
	//显示addDept页面
	@RequestMapping("/showAddDept")
	public String showAddDept() {
		return "/dept/addDept";
	}
	//添加部门信息
	@RequestMapping("/addDept")
	public String addDept(String deptName,String deptLoc) {
		//调用业务层方法
		Dept dept = new Dept();
		dept.setDeptName(deptName);
		dept.setDeptLoc(deptLoc);
		deptService.addDept(dept);
		return "/dept/index";
	}
	@RequestMapping("/getAllDept")
	public String getAllDept(ModelMap map) {
		//1.调用业务层的方法，返回list
		List<Dept> list = deptService.getAll();
		//2.把list添加到map中
		map.addAttribute("list",list);
		//3.return 
		return "/dept/showAll";
	}
	//删除部门信息
	@RequestMapping("/removeDept")
	public String removeDept(Integer id) {
		//1.调用业务层的删除的方法
		deptService.removeDept(id);
		//2.设置重定向
		return "redirect:getAllDept.htm";
	}
	
}
