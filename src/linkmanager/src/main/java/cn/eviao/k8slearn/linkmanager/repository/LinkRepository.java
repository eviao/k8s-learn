package cn.eviao.k8slearn.linkmanager.repository;

import cn.eviao.k8slearn.linkmanager.entity.Link;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LinkRepository extends CrudRepository<Link, Integer> {

    List<Link> findAllByUserid(Integer userid, Sort sort);
}
