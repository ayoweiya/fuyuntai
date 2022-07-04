package com.naturaltel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.naturaltel.vo.db.FateHistoryVO;

@Repository
public class FateHistoryDAO extends BaseDAO {

	private JdbcOperations jdbcOperations;
	private static final String TABLE_NAME = DB_NAME + ".fate_history";

	@Autowired
	public FateHistoryDAO(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	public FateHistoryVO getFateHistoryVO(String fateOrder) {
		String SQL = "SELECT * FROM " + TABLE_NAME + " WHERE fateOrder = ?";

		logger.debug("SQL:[{}], fateOrder:[{}]", SQL, fateOrder);

		List<FateHistoryVO> list = null;
		
		try {
			list = jdbcOperations.query(SQL, new Object[] {fateOrder}, new FateHistoryVORowMapper());
		} catch(Exception e) {
			logger.debug(e);
		}
		
		if (list.size() == 0) {
			return null;
		}
		FateHistoryVO fateHistoryVO = list.get(0);
		logger.info("fateHistoryVO:[{}]", fateHistoryVO);
		
		return fateHistoryVO;
	}

	public List<FateHistoryVO> getFateHistoryVO(String msisdn, String lampType) {
		String SQL = "SELECT * FROM " + TABLE_NAME + " WHERE msisdn = ? AND lampType = ?";

		logger.debug("SQL:[{}], msisdn:[{}], lampType:[{}]", SQL, msisdn, lampType);

		List<FateHistoryVO> list = null;

		try {
			list = jdbcOperations.query(SQL, new Object[]{msisdn, lampType}, new FateHistoryVORowMapper());
		} catch (Exception e) {
			logger.debug(e);
		}
		
		if (list.size() == 0) {
			return null;
		}
		logger.info("fateHistoryVO List:[{}]", list);

		return list;
	}

	public List<FateHistoryVO> getFateHistoryListBymsisdn(String msisdn) {
		String SQL = "SELECT * FROM " + TABLE_NAME + " WHERE msisdn = ? ORDER BY createTime DESC";
		logger.debug("SQL:[{}], msisdn:[{}]", SQL, msisdn);
		
		List<FateHistoryVO> list = null;
		try {
			list = jdbcOperations.query(SQL, new Object[] {msisdn}, new FateHistoryVORowMapper());
		} catch(Exception e) {
			logger.debug(e);
		}

		return list;
	}

	public int insert(String fateOrder, String msisdn, String lampType) {
		String SQL = "INSERT INTO " + TABLE_NAME + " (fateOrder, msisdn, lampType) VALUES (?, ?, ?)";

		logger.debug("SQL:[{}], fateOrder:[{}], msisdn:[{}], lampType:[{}]"
				, SQL, fateOrder, msisdn, lampType);

		List<Object> parameters = new ArrayList<>();
		parameters.add(fateOrder);
		parameters.add(msisdn);
		parameters.add(lampType);
		
		return jdbcOperations.update(SQL, parameters.toArray());
	}

	public int update(String fateOrder, String msisdn) {
		String SQL = "UPDATE " + TABLE_NAME + " SET hasLampInfo=1 WHERE fateOrder = ? AND msisdn = ?";
		
		logger.debug("SQL:[{}], fateOrder:[{}], msisdn:[{}]" , SQL, fateOrder, msisdn);
		
		List<Object> parameters = new ArrayList<>();
		parameters.add(fateOrder);
		parameters.add(msisdn);
		
		return jdbcOperations.update(SQL, parameters.toArray());
	}
	
	public int updateUserInfoVotive(String fateOrder, String msisdn, String votiveType) {		
		String SQL = "UPDATE " + TABLE_NAME + " SET isVotive=1, votiveType=?, votiveTime=NOW() WHERE fateOrder = ? AND msisdn = ?";

		logger.debug("SQL:[{}], votiveType:[{}], fateOrder:[{}], msisdn:[{}]"
				, SQL, votiveType, fateOrder, msisdn);

		List<Object> parameters = new ArrayList<>();
		parameters.add(votiveType);
		parameters.add(fateOrder);
		parameters.add(msisdn);
		
		return jdbcOperations.update(SQL, parameters.toArray());
	}

	private class FateHistoryVORowMapper implements RowMapper<FateHistoryVO> {
		@Override
		public FateHistoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			FateHistoryVO fateHistoryVO = new FateHistoryVO();

			fateHistoryVO.setIdx(rs.getInt("idx"));
			fateHistoryVO.setFateOrder(rs.getString("fateOrder"));
			fateHistoryVO.setMsisdn(rs.getString("msisdn"));
			fateHistoryVO.setLampType(rs.getString("lampType"));
			fateHistoryVO.setHasLampInfo(rs.getInt("hasLampInfo"));
			fateHistoryVO.setIsVotive(rs.getInt("isVotive"));
			fateHistoryVO.setVotiveType(rs.getString("votiveType"));
			fateHistoryVO.setVotiveTime(rs.getTimestamp("votiveTime"));
			fateHistoryVO.setDeliver_Way_LuckyProduct(rs.getString("Deliver_Way_LuckyProduct"));
			fateHistoryVO.setDeliver_ID_LuckyProduct(rs.getString("Deliver_ID_LuckyProduct"));
			fateHistoryVO.setDeliver_Time_LuckyProduct(rs.getTimestamp("Deliver_Time_LuckyProduct"));
			fateHistoryVO.setCreateTime(rs.getTimestamp("createTime"));
			fateHistoryVO.setUpdateTime(rs.getTimestamp("updateTime"));

			return fateHistoryVO;
		}
	}
}