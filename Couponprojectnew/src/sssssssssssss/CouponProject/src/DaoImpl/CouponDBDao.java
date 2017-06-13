package sssssssssssss.CouponProject.src.DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sssssssssssss.CouponProject.src.Dao.CouponDao;
import sssssssssssss.CouponProject.src.Project.Coupon;
import sssssssssssss.CouponProject.src.Project.CouponType;





public class CouponDBDao implements CouponDao {

	private static final String TABLE_NAME = "coupons";

	@Override
	public void addCoupon(Coupon c) throws Exception {
		// 1. get a connection (from pool)
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("INSERT INTO " + TABLE_NAME + " VALUES (?, ?, ? ,? , ? , ? , ? , ?, ?)");
			stat.setInt(1, c.getId());
			stat.setString(2, c.getTitle());
			stat.setDate(3, c.getStart_date());
			stat.setDate(4, c.getEnd_date());
			stat.setInt(5, c.getCouponAmount());
			stat.setString(6, c.getMessage());
			stat.setDouble(7, c.getPrice());
			stat.setString(8, c.getImage());
			stat.setString(9, c.getType().toString());

			System.out.println("Executing: " + stat.toString());
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
	public Coupon getCoupon(int id) {
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("SELECT * from " + TABLE_NAME + " where id=?");
			stat.setInt(1, id);

			// System.out.println("Executing: " + stat.toString());
			ResultSet rs = stat.executeQuery();

			// we expect only one coupon
			rs.next();

			int id2 = rs.getInt(1);
			String title = rs.getString(2);
			Date start_date = rs.getDate(3);
			Date end_date = rs.getDate(4);
			int couponAmount = rs.getInt(5);
			String message = rs.getString(6);
			double price = rs.getDouble(7);
			String image = rs.getString(8);
			CouponType type = CouponType.valueOf(rs.getString(9));

			Coupon c = new Coupon(title,start_date,end_date,couponAmount,message,price,image,type);
			return c;

		} catch (SQLException e) {
			e.printStackTrace();
			return null; // TODO: deal with the exception
		} finally {
			// 3. release connection
			releaseConnection(con);
		}

	}

	@Override
	public void removeCoupon(int id) throws Exception {
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("DELETE * from " + TABLE_NAME + " where id=?");
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
	public void updateCoupon(Coupon c) throws Exception {
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("UPDATE " + TABLE_NAME
					+ " SET id=?, title=?,start_date=?,end_date=?,couponAmount=?,message=?,price=?,image=? WHERE id=?");
			stat.setInt(1, c.getId());
			stat.setString(2, c.getTitle());
			stat.setDate(3, c.getStart_date());
			stat.setDate(4, c.getEnd_date());
			stat.setInt(5, c.getCouponAmount());
			stat.setString(6, c.getMessage());
			stat.setDouble(7, c.getPrice());
			stat.setString(8, c.getImage());

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
	public List<Coupon> getAllCoupons() {
		Connection con = null;
		try {
			con = getConnection();

			// 2. create sql insert
			PreparedStatement stat = con.prepareStatement("SELECT * from " + TABLE_NAME);

			stat.executeUpdate();

			// System.out.println("Executing: " + stat.toString());
			List<Coupon> cl = new ArrayList<>();
			ResultSet rs = stat.executeQuery();

			// we expect only one coupon
			while (rs.next()) {

				long id2 = rs.getLong(1);
				String title = rs.getString(2);
				Date start_date = rs.getDate(3);
				Date end_date = rs.getDate(4);
				int couponAmount = rs.getInt(5);
				String message = rs.getString(6);
				double price = rs.getDouble(7);
				String image = rs.getString(8);
				CouponType type = CouponType.valueOf(rs.getString(9));
				
				Coupon c = new Coupon(title,start_date,end_date,couponAmount,message,price,image,type);
				cl.add(c);
			}
			
			return cl;
		} 
		catch (SQLException e) {
			// TODO: deal with exception
			e.printStackTrace();
			return null;
		} finally {
			// 3. release connection
			releaseConnection(con);
		}
	}
	private Connection getConnection() throws SQLException {
		// TODO: maybe we should catch the exception here
		// and close the program. It is too severe
		String dbName = "CouponSystem";
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