package mylab.customer;

import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {
        "classpath:spring-beans.xml",
        "classpath:spring-beans-mybatis.xml"
})
public class CustomerSpringTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void insertAndCheckLastCustomer() {
        CustomerVO customer = new CustomerVO();
        customer.setName("장보고");
        customer.setEmail("jang@example.com");
        customer.setAge(40);

        customerService.insertCustomer(customer);
        System.out.println("고객 등록 완료");

        List<CustomerVO> customers = customerService.getAllCustomerList();
        assertFalse(customers.isEmpty());

        CustomerVO last = customers.get(customers.size() - 1);
        System.out.println("마지막 고객 정보: " + last);

        assertEquals("장보고", last.getName());
        assertEquals("jang@example.com", last.getEmail());
    }
}
