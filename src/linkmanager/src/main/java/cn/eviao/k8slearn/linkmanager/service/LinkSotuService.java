package cn.eviao.k8slearn.linkmanager.service;

import cn.eviao.k8slearn.linkmanager.entity.Link;
import feign.Headers;
import feign.RequestLine;

public interface LinkSotuService {

    @RequestLine("POST /tasks")
    @Headers("Content-Type: application/json")
    void createTask(Link link);
}
