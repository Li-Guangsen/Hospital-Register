package com.lgs.backend.common;

import com.lgs.backend.api.OrderApi;
import com.lgs.backend.dao.OrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(StartupRunner.class);
    //使时间早于今天的订单，如果订单状态status是“已叫号”则更新为已取消
    private OrderDao orderDao;
    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    @Override
    public void run(String... args) throws Exception {
        orderDao.updateNowStatus();
        LOGGER.info("往日未完成（未到）预约，“已叫号”更新为“已取消”！");
        LOGGER.info("定时任务执行完成！");
        LOGGER.info("====================================");
        LOGGER.info("====================================");
        LOGGER.info("Hello, Spring Boot!");
    }
}
