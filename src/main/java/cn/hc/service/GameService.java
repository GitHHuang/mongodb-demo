package cn.hc.service;

import cn.hc.domain.Game;

import java.util.List;

public interface GameService {
    public List<Game> selectGameList(Game game);

    public Game insertGame(Game game) throws Exception;

    public Game updateGame(Game game) throws Exception;
}
