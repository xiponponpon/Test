package com.surn.quartz02.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyJobFactory extends AdaptableJobFactory {

    //这个由Spring自动注入
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    //重写Job任务对象的创建实例方法
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        //通过以下方式，解决Job任务无法使用Spring中的Bean问题
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}

