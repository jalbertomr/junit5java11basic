package com.bext.junit5java11basic.model;

public class TolkeinCharacter {
	private int age;
	private String name;
	private Race race;
	
	private long notAccessibleField = System.currentTimeMillis();

	public TolkeinCharacter(String name, int age,  Race race) {
		super();
		this.age = age;
		this.name = name;
		this.race = race;
	}

	public String getName() {
		return name;
	}

	public Race getRace() {
		return race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Age is not Allowed to be smaller than zero");
		}
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TolkeinCharacter other = (TolkeinCharacter) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (race != other.race)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TolkeingCharacter [age=" + age + ", name=" + name + "]";
	}
	
}
