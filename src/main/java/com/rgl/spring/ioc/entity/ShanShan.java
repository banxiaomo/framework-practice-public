package com.rgl.spring.ioc.entity;

import com.rgl.common.entity.Idol;

public class ShanShan extends Idol {

	private YuZhen yuzhen;

	public ShanShan() {
		System.out.println("闪闪-无参构造器");
	}

	public ShanShan(Integer pid) {
		System.out.println("闪闪-有参构造器-参数:pid");
		super.setPid(pid);
	}

	public ShanShan(Integer pid, String fullname) {
		System.out.println("闪闪-有参构造器-参数:pid,fullname");
		super.setPid(pid);
		super.setName(fullname);
	}

	public ShanShan(Integer pid, String fullname, YuZhen yuzhen) {
		System.out.println("闪闪-有参构造器-参数:pid,fullname,yuzhen");
		super.setPid(pid);
		super.setFullname(fullname);
		this.yuzhen = yuzhen;
	}

	public YuZhen getYuzhen() {
		return yuzhen;
	}

	public void setYuzhen(YuZhen yuzhen) {
		this.yuzhen = yuzhen;
	}

	@Override
	public String toString() {
		return super.toString() + "ShanShan [yuzhen=" + yuzhen + "]";
	}

	public static void initShanShan(ShanShan obj) {
		obj.setPid(2);
		obj.setFullname("杨允涵");
		obj.setName("闪闪");
		obj.setCatchphrase("一闪一闪亮晶晶,满天都是,布灵布灵");
	}

}
