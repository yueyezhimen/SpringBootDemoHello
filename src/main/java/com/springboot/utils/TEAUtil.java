package com.springboot.utils;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

import javax.xml.bind.DatatypeConverter;

/**
 * <p>
 *
 * Tea算法 每次操作可以处理8个字节数据 KEY为16字节,应为包含4个int型数的int[]，一个int为4个字节
 * 加密解密轮数应为8的倍数，推荐加密轮数为64轮
 * 
 * @author hyl
 * @version v1.0: Tea.java, v 0.1 2021/3/12 13:48 $
 */
public class TEAUtil {
	private static final int[] KEY = new int[] { 0x789f5645, 0xf68bd5a4, 0x81963ffa, 0x458fac58 };

	public static String encryptToBase64(long content) {
		byte[] info = longToBytes(content);
		byte[] secretInfo = TEAUtil.encrypt(info, 0, KEY, 32);
		String secretInfoString = DatatypeConverter.printBase64Binary(secretInfo);
		return secretInfoString;
	}

	public static long decryptToBase64(String content) {
		byte[] parseBase64Binary = DatatypeConverter.parseBase64Binary(content);
		byte[] decryptInfo = TEAUtil.decrypt(parseBase64Binary, 0, KEY, 32);
		return bytesToLong(decryptInfo);
	}

	/**
	 * 加密
	 * 
	 * @param content 加密内容
	 * @param offset
	 * @param key     加密秘钥
	 * @param times   times为加密轮数 64,32,16
	 * @return
	 */
	public static byte[] encrypt(byte[] content, int offset, int[] key, int times) {
		int[] tempInt = byteToInt(content, offset);
		int y = tempInt[0], z = tempInt[1], sum = 0, i;
		int delta = 0x9e3779b9; // 这是算法标准给的值
		int a = key[0], b = key[1], c = key[2], d = key[3];

		for (i = 0; i < times; i++) {
			sum += delta;
			y += ((z << 4) + a) ^ (z + sum) ^ ((z >> 5) + b);
			z += ((y << 4) + c) ^ (y + sum) ^ ((y >> 5) + d);
		}
		tempInt[0] = y;
		tempInt[1] = z;
		return intToByte(tempInt, 0);
	}

	// 解密
	public static byte[] decrypt(byte[] encryptContent, int offset, int[] key, int times) {
		int[] tempInt = byteToInt(encryptContent, offset);
		int y = tempInt[0], z = tempInt[1], sum = 0xC6EF3720, i;
		int delta = 0x9e3779b9; // 这是算法标准给的值
		int a = key[0], b = key[1], c = key[2], d = key[3];

		for (i = 0; i < times; i++) {
			z -= ((y << 4) + c) ^ (y + sum) ^ ((y >> 5) + d);
			y -= ((z << 4) + a) ^ (z + sum) ^ ((z >> 5) + b);
			sum -= delta;
		}
		tempInt[0] = y;
		tempInt[1] = z;

		return intToByte(tempInt, 0);
	}

	// byte[]型数据转成int[]型数据
	private static int[] byteToInt(byte[] content, int offset) {

		int[] result = new int[content.length >> 2]; // 除以2的n次方 == 右移n位 即 content.length / 4 == content.length >> 2
		for (int i = 0, j = offset; j < content.length; i++, j += 4) {
			result[i] = transform(content[j + 3]) | transform(content[j + 2]) << 8 | transform(content[j + 1]) << 16
					| (int) content[j] << 24;
		}
		return result;

	}

	// int[]型数据转成byte[]型数据
	private static byte[] intToByte(int[] content, int offset) {
		byte[] result = new byte[content.length << 2]; // 乘以2的n次方 == 左移n位 即 content.length * 4 == content.length << 2
		for (int i = 0, j = offset; j < result.length; i++, j += 4) {
			result[j + 3] = (byte) (content[i] & 0xff);
			result[j + 2] = (byte) ((content[i] >> 8) & 0xff);
			result[j + 1] = (byte) ((content[i] >> 16) & 0xff);
			result[j] = (byte) ((content[i] >> 24) & 0xff);
		}
		return result;
	}

	// 若某字节被解释成负的则需将其转成无符号正数
	private static int transform(byte temp) {
		int tempInt = (int) temp;
		if (tempInt < 0) {
			tempInt += 256;
		}
		return tempInt;
	}

	public static byte[] longToBytes(long l) {
		byte[] result = new byte[8];
		for (int i = 7; i >= 0; i--) {
			result[i] = (byte) (l & 0xFF);
			l >>= 8;
		}
		return result;
	}

	public static long bytesToLong(byte[] b) {
		long result = 0;
		for (int i = 0; i < 8; i++) {
			result <<= 8;
			result |= (b[i] & 0xFF);
		}
		return result;
	}

// 测试代码如下:
	public static void main(String[] args) throws UnsupportedEncodingException {
		long a11 = System.currentTimeMillis();
		TEAUtil tea = new TEAUtil();
		Long long1 = 123152555555558581l;
		byte[] info2 = new byte[] { 1, 2, 3, 2, 5, 6, 2, 126 };
		// 加密解密所用的KEY

		for (int i = 0; i < 10000000; i++) {
			// toLong(info2);
			decryptToBase64("42pRaWKesak=");;
		}
		long a12 = System.currentTimeMillis();
		System.out.println(a12 - a11);
	}
}