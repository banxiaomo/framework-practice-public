package com.rgl.spring.ioc.factory;

import org.springframework.beans.factory.FactoryBean;

import com.rgl.spring.ioc.entity.YuZhen;

public class YuZhenFactoryBean implements FactoryBean<YuZhen> {

	@Override
	public YuZhen getObject() throws Exception {
		YuZhen yuzhen = new YuZhen();
		YuZhen.initYuZhen(yuzhen);
		return yuzhen;
	}

	@Override
	public Class<?> getObjectType() {
		return YuZhen.class;
	}

}
