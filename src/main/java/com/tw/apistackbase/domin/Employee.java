package com.tw.apistackbase.domin;

public class Employee {
	public Employee(int id, String name, int age, String gender) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Employee() {
	}
	private int id;
	private String name;
	private int age;
	private String gender;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}
	public void setId(int id) {
		this.id = id;
		
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge( int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
