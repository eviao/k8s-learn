package cn.eviao.k8slearn.linkmanager.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private Integer id;
    private String email;
    private String name;
    private Date createdAt;
    private Date updatedAt;
}
