package com.example.java8.customclass;

public class Person {

	private String firstName;
	private String gender;
	private Integer age;
	public Person(String firstName, String gender, Integer age) {
		super();
		this.firstName = firstName;
		this.gender = gender;
		this.age = age;
	}
	
	public boolean equals(Object other) {
            return ((Person) other).getFirstName().equals(this.getFirstName());
    }
    public int hashCode() {
        return this.getFirstName().hashCode();
    }
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
}
