package com.neo.repository.impl;

import com.neo.dao.UserMapper;
import com.neo.model.User;
import com.neo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <p>
 *
 * </p>
 * Create by xiancreate on 2021-08-19 21:13
 */
@Service(value = "mySQLImpl")
public class UserRepositoryMySQLImpl implements UserRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {

    }

    @Override
    public User findUserByUserName(String userName) {

        User user = new User();
        user.setUserName(userName);
        return jdbcTemplate.queryForObject("select * from user where username=?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                String username = rs.getString("username");
                String id = rs.getString("id");
                String password = rs.getString("password");
                User user1 = new User();
                user1.setUserName(userName);
                user1.setPassWord(password);
                user1.setId(Long.valueOf(id));
                return user1;
            }
        },userName);
    }



    @Override
    public long updateUser(User user) {
        return 0;
    }

    @Override
    public void deleteUserById(Long id) {

    }

    @Override
    public User findUserByUserNameMyBatis(String username) {
        return userMapper.getUserByUserName(username);
    }


}
