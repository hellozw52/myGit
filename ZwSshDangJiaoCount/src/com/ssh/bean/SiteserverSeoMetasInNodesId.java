package com.ssh.bean;

/**
 * SiteserverSeoMetasInNodesId entity. @author MyEclipse Persistence Tools
 */

public class SiteserverSeoMetasInNodesId implements java.io.Serializable {

    // Fields

    private Integer nodeId;
    private String isChannel;
    private SiteserverSeoMeta siteserverSeoMeta;

    // Constructors

    /** default constructor */
    public SiteserverSeoMetasInNodesId() {
    }

    /** full constructor */
    public SiteserverSeoMetasInNodesId(Integer nodeId, String isChannel,
	    SiteserverSeoMeta siteserverSeoMeta) {
	this.nodeId = nodeId;
	this.isChannel = isChannel;
	this.siteserverSeoMeta = siteserverSeoMeta;
    }

    // Property accessors

    public Integer getNodeId() {
	return this.nodeId;
    }

    public void setNodeId(Integer nodeId) {
	this.nodeId = nodeId;
    }

    public String getIsChannel() {
	return this.isChannel;
    }

    public void setIsChannel(String isChannel) {
	this.isChannel = isChannel;
    }

    public SiteserverSeoMeta getSiteserverSeoMeta() {
	return this.siteserverSeoMeta;
    }

    public void setSiteserverSeoMeta(SiteserverSeoMeta siteserverSeoMeta) {
	this.siteserverSeoMeta = siteserverSeoMeta;
    }

    public boolean equals(Object other) {
	if ((this == other))
	    return true;
	if ((other == null))
	    return false;
	if (!(other instanceof SiteserverSeoMetasInNodesId))
	    return false;
	SiteserverSeoMetasInNodesId castOther = (SiteserverSeoMetasInNodesId) other;

	return ((this.getNodeId() == castOther.getNodeId()) || (this
		.getNodeId() != null && castOther.getNodeId() != null && this
		.getNodeId().equals(castOther.getNodeId())))
		&& ((this.getIsChannel() == castOther.getIsChannel()) || (this
			.getIsChannel() != null
			&& castOther.getIsChannel() != null && this
			.getIsChannel().equals(castOther.getIsChannel())))
		&& ((this.getSiteserverSeoMeta() == castOther
			.getSiteserverSeoMeta()) || (this
			.getSiteserverSeoMeta() != null
			&& castOther.getSiteserverSeoMeta() != null && this
			.getSiteserverSeoMeta().equals(
				castOther.getSiteserverSeoMeta())));
    }

    public int hashCode() {
	int result = 17;

	result = 37 * result
		+ (getNodeId() == null ? 0 : this.getNodeId().hashCode());
	result = 37 * result
		+ (getIsChannel() == null ? 0 : this.getIsChannel().hashCode());
	result = 37
		* result
		+ (getSiteserverSeoMeta() == null ? 0 : this
			.getSiteserverSeoMeta().hashCode());
	return result;
    }

}