package Encryption;

import graphics.OutputDecryptionPanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.parser.ParseException;

public class Decrypt {
	public static void Decryption(String key,String code) throws ParseException, IOException{
		ArrayList<String> subs = new ArrayList<String>();
		String message = "";
		int hashedKey = key.hashCode(),abs_hash=Math.abs(hashedKey),log_dec=(int)Math.log10(abs_hash);
		if(log_dec> 7)
			hashedKey = hashedKey/1000;
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
			if(subs.get(i).contains("x")){
				subs.set(i,subs.get(i).replace("x", "."));
				subs.set(i+1,subs.get(i+1).replace("x", "."));
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
					else
						message = message+chr;
				}
			}else if(subs.get(i).contains("z")){
				subs.set(i,subs.get(i).replace("z", "."));
				subs.set(i+1,subs.get(i+1).replace("z", "."));
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
				}
				else{
					String chr = googleMapsAPI.getChar(new Double[]{doubTemp[0],doubTemp[1]});
					if(chr == null){
						Random r = new Random();
						message = message+(char)(r.nextInt(60) + ' ');
					}
					else
						message = message+chr.toUpperCase();
				}
			}
		}
		OutputDecryptionPanel.setOutput(message);
}}
