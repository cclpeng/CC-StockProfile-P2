package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name="USERS")
@Component
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sqUserId")
	@SequenceGenerator(name="sqUserId", allocationSize=1, sequenceName="SQ_GENERATE_USER_ID")
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_N")
	private String userN;
	
	@Column(name="PASS_W")
	private String passW;
	
	@Column(name="NAME")
	private String name;
	
	public User() { super(); }
	
	public User(String userN, String passW, String name) {
		super();
		this.userN = userN;
		this.passW = passW;
		this.name = name;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getUserN() {
		return userN;
	}
	public String getPassW() {
		return passW;
	}
	public String getName() {
		return name;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserN(String userN) {
		this.userN = userN;
	}
	public void setPassW(String passW) {
		this.passW = passW;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userN=" + userN + ", passW=" + passW + ", name=" + name + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passW == null) ? 0 : passW.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userN == null) ? 0 : userN.hashCode());
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
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passW == null) {
			if (other.passW != null)
				return false;
		} else if (!passW.equals(other.passW))
			return false;
		if (userId != other.userId)
			return false;
		if (userN == null) {
			if (other.userN != null)
				return false;
		} else if (!userN.equals(other.userN))
			return false;
		return true;
	}
	
}
