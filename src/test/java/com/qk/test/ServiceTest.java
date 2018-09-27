package com.qk.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qk.service.PropService;

@RunWith(SpringJUnit4ClassRunner.class)//告诉测试框架:使用spring运行环境进行测试
@ContextConfiguration("classpath:spring.xml")//用那个IOC容器
public class ServiceTest {
	//随意使用IOC容器
	@Autowired
	private PropService ps;
		
	@Test
	public void getAllPropByJsonTest() {
		System.out.println(ps.getAllPropByJson());
	}
	
	@Test
	@Transactional
	@Rollback
	public void removePropByCheckedAjaxTest() {
		String[] ids= {"016fffbe-99fe-435e-bd23-bb734f7fe700","25664f2b-f88d-48e7-8fdd-1cef4be0d4e5"};
		System.out.println(ps.removePropByCheckedAjax(ids));
	}

}
