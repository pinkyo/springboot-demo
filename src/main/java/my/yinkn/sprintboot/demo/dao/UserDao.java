package my.yinkn.sprintboot.demo.dao;

import my.yinkn.sprintboot.demo.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yinkn on 2017/7/9.
 */
public interface UserDao extends PagingAndSortingRepository<UserEntity, String> {

    UserEntity findByName(String name);
}
