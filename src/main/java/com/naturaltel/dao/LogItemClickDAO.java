package com.naturaltel.dao;

import com.naturaltel.vo.db.LogItemClickVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class LogItemClickDAO extends BaseDAO {
    private JdbcOperations jdbcOperations;
    
    private static final String TABLE_NAME = DB_NAME + ".logitemclick";

    @Autowired
    public LogItemClickDAO(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }
    
    @SuppressWarnings("unused")
    private LogItemClickVO parserLogItemClickVO(ResultSet rs) throws SQLException {
        LogItemClickVO vo = new LogItemClickVO();
        vo.setIndexId(rs.getInt("indexId"));
        vo.setSessionId(rs.getString("sessionId"));
        vo.setChannel(rs.getString("channel"));
        vo.setMsisdn(rs.getString("msisdn"));
        vo.setLoginType(rs.getString("loginType"));
        vo.setUserAccount(rs.getString("userAccount"));
        vo.setUserid(rs.getString("userid"));
        vo.setPageId(rs.getString("pageId"));
        vo.setItemType(rs.getInt("itemType"));
        vo.setItemId(rs.getString("itemId"));
        vo.setCreateTime(rs.getTimestamp("createTime"));
        vo.setOperator(rs.getString("operator"));
        return vo;
    }

    public int insert(LogItemClickVO vo) {
        final String SQL = "INSERT INTO " + TABLE_NAME  + " (sessionId, channel ,msisdn, loginType, userAccount, userid, pageId, itemType, itemId, createTime, operator) "
                + "  VALUES (?,?,?,?,?,?,?,?,?,now(),?)";
        logger.debug("SQL[{}], sessionId=[{}],channel=[{}], msisdn=[{}], loginType=[{}], userAccount=[{}], userid=[{}], pageId=[{}], itemType=[{}], " +
                        "itemId=[{}], createTime=[{}], operator=[{}]", SQL, vo.getSessionId(), vo.getChannel(), vo.getMsisdn(), vo.getLoginType(), vo.getUserAccount(),
                vo.getUserid(), vo.getPageId(), vo.getItemType(), vo.getItemId(), vo.getCreateTime(), vo.getOperator());

        List<Object> parameters = new ArrayList<>();
        parameters.add(vo.getSessionId());
        parameters.add(vo.getChannel());
        parameters.add(vo.getMsisdn());
        parameters.add(vo.getLoginType());
        parameters.add(vo.getUserAccount());
        parameters.add(vo.getUserid());
        parameters.add(vo.getPageId());
        parameters.add(vo.getItemType());
        parameters.add(vo.getItemId());
        parameters.add(vo.getOperator());

        int affectedRows = jdbcOperations.update(SQL,  parameters.toArray());
        return affectedRows;
    }    
}