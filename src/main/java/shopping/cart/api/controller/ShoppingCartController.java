package shopping.cart.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shopping.cart.api.ApiConstants;
import shopping.cart.api.entity.CustomerEntity;
import shopping.cart.api.entity.ShoppingCartEntity;
import shopping.cart.api.service.ShoppingCartService;

import java.util.List;

@RestController
@RequestMapping(ApiConstants.SHOPPING_CART)
@Api(value = "ShoppingCart Controller", tags = {"ShoppingCart Controller"},
    description = "REST APIs for shopping cart create,update etc")
public class ShoppingCartController {

    private static final Logger logger = LogManager.getLogger(ShoppingCartController.class);

    @Autowired
    ShoppingCartService shoppingCartService;

    @ApiOperation("Get shopping cart items of each customer")
    @GetMapping(value = ApiConstants.CUSTOMER + ApiConstants.ID_PATH,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ShoppingCartEntity>> getShoppingCartDTO(CustomerEntity customerEntity){
        logger.debug("Customer Entity {}",customerEntity);
        return ResponseEntity.ok().body(shoppingCartService.getShoppingCartItems(customerEntity));
    }
}
