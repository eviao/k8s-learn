package cn.eviao.k8slearn.usercenter.service;

import cn.eviao.k8slearn.usercenter.entity.User;
import cn.eviao.k8slearn.usercenter.entity.SessionUser;
import cn.eviao.k8slearn.usercenter.repository.UserRepository;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private HttpSession session;

    private String digestPassword(String password) {
        return new String(DigestUtils.sha256Hex(password));
    }

    public User register(User user) {
        var password = digestPassword(user.getPassword());
        user.setPassword(password);

        var now = LocalDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public SessionUser login(String email, String password) {
        var user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(digestPassword(password))) {
            return null;
        }

        var sessionUser = new SessionUser(user);
        session.setAttribute("user", sessionUser);

        return sessionUser;
    }

    @Transactional(readOnly = true)
    public void logout() {
        session.invalidate();
    }
}
