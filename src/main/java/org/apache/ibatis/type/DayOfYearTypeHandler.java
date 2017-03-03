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
import org.threeten.extra.DayOfYear;

/**
 * Type Handler for threeten-extra DayOfYear
 * 
 * @author Björn Raupach
 */
public class DayOfYearTypeHandler extends BaseTypeHandler<DayOfYear> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int parameterIndex, DayOfYear dayOfYear, JdbcType type) throws SQLException {
        ps.setInt(parameterIndex, dayOfYear.getValue());
    }

    @Override
    public DayOfYear getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int dayOfYear = rs.getInt(columnName);
        return dayOfYear == 0 ? null : DayOfYear.of(dayOfYear);
    }

    @Override
    public DayOfYear getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int dayOfYear = rs.getInt(columnIndex);
        return dayOfYear == 0 ? null : DayOfYear.of(dayOfYear);
    }

    @Override
    public DayOfYear getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int dayOfYear = cs.getInt(columnIndex);
        return dayOfYear == 0 ? null : DayOfYear.of(dayOfYear);
    }
    
}
