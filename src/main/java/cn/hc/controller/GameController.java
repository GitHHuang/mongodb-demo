package cn.hc.controller;


import cn.hc.domain.Game;
import cn.hc.service.GameServiceByRepository;
import cn.hc.service.GameServiceByTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameServiceByRepository gameServiceByRepository;

    @Autowired
    private GameServiceByTemplate gameServiceByTemplate;

    @RequestMapping("/game/{id}")
    public Game getGame(@PathVariable("id") String id) {
        Game game = gameServiceByRepository.selectGame(id);
        System.out.println("game");
        return game;
    }

    @RequestMapping("/game-page")
    public Page<Game> getGamePage(Game game) {
        Page<Game> games = gameServiceByRepository.selectGamePage(game);
        System.out.println(games);
        return games;
    }

    @RequestMapping("/game-list")
    public List<Game> getGameList(Game game) {
        List<Game> games = gameServiceByRepository.selectGameList(game);
        System.out.println(games);
        return games;
    }

    @PostMapping("/game")
    public String addGame(@RequestBody Game game) throws Exception {
        gameServiceByRepository.insertGame(game);
        System.out.println(game);
        return "保存成功";
    }

    @PutMapping("/game")
    public String editGame(@RequestBody Game game) throws Exception {
        gameServiceByRepository.updateGame(game);
        System.out.println(game);
        return "保存成功";
    }

    @DeleteMapping("/game/{id}")
    public String delGame(@PathVariable("id") String id) {
        gameServiceByRepository.deleteGame(id);
        return "删除成功";
    }

}
