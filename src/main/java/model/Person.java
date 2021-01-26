package model;

import java.util.ArrayList;

public class Person {
	private int id;
	private String name;
	private int age;
	private ArrayList<Account> accounts;
	private ArrayList<CreditCard> creditCards;
	private Address address;
	private TypePerson type;
	
	public Person() {
		super();
	}

	public Person(int id, String name, int age, ArrayList<Account> accounts, ArrayList<CreditCard> creditCards,
			Address address, TypePerson type) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.accounts = accounts;
		this.creditCards = creditCards;
		this.address = address;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public ArrayList<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(ArrayList<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public TypePerson getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", accounts=" + accounts + ", creditCards="
				+ creditCards + ", address=" + address + ", type=" + type + "]";
	}
	
	
}
