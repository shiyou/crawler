package com.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author hjd
 * @date 2016年8月11日
 */
@Controller
public class ProcessEngineTest {
	@Autowired
	ProcessEngine processEngine ;// = ProcessEngines.getDefaultProcessEngine();

}
