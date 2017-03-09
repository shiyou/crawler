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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hjd
 * @date 2017年3月9日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class JunitTest {
	
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	@Rule
	public ActivitiRule activitiRule;
	
	@Test
	@Deployment
	public void test(){
		runtimeService.startProcessInstanceByKey("oneTaskProcess");
		Task task = taskService.createTaskQuery().singleResult();
		Assert.assertEquals("my task", task.getName());
		
		taskService.complete(task.getId());
		Assert.assertEquals(0, runtimeService.createProcessInstanceQuery().count());
		
	}
}
