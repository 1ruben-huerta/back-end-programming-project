package com.example.demo.services;

import com.example.demo.dao.CartRepository;
import com.example.demo.dao.CustomerRepository;
import com.example.demo.dto.Purchase;
import com.example.demo.dto.PurchaseResponse;
import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CartRepository cartRepository;
    private CustomerRepository customerRepository;
    @Autowired
    public CheckoutServiceImpl(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        String orderTrackingNumber;

        Cart cart = purchase.getCart();

        orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);

        Set<CartItem> cartItems = purchase.getCartItems();
        cartItems.forEach(item -> cart.add(item));
        cart.setStatus(StatusType.ordered);

        cart.setCartItems(purchase.getCartItems());
        cart.setCustomer(purchase.getCustomer());

        Customer customer = purchase.getCustomer();
        customer.add(cart);

        customerRepository.save(customer);
        cartRepository.save(cart);

        if(cartItems.isEmpty()) {
            return new PurchaseResponse("Error: Tracking number cannot be generated on an empty cart.");
        } else if (cart.getParty_size() <= 0) {
            return new PurchaseResponse("Error: Your party size must be above zero to generate a tracking number.");
        } else {
            return new PurchaseResponse(orderTrackingNumber);
        }
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
