package com.mao.hand.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mao.hand.Beans.Customer;
import com.mao.hand.ServiceImpl.CustomerServiceImpl;

@Controller
public class ShowCustomerController {
	 private static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	
	 @RequestMapping("/customer")
	@ResponseBody
	public List<Customer> getCustomer(){
		CustomerServiceImpl customerServiceImpl= (CustomerServiceImpl) context.getBean("customerService");
		List<Customer> list= customerServiceImpl.SelectCustomer();
		return list;
	}
}
