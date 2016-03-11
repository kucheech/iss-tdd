package iss.pos;

import iss.pos.promotion.DiscountCalculator;
import iss.pos.promotion.Promotion;
import iss.pos.test.Products;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		Order order = new Order();

		ArrayList<Product> productList = new ArrayList<>();
		Iterator it = Products.getProducts().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			productList.add((Product) pair.getValue());
		}

		Scanner in = new Scanner(System.in);

		Promotion promo = new Promotion(1); // TODO: setup the promotion as you
											// see fit

		System.out.println("Enter promotion to disable or N to skip");
		String sinput = in.nextLine();

		try {
			int promotionToDisable = Integer.parseInt(sinput);
			promo.DisablePromotion(promotionToDisable);
		} catch (NumberFormatException e) {
			System.out.println("Not disabling any promotion");
		}

		while (true) {
			int i;
			for (i = 0; i < productList.size(); ++i) {
				System.out.println((i + 1) + ": "
						+ productList.get(i).getName());
			}
			System.out.println((i + 1) + ": <QUIT>\n");

			System.out.print("Select: ");
			int input = in.nextInt();

			if (input == i + 1) {
				break;
			}

			System.out.print("Qty: ");
			int qty = in.nextInt();

			if (input > 0 && input <= productList.size()) {
				order.add(productList.get(input - 1), qty);
			}

			System.out.println();
		}

		DiscountCalculator dc = new DiscountCalculator(promo);
		Order newOrder = dc.calculateDiscount(order);

		System.out.println("\nCart:");

		List<OrderItem> items = order.getItems();
		Iterator<OrderItem> itr = items.iterator();

		while (itr.hasNext()) {
			OrderItem oi = itr.next();
			Product p = oi.getProduct();
			System.out.println(" " + p.getName() + ": " + oi.getQuantity());
		}

		System.out.println("Total: $" + newOrder.getTotalPrice());
		System.out.println("Discount: $" + newOrder.getTotalDiscount());

		in.close();
	}

}
