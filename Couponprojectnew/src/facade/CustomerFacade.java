package facade;

import java.util.*;

import sssssssssssss.CouponProject.src.Dao.CouponDao;
import sssssssssssss.CouponProject.src.Project.Coupon;

public class CustomerFacade implements CouponClientFacade {

	@Override
	public CouponClientFacade login(String name, String password, String clientType) {
		return null;//TODO:back to here
	}

	public CustomerFacade() {}

	//TODO:DEAL WITH ALL FUNCTIONS!!!
	public Coupon PurchaseCoupon (Coupon c){
		return c;
	}
	
	public List<Coupon> GetAllPurchasedCoupons(){
		return null;
	}
	
	//TODO:GetAll by ____
	
}
