package org.fwx.controller;

import org.fwx.bean.User;
import org.fwx.exception.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/26 8:05
 * @Version 1.0
 */
@Controller
public class IndexController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 处理用户登录请求的控制器方法。
     *
     * <p>该方法映射了根路径("/")和登录路径("/login")的 GET 请求，
     * 当用户访问这些路径时，会返回一个名为 "login" 的视图，
     * 通常这会是一个登录表单页面。</p>
     *
     * @return 返回一个字符串，指示视图的名称，这里是"login"。
     */
    @GetMapping({"/","/login"})
    public String login() {
        return "login";
    }

    /**
     * 处理用户登录请求。
     *
     * @param session HttpSession对象，用于在服务器端保存用户会话信息。
     * @param user 用户对象，包含用户登录时提交的用户名和密码。
     * @param model Model对象，用于在视图和控制器之间传递数据。
     * @return 返回登录成功后重定向到的页面路径或登录失败时返回的视图名称。
     */
    @PostMapping("/login")
    public String toMain(HttpSession session, User user, Model model) {

        // 验证用户名和密码是否正确
        if (user.getUserName().equals("admin") && user.getPassword().equals("123456")) {
            // 登录成功，将用户信息保存到session中
            session.setAttribute("user", user);
            // 重定向到主页面
            return "redirect:main.html";
        } else {
            // 登录失败，向模型中添加错误消息，并返回登录页面
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }



    /**
     * 处理访问主页面的请求。
     *
     * @param session  HttpSession对象，用于检查用户是否已登录。
     * @param model    Model对象，用于在重定向或渲染视图时传递数据。
     * @return 返回字符串指示视图的名称或重定向的URL。
     */
    @GetMapping("/main.html")
    public String main(HttpSession session, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {

        ValueOperations<String, String> forValue = stringRedisTemplate.opsForValue();
        String mainCount = forValue.get("/main.html");
        String sqlCount = forValue.get("/sql");

        model.addAttribute("mainCount", mainCount);
        model.addAttribute("sqlCount", sqlCount);

        // 异常处理：用于测试自定义异常 org.fwx.exception.ResponseStatusException
        /*if (session != null) {
            throw new ResponseStatusException();
        }*/

        // 异常处理：用于测试 mvc 异常处理，mvc底层会处理，跳转到错误页面
        /*try {
            response.sendError(403,"访问拒绝！");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


        /*
        // 用拦截器代替
        // 检查用户是否已登录
        if(session.getAttribute("user") != null){
            // 如果已登录，返回主页面
            return "main";
        } else {
            // 如果未登录，向模型添加消息，并重定向到登录页面
            // 重定向，把错误信息传递到登录页面。这个只会把参数传递过去显示在url上
            // 可以用session传递msg
            // redirectAttributes.addAttribute("msg", "请先登录");
            // return "redirect:login";

            //请求转发，把错误信息传递到登录页面
            model.addAttribute("msg", "请先登录");
            return "login";
        }*/
        return "main";
    }


}
