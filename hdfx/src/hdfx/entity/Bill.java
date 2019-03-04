package hdfx.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Bill entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bill", catalog = "hdfx")

public class Bill implements java.io.Serializable {

	// Fields

	private Integer id;
	private String dfhm;
	private Timestamp thsj;
	private String bfhm;
	private String bfgsd;
	private String dfgsd;
	private Integer thsc;
	private String jh;
	private Integer lac;
	private Integer ci;
	private String zbjbz;
	private String sjfsd;
	private String yys;

	// Constructors

	/** default constructor */
	public Bill() {
	}

	/** full constructor */
	public Bill(String dfhm, Timestamp thsj, String bfhm, String bfgsd, String dfgsd, Integer thsc, String jh,
			Integer lac, Integer ci, String zbjbz, String sjfsd, String yys) {
		this.dfhm = dfhm;
		this.thsj = thsj;
		this.bfhm = bfhm;
		this.bfgsd = bfgsd;
		this.dfgsd = dfgsd;
		this.thsc = thsc;
		this.jh = jh;
		this.lac = lac;
		this.ci = ci;
		this.zbjbz = zbjbz;
		this.sjfsd = sjfsd;
		this.yys = yys;
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

	@Column(name = "dfhm", length = 20)

	public String getDfhm() {
		return this.dfhm;
	}

	public void setDfhm(String dfhm) {
		this.dfhm = dfhm;
	}

	@Column(name = "thsj", length = 19)

	public Timestamp getThsj() {
		return this.thsj;
	}

	public void setThsj(Timestamp thsj) {
		this.thsj = thsj;
	}

	@Column(name = "bfhm", length = 20)

	public String getBfhm() {
		return this.bfhm;
	}

	public void setBfhm(String bfhm) {
		this.bfhm = bfhm;
	}

	@Column(name = "bfgsd", length = 100)

	public String getBfgsd() {
		return this.bfgsd;
	}

	public void setBfgsd(String bfgsd) {
		this.bfgsd = bfgsd;
	}

	@Column(name = "dfgsd", length = 100)

	public String getDfgsd() {
		return this.dfgsd;
	}

	public void setDfgsd(String dfgsd) {
		this.dfgsd = dfgsd;
	}

	@Column(name = "thsc")

	public Integer getThsc() {
		return this.thsc;
	}

	public void setThsc(Integer thsc) {
		this.thsc = thsc;
	}

	@Column(name = "jh", length = 10)

	public String getJh() {
		return this.jh;
	}

	public void setJh(String jh) {
		this.jh = jh;
	}

	@Column(name = "lac")

	public Integer getLac() {
		return this.lac;
	}

	public void setLac(Integer lac) {
		this.lac = lac;
	}

	@Column(name = "ci")

	public Integer getCi() {
		return this.ci;
	}

	public void setCi(Integer ci) {
		this.ci = ci;
	}

	@Column(name = "zbjbz", length = 10)

	public String getZbjbz() {
		return this.zbjbz;
	}

	public void setZbjbz(String zbjbz) {
		this.zbjbz = zbjbz;
	}

	@Column(name = "sjfsd", length = 10)

	public String getSjfsd() {
		return this.sjfsd;
	}

	public void setSjfsd(String sjfsd) {
		this.sjfsd = sjfsd;
	}

	@Column(name = "yys", length = 10)

	public String getYys() {
		return this.yys;
	}

	public void setYys(String yys) {
		this.yys = yys;
	}

}