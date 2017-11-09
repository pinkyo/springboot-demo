package my.pinkyo.demo.controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import my.pinkyo.demo.model.User;
import my.pinkyo.demo.service.UserService;

/**
 * Created by pinkyo on 2017/7/9.
 */
@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Validated @NotNull User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public User getUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@RequestBody @Validated @NotNull User user) {
        userService.updateUser(user);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserByName(@PathVariable String name) {
        userService.deleteUserByName(name);
    }
}
