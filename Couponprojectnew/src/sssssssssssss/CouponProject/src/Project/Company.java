package sssssssssssss.CouponProject.src.Project;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private int id;
	private String compName;
	private String password;
	private String email;
	
	public static List<String> compNameList = new ArrayList<>();

	public Company(String compName, String password) {
		setCompName(compName);
		setPassword(password);
	}

	public Company(String compName, String password, String email) {
		setCompName(compName);
		setPassword(password);
		setEmail(email);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
		//TODO: NO IDEA FOR AN ALGORITEM
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		String PASSWORD_PATTERN = "\\w{6,}";
		if(!password.matches(PASSWORD_PATTERN)) 
		{
			System.out.println(password + " - Password must contain 6 characters or more");
			return;
		}
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(isValidEmailAddress(email))
		{			
			this.email = email;
		}
	}
	
	public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
 }

	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", password=" + password + ", email=" + email + "]";
	}

}
