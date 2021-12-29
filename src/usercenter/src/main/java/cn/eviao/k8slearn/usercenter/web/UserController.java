package cn.eviao.k8slearn.usercenter.web;

import cn.eviao.k8slearn.usercenter.ParamsBindingException;
import cn.eviao.k8slearn.usercenter.model.User;
import cn.eviao.k8slearn.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(
            @RequestBody @Valid User user,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            throw new ParamsBindingException(result);
        }
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User update(
            @PathVariable Integer id,
            @RequestBody @Valid User user,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            throw new ParamsBindingException(result);
        }
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return userService.findById(id).orElse(null);
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
}
