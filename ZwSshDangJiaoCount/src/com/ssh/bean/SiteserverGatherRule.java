package com.ssh.bean;

import java.sql.Timestamp;

/**
 * SiteserverGatherRule entity. @author MyEclipse Persistence Tools
 */

public class SiteserverGatherRule implements java.io.Serializable {

    // Fields

    private SiteserverGatherRuleId id;
    private String cookieString;
    private String gatherUrlIsCollection;
    private String gatherUrlCollection;
    private String gatherUrlIsSerialize;
    private String gatherUrlSerialize;
    private Integer serializeFrom;
    private Integer serializeTo;
    private Integer serializeInterval;
    private String serializeIsOrderByDesc;
    private String serializeIsAddZero;
    private Integer nodeId;
    private String charset;
    private String urlInclude;
    private String titleInclude;
    private String contentExclude;
    private String contentHtmlClearCollection;
    private String contentHtmlClearTagCollection;
    private Timestamp lastGatherDate;
    private String listAreaStart;
    private String listAreaEnd;
    private String contentChannelStart;
    private String contentChannelEnd;
    private String contentTitleStart;
    private String contentTitleEnd;
    private String contentContentStart;
    private String contentContentEnd;
    private String contentNextPageStart;
    private String contentNextPageEnd;
    private String contentAttributes;
    private String contentAttributesXml;
    private String extendValues;

    // Constructors

    /** default constructor */
    public SiteserverGatherRule() {
    }

    /** full constructor */
    public SiteserverGatherRule(SiteserverGatherRuleId id, String cookieString,
	    String gatherUrlIsCollection, String gatherUrlCollection,
	    String gatherUrlIsSerialize, String gatherUrlSerialize,
	    Integer serializeFrom, Integer serializeTo,
	    Integer serializeInterval, String serializeIsOrderByDesc,
	    String serializeIsAddZero, Integer nodeId, String charset,
	    String urlInclude, String titleInclude, String contentExclude,
	    String contentHtmlClearCollection,
	    String contentHtmlClearTagCollection, Timestamp lastGatherDate,
	    String listAreaStart, String listAreaEnd,
	    String contentChannelStart, String contentChannelEnd,
	    String contentTitleStart, String contentTitleEnd,
	    String contentContentStart, String contentContentEnd,
	    String contentNextPageStart, String contentNextPageEnd,
	    String contentAttributes, String contentAttributesXml,
	    String extendValues) {
	this.id = id;
	this.cookieString = cookieString;
	this.gatherUrlIsCollection = gatherUrlIsCollection;
	this.gatherUrlCollection = gatherUrlCollection;
	this.gatherUrlIsSerialize = gatherUrlIsSerialize;
	this.gatherUrlSerialize = gatherUrlSerialize;
	this.serializeFrom = serializeFrom;
	this.serializeTo = serializeTo;
	this.serializeInterval = serializeInterval;
	this.serializeIsOrderByDesc = serializeIsOrderByDesc;
	this.serializeIsAddZero = serializeIsAddZero;
	this.nodeId = nodeId;
	this.charset = charset;
	this.urlInclude = urlInclude;
	this.titleInclude = titleInclude;
	this.contentExclude = contentExclude;
	this.contentHtmlClearCollection = contentHtmlClearCollection;
	this.contentHtmlClearTagCollection = contentHtmlClearTagCollection;
	this.lastGatherDate = lastGatherDate;
	this.listAreaStart = listAreaStart;
	this.listAreaEnd = listAreaEnd;
	this.contentChannelStart = contentChannelStart;
	this.contentChannelEnd = contentChannelEnd;
	this.contentTitleStart = contentTitleStart;
	this.contentTitleEnd = contentTitleEnd;
	this.contentContentStart = contentContentStart;
	this.contentContentEnd = contentContentEnd;
	this.contentNextPageStart = contentNextPageStart;
	this.contentNextPageEnd = contentNextPageEnd;
	this.contentAttributes = contentAttributes;
	this.contentAttributesXml = contentAttributesXml;
	this.extendValues = extendValues;
    }

    // Property accessors

    public SiteserverGatherRuleId getId() {
	return this.id;
    }

    public void setId(SiteserverGatherRuleId id) {
	this.id = id;
    }

    public String getCookieString() {
	return this.cookieString;
    }

    public void setCookieString(String cookieString) {
	this.cookieString = cookieString;
    }

    public String getGatherUrlIsCollection() {
	return this.gatherUrlIsCollection;
    }

    public void setGatherUrlIsCollection(String gatherUrlIsCollection) {
	this.gatherUrlIsCollection = gatherUrlIsCollection;
    }

    public String getGatherUrlCollection() {
	return this.gatherUrlCollection;
    }

    public void setGatherUrlCollection(String gatherUrlCollection) {
	this.gatherUrlCollection = gatherUrlCollection;
    }

    public String getGatherUrlIsSerialize() {
	return this.gatherUrlIsSerialize;
    }

    public void setGatherUrlIsSerialize(String gatherUrlIsSerialize) {
	this.gatherUrlIsSerialize = gatherUrlIsSerialize;
    }

    public String getGatherUrlSerialize() {
	return this.gatherUrlSerialize;
    }

    public void setGatherUrlSerialize(String gatherUrlSerialize) {
	this.gatherUrlSerialize = gatherUrlSerialize;
    }

    public Integer getSerializeFrom() {
	return this.serializeFrom;
    }

    public void setSerializeFrom(Integer serializeFrom) {
	this.serializeFrom = serializeFrom;
    }

    public Integer getSerializeTo() {
	return this.serializeTo;
    }

    public void setSerializeTo(Integer serializeTo) {
	this.serializeTo = serializeTo;
    }

    public Integer getSerializeInterval() {
	return this.serializeInterval;
    }

    public void setSerializeInterval(Integer serializeInterval) {
	this.serializeInterval = serializeInterval;
    }

    public String getSerializeIsOrderByDesc() {
	return this.serializeIsOrderByDesc;
    }

    public void setSerializeIsOrderByDesc(String serializeIsOrderByDesc) {
	this.serializeIsOrderByDesc = serializeIsOrderByDesc;
    }

    public String getSerializeIsAddZero() {
	return this.serializeIsAddZero;
    }

    public void setSerializeIsAddZero(String serializeIsAddZero) {
	this.serializeIsAddZero = serializeIsAddZero;
    }

    public Integer getNodeId() {
	return this.nodeId;
    }

    public void setNodeId(Integer nodeId) {
	this.nodeId = nodeId;
    }

    public String getCharset() {
	return this.charset;
    }

    public void setCharset(String charset) {
	this.charset = charset;
    }

    public String getUrlInclude() {
	return this.urlInclude;
    }

    public void setUrlInclude(String urlInclude) {
	this.urlInclude = urlInclude;
    }

    public String getTitleInclude() {
	return this.titleInclude;
    }

    public void setTitleInclude(String titleInclude) {
	this.titleInclude = titleInclude;
    }

    public String getContentExclude() {
	return this.contentExclude;
    }

    public void setContentExclude(String contentExclude) {
	this.contentExclude = contentExclude;
    }

    public String getContentHtmlClearCollection() {
	return this.contentHtmlClearCollection;
    }

    public void setContentHtmlClearCollection(String contentHtmlClearCollection) {
	this.contentHtmlClearCollection = contentHtmlClearCollection;
    }

    public String getContentHtmlClearTagCollection() {
	return this.contentHtmlClearTagCollection;
    }

    public void setContentHtmlClearTagCollection(
	    String contentHtmlClearTagCollection) {
	this.contentHtmlClearTagCollection = contentHtmlClearTagCollection;
    }

    public Timestamp getLastGatherDate() {
	return this.lastGatherDate;
    }

    public void setLastGatherDate(Timestamp lastGatherDate) {
	this.lastGatherDate = lastGatherDate;
    }

    public String getListAreaStart() {
	return this.listAreaStart;
    }

    public void setListAreaStart(String listAreaStart) {
	this.listAreaStart = listAreaStart;
    }

    public String getListAreaEnd() {
	return this.listAreaEnd;
    }

    public void setListAreaEnd(String listAreaEnd) {
	this.listAreaEnd = listAreaEnd;
    }

    public String getContentChannelStart() {
	return this.contentChannelStart;
    }

    public void setContentChannelStart(String contentChannelStart) {
	this.contentChannelStart = contentChannelStart;
    }

    public String getContentChannelEnd() {
	return this.contentChannelEnd;
    }

    public void setContentChannelEnd(String contentChannelEnd) {
	this.contentChannelEnd = contentChannelEnd;
    }

    public String getContentTitleStart() {
	return this.contentTitleStart;
    }

    public void setContentTitleStart(String contentTitleStart) {
	this.contentTitleStart = contentTitleStart;
    }

    public String getContentTitleEnd() {
	return this.contentTitleEnd;
    }

    public void setContentTitleEnd(String contentTitleEnd) {
	this.contentTitleEnd = contentTitleEnd;
    }

    public String getContentContentStart() {
	return this.contentContentStart;
    }

    public void setContentContentStart(String contentContentStart) {
	this.contentContentStart = contentContentStart;
    }

    public String getContentContentEnd() {
	return this.contentContentEnd;
    }

    public void setContentContentEnd(String contentContentEnd) {
	this.contentContentEnd = contentContentEnd;
    }

    public String getContentNextPageStart() {
	return this.contentNextPageStart;
    }

    public void setContentNextPageStart(String contentNextPageStart) {
	this.contentNextPageStart = contentNextPageStart;
    }

    public String getContentNextPageEnd() {
	return this.contentNextPageEnd;
    }

    public void setContentNextPageEnd(String contentNextPageEnd) {
	this.contentNextPageEnd = contentNextPageEnd;
    }

    public String getContentAttributes() {
	return this.contentAttributes;
    }

    public void setContentAttributes(String contentAttributes) {
	this.contentAttributes = contentAttributes;
    }

    public String getContentAttributesXml() {
	return this.contentAttributesXml;
    }

    public void setContentAttributesXml(String contentAttributesXml) {
	this.contentAttributesXml = contentAttributesXml;
    }

    public String getExtendValues() {
	return this.extendValues;
    }

    public void setExtendValues(String extendValues) {
	this.extendValues = extendValues;
    }

}