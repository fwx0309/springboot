package org.fwx.controller;

import org.fwx.bean.Person;
import org.fwx.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ParamController
 * @Description TODO
 * @Author Fwx
 * @Date 2024/4/23 18:01
 * @Version 1.0
 */
@RestController
public class ParamController {

    @PostMapping("/bean")
    public String requestBody(User user){
        return "user: " + user ;
    }

    @GetMapping("/car/{id}/owner/{username}")
    public String pathVariable(@PathVariable("id") String id,@PathVariable("username") String username,@PathVariable
    Map<String,String> map){
        return "id: " + id + " username: " + username + " map: " + map;
    }

    @GetMapping("/requestHeader")
    public String requestHeader(@RequestHeader("user-agent") String userAgent,@RequestHeader Map<String, String> map){
        return "userAgent: " + userAgent + "; map: " + map;
    }

    @PostMapping("/map")
    public String requestBody(@RequestParam Map<String,Object> map){
        return "map: " + map ;
    }

    @GetMapping("/requestParam")
    public String requestParam(@RequestParam("username") String username,
                               @RequestParam("inters") List<String> inters,
                               @RequestParam Map<String, String> map)   //这个参数里面inters只能获取到一个值
    {
        return "username: " + username + "; inters: " + inters + "; map: " + map;
    }

    /**
     * 要访问两次，第一次访问用httpsession生成的cookie，第二次访问用cookie获取sessionid
     * @param session
     * @param jsessionid
     * @param cookie
     * @return
     */
    @GetMapping("/cookieValue")
    public String cookieValue(HttpSession session, @CookieValue("JSESSIONID") String jsessionid, @CookieValue("JSESSIONID") Cookie cookie){
        return "session: " + session + "; jsessionid: " + jsessionid + "; cookie.getValue(): "
                + cookie.getValue() + "; cookie.getName(): " + cookie.getName();
    }

    @PostMapping("/requestBody")
    public String requestBody(@RequestBody String body){
        return "body: " + body ;
    }

    @GetMapping("/matrixVariable/{sell}")
    public String matrixVariable(@MatrixVariable("low") String low,
                                 @MatrixVariable("brand") List<String> brand,
                                 @PathVariable("sell") String sell ){
        return "low: " + low + "; brand: " + brand + "; sell: " + sell;
    }

    @GetMapping("/boss/{bossId}/{empId}")
    public String boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        return bossAge + " " + empAge;
    }

    /**
     * 自定义类型转换器，将person中的pet，用自定的Converter转换
     * @param person
     * @return
     */
    @PostMapping("/savePerson")
    public String savePerson(Person person){
        return person.toString();
    }
}
