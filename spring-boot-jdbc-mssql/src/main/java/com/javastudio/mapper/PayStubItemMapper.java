package com.javastudio.mapper;

import com.javastudio.dto.PayStubItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PayStubItemMapper implements RowMapper<PayStubItem> {
    @Override
    public PayStubItem mapRow(ResultSet resultSet, int i) throws SQLException {
        PayStubItem payStubItem = new PayStubItem();
        payStubItem.setName(resultSet.getString("Name"));
        payStubItem.setTitle(resultSet.getString("Title"));
        payStubItem.setCompensationFactorPropertyId(resultSet.getLong("CompensationFactorPropertyRef"));
        payStubItem.setApplyYearMonth(resultSet.getString("ApplyYearMonth"));
        payStubItem.setAmount(resultSet.getLong("Value"));
        payStubItem.setCompensationFactorId(resultSet.getLong("CompensationFactorID"));
        return payStubItem;
    }
}
