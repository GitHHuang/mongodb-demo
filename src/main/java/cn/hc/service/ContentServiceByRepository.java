package cn.hc.service;

import cn.hc.dao.ContentRepository;
import cn.hc.domain.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ContentServiceByRepository {
    @Autowired
    private ContentRepository contentRepository;

    public List<Content> selectContentList() {
        return contentRepository.findAll();
    }

    public Content insertContent(Content content) throws Exception {
        if (StringUtils.hasLength(content.getId())) {
            throw new Exception("创建文档时ID必须为空");
        }
        return contentRepository.save(content);
    }

    public Content updateContent(Content content) throws Exception {
        if (!StringUtils.hasLength(content.getId())) {
            throw new Exception("更新文档时ID不能为空");
        }
        return contentRepository.save(content);
    }
}
