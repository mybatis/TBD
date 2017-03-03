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
import org.threeten.extra.Months;

/**
 * Type handler for threeten-extra Months
 * @author raupach
 */
public class MonthsTypeHandler extends BaseTypeHandler<Months> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int parameterIndex, Months months, JdbcType type) throws SQLException {
        ps.setInt(parameterIndex, months.getAmount());
    }

    @Override
    public Months getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int months = rs.getInt(columnName);
        return rs.wasNull() ? null : Months.of(months);
    }

    @Override
    public Months getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int months = rs.getInt(columnIndex);
        return rs.wasNull() ? null : Months.of(months);
    }

    @Override
    public Months getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int months = cs.getInt(columnIndex);
        return cs.wasNull() ? null : Months.of(months);
    }
    
}
