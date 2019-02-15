package com.cube.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlFormat {
	public static String eucencode(String tmp){
		String str="";
		try {
			if(tmp !=null)
			str = URLEncoder.encode(tmp, "EUC-KR");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	public static String utfencode(String tmp){
		String str="";
		try {
			if(tmp !=null)
			str = URLEncoder.encode(tmp, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
}
