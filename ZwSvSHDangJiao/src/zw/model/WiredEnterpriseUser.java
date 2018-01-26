package zw.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WiredEnterpriseUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wired_EnterpriseUser", schema = "dbo", catalog = "hnyx")
public class WiredEnterpriseUser implements java.io.Serializable {

    // Fields

    private Integer enterpriseUserId;
    private String enterpriseUserCode;
    private String enterpriseUserName;
    private Integer industryId;
    private String industryName;
    private String state;
    private Timestamp addDate;
    private Timestamp editDate;

    // Constructors

    /** default constructor */
    public WiredEnterpriseUser() {
    }

    /** minimal constructor */
    public WiredEnterpriseUser(Integer industryId, Timestamp addDate,
	    Timestamp editDate) {
	this.industryId = industryId;
	this.addDate = addDate;
	this.editDate = editDate;
    }

    /** full constructor */
    public WiredEnterpriseUser(String enterpriseUserCode,
	    String enterpriseUserName, Integer industryId, String industryName,
	    String state, Timestamp addDate, Timestamp editDate) {
	this.enterpriseUserCode = enterpriseUserCode;
	this.enterpriseUserName = enterpriseUserName;
	this.industryId = industryId;
	this.industryName = industryName;
	this.state = state;
	this.addDate = addDate;
	this.editDate = editDate;
    }

    // Property accessors
    @Id
    @GeneratedValue
    @Column(name = "EnterpriseUserId", unique = true, nullable = false)
    public Integer getEnterpriseUserId() {
	return this.enterpriseUserId;
    }

    public void setEnterpriseUserId(Integer enterpriseUserId) {
	this.enterpriseUserId = enterpriseUserId;
    }

    @Column(name = "EnterpriseUserCode")
    public String getEnterpriseUserCode() {
	return this.enterpriseUserCode;
    }

    public void setEnterpriseUserCode(String enterpriseUserCode) {
	this.enterpriseUserCode = enterpriseUserCode;
    }

    @Column(name = "EnterpriseUserName")
    public String getEnterpriseUserName() {
	return this.enterpriseUserName;
    }

    public void setEnterpriseUserName(String enterpriseUserName) {
	this.enterpriseUserName = enterpriseUserName;
    }

    @Column(name = "IndustryId", nullable = false)
    public Integer getIndustryId() {
	return this.industryId;
    }

    public void setIndustryId(Integer industryId) {
	this.industryId = industryId;
    }

    @Column(name = "IndustryName")
    public String getIndustryName() {
	return this.industryName;
    }

    public void setIndustryName(String industryName) {
	this.industryName = industryName;
    }

    @Column(name = "State")
    public String getState() {
	return this.state;
    }

    public void setState(String state) {
	this.state = state;
    }

    @Column(name = "AddDate", nullable = false, length = 23)
    public Timestamp getAddDate() {
	return this.addDate;
    }

    public void setAddDate(Timestamp addDate) {
	this.addDate = addDate;
    }

    @Column(name = "EditDate", nullable = false, length = 23)
    public Timestamp getEditDate() {
	return this.editDate;
    }

    public void setEditDate(Timestamp editDate) {
	this.editDate = editDate;
    }

}