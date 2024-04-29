package com.springboot.utils;

import org.springframework.util.DigestUtils;

/**
 * MD5加密组件
 * 
 * @author wbw
 * @version 1.0
 * @since 1.0
 */
public abstract class MD5Util {
 
	/**
	 * MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static byte[] encodeMD5(String data) throws Exception {
		return DigestUtils.md5Digest(data.getBytes());
	}
 
	/**
	 * MD5加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return byte[] 消息摘要
	 * 
	 * @throws Exception
	 */
	public static String encodeMD5Hex(String data) {
		return DigestUtils.md5DigestAsHex(data.getBytes());
	}
}
