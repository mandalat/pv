package com.mandala.system.vo;

import java.io.Serializable;

public class LoginUserNew implements Serializable
{
private static final long serialVersionUID = 1L;
private String userId;//用户ID，登录工号
private String userName;//用户姓名
private String password;//密码
private String userPhoneNum;//电话
private String ksCode;//科室代码
private String ksName;//科室名称
private String zwName;//职务名称
private String loginType;//登录类型
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserPhoneNum() {
	return userPhoneNum;
}
public void setUserPhoneNum(String userPhoneNum) {
	this.userPhoneNum = userPhoneNum;
}
public String getKsCode() {
	return ksCode;
}
public void setKsCode(String ksCode) {
	this.ksCode = ksCode;
}
public String getKsName() {
	return ksName;
}
public void setKsName(String ksName) {
	this.ksName = ksName;
}
public String getZwName() {
	return zwName;
}
public void setZwName(String zwName) {
	this.zwName = zwName;
}
public String getLoginType() {
	return loginType;
}
public void setLoginType(String loginType) {
	this.loginType = loginType;
}
@Override
public String toString() {
	return "LoginUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userPhoneNum="
			+ userPhoneNum + ", ksCode=" + ksCode + ", ksName=" + ksName + ", zwName=" + zwName + ", loginType="
			+ loginType + "]";
}


}