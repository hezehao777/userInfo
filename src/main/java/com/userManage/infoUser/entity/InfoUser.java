package com.userManage.infoUser.entity;

import java.io.Serializable;
import java.util.Date;

public class InfoUser implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Byte type;

    private Date loginTime;

    private Date changepwdTime;

    private Date createTime;

    private Byte status;

    private String mobile;

    private String photoUrl;

    private String nickname;

    private Integer storeId;

    private Integer accountMoney;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getChangepwdTime() {
        return changepwdTime;
    }

    public void setChangepwdTime(Date changepwdTime) {
        this.changepwdTime = changepwdTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(Integer accountMoney) {
        this.accountMoney = accountMoney;
    }

	@Override
	public String toString() {
		return "InfoUser [id=" + id + ", username=" + username + ", password=" + password + ", type=" + type
				+ ", loginTime=" + loginTime + ", changepwdTime=" + changepwdTime + ", createTime=" + createTime
				+ ", status=" + status + ", mobile=" + mobile + ", photoUrl=" + photoUrl + ", nickname=" + nickname
				+ ", storeId=" + storeId + ", accountMoney=" + accountMoney + "]";
	}
    
    
}