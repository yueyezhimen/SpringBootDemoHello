package com.springboot.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

public class DataEncryption {

	/**
	 * Md5加密编码
	 * 
	 * @param String
	 * @return String
	 */
	public static String MD5Encode(String origin) {
		return DigestUtils.md5DigestAsHex(origin.getBytes());
	}

	/**
	 * Md5加密编码
	 * 
	 * @param byte[]
	 * @return String
	 */
	public static String MD5Encode(byte[] origin) {
		return DigestUtils.md5DigestAsHex(origin);
	}

	/**
	 * AES编码
	 * 
	 * @param 数据（data）
	 * @param 秘钥（key）
	 * @return String
	 */
	public static String AESEncrypt(String data, String key) {
		return doAES(data, key, 1);
	}

	/**
	 * AES解码
	 * 
	 * @param 数据（data）
	 * @param 秘钥（key）
	 * @return String
	 */
	public static String AESDecrypt(String data, String key) {
		return doAES(data, key, 2);
	}

	private static String doAES(String data, String key, int mode) {
		try {
			if ((StringUtils.hasText(key)) || (StringUtils.hasText(key))) {
				return null;
			}
			boolean encrypt = mode == 1;
			byte[] content;
			if (encrypt) {
				content = data.getBytes();
			} else {
				content = parseHexStr2Byte(data);
			}
			KeyGenerator kgen = KeyGenerator.getInstance("AES");

			kgen.init(128, new SecureRandom(key.getBytes()));

			SecretKey secretKey = kgen.generateKey();

			byte[] enCodeFormat = secretKey.getEncoded();

			SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");

			Cipher cipher = Cipher.getInstance("AES");

			cipher.init(mode, keySpec);
			byte[] result = cipher.doFinal(content);
			if (encrypt) {
				return parseByte2HexStr(result);
			}
			return new String(result);
		} catch (Exception e) {
			System.out.println("AES��������!" + e);
		}
		return null;
	}

	private static String parseByte2HexStr(byte[] buf) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	private static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1) {
			return null;
		}
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = ((byte) (high * 16 + low));
		}
		return result;
	}
}
