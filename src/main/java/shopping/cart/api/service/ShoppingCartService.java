package shopping.cart.api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopping.cart.api.entity.CustomerEntity;
import shopping.cart.api.entity.ShoppingCartEntity;
import shopping.cart.api.repository.CartItemRepository;

import java.util.List;

@Service
public class ShoppingCartService {

    private static final Logger logger = LogManager.getLogger(ShoppingCartService.class);

    @Autowired
    CartItemRepository cartItemRepository;

    public List<ShoppingCartEntity> getShoppingCartItems(CustomerEntity customerEntity){
        return cartItemRepository.findAllByCustomerId(customerEntity.getId());
    }
}
