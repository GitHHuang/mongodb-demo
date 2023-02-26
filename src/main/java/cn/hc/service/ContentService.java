package cn.hc.service;

import cn.hc.dao.ContentRepository;
import cn.hc.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    @Autowired
    private ContentRepository contentRepository;

    public List<Content> selectContentList() {
        return contentRepository.findAll();
    }
}
