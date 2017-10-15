package my.pinkyo.demo.service.impl.v1;

import my.pinkyo.demo.dao.UserDao;
import my.pinkyo.demo.entity.UserEntity;
import my.pinkyo.demo.exception.BadRequestException;
import my.pinkyo.demo.model.User;
import my.pinkyo.demo.service.UserService;
import my.pinkyo.demo.util.ModelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User createUser(User user) {
        if (isUserExist(user.getName())) { throw new BadRequestException("user have existed."); }

        UserEntity entity = ModelUtil.convertToEntity(user);
        UserEntity result = userDao.save(entity);

        return ModelUtil.convertToModel(result);
    }

    @Override
    public void updateUser(User user) {
        if (!isUserExist(user.getName())) { throw new BadRequestException("user is not found."); }

        UserEntity entity = userDao.findByName(user.getName());
        entity.setSex(user.getSex());
    }

    @Override
    public User getUserByName(String name) {
        UserEntity entity = userDao.findByName(name);
        if (entity == null) {
            throw new BadRequestException("user is not found.");
        }
        return ModelUtil.convertToModel(entity);
    }

    @Override
    public void deleteUserByName(String name) {
        if (!isUserExist(name)) {
            throw new BadRequestException("user is not found.");
        }

        UserEntity entity = userDao.findByName(name);
        userDao.delete(entity);
    }

    private boolean isUserExist(String userName) {
        return userDao.findByName(userName) != null;
    }

}
