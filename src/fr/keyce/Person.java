package fr.keyce;

public class Person {

	private String name;

	Integer age; 
	
	
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void incrementAge() {
		age++;
	}
	
	@Override
	public String toString() {
		return name + " a " + age + " ans ";
	}

	public void setName(String name) {
			this.name = name;
	}

}
