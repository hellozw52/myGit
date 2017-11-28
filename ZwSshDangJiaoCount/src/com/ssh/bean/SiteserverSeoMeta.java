package com.ssh.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * SiteserverSeoMeta entity. @author MyEclipse Persistence Tools
 */

public class SiteserverSeoMeta implements java.io.Serializable {

    // Fields

    private Integer seoMetaId;
    private SiteserverNode siteserverNode;
    private String seoMetaName;
    private String isDefault;
    private String pageTitle;
    private String keywords;
    private String description;
    private String copyright;
    private String author;
    private String email;
    private String language;
    private String charset;
    private String distribution;
    private String rating;
    private String robots;
    private String revisitAfter;
    private String expires;
    private Set siteserverSeoMetasInNodeses = new HashSet(0);

    // Constructors

    /** default constructor */
    public SiteserverSeoMeta() {
    }

    /** minimal constructor */
    public SiteserverSeoMeta(SiteserverNode siteserverNode, String seoMetaName,
	    String isDefault, String pageTitle, String keywords,
	    String description, String copyright, String author, String email,
	    String language, String charset, String distribution,
	    String rating, String robots, String revisitAfter, String expires) {
	this.siteserverNode = siteserverNode;
	this.seoMetaName = seoMetaName;
	this.isDefault = isDefault;
	this.pageTitle = pageTitle;
	this.keywords = keywords;
	this.description = description;
	this.copyright = copyright;
	this.author = author;
	this.email = email;
	this.language = language;
	this.charset = charset;
	this.distribution = distribution;
	this.rating = rating;
	this.robots = robots;
	this.revisitAfter = revisitAfter;
	this.expires = expires;
    }

    /** full constructor */
    public SiteserverSeoMeta(SiteserverNode siteserverNode, String seoMetaName,
	    String isDefault, String pageTitle, String keywords,
	    String description, String copyright, String author, String email,
	    String language, String charset, String distribution,
	    String rating, String robots, String revisitAfter, String expires,
	    Set siteserverSeoMetasInNodeses) {
	this.siteserverNode = siteserverNode;
	this.seoMetaName = seoMetaName;
	this.isDefault = isDefault;
	this.pageTitle = pageTitle;
	this.keywords = keywords;
	this.description = description;
	this.copyright = copyright;
	this.author = author;
	this.email = email;
	this.language = language;
	this.charset = charset;
	this.distribution = distribution;
	this.rating = rating;
	this.robots = robots;
	this.revisitAfter = revisitAfter;
	this.expires = expires;
	this.siteserverSeoMetasInNodeses = siteserverSeoMetasInNodeses;
    }

    // Property accessors

    public Integer getSeoMetaId() {
	return this.seoMetaId;
    }

    public void setSeoMetaId(Integer seoMetaId) {
	this.seoMetaId = seoMetaId;
    }

    public SiteserverNode getSiteserverNode() {
	return this.siteserverNode;
    }

    public void setSiteserverNode(SiteserverNode siteserverNode) {
	this.siteserverNode = siteserverNode;
    }

    public String getSeoMetaName() {
	return this.seoMetaName;
    }

    public void setSeoMetaName(String seoMetaName) {
	this.seoMetaName = seoMetaName;
    }

    public String getIsDefault() {
	return this.isDefault;
    }

    public void setIsDefault(String isDefault) {
	this.isDefault = isDefault;
    }

    public String getPageTitle() {
	return this.pageTitle;
    }

    public void setPageTitle(String pageTitle) {
	this.pageTitle = pageTitle;
    }

    public String getKeywords() {
	return this.keywords;
    }

    public void setKeywords(String keywords) {
	this.keywords = keywords;
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public String getCopyright() {
	return this.copyright;
    }

    public void setCopyright(String copyright) {
	this.copyright = copyright;
    }

    public String getAuthor() {
	return this.author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    public String getEmail() {
	return this.email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getLanguage() {
	return this.language;
    }

    public void setLanguage(String language) {
	this.language = language;
    }

    public String getCharset() {
	return this.charset;
    }

    public void setCharset(String charset) {
	this.charset = charset;
    }

    public String getDistribution() {
	return this.distribution;
    }

    public void setDistribution(String distribution) {
	this.distribution = distribution;
    }

    public String getRating() {
	return this.rating;
    }

    public void setRating(String rating) {
	this.rating = rating;
    }

    public String getRobots() {
	return this.robots;
    }

    public void setRobots(String robots) {
	this.robots = robots;
    }

    public String getRevisitAfter() {
	return this.revisitAfter;
    }

    public void setRevisitAfter(String revisitAfter) {
	this.revisitAfter = revisitAfter;
    }

    public String getExpires() {
	return this.expires;
    }

    public void setExpires(String expires) {
	this.expires = expires;
    }

    public Set getSiteserverSeoMetasInNodeses() {
	return this.siteserverSeoMetasInNodeses;
    }

    public void setSiteserverSeoMetasInNodeses(Set siteserverSeoMetasInNodeses) {
	this.siteserverSeoMetasInNodeses = siteserverSeoMetasInNodeses;
    }

}