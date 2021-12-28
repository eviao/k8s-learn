package cn.eviao.k8slearnusercenter.repository;

import cn.eviao.k8slearnusercenter.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
