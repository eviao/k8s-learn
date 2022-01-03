package cn.eviao.k8slearn.usercenter.web;

import cn.eviao.k8slearn.usercenter.ApplicationException;
import cn.eviao.k8slearn.usercenter.model.Result;
import cn.eviao.k8slearn.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        if (!userService.login(username, password)) {
            throw new ApplicationException("登录失败");
        }
        return Result.create("登录成功");
    }

    @DeleteMapping("/logout")
    public Result logout() {
        userService.logout();
        return Result.create("注销成功");
    }
}
