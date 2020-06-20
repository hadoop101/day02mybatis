package pack01.dao;

import pack01.bean.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
