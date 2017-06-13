package sssssssssssss.CouponProject.src.Project;

import java.sql.Date;

public class Coupon {

	private int id;
	private String title;
	private Date start_date;
	private Date end_date;
	private int couponAmount;
	private String message;
	private double price;
	private String image;
	private CouponType type;

	public Coupon(){}
	
	public Coupon(String title, Date start_date, Date end_date, int couponAmount, String message, double price,
			String image,CouponType type) {
		this.title = title;
		this.start_date = start_date;
		this.end_date = end_date;
		this.couponAmount = couponAmount;
		this.message = message;
		this.price = price;
		this.image = image;
		this.type = type;

	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(int couponAmount) {
		this.couponAmount = couponAmount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public CouponType getType() {
		return type;
	}

	public void setType(CouponType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", couponAmount=" + couponAmount + ", message=" + message + ", price=" + price + ", image=" + image
				+ ", type=" + type + "]";
	}



}
