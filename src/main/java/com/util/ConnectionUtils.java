package com.util;/********************************************************************
 /**
 * @Project: test_maven
 * @Package jdbc
 * @author guohongjin
 * @date 2017/8/28 22:12
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.sql.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author guohongjin
 * @ClassName ConnectionUtils
 * @Description 类描述
 * @date 2017/8/28
 */
public class ConnectionUtils implements Connection {
    //3.定义一个变量
    private Connection conn;

    private LinkedList<Connection> pool;

    // 2.编写一个构造方法(参数使用了面相对象的多态特性)
    public ConnectionUtils(Connection conn, LinkedList<Connection> pool) {
        this.conn=conn;
        this.pool=pool;
    }

    //4.书写需要增强的方法
    @Override
    public void close() throws SQLException {
        pool.add(conn);
    }

    /**
     * 此方法必须覆盖！否则会出现空指针异常！！！
     */
    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Statement createStatement() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String nativeSQL(String sql) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean getAutoCommit() throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void commit() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void rollback() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isClosed() throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public DatabaseMetaData getMetaData() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setReadOnly(boolean readOnly) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isReadOnly() throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setCatalog(String catalog) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public String getCatalog() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTransactionIsolation(int level) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getTransactionIsolation() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void clearWarnings() throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Class<?>> getTypeMap() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setHoldability(int holdability) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getHoldability() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Savepoint setSavepoint() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Savepoint setSavepoint(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void rollback(Savepoint savepoint) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void releaseSavepoint(Savepoint savepoint) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
                                              int resultSetHoldability) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
                                         int resultSetHoldability) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Clob createClob() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Blob createBlob() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NClob createNClob() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SQLXML createSQLXML() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isValid(int timeout) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setClientInfo(String name, String value) throws SQLClientInfoException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setClientInfo(Properties properties) throws SQLClientInfoException {
        // TODO Auto-generated method stub

    }

    @Override
    public String getClientInfo(String name) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Properties getClientInfo() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setSchema(String schema) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public String getSchema() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void abort(Executor executor) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
        // TODO Auto-generated method stub

    }

    @Override
    public int getNetworkTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
