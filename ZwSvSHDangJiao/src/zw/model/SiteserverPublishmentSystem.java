package zw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SiteserverPublishmentSystem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "siteserver_PublishmentSystem", schema = "dbo", catalog = "hnyxnew")
public class SiteserverPublishmentSystem implements java.io.Serializable {

    // Fields

    private Integer publishmentSystemId;
//    private SiteserverNode siteserverNode;
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
    public SiteserverPublishmentSystem(
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
//	this.siteserverNode = siteserverNode;
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
    @Id
    @GeneratedValue
    @Column(name = "PublishmentSystemID", unique = true, nullable = false)
    public Integer getPublishmentSystemId() {
	return this.publishmentSystemId;
    }

    public void setPublishmentSystemId(Integer publishmentSystemId) {
	this.publishmentSystemId = publishmentSystemId;
    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "PublishmentSystemID", unique = true, nullable = false, insertable = false, updatable = false)
//    public SiteserverNode getSiteserverNode() {
//	return this.siteserverNode;
//    }
//
//    public void setSiteserverNode(SiteserverNode siteserverNode) {
//	this.siteserverNode = siteserverNode;
//    }

    @Column(name = "PublishmentSystemName", nullable = false)
    public String getPublishmentSystemName() {
	return this.publishmentSystemName;
    }

    public void setPublishmentSystemName(String publishmentSystemName) {
	this.publishmentSystemName = publishmentSystemName;
    }

    @Column(name = "PublishmentSystemType", nullable = false, length = 50)
    public String getPublishmentSystemType() {
	return this.publishmentSystemType;
    }

    public void setPublishmentSystemType(String publishmentSystemType) {
	this.publishmentSystemType = publishmentSystemType;
    }

    @Column(name = "AuxiliaryTableForContent", nullable = false, length = 50)
    public String getAuxiliaryTableForContent() {
	return this.auxiliaryTableForContent;
    }

    public void setAuxiliaryTableForContent(String auxiliaryTableForContent) {
	this.auxiliaryTableForContent = auxiliaryTableForContent;
    }

    @Column(name = "AuxiliaryTableForGoods", nullable = false, length = 50)
    public String getAuxiliaryTableForGoods() {
	return this.auxiliaryTableForGoods;
    }

    public void setAuxiliaryTableForGoods(String auxiliaryTableForGoods) {
	this.auxiliaryTableForGoods = auxiliaryTableForGoods;
    }

    @Column(name = "AuxiliaryTableForBrand", nullable = false, length = 50)
    public String getAuxiliaryTableForBrand() {
	return this.auxiliaryTableForBrand;
    }

    public void setAuxiliaryTableForBrand(String auxiliaryTableForBrand) {
	this.auxiliaryTableForBrand = auxiliaryTableForBrand;
    }

    @Column(name = "AuxiliaryTableForGovPublic", nullable = false, length = 50)
    public String getAuxiliaryTableForGovPublic() {
	return this.auxiliaryTableForGovPublic;
    }

    public void setAuxiliaryTableForGovPublic(String auxiliaryTableForGovPublic) {
	this.auxiliaryTableForGovPublic = auxiliaryTableForGovPublic;
    }

    @Column(name = "AuxiliaryTableForGovInteract", nullable = false, length = 50)
    public String getAuxiliaryTableForGovInteract() {
	return this.auxiliaryTableForGovInteract;
    }

    public void setAuxiliaryTableForGovInteract(
	    String auxiliaryTableForGovInteract) {
	this.auxiliaryTableForGovInteract = auxiliaryTableForGovInteract;
    }

    @Column(name = "AuxiliaryTableForVote", nullable = false, length = 50)
    public String getAuxiliaryTableForVote() {
	return this.auxiliaryTableForVote;
    }

    public void setAuxiliaryTableForVote(String auxiliaryTableForVote) {
	this.auxiliaryTableForVote = auxiliaryTableForVote;
    }

    @Column(name = "AuxiliaryTableForJob", nullable = false, length = 50)
    public String getAuxiliaryTableForJob() {
	return this.auxiliaryTableForJob;
    }

    public void setAuxiliaryTableForJob(String auxiliaryTableForJob) {
	this.auxiliaryTableForJob = auxiliaryTableForJob;
    }

    @Column(name = "IsCheckContentUseLevel", nullable = false, length = 18)
    public String getIsCheckContentUseLevel() {
	return this.isCheckContentUseLevel;
    }

    public void setIsCheckContentUseLevel(String isCheckContentUseLevel) {
	this.isCheckContentUseLevel = isCheckContentUseLevel;
    }

    @Column(name = "CheckContentLevel", nullable = false)
    public Integer getCheckContentLevel() {
	return this.checkContentLevel;
    }

    public void setCheckContentLevel(Integer checkContentLevel) {
	this.checkContentLevel = checkContentLevel;
    }

    @Column(name = "PublishmentSystemDir", nullable = false, length = 50)
    public String getPublishmentSystemDir() {
	return this.publishmentSystemDir;
    }

    public void setPublishmentSystemDir(String publishmentSystemDir) {
	this.publishmentSystemDir = publishmentSystemDir;
    }

    @Column(name = "PublishmentSystemUrl", nullable = false, length = 200)
    public String getPublishmentSystemUrl() {
	return this.publishmentSystemUrl;
    }

    public void setPublishmentSystemUrl(String publishmentSystemUrl) {
	this.publishmentSystemUrl = publishmentSystemUrl;
    }

    @Column(name = "IsHeadquarters", nullable = false, length = 18)
    public String getIsHeadquarters() {
	return this.isHeadquarters;
    }

    public void setIsHeadquarters(String isHeadquarters) {
	this.isHeadquarters = isHeadquarters;
    }

    @Column(name = "ParentPublishmentSystemID", nullable = false)
    public Integer getParentPublishmentSystemId() {
	return this.parentPublishmentSystemId;
    }

    public void setParentPublishmentSystemId(Integer parentPublishmentSystemId) {
	this.parentPublishmentSystemId = parentPublishmentSystemId;
    }

    @Column(name = "GroupSN", nullable = false)
    public String getGroupSn() {
	return this.groupSn;
    }

    public void setGroupSn(String groupSn) {
	this.groupSn = groupSn;
    }

    @Column(name = "Taxis", nullable = false)
    public Integer getTaxis() {
	return this.taxis;
    }

    public void setTaxis(Integer taxis) {
	this.taxis = taxis;
    }

    @Column(name = "SettingsXML", nullable = false)
    public String getSettingsXml() {
	return this.settingsXml;
    }

    public void setSettingsXml(String settingsXml) {
	this.settingsXml = settingsXml;
    }

    @Column(name = "EnterpriseUserCode", nullable = false)
    public String getEnterpriseUserCode() {
	return this.enterpriseUserCode;
    }

    public void setEnterpriseUserCode(String enterpriseUserCode) {
	this.enterpriseUserCode = enterpriseUserCode;
    }

    @Column(name = "GEOCode", nullable = false)
    public String getGeocode() {
	return this.geocode;
    }

    public void setGeocode(String geocode) {
	this.geocode = geocode;
    }

    @Column(name = "IsTestSite", nullable = false, length = 18)
    public String getIsTestSite() {
	return this.isTestSite;
    }

    public void setIsTestSite(String isTestSite) {
	this.isTestSite = isTestSite;
    }

    @Column(name = "IsEnabledSite", nullable = false, length = 18)
    public String getIsEnabledSite() {
	return this.isEnabledSite;
    }

    public void setIsEnabledSite(String isEnabledSite) {
	this.isEnabledSite = isEnabledSite;
    }

    @Column(name = "IsEnterpriseSite", nullable = false, length = 18)
    public String getIsEnterpriseSite() {
	return this.isEnterpriseSite;
    }

    public void setIsEnterpriseSite(String isEnterpriseSite) {
	this.isEnterpriseSite = isEnterpriseSite;
    }

    @Column(name = "IsTrust", nullable = false, length = 18)
    public String getIsTrust() {
	return this.isTrust;
    }

    public void setIsTrust(String isTrust) {
	this.isTrust = isTrust;
    }

    @Column(name = "IndustryID", nullable = false)
    public Integer getIndustryId() {
	return this.industryId;
    }

    public void setIndustryId(Integer industryId) {
	this.industryId = industryId;
    }

    @Column(name = "PropertyNames", nullable = false)
    public String getPropertyNames() {
	return this.propertyNames;
    }

    public void setPropertyNames(String propertyNames) {
	this.propertyNames = propertyNames;
    }

    @Column(name = "BusinessCircleID", nullable = false)
    public Integer getBusinessCircleId() {
	return this.businessCircleId;
    }

    public void setBusinessCircleId(Integer businessCircleId) {
	this.businessCircleId = businessCircleId;
    }

}