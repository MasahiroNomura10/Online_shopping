package model.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class hash{
	public static String hash(String password) {
		
		String newPassword=null;
		try {
//			ソルト化（ランダムな文字列の生成）
			byte[] salt = new byte[16];
			SecureRandom random = new SecureRandom();
			random.nextBytes(salt);
			
//			ハッシュ化（パスワードを256型の文字列に変換）
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(salt);
			md.update(password.getBytes());
			byte[] hashBytes = md.digest();
			System.out.println(hashBytes);
//			ハッシュ化されたパスワードを読めるようにする。
			String hash = Base64.getEncoder().encodeToString(hashBytes);
			System.out.println(hash);
			newPassword=hash;
			
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			newPassword="errorです";
		}
		return newPassword;
	}
}