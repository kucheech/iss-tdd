package iss.pos.promotion;

import iss.pos.Order;

public class DiscountCalculator {

    public DiscountCalculator(Promotion promo) {

    }

    public Order calculateDiscount(Order order) {
     
        order.calculateDiscount();
        
        return order;
    }
}
