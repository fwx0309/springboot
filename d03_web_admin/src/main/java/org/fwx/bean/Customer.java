package org.fwx.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;

/**
 * @ClassName Customer
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/28 12:52
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    private int id;
    private String name;
    private String email;
    private Date birth;

}
