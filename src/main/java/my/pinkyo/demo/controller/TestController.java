package my.pinkyo.demo.controller;

import my.pinkyo.demo.model.User;
import my.pinkyo.demo.service.UserService;
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
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Validated User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody @Validated User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserByName(String name) {
        userService.deleteUserByName(name);
    }

    @RequestMapping(method = RequestMethod.GET)
    private String getDefaultName() {
        return defaultName;
    }

}
