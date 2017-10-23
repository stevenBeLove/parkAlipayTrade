package com.qt.sales.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 自定义序列工具类
 * 
 * @author 杜忠(Michael.Du)
 * @version 1.0
 * @since 1.5
 */

public class Sequence {
	private static String PATH ="/home/weblogic/seq/";
	private static String EXT = ".seq";
	private String name;
	private Long start;
	private Long step;
	private File seqFile;
	private Long seqData;
	private Long num;

	/**
	 * 构造器1
	 * @param path 文件路径
	 * @param name 序列名
	 * @param start 开始值
	 * @param step 步长
	 */
	public Sequence(String path, String name, String start, String step) {
		PATH = path;
		init(name, start, step);
	}

	/**
	 * 构造器2
	 * @param name 序列名
	 * @param start 开始值
	 * @param step 步长
	 */
	public Sequence(String name, String start, String step) {
		init(name, start, step);
	}

	/**
	 * 构造器3
	 * @param path 文件路径
	 * @param param 参数
	 */
	public Sequence(String path, String param) {
		PATH = path;
		String params[] = param.split("\\|");
		init(params[0], params[1], params[2]);
	}

	/**
	 * 构造器4
	 * @param param 参数
	 */
	public Sequence(String param) {
		String params[] = param.split("\\|");
		init(params[0], params[1], params[2]);
	}

	/**
	 * 序列初始化
	 * @param name 序列名
	 * @param start 开始值
	 * @param step 步长
	 */
	private void init(String name, String start, String step) {
		this.name = name;
		this.start = Long.parseLong(start);
		this.step = Long.parseLong(step);
		seqFile = new File(PATH + this.name + EXT);
		num = 0L;
		System.out.println(seqFile.getPath());
		if (seqFile.exists()) {
			try {
				BufferedReader in = new BufferedReader(new FileReader(seqFile));
				if (in.ready())
					seqData = Long.parseLong(in.readLine());
				in.close();
			} catch (Exception e) {
			}
		} else {
			seqData = this.start;
		}
		String tmpStr = Long.toString(seqData + this.step);
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(seqFile));
			out.write(tmpStr);
			out.close();
		} catch (IOException e) {
		}
	}

	/**
	 * 获取下一值
	 * @return String 
	 */
	synchronized public String getNext() {
		String seq = Long.toString(seqData);
		if (num < step) {
			num++;
		} else {
			num = 1L;
			String tmpStr = Long.toString(seqData + step);
			BufferedWriter out;
			try {
				out = new BufferedWriter(new FileWriter(seqFile));
				out.write(tmpStr);
				out.close();
			} catch (IOException e) {
			}
		}
		seqData++;
		return seq;
	}

	public static void main(String arg[]) {
		Sequence seq = new Sequence("test|0|20");
		for (int i = 0; i < 25; i++)
			System.out.println(seq.getNext());
	}

}
