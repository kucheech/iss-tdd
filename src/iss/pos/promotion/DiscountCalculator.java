package iss.pos.promotion;

import java.util.ArrayList;

import iss.pos.Order;
import iss.pos.OrderItem;

public class DiscountCalculator {

	Promotion promo;

	public DiscountCalculator(Promotion promo) {
		this.promo = promo;
	}

	public Order calculateDiscount(Order order) {

		Order orderWithDiscounts = promo.applyPromotion(order);
		
		switch (promo.getId()) {
		case 1:
			order.calculateDiscount();
			break;
		case 2:
			order.calculateDiscount2();
			break;
		case 3:
			//order.calculateDiscount3();
			break;
		default:
			System.out.println("Invalid promotion");
		}
		
		return orderWithDiscounts;
	}
}
