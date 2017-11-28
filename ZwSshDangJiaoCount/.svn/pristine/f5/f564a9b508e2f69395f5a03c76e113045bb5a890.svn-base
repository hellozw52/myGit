package com.ssh.bean;

/**
 * SiteserverSystemPermissionsId entity. @author MyEclipse Persistence Tools
 */

public class SiteserverSystemPermissionsId implements java.io.Serializable {

    // Fields

    private String roleName;
    private SiteserverNode siteserverNode;

    // Constructors

    /** default constructor */
    public SiteserverSystemPermissionsId() {
    }

    /** full constructor */
    public SiteserverSystemPermissionsId(String roleName,
	    SiteserverNode siteserverNode) {
	this.roleName = roleName;
	this.siteserverNode = siteserverNode;
    }

    // Property accessors

    public String getRoleName() {
	return this.roleName;
    }

    public void setRoleName(String roleName) {
	this.roleName = roleName;
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
	if (!(other instanceof SiteserverSystemPermissionsId))
	    return false;
	SiteserverSystemPermissionsId castOther = (SiteserverSystemPermissionsId) other;

	return ((this.getRoleName() == castOther.getRoleName()) || (this
		.getRoleName() != null && castOther.getRoleName() != null && this
		.getRoleName().equals(castOther.getRoleName())))
		&& ((this.getSiteserverNode() == castOther.getSiteserverNode()) || (this
			.getSiteserverNode() != null
			&& castOther.getSiteserverNode() != null && this
			.getSiteserverNode().equals(
				castOther.getSiteserverNode())));
    }

    public int hashCode() {
	int result = 17;

	result = 37 * result
		+ (getRoleName() == null ? 0 : this.getRoleName().hashCode());
	result = 37
		* result
		+ (getSiteserverNode() == null ? 0 : this.getSiteserverNode()
			.hashCode());
	return result;
    }

}