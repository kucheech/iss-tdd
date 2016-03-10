package iss.pos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Order {

	private List<OrderItem> items;
	private List<Discount> discounts;
	
	public Order() {
		items = new ArrayList<OrderItem>();
		discounts = new ArrayList<Discount>();
	}

	public void add(Product prod, int qty) {
		OrderItem oi = getOrderItem(prod.getSku());

		if (oi == null) {
			oi = new OrderItem();
			oi.setProduct(prod);
			oi.setQuantity(qty);
			items.add(oi);
			this.sortBySKU();
		} else {
			oi.setQuantity(oi.getQuantity() + qty);
		}
	}
	

	public OrderItem getOrderItem(String sku) {
		Iterator<OrderItem> itr = items.iterator();

		while (itr.hasNext()) {
			OrderItem oi = itr.next();

			if (oi.getProduct().getSku() == sku) {
				return oi;
			}
		}
		return null;
	}

	public void sortBySKU() {
		items.sort(new Comparator<OrderItem>() {

			@Override
			public int compare(OrderItem item1, OrderItem item2) {
				return item1.getProduct().getSku().compareToIgnoreCase(item2.getProduct().getSku());
			}

		});
	}

	public double getTotalPrice() {
		double total = 0;
		Iterator<OrderItem> itr = items.iterator();

		while (itr.hasNext()) {
			OrderItem oi = itr.next();
			total += oi.getQuantity() * oi.getProduct().getPrice();
		}

		return total;
	}


	public List<OrderItem> getItems() {

		return items;
	}
	
	public List<Discount> getDiscounts() {

		return discounts;
	}

	public void add(Discount discount) {		
		discounts.add(discount);
	}
	
	public double getTotalDiscount() {
		double total = 0;
		Iterator<Discount> itr = discounts.iterator();
		while(itr.hasNext()) {
			total += itr.next().getAmount();
		}
		
		return total;
	}
	

}
