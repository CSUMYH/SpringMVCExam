package com.mao.hand.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mao.hand.Beans.Address;
import com.mao.hand.ServiceImpl.AddressServiceImpl;

@Controller
public class ShowAddressController {
	 private static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	
	@RequestMapping("/address")
	@ResponseBody
	public List<Address> showAddress(){
		AddressServiceImpl addressServiceImpl = (AddressServiceImpl) context.getBean("addressService");
		List<Address> list = addressServiceImpl.getAllAddress();
		return list;
	}
}
