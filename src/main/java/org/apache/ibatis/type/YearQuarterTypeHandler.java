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
import org.threeten.extra.YearQuarter;

/**
 * Type Handler for threeten-extra YearQuarter
 * 
 * @author Björn Raupach
 */
public class YearQuarterTypeHandler extends BaseTypeHandler<YearQuarter> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int parameterIndex, YearQuarter yearQuarter, JdbcType type) throws SQLException {
        ps.setString(parameterIndex, yearQuarter.toString());
    }

    @Override
    public YearQuarter getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        return getYearQuarter(str);
    }

    @Override
    public YearQuarter getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        return getYearQuarter(str);
    }

    @Override
    public YearQuarter getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        return getYearQuarter(str);
    }
    
    private static YearQuarter getYearQuarter(String str) {
        if (str != null) {
            return YearQuarter.parse(str);
        }
        return null;
    }
    
}
