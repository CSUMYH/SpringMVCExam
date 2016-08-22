package com.mao.hand.Controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mao.hand.Beans.Address;
import com.mao.hand.Beans.Customer;
import com.mao.hand.ServiceImpl.AddressServiceImpl;
import com.mao.hand.ServiceImpl.CustomerServiceImpl;

@Controller
public class AddCostomerController {
	 private static ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	
	@RequestMapping("/add")
	public String SaveCostomer(String last_name,String first_name,String email,Address address){
		CustomerServiceImpl customerServiceImpl= (CustomerServiceImpl) context.getBean("customerService");
		AddressServiceImpl addressServiceImpl = (AddressServiceImpl) context.getBean("addressService");
//		active,last_update,store_id,first_name,last_name,email,address_id,create_date
		//firstname ,lastname,email,adrees
		List<Address> listaddress =  addressServiceImpl.getAllAddress();
		int address_id=0;
		System.out.println(address.getAddress());
		for(int i =0 ;i<listaddress.size();i++){
			if(address.getAddress().equals(listaddress.get(i).getAddress().split(" ")[0])){
				address_id=listaddress.get(i).getAddress_id();
			}
		}
		System.out.println(address_id);
		Customer cus = new Customer();
		Date update = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String date = dateFormat.format( update ); 
    	Timestamp ts = Timestamp.valueOf(date); 
    	cus.setLast_update(ts);
    	cus.setCreate_date(ts);
    	cus.setActive(1);
    	cus.setStore_id(1);
    	cus.setAddress_id(address_id);
    	cus.setFirst_name(first_name);
    	cus.setLast_name(last_name);
    	cus.setEmail(email);
    	customerServiceImpl.SaveCustomer(cus);
		return "forward:index.jsp";
	}
}
