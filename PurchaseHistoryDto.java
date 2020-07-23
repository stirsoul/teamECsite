package jp.co.internous.ocean.model.domain.dto;

import java.sql.Timestamp;

public class PurchaseHistoryDto {
	
	private int id;
	
	private int userId;
	
	private int productId;
	
	private int productCount;
	
	private int price;
	
	private int destinationId;
	
	private byte status;
	
	private Timestamp purchasedAt;
	
	private Timestamp createdAt;
	
	private Timestamp updateAt;
	
	private String productName;
	
	private String familyName;
	
	private String firstName;
	
	private String address;
	
	public PurchaseHistoryDto() {}

	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUseId() {
		return userId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	public int getProductCount() {
		return productCount;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}
	public int getDestinationId() {
		return destinationId;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public byte getStatus() {
		return status;
	}
	public void setPurchasedAt(Timestamp purchasedAt) {
		this.purchasedAt = purchasedAt;
	}
	public Timestamp getPurchasedAt() {
		return purchasedAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}
	public Timestamp getUpdateAt() {
		return updateAt;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductName() {
		return productName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
}
