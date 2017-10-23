//package com.qt.sales.utils;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//
//public class Sorter {
//	
//	public static String work(String c){
//		if (c==null || c.isEmpty())return c;
//		String[] lables=c.split(",");
//		if (lables.length<=2)return c;
//		List<Lable> list=new ArrayList<Lable>();
//		//统计
//		for (String s:lables){
//			String[] tmp=s.split("_");
//			Lable l=getLable(list,tmp[0]);
//			if (l==null){
//				l=new Lable(tmp[0]);
//				l.count=1;
//				l.values.add(s);
//				list.add(l);
//			}else{
//				l.count=l.count+1;
//				l.values.add(s);
//			}
//		}
//		//排序
//		for (int i=0;i<list.size()-1;i++){
//			for (int j=i+1;j<list.size();j++){
//				if (list.get(i).count<list.get(j).count){
//					Lable tmp=list.get(i);
//					list.set(i, list.get(j));
//					list.set(j, tmp);
//				}
//			}
//		}
//		//重组
//		StringBuffer str=new StringBuffer();
//		for (Lable l:list){
//			for (String s:l.values){
//				str.append(s).append(",");
//			}
//		}
//		return str.substring(0, str.length()-1);
//	}
//	
//	public static Lable getLable(List<Lable>list,String lableName){
//		for (Lable l:list){
//			if (l.name.equals(lableName))return l;
//		}
//		return null; 
//	}
//	
//	static class  Lable{
//		public String name;
//		public int count=0;
//		public List<String> values=new ArrayList<String>();
//		
//		public Lable(String name){
//			this.name=name;
//		}
//	}
//
//	public static void main(String[] args) {
//		//String c="lab_1,lab1_1,lab3_1,lab4_1,lab1_2,lab3_2,lab3_3,lab3_4";
//		String c="lab_1";
//		System.out.println(work(c));
//		SimpleDateFormat sFmt = new SimpleDateFormat("yyyy-MM");
//		Calendar cc = Calendar.getInstance();
//		cc.add(Calendar.MONTH, 1);
//		System.out.println(sFmt.format(cc.getTime()));
//	}
//
//}
