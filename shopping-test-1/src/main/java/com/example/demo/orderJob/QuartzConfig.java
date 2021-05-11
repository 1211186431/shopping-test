package com.example.demo.orderJob;

import java.util.Date;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

@Component
public class QuartzConfig {

	/**
	 * 删除任务
	 */
	public  void delTask(String key) throws SchedulerException {
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
		scheduler.deleteJob(new JobKey(key));
	}
	/**
	 * 创建任务
	 */
	public  void task(Job job,Map<String,Object> param,String key) throws SchedulerException {
		Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 开始
        scheduler.start();
        // job 唯一标识 test.test-1
        JobKey jobKey = new JobKey(key);
        if(scheduler.checkExists(jobKey)) return;//任务已存在
        JobDataMap map=new JobDataMap(param);//传到参数
        JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(jobKey).setJobData( map).build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(key)
                // 执行时间
                .startAt(new Date(System.currentTimeMillis() + 1000*60*5))
                .build();
        scheduler.scheduleJob(jobDetail , trigger);
	}


}
