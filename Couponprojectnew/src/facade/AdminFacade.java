package facade;

import java.util.List;

import sssssssssssss.CouponProject.src.Dao.CompanyDao;
import sssssssssssss.CouponProject.src.Dao.CustomerDao;
import sssssssssssss.CouponProject.src.Project.Company;
import sssssssssssss.CouponProject.src.Project.Customer;

public class AdminFacade implements CouponClientFacade, CompanyDao, CustomerDao{

	@Override
	public void addCustomer(Customer c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomer(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCustomer(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(Customer c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCompany(Company c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company getCompany(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCompany(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Company> getAllCompanys() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CouponClientFacade login(String name, String password, String clientType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
