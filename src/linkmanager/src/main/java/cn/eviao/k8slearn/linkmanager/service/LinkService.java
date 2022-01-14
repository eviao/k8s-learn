package cn.eviao.k8slearn.linkmanager.service;

import cn.eviao.k8slearn.linkmanager.entity.Link;
import cn.eviao.k8slearn.linkmanager.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private LinkSotuService linkSotuService;

    public Link create(Link link) {
        var user = userService.findById(link.getUserid());
        link.setUserid(user.getId());
        link.setUsername(user.getName());

        var now = LocalDateTime.now();
        link.setCreatedAt(now);
        link.setUpdatedAt(now);

        var persisted = linkRepository.save(link);

        linkSotuService.createTask(persisted);

        return persisted;
    }

    public void delete(Integer id) {
        linkRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Link> findAllByUserid(Integer userid) {
        return linkRepository.findAllByUserid(userid,
                Sort.by(Sort.Direction.DESC, "createdAt"));
    }
}
