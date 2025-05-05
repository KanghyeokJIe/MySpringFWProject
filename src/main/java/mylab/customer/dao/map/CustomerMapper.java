package mylab.customer.dao.map;

import mylab.customer.vo.CustomerVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    List<CustomerVO> selectAllCustomer();
    CustomerVO selectCustomer(int id);
    void insertCustomer(CustomerVO customer);
}
