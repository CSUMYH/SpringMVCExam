package com.mao.hand.Cut;

import org.aspectj.lang.annotation.Aspect;

//@Aspect
public class Log {
//	@Before("execution(* com.mao.hand.ServiceImpl.CustomerServiceIce)")
	public void Before(){
		System.out.println("Before	Insert	Customer Data");
	}
	public void After(){
		System.out.println("After	Insert	Customer Data");
	}
}
