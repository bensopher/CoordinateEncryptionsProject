package Encryption;

import graphics.OutputDecryptionPanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.parser.ParseException;

public class Decrypt {
	private static ArrayList<String> subs = null;
	private static String message;
	private static int hashedKey;
	private static String code;
	public static int makeHashKey(String key){
		int hashedKey = key.hashCode();
		if(((int)Math.log10(Math.abs(hashedKey))+1) > 8)
			hashedKey = hashedKey/1000;
		return hashedKey;
	}
	public static void subsReplacing(String chr, int index){
		subs.set(index,subs.get(index).replace(chr, "."));
		subs.set(index+1,subs.get(index+1).replace(chr, "."));
	}
	public static double[] removeHashKay(double[] doub,double[] afterP){
		return new double[]{(((int)doub[0]) - hashedKey) + afterP[0],(((int)doub[1]) - hashedKey) + afterP[1]};
	}
	public static void isSpecialChar(double[] doub){
		int intTemp = (int)(doub[0] / 10);
		if(intTemp == 30)
			message = message+'\n';
		else
			message = message+(char)intTemp;
	}
	public static void removeSpaces(){
		code = code.replace("\n", " ");
		while(code.endsWith(" "))
			code = code.replaceAll(" $","");
	}
	public static void splitToSubs(){
		for(int i=0,j=0;i<code.length();i++){
			if(code.charAt(i) == ' ' || i==code.length()-1){
				if(i==code.length()-1)
					subs.add(code.substring(j, i+1));
				else
					subs.add(code.substring(j, i));
				j = i+1;
			}
		}
	}
	public static void Decryption(String key,String c) throws ParseException, IOException{
		subs = new ArrayList<String>();
		message = "";
		hashedKey = makeHashKey(key);
		code = c;
		removeSpaces();

		splitToSubs();
		
		for(int i=0;i<subs.size();i = i+2){
			boolean isUpper = false;
			if(subs.get(i).contains("z")){
				subsReplacing("z",i);
				isUpper = true;
			}
			else{
				subsReplacing("x",i);
			}
			double[] doubTemp = new double[]{Double.valueOf(subs.get(i)),Double.valueOf(subs.get(i+1))};
			double[] afterPoint = new double[]{Math.round(((Math.abs(doubTemp[0])-Math.floor(Math.abs(doubTemp[0])))*Math.signum(doubTemp[0]))* 1e9) / 1e9 , Math.round(((Math.abs(doubTemp[1])-Math.floor(Math.abs(doubTemp[1])))*Math.signum(doubTemp[1])) * 1e9) / 1e9};
			doubTemp = removeHashKay(doubTemp,afterPoint);
			if(doubTemp[0] > 180.0){
				isSpecialChar(doubTemp);
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
		}
		OutputDecryptionPanel.setOutput(message);
	}
}
