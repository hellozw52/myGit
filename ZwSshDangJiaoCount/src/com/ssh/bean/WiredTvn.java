package com.ssh.bean;

/**
 * WiredTvn entity. @author MyEclipse Persistence Tools
 */

public class WiredTvn implements java.io.Serializable {

    // Fields

    private Integer id;
    private Integer enterpriseUserId;
    private String tvn;

    // Constructors

    /** default constructor */
    public WiredTvn() {
    }

    /** full constructor */
    public WiredTvn(Integer enterpriseUserId, String tvn) {
	this.enterpriseUserId = enterpriseUserId;
	this.tvn = tvn;
    }

    // Property accessors

    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Integer getEnterpriseUserId() {
	return this.enterpriseUserId;
    }

    public void setEnterpriseUserId(Integer enterpriseUserId) {
	this.enterpriseUserId = enterpriseUserId;
    }

    public String getTvn() {
	return this.tvn;
    }

    public void setTvn(String tvn) {
	this.tvn = tvn;
    }

}