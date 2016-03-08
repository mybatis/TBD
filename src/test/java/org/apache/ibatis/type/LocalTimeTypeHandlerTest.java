/**
 *    Copyright 2016 the original author or authors.
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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.time.LocalTime;

import org.junit.Test;

public class LocalTimeTypeHandlerTest extends BaseTypeHandlerTest {

  private static final TypeHandler<LocalTime> TYPE_HANDLER = new LocalTimeTypeHandler();
  // java.sql.Time doesn't contain millis, so set nano to 0
  private static final LocalTime LOCAL_TIME = LocalTime.now().withNano(0);
  private static final Time TIME = Time.valueOf(LOCAL_TIME);

  @Override
  @Test
  public void shouldSetParameter() throws Exception {
    TYPE_HANDLER.setParameter(ps, 1, LOCAL_TIME, null);
    verify(ps).setTime(1, TIME);
  }

  @Override
  @Test
  public void shouldGetResultFromResultSet() throws Exception {
    when(rs.getTime("column")).thenReturn(TIME);
    assertEquals(LOCAL_TIME, TYPE_HANDLER.getResult(rs, "column"));
  }

  @Override
  @Test
  public void shouldGetResultFromCallableStatement() throws Exception {
    when(cs.getTime(1)).thenReturn(TIME);
    assertEquals(LOCAL_TIME, TYPE_HANDLER.getResult(cs, 1));
  }
}
