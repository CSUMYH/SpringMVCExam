package com.mao.hand.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mao.hand.Beans.Customer;
import com.mao.hand.ServiceImpl.CustomerServiceImpl;

@Controller
public class DeleteCustomerController {
	 private static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	@RequestMapping("/delete")
	@ResponseBody
	public String DeleteCustomer(int customer_id){
		CustomerServiceImpl customerServiceImpl= (CustomerServiceImpl) context.getBean("customerService");
		Customer customer= (Customer) context.getBean("Customer");
		customer.setCustomer_id(customer_id);
		customerServiceImpl.DeleteCustomer(customer);
		return "forward:index.jsp";
	}
}
