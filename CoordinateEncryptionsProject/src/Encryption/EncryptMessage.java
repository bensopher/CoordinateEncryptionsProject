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
	private ArrayList<Double[]> listOfHashedCoordinates = new ArrayList<Double[]>();
//	private HashMap<Integer, Double> coordinatesBank = new HashMap<Integer, Double>();
	private String message;
	public EncryptMessage(String key,String message){
		this.key = key;
		this.message = message;
	}
	public String getMessage(){return this.message;}
	
	
//	@SuppressWarnings("unchecked")
	public void Encrypting() throws FileNotFoundException, IOException, ParseException{
		Random r = new Random();
		JSONParser parser = new JSONParser(); 
		JSONArray resultsElement;
		File f=new File("streets/streets.json");
		String path = f.getAbsolutePath();
		path = path.replace("\\", "\\\\").replace("CoordinateEncryptionsProject\\\\streets", "CoordinateEncryptionsProject\\\\src\\\\streets");
		JSONObject bodySource = (JSONObject) parser.parse(new FileReader(path));
//		JSONObject bodySource = (JSONObject) parser.parse(new FileReader("C:\\Users\\tony\\git\\CoordinateEncryptionsProject\\CoordinateEncryptionsProject\\src\\streets\\streets.json"));
//		System.out.println(bodySource);
		Double[] temp = new Double[2];
		for(int i=0;i<this.getMessage().length();i++){
//			System.out.println(this.getMessage().length());
//			if(message.charAt(i) >= 'a' && message.charAt(i) <= 'z'){
//				System.out.println(message.charAt(i));
				resultsElement = (JSONArray) bodySource.get(String.valueOf(message.charAt(i)).toUpperCase());
				//r.nextInt((max - min) + 1) + min;
//				String address = (String)resultsElement.get(r.nextInt((resultsElement.size()-1 - 0) + 1) + 0);
				String address = (String)resultsElement.get(0);
				System.out.println(address);
				temp = googleMapsAPI.getCordinates(address);
//				System.out.println(temp);
				if(temp == null){
					i--;
					continue;
				}
				System.out.println("["+temp[0]+","+temp[1]+"]");
//				coordinatesBank.put(temp[0].hashCode(), temp[0]);
//				coordinatesBank.put(temp[1].hashCode(), temp[1]);
//				System.out.println("wtf");
				listOfHashedCoordinates.add(new Double[]{kayHash(temp[0]),kayHash(temp[1])});
//				System.out.println(listOfHashedCoordinates.get(listOfHashedCoordinates.size()-1)[0]+" "+listOfHashedCoordinates.get(listOfHashedCoordinates.size()-1)[1]);
//				System.out.println(listOfHashedCoordinates.get(listOfHashedCoordinates.size()-1)[0]+" "+listOfHashedCoordinates.get(listOfHashedCoordinates.size()-1)[1]);
//			}else if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z'){
//				
//			}else{
//				
//			}
		}
//		System.out.println(listOfHashedCoordinates.size() == this.getMessage().length());
//		OutputPanel.clearOutput();
		for(int i=0;i<listOfHashedCoordinates.size();i++){
			if((i+1)%4 == 0)
				OutputEncryptionPanel.setOutput(listOfHashedCoordinates.get(i)[0]+" "+listOfHashedCoordinates.get(i)[1]+"\n");
			else
				OutputEncryptionPanel.setOutput(listOfHashedCoordinates.get(i)[0]+" "+listOfHashedCoordinates.get(i)[1]+" ");
			}
		
//		JSONObject jsonOutput = new JSONObject();
//		HashMap<String,HashMap<Integer, Double>> withKey = new HashMap<String,HashMap<Integer, Double>>();
//		withKey.put(key, coordinatesBank);
//		jsonOutput.putAll(withKey);
//		//Write JSON file
//		File keysFile=new File("keys/keys.json");
//		String keysPath = keysFile.getAbsolutePath();
//		keysPath = keysPath.replace("\\", "\\\\").replace("CoordinateEncryptionsProject\\\\keys", "CoordinateEncryptionsProject\\\\src\\\\keys");
//		try{
//			FileReader fileNotEmpty = new FileReader(keysPath);
//			JSONObject keysBody = (JSONObject) parser.parse(fileNotEmpty);
//			keysBody.put(key, coordinatesBank);
//			
//		}catch(Exception FileNotFoundException){
//			FileWriter file = new FileWriter(keysPath);
//			file.write(jsonOutput.toJSONString());
//	        file.flush();
//		}
	}
	public Double kayHash(Double cord){
		Double hashedKey = Double.valueOf(key.hashCode());
//		hashedKey = hashedKey/1000000000;
		return cord+hashedKey;
	}
}
