package com.rgl.common.entity;

public class IdolMsg {
	private Integer pid;
	private Integer idolId;
	private String idolname;
	private String team;
	private String rank;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getIdolId() {
		return idolId;
	}

	public void setIdolId(Integer idolId) {
		this.idolId = idolId;
	}

	public String getIdolname() {
		return idolname;
	}

	public void setIdolname(String idolname) {
		this.idolname = idolname;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "IdolMsg [pid=" + pid + ", idolId=" + idolId + ", idolname=" + idolname + ", team=" + team + ", rank=" + rank + "]";
	}

}
