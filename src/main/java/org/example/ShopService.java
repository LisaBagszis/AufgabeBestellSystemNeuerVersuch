package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class ShopService {
    private ProductRepo productRepo;
    private OrderRepo orderRepo;

    public ShopService () {
        productRepo = new ProductRepo();
        orderRepo = new OrderRepo();
    }

    public void listProducts() {
        System.out.println(productRepo.list());
    }

    public void getProduct(String id) {
        System.out.println(productRepo.get(id));

    }

    public void listOrders() {
        System.out.println(orderRepo.list());
    }

    public void getOrder(String id) {
        System.out.println(orderRepo.get(id));
    }

    public Order addOrder(List<String> productIds) {
       List<Product> allProducts = new ArrayList<>();

       for (String productId: productIds){
         Product product =  productRepo.get(productId);

           if (product == null) {
               throw new NoSuchElementException("Product with Id: " + productId + " not found!");
           }
           allProducts.add(product);
       }
       Order order = new Order(UUID.randomUUID().toString(), allProducts);
       orderRepo.add(order);

        return order;
    }
}
