package com.modernjavainaction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Person {
	
	private String firstName;
	private String lastName;
	private Address homeAddress;
	
	Person(String fname, String lname){
		this.firstName = fname;
		this.lastName = lname;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address address) {
		this.homeAddress = address;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(firstName).append("-").append(this.getHomeAddress().getPinCode());
		return sb.toString();
	}
}

class Address{
	private Long pinCode;

	public Long getPinCode() {
		return pinCode;
	}

	public void setPinCode(Long pinCode) {
		this.pinCode = pinCode;
	}
}

class AddressComparator implements Comparator<Address>{

	@Override
	public int compare(Address a1, Address a2) {
		System.out.println("Address compare:" + a1 + "-" + a2);
		return a1.getPinCode().compareTo(a2.getPinCode());
	}

}

public class ComparatorExample{
	public static void main(String[] args) {
		List<Person> family = new ArrayList<>();
		Person person1 = new Person("zSiddhu", "Nalwad");
		Person person2 = new Person("Vishwanath", "Nalwad");

		Address bengaluru = new Address();
		bengaluru.setPinCode(560023L);

		Address gadag = new Address();
		gadag.setPinCode(582101L);
		
		person1.setHomeAddress(bengaluru);
		person2.setHomeAddress(gadag);
		
		family.add(person2);
		family.add(person1);
		
		
		System.out.println(family);

		//family.sort(Comparator.comparing(Person::getFirstName));
			
		//System.out.println(family);
		
		AddressComparator personComparator = new AddressComparator();
		family.sort(Comparator.comparing(Person::getHomeAddress, personComparator ));
		
		System.out.println(family);
		
		Function<String, Integer> strToInt = s -> Integer.parseInt(s);
		int n = strToInt.apply("9");
		System.out.println(n);
	}
}

