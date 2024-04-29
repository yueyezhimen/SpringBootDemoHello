package com.springboot.utils.encryption;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

/**
 * Base64组件
 * 
 * @author wbw
 * @version 1.0
 * @since 1.0
 */
public abstract class Base64Util {
	/**
	 * 字符编码
	 */
	public final static String encoding = "UTF-8";
 
	/**
	 * Base64编码
	 * 
	 * @param data 待编码数据
	 * @return String 编码数据
	 * @throws Exception
	 */
	public static byte[] encode(byte[] data) {
		if (data!=null) {
			return DatatypeConverter.printBase64Binary(data).getBytes();
		}
		return null;
//		byte[] b = Base64.encodeBase64(data.getBytes(ENCODING));
//		return new String(b, ENCODING);
	}
	public static String encode(String data) {
		if (data!=null) {
			try {
				return DatatypeConverter.printBase64Binary(data.getBytes(encoding));
			} catch (UnsupportedEncodingException e) {
			}
		}
		return null;
	}
//	/**
//	 * Base64安全编码<br>
//	 * 遵循RFC 2045实现
//	 * 
//	 * @param data
//	 *            待编码数据
//	 * @return String 编码数据
//	 * 
//	 * @throws Exception
//	 */
//	public static String encodeSafe(String data) throws Exception {
//		byte[] b = Base64.encodeBase64(data.getBytes(ENCODING), true);
//		return new String(b, ENCODING);
//	}
// 
	public static byte[] decode(byte[] data){
		if (data!=null) {
			try {
				return DatatypeConverter.parseBase64Binary(new String(data,encoding));
			} catch (UnsupportedEncodingException e) {
			}
		}
		return null;
		// 执行解码
//		byte[] b = Base64.decodeBase64(data.getBytes(ENCODING));
//		return new String(b, ENCODING);
	}
	/**
	 * Base64解码
	 * 
	 * @param data 待解码数据
	 * @return String 解码数据
	 * @throws Exception
	 */
	public static String decode(String data) {
		if (data!=null) {
			try {
				return new String(DatatypeConverter.parseBase64Binary(data),encoding);
			} catch (UnsupportedEncodingException e) {
			}
		}
		return null;
	}
}
