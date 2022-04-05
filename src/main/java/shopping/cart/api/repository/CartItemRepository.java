package shopping.cart.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopping.cart.api.entity.ShoppingCartEntity;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<ShoppingCartEntity,Integer> {
    List<ShoppingCartEntity> findAllByCustomerId(Integer customerId);
}
