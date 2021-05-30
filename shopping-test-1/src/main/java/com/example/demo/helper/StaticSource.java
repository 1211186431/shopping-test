package com.example.demo.helper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StaticSource {
//	 String picurl="/home";
   String picurl="C://Users/dy-xx/Pictures";
   
   @Bean
   public String getPicurl() {
	   return this.picurl;
   }
}
