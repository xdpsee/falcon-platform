package com.zhenhui.demo.falcon.service.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.zhenhui.demo.falcon.core.domain.CommandType;
import com.zhenhui.demo.falcon.core.support.utils.JSONUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class CommandTypeListTypeHandler extends BaseTypeHandler<List<CommandType>> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<CommandType> parameter, JdbcType jdbcType)
        throws SQLException {
        ps.setString(i, JSONUtils.toJsonString(parameter));
    }

    @Override
    public List<CommandType> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        return JSONUtils.fromJsonString(value, new TypeReference<List<CommandType>>() {});
    }

    @Override
    public List<CommandType> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        return JSONUtils.fromJsonString(value, new TypeReference<List<CommandType>>() {});

    }

    @Override
    public List<CommandType> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        return JSONUtils.fromJsonString(value, new TypeReference<List<CommandType>>() {});

    }
}
