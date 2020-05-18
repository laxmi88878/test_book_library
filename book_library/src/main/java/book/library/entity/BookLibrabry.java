package book.library.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK_LIBRARY_DETAILS")
public class BookLibrabry implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "BOOK_ID")
	private Long id;
	
	@Column(name = "BOOK_REF_ID")
	private String bookRefNumber;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@Column(name = "BOOK_AUTHOR")
	private String bookAuthor;
	
	@Column(name = "BOOK_TYPE")
	private String bookType;
	
	@Column(name = "CREATED_DATE", length=7)
	private Date createdDate;
	
	@Column(name = "CREATED_BY", length=50)
    private String createdBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookRefNumber() {
		return bookRefNumber;
	}

	public void setBookRefNumber(String bookRefNumber) {
		this.bookRefNumber = bookRefNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
	


}
