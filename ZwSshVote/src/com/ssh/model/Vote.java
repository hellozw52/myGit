package com.ssh.model;

/**
 * Vote entity. @author MyEclipse Persistence Tools
 */

public class Vote implements java.io.Serializable {

    // Fields

    private Integer id;
    private String tvn;
    private String voteid;
    private String votetime;
    private String address;

    // Constructors

    /** default constructor */
    public Vote() {
    }

    /** full constructor */
    public Vote(String tvn, String voteid, String votetime, String address) {
	this.tvn = tvn;
	this.voteid = voteid;
	this.votetime = votetime;
	this.address = address;
    }

    // Property accessors

    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getTvn() {
	return this.tvn;
    }

    public void setTvn(String tvn) {
	this.tvn = tvn;
    }

    public String getVoteid() {
	return this.voteid;
    }

    public void setVoteid(String voteid) {
	this.voteid = voteid;
    }

    public String getVotetime() {
	return this.votetime;
    }

    public void setVotetime(String votetime) {
	this.votetime = votetime;
    }

    public String getAddress() {
	return this.address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

}