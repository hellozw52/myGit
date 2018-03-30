package zw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SsmUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ssm_user", catalog = "ssm_db")
public class SsmUser implements java.io.Serializable {

    // Fields

    private Integer id;
    private String userName;
    private String password;
    private String roleName;

    // Constructors

    /** default constructor */
    public SsmUser() {
    }

    /** full constructor */
    public SsmUser(String userName, String password, String roleName) {
	this.userName = userName;
	this.password = password;
	this.roleName = roleName;
    }

    // Property accessors
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
	return this.id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Column(name = "userName", length = 100)
    public String getUserName() {
	return this.userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    @Column(name = "password", length = 100)
    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Column(name = "roleName", length = 20)
    public String getRoleName() {
	return this.roleName;
    }

    public void setRoleName(String roleName) {
	this.roleName = roleName;
    }

}