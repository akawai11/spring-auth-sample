package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public User getUser(String id) {
        String sql = "SELECT ID, NAME, PASSWORD FROM USER WHERE ID=:id";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);

        List<User> userList = namedParameterJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(User.class));

        return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
    }

}
