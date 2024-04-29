package com.springboot.utils;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	public static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	private final static ObjectMapper mapper = new ObjectMapper();
	
	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
	/**
	 * Json 字符串转Object
	 * 
	 * 转Map valueType=Map.class
	 * 转List valueType=List.class
	 * @param <T>
	 * @param json
	 * @param valueType
	 * @return
	 */
	public <T> T toObject(String json, Class<T> valueType) {
		try {
			return mapper.readValue(json, valueType);
		} catch (IOException e) {
			logger.error(e.getMessage());
			return null;
		}
	}
}
