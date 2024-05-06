package org.fwx.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.fwx.bean.User;
import org.fwx.service.UserPlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName TableController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/26 15:43
 * @Version 1.0
 */
@Controller
public class TableController {

    @Autowired
    private UserPlusService userPlusService;

    @GetMapping("/basic_table")
    public String basic_table(){
        int i = 1 /0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model,
                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize){
//        User admin = new User("admin", "123456");
//        model.addAttribute("users",admin);

        // 查询全部用户
        // List<User> list = userPlusService.list();

        // 使用mybatis分页查询
        Page<User> userPage = new Page<>(pageNum,pageSize);
        Page<User> users = userPlusService.page(userPage, null);
        model.addAttribute("users",users);

        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }
}
