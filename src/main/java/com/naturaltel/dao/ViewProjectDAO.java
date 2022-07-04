package com.naturaltel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.naturaltel.vo.db.ViewProjectVO;

@Repository
public class ViewProjectDAO extends BaseDAO {
    private JdbcOperations jdbcOperations;
    
    private static final String TABLE_NAME = DB_NAME + ".view_project";

    @Autowired
    public ViewProjectDAO(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    
    private class ViewProjectVORowMapper implements RowMapper<ViewProjectVO> {
        @Override
        public ViewProjectVO mapRow(ResultSet rs, int rowNum) throws SQLException {        	
        	ViewProjectVO viewProject = new ViewProjectVO();
        	
        	viewProject.setIdx(rs.getInt("idx"));
        	viewProject.setWuxin(rs.getString("wuxin"));
        	viewProject.setProjectId(rs.getInt("projectId"));
        	viewProject.setProject(rs.getString("project"));
        	viewProject.setContent_free(rs.getString("content_free"));
        	viewProject.setContent(rs.getString("content"));
        	
            return viewProject;
        }
    }
    
    public ViewProjectVO getProjectByIdx(String idx) {
    	final String sql = "SELECT * FROM " + TABLE_NAME + " WHERE idx = ?";    	
    	logger.debug("SQL[{}], idx=[{}]", sql, idx);
    	
    	ViewProjectVO viewProject = null;
    	try {
    		viewProject = jdbcOperations.queryForObject(sql, new Object[]{idx}, new ViewProjectVORowMapper());    		
    		logger.info(viewProject);    		
    	} catch (Exception e) {
    		logger.info(e);
    	}

        return viewProject;
    }
}