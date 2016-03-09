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

    public void sortByStyle(ArrayList<OrderItem> list) {
        list.sort(new Comparator<OrderItem>() {

            @Override
            public int compare(OrderItem item1, OrderItem item2) {
                return item1.getProduct().getStyle()
                        .compareToIgnoreCase(item2.getProduct().getStyle());
            }

        });
    }
    
        public void sortBySKU() {
        items.sort(new Comparator<OrderItem>() {

            @Override
            public int compare(OrderItem item1, OrderItem item2) {
                return item1.getProduct().getSku()
                        .compareToIgnoreCase(item2.getProduct().getSku());
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
//            if(qty == 1) {
//                //no discount
//            } else if(qty == 2) {
//                //no discount
//                total += 0.3 * oi.getProduct().getPrice();
//            }    
            int numDiscounted = qty / 2;
            discount += 0.3 * numDiscounted * oi.getProduct().getPrice();
            oi.setQuantity(qty-numDiscounted*2);
            if(oi.getQuantity() == 0) {
            	itr.remove();
            	//System.out.println("removed");	
            }
        }
        
        
        sortByStyle(copy);
        itr = copy.iterator();
        //System.out.println(copy.size());
        while (itr.hasNext()) {
        	OrderItem oi = itr.next();
        	//System.out.println(oi.getProduct().getStyle());
        	if(itr.hasNext()) {
        		OrderItem oi2 = itr.next(); 
        		if(oi.getProduct().hasSameStyle(oi2.getProduct())) {
        			double price1 = oi.getProduct().getPrice();
        			double price2 = oi2.getProduct().getPrice();
        			System.out.println(price1 + " " + price2);
        			oi.setQuantity(oi.getQuantity()-1);
        			oi2.setQuantity(oi2.getQuantity()-1);
        		}
        	}
        }


    }
    
    public double getDiscount() {
        return discount;
    }

}
