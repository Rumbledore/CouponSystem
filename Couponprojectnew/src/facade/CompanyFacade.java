package facade;

import java.util.List;

import sssssssssssss.CouponProject.src.Dao.CouponDao;
import sssssssssssss.CouponProject.src.Project.Coupon;

public class CompanyFacade implements CouponClientFacade, CouponDao{
	
	public CompanyFacade() {}
	
	@Override
	public CouponClientFacade login(String name, String password, String clientType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCoupon(Coupon c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Coupon getCoupon(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCoupon(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCoupon(Coupon c) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Coupon> getAllCoupons() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
