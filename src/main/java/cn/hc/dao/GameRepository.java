package cn.hc.dao;

import cn.hc.domain.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, String> {

}
