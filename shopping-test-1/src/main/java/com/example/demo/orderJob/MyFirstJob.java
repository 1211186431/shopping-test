package com.example.demo.orderJob;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.example.demo.helper.ApplicationContextUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyFirstJob extends QuartzJobBean{
   String name;
   public void setName(String name) {
	   this.name=name;
   }
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		 log.info("11111"+name);
		 //DBJob d=(DBJob) ApplicationContextUtil.getBean("DBJob");
	}
}
