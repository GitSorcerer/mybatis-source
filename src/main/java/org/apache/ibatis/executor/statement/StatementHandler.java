/**
 * Copyright 2009-2016 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ibatis.executor.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.ResultHandler;

/**
 * @author Clinton Begin
 * <p>
 * 封装了JDBC Statement操作，负责对JDBC statement 的操作，如设置参数、将Statement结果集转换成List集合
 * <p>
 * 创建 Statement 对象，为 SQL 语句绑定实参，执
 * 行 select、 insert、 update 、 delete 等多种类型的 SQL 语句，批量执行 SQL 语句，将结果集映射
 * 成结果对象
 */
public interface StatementHandler {

  Statement prepare(Connection connection, Integer transactionTimeout)
    throws SQLException;

  void parameterize(Statement statement)
    throws SQLException;

  void batch(Statement statement)
    throws SQLException;

  int update(Statement statement)
    throws SQLException;

  <E> List<E> query(Statement statement, ResultHandler resultHandler)
    throws SQLException;

  <E> Cursor<E> queryCursor(Statement statement)
    throws SQLException;

  BoundSql getBoundSql();

  ParameterHandler getParameterHandler();

}
