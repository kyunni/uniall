package com.mong.cmmn.session;

import java.io.Serializable;

public class LoginUserSession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3635098009466290957L;
	private String userIdx;
	private String userId;
	private String userName;
	private String userGroup;
	public String getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(String userIdx) {
		this.userIdx = userIdx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	
	
}
