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

import java.time.DateTimeException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.threeten.extra.DayOfYear;

/**
 * @author Björn Raupach
 */
public class DayOfYearTypeHandlerTest extends BaseTypeHandlerTest {
    
    private static final TypeHandler<DayOfYear> TYPE_HANDLER = new DayOfYearTypeHandler();
    private static final DayOfYear INSTANT = DayOfYear.now();

    @Override
    @Test
    public void shouldSetParameter() throws Exception {
        TYPE_HANDLER.setParameter(ps, 1, INSTANT, null);
        verify(ps).setInt(1, INSTANT.getValue());
    }

    @Override
    @Test
    public void shouldGetResultFromResultSetByName() throws Exception {
        when(rs.getInt("column")).thenReturn(INSTANT.getValue());
        assertEquals(INSTANT, TYPE_HANDLER.getResult(rs, "column"));
    }

    @Override
    @Test
    public void shouldGetResultNullFromResultSetByName() throws Exception {
        when(rs.getInt("column")).thenReturn(0);
        when(rs.wasNull()).thenReturn(true);
        assertNull(TYPE_HANDLER.getResult(rs, "column"));
    }

    @Override
    @Test
    public void shouldGetResultFromResultSetByPosition() throws Exception {
        when(rs.getInt(1)).thenReturn(INSTANT.getValue());
        assertEquals(INSTANT, TYPE_HANDLER.getResult(rs, 1));
    }

    @Override
    @Test
    public void shouldGetResultNullFromResultSetByPosition() throws Exception {
        when(rs.getInt(1)).thenReturn(0);
        when(rs.wasNull()).thenReturn(true);
        assertNull(TYPE_HANDLER.getResult(rs, 1));
    }

    @Override
    @Test
    public void shouldGetResultFromCallableStatement() throws Exception {
        when(cs.getInt(1)).thenReturn(INSTANT.getValue());
        assertEquals(INSTANT, TYPE_HANDLER.getResult(cs, 1));
    }

    @Override
    @Test
    public void shouldGetResultNullFromCallableStatement() throws Exception {
        when(cs.getInt(1)).thenReturn(0);
        when(cs.wasNull()).thenReturn(true);
        assertNull(TYPE_HANDLER.getResult(cs, 1));
    }
    
    @Test(expected = DateTimeException.class)
    public void shouldThrowDateTimeException() throws Exception {
        when(rs.getInt("column")).thenReturn(999);
        ((DayOfYearTypeHandler)TYPE_HANDLER).getNullableResult(rs, "column");
    }
    
}
