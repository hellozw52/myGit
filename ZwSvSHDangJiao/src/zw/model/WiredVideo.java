package zw.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * WiredVideo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="wired_Video"
    ,schema="dbo"
    ,catalog="hnyxnew"
)

public class WiredVideo  implements java.io.Serializable {


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
    public WiredVideo(Integer videoId, Integer publishmentSystemId, Integer providerId, Timestamp createDate, Timestamp editDate, Integer taxis, Timestamp licensingStart, Timestamp licensingEnd, Integer productId) {
        this.videoId = videoId;
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
    public WiredVideo(Integer videoId, Integer publishmentSystemId, String assetName, String assetId, String assetTmpId, String assetTmpId1, String assetTmpId2, String assetClass, Integer providerId, String providerName, String providerCode, String product, String description, Timestamp createDate, Timestamp editDate, String versionMajor, String versionMinor, Integer taxis, String addUser, String videoPath, String videoName, String xmlpath, String coverPath, String videoIntro, String state, String ftpVideoPath, String titbitsPath, String additionXml, String ftpAdipath, String runTime, String displayRunTime, Timestamp licensingStart, Timestamp licensingEnd, String isBatch, String batchProcess, Integer productId) {
        this.videoId = videoId;
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
    @Id 
    
    @Column(name="VideoId", unique=true, nullable=false)

    public Integer getVideoId() {
        return this.videoId;
    }
    
    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }
    
    @Column(name="PublishmentSystemId", nullable=false)

    public Integer getPublishmentSystemId() {
        return this.publishmentSystemId;
    }
    
    public void setPublishmentSystemId(Integer publishmentSystemId) {
        this.publishmentSystemId = publishmentSystemId;
    }
    
    @Column(name="AssetName")

    public String getAssetName() {
        return this.assetName;
    }
    
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
    
    @Column(name="AssetId")

    public String getAssetId() {
        return this.assetId;
    }
    
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }
    
    @Column(name="AssetTmpId")

    public String getAssetTmpId() {
        return this.assetTmpId;
    }
    
    public void setAssetTmpId(String assetTmpId) {
        this.assetTmpId = assetTmpId;
    }
    
    @Column(name="AssetTmpId1")

    public String getAssetTmpId1() {
        return this.assetTmpId1;
    }
    
    public void setAssetTmpId1(String assetTmpId1) {
        this.assetTmpId1 = assetTmpId1;
    }
    
    @Column(name="AssetTmpId2")

    public String getAssetTmpId2() {
        return this.assetTmpId2;
    }
    
    public void setAssetTmpId2(String assetTmpId2) {
        this.assetTmpId2 = assetTmpId2;
    }
    
    @Column(name="AssetClass")

    public String getAssetClass() {
        return this.assetClass;
    }
    
    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }
    
    @Column(name="ProviderId", nullable=false)

    public Integer getProviderId() {
        return this.providerId;
    }
    
    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }
    
    @Column(name="ProviderName")

    public String getProviderName() {
        return this.providerName;
    }
    
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
    
    @Column(name="ProviderCode")

    public String getProviderCode() {
        return this.providerCode;
    }
    
    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }
    
    @Column(name="Product")

    public String getProduct() {
        return this.product;
    }
    
    public void setProduct(String product) {
        this.product = product;
    }
    
    @Column(name="Description")

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="CreateDate", nullable=false, length=23)

    public Timestamp getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    
    @Column(name="EditDate", nullable=false, length=23)

    public Timestamp getEditDate() {
        return this.editDate;
    }
    
    public void setEditDate(Timestamp editDate) {
        this.editDate = editDate;
    }
    
    @Column(name="VersionMajor")

    public String getVersionMajor() {
        return this.versionMajor;
    }
    
    public void setVersionMajor(String versionMajor) {
        this.versionMajor = versionMajor;
    }
    
    @Column(name="VersionMinor")

    public String getVersionMinor() {
        return this.versionMinor;
    }
    
    public void setVersionMinor(String versionMinor) {
        this.versionMinor = versionMinor;
    }
    
    @Column(name="Taxis", nullable=false)

    public Integer getTaxis() {
        return this.taxis;
    }
    
    public void setTaxis(Integer taxis) {
        this.taxis = taxis;
    }
    
    @Column(name="AddUser")

    public String getAddUser() {
        return this.addUser;
    }
    
    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }
    
    @Column(name="VideoPath")

    public String getVideoPath() {
        return this.videoPath;
    }
    
    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }
    
    @Column(name="VideoName")

    public String getVideoName() {
        return this.videoName;
    }
    
    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }
    
    @Column(name="XMLPath")

    public String getXmlpath() {
        return this.xmlpath;
    }
    
    public void setXmlpath(String xmlpath) {
        this.xmlpath = xmlpath;
    }
    
    @Column(name="CoverPath")

    public String getCoverPath() {
        return this.coverPath;
    }
    
    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }
    
    @Column(name="VideoIntro")

    public String getVideoIntro() {
        return this.videoIntro;
    }
    
    public void setVideoIntro(String videoIntro) {
        this.videoIntro = videoIntro;
    }
    
    @Column(name="State")

    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    @Column(name="FtpVideoPath")

    public String getFtpVideoPath() {
        return this.ftpVideoPath;
    }
    
    public void setFtpVideoPath(String ftpVideoPath) {
        this.ftpVideoPath = ftpVideoPath;
    }
    
    @Column(name="TitbitsPath")

    public String getTitbitsPath() {
        return this.titbitsPath;
    }
    
    public void setTitbitsPath(String titbitsPath) {
        this.titbitsPath = titbitsPath;
    }
    
    @Column(name="AdditionXml")

    public String getAdditionXml() {
        return this.additionXml;
    }
    
    public void setAdditionXml(String additionXml) {
        this.additionXml = additionXml;
    }
    
    @Column(name="FtpADIPath")

    public String getFtpAdipath() {
        return this.ftpAdipath;
    }
    
    public void setFtpAdipath(String ftpAdipath) {
        this.ftpAdipath = ftpAdipath;
    }
    
    @Column(name="RunTime")

    public String getRunTime() {
        return this.runTime;
    }
    
    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }
    
    @Column(name="DisplayRunTime")

    public String getDisplayRunTime() {
        return this.displayRunTime;
    }
    
    public void setDisplayRunTime(String displayRunTime) {
        this.displayRunTime = displayRunTime;
    }
    
    @Column(name="LicensingStart", nullable=false, length=23)

    public Timestamp getLicensingStart() {
        return this.licensingStart;
    }
    
    public void setLicensingStart(Timestamp licensingStart) {
        this.licensingStart = licensingStart;
    }
    
    @Column(name="LicensingEnd", nullable=false, length=23)

    public Timestamp getLicensingEnd() {
        return this.licensingEnd;
    }
    
    public void setLicensingEnd(Timestamp licensingEnd) {
        this.licensingEnd = licensingEnd;
    }
    
    @Column(name="IsBatch")

    public String getIsBatch() {
        return this.isBatch;
    }
    
    public void setIsBatch(String isBatch) {
        this.isBatch = isBatch;
    }
    
    @Column(name="BatchProcess")

    public String getBatchProcess() {
        return this.batchProcess;
    }
    
    public void setBatchProcess(String batchProcess) {
        this.batchProcess = batchProcess;
    }
    
    @Column(name="ProductId", nullable=false)

    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
   








}