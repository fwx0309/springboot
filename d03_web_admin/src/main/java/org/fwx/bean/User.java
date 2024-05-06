package org.fwx.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName User
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/26 8:11
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName("user")  // 如果表名和实体类名不一致，可以使用@TableName注解指定表名
public class User {

    // 表中没有的字段
    @TableField(exist = false)
    private String userName;
    private String password;


    private Integer id;
    private String name;

    private String address;

    private String phone;
}
