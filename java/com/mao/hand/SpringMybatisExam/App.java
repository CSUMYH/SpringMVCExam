package com.mao.hand.SpringMybatisExam;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mao.hand.Beans.Address;
import com.mao.hand.Beans.Customer;
import com.mao.hand.Service.AddressService;
import com.mao.hand.ServiceImpl.AddressServiceImpl;
import com.mao.hand.ServiceImpl.CustomerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext context;
    	
	public static void main( String[] args )
    {
    	context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    	Scanner input = new Scanner(System.in);
    	System.out.println("请输入：  first_name :");
    	String first_name = input.next();
    	System.out.println("请输入：  last_name :");
    	String last_name = input.next();
    	System.out.println("请输入：  email :");
    	String email = input.next();   	
    	AddressServiceImpl addressServiceImp = (AddressServiceImpl) context.getBean("addrsessService");
    	int address_id = sel(input,addressServiceImp);
    	Date update = new Date();
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String date = dateFormat.format( update ); 
    	Timestamp ts = Timestamp.valueOf(date);   
    	Customer customer = (Customer) context.getBean("Customer");
    	customer.setAddress_id(address_id);
    	customer.setEmail(email);
    	customer.setFirst_name(first_name);
    	customer.setLast_name(last_name);
    	customer.setActive(1);
    	customer.setLast_update(ts);
    	customer.setCreate_date(ts);
    	customer.setStore_id(1);
    	CustomerServiceImpl customerServiceImpl = (CustomerServiceImpl) context.getBean("customerService");
    	customerServiceImpl.SaveCustomer(customer);
    	customerServiceImpl.SelectLastInsert();
    	customer.setCustomer_id(selDelId(input,customerServiceImpl));
    	customerServiceImpl.DeleteCustomer(customer);
    	System.out.println("你输入的ID�?"+customer.getCustomer_id()+"的Customer已经删除");
    }
	
    public static int sel(Scanner input ,AddressServiceImpl addressServiceImp){
    	System.out.println("请输�?  address_id :");
    	int address_id = input.nextInt();	
    	boolean flag =false;
    	for(Address as : addressServiceImp.getAllAddress()){
    		if(as.getAddress_id()==address_id){
    			flag=true;
    		}
    	}
		if(!flag){
			System.out.println("您所输入的address_id不存�?");
			address_id=sel(input,addressServiceImp);
		}
		return address_id;
    }
    
    public static int  selDelId(Scanner input ,CustomerServiceImpl customerServiceImpl){
    	System.out.println("请输入要删除的ID:");
   		int deleteId = input.nextInt();
    	boolean flag = false;
    	for(Customer cs : customerServiceImpl.SelectCustomer()){
    		if(cs.getCustomer_id()==deleteId){
    			flag=true;
    		}
    	}
    	if(!flag){	
    		System.out.println("您输入的ID不存�?");
    		deleteId=selDelId(input,customerServiceImpl);
    	}
    	return deleteId;
    }
   
}
