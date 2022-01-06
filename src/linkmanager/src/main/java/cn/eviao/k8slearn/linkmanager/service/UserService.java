package cn.eviao.k8slearn.linkmanager.service;

import cn.eviao.k8slearn.linkmanager.entity.User;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface UserService {

    @RequestLine("GET /users/{id}")
    @Headers("Content-Type: application/json")
    User findById(@Param("id") Integer id);
}
