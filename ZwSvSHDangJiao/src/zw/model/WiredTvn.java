package zw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WiredTvn entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wired_TVN", schema = "dbo", catalog = "hnyx")
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
    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false)
    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Column(name = "EnterpriseUserId", nullable = false)
    public Integer getEnterpriseUserId() {
	return this.enterpriseUserId;
    }

    public void setEnterpriseUserId(Integer enterpriseUserId) {
	this.enterpriseUserId = enterpriseUserId;
    }

    @Column(name = "TVN", nullable = false)
    public String getTvn() {
	return this.tvn;
    }

    public void setTvn(String tvn) {
	this.tvn = tvn;
    }

}