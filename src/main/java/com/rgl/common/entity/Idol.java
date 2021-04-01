package com.rgl.common.entity;

public class Idol {
	private Integer pid;
	private String name;
	private String fullname;
	private String catchphrase;
	private String meme;
	private Integer msgid;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getCatchphrase() {
		return catchphrase;
	}

	public void setCatchphrase(String catchphrase) {
		this.catchphrase = catchphrase;
	}

	public String getMeme() {
		return meme;
	}

	public void setMeme(String meme) {
		this.meme = meme;
	}

	public Integer getMsgid() {
		return msgid;
	}

	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}

	@Override
	public String toString() {
		return "Idol [pid=" + pid + ", name=" + name + ", fullname=" + fullname + ", catchphrase=" + catchphrase + ", meme=" + meme + ", msgid=" + msgid + "]";
	}

}
