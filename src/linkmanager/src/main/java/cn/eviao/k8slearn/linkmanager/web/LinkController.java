package cn.eviao.k8slearn.linkmanager.web;

import cn.eviao.k8slearn.linkmanager.entity.Link;
import cn.eviao.k8slearn.linkmanager.entity.Result;
import cn.eviao.k8slearn.linkmanager.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping
    public Result create(@RequestBody Link link) {
        var result = linkService.create(link);
        return Result.create(result);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        linkService.delete(id);
        return Result.create("删除成功");
    }
}
