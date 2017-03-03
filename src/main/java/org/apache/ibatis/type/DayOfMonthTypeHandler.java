/**
 *    Copyright 2016-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.threeten.extra.DayOfMonth;

/**
 * Type Handler for threeten-extra DayOfMonth
 * 
 * @author Björn Raupach
 */
public class DayOfMonthTypeHandler extends BaseTypeHandler<DayOfMonth> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int parameterIndex, DayOfMonth dayOfMonth, JdbcType type) throws SQLException {
        ps.setInt(parameterIndex, dayOfMonth.getValue());
    }

    @Override
    public DayOfMonth getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int dayOfMonth = rs.getInt(columnName);
        return dayOfMonth == 0 ? null : DayOfMonth.of(dayOfMonth);
    }

    @Override
    public DayOfMonth getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int dayOfMonth = rs.getInt(columnIndex);
        return dayOfMonth == 0 ? null : DayOfMonth.of(dayOfMonth);
    }

    @Override
    public DayOfMonth getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int dayOfMonth = cs.getInt(columnIndex);
        return dayOfMonth == 0 ? null : DayOfMonth.of(dayOfMonth);
    }
    
}
