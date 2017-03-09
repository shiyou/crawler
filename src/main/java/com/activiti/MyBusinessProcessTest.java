package com.activiti;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author hjd
 * @date 2017年3月9日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class MyBusinessProcessTest {
	
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	@Rule
	public ActivitiRule activitiRule;
	
	
	public void simpleProessTest() {
		runtimeService.startProcessInstanceByKey("simpleProcess");
		Task task = taskService.createTaskQuery().singleResult();
		Assert.assertEquals("My Task", task.getName());
		
		taskService.complete(task.getId());
		Assert.assertEquals(0, runtimeService.createNativeExecutionQuery().count());
	}
	@Test
	@Deployment
	public void ruleUsageExample(){
		RuntimeService runtimeService = activitiRule.getRuntimeService();
		runtimeService.startProcessInstanceByKey("ruleUsage");
		
		TaskService taskService = activitiRule.getTaskService();
		Task task = taskService.createTaskQuery().singleResult();
		Assert.assertEquals("My Task", task.getName());
		
		taskService.complete(task.getId());
		Assert.assertEquals(0, runtimeService.createNativeExecutionQuery().count());
	}
	

}

























