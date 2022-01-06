package cn.eviao.k8slearn.usercenter.web;

import cn.eviao.k8slearn.usercenter.entity.User;
import cn.eviao.k8slearn.usercenter.entity.Result;
import cn.eviao.k8slearn.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        var sessionUser = userService.login(user.getEmail(), user.getPassword());
        if (sessionUser == null) {
            throw new RuntimeException("登录失败");
        }
        return Result.create("登录成功", sessionUser);
    }

    @DeleteMapping("/logout")
    public Result logout() {
        userService.logout();
        return Result.create("注销成功");
    }
}
