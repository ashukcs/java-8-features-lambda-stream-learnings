package com.tachtalk.stream.map_flatmap;

import java.util.List;

public class Customer {
	private String id;
	private String name;
	private String email;
	private List<String> phones;

	public Customer() {

	}

	public Customer(String id, String name, String email, List<String> phones) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phones = phones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getPhones() {
		return phones;
	}

	public void setPhones(List<String> phones) {
		this.phones = phones;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phones=" + phones + "]";
	}

}
