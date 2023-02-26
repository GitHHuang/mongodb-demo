package cn.hc.dao;

import cn.hc.domain.Content;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContentRepository extends MongoRepository<Content, String> {

}
