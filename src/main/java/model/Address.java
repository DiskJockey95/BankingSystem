package model;

public class Address {

	private int id;
	private int streetAddress;
	private String street;
	private String postalCode;
	private String city;
	private String province;

	public Address() {
		super();
	}

	public Address(int id, int streetAddress, String street, String postalCode, String city, String province) {
		super();
		this.id = id;
		this.streetAddress = streetAddress;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.province = province;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(int streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetAddress=" + streetAddress + ", street=" + street + ", postalCode="
				+ postalCode + ", city=" + city + ", province=" + province + "]";
	}

	public void moveTo(int streetAddress, String street, String postalCode, String city, String province) {
		this.streetAddress = streetAddress;
		this.street = street;
		this.postalCode = postalCode;
		this.province = province;
	}
}
