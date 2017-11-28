package com.ssh.bean;

/**
 * SiteserverPublishmentSystem entity. @author MyEclipse Persistence Tools
 */

public class SiteserverPublishmentSystem implements java.io.Serializable {

    // Fields

    private Integer publishmentSystemId;
    private SiteserverNode siteserverNode;
    private String publishmentSystemName;
    private String publishmentSystemType;
    private String auxiliaryTableForContent;
    private String auxiliaryTableForGoods;
    private String auxiliaryTableForBrand;
    private String auxiliaryTableForGovPublic;
    private String auxiliaryTableForGovInteract;
    private String auxiliaryTableForVote;
    private String auxiliaryTableForJob;
    private String isCheckContentUseLevel;
    private Integer checkContentLevel;
    private String publishmentSystemDir;
    private String publishmentSystemUrl;
    private String isHeadquarters;
    private Integer parentPublishmentSystemId;
    private String groupSn;
    private Integer taxis;
    private String settingsXml;
    private String enterpriseUserCode;
    private String geocode;
    private String isTestSite;
    private String isEnabledSite;
    private String isEnterpriseSite;
    private String isTrust;
    private Integer industryId;
    private String propertyNames;
    private Integer businessCircleId;

    // Constructors

    /** default constructor */
    public SiteserverPublishmentSystem() {
    }

    /** full constructor */
    public SiteserverPublishmentSystem(SiteserverNode siteserverNode,
	    String publishmentSystemName, String publishmentSystemType,
	    String auxiliaryTableForContent, String auxiliaryTableForGoods,
	    String auxiliaryTableForBrand, String auxiliaryTableForGovPublic,
	    String auxiliaryTableForGovInteract, String auxiliaryTableForVote,
	    String auxiliaryTableForJob, String isCheckContentUseLevel,
	    Integer checkContentLevel, String publishmentSystemDir,
	    String publishmentSystemUrl, String isHeadquarters,
	    Integer parentPublishmentSystemId, String groupSn, Integer taxis,
	    String settingsXml, String enterpriseUserCode, String geocode,
	    String isTestSite, String isEnabledSite, String isEnterpriseSite,
	    String isTrust, Integer industryId, String propertyNames,
	    Integer businessCircleId) {
	this.siteserverNode = siteserverNode;
	this.publishmentSystemName = publishmentSystemName;
	this.publishmentSystemType = publishmentSystemType;
	this.auxiliaryTableForContent = auxiliaryTableForContent;
	this.auxiliaryTableForGoods = auxiliaryTableForGoods;
	this.auxiliaryTableForBrand = auxiliaryTableForBrand;
	this.auxiliaryTableForGovPublic = auxiliaryTableForGovPublic;
	this.auxiliaryTableForGovInteract = auxiliaryTableForGovInteract;
	this.auxiliaryTableForVote = auxiliaryTableForVote;
	this.auxiliaryTableForJob = auxiliaryTableForJob;
	this.isCheckContentUseLevel = isCheckContentUseLevel;
	this.checkContentLevel = checkContentLevel;
	this.publishmentSystemDir = publishmentSystemDir;
	this.publishmentSystemUrl = publishmentSystemUrl;
	this.isHeadquarters = isHeadquarters;
	this.parentPublishmentSystemId = parentPublishmentSystemId;
	this.groupSn = groupSn;
	this.taxis = taxis;
	this.settingsXml = settingsXml;
	this.enterpriseUserCode = enterpriseUserCode;
	this.geocode = geocode;
	this.isTestSite = isTestSite;
	this.isEnabledSite = isEnabledSite;
	this.isEnterpriseSite = isEnterpriseSite;
	this.isTrust = isTrust;
	this.industryId = industryId;
	this.propertyNames = propertyNames;
	this.businessCircleId = businessCircleId;
    }

    // Property accessors

    public Integer getPublishmentSystemId() {
	return this.publishmentSystemId;
    }

    public void setPublishmentSystemId(Integer publishmentSystemId) {
	this.publishmentSystemId = publishmentSystemId;
    }

    public SiteserverNode getSiteserverNode() {
	return this.siteserverNode;
    }

    public void setSiteserverNode(SiteserverNode siteserverNode) {
	this.siteserverNode = siteserverNode;
    }

    public String getPublishmentSystemName() {
	return this.publishmentSystemName;
    }

    public void setPublishmentSystemName(String publishmentSystemName) {
	this.publishmentSystemName = publishmentSystemName;
    }

    public String getPublishmentSystemType() {
	return this.publishmentSystemType;
    }

    public void setPublishmentSystemType(String publishmentSystemType) {
	this.publishmentSystemType = publishmentSystemType;
    }

    public String getAuxiliaryTableForContent() {
	return this.auxiliaryTableForContent;
    }

    public void setAuxiliaryTableForContent(String auxiliaryTableForContent) {
	this.auxiliaryTableForContent = auxiliaryTableForContent;
    }

    public String getAuxiliaryTableForGoods() {
	return this.auxiliaryTableForGoods;
    }

    public void setAuxiliaryTableForGoods(String auxiliaryTableForGoods) {
	this.auxiliaryTableForGoods = auxiliaryTableForGoods;
    }

    public String getAuxiliaryTableForBrand() {
	return this.auxiliaryTableForBrand;
    }

    public void setAuxiliaryTableForBrand(String auxiliaryTableForBrand) {
	this.auxiliaryTableForBrand = auxiliaryTableForBrand;
    }

    public String getAuxiliaryTableForGovPublic() {
	return this.auxiliaryTableForGovPublic;
    }

    public void setAuxiliaryTableForGovPublic(String auxiliaryTableForGovPublic) {
	this.auxiliaryTableForGovPublic = auxiliaryTableForGovPublic;
    }

    public String getAuxiliaryTableForGovInteract() {
	return this.auxiliaryTableForGovInteract;
    }

    public void setAuxiliaryTableForGovInteract(
	    String auxiliaryTableForGovInteract) {
	this.auxiliaryTableForGovInteract = auxiliaryTableForGovInteract;
    }

    public String getAuxiliaryTableForVote() {
	return this.auxiliaryTableForVote;
    }

    public void setAuxiliaryTableForVote(String auxiliaryTableForVote) {
	this.auxiliaryTableForVote = auxiliaryTableForVote;
    }

    public String getAuxiliaryTableForJob() {
	return this.auxiliaryTableForJob;
    }

    public void setAuxiliaryTableForJob(String auxiliaryTableForJob) {
	this.auxiliaryTableForJob = auxiliaryTableForJob;
    }

    public String getIsCheckContentUseLevel() {
	return this.isCheckContentUseLevel;
    }

    public void setIsCheckContentUseLevel(String isCheckContentUseLevel) {
	this.isCheckContentUseLevel = isCheckContentUseLevel;
    }

    public Integer getCheckContentLevel() {
	return this.checkContentLevel;
    }

    public void setCheckContentLevel(Integer checkContentLevel) {
	this.checkContentLevel = checkContentLevel;
    }

    public String getPublishmentSystemDir() {
	return this.publishmentSystemDir;
    }

    public void setPublishmentSystemDir(String publishmentSystemDir) {
	this.publishmentSystemDir = publishmentSystemDir;
    }

    public String getPublishmentSystemUrl() {
	return this.publishmentSystemUrl;
    }

    public void setPublishmentSystemUrl(String publishmentSystemUrl) {
	this.publishmentSystemUrl = publishmentSystemUrl;
    }

    public String getIsHeadquarters() {
	return this.isHeadquarters;
    }

    public void setIsHeadquarters(String isHeadquarters) {
	this.isHeadquarters = isHeadquarters;
    }

    public Integer getParentPublishmentSystemId() {
	return this.parentPublishmentSystemId;
    }

    public void setParentPublishmentSystemId(Integer parentPublishmentSystemId) {
	this.parentPublishmentSystemId = parentPublishmentSystemId;
    }

    public String getGroupSn() {
	return this.groupSn;
    }

    public void setGroupSn(String groupSn) {
	this.groupSn = groupSn;
    }

    public Integer getTaxis() {
	return this.taxis;
    }

    public void setTaxis(Integer taxis) {
	this.taxis = taxis;
    }

    public String getSettingsXml() {
	return this.settingsXml;
    }

    public void setSettingsXml(String settingsXml) {
	this.settingsXml = settingsXml;
    }

    public String getEnterpriseUserCode() {
	return this.enterpriseUserCode;
    }

    public void setEnterpriseUserCode(String enterpriseUserCode) {
	this.enterpriseUserCode = enterpriseUserCode;
    }

    public String getGeocode() {
	return this.geocode;
    }

    public void setGeocode(String geocode) {
	this.geocode = geocode;
    }

    public String getIsTestSite() {
	return this.isTestSite;
    }

    public void setIsTestSite(String isTestSite) {
	this.isTestSite = isTestSite;
    }

    public String getIsEnabledSite() {
	return this.isEnabledSite;
    }

    public void setIsEnabledSite(String isEnabledSite) {
	this.isEnabledSite = isEnabledSite;
    }

    public String getIsEnterpriseSite() {
	return this.isEnterpriseSite;
    }

    public void setIsEnterpriseSite(String isEnterpriseSite) {
	this.isEnterpriseSite = isEnterpriseSite;
    }

    public String getIsTrust() {
	return this.isTrust;
    }

    public void setIsTrust(String isTrust) {
	this.isTrust = isTrust;
    }

    public Integer getIndustryId() {
	return this.industryId;
    }

    public void setIndustryId(Integer industryId) {
	this.industryId = industryId;
    }

    public String getPropertyNames() {
	return this.propertyNames;
    }

    public void setPropertyNames(String propertyNames) {
	this.propertyNames = propertyNames;
    }

    public Integer getBusinessCircleId() {
	return this.businessCircleId;
    }

    public void setBusinessCircleId(Integer businessCircleId) {
	this.businessCircleId = businessCircleId;
    }

}