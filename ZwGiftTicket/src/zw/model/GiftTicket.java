package zw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GiftTicket entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "gift_ticket", catalog = "stb")

public class GiftTicket implements java.io.Serializable {

    // Fields

    private Integer id;
    private String getTvn;
    private String useTvn;
    private Integer ticketNo;
    private Integer entityId;
    private Integer status;

    // Constructors

    /** default constructor */
    public GiftTicket() {
    }

    /** full constructor */
    public GiftTicket(String getTvn, String useTvn, Integer ticketNo,
	    Integer entityId, Integer status) {
	this.getTvn = getTvn;
	this.useTvn = useTvn;
	this.ticketNo = ticketNo;
	this.entityId = entityId;
	this.status = status;
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

    @Column(name = "get_tvn", length = 20)

    public String getGetTvn() {
	return this.getTvn;
    }

    public void setGetTvn(String getTvn) {
	this.getTvn = getTvn;
    }

    @Column(name = "use_tvn", length = 20)

    public String getUseTvn() {
	return this.useTvn;
    }

    public void setUseTvn(String useTvn) {
	this.useTvn = useTvn;
    }

    @Column(name = "ticket_no")

    public Integer getTicketNo() {
	return this.ticketNo;
    }

    public void setTicketNo(Integer ticketNo) {
	this.ticketNo = ticketNo;
    }

    @Column(name = "entity_id")

    public Integer getEntityId() {
	return this.entityId;
    }

    public void setEntityId(Integer entityId) {
	this.entityId = entityId;
    }

    @Column(name = "status")

    public Integer getStatus() {
	return this.status;
    }

    public void setStatus(Integer status) {
	this.status = status;
    }

}