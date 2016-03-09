package iss.pos.test;

import static org.junit.Assert.*;

import org.junit.Test;
import iss.pos.*;
import iss.pos.promotion.*;

public class DiscountTest {

    @Test
    public void test1ABuy1Item() {

        //setup
        Promotion promo = new Promotion(); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 1);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0; //no discount
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

    @Test
    public void test1BBuy2ItemsOfSameSKU() {

        //setup
        Promotion promo = new Promotion(); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 2);

        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0.3 * Products.GetProduct("blueDress").getPrice();
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test1CBuy2ItemsOfSameStyle() {

        //setup
        Promotion promo = new Promotion(); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 1);
        order.add(Products.GetProduct("greenDress"), 1);

        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 50; //$50 discount for blue dress
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

    
    @Test
    public void test1DBuyOddItemsOfSameSKU() {

        //setup
        Promotion promo = new Promotion(); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 5);

        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = order.getDiscount(); //no discount
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

     @Test
    public void test1DBuyEvenItemsOfSameSKU() {

        //setup
        Promotion promo = new Promotion(); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 2);

        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = order.getDiscount(); //no discount
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }


}
