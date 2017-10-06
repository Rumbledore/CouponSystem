package webapp.Phase2222;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Company;
import beans.Customer;
import exceptions.MyException;
import facade.AdminFacade;
import facade.ClientType;
import facade.CouponSystemSingleton;

@Path("admin")
public class AdminResource {

	@Path("/company")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Company> getAllCompany() throws MyException {

		AdminFacade adminFacade = (AdminFacade) CouponSystemSingleton.getInstance().login("admin", "1234",
				ClientType.ADMIN);
		return adminFacade.getAllCompanies();
	}

	@Path("/company/{index}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Company getCompany(@PathParam("index") int index) throws MyException {

		AdminFacade adminFacade = (AdminFacade) CouponSystemSingleton.getInstance().login("admin", "1234",
				ClientType.ADMIN);
		return adminFacade.getCompany(index);
	}

	@Path("/company")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCompany(Company c) {
		AdminFacade adminFacade;
		try {
			adminFacade = (AdminFacade) CouponSystemSingleton.getInstance().login("admin", "1234", ClientType.ADMIN);

			adminFacade.createCompany(c);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("created!");
	}

	@DELETE
	@Path("/company/{index}")
	public void removeCompany(@PathParam("index") int index) throws MyException {
		AdminFacade adminFacade = (AdminFacade) CouponSystemSingleton.getInstance().login("admin", "1234",
				ClientType.ADMIN);
		Company c = new Company();
		c.setId(index);
		adminFacade.removeCompany(c);
		System.out.println("removed!");
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/company/{index}")
	public void updateCoupon(@PathParam("index") int index, Company c) throws MyException {
		AdminFacade adminFacade = (AdminFacade) CouponSystemSingleton.getInstance().login("admin", "1234",
				ClientType.ADMIN);
		adminFacade.updateCompany(c);
		System.out.println("updated!");
	}

	// NOW CUSTOMER FUNCTION IN ADMINFACADER
	@Path("/customer")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Customer> getAllCustomers() throws MyException {

		AdminFacade adminFacade = (AdminFacade) CouponSystemSingleton.getInstance().login("admin", "1234",
				ClientType.ADMIN);
		return adminFacade.getAllCustomers();
	}

	@Path("/customer/{index}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@PathParam("index") int index) throws MyException {

		AdminFacade adminFacade = (AdminFacade) CouponSystemSingleton.getInstance().login("admin", "1234",
				ClientType.ADMIN);
		return adminFacade.getCustomer(index);
	}

	@Path("/customer")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createCustomer(Customer c) {
		AdminFacade adminFacade;
		try {
			adminFacade = (AdminFacade) CouponSystemSingleton.getInstance().login("admin", "1234", ClientType.ADMIN);

			adminFacade.createCustomer(c);
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("created!");
	}

	@DELETE
	@Path("/customer/{index}")
	public void removeCustomer(@PathParam("index") int index) throws MyException {
		AdminFacade adminFacade = (AdminFacade) CouponSystemSingleton.getInstance().login("admin", "1234",
				ClientType.ADMIN);
		Customer c = new Customer();
		c.setId(index);
		adminFacade.removeCustomer(c);
		System.out.println("removed!");
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/customer/{index}")
	public void updateCustomer(@PathParam("index") int index, Customer c) throws MyException {
		AdminFacade adminFacade = (AdminFacade) CouponSystemSingleton.getInstance().login("admin", "1234",
				ClientType.ADMIN);
		adminFacade.updateCustomer(c);
		System.out.println("updated!");
	}

}
