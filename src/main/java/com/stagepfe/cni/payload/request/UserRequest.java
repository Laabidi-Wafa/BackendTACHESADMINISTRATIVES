package com.stagepfe.cni.payload.request;

import java.util.Set;

import com.stagepfe.cni.models.DemandeCG;

public class UserRequest {

    private String username;
    private String image;
    private String address;
    private String phone;
	private String datebirth;
    private String email;
    private String password;
    private Set<String> role;
	private Set<DemandeCG> cgrises;

    
    
    public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getDatebirth() {
		return datebirth;
	}
	public void setDatebirth(String datebirth) {
		this.datebirth = datebirth;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getRole() {
	      return this.role;
	    }
	    
	    public void setRole(Set<String> role) {
	      this.role = role;
	    }
	    
	    public Set<DemandeCG> getCgrises() {
			return cgrises;
		}

		public void setCgrises(Set<DemandeCG> cgrises) {
			this.cgrises = cgrises;
		}	
}
