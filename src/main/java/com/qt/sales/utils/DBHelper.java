package com.qt.sales.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.sql.DataSource;

/**
 * 数据库工具类
 * <p>
 * 提供一个访问数据库的简单封装
 * 
 * @author 杜忠(Michael.Du)
 * @version 1.0
 * @since 1.5
 */

public class DBHelper {

	private Connection conn = null;

	private Statement stmt = null;

	private PreparedStatement pstmt = null;

	private ResultSet rst = null;

	private String driver = null;

	private String url = null;

	private String username = null;

	private String password = null;

	private void getConnect() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, password);
	}

	/**
	 * 构造器1
	 * <p>DBHelper提供丰富的构造器，方便使用，本构造器是标准的方法。
	 * @param driver 数据库驱动类
	 * @param url 数据库访问的连接
	 * @param username 数据库的用户名
	 * @param password 数据库用户的密码
	 * @throws ClassNotFoundException 无法找到数据库驱动类
	 * @throws SQLException 抛出SQL异常
	 */
	public DBHelper(String driver, String url, String username, String password)
			throws ClassNotFoundException, SQLException {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		getConnect();
	}

	/**
	 * 构造器2
	 * <p>从数据源获取数据库连接。
	 * @param ds 数据源
	 * @throws SQLException 抛出SQL异常
	 */
	public DBHelper(DataSource ds) throws SQLException {
		conn = ds.getConnection();
	}

	/**
	 * 构造器3
	 * <p>直接传入数据库连接。
	 * @param conn 数据库连接
	 */
	public DBHelper(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 构造器4
	 * <p>从Properties中获得数据库的初始化参数，创建数据库连接。
	 * @param props 参数
	 * @throws ClassNotFoundException 无法找到数据库驱动类
	 * @throws SQLException 抛出SQL异常
	 */
	public DBHelper(Properties props) throws ClassNotFoundException,
			SQLException {
		url = props.getProperty("url");
		driver = props.getProperty("driver");
		username = props.getProperty("username");
		password = props.getProperty("password");
		getConnect();
	}

	/**
	 * 构造器5
	 * <p>从ResourceBundle中获得数据库的初始化参数，创建数据库连接。
	 * @param props 参数
	 * @throws ClassNotFoundException 无法找到数据库驱动类
	 * @throws SQLException 抛出SQL异常
	 */
	public DBHelper(ResourceBundle props) throws ClassNotFoundException,
			SQLException {
		url = props.getString("url");
		driver = props.getString("driver");
		username = props.getString("username");
		password = props.getString("password");
		getConnect();
	}

	/**
	 * 构造器6
	 * <p>通过参数路径，找到参数，创建数据库连接。
	 * @param propsPath 参数路径
	 * @throws ClassNotFoundException 无法找到数据库驱动类
	 * @throws SQLException 抛出SQL异常
	 * @throws IOException 
	 */
	public DBHelper(String propsPath) throws ClassNotFoundException,
			SQLException, IOException {
		ResourceBundle props = ResourceBundle.getBundle(propsPath);
		url = props.getString("url");
		driver = props.getString("driver");
		username = props.getString("username");
		password = props.getString("password");
		getConnect();
	}

	/**
	 * 获取当前数据库连接
	 * @return Connection 数据库连接
	 */
	public Connection getConnection() {
		return conn;
	}

	/**
	 * 设置commit方式，缺省值为true，表示自动commit。
	 * @param b 是否AutoCommit
	 * @throws SQLException 抛出SQL异常
	 */
	public void setAutoCommit(Boolean b) throws SQLException {
		conn.setAutoCommit(b);
	}

	/**
	 * 数据库提交
	 * @throws SQLException 抛出SQL异常
	 */
	public void commit() throws SQLException {
		conn.commit();
	}

	/**
	 * 数据库回滚
	 * @throws SQLException  抛出SQL异常
	 */
	public void rollback() throws SQLException {
		conn.rollback();
	}

	/**
	 * 设置sql模板
	 * @param sql SQL模板
	 * @throws SQLException  抛出SQL异常
	 */
	public void setPrepareStatement(String sql) throws SQLException {
		if (pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		pstmt = conn.prepareStatement(sql);
	}

	/**
	 * 查询
	 * @param sql SQL语句
	 * @return ResultSet 结果集
	 * @throws SQLException 抛出SQL异常
	 */
	
	public ResultSet query(String sql) throws SQLException {
		if (stmt == null) {
			stmt = conn.createStatement();
		}
		rst = stmt.executeQuery(sql);
		return rst;
	}

	/**
	 * 模版查询
	 * @param sql SQL模板
	 * @param arg 参数
	 * @return ResultSet 结果集
	 * @throws SQLException 抛出SQL异常
	 */
	public ResultSet query(String sql, String arg[]) throws SQLException {
		if (pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < arg.length; i++) {
			pstmt.setString(i + 1, arg[i]);
		}
		rst = pstmt.executeQuery();
		return rst;
	}

	/**
	 * 通预设模版查询
	 * @param arg 参数
	 * @return ResultSet 结果集
	 * @throws SQLException 抛出SQL异常
	 */
	public ResultSet query(String arg[]) throws SQLException {
		pstmt.clearParameters();
		for (int i = 0; i < arg.length; i++) {
			pstmt.setString(i + 1, arg[i]);
		}
		rst = pstmt.executeQuery();
		return rst;
	}
	
	/**
	 * 执行sql
	 * @param sql sql命令
	 * @return boolean 是否成功
	 * @throws SQLException 抛出SQL异常
	 */
	public boolean execute(String sql) throws SQLException {
		if (stmt == null) {
			stmt = conn.createStatement();
		}
		return stmt.execute(sql);
	}

	/**
	 * 执行sql
	 * @param sql SQL命令模板
	 * @param arg 参数
	 * @return boolean 是否成功
	 * @throws SQLException 抛出SQL异常
	 */
	public boolean execute(String sql, String arg[]) throws SQLException {
		if (pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < arg.length; i++) {
			pstmt.setString(i + 1, arg[i]);
		}
		return pstmt.execute();
	}

	/**
	 * 执行sql
	 * @param arg 参数
	 * @return boolean 是否成功
	 * @throws SQLException 抛出SQL异常
	 */
	public boolean execute(String arg[]) throws SQLException {
		pstmt.clearParameters();
		for (int i = 0; i < arg.length; i++) {
			pstmt.setString(i + 1, arg[i]);
		}
		return pstmt.execute();
	}

	/**
	 * 插入操作
	 * @param sql 插入SQL语句
	 * @return int 影响的记录数
	 * @throws SQLException 抛出SQL异常
	 */
	public int insert(String sql) throws SQLException {
		return update(sql);
	}

	/**
	 * 插入操作
	 * @param sql 插入SQL模板
	 * @param arg 参数
	 * @return int 影响的记录数
	 * @throws SQLException 抛出SQL异常
	 */
	public int insert(String sql, String arg[]) throws SQLException {
		return update(sql, arg);
	}

	/**
	 * 插入操作
	 * @param arg 参数
	 * @return int 影响的记录数
	 * @throws SQLException 抛出SQL异常
	 */
	public int insert(String arg[]) throws SQLException {
		return update(arg);
	}

	/**
	 * 更新操作
	 * @param sql 更新SQL语句
	 * @return int 更新的记录数
	 * @throws SQLException 抛出SQL异常
	 */
	public int update(String sql) throws SQLException {
		if (stmt == null) {
			stmt = conn.createStatement();
		}
		return stmt.executeUpdate(sql);
	}

	/**
	 * 更新操作
	 * @param sql 更新SQL模板
	 * @param arg 参数
	 * @return int 更新的记录数
	 * @throws SQLException 抛出SQL异常
	 */
	public int update(String sql, String arg[]) throws SQLException {
		if (pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		pstmt = conn.prepareStatement(sql);
		for (int i = 0; i < arg.length; i++) {
			pstmt.setString(i + 1, arg[i]);
		}
		return pstmt.executeUpdate();
	}

	/**
	 * 更新操作
	 * @param arg 参数
	 * @return int 更新的记录数
	 * @throws SQLException 抛出SQL异常
	 */
	public int update(String arg[]) throws SQLException {
		pstmt.clearParameters();
		for (int i = 0; i < arg.length; i++) {
			pstmt.setString(i + 1, arg[i]);
		}
		return pstmt.executeUpdate();
	}

	/**
	 * 关闭数据库资源
	 * @throws SQLException 抛出SQL异常
	 */
	public void close() throws SQLException {
		if (rst != null) {
			rst.close();
			rst = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (pstmt != null) {
			pstmt.close();
			pstmt = null;
		}
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}

	/**
	 * 测试初步表明PreparedStatement和Statement相互独立，一个connect可以同时执行两个（多个）sql。
	 * 但是只可保持一个结果集。
	 * 
	 * @param arg
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static void main(String arg[]) throws ClassNotFoundException,
			SQLException, IOException {
		DBHelper dbcon = new DBHelper("cn/ardu/test/database");
		System.out.println("======通过Statement查询======");
		ResultSet rst1 = dbcon.query(
				"select * from functions where groupid='001'", new String[] {});
		ResultSet rst = dbcon
				.query("select * from functions where groupid='001'");

		while (rst.next())
			System.out.println(rst.getString("name"));
		System.out.println("********");
		while (rst1.next())
			System.out.println(rst.getString("name"));
		dbcon.close();
	}
}
