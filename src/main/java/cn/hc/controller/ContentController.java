package cn.hc.controller;


import cn.hc.domain.Content;
import cn.hc.service.ContentServiceByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContentController {

    @Autowired
    private ContentServiceByRepository contentServiceByRepository;

    @RequestMapping("/content-list")
    public List<Content> getContentList() {
        List<Content> contents = contentServiceByRepository.selectContentList();
        return contents;
    }

}
