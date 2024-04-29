package com.springboot.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResultUtils {
	public static final Logger logger = LoggerFactory.getLogger(ResultUtils.class);
	public static Map<String, Object> createMap() {
		return new HashMap<String, Object>();
	}
	public static Map<String, Object> setResult(boolean request,int code) {
		Map<String, Object> map = createMap();
		map.put("request", request);
		map.put("code", code);
		return map;
	}
	public static Map<String, Object> setResult(boolean request,int code, String msg) {
		Map<String, Object> map = createMap();
		map.put("request", request);
		map.put("code", code);
		map.put("msg", msg);
		return map;
	}
	public static Map<String, Object> setResult(boolean request,int code, String msg, String msgDebug) {
		Map<String, Object> map = createMap();
		map.put("request", request);
		map.put("code", code);
		map.put("msg", msg);
		if (logger.isDebugEnabled()) {
			map.put("msgdetail", msgDebug);
		}
		return map;
	}
	public static Map<String, Object> setResult(boolean request,int code, Map<String, Object> data) {
		Map<String, Object> map = createMap();
		map.put("request", request);
		map.put("code", code);
		map.put("data", data);
		return map;
	}
	public static Map<String, Object> setResult(boolean request,int code, String msg, Map<String, Object> data) {
		Map<String, Object> map = createMap();
		map.put("request", request);
		map.put("code", code);
		map.put("msg", msg);
		map.put("data", data);
		return map;
	}
	public static Map<String, Object> setResult(boolean request,int code, String msg, String msgDebug, Map<String, Object> data) {
		Map<String, Object> map = createMap();
		map.put("request", request);
		map.put("code", code);
		map.put("msg", msg);
		if (logger.isDebugEnabled()) {
			map.put("msgdetail", msgDebug);
		}
		map.put("data", data);
		return map;
	}

}
