package cn.hc.service;

import cn.hc.dao.GameRepository;
import cn.hc.domain.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class GameServiceByRepository implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> selectGameList(Game game) {
        return gameRepository.findAll();
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
}
