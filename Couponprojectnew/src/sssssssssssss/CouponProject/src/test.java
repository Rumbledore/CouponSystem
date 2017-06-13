package sssssssssssss.CouponProject.src;

import java.util.List;

import sssssssssssss.CouponProject.src.Dao.CompanyDao;
import sssssssssssss.CouponProject.src.DaoImpl.CompanyDBDao;
import sssssssssssss.CouponProject.src.Project.Company;



public class test {

	public static void main(String[] args) {

		/*CustomerDao cDao = new CustomerDBDao();

		Customer c1 = new Customer("moshe", "aaasasas");
		try {
			//cDao.addCustomer(c1);
			System.out.println(cDao.getCustomer(706));
			//cDao.removeCustomer(200);
			//cDao.getAllCustomers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*for (int i = 0; i < 100; i++) {


			try {
				cDao.addCustomer(c1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("added customer name: " + c1.getCustName() + " id: " + c1.getId());
		}*/
		CompanyDao cDao = new CompanyDBDao();
		Company c1 = new Company("Zohar", "123456");
		try {
			cDao.addCompany(c1);
			System.out.println(cDao.getCompany(11));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

}
