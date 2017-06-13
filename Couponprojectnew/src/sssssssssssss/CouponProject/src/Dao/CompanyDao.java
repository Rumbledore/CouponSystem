package sssssssssssss.CouponProject.src.Dao;

import java.util.List;

import sssssssssssss.CouponProject.src.Project.Company;




public interface CompanyDao {
	public void addCompany(Company c) throws Exception;
	public Company getCompany(int id) throws Exception;
	public void removeCompany(int id) throws Exception;
	public List<Company> getAllCompanys() throws Exception;
}
