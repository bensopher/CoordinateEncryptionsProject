package Encryption;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

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
//		while(true){
//			Random rand = new Random();
//			int exp;
//			double r1 = Double.valueOf(rand.nextInt((900000000 - (-90000)) + 1) + (-90000)),r2 = Double.valueOf(rand.nextInt((900000000 - (-90000)) + 1) + (-90000));
//			int r1Len = (int)(Math.log10(r1)+1),r2Len = (int)(Math.log10(r2)+1);
//			r1 = r1/Math.pow(10,r1Len-2);
//			r2 = r2/Math.pow(10,r2Len-2);
////			double r1 = (-90.0) + (90.0 - (-90.0)) * rand.nextDouble(),r2 = (-90.0) + (90.0 - (-90.0)) * rand.nextDouble();
////			System.out.println(r1+","+r2);
//			String check = googleMapsAPI.getChar(new Double[]{r1,r2});
////			System.out.println(check);
//			if(check != null){
//				if(check.equals("u")){
////					System.out.println(r1+","+r2);
//					String address = googleMapsAPI.getAddress(new Double[]{r1,r2});
//					if(!address.contains("Unnamed Road"))
//						System.out.println(address);
//				}
//			}
//		}
//		System.out.println(googleMapsAPI.getCordinates(adress)[0]+","+googleMapsAPI.getCordinates(adress)[1]);
//		System.out.println(googleMapsAPI.getChar(googleMapsAPI.getCordinates(adress)));
//		Double doub = 14.232323;
//		int len = (int)(Math.log10(doub)+1);
//		System.out.println(len);
//		System.out.println((googleMapsAPI.getCordinates("Ashkelon, Israel")[0]+","+googleMapsAPI.getCordinates("Ashkelon, Israel")[1]).replace(",", " ").replace(".", "s"));
//		System.out.println((googleMapsAPI.getCordinates("Ashdod, Israel")[0]+","+googleMapsAPI.getCordinates("Ashdod, Israel")[1]).replace(",", " ").replace(".", "s"));
//		System.out.println((googleMapsAPI.getCordinates("Tel Aviv, Israel")[0]+","+googleMapsAPI.getCordinates("Tel Aviv, Israel")[1]).replace(",", " ").replace(".", "s"));
//		System.out.println((googleMapsAPI.getCordinates("Jerusalem, Israel")[0]+","+googleMapsAPI.getCordinates("Jerusalem, Israel")[1]).replace(",", " ").replace(".", "s"));
//		System.out.println((googleMapsAPI.getCordinates("Netivot, Israel")[0]+","+googleMapsAPI.getCordinates("Netivot, Israel")[1]).replace(",", " ").replace(".", "s"));
//		System.out.println((googleMapsAPI.getCordinates("Herzelia, Israel")[0]+","+googleMapsAPI.getCordinates("Herzelia, Israel")[1]).replace(",", " ").replace(".", "s"));
//		System.out.println((googleMapsAPI.getCordinates("Rosh Ha Ain, Israel")[0]+","+googleMapsAPI.getCordinates("Rosh Ha Ain, Israel")[1]).replace(",", " ").replace(".", "s"));
//		int in = (int)3042543.5;
//		double doub = in;
//		double in = (int)-612622.6329223;
//		System.out.println((612622.6329223)-(long)(612622.6329223));
//		System.out.println((-612622.6329223)%10);
//		System.out.println(-612622.6329223-(-612674));
		System.out.println(-103550.813288-103591.79125);
	}

}
