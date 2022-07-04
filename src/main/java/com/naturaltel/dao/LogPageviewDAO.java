package com.naturaltel.dao;
import com.naturaltel.vo.db.LogPageviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LogPageviewDAO extends BaseDAO {
    private JdbcOperations jdbcOperations;
    
    private static final String TABLE_NAME = DB_NAME + ".logpageview";

    @Autowired
    public LogPageviewDAO(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @SuppressWarnings("unused")
    private LogPageviewVO parserLogPageviewVO(ResultSet rs)  throws SQLException {
        LogPageviewVO vo = new LogPageviewVO();

        vo.setIndexId(rs.getInt("indexId"));
        vo.setSessionId(rs.getString("sessionId"));
        vo.setChannel(rs.getString("channel"));
        vo.setCreateTime(rs.getTimestamp("createTime"));
        vo.setMsisdn(rs.getString("msisdn"));
        vo.setLoginType(rs.getString("loginType"));
        vo.setUserAccount(rs.getString("userAccount"));
        vo.setUserid(rs.getString("userid"));
        vo.setPageId(rs.getString("pageId"));
        vo.setFromPageId(rs.getString("fromPageId"));
        vo.setOperator(rs.getString("operator"));

        return vo;
    }

    public int insert(LogPageviewVO vo)  {
        final String SQL = "INSERT INTO " + TABLE_NAME + " (sessionId, channel,createTime, msisdn, loginType, userAccount, userid, pageId, fromPageId, operator) " +
                "VALUES (?,?,now(),?,?,?,?,?,?,?)";

        logger.debug("SQL[{}],sessionId=[{}], channel=[{}], createTime=[{}], msisdn=[{}], loginType=[{}], userAccount=[{}], userid=[{}], pageId=[{}], " +
                        "fromPageId=[{}], operator=[{}], ", SQL , vo.getSessionId(), vo.getChannel(), vo.getCreateTime(), vo.getMsisdn(),
                vo.getLoginType(), vo.getUserAccount(), vo.getUserid(), vo.getPageId(), vo.getFromPageId(), vo.getOperator());

        List<Object> parameters = new ArrayList<>();
        parameters.add(vo.getSessionId());
        parameters.add(vo.getChannel());
        parameters.add(vo.getMsisdn());
        parameters.add(vo.getLoginType());
        parameters.add(vo.getUserAccount());
        parameters.add(vo.getUserid());
        parameters.add(vo.getPageId());
        parameters.add(vo.getFromPageId());
        parameters.add(vo.getOperator());

        int affectedRows = jdbcOperations.update(SQL, parameters.toArray());
        return affectedRows;
    }
}