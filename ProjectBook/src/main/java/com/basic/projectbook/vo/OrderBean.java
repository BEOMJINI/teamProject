package com.basic.projectbook.vo;

public class OrderBean {
	private String discount;
	private String qty;
	private String img;
	private String title;
	private String isbn;
	private String status;
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderBean [discount=" + discount + ", qty=" + qty + ", img=" + img + ", title=" + title + ", isbn="
				+ isbn + ", status=" + status + "]";
	}
	
}
