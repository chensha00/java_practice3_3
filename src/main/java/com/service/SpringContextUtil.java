package com.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author guohongjin
 * @ClassName SpringContextUtil
 * @Description 获取springmvc的容器帮助类
 * @date 2016/8/25
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    // Spring应用上下文环境
    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * @Title: getApplicationContext
     * @Description: 保证线程同步
     * @author guohongjin
     * @date 2016-08-25
     */

    public synchronized  static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    /**
     * @Title: getBean
     * @Description: 根据beanId获取bean对象
     * @author guohongjin
     * @throw BeansException
     */

    public synchronized  static Object getBean(String beanId) throws BeansException {
        return applicationContext.getBean(beanId);
    }

}
