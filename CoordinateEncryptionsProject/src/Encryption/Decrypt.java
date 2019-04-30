package Encryption;

import graphics.OutputDecryptionPanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.parser.ParseException;

public class Decrypt {
	public static void Decryption(String key,String code) throws ParseException, IOException{
//		HashMap<String, String> SpecialSymbols = new HashMap<String, String>();
		ArrayList<String> subs = new ArrayList<String>();
		String message = "";
//		ArrayList<Double> doubles = new ArrayList<Double>();
		int hashedKey = key.hashCode();
		if(((int)Math.log10(Math.abs(hashedKey))+1) > 8)
			hashedKey = hashedKey/1000;
//		double doubKey = hashedKey/(double)Math.pow(10, ((int)Math.log10(Math.abs(hashedKey))+1)/2);
//		hashedKey = hashedKey/1000000000;
//		SpecialSymbols.put("31.6687885 34.5742523",".");
//		SpecialSymbols.put("31.804381 34.655314",",");
//		SpecialSymbols.put("32.0852999 34.78176759999999",":");
//		SpecialSymbols.put("31.768319 35.21371","!");
//		SpecialSymbols.put("31.423196 34.595254","?");
//		SpecialSymbols.put("32.162413 34.844675","-");
//		SpecialSymbols.put("32.095838 34.952177"," ");
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

		for(int i=0,j=0;i<code.length();i++){
			if(code.charAt(i) == ' ' || i==code.length()-1){
				if(i==code.length()-1)
					subs.add(code.substring(j, i+1));
				else
					subs.add(code.substring(j, i));
				j = i+1;
			}
		}
		
		for(int i=0;i<subs.size();i = i+2){
			boolean isUpper = false;
			if(subs.get(i).contains("z")){
				subs.set(i,subs.get(i).replace("z", "."));
				subs.set(i+1,subs.get(i+1).replace("z", "."));
				isUpper = true;
			}
			else{
				subs.set(i,subs.get(i).replace("x", "."));
				subs.set(i+1,subs.get(i+1).replace("x", "."));
			}
			double[] doubTemp = new double[]{Double.valueOf(subs.get(i)),Double.valueOf(subs.get(i+1))};
			double[] afterPoint = new double[]{Math.round(((Math.abs(doubTemp[0])-Math.floor(Math.abs(doubTemp[0])))*Math.signum(doubTemp[0]))* 1e9) / 1e9 , Math.round(((Math.abs(doubTemp[1])-Math.floor(Math.abs(doubTemp[1])))*Math.signum(doubTemp[1])) * 1e9) / 1e9};
			doubTemp[0] = (((int)doubTemp[0]) - hashedKey) + afterPoint[0];
			doubTemp[1] = (((int)doubTemp[1]) - hashedKey) + afterPoint[1];
			if(doubTemp[0] > 180.0){
				int intTemp = (int)(doubTemp[0] / 10);
				if(intTemp == 30)
					message = message+'\n';
				else
					message = message+(char)intTemp;
				continue;
			}
			else{
				String chr = googleMapsAPI.getChar(new Double[]{doubTemp[0],doubTemp[1]});
				if(chr == null){
					Random r = new Random();
					message = message+(char)(r.nextInt(60) + ' ');
				}
				else{
					if(isUpper)
						message = message+chr.toUpperCase();
					else
						message = message+chr;
				}
			}
//			if(subs.get(i).contains("x")){
//				subs.set(i,subs.get(i).replace("x", "."));
//				subs.set(i+1,subs.get(i+1).replace("x", "."));
//				double[] doubTemp = new double[]{Double.valueOf(subs.get(i)),Double.valueOf(subs.get(i+1))};
//				double[] afterPoint = new double[]{Math.round(((Math.abs(doubTemp[0])-Math.floor(Math.abs(doubTemp[0])))*Math.signum(doubTemp[0]))* 1e9) / 1e9 , Math.round(((Math.abs(doubTemp[1])-Math.floor(Math.abs(doubTemp[1])))*Math.signum(doubTemp[1])) * 1e9) / 1e9};
//				doubTemp[0] = (((int)doubTemp[0]) - hashedKey) + afterPoint[0];
//				doubTemp[1] = (((int)doubTemp[1]) - hashedKey) + afterPoint[1];
//				if(doubTemp[0] > 180.0){
//					int intTemp = (int)(doubTemp[0] / 10);
//					if(intTemp == 30)
//						message = message+'\n';
//					else
//						message = message+(char)intTemp;
//					continue;
//				}
//				else{
//					String chr = googleMapsAPI.getChar(new Double[]{doubTemp[0],doubTemp[1]});
//					if(chr == null){
//						Random r = new Random();
//						message = message+(char)(r.nextInt(60) + ' ');
//					}
//					else
//						message = message+chr;
//				}
//			}
		}
		
		
//		for(int i=0;i<subs.size();i = i+2){
//			if(subs.get(i).contains("x")){
//				subs.set(i,subs.get(i).replace("x", "."));
//				subs.set(i+1,subs.get(i+1).replace("x", "."));
//				double[] doubTemp = new double[]{Double.valueOf(subs.get(i)),Double.valueOf(subs.get(i+1))};
//				double[] afterPoint = new double[]{Math.round(((Math.abs(doubTemp[0])-Math.floor(Math.abs(doubTemp[0])))*Math.signum(doubTemp[0]))* 1e9) / 1e9 , Math.round(((Math.abs(doubTemp[1])-Math.floor(Math.abs(doubTemp[1])))*Math.signum(doubTemp[1])) * 1e9) / 1e9};
//				doubTemp[0] = (((int)doubTemp[0]) - hashedKey) + afterPoint[0];
//				doubTemp[1] = (((int)doubTemp[1]) - hashedKey) + afterPoint[1];
//				if(doubTemp[0] > 180.0){
//					int intTemp = (int)(doubTemp[0] / 10);
//					if(intTemp == 30)
//						message = message+'\n';
//					else
//						message = message+(char)intTemp;
//					continue;
//				}
//				else{
//					String chr = googleMapsAPI.getChar(new Double[]{doubTemp[0],doubTemp[1]});
//					if(chr == null){
//						Random r = new Random();
//						message = message+(char)(r.nextInt(60) + ' ');
//					}
//					else
//						message = message+chr;
//				}
//			}else if(subs.get(i).contains("z")){
//				subs.set(i,subs.get(i).replace("z", "."));
//				subs.set(i+1,subs.get(i+1).replace("z", "."));
//				double[] doubTemp = new double[]{Double.valueOf(subs.get(i)),Double.valueOf(subs.get(i+1))};
//				double[] afterPoint = new double[]{Math.round(((Math.abs(doubTemp[0])-Math.floor(Math.abs(doubTemp[0])))*Math.signum(doubTemp[0]))* 1e9) / 1e9 , Math.round(((Math.abs(doubTemp[1])-Math.floor(Math.abs(doubTemp[1])))*Math.signum(doubTemp[1])) * 1e9) / 1e9};
//				doubTemp[0] = (((int)doubTemp[0]) - hashedKey) + afterPoint[0];
//				doubTemp[1] = (((int)doubTemp[1]) - hashedKey) + afterPoint[1];
//				if(doubTemp[0] > 180.0){
//					int intTemp = (int)(doubTemp[0] / 10);
//					if(intTemp == 30)
//						message = message+'\n';
//					else
//						message = message+(char)intTemp;
//				}
//				else{
//					String chr = googleMapsAPI.getChar(new Double[]{doubTemp[0],doubTemp[1]});
//					if(chr == null){
//						Random r = new Random();
//						message = message+(char)(r.nextInt(60) + ' ');
//					}
//					else
//						message = message+chr.toUpperCase();
//				}
//			}
//		}
		OutputDecryptionPanel.setOutput(message);
//		for(int i=0;i<code.length();i++){
//			if(code.charAt(i) == ' ' || i==code.length()-1){
//				if(i==code.length()-1)
//					sub = code.substring(j, i+1);
//				else
//					sub = code.substring(j, i);
////				System.out.println(sub);
//				if(sub.contains("x")){
//					sub = sub.replace("x", ".");
//					double temp = Double.valueOf(sub);
//					double afterPoint = Math.abs(doubles.get(i))-Math.floor(Math.abs(doubles.get(i)));
//					afterPoint = afterPoint*Math.signum(temp);
//					if(temp > 180.0){
//						int intTemp = (int)(temp / 10);
//						message = message+(char)intTemp;
//					}
//					
//					temp = (int)temp;
//					temp = temp - hashedKey;
//					afterPoint = Math.round(afterPoint * 1e9) / 1e9;
//					//afterPoint+temp
//				}else if(sub.contains("z")){
//					sub = sub.replace("z", ".");
//					
//					
//				}
////				System.out.println(Double.valueOf(sub));
//				doubles.add(Double.valueOf(sub));
//				j = i+1;
////				System.out.println(code);
//			}
//		}
//		
//		double temp = 0.0;
//		for(int i=0;i<doubles.size();i++){
//			temp = doubles.get(i);
////			System.out.println("before removing the key: "+temp);
////			System.out.println("The Key: "+hashedKey);
//			double afterPoint = Math.abs(doubles.get(i))-Math.floor(Math.abs(doubles.get(i)));
//			afterPoint = afterPoint*Math.signum(temp);
//			temp = (int)temp;
//			temp = temp - hashedKey;
////			System.out.println("after raises the hashKey: "+temp);
////			double afterPoint = Math.abs(doubles.get(i))-Math.floor(Math.abs(doubles.get(i)));
////			System.out.println("after point: "+afterPoint);
//			afterPoint = Math.round(afterPoint * 1e9) / 1e9;
////			System.out.println(afterPoint+temp);
////			System.out.println("With the signum:"+((Math.signum(temp))*afterPoint+temp));
////			if((int)temp == 0)
////				doubles.set(i, (Math.signum(temp))*afterPoint+temp);
//			doubles.set(i, afterPoint+temp);
//			}
////		for(int i=0;i<doubles.size();i++)
////			System.out.println(doubles.get(i));
//		for(int i=0;i<doubles.size();i = i+2){
////			String coordins= String.valueOf(doubles.get(i))+" "+String.valueOf(doubles.get(i+1));
//			if(temp > 180.0){
//				int intTemp = (int)(temp / 10);
//				message = message+(char)intTemp;
//				
//			}else{
////				System.out.println("before callig getChar:"+doubles.get(i)+" "+doubles.get(i+1));
//				String chr = googleMapsAPI.getChar(new Double[]{doubles.get(i),doubles.get(i+1)});
//				if(chr == null){
//					Random r = new Random();
//					message = message+(char)(r.nextInt(60) + ' ');
//				}
//				else
//					message = message+chr;
//			}
//		}
//		OutputDecryptionPanel.setOutput(message);
//	public String detectingSpecialSymbol(String sub){
//		
//		switch(){
//		
//		}
//		
//	}
	}}
