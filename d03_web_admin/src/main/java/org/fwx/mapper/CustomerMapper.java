package org.fwx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fwx.bean.Customer;

import java.util.List;

/**
 * @ClassName CustomerMapper
 * @Description mybatis mapper
 * @Author Fwx
 * @Date 2024/4/29 8:38
 * @Version 1.0
 */
@Mapper
public interface CustomerMapper {

    public List<Customer> findAll();

    @Select("select * from customers where id = #{id}")
    public Customer findById(Integer id);
}
