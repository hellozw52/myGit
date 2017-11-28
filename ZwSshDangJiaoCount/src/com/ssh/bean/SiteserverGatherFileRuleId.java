package com.ssh.bean;

/**
 * SiteserverGatherFileRuleId entity. @author MyEclipse Persistence Tools
 */

public class SiteserverGatherFileRuleId implements java.io.Serializable {

    // Fields

    private String gatherRuleName;
    private SiteserverNode siteserverNode;

    // Constructors

    /** default constructor */
    public SiteserverGatherFileRuleId() {
    }

    /** full constructor */
    public SiteserverGatherFileRuleId(String gatherRuleName,
	    SiteserverNode siteserverNode) {
	this.gatherRuleName = gatherRuleName;
	this.siteserverNode = siteserverNode;
    }

    // Property accessors

    public String getGatherRuleName() {
	return this.gatherRuleName;
    }

    public void setGatherRuleName(String gatherRuleName) {
	this.gatherRuleName = gatherRuleName;
    }

    public SiteserverNode getSiteserverNode() {
	return this.siteserverNode;
    }

    public void setSiteserverNode(SiteserverNode siteserverNode) {
	this.siteserverNode = siteserverNode;
    }

    public boolean equals(Object other) {
	if ((this == other))
	    return true;
	if ((other == null))
	    return false;
	if (!(other instanceof SiteserverGatherFileRuleId))
	    return false;
	SiteserverGatherFileRuleId castOther = (SiteserverGatherFileRuleId) other;

	return ((this.getGatherRuleName() == castOther.getGatherRuleName()) || (this
		.getGatherRuleName() != null
		&& castOther.getGatherRuleName() != null && this
		.getGatherRuleName().equals(castOther.getGatherRuleName())))
		&& ((this.getSiteserverNode() == castOther.getSiteserverNode()) || (this
			.getSiteserverNode() != null
			&& castOther.getSiteserverNode() != null && this
			.getSiteserverNode().equals(
				castOther.getSiteserverNode())));
    }

    public int hashCode() {
	int result = 17;

	result = 37
		* result
		+ (getGatherRuleName() == null ? 0 : this.getGatherRuleName()
			.hashCode());
	result = 37
		* result
		+ (getSiteserverNode() == null ? 0 : this.getSiteserverNode()
			.hashCode());
	return result;
    }

}