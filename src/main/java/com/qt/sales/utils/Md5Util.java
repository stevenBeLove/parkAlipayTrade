package com.qt.sales.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Md5Util {
	public static String getMd5(String sb) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(sb.getBytes());
		byte b[] = md5.digest();
		int i;
		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();
	}
	
	/**
	 * map排序后拼接
	 * @param map
	 * @return
	 */
	public static String sortMapByKey(Map<String, String> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, String> sortMap = new TreeMap<String, String>(new Comparator<String>() {
			public int compare(String obj1, String obj2) {
				// 降序排序
				return obj2.compareTo(obj1);
			}
		});
		sortMap.putAll(map);
		StringBuffer sb = new StringBuffer();
		for (String key : sortMap.keySet()) {
			sb.append(key+sortMap.get(key));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		try {
		    Map<String, String> paramMap = new HashMap<String, String>();
		    paramMap.put("outParkingId", "10230");//停车场Id
//		    paramMap.put("inTime", "2018-01-10 12:48:24");//进场时间
//		    paramMap.put("outTime", "2018-01-10 12:54:17");//出场时间
		    paramMap.put("carNumber", "沪C6R5L7");//车牌
		    
		    String signValue = Md5Util.sortMapByKey(paramMap);
		    String nsign = Md5Util.getMd5(signValue+"abc1234");
		    System.out.println(nsign);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
