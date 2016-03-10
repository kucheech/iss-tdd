package iss.pos.promotion;

import iss.pos.Order;

public class DiscountCalculator {

	Promotion promo;

	public DiscountCalculator(Promotion promo) {
		this.promo = promo;
	}

	public Order calculateDiscount(Order order) {

		Order orderWithDiscounts = promo.applyPromotion(order);
				
		return orderWithDiscounts;
	}
}
