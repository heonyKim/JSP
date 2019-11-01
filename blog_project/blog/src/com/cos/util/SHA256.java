package com.cos.util;

import java.security.MessageDigest;

//256bit 길이의 암호 = 해시 = 복호화가 안됨
public class SHA256 {
	// password를 암호화해서 return

	public static String getEncrypt(String rawPassword, String salt) {

		// rawPassword = "qw5678qw"
		// salt = cos
		String result = "";

		// [q , w , 5, 6, 7, 8,q ,w]
		byte[] a = rawPassword.getBytes();
		byte[] b = new byte[a.length + salt.length()]; // 11

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(b); // MessageDigest가 SHA-256으로 암호화된 값을 들고 있음.

			byte[] bResult = md.digest();

//			for (byte data : bResult) {
//				System.out.print(data+" ");
//			}

			StringBuffer sb = new StringBuffer();
			for (byte data : bResult) {
				sb.append(Integer.toString(data & 0xff, 16));
			}
			result = sb.toString();
			System.out.println(result);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		getEncrypt("qw5678qw", "cos");
	}
}
