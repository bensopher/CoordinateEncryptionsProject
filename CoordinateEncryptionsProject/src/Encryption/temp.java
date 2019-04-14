package Encryption;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.parser.ParseException;

public class temp {

	public static void main(String[] args) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, ShortBufferException, IllegalBlockSizeException, BadPaddingException, ParseException, IOException {
//		byte[] input = "-12.232323".getBytes("UTF-8");
//		System.out.println(Arrays.toString(input));
//		byte[] keyBytes = "Tony1234Tony1234".getBytes("UTF-8");
//		byte[] ivBytes = "aaaaaaaaaaaaaaaa".getBytes("UTF-8");
//
//		
//		SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
//		IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
//
//		
//		Cipher cipher = Cipher.getInstance("AES/CTR/PKCS5Padding");
//		cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
//		byte[] encrypted= new byte[cipher.getOutputSize(input.length)];
//		int enc_len = cipher.update(input, 0, input.length, encrypted, 0);
//		enc_len += cipher.doFinal(encrypted, enc_len);
//		System.out.println(new String(encrypted,0,enc_len,StandardCharsets.UTF_8));
////		System.out.println(enc_len);
////		System.out.println(encrypted.length);
//		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
//		byte[] decrypted = new byte[cipher.getOutputSize(enc_len)];
//		int dec_len = cipher.update(encrypted, 0, enc_len, decrypted, 0);
//		dec_len += cipher.doFinal(decrypted, dec_len);
//		System.out.println(new String(decrypted,0,enc_len,StandardCharsets.UTF_8));
		
		
//		String key = "Tony1234";
//		Double hash = Double.valueOf(key.hashCode());
//		hash = hash/1000000000;
//		System.out.println(hash);
//		Double[] cord = googleMapsAPI.getCordinates("Anatalia");
//		System.out.println(cord[0]+" "+cord[1]);
//		System.out.println(cord[1]+hash);
		
		
//		System.out.println(googleMapsAPI.getCordinates("41.894366696999995,-87.804930803")[0]);
		
//		System.out.println("tony".hashCode());
//		System.out.println("dani".hashCode());
//		System.out.println(39.3432432523434387456795867454);
		String adress = "Zwolle, Netherlands";
		System.out.println(googleMapsAPI.getCordinates(adress)[0]+","+googleMapsAPI.getCordinates(adress)[1]);
		System.out.println(googleMapsAPI.getChar(googleMapsAPI.getCordinates(adress)));
	}

}
