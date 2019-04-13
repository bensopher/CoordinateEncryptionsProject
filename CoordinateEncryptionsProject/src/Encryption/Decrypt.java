package Encryption;

import graphics.OutputDecryptionPanel;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

public class Decrypt {
	public static void Decryption(String key,String code) throws ParseException, IOException{
		String message = "";
		ArrayList<Double> doubles = new ArrayList<Double>();
		Double hashedKey = Double.valueOf(key.hashCode());
		hashedKey = hashedKey/1000000000;
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
			message = message+googleMapsAPI.getChar(new Double[]{doubles.get(i),doubles.get(i+1)});
		}
		OutputDecryptionPanel.setOutput(message);
	}
}
