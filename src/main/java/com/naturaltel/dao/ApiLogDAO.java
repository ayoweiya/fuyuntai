package com.naturaltel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

@Repository
public class ApiLogDAO extends BaseDAO {
    private JdbcOperations jdbcOperations;
    
    private static final String TABLE_NAME = DB_NAME + ".api_log";

    @Autowired
    public ApiLogDAO(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    
    public void insert(String method, String param, String type, String ip) {
    	final String sql = "INSERT INTO " + TABLE_NAME + " (method, param, type, ip, updateTime)"
    			+ " VALUES (?, ?, ?, ?, now(6))";
    	
    	logger.debug("SQL[{}], method=[{}], param=[{}], type=[{}], ip=[{}]",
    			sql, method, param, type, ip);
    	
    	jdbcOperations.update(sql, new Object[]{method, param, type, ip});
    }
}