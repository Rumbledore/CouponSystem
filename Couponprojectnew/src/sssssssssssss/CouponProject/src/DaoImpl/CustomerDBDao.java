package sssssssssssss.CouponProject.src.DaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sssssssssssss.CouponProject.src.Dao.CustomerDao;
import sssssssssssss.CouponProject.src.Project.Customer;




public class CustomerDBDao implements CustomerDao {

	private static final String TABLE_NAME = "customer";

	@Override
	public void addCustomer(Customer c) throws Exception {
		// 1. get a connection (from pool)
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			String sql = "INSERT INTO " + TABLE_NAME + "(CUST_NAME, PASSWORD) VALUES (?, ?)";
			PreparedStatement stat = con.prepareStatement(sql, 
					Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, c.getCustName());
			stat.setString(2, c.getPassword());

			System.out.println("Executing: " + stat.toString());
			stat.executeUpdate();
			
			// get the auto generated customer id, and put in the bean
			//
		    // Example of using Statement.getGeneratedKeys()
		    // to retrieve the value of an auto-increment
		    // value
		    //
			int id = 0;
		    ResultSet rs = stat.getGeneratedKeys();
		    if (rs.next()) {
		        id = rs.getInt(1);
		    } else {
		    	
		    	// TODO: Error, do something
		    }
			c.setId(id);

		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		} finally {
			// 3. release connection
			releaseConnection(con);
		}
	}

	@Override
	public Customer getCustomer(int id) throws Exception {
		Connection con = null; 
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("SELECT * from " + TABLE_NAME + " where id=?");
			stat.setInt(1, id);

			// System.out.println("Executing: " + stat.toString());
			ResultSet rs = stat.executeQuery();

			// we expect only one customer
			rs.next();
			
			String name = rs.getString(2);
			String password = rs.getString(3);

			Customer c = new Customer(name, password);
			c.setId(id);
			return c;

		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		} finally {
			// 3. release connection
			releaseConnection(con);
		}
		return null;
	}

	@Override
	public void removeCustomer(int id) throws Exception {
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("DELETE from " + TABLE_NAME + " where id=?");
			stat.setInt(1, id);
			stat.executeUpdate();
			System.out.println(id + " have been removed");
		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		} finally {
			// 3. release connection
			releaseConnection(con);
		}

	}

	@Override
	//TODO:we need to change the function completly
	public void updateCustomer(Customer c) throws Exception {
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = 
					con.prepareStatement("UPDATE " + TABLE_NAME + 
							" SET CUST_NAME=?, PASSWORD=? WHERE id=?");
			
			stat.setString(1, c.getCustName());
			stat.setString(2, c.getPassword());
			
			stat.executeUpdate();

		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		} finally {
			// 3. release connection
			releaseConnection(con);
		}

	}

	@Override
	public List<Customer> getAllCustomers() throws Exception {
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("SELECT * from " + TABLE_NAME);
			
			ResultSet rs = stat.executeQuery();

			// we expect only one coupon
			List<Customer> customers = new ArrayList<>();
			while (rs.next()) {

				String name = rs.getString(1);
				String password = rs.getString(2);
				Customer c = new Customer(name, password);
				customers.add(c);
			}
			return customers;

		} catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
		} finally {
			// 3. release connection
			releaseConnection(con);
		}
		return null;
	}

	private Connection getConnection() throws SQLException {
		// TODO: maybe we should catch the exception here
		// and close the program. It is too severe
		String dbName = "coupondb";
		String url = "jdbc:mysql://localhost/" + dbName;
		return DriverManager.getConnection(url, "root", "12345678");
	}

	private void releaseConnection(Connection con) {
		// We currently are closing the connections. Later we
		// will move to a better solution using a connection pool
		// that Assaf will provide
		try {
			con.close();
		} catch (SQLException e) {
			// We don't care
			e.printStackTrace();
		}
	}

}
