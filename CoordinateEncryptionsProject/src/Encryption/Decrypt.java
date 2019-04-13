package Encryption;

import graphics.OutputDecryptionPanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

public class Decrypt {
	public static void Decryption(String key,String code) throws ParseException, IOException{
		HashMap<String, String> SpecialSymbols = new HashMap<String, String>();
		String message = "";
		ArrayList<Double> doubles = new ArrayList<Double>();
		Double hashedKey = Double.valueOf(key.hashCode());
		hashedKey = hashedKey/1000000000;
		
		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Kappara, San Gwann, Malta")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Kappara, San Gwann, Malta")[1]), ".");
		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Tony USA, Sai Mai Road, Sai Mai, Bangkok, Thailand")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Tony USA, Sai Mai Road, Sai Mai, Bangkok, Thailand")[1]), ",");
		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Benjamin’s Garden, Lat Sawai, Lam Luk Ka District, Pathum Thani, Thailand")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Benjamin’s Garden, Lat Sawai, Lam Luk Ka District, Pathum Thani, Thailand")[1]), ":");
		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Daniel Thaiger Burger, Soi Sukhumvit 11, Khlong Toei Nuea, Watthana, Bangkok, Thailand")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Daniel Thaiger Burger, Soi Sukhumvit 11, Khlong Toei Nuea, Watthana, Bangkok, Thailand")[1]), "!");
		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Roberta Vinci, Ahuza Street, Pardes Hanna-Karkur")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Roberta Vinci, Ahuza Street, Pardes Hanna-Karkur")[1]), "?");
		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("Sarajevo, Bosnia and Herzegovina")[0])+","+String.valueOf(googleMapsAPI.getCordinates("Sarajevo, Bosnia and Herzegovina")[1]), "-");
		SpecialSymbols.put(String.valueOf(googleMapsAPI.getCordinates("SPACE Office Centre Sarajevo, Pijačna, Sarajevo, Bosnia and Herzegovina")[0])+","+String.valueOf(googleMapsAPI.getCordinates("SPACE Office Centre Sarajevo, Pijačna, Sarajevo, Bosnia and Herzegovina")[1]), " ");

		
		code = code.replace("\n", " ");
		while(code.endsWith(" "))
			code = code.replaceAll(" $","");
		code = code.replace(" ", ",");
		int j=0;
		for(int i=0;i<code.length();i++){
			if(code.charAt(i) == ','){
				doubles.add(Double.valueOf(code.substring(j, i)));
				j = i+1;
//				System.out.println(code);
			}
		}
		doubles.add(Double.valueOf(code.substring(j, code.length()-1)));
		for(int i=0;i<doubles.size();i++)
			doubles.set(i, doubles.get(i)-hashedKey);
		for(int i=0;i<doubles.size();i++)
			System.out.println(doubles.get(i));
		for(int i=0;i<doubles.size();i = i+2){
			String coordins= String.valueOf(doubles.get(i))+","+String.valueOf(doubles.get(i+1));
			if(SpecialSymbols.containsKey(coordins))
				message = message+SpecialSymbols.get(coordins);
			else
				message = message+googleMapsAPI.getChar(new Double[]{doubles.get(i),doubles.get(i+1)});
		}
		OutputDecryptionPanel.setOutput(message);
	}
}
