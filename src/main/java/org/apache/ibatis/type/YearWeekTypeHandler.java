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
import org.threeten.extra.YearWeek;

/**
 * Type Handler for threeten-extra YearWeek
 * 
 * @author Björn Raupach
 */
public class YearWeekTypeHandler extends BaseTypeHandler<YearWeek> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int parameterIndex, YearWeek yearWeek, JdbcType type) throws SQLException {
        ps.setString(parameterIndex, yearWeek.toString());
    }

    @Override
    public YearWeek getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        return getYearWeek(str);
    }

    @Override
    public YearWeek getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        return getYearWeek(str);
    }

    @Override
    public YearWeek getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        return getYearWeek(str);
    }
    
    private static YearWeek getYearWeek(String str) {
        if (str != null) {
            return YearWeek.parse(str);
        }
        return null;
    }
    
}
