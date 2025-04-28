package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	
	// 해설본 코드
	@Autowired
	ShoppingCart cart;
	
	@Autowired
	OrderService service;
	
	@Test
	void testShoppingCart() {
		assertNotNull(cart);
        assertEquals(2, cart.getProducts().size());
        assertEquals("노트북", cart.getProducts().get(0).getName());
        assertEquals("스마트폰", cart.getProducts().get(1).getName());
	}	
	
	@Test
	void testOrderService() {
		assertNotNull(service);
        assertNotNull(service.getShoppingCart());
        assertEquals(2300000.0, service.calculateOrderTotal(), 0.001);
	}
}
