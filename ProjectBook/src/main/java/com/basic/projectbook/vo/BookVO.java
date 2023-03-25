package com.basic.projectbook.vo;

public class BookVO {
private int no;
private String title;
private String image;
private String author;
private String discount;
private String publisher;
private String pubdate;
private String isbn;
private String description;
private String genre;
private String country;
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getDiscount() {
	return discount;
}
public void setDiscount(String discount) {
	this.discount = discount;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public String getPubdate() {
	return pubdate;
}
public void setPubdate(String pubdate) {
	this.pubdate = pubdate;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
@Override
public String toString() {
	return "BookVO [no=" + no + ", title=" + title + ", image=" + image + ", author=" + author + ", discount="
			+ discount + ", publisher=" + publisher + ", pubdate=" + pubdate + ", isbn=" + isbn + ", description="
			+ description + ", genre=" + genre + ", country=" + country + "]";
}






}
