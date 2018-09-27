package com.qk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qk.service.PropService;

@Controller
public class IndexController {
	@Autowired
	private PropService ps;
	private static final String AJAXCHARSET="text/html;charset=UTF-8";
	
	@RequestMapping("/insertProp.do")
	public String insertProp(HttpServletRequest req,String propsName,String propsRole,String propsLevel,String propsDescribe) {
		req.setAttribute("result", ps.insertProp(propsName, propsRole, propsLevel, propsDescribe));
		return "/showProps.do";
	}

	@RequestMapping(value="/insertProp.ajax", produces=AJAXCHARSET)
	@ResponseBody
	public String insertPropByAjax(String propsName,String propsRole,String propsLevel,String propsDescribe) {
		return ps.insertProp(propsName, propsRole, propsLevel, propsDescribe);
	}
	
	@RequestMapping("/showProps.do")
	public String showProps(HttpServletRequest req) {
		req.setAttribute("PropList", ps.selectAllProps());
		return "/index.jsp";
		
	}
	
	@RequestMapping(value="/showPropsByAjax.ajax", produces=AJAXCHARSET)
	@ResponseBody
	public String showPropsByAjax() {
		
		return ps.getAllPropByJson();
	}
	
	@RequestMapping("/removeProp.do")
	public String removeProp(HttpServletRequest req, String propsId) {
		req.setAttribute("result", ps.removeProp(propsId));
		return "/showProps.do";
	}
	
	@RequestMapping(value="/removePropByAjax.ajax", produces=AJAXCHARSET)
	@ResponseBody
	public String removePropByAjax(String propsId) {
		return ps.removeProp(propsId);
	}
	
	@RequestMapping(value="/removePropByCheckedAjax.ajax", produces=AJAXCHARSET)
	@ResponseBody
	public String removePropByCheckedAjax(@RequestParam(value="idArry[]") String[] ids) {
		
		return ps.removePropByCheckedAjax(ids);
	}
}
