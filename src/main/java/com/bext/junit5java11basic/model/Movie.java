package com.bext.junit5java11basic.model;

import java.util.Date;

public class Movie {

	private String title;
	private Date relesaeDate;
	@SuppressWarnings("unused")
	private String duration;
	
	public Movie(String title, Date relesaeDate, String duration) {
		super();
		this.title = title;
		this.relesaeDate = relesaeDate;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public Date getRelesaeDate() {
		return relesaeDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((relesaeDate == null) ? 0 : relesaeDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Movie other = (Movie) obj;
		if (relesaeDate == null) {
			if (other.relesaeDate != null)
				return false;
		} else if (!relesaeDate.equals(other.relesaeDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
	
	
}
