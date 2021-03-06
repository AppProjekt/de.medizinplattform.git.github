package de.medizinplattform.managedbeans;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import de.medizinplattform.entities.Users;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean {
	
	public String name;
	public String password;
	
	
	@ManagedProperty(value="#{users}")
	private Users users;
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	
	@ManagedProperty(value="#{userBean}")
	private UserBean user;
	
	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
	
	public LoginBean(){
		
		//debug
		System.out.println("Login Bean started");
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String login(){
		//debug
		if(users != null){
	    
			System.out.println("checking if user " + name+ " is registered");
			if(users.hasUser(name)==false){
				System.out.println("no such user exists");
			}
			else{
				if(password.equals(users.getPassword(name))){
					System.out.println("succesfull login");
					user.setHeader("header_with_name.xhtml");
					user.setName(name);
					return "index.xhtml";
				}
				else{
					System.out.println("wrong password");
				}
			}
				
	    
		
		}       
		return null;    
	}
	public String logout(){
		//debug
		System.out.println("header_with_forms mode set");
		user.setHeader("header_with_forms.xhtml");
		user.setName(null);
		return "index.xhtml";
	}
	
	@PreDestroy
	public void cry(){
		//System.out.println("LoginBean is about to be destroyed");
	}
	
}
