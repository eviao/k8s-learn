package cn.eviao.k8slearn.linkmanager.repository;

import cn.eviao.k8slearn.linkmanager.entity.Link;
import org.springframework.data.repository.CrudRepository;

public interface LinkRepository extends CrudRepository<Link, Integer> {
}
