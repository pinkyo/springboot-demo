package my.pinkyo.demo.controller;

import my.pinkyo.demo.dao.UserDao;
import my.pinkyo.demo.entity.UserEntity;
import my.pinkyo.demo.model.User;
import my.pinkyo.demo.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pinkyo on 2017/7/9.
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Value("${test.default.name}")
    private String defaultName;

    @Autowired
    UserDao userDao;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody @Validated User user) {
        UserEntity entity = ModelUtil.convertToEntity(user);
        userDao.save(entity);

        return "successful";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        UserEntity entity = userDao.findByName(name);
        return ModelUtil.convertToModel(entity);
    }

    @RequestMapping(method = RequestMethod.GET)
    private String getDefaultName() {
        return defaultName;
    }

}
