package com.javastudio.service;

import com.javastudio.api.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneralServiceImpl implements GeneralService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public String execute(String query) {
        jdbcTemplate.query(query, new ResultSetExtractor<Object>() {
            @Override
            public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                return null;
            }
        });
        return "";
    }
}
