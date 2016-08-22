package com.mao.hand.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mao.hand.Beans.Customer;
import com.mao.hand.ServiceImpl.CustomerServiceImpl;


@Controller
public class LoginController  {
	 private static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	@RequestMapping("/Login")
	public String Login(String name,HttpSession model){
		CustomerServiceImpl customerServiceImpl = (CustomerServiceImpl) context.getBean("customerService");
		List<Customer> list = customerServiceImpl.SelectCustomer();
		boolean flag= false;
		model.setAttribute("list", list);
		for(Customer cs : list){
			if(cs.getFirst_name().equals(name)){
				model.setAttribute("name", name);
				flag=true;			
			}
		}
		if(flag){

		
		   return  "forward:index.jsp";	
		}else{

			return "forward:Login.jsp";		
			
		}		
	}
}
