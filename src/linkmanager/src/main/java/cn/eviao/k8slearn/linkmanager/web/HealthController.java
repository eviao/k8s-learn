package cn.eviao.k8slearn.linkmanager.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthy")
public class HealthController {

    @GetMapping
    public String ping() {
        return "ping";
    }
}
