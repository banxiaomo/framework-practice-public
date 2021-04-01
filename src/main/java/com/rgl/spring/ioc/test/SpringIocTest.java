package com.rgl.spring.ioc.test;

import java.sql.Connection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rgl.spring.ioc.entity.ShanShan;
import com.rgl.spring.ioc.entity.YuZhen;

public class SpringIocTest {
	private static ApplicationContext context;

	public static void main(String[] args) {
		String config = "spring-ioc.xml";
		context = new ClassPathXmlApplicationContext(config);
//		iocTest1();
//		iocTest2();
//		iocTest3();
		iocTest4();
	}

	/**
	 * spring-ioc 通过'构造器'生成 bean,并通过构造器注入
	 */
	public static void iocTest1() {
		// bean不配置id和name时
		YuZhen yuzhen = context.getBean("com.rgl.spring.ioc.entity.YuZhen#0", YuZhen.class);
		System.out.println(yuzhen);
		// 构造器参数为pid
		YuZhen yuzhen1 = context.getBean("yuzhen1", YuZhen.class);
		System.out.println(yuzhen1);
		// 构造器参数为pid,fullname,name
		YuZhen yuzhen2 = context.getBean("yuzhen2", YuZhen.class);
		System.out.println(yuzhen2);
	}

	/**
	 * spring-ioc 通过'构造器'生成 bean,并通过set方法注入
	 */
	public static void iocTest2() {
		// 使用set方法初始化pid和fullname
		ShanShan shanshan1 = context.getBean("shanshan1", ShanShan.class);
		System.out.println(shanshan1);
		// 使用 含参构造器 创建bean,再用set方法初始化fullname和yuzhen
		ShanShan shanshan2 = context.getBean("shanshan2", ShanShan.class);
		System.out.println(shanshan2);
	}

	/**
	 * spring-ioc 通过"静态工厂方法"和"实例工厂方法"生成bean
	 * <p>
	 * 实例工厂方法,会进行'bean的初始化'和'动态从ioc容器获取bean注入'
	 */
	public static void iocTest3() {
		// 使用 静态构造方法 创建bean
		YuZhen yuzhen3 = context.getBean("yuzhen3", YuZhen.class);
		System.out.println(yuzhen3);
		// 使用 实例工厂方法 创建bean,并使用方法通过beanfactory注入
		ShanShan shanshan3 = context.getBean("shanshan3", ShanShan.class);
		System.out.println(shanshan3);
	}

	/**
	 * spring-ioc 通过 factorybean 的方式生成bean
	 */
	public static void iocTest4() {
		// 使用 factorybean 的方式创建bean
		YuZhen yuzhen4 = context.getBean("yuzhen4", YuZhen.class);
		System.out.println(yuzhen4);
		// 使用 factorybean 的方式创建bean,将第三方包生成的connection的bean放入ioc容器
		Connection conn = context.getBean("conn", Connection.class);
		System.out.println(conn);

	}
}
