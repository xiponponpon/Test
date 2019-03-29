package com.surn.quartz02.quartz;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class QuartzConfiguration {

    @Autowired
    private MyJobFactory myJobFactory;

    //创建调度器工厂
    @Bean
        public SchedulerFactoryBean schedulerFactoryBean(){
            //1.创建SchedulerFactoryBean
            //2.加载自定义的quartz.properties配置文件
            //3.设置MyJobFactory

            SchedulerFactoryBean factoryBean=new SchedulerFactoryBean();
            try {
                factoryBean.setQuartzProperties(quartzProperties());
                factoryBean.setJobFactory(myJobFactory);
                return factoryBean;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean=new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    @Bean(name="scheduler")
    public Scheduler scheduler(){
        return schedulerFactoryBean().getScheduler();
    }
}