package sssssssssssss.CouponProject.src.Dao;

import java.util.List;

import sssssssssssss.CouponProject.src.Project.Customer;




public interface CustomerDao {
	public void addCustomer(Customer c) throws Exception;
	public Customer getCustomer(int id) throws Exception;
	public void removeCustomer(int id) throws Exception;
	public void updateCustomer(Customer c) throws Exception;
	public List<Customer> getAllCustomers() throws Exception;
}
