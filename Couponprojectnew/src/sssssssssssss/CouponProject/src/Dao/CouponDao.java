package sssssssssssss.CouponProject.src.Dao;

import java.util.List;

import sssssssssssss.CouponProject.src.Project.Coupon;







public interface CouponDao {
	public void addCoupon(Coupon c) throws Exception;
	public Coupon getCoupon(int id) throws Exception;
	public void removeCoupon(int id) throws Exception;
	public void updateCoupon(Coupon c) throws Exception;
	public List<Coupon> getAllCoupons() throws Exception;
}
