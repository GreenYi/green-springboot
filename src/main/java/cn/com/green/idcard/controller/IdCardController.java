package cn.com.green.idcard.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.green.idcard.bean.IdCard;
import cn.com.green.idcard.service.IdCardService;

@Controller
@RequestMapping("/idCard")
public class IdCardController {
	@Resource
	private IdCardService idCardService;
	
	//查询完成页面
	@RequestMapping("/getIdCardInfo")
	public ModelAndView getIdCardInfo(HttpServletRequest req, ModelAndView mv) {
		String cardno = req.getParameter("cardno");
		String name = req.getParameter("name");
		IdCard idCard = idCardService.getIdCardInfo(cardno, name);
		if (idCard != null) {
			mv.addObject("idCard", idCard);
			mv.addObject("message","查询成功！");
			mv.setViewName("/idCard/getIdCardInfo");
		} else {//没有权限或者出错
			mv.addObject("message","查询错误！查询次数已用完或者服务器异常，请联系开发者：green.gm.yi@foxmail.com");
			mv.setViewName("/idCard/getIdCardInfo");
		}
		return mv;
	}
	
	//显示页面
	@RequestMapping("/show")
	public ModelAndView show(HttpServletRequest req, ModelAndView mv) {
		mv.setViewName("/idCard/getIdCardInfo");
		return mv;
	}
}
