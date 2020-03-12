package life.majiang.community.community.controller;

import life.majiang.community.community.mapper.UserMapper;
import life.majiang.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){
        //获取所有cookie值放入数组里
        Cookie[] cookies = request.getCookies();
        //循环cookie数组
        for (Cookie cookie : cookies) {
            //获取cookie数组中name为"token"的value值
            //并通过value进入数据库查询获取user的值
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                if(user != null){
                    //创建一个session
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }

        return "index";
    }
}
