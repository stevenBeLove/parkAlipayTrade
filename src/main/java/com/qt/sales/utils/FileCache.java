package com.qt.sales.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.concurrent.ConcurrentHashMap;

public class FileCache {
	public static final String cachePath="/home/weblogic/cache/";
	private static ConcurrentHashMap<String, String> writeLock = new ConcurrentHashMap<String, String>();
	
	private static Integer lock=0;
	
	private static boolean isWriting(String path){
		synchronized (lock){
			if (writeLock.containsKey(path))return true;
			else return false;
		}
	}
	
	private static boolean getWriteLock(String path){
		synchronized (lock){
			if (writeLock.containsKey(path))return false;
			else {
				writeLock.put(path, "");
				return true;
			}
		}
	}
	
	private static void freeWriteLock(String path){
		synchronized (lock){
			writeLock.remove(path);
		}
	}
	
	public static String get(String node,String date,String type) throws IOException{

			date=date.replaceAll("-", "");
			File file=null;
			if ("day".equals(type)){
				file=new File(cachePath+date.substring(0, 6)+"/"+date+"/"+node+".txt");
			}else{
				file=new File(cachePath+date.substring(0, 6)+"/"+node+".txt");
			}
			//包含此文件
			
			if (file.exists() && !isWriting(file.getAbsolutePath())){
				BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
				StringBuffer str=new StringBuffer();
				while (in.ready()){
					str.append(in.readLine());
				}
				in.close();
				return str.toString();
			}
			return null;
	}
	
	public static void put(String node,String date,String type,String data,String force) throws IOException{
		date=date.replaceAll("-", "");
		File file=null;
		File path=null;
		if ("day".equals(type)){
			file=new File(cachePath+date.substring(0, 6)+"/"+date+"/"+node+".txt");
			path=new File(cachePath+date.substring(0, 6)+"/"+date);
		}else{
			file=new File(cachePath+date.substring(0, 6)+"/"+node+".txt");
			path=new File(cachePath+date.substring(0, 6));
		}

		//force ： 1 强制更新  0 不强制更新
		if( force!=null && "0".equals(force) && file.exists()){
			return;
		}
		if( force==null && file.exists()){
			return;
		}
		
		if (getWriteLock(file.getAbsolutePath())){	
			try{
				if (!path.exists())path.mkdirs();
				BufferedWriter out=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
				out.write(data);
				out.close();
			}catch (IOException e){
				throw e;
			}finally{
				freeWriteLock(file.getAbsolutePath());
			}
		}
	}
	
	public static void main(String[] arg){
		File file=new File(cachePath+"20160701".substring(0, 6)+"/20160701/root.txt");
		System.out.println(file.getAbsolutePath());
	}
	

}
