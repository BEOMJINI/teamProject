package com.basic.projectbook.vo;

public class SaleVO {
	private int no;
	private String isbn;
	private int qty;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "SaleVO [no=" + no + ", isbn=" + isbn + ", qty=" + qty + "]";
	}
	
}
