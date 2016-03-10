package iss.pos.promotion;

import java.util.ArrayList;
import java.util.Iterator;

import iss.pos.Discount;
import iss.pos.Order;
import iss.pos.OrderItem;

public class Promotion {
	private int id;
	
	public Promotion(int id) {
		this.id = id;
	}
		
	public int getId() {
		return id;
	}
	
	public Order applyPromotion(Order order) {
		
		
		switch(id) {
		case 1: 
			break;
		case 2: 
			break;
		case 3: 
			calculateDiscount3(order);
			break;
		default:
			System.out.println("Invalid promotion");
		
		}
		
		return order;
	}
	
	
	public void calculateDiscount3(Order order) {
		ArrayList<OrderItem> copy = new ArrayList<OrderItem>();
		copy.addAll(order.getItems());

		ArrayList<OrderItem> list = new ArrayList<OrderItem>();
		String style = "3001"; //for invisible socks
		OrderItem oi = getOrderItemByStyle(copy, "3001");
		while(oi != null) {
			list.add(oi);
			copy.remove(oi);
			oi = getOrderItemByStyle(copy, style);
		}
			
		double discountAmount = 20; // 45-25
		int qty = getTotalQty(list);
		int numTriples = qty / 3; //integer division
		Discount discount = new Discount("Discount for Invisible Socks",  numTriples * discountAmount);
		order.add(discount);		
	}
	
	public OrderItem getOrderItemByStyle(ArrayList<OrderItem> list, String style) {
		Iterator<OrderItem> itr = list.iterator();

		while (itr.hasNext()) {
			OrderItem oi = itr.next();

			if (oi.getProduct().getStyle().equalsIgnoreCase(style)) {
				return oi;
			}
		}
		return null;
	}
	
	public int getTotalQty(ArrayList<OrderItem> list) {
		Iterator<OrderItem> itr = list.iterator();
		int totalQty = 0;

		while (itr.hasNext()) {
			OrderItem oi = itr.next();
			totalQty += oi.getQuantity();
		}
		
		return totalQty;
	}
}
