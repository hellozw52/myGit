package zw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SsmBook entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ssm_book", catalog = "ssm_db")
public class SsmBook implements java.io.Serializable {

    // Fields

    private Integer id;
    private String isbn;
    private String path;
    private String title;
    private String subtitle;
    private String originalTitle;
    private String marketPrice;
    private String intro;
    private String binding;
    private String pages;
    private String author;
    private String publisher;
    private String catalog;
    private String supply;
    private Integer status;
    private Integer hot;
    private String indate;

    // Constructors

    /** default constructor */
    public SsmBook() {
    }

    /** minimal constructor */
    public SsmBook(String isbn) {
	this.isbn = isbn;
    }

    /** full constructor */
    public SsmBook(String isbn, String path, String title, String subtitle,
	    String originalTitle, String marketPrice, String intro,
	    String binding, String pages, String author, String publisher,
	    String catalog, String supply, Integer status, Integer hot,
	    String indate) {
	this.isbn = isbn;
	this.path = path;
	this.title = title;
	this.subtitle = subtitle;
	this.originalTitle = originalTitle;
	this.marketPrice = marketPrice;
	this.intro = intro;
	this.binding = binding;
	this.pages = pages;
	this.author = author;
	this.publisher = publisher;
	this.catalog = catalog;
	this.supply = supply;
	this.status = status;
	this.hot = hot;
	this.indate = indate;
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

    @Column(name = "isbn", nullable = false, length = 15)
    public String getIsbn() {
	return this.isbn;
    }

    public void setIsbn(String isbn) {
	this.isbn = isbn;
    }

    @Column(name = "path", length = 150)
    public String getPath() {
	return this.path;
    }

    public void setPath(String path) {
	this.path = path;
    }

    @Column(name = "title", length = 200)
    public String getTitle() {
	return this.title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    @Column(name = "subtitle", length = 200)
    public String getSubtitle() {
	return this.subtitle;
    }

    public void setSubtitle(String subtitle) {
	this.subtitle = subtitle;
    }

    @Column(name = "originalTitle", length = 200)
    public String getOriginalTitle() {
	return this.originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
	this.originalTitle = originalTitle;
    }

    @Column(name = "marketPrice", length = 10)
    public String getMarketPrice() {
	return this.marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
	this.marketPrice = marketPrice;
    }

    @Column(name = "intro", length = 65535)
    public String getIntro() {
	return this.intro;
    }

    public void setIntro(String intro) {
	this.intro = intro;
    }

    @Column(name = "binding", length = 20)
    public String getBinding() {
	return this.binding;
    }

    public void setBinding(String binding) {
	this.binding = binding;
    }

    @Column(name = "pages", length = 10)
    public String getPages() {
	return this.pages;
    }

    public void setPages(String pages) {
	this.pages = pages;
    }

    @Column(name = "author", length = 200)
    public String getAuthor() {
	return this.author;
    }

    public void setAuthor(String author) {
	this.author = author;
    }

    @Column(name = "publisher", length = 100)
    public String getPublisher() {
	return this.publisher;
    }

    public void setPublisher(String publisher) {
	this.publisher = publisher;
    }

    @Column(name = "catalog", length = 65535)
    public String getCatalog() {
	return this.catalog;
    }

    public void setCatalog(String catalog) {
	this.catalog = catalog;
    }

    @Column(name = "supply", length = 20)
    public String getSupply() {
	return this.supply;
    }

    public void setSupply(String supply) {
	this.supply = supply;
    }

    @Column(name = "status")
    public Integer getStatus() {
	return this.status;
    }

    public void setStatus(Integer status) {
	this.status = status;
    }

    @Column(name = "hot")
    public Integer getHot() {
	return this.hot;
    }

    public void setHot(Integer hot) {
	this.hot = hot;
    }

    @Column(name = "indate", length = 50)
    public String getIndate() {
	return this.indate;
    }

    public void setIndate(String indate) {
	this.indate = indate;
    }

    @Override
    public String toString() {
	return "SsmBook [id=" + id + ", isbn=" + isbn + ", path=" + path
		+ ", title=" + title + ", subtitle=" + subtitle
		+ ", originalTitle=" + originalTitle + ", marketPrice="
		+ marketPrice + ", intro=" + intro + ", binding=" + binding
		+ ", pages=" + pages + ", author=" + author + ", publisher="
		+ publisher + ", catalog=" + catalog + ", supply=" + supply
		+ ", status=" + status + ", hot=" + hot + ", indate=" + indate
		+ "]";
    }

}