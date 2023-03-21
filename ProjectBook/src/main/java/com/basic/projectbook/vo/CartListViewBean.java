package com.basic.projectbook.vo;

public class CartListViewBean {
	private String img;
	private String title;
	private String author;
	private int cqty;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getCqty() {
		return cqty;
	}
	public void setCqty(int cqty) {
		this.cqty = cqty;
	}
	@Override
	public String toString() {
		return "CartListViewBean [img=" + img + ", title=" + title + ", author=" + author + ", cqty=" + cqty + "]";
	}
	
	
	
}
