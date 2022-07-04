package com.naturaltel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class SequenceDAO extends BaseDAO {
    private JdbcOperations jdbcOperations;
    
    @Autowired
    public SequenceDAO(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    
	private static int parseVO(ResultSet rs) throws SQLException {
		int rtn = rs.getInt("C");
		return rtn;
	}

	private static final class ThisRowMapper implements RowMapper<Integer> {
		@Override
		public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
			return parseVO(rs);
		}
	}

	public Integer getNextVal(String sequenceName) {
		String SQL = "SELECT "+  DB_NAME + ".NEXTVAL('" + sequenceName + "') as C";

		logger.debug("SQL[{}]", SQL);

		return jdbcOperations.queryForObject(SQL, new ThisRowMapper());
	}
}