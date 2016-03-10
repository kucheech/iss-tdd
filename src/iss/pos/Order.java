package iss.pos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Order {

	private List<OrderItem> items;
	private double discount;

	public Order() {
		items = new ArrayList<OrderItem>();
		discount = 0;
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

	
	
	public void sortByStyle(ArrayList<OrderItem> list) {
		list.sort(new Comparator<OrderItem>() {

			@Override
			public int compare(OrderItem item1, OrderItem item2) {
				return item1.getProduct().getStyle().compareToIgnoreCase(item2.getProduct().getStyle());
			}

		});
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

	public void calculateDiscount() {
		ArrayList<OrderItem> copy = new ArrayList<OrderItem>();
		copy.addAll(items);

		Iterator<OrderItem> itr = copy.iterator();

		while (itr.hasNext()) {
			OrderItem oi = itr.next();
			int qty = oi.getQuantity();
			// if(qty == 1) {
			// //no discount
			// } else if(qty == 2) {
			// //no discount
			// total += 0.3 * oi.getProduct().getPrice();
			// }
			int numDiscounted = qty / 2;
			discount += 0.3 * numDiscounted * oi.getProduct().getPrice();
			oi.setQuantity(qty - numDiscounted * 2);
			if (oi.getQuantity() == 0) {
				itr.remove();
				// System.out.println("removed");
			}
		}

		// sortByStyle(copy);
		// itr = copy.iterator();
		// //System.out.println(copy.size());
		// while (itr.hasNext()) {
		// OrderItem oi = itr.next();
		// //System.out.println(oi.getProduct().getStyle());
		// if(itr.hasNext()) {
		// OrderItem oi2 = itr.next();
		// if(oi.getProduct().hasSameStyle(oi2.getProduct())) {
		// double price1 = oi.getProduct().getPrice();
		// double price2 = oi2.getProduct().getPrice();
		// System.out.println(price1 + " " + price2);
		// oi.setQuantity(oi.getQuantity()-1);
		// oi2.setQuantity(oi2.getQuantity()-1);
		// }
		// }
		// }

		// System.out.println(copy.size());

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

				discount += 0.5 * (price1 < price2 ? price1 : price2);
				if (oi2.getQuantity() == 0) {
					copy.remove(oi2);
				}
			}
		}

	}

	public void calculateDiscount2() {
		ArrayList<OrderItem> copy = new ArrayList<OrderItem>();
		copy.addAll(items);

		Iterator<OrderItem> itr = copy.iterator();
		while (itr.hasNext()) {
			ArrayList<OrderItem> list = new ArrayList<OrderItem>();
			OrderItem oi = itr.next();
			list.add(oi);			
			// System.out.println(oi.getProduct().getStyle());
			String style = oi.getProduct().getStyle();
			itr.remove();
			
			oi = getOrderItemByStyle(copy, oi.getProduct().getStyle());
			while(oi != null) {
				list.add(oi);
				copy.remove(oi);
				oi = getOrderItemByStyle(copy, oi.getProduct().getStyle());
			}
			
			double discountAmount = 0.1;			
			if(list.size() > 1 || list.get(0).getQuantity() > 1) {
				discountAmount = 0.2;
			} 
			Iterator<OrderItem> itr2 = list.iterator();
			while(itr2.hasNext()) {
				OrderItem oi2 = itr2.next();
				discount += discountAmount * oi2.getQuantity() * oi2.getProduct().getPrice();
			}
	 

		}


	}
	
	
	public void calculateDiscount3() {
		ArrayList<OrderItem> copy = new ArrayList<OrderItem>();
		copy.addAll(items);

		Iterator<OrderItem> itr = copy.iterator();
		while (itr.hasNext()) {
			ArrayList<OrderItem> list = new ArrayList<OrderItem>();
			OrderItem oi = itr.next();
			list.add(oi);			
			// System.out.println(oi.getProduct().getStyle());
			String style = oi.getProduct().getStyle();
			itr.remove();
			
			oi = getOrderItemByStyle(copy, oi.getProduct().getStyle());
			while(oi != null) {
				list.add(oi);
				copy.remove(oi);
				oi = getOrderItemByStyle(copy, oi.getProduct().getStyle());
			}
			
			double discountAmount = 0.1;			
			if(list.size() > 1 || list.get(0).getQuantity() > 1) {
				discountAmount = 0.2;
			} 
			Iterator<OrderItem> itr2 = list.iterator();
			while(itr2.hasNext()) {
				OrderItem oi2 = itr2.next();
				discount += discountAmount * oi2.getQuantity() * oi2.getProduct().getPrice();
			}
	 

		}


	}
	

	public double getDiscount() {
		return discount;
	}

	public List<OrderItem> getItems() {

		return items;
	}

}
