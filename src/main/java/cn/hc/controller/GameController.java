package cn.hc.controller;


import cn.hc.domain.Game;
import cn.hc.service.GameServiceByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameServiceByRepository gameServiceByRepository;

    @RequestMapping("/game-list")
    public List<Game> getGameList() {
        Game game = new Game();
        List<Game> games = gameServiceByRepository.selectGameList(game);
        return games;
    }
    
    @PostMapping("/game")
    public String addGame(@RequestBody Game game) throws Exception {
        gameServiceByRepository.insertGame(game);
        return "保存成功";
    }

    @PutMapping("/game")
    public String editGame(@RequestBody Game game) throws Exception {
        gameServiceByRepository.updateGame(game);
        return "保存成功";
    }

}
