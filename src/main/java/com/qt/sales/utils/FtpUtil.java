package com.qt.sales.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Locale;

import sun.net.*;
import sun.net.ftp.*;
/**
 * FTP工具类
 * <p>提供FTP文件列表、上传、下载功能
 * @author 杜忠(Michael.Du)
 * @version 1.0
 * @since 1.5
 */

public class FtpUtil {
	/**
	 * FTP文件列表
	 * @param server 服务器地址
	 * @param user   用户名
	 * @param password 密码
	 * @param path 路径
	 * @return String 文件列表返回（未解析）
	 * @throws IOException 抛出IO错误
	 */
	
	public static String ftpList(String server, String user, String password,
			String path) throws IOException {
		StringBuffer out = new StringBuffer();

		FtpClient ftpClient = new FtpClient();// 创建FtpClient对象
		
		ftpClient.openServer(server);// 连接FTP服务器

		ftpClient.login(user, password);// 登录FTP服务器
		
		if (path.length() != 0)
			ftpClient.cd(path);
		TelnetInputStream is = ftpClient.list();

		int c;
		while ((c = is.read()) != -1) {
			out.append((char) c);
		}
		is.close();
		ftpClient.closeServer();// 退出FTP服务器

		return out.toString();
	}
    /**
     * FTP下载
	 * @param server 服务器地址
	 * @param user   用户名
	 * @param password 密码
	 * @param path 路径
     * @param filename 文件名
     * @param targetPath 保存目标路径
     * @throws IOException 抛出IO错误
     */
	public static void ftpGet(String server, String user, String password,
			String path, String filename, String targetPath) throws IOException {
		FtpClient ftpClient = new FtpClient();
		ftpClient.openServer(server);
		ftpClient.login(user, password);
		if (path.length() != 0)
			ftpClient.cd(path);
		ftpClient.binary();
		TelnetInputStream is = ftpClient.get(filename);
		File file_out = new File(targetPath + filename);
		FileOutputStream os = new FileOutputStream(file_out);
		byte[] bytes = new byte[1024];
		int c;
		while ((c = is.read(bytes)) != -1) {
			os.write(bytes, 0, c);
		}
		is.close();
		os.close();
		ftpClient.closeServer();
	}
    /**
     * FTP上传
	 * @param server 服务器地址
	 * @param user   用户名
	 * @param password 密码
	 * @param path 路径
     * @param filename 文件名
     * @param sourcePath 源路径
     * @throws IOException 抛出IO错误
     */
	public static void ftpPut(String server, String user, String password,
			String path, String filename, String sourcePath) throws IOException {

		FtpClient ftpClient = new FtpClient();
		ftpClient.openServer(server);
		ftpClient.login(user, password);
		if (path.length() != 0)
			ftpClient.cd(path);
		ftpClient.binary();
		TelnetOutputStream os = ftpClient.put(filename);
		File file_in = new File(sourcePath + filename);
		FileInputStream is = new FileInputStream(file_in);
		byte[] bytes = new byte[1024];
		int c;
		while ((c = is.read(bytes)) != -1) {
			os.write(bytes, 0, c);
		}
		is.close();
		os.close();
		ftpClient.closeServer();
	}
	
	public static void main(String arg[]) throws Exception{
		/*FtpClient ftpClient = new FtpClient();
		ftpClient.openServer("127.0.0.1");
		ftpClient.login("df", "df");
		ftpClient.sendServer("xmkd /test/testqq\r\n");
		ftpClient.readServerResponse();
		ftpClient.cd("/test/testqq");
		ftpClient.get("/test/testqq/test.txt");
		ftpClient.closeServer();*/
		ByteArrayInputStream tmp=new ByteArrayInputStream(ftpList("192.168.1.7","filesys","filesys",".").getBytes()) ;
		BufferedReader in=new BufferedReader(new InputStreamReader(tmp));
		while(in.ready()){
			String line=in.readLine();
			String[] s=line.split(" +");
			SimpleDateFormat format = new SimpleDateFormat("MMMddHH:mm",Locale.ENGLISH);
			System.out.println(format.parse(s[5]+s[6]+s[7]));
		}
			
	}
}
