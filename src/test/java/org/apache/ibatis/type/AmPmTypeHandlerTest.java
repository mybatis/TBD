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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.threeten.extra.AmPm;
import static org.threeten.extra.AmPm.*;


/**
 * @author Björn Raupach
 */
public class AmPmTypeHandlerTest extends BaseTypeHandlerTest {
    
    private static final TypeHandler<AmPm> TYPE_HANDLER = new AmPmTypeHandler();

    @Override
    @Test
    public void shouldSetParameter() throws Exception {
        TYPE_HANDLER.setParameter(ps, 1, AM, null);
        verify(ps).setString(1, AM.name());
        
        TYPE_HANDLER.setParameter(ps, 1, PM, null);
        verify(ps).setString(1, PM.name());
    }

    @Override
    @Test
    public void shouldGetResultFromResultSetByName() throws Exception {
        when(rs.getString("column")).thenReturn(AM.name());
        assertEquals(AM, TYPE_HANDLER.getResult(rs, "column"));
        
        when(rs.getString("column")).thenReturn(PM.name());
        assertEquals(PM, TYPE_HANDLER.getResult(rs, "column"));
    }

    @Override
    @Test
    public void shouldGetResultNullFromResultSetByName() throws Exception {
        when(rs.getString("column")).thenReturn(null);
        when(rs.wasNull()).thenReturn(true);
        assertNull(TYPE_HANDLER.getResult(rs, "column"));
    }

    @Override
    @Test
    public void shouldGetResultFromResultSetByPosition() throws Exception {
        when(rs.getString(1)).thenReturn(AM.name());
        assertEquals(AM, TYPE_HANDLER.getResult(rs, 1));
        
        when(rs.getString(1)).thenReturn(PM.name());
        assertEquals(PM, TYPE_HANDLER.getResult(rs, 1));
    }

    @Override
    @Test
    public void shouldGetResultNullFromResultSetByPosition() throws Exception {
        when(rs.getString(1)).thenReturn(null);
        when(rs.wasNull()).thenReturn(true);
        assertNull(TYPE_HANDLER.getResult(rs, 1));
    }

    @Override
    @Test
    public void shouldGetResultFromCallableStatement() throws Exception {
        when(cs.getString(1)).thenReturn(AM.name());
        assertEquals(AM, TYPE_HANDLER.getResult(cs, 1));
        
        when(cs.getString(1)).thenReturn(PM.name());
        assertEquals(PM, TYPE_HANDLER.getResult(cs, 1));
    }

    @Override
    @Test
    public void shouldGetResultNullFromCallableStatement() throws Exception {
        when(cs.getString(1)).thenReturn(null);
        when(cs.wasNull()).thenReturn(true);
        assertNull(TYPE_HANDLER.getResult(cs, 1));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowDateTimeException() throws Exception {
        when(rs.getString("column")).thenReturn("some value");
        ((AmPmTypeHandler)TYPE_HANDLER).getNullableResult(rs, "column");
    }
    
}
