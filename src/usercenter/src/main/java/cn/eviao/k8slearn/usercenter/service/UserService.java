package cn.eviao.k8slearn.usercenter.service;

import cn.eviao.k8slearn.usercenter.model.User;
import cn.eviao.k8slearn.usercenter.repository.UserRepository;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        user.setName(user.getName().trim());

        var now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        return userRepository.save(user);
    }

    public User update(Integer id, User user) {
        return userRepository.findById(id)
                .map(it -> {
                    if (Strings.isNotBlank(user.getName())) {
                        it.setName(user.getName());
                    }
                    it.setUpdatedAt(LocalDateTime.now());
                    return userRepository.save(it);
                })
                .orElseThrow();
    }

    public boolean delete(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }
}
