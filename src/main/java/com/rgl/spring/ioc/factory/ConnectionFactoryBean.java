package com.rgl.spring.ioc.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.FactoryBean;

public class ConnectionFactoryBean implements FactoryBean<Connection> {

	private String url;

	@Override
	public Connection getObject() throws Exception {
		return DriverManager.getConnection(url);
	}

	@Override
	public Class<?> getObjectType() {
		return Connection.class;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
