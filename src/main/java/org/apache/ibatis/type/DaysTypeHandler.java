/*
 * Copyright 2017 MyBatis.org.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.threeten.extra.Days;

/**
 * Type Handler for threeten-extra Days
 * 
 * @author Björn Raupach
 */
public class DaysTypeHandler extends BaseTypeHandler<Days> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int parameterIndex, Days days, JdbcType type) throws SQLException {
        ps.setInt(parameterIndex, days.getAmount());
    }

    @Override
    public Days getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int days = rs.getInt(columnName);
        return rs.wasNull() ? null : Days.of(days);
    }

    @Override
    public Days getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int days = rs.getInt(columnIndex);
        return rs.wasNull() ? null : Days.of(days);
    }

    @Override
    public Days getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int days = cs.getInt(columnIndex);
        return cs.wasNull() ? null : Days.of(days);
    }
    
}
