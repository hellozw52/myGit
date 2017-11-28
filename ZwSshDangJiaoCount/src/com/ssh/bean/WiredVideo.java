package com.ssh.bean;

import java.sql.Timestamp;

/**
 * WiredVideo entity. @author MyEclipse Persistence Tools
 */

public class WiredVideo implements java.io.Serializable {

    // Fields

    private Integer videoId;
    private Integer publishmentSystemId;
    private String assetName;
    private String assetId;
    private String assetTmpId;
    private String assetTmpId1;
    private String assetTmpId2;
    private String assetClass;
    private Integer providerId;
    private String providerName;
    private String providerCode;
    private String product;
    private String description;
    private Timestamp createDate;
    private Timestamp editDate;
    private String versionMajor;
    private String versionMinor;
    private Integer taxis;
    private String addUser;
    private String videoPath;
    private String videoName;
    private String xmlpath;
    private String coverPath;
    private String videoIntro;
    private String state;
    private String ftpVideoPath;
    private String titbitsPath;
    private String additionXml;
    private String ftpAdipath;
    private String runTime;
    private String displayRunTime;
    private Timestamp licensingStart;
    private Timestamp licensingEnd;
    private String isBatch;
    private String batchProcess;
    private Integer productId;

    // Constructors

    /** default constructor */
    public WiredVideo() {
    }

    /** minimal constructor */
    public WiredVideo(Integer publishmentSystemId, Integer providerId,
	    Timestamp createDate, Timestamp editDate, Integer taxis,
	    Timestamp licensingStart, Timestamp licensingEnd, Integer productId) {
	this.publishmentSystemId = publishmentSystemId;
	this.providerId = providerId;
	this.createDate = createDate;
	this.editDate = editDate;
	this.taxis = taxis;
	this.licensingStart = licensingStart;
	this.licensingEnd = licensingEnd;
	this.productId = productId;
    }

    /** full constructor */
    public WiredVideo(Integer publishmentSystemId, String assetName,
	    String assetId, String assetTmpId, String assetTmpId1,
	    String assetTmpId2, String assetClass, Integer providerId,
	    String providerName, String providerCode, String product,
	    String description, Timestamp createDate, Timestamp editDate,
	    String versionMajor, String versionMinor, Integer taxis,
	    String addUser, String videoPath, String videoName, String xmlpath,
	    String coverPath, String videoIntro, String state,
	    String ftpVideoPath, String titbitsPath, String additionXml,
	    String ftpAdipath, String runTime, String displayRunTime,
	    Timestamp licensingStart, Timestamp licensingEnd, String isBatch,
	    String batchProcess, Integer productId) {
	this.publishmentSystemId = publishmentSystemId;
	this.assetName = assetName;
	this.assetId = assetId;
	this.assetTmpId = assetTmpId;
	this.assetTmpId1 = assetTmpId1;
	this.assetTmpId2 = assetTmpId2;
	this.assetClass = assetClass;
	this.providerId = providerId;
	this.providerName = providerName;
	this.providerCode = providerCode;
	this.product = product;
	this.description = description;
	this.createDate = createDate;
	this.editDate = editDate;
	this.versionMajor = versionMajor;
	this.versionMinor = versionMinor;
	this.taxis = taxis;
	this.addUser = addUser;
	this.videoPath = videoPath;
	this.videoName = videoName;
	this.xmlpath = xmlpath;
	this.coverPath = coverPath;
	this.videoIntro = videoIntro;
	this.state = state;
	this.ftpVideoPath = ftpVideoPath;
	this.titbitsPath = titbitsPath;
	this.additionXml = additionXml;
	this.ftpAdipath = ftpAdipath;
	this.runTime = runTime;
	this.displayRunTime = displayRunTime;
	this.licensingStart = licensingStart;
	this.licensingEnd = licensingEnd;
	this.isBatch = isBatch;
	this.batchProcess = batchProcess;
	this.productId = productId;
    }

    // Property accessors

    public Integer getVideoId() {
	return this.videoId;
    }

    public void setVideoId(Integer videoId) {
	this.videoId = videoId;
    }

    public Integer getPublishmentSystemId() {
	return this.publishmentSystemId;
    }

    public void setPublishmentSystemId(Integer publishmentSystemId) {
	this.publishmentSystemId = publishmentSystemId;
    }

    public String getAssetName() {
	return this.assetName;
    }

    public void setAssetName(String assetName) {
	this.assetName = assetName;
    }

    public String getAssetId() {
	return this.assetId;
    }

    public void setAssetId(String assetId) {
	this.assetId = assetId;
    }

    public String getAssetTmpId() {
	return this.assetTmpId;
    }

    public void setAssetTmpId(String assetTmpId) {
	this.assetTmpId = assetTmpId;
    }

    public String getAssetTmpId1() {
	return this.assetTmpId1;
    }

    public void setAssetTmpId1(String assetTmpId1) {
	this.assetTmpId1 = assetTmpId1;
    }

    public String getAssetTmpId2() {
	return this.assetTmpId2;
    }

    public void setAssetTmpId2(String assetTmpId2) {
	this.assetTmpId2 = assetTmpId2;
    }

    public String getAssetClass() {
	return this.assetClass;
    }

    public void setAssetClass(String assetClass) {
	this.assetClass = assetClass;
    }

    public Integer getProviderId() {
	return this.providerId;
    }

    public void setProviderId(Integer providerId) {
	this.providerId = providerId;
    }

    public String getProviderName() {
	return this.providerName;
    }

    public void setProviderName(String providerName) {
	this.providerName = providerName;
    }

    public String getProviderCode() {
	return this.providerCode;
    }

    public void setProviderCode(String providerCode) {
	this.providerCode = providerCode;
    }

    public String getProduct() {
	return this.product;
    }

    public void setProduct(String product) {
	this.product = product;
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Timestamp getCreateDate() {
	return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
	this.createDate = createDate;
    }

    public Timestamp getEditDate() {
	return this.editDate;
    }

    public void setEditDate(Timestamp editDate) {
	this.editDate = editDate;
    }

    public String getVersionMajor() {
	return this.versionMajor;
    }

    public void setVersionMajor(String versionMajor) {
	this.versionMajor = versionMajor;
    }

    public String getVersionMinor() {
	return this.versionMinor;
    }

    public void setVersionMinor(String versionMinor) {
	this.versionMinor = versionMinor;
    }

    public Integer getTaxis() {
	return this.taxis;
    }

    public void setTaxis(Integer taxis) {
	this.taxis = taxis;
    }

    public String getAddUser() {
	return this.addUser;
    }

    public void setAddUser(String addUser) {
	this.addUser = addUser;
    }

    public String getVideoPath() {
	return this.videoPath;
    }

    public void setVideoPath(String videoPath) {
	this.videoPath = videoPath;
    }

    public String getVideoName() {
	return this.videoName;
    }

    public void setVideoName(String videoName) {
	this.videoName = videoName;
    }

    public String getXmlpath() {
	return this.xmlpath;
    }

    public void setXmlpath(String xmlpath) {
	this.xmlpath = xmlpath;
    }

    public String getCoverPath() {
	return this.coverPath;
    }

    public void setCoverPath(String coverPath) {
	this.coverPath = coverPath;
    }

    public String getVideoIntro() {
	return this.videoIntro;
    }

    public void setVideoIntro(String videoIntro) {
	this.videoIntro = videoIntro;
    }

    public String getState() {
	return this.state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getFtpVideoPath() {
	return this.ftpVideoPath;
    }

    public void setFtpVideoPath(String ftpVideoPath) {
	this.ftpVideoPath = ftpVideoPath;
    }

    public String getTitbitsPath() {
	return this.titbitsPath;
    }

    public void setTitbitsPath(String titbitsPath) {
	this.titbitsPath = titbitsPath;
    }

    public String getAdditionXml() {
	return this.additionXml;
    }

    public void setAdditionXml(String additionXml) {
	this.additionXml = additionXml;
    }

    public String getFtpAdipath() {
	return this.ftpAdipath;
    }

    public void setFtpAdipath(String ftpAdipath) {
	this.ftpAdipath = ftpAdipath;
    }

    public String getRunTime() {
	return this.runTime;
    }

    public void setRunTime(String runTime) {
	this.runTime = runTime;
    }

    public String getDisplayRunTime() {
	return this.displayRunTime;
    }

    public void setDisplayRunTime(String displayRunTime) {
	this.displayRunTime = displayRunTime;
    }

    public Timestamp getLicensingStart() {
	return this.licensingStart;
    }

    public void setLicensingStart(Timestamp licensingStart) {
	this.licensingStart = licensingStart;
    }

    public Timestamp getLicensingEnd() {
	return this.licensingEnd;
    }

    public void setLicensingEnd(Timestamp licensingEnd) {
	this.licensingEnd = licensingEnd;
    }

    public String getIsBatch() {
	return this.isBatch;
    }

    public void setIsBatch(String isBatch) {
	this.isBatch = isBatch;
    }

    public String getBatchProcess() {
	return this.batchProcess;
    }

    public void setBatchProcess(String batchProcess) {
	this.batchProcess = batchProcess;
    }

    public Integer getProductId() {
	return this.productId;
    }

    public void setProductId(Integer productId) {
	this.productId = productId;
    }

}