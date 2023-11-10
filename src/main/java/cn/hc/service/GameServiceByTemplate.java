package cn.hc.service;

import cn.hc.domain.Game;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * mongodb核心，非常灵活
 */
@Service
public class GameServiceByTemplate implements GameService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Game selectGame(String id) {
        return mongoTemplate.findById(id, Game.class);
    }

    @Override
    public Page<Game> selectGamePage(Game game) {
        return null;
//        Query query = new Query(Criteria
//                .where("name").is(game.getName())
//                .and("").is(null));
//        return mongoTemplate.find(query, Game.class);
    }

    @Override
    public List<Game> selectGameList(Game game) {
        Query query = new Query(Criteria
                .where("name").regex(game.getName()!=null?game.getName():"")
                .and("developer").regex(game.getDeveloper()!=null?game.getDeveloper():""));
        return mongoTemplate.find(query, Game.class);
    }

    @Override
    public Game insertGame(Game game) {
        return mongoTemplate.insert(game);
    }

    @Override
    public Game updateGame(Game game) {
        Query query = new Query(Criteria.where("_id").is(game.getId()));
        Update update = new Update();
        UpdateResult updateResult = mongoTemplate.upsert(query, update, Game.class);
        if (updateResult.getModifiedCount() > 0) {
            return game;
        } else {
            return null;
        }
    }

    @Override
    public void deleteGame(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        mongoTemplate.remove(query);
    }
}
