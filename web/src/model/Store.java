package model;

public class Store {
	private int storeNo;
	private String storeName;
	private String storePic;
	private String address;
	private String hours;
	private String closedays;
	private int callNumber;
	
	public Store(int storeNo, String storeName, String storePic, 
			String address, String hours, String closedays, int callNumber) {
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storePic = storePic;
		this.address = address;
		this.hours = hours;
		this.closedays = closedays;
		this.callNumber = callNumber;
	}
	
	public int getStoreNo() {
		return storeNo;
	}

	public String getStorePic() {
		return storePic;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getHours() {
		return hours;
	}
	
	public String getClosedays() {
		return closedays;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public int getCallNumber() {
		return callNumber;
	}
	
}
