package cn.eviao.k8slearn.usercenter.web;

import cn.eviao.k8slearn.usercenter.entity.User;
import cn.eviao.k8slearn.usercenter.entity.Result;
import cn.eviao.k8slearn.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.register(user);
        return Result.create("注册成功");
    }
}
