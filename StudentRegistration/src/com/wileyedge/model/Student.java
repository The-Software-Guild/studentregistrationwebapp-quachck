package com.wileyedge.model;

public class Student {
	private String name;
	private int age;
	private int mobile;
	private String address;
	
	public Student(String name, int age, int mobile, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
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

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", mobile=" + mobile + ", address=" + address + "]";
	}
		
}
