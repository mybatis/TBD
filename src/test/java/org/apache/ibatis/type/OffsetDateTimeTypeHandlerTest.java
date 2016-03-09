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

import java.sql.Timestamp;
import java.time.OffsetDateTime;

import org.junit.Test;

public class OffsetDateTimeTypeHandlerTest extends BaseTypeHandlerTest {

  private static final TypeHandler<OffsetDateTime> TYPE_HANDLER = new OffsetDateTimeTypeHandler();
  private static final OffsetDateTime OFFSET_DATE_TIME = OffsetDateTime.now();
  private static final Timestamp TIMESTAMP = Timestamp.from(OFFSET_DATE_TIME.toInstant());

  @Override
  @Test
  public void shouldSetParameter() throws Exception {
    TYPE_HANDLER.setParameter(ps, 1, OFFSET_DATE_TIME, null);
    verify(ps).setTimestamp(1, TIMESTAMP);
  }

  @Override
  @Test
  public void shouldGetResultFromResultSet() throws Exception {
    when(rs.getTimestamp("column")).thenReturn(TIMESTAMP);
    assertEquals(OFFSET_DATE_TIME, TYPE_HANDLER.getResult(rs, "column"));
  }

  @Override
  public void shouldGetResultFromCallableStatement() throws Exception {
    when(cs.getTimestamp(1)).thenReturn(TIMESTAMP);
    assertEquals(OFFSET_DATE_TIME, TYPE_HANDLER.getResult(cs, 1));
  }
}
