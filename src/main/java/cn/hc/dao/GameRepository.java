package cn.hc.dao;

import cn.hc.domain.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface GameRepository extends MongoRepository<Game, String> {
    List<Game> getByNameLikeAndDeveloperLike(String name, String developer);

    Page<Game> findByName(String name, Pageable pageable);
}
