package com.rgl.spring.ioc.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;

import com.rgl.spring.ioc.entity.ShanShan;
import com.rgl.spring.ioc.entity.YuZhen;

public class ShanShanBeanFactory implements BeanFactoryAware, InitializingBean {

	private BeanFactory beanFactory;

	/**
	 * 静态工厂方法
	 */
	public static YuZhen getInstance(boolean isInit) {
		System.out.println("===静态工厂方法===");
		YuZhen obj = new YuZhen();
		if (isInit) {
			YuZhen.initYuZhen(obj);
		}
		System.out.println("===静态工厂方法===");
		return obj;
	}

	/**
	 * 实例工厂方法
	 */
	public ShanShan getInstance() {
		System.out.println("===实例工厂方法===");
		ShanShan obj = new ShanShan(2);
		// 动态的从ioc容器内取bean
		YuZhen yuzhen = beanFactory.getBean("yuzhen3", YuZhen.class);
		obj.setYuzhen(yuzhen);
		System.out.println("===实例工厂方法===");
		return obj;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("bean生命周期-初始化");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

}
