package com.naturaltel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.naturaltel.vo.db.UserLampInfoVO;

@Repository
public class UserLampInfoDAO extends BaseDAO {

	private JdbcOperations jdbcOperations;
	private static final String TABLE_NAME = DB_NAME + ".userlampinfo";

	@Autowired
	public UserLampInfoDAO(JdbcOperations jdbcOperations) {
		this.jdbcOperations = jdbcOperations;
	}

	public UserLampInfoVO getUserLampInfo(String fateOrder) {
		String SQL = "SELECT * FROM " + TABLE_NAME + " WHERE fateOrder = ?";

		logger.debug("SQL:[{}], fateOrder:[{}]", SQL, fateOrder);

		List<UserLampInfoVO> list = null;
		
		try {
			list = jdbcOperations.query(SQL, new Object[] {fateOrder}, new UserLampInfoVORowMapper());
		} catch(Exception e) {
			logger.debug(e);
		}
		
		if (list.size() == 0) {
			return null;
		}
		UserLampInfoVO userLampInfoVO = list.get(0);
		logger.info("fateHistoryVO:[{}]", userLampInfoVO);
		
		return userLampInfoVO;
	}

	public int insertUserLampInfo(UserLampInfoVO userLampInfoVO) {
		String fateOrder = userLampInfoVO.getFateOrder();
		String msisdn = userLampInfoVO.getMsisdn();
		String name = userLampInfoVO.getName();
		String birthDay = userLampInfoVO.getBirthDay();
		String area = userLampInfoVO.getArea();
		String city = userLampInfoVO.getCity();
		String dist = userLampInfoVO.getDist();
		String road = userLampInfoVO.getRoad();
		String wishMsg = userLampInfoVO.getWishMsg();

		String name_luckyProduct = userLampInfoVO.getName_luckyProduct();
		String area_luckyProduct = userLampInfoVO.getArea_luckyProduct();
		String city_luckyProduct = userLampInfoVO.getCity_luckyProduct();
		String dist_luckyProduct = userLampInfoVO.getDist_luckyProduct();
		String road_luckyProduct = userLampInfoVO.getRoad_luckyProduct();

		String SQL = "INSERT INTO " + TABLE_NAME + " (fateOrder, msisdn, name, birthDay, area, city, dist, road, wishMsg," +
				" name_luckyProduct, area_luckyProduct, city_luckyProduct, dist_luckyProduct, road_luckyProduct)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		logger.debug("SQL:[{}], fateOrder:[{}], msisdn:[{}], name:[{}], birthDay:[{}], area:[{}], city:[{}], dist:[{}], road:[{}], wishMsg:[{}]," +
						" name_luckyProduct:[{}], area_luckyProduct:[{}], city_luckyProduct:[{}], dist_luckyProduct:[{}], road_luckyProduct:[{}] "
				, SQL, fateOrder, msisdn, name, birthDay, area, city, dist, road, wishMsg,
				name_luckyProduct, area_luckyProduct, city_luckyProduct, dist_luckyProduct, road_luckyProduct);

		List<Object> parameters = new ArrayList<>();
		parameters.add(fateOrder);
		parameters.add(msisdn);
		parameters.add(name);
		parameters.add(birthDay);
		parameters.add(area);
		parameters.add(city);
		parameters.add(dist);
		parameters.add(road);
		parameters.add(wishMsg);
		parameters.add(name_luckyProduct);
		parameters.add(area_luckyProduct);
		parameters.add(city_luckyProduct);
		parameters.add(dist_luckyProduct);
		parameters.add(road_luckyProduct);

		return jdbcOperations.update(SQL, parameters.toArray());
	}

//	public int updateUserInfoVotive(String fateOrder, String msisdn, String votiveType) {		
//		String SQL = "UPDATE " + TABLE_NAME + " SET isVotive=1, votiveType=? WHERE fateOrder = ? AND msisdn = ?";
//
//		logger.debug("SQL:[{}], votiveType:[{}], fateOrder:[{}], msisdn:[{}]"
//				, SQL, votiveType, fateOrder, msisdn);
//
//		List<Object> parameters = new ArrayList<>();
//		parameters.add(votiveType);
//		parameters.add(fateOrder);
//		parameters.add(msisdn);
//		
//		return jdbcOperations.update(SQL, parameters.toArray());
//	}

	private class UserLampInfoVORowMapper implements RowMapper<UserLampInfoVO> {
		@Override
		public UserLampInfoVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserLampInfoVO userLampInfoVO = new UserLampInfoVO();

			userLampInfoVO.setIdx(rs.getInt("idx"));
			userLampInfoVO.setFateOrder(rs.getString("fateOrder"));
			userLampInfoVO.setMsisdn(rs.getString("msisdn"));
			userLampInfoVO.setName(rs.getString("name"));
			userLampInfoVO.setBirthDay(rs.getString("birthDay"));
			userLampInfoVO.setArea(rs.getString("area"));
			userLampInfoVO.setCity(rs.getString("city"));
			userLampInfoVO.setDist(rs.getString("dist"));
			userLampInfoVO.setRoad(rs.getString("road"));
			userLampInfoVO.setWishMsg(rs.getString("wishMsg"));

			userLampInfoVO.setName_luckyProduct(rs.getString("name_luckyProduct"));
			userLampInfoVO.setArea_luckyProduct(rs.getString("area_luckyProduct"));
			userLampInfoVO.setCity_luckyProduct(rs.getString("city_luckyProduct"));
			userLampInfoVO.setDist_luckyProduct(rs.getString("dist_luckyProduct"));
			userLampInfoVO.setRoad_luckyProduct(rs.getString("road_luckyProduct"));

			return userLampInfoVO;
		}
	}
}