package cn.hc.service;

import cn.hc.dao.ContentRepository;
import cn.hc.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceByTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    // public List<Content> selectContentList() {
    //     return contentRepository.findAll();
    // }
    //
    // public Content insertContent(Content content) {
    //     return contentRepository.insert(content);
    // }
    //
    // public Content updateContent(Content content) {
    //     return contentRepository.
    // }
}
