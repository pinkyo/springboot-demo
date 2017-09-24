package my.pinkyo.demo.dao;

import my.pinkyo.demo.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yinkn on 2017/7/9.
 */
public interface UserDao extends PagingAndSortingRepository<UserEntity, String> {

    UserEntity findByName(String name);
}
