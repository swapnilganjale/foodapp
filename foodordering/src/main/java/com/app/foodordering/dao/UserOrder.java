package com.app.foodordering.dao;

import java.util.List;

public class UserOrder {
	
	private Integer tableid;
	private List<ProductDetais> productDetais;
	
	public UserOrder() {
		
	}


	public Integer getTableid() {
		return tableid;
	}


	public void setTableid(Integer tableid) {
		this.tableid = tableid;
	}


	public List<ProductDetais> getProductDetais() {
		return productDetais;
	}


	public void setProductDetais(List<ProductDetais> productDetais) {
		this.productDetais = productDetais;
	}


	@Override
	public String toString() {
		return "UserOrder [tableid=" + tableid + ", productDetais=" + productDetais + "]";
	}

	
	

	
	
}

