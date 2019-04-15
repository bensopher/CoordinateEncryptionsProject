package Encryption;

import graphics.OutputDecryptionPanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.parser.ParseException;

public class Decrypt {
	public static void Decryption(String key,String code) throws ParseException, IOException{
		HashMap<String, String> SpecialSymbols = new HashMap<String, String>();
		String message = "";
		ArrayList<Double> doubles = new ArrayList<Double>();
		int hashedKey = key.hashCode();
		if(((int)Math.log10(Math.abs(hashedKey))+1) > 8)
			hashedKey = hashedKey/1000;
//		double doubKey = hashedKey/(double)Math.pow(10, ((int)Math.log10(Math.abs(hashedKey))+1)/2);
//		hashedKey = hashedKey/1000000000;
		SpecialSymbols.put("31.6687885 34.5742523",".");
		SpecialSymbols.put("31.804381 34.655314",",");
		SpecialSymbols.put("32.0852999 34.78176759999999",":");
		SpecialSymbols.put("31.768319 35.21371","!");
		SpecialSymbols.put("31.423196 34.595254","?");
		SpecialSymbols.put("32.162413 34.844675","-");
		SpecialSymbols.put("32.095838 34.952177"," ");
//		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Kappara, San Gwann, Malta")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Kappara, San Gwann, Malta")[1]), ".");
//		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Tony USA, Sai Mai Road, Sai Mai, Bangkok, Thailand")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Tony USA, Sai Mai Road, Sai Mai, Bangkok, Thailand")[1]), ",");
//		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Benjamin’s Garden, Lat Sawai, Lam Luk Ka District, Pathum Thani, Thailand")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Benjamin’s Garden, Lat Sawai, Lam Luk Ka District, Pathum Thani, Thailand")[1]), ":");
//		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Daniel Thaiger Burger, Soi Sukhumvit 11, Khlong Toei Nuea, Watthana, Bangkok, Thailand")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Daniel Thaiger Burger, Soi Sukhumvit 11, Khlong Toei Nuea, Watthana, Bangkok, Thailand")[1]), "!");
//		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Roberta Vinci, Ahuza Street, Pardes Hanna-Karkur")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Roberta Vinci, Ahuza Street, Pardes Hanna-Karkur")[1]), "?");
//		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Sarajevo, Bosnia and Herzegovina")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Sarajevo, Bosnia and Herzegovina")[1]), "-");
//		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("SPACE Office Centre Sarajevo, Pijačna, Sarajevo, Bosnia and Herzegovina")[0])+","+String.valueOf(googleMapsAPI.getCordinates("SPACE Office Centre Sarajevo, Pijačna, Sarajevo, Bosnia and Herzegovina")[1]), " ");

		code = code.replace("\n", " ");
		while(code.endsWith(" "))
			code = code.replaceAll(" $","");
//		code = code.replace(" ", ",");
		int j=0;
		boolean isUpper = false;
		String sub;
		for(int i=0;i<code.length();i++){
			if(i==code.length()-1){
				sub = code.substring(j, i+1);
				if(sub.contains("x")){
					sub = sub.replace("x", ".");
				}else if(sub.contains("z")){
					sub = sub.replace("z", ".");
				}
				doubles.add(Double.valueOf(sub));
			}
			if(code.charAt(i) == ' '){
				sub = code.substring(j, i);
//				System.out.println(sub);
				if(sub.contains("x")){
					sub = sub.replace("x", ".");
				}else if(sub.contains("z")){
					sub = sub.replace("z", ".");
				}
//				System.out.println(Double.valueOf(sub));
				doubles.add(Double.valueOf(sub));
				j = i+1;
//				System.out.println(code);
			}
		}
		
		
		for(int i=0;i<doubles.size();i++){
			double temp = doubles.get(i);
			System.out.println("before removing the key: "+temp);
			System.out.println("The Key: "+hashedKey);
			double afterPoint = Math.abs(doubles.get(i))-Math.floor(Math.abs(doubles.get(i)));
			afterPoint = afterPoint*Math.signum(temp);
			temp = (int)temp;
			temp = temp - hashedKey;
			System.out.println("after raises the hashKey: "+temp);
//			double afterPoint = Math.abs(doubles.get(i))-Math.floor(Math.abs(doubles.get(i)));
			System.out.println("after point: "+afterPoint);
			afterPoint = Math.round(afterPoint * 1e9) / 1e9;
			System.out.println(afterPoint+temp);
//			System.out.println("With the signum:"+((Math.signum(temp))*afterPoint+temp));
//			if((int)temp == 0)
//				doubles.set(i, (Math.signum(temp))*afterPoint+temp);
			doubles.set(i, afterPoint+temp);
			}
//		for(int i=0;i<doubles.size();i++)
//			System.out.println(doubles.get(i));
		for(int i=0;i<doubles.size();i = i+2){
			String coordins= String.valueOf(doubles.get(i))+" "+String.valueOf(doubles.get(i+1));
			if(SpecialSymbols.containsKey(coordins))
				message = message+SpecialSymbols.get(coordins);
			else{
				System.out.println("before callig getChar:"+doubles.get(i)+" "+doubles.get(i+1));
				String chr = googleMapsAPI.getChar(new Double[]{doubles.get(i),doubles.get(i+1)});
				if(chr == null){
					Random r = new Random();
					message = message+(char)(r.nextInt(60) + ' ');
				}
				else
					message = message+chr;
			}
		}
		OutputDecryptionPanel.setOutput(message);
	}
//	public String detectingSpecialSymbol(String sub){
//		
//		switch(){
//		
//		}
//		
//	}
}
