package demo.controller;

import demo.domain.CacheEntity;
import demo.repository.RedisRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisRepo repo;

    @RequestMapping(value = "/v1/save", method = RequestMethod.POST)
    public List<CacheEntity> saveEntities(@RequestBody String key){
        repo.save(key);
        return new ArrayList<>();
    }
}
