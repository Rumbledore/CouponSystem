package sssssssssssss.CouponProject.src.DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sssssssssssss.CouponProject.src.Dao.CompanyDao;
import sssssssssssss.CouponProject.src.Project.Company;






public class CompanyDBDao implements CompanyDao {

	private static final String TABLE_NAME = "company";

	@Override
	public void addCompany(Company c) throws Exception {
		// 1. get a connection (from pool)
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			String sql = "INSERT INTO " + TABLE_NAME + "(COMP_NAME, PASSWORD) VALUES (?, ?)";
			PreparedStatement stat = con.prepareStatement(sql, 
					Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, c.getCompName());
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
	public Company getCompany(int id) throws Exception {
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
			String email = rs.getString(4);
			if(email == null){
				Company c = new Company(name, password);
				c.setId(id);
				return c;	
			}
			else
			{
				Company c = new Company(name, password, email);
				c.setId(id);
				return c;
			}
			
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
	public void removeCompany(int id) throws Exception {
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("DELETE from " + TABLE_NAME + " where id=?");
			stat.setInt(1, id);
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
	public List<Company> getAllCompanys() throws Exception {
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("SELECT * from " + TABLE_NAME);

			stat.executeUpdate();

			// System.out.println("Executing: " + stat.toString());
			List<Company> cl = new ArrayList<>();
			ResultSet rs = stat.executeQuery();

			// we expect only one coupon
			while (rs.next()) {
				String compName = rs.getString(1);
				String password = rs.getString(2);
				String email = rs.getString(3);
				
				Company c = new Company(compName,password,email);
				cl.add(c);
			}
			
			return cl;
		} 
		catch (SQLException e) {
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
		return DriverManager.getConnection(url, "root", "1234");
	}

	private void releaseConnection(Connection con)
	{
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
