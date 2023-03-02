package cn.hc.service;

import cn.hc.domain.Game;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceByTemplate implements GameService {
    @Autowired
    private MongoTemplate contentTemplate;

    @Override
    public List<Game> selectGameList(Game game) {
        Query query = new Query(Criteria
                .where("developer").is(game.getDeveloper())
                .and("").is(null));
        return contentTemplate.find(query, Game.class);
    }

    @Override
    public Game insertGame(Game game) {
        return contentTemplate.insert(game);
    }

    @Override
    public Game updateGame(Game game) {
        Query query = new Query(Criteria.where("_id").is(game.getId()));
        Update update = new Update();
        UpdateResult updateResult = contentTemplate.upsert(query, update, Game.class);
        if (updateResult.getModifiedCount() > 0) {
            return game;
        } else {
            return null;
        }
    }
}
