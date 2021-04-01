package com.rgl.spring.ioc.entity;

import com.rgl.common.entity.Idol;

public class YuZhen extends Idol {
	public YuZhen() {
		System.out.println("玉珍-无参构造器");
	}

	public YuZhen(Integer pid) {
		System.out.println("玉珍-有参构造器-参数:pid");
		super.setPid(pid);
	}

	public YuZhen(Integer pid, String fullname) {
		System.out.println("玉珍-有参构造器-参数:pid,fullname");
		super.setPid(pid);
		super.setName(fullname);
	}

	public YuZhen(Integer pid, String name, String fullname) {
		System.out.println("玉珍-有参构造器-参数:pid,name,fullname");
		super.setPid(pid);
		super.setName(name);
		super.setFullname(fullname);
	}

	public static void initYuZhen(YuZhen obj) {
		obj.setPid(1);
		obj.setFullname("谯玉珍");
		obj.setName("玉珍儿");
		obj.setCatchphrase("knock,knock,敲敲,门铃响了,铃铃");
	}
}
