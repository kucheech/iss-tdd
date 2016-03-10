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
			calculateDiscount1(order);
			break;
		case 2: 
			calculateDiscount2(order);
			break;
		case 3: 
			calculateDiscount3(order);
			break;
		default:
			System.out.println("Invalid promotion");
		
		}
		
		return order;
	}
	
	
	public void calculateDiscount1(Order order) {
		ArrayList<OrderItem> copy = new ArrayList<OrderItem>();
		copy.addAll(order.getItems());

		Iterator<OrderItem> itr = copy.iterator();

		while (itr.hasNext()) {
			OrderItem oi = itr.next();
			int qty = oi.getQuantity();
			int numDiscounted = qty / 2;
			String discountMessage = "30% off for 2nd item of same SKU";
			Discount discount = new Discount(discountMessage, 0.3 * numDiscounted * oi.getProduct().getPrice());
			order.add(discount);
			oi.setQuantity(qty - numDiscounted * 2);
			if (oi.getQuantity() == 0) {
				itr.remove();
				// System.out.println("removed");
			}
		}

		itr = copy.iterator();
		while (itr.hasNext()) {
			OrderItem oi = itr.next();

			// System.out.println(oi.getProduct().getStyle());
			itr.remove();
			OrderItem oi2 = getOrderItemByStyle(copy, oi.getProduct().getStyle());
			if (oi2 != null) {
				double price1 = oi.getProduct().getPrice();
				double price2 = oi2.getProduct().getPrice();
				// System.out.println(price1 + " " + price2);
				// oi.setQuantity(oi.getQuantity()-1);
				oi2.setQuantity(oi2.getQuantity() - 1);

				String discountMessage = "50% off for 2nd item of same style, different SKU";
				Discount discount = new Discount(discountMessage, 0.5 * (price1 < price2 ? price1 : price2));
				order.add(discount);
				if (oi2.getQuantity() == 0) {
					copy.remove(oi2);
				}
			}
		}

	}

	
	
	public void calculateDiscount2(Order order) {
		ArrayList<OrderItem> copy = new ArrayList<OrderItem>();
		copy.addAll(order.getItems());

		Iterator<OrderItem> itr = copy.iterator();
		while (itr.hasNext()) {
			ArrayList<OrderItem> list = new ArrayList<OrderItem>();
			OrderItem oi = itr.next();
			list.add(oi);			
			// System.out.println(oi.getProduct().getStyle());
			String style = oi.getProduct().getStyle();
			itr.remove();
			
			oi = getOrderItemByStyle(copy, style);
			while(oi != null) {
				list.add(oi);
				copy.remove(oi);
				oi = getOrderItemByStyle(copy, style);
			}
			
			double discountAmount = 0.1;
			String discountMessage = "10% off first item";
			if(list.size() > 1 || list.get(0).getQuantity() > 1) {
				discountAmount = 0.2;
				discountMessage = "20% off for more than 2 items of same style";
			} 
			Iterator<OrderItem> itr2 = list.iterator();
			while(itr2.hasNext()) {
				OrderItem oi2 = itr2.next();
				Discount discount = new Discount(discountMessage,  discountAmount * oi2.getQuantity() * oi2.getProduct().getPrice());
				order.add(discount);		
			}
	 

		}


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
		String discountMessage = "3 pairs of women's invisible socks for $25";
		Discount discount = new Discount(discountMessage,  numTriples * discountAmount);
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
