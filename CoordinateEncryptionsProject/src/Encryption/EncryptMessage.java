package Encryption;
import graphics.OutputEncryptionPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class EncryptMessage {
	private String key;
	private String message;
	public EncryptMessage(String key,String message){
		this.key = key;
		this.message = message;
	}
	public String getMessage(){return this.message;}
	public void Encrypting() throws FileNotFoundException, IOException, ParseException{
		Random r = new Random();
		JSONParser parser = new JSONParser(); 
		JSONArray resultsElement;
		File f=new File("streets/streets.json");
		String path = f.getAbsolutePath();
		path = path.replace("\\", "\\\\").replace("CoordinateEncryptionsProject\\\\streets", "CoordinateEncryptionsProject\\\\src\\\\streets");
		JSONObject bodySource = (JSONObject) parser.parse(new FileReader(path));

		Double[] temp = new Double[2],doubTemp;
		
		for(int i=0;i<this.getMessage().length();i++){
			
			String set = "x";
			if(Character.isUpperCase(message.charAt(i)))
				set = "z";
			
			if(Character.isAlphabetic(message.charAt(i))){
				resultsElement = (JSONArray) bodySource.get(String.valueOf(message.charAt(i)).toUpperCase());
				String address = (String)resultsElement.get(r.nextInt((resultsElement.size()-1 - 0) + 1) + 0);
				temp = googleMapsAPI.getCordinates(address);
				if(temp == null){
					i--;
					continue;
				}
				doubTemp = keyHash(temp);
			}else if(message.charAt(i) == '\n'){
				doubTemp = keyHash(new Double[]{(double)300+(Math.round((r.nextDouble()*0.999999) * 1e7) / 1e7),(double)300+(Math.round((r.nextDouble()*0.999999) * 1e7) / 1e7)});
			}else{
				doubTemp = keyHash(new Double[]{(double)(message.charAt(i))*10+(Math.round((r.nextDouble()*0.999999) * 1e7) / 1e7),(double)(message.charAt(i))*10+(Math.round((r.nextDouble()*0.999999) * 1e7) / 1e7)});
			}
			OutputEncryptionPanel.setOutput(String.valueOf(doubTemp[0]).replace(".", set)+" "+String.valueOf(doubTemp[1]).replace(".", set));
			if((i+1)%4 == 0)
				OutputEncryptionPanel.setOutput("\n");
			else
				OutputEncryptionPanel.setOutput(" ");
			}
	}
	public Double[] keyHash(Double[] cord){
		Double[] newCord = new Double[]{cord[0],cord[1]};
		int hashedKey = key.hashCode();
		if(((int)Math.log10(Math.abs(hashedKey))+1) > 8)
			hashedKey = hashedKey/1000;
		
		for(int i=0;i<2;i++){
			double temp = newCord[i];
			double afterPoint = Math.abs(newCord[i])-Math.floor(Math.abs(newCord[i]));
			afterPoint = afterPoint*Math.signum(temp);
			temp = (int)temp;
			temp = temp + hashedKey;
			afterPoint = Math.round(afterPoint * 1e9) / 1e9;
			newCord[i] = afterPoint+temp;
		}
		return new Double[]{newCord[0],newCord[1]};
	}
}
