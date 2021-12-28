package cn.eviao.k8slearn.usercenter.repository;

import cn.eviao.k8slearn.usercenter.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
