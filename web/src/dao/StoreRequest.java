package dao;

public class StoreRequest {
	private int storeNo;
	private String storeName;
	private String storePic;
	private String address;
	private String hours;
	private String closedays;
	private int callNumber;
	
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStorePic() {
		return storePic;
	}
	public void setStorePic(String storePic) {
		this.storePic = storePic;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public String getClosedays() {
		return closedays;
	}
	public void setClosedays(String closedays) {
		this.closedays = closedays;
	}
	public int getCallNumber() {
		return callNumber;
	}
	public void setCallNumber(int callNumber) {
		this.callNumber = callNumber;
	}
	
	
}
