package com.revature.models.forms;

public class ChangeSettingsForm {
	private String username;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	public ChangeSettingsForm() {
		super();
	}
	public ChangeSettingsForm(String username, String oldPassword, String newPassword, String confirmPassword) {
		super();
		this.username = username;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
	}
	public String getUsername() {
		return username;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Override
	public String toString() {
		return "ChangeSettingsForm [username=" + username + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + ", confirmPassword=" + confirmPassword + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmPassword == null) ? 0 : confirmPassword.hashCode());
		result = prime * result + ((newPassword == null) ? 0 : newPassword.hashCode());
		result = prime * result + ((oldPassword == null) ? 0 : oldPassword.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		ChangeSettingsForm other = (ChangeSettingsForm) obj;
		if (confirmPassword == null) {
			if (other.confirmPassword != null)
				return false;
		} else if (!confirmPassword.equals(other.confirmPassword))
			return false;
		if (newPassword == null) {
			if (other.newPassword != null)
				return false;
		} else if (!newPassword.equals(other.newPassword))
			return false;
		if (oldPassword == null) {
			if (other.oldPassword != null)
				return false;
		} else if (!oldPassword.equals(other.oldPassword))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
}
