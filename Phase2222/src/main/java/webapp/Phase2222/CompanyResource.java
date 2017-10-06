package webapp.Phase2222;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Company;
import beans.Coupon;
import exceptions.MyException;
import facade.ClientType;
import facade.CompanyFacade;
import facade.CouponSystemSingleton;

@Path("/company")
public class CompanyResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Coupon> getCoupons(Company company) throws MyException
	{
		CompanyFacade companyFacade = (CompanyFacade) CouponSystemSingleton.getInstance().login("Zuliver", "0222123",
				ClientType.COMPANY);
		try
		{
			Collection<Coupon> couponList = companyFacade.getCoupons(company);
			return couponList;
		}catch (Exception e) {
			System.out.println("<html>");
			System.out.println("<head>");
			System.out.println("</head>");
			System.out.println("<body>");
			System.out.println("<h1>" + "Company has no Coupons !" + "</h1>");
			System.out.println("</body>");
			System.out.println("</html>");
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean createCoupon(Company company, Coupon coupon) 
	{
		CompanyFacade companyFacade;
		try {
			companyFacade = (CompanyFacade) CouponSystemSingleton.getInstance().login("Zuliver", "0222123",
					ClientType.COMPANY);
			return companyFacade.createCoupon(company, coupon);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 
}

