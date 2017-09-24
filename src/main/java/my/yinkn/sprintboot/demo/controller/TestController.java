package my.yinkn.sprintboot.demo.controller;

import my.yinkn.sprintboot.demo.entity.UserEntity;
import my.yinkn.sprintboot.demo.model.User;
import my.yinkn.sprintboot.demo.dao.UserDao;
import my.yinkn.sprintboot.demo.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yinkn on 2017/7/9.
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Value("${test.default.name}")
    private String defaultName;

    @Autowired
    UserDao userDao;

    @RequestMapping(method = RequestMethod.POST)
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