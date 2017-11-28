package com.ssh.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * SiteserverTemplate entity. @author MyEclipse Persistence Tools
 */

public class SiteserverTemplate implements java.io.Serializable {

    // Fields

    private Integer templateId;
    private SiteserverNode siteserverNode;
    private String templateName;
    private String templateType;
    private String relatedFileName;
    private String createdFileFullName;
    private String createdFileExtName;
    private String charset;
    private String isDefault;
    private Set siteserverTemplateLogs = new HashSet(0);

    // Constructors

    /** default constructor */
    public SiteserverTemplate() {
    }

    /** minimal constructor */
    public SiteserverTemplate(SiteserverNode siteserverNode,
	    String templateName, String templateType, String relatedFileName,
	    String createdFileFullName, String createdFileExtName,
	    String charset, String isDefault) {
	this.siteserverNode = siteserverNode;
	this.templateName = templateName;
	this.templateType = templateType;
	this.relatedFileName = relatedFileName;
	this.createdFileFullName = createdFileFullName;
	this.createdFileExtName = createdFileExtName;
	this.charset = charset;
	this.isDefault = isDefault;
    }

    /** full constructor */
    public SiteserverTemplate(SiteserverNode siteserverNode,
	    String templateName, String templateType, String relatedFileName,
	    String createdFileFullName, String createdFileExtName,
	    String charset, String isDefault, Set siteserverTemplateLogs) {
	this.siteserverNode = siteserverNode;
	this.templateName = templateName;
	this.templateType = templateType;
	this.relatedFileName = relatedFileName;
	this.createdFileFullName = createdFileFullName;
	this.createdFileExtName = createdFileExtName;
	this.charset = charset;
	this.isDefault = isDefault;
	this.siteserverTemplateLogs = siteserverTemplateLogs;
    }

    // Property accessors

    public Integer getTemplateId() {
	return this.templateId;
    }

    public void setTemplateId(Integer templateId) {
	this.templateId = templateId;
    }

    public SiteserverNode getSiteserverNode() {
	return this.siteserverNode;
    }

    public void setSiteserverNode(SiteserverNode siteserverNode) {
	this.siteserverNode = siteserverNode;
    }

    public String getTemplateName() {
	return this.templateName;
    }

    public void setTemplateName(String templateName) {
	this.templateName = templateName;
    }

    public String getTemplateType() {
	return this.templateType;
    }

    public void setTemplateType(String templateType) {
	this.templateType = templateType;
    }

    public String getRelatedFileName() {
	return this.relatedFileName;
    }

    public void setRelatedFileName(String relatedFileName) {
	this.relatedFileName = relatedFileName;
    }

    public String getCreatedFileFullName() {
	return this.createdFileFullName;
    }

    public void setCreatedFileFullName(String createdFileFullName) {
	this.createdFileFullName = createdFileFullName;
    }

    public String getCreatedFileExtName() {
	return this.createdFileExtName;
    }

    public void setCreatedFileExtName(String createdFileExtName) {
	this.createdFileExtName = createdFileExtName;
    }

    public String getCharset() {
	return this.charset;
    }

    public void setCharset(String charset) {
	this.charset = charset;
    }

    public String getIsDefault() {
	return this.isDefault;
    }

    public void setIsDefault(String isDefault) {
	this.isDefault = isDefault;
    }

    public Set getSiteserverTemplateLogs() {
	return this.siteserverTemplateLogs;
    }

    public void setSiteserverTemplateLogs(Set siteserverTemplateLogs) {
	this.siteserverTemplateLogs = siteserverTemplateLogs;
    }

}