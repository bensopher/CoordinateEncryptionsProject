package Encryption;
import graphics.OutputPanel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListResourceBundle;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class EncryptMessage {
	private ArrayList<long[]> listOfHashedCoordinates = new ArrayList<long[]>();
	private String message;
	public EncryptMessage(String message){
		if(!setMessage(message)){
			message = "The message was empty.";
		}
	}
	public boolean setMessage(String message){
		if(message == null) return false;
		this.message = message;
		return true;
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
//		JSONObject bodySource = (JSONObject) parser.parse(new FileReader("C:\\Users\\tony\\git\\CoordinateEncryptionsProject\\CoordinateEncryptionsProject\\src\\streets\\streets.json"));
		System.out.println(bodySource);
		Double[] temp = new Double[2];
		for(int i=0;i<this.getMessage().length();i++){
			if(message.charAt(i) >= 'a' && message.charAt(i) <= 'z'){
				System.out.println(message.charAt(i));
				resultsElement = (JSONArray) bodySource.get(String.valueOf(message.charAt(i)).toUpperCase());
				//r.nextInt((max - min) + 1) + min;
				int rand = r.nextInt((resultsElement.size()-1 - 0) + 1) + 0;
				String street = (String)resultsElement.get(rand);
				System.out.println(street);
				temp = googleMapsAPI.getCordinates(street+",USA");
				if(temp == null){
					i--;
					continue;
				}
				System.out.println("["+temp[0]+","+temp[1]+"]");
				listOfHashedCoordinates.add(new long[]{temp[0].hashCode(),temp[1].hashCode()});
			}else if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z'){
				
			}else{
				
			}
		}
		System.out.println(listOfHashedCoordinates.size() == this.getMessage().length());
		for(int i=0;i<listOfHashedCoordinates.size();i++)
			OutputPanel.setOutput(listOfHashedCoordinates.get(i)[0]+" "+listOfHashedCoordinates.get(i)[1]+"\n");
	}
}
