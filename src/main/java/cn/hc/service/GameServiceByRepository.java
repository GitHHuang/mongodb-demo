package cn.hc.service;

import cn.hc.dao.GameRepository;
import cn.hc.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.data.domain.Page;


import java.util.List;

/**
 * JPA模式，不够灵活
 */
@Service
public class GameServiceByRepository implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Override
    public Game selectGame(String id) {
        return gameRepository.findById(id).get();
    }

    @Override
    public Page<Game> selectGamePage(Game game) {
        return gameRepository.findByName(game.getName(), PageRequest.of(0, 5));
    }

    @Override
    public List<Game> selectGameList(Game game) {
        return gameRepository.getByNameLikeAndDeveloperLike(game.getName(), game.getDeveloper());
    }

    @Override
    public Game insertGame(Game game) throws Exception {
        if (StringUtils.hasLength(game.getId())) {
            throw new Exception("创建文档时ID必须为空");
        }
        return gameRepository.save(game);
    }

    @Override
    public Game updateGame(Game game) throws Exception {
        if (!StringUtils.hasLength(game.getId())) {
            throw new Exception("更新文档时ID不能为空");
        }
        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(String id) {
        gameRepository.deleteById(id);
    }
}
