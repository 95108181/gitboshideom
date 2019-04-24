package com.boshi.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定时任务窜行执行
 **/
@Component
public class SchedulingTest {

  private final Logger logger = LoggerFactory.getLogger(getClass());
//  //添加定时任务1
//  @Scheduled(cron = "0/1 * * * * ?") // 每5秒执行一次
//  public void scheduler() {
//    logger.info("11111111111111111111");
//  }
//  //添加定时任务2
//  @Scheduled(cron = "0/2 * * * * ?") // 每5秒执行一次
//  public void scheduler1() {
//    logger.info("2222222222222222222222");
//  }
}
