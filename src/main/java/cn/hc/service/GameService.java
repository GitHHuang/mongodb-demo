package cn.hc.service;

import cn.hc.domain.Game;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GameService {
    public Game selectGame(String id);

    public List<Game> selectGameList(Game game);

    public Page<Game> selectGamePage(Game game);

    public Game insertGame(Game game) throws Exception;

    public Game updateGame(Game game) throws Exception;
}
