package org.fwx.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName User
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/23 19:22
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userName;

    private String email;
}
