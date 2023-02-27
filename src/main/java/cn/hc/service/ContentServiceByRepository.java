package cn.hc.service;

import cn.hc.dao.ContentRepository;
import cn.hc.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceByRepository {
    @Autowired
    private ContentRepository contentRepository;

    public List<Content> selectContentList() {
        return contentRepository.findAll();
    }

    public Content insertContent(Content content) {
        return contentRepository.insert(content);
    }

    public Content updateContent(Content content) {
        //todo
        return content;
    }
}
