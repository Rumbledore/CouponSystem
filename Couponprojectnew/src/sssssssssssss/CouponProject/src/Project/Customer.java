package sssssssssssss.CouponProject.src.Project;

public class Customer {
	private int id;
	private String custName;
	private String password;

	public Customer(String custName, String password) {
		this.custName = custName;
		setPassword(password);
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		String PASSWORD_PATTERN = "\\w{6,}";
		if (!password.matches(PASSWORD_PATTERN)) {
			System.out.println(password + " - Password must contain 6 characters or more");
			return;
		}
		
		this.password = password;
	
}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", password=" + password + "]";
	}

}
