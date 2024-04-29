package com.springboot.utils;

import java.util.UUID;

public class CookieDataEncryption {

	public static String CookieEncode(String Username, String Password) {
		String uuid = UUID.randomUUID().toString();
		long currentTimeMillis = System.currentTimeMillis();
		String code = Username + "," + Password + "," + currentTimeMillis + "," + uuid;
		return DataEncryption.AESEncrypt(code, "!@#$%+_)*^%^");
	}

	public static String[] CookieDecrypt(String code) {
		/* 解密Cookie */
		String username = DataEncryption.AESDecrypt(code, "!@#$%+_)*^%^");
		String[] split = username.split(",");
		if (split.length == 4) {
			long currentTimeMillis = System.currentTimeMillis();
			long currentTimeMillisold = Long.parseLong(split[2]);
			System.out.println("currentTimeMillis="+currentTimeMillis);
			System.out.println("currentTimeMillisold="+currentTimeMillisold);
			/**
			 * 7天有效期
			 */
			System.out.println(currentTimeMillis - currentTimeMillisold);
			if ((currentTimeMillis - currentTimeMillisold) <= 1000 * 60 * 60 * 24 * 7) {
				return new String[] { split[0], split[1] };
			}
		}
		return null;
	}
}
