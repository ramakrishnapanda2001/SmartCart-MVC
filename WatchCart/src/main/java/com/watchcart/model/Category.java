package com.watchcart.model;

import java.util.List;

public class Category {
	private int category_id;
	private String categoryName;
	private String categoryDescription;
	private List<Product> products;
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public Category(int category_id, String categoryName, String categoryDescription) {
		super();
		this.category_id = category_id;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}
	public Category(String categoryName, String categoryDescription, List<Product> products) {
		super();
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.products = products;
	}
	public Category() {
		super();
	}
}
