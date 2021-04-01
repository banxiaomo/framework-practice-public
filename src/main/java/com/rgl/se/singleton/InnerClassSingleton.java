package com.rgl.se.singleton;

public class InnerClassSingleton {
	static class InnerClass {
		private static InnerClassSingleton instance = new InnerClassSingleton();
	}

	private InnerClassSingleton() {

	}

	public static InnerClassSingleton getInstance() {
		return InnerClass.instance;
	}
}
