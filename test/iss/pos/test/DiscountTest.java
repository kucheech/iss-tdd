package iss.pos.test;

import static org.junit.Assert.*;

import org.junit.Test;
import iss.pos.*;
import iss.pos.promotion.*;

public class DiscountTest {

    @Test
    public void test1ABuy1Item() {

        //setup
        Promotion promo = new Promotion(1); //TODO: setup the promotion as you see fit
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
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

    @Test
    public void test1BBuy2ItemsOfSameSKU() {

        //setup
        Promotion promo = new Promotion(1); //TODO: setup the promotion as you see fit
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
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test1CBuy2ItemsOfSameStyle() {

        //setup
        Promotion promo = new Promotion(1); //TODO: setup the promotion as you see fit
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
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test1CBuy2ItemsOfSameStyleCheckTotalPrice() {

        //setup
        Promotion promo = new Promotion(1); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 1);
        order.add(Products.GetProduct("greenDress"), 1);

        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 150; //$50 discount for blue dress
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, order.getTotalPrice(), 0.001);
        assertEquals(expectedValue, newOrder.getTotalPrice(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test1DBuyOddItemsOfSameSKU() {

        //setup
        Promotion promo = new Promotion(1); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 5);

        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 60;
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

     @Test
    public void test1DBuyEvenItemsOfSameSKU() {

        //setup
        Promotion promo = new Promotion(1); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 4);

        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 60;
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }


    @Test
    public void test2ABuy1Item() {

        //setup
        Promotion promo = new Promotion(2); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 1);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0.1*Products.GetProduct("blueDress").getPrice(); 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test2BBuy2ItemsOfSameStyle() {

        //setup
        Promotion promo = new Promotion(2); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 1);
        order.add(Products.GetProduct("greenDress"), 1);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0.2 * (Products.GetProduct("blueDress").getPrice() + Products.GetProduct("greenDress").getPrice()); 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test2BBuy2ItemsOfSameStyle2() {

        //setup
        Promotion promo = new Promotion(2); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 2);
      
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0.2 * (Products.GetProduct("blueDress").getPrice() * 2 ); 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    
    @Test
    public void test2CBuyMoreThan2ItemsOfSameStyle() {

        //setup
        Promotion promo = new Promotion(2); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 1);
        order.add(Products.GetProduct("greenDress"), 1);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0.2 * (Products.GetProduct("blueDress").getPrice() + Products.GetProduct("greenDress").getPrice()); 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

    @Test
    public void test2DBuy1ItemOfStyleAAndBuy1ItemOfStyleB() {

        //setup
        Promotion promo = new Promotion(2); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 1);
        order.add(Products.GetProduct("whiteSocks"), 1);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0.1 * (Products.GetProduct("blueDress").getPrice() + Products.GetProduct("whiteSocks").getPrice()); 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
	
    @Test
    public void test2EBuy1ItemOfStyleAAndBuy2ItemOfStyleB() {

        //setup
        Promotion promo = new Promotion(2); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("blueDress"), 1);
        order.add(Products.GetProduct("redSocks"), 2);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0.1 * Products.GetProduct("blueDress").getPrice() + 0.2*Products.GetProduct("redSocks").getPrice()*2; 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

    @Test
    public void test3ABuy1Socks() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 1);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test3ABuy2SocksOfSameSKU() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 2);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

    @Test
    public void test3ABuy2SocksOfDifferentSKUs() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 1);
        order.add(Products.GetProduct("invisibleWhiteSocks"), 1);
        
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 0; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

    @Test
    public void test3BBuy3SocksOfSameSKU() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 3);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 20; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test3BBuy3SocksOfDifferentSKU() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 2);
        order.add(Products.GetProduct("invisibleWhiteSocks"), 1);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 20; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    

    @Test
    public void test3CBuyMoreThan3SocksOfSameSKUAndMultipleOf3() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 6);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 40; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test3CBuyMoreThan3SocksOfDifferentSKUAndMultipleOf3() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 3);
        order.add(Products.GetProduct("invisibleWhiteSocks"), 3);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 40; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    

    @Test
    public void test3DBuyMoreThan3SocksOfSameSKUAndNotMultipleOf3() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 5);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 20; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

    public void test3DBuyMoreThan3SocksOfDifferentSKUAndNotMultipleOf3() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 3);
        order.add(Products.GetProduct("invisibleWhiteSocks"), 2);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 20; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    public void test3EMixOf3SocksAndOtherItems() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 3);
        order.add(Products.GetProduct("invisibleWhiteSocks"), 2);
        order.add(Products.GetProduct("blueDress"), 2);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 20; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test3EBuy3SocksOfSameSKUAndOtherItems() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 3);
        order.add(Products.GetProduct("blueDress"), 2);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 20; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test3EBuy3SocksOfDifferentSKUAndOtherItems() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 2);
        order.add(Products.GetProduct("invisibleWhiteSocks"), 1);
        order.add(Products.GetProduct("blueDress"), 2);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 20; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    

    @Test
    public void test3EBuyMoreThan3SocksOfSameSKUAndMultipleOf3AndOtherItems() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 6);
        order.add(Products.GetProduct("blueDress"), 2);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 40; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    @Test
    public void test3EBuyMoreThan3SocksOfDifferentSKUAndMultipleOf3AndOtherItems() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 3);
        order.add(Products.GetProduct("invisibleWhiteSocks"), 3);
        order.add(Products.GetProduct("blueDress"), 2);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 40; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    

    @Test
    public void test3EBuyMoreThan3SocksOfSameSKUAndNotMultipleOf3AndOtherItems() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 5);
        order.add(Products.GetProduct("blueDress"), 2);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 20; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }

    public void test3EBuyMoreThan3SocksOfDifferentSKUAndNotMultipleOf3AndOtherItems() {

        //setup
        Promotion promo = new Promotion(3); //TODO: setup the promotion as you see fit
        DiscountCalculator dc = new DiscountCalculator(promo);

//        Order order = null; //TODO: setup the order, you can refer to SampleTest.java for example
        Order order = new Order();
        order.add(Products.GetProduct("invisibleRedSocks"), 3);
        order.add(Products.GetProduct("invisibleWhiteSocks"), 2);
        order.add(Products.GetProduct("blueDress"), 2);
        
        //exercise
        Order newOrder = dc.calculateDiscount(order);

        //verify
        //double expectedValue = 0;//TODO: set the expected value;
        double expectedValue = 20; //no discount 
        //System.out.println("discount: " + expectedValue);
        assertEquals(expectedValue, newOrder.getTotalDiscount(), 0.001);
        //TODO: add additional verification if necessary
    }
    
    
}
