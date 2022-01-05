package cn.eviao.k8slearn.linkmanager.service;

import cn.eviao.k8slearn.linkmanager.entity.Link;
import cn.eviao.k8slearn.linkmanager.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public Link create(Link link) {
        var now = LocalDateTime.now();
        link.setCreatedAt(now);
        link.setUpdatedAt(now);
        return linkRepository.save(link);
    }

    public void delete(Integer id) {
        linkRepository.deleteById(id);
    }
}
