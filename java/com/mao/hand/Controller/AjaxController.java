package com.mao.hand.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

		@RequestMapping("/ajax")
		@ResponseBody
		public void ajax(String tname , HttpServletResponse resp) throws IOException{
			System.out.println(tname);
			if("aaa".equals(tname)){
					System.out.println(1111);

			}else{
				System.out.println(2222);
			}
		}
		
}
