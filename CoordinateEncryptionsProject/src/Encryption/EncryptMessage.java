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
//	private ArrayList<String> listOfHashedCoordinates = new ArrayList<String>();
//	private HashMap<Character, Double[]> SpecialSymbols = new HashMap<Character, Double[]>();
//	private HashMap<Integer, Double> coordinatesBank = new HashMap<Integer, Double>();
	private String message;
	public EncryptMessage(String key,String message){
		this.key = key;
		this.message = message;
	}
	public String getMessage(){return this.message;}
	
	
//	@SuppressWarnings("unchecked")
	public void Encrypting() throws FileNotFoundException, IOException, ParseException{
//		SpecialSymbols.put('.',new Double[]{31.6687885,34.5742523});
//		SpecialSymbols.put(',',new Double[]{31.804381,34.655314});
//		SpecialSymbols.put(':',new Double[]{32.0852999,34.78176759999999});
//		SpecialSymbols.put('!',new Double[]{31.768319,35.21371});
//		SpecialSymbols.put('?',new Double[]{31.423196,34.595254});
//		SpecialSymbols.put('-',new Double[]{32.162413,34.844675});
//		SpecialSymbols.put(' ',new Double[]{32.095838,34.952177});
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
//			System.out.println(this.getMessage());
//				System.out.println(message.charAt(i));
//				resultsElement = (JSONArray) bodySource.get(String.valueOf(message.charAt(i)).toUpperCase());
				//r.nextInt((max - min) + 1) + min;
//				String address = (String)resultsElement.get(r.nextInt((resultsElement.size()-1 - 0) + 1) + 0);
//				String address = (String)resultsElement.get(0);
//				System.out.println(address);
//				temp = googleMapsAPI.getCordinates(address);
//				System.out.println(temp);
//				if(temp == null){
//					i--;
//					continue;
//				}
//				System.out.println("["+temp[0]+","+temp[1]+"]");
//				coordinatesBank.put(temp[0].hashCode(), temp[0]);
//				coordinatesBank.put(temp[1].hashCode(), temp[1]);
//				System.out.println("wtf");
//			System.out.println(message.charAt(i) == '\n');
				if(message.charAt(i) >= 'a' && message.charAt(i) <= 'z'){
					resultsElement = (JSONArray) bodySource.get(String.valueOf(message.charAt(i)).toUpperCase());
					String address = (String)resultsElement.get(r.nextInt((resultsElement.size()-1 - 0) + 1) + 0);
//					System.out.println(address);
					temp = googleMapsAPI.getCordinates(address);
					if(temp == null){
						i--;
						continue;
					}
//					System.out.println("["+temp[0]+","+temp[1]+"]");
					Double[] doubTemp = keyHash(temp);
					OutputEncryptionPanel.setOutput(String.valueOf(doubTemp[0]).replace(".", "x")+" "+String.valueOf(doubTemp[1]).replace(".", "x"));
				}else if(message.charAt(i) >= 'A' && message.charAt(i) <= 'Z'){
					resultsElement = (JSONArray) bodySource.get(String.valueOf(message.charAt(i)).toUpperCase());
					String address = (String)resultsElement.get(r.nextInt((resultsElement.size()-1 - 0) + 1) + 0);
//					System.out.println(address);
					temp = googleMapsAPI.getCordinates(address);
					if(temp == null){
						i--;
						continue;
					}
//					System.out.println("["+temp[0]+","+temp[1]+"]");
					Double[] doubTemp = keyHash(temp);
					OutputEncryptionPanel.setOutput(String.valueOf(doubTemp[0]).replace(".", "z")+" "+String.valueOf(doubTemp[1]).replace(".", "z"));
				}else if(message.charAt(i) == '\n'){
					Double[] doubTemp = keyHash(new Double[]{(double)300+(Math.round((r.nextDouble()*0.999999) * 1e7) / 1e7),(double)300+(Math.round((r.nextDouble()*0.999999) * 1e7) / 1e7)});
					OutputEncryptionPanel.setOutput(String.valueOf(doubTemp[0]).replace(".", "x")+" "+String.valueOf(doubTemp[1]).replace(".", "x"));
				}else{
//					System.out.println("work");
//					OutputEncryptionPanel.setOutput(keyHash(SpecialSymbols.get(message.charAt(i))));
//					System.out.println("["+SpecialSymbols.get(message.charAt(i))[0]+","+SpecialSymbols.get(message.charAt(i))[1]+"]");
					//r.nextInt((resultsElement.size()-1 - 0) + 1) + 0
					//Math.round(afterPoint * 1e9) / 1e9;
//					double rand = (r.nextDouble()*0.999999);
//					System.out.println((double)('.')*10+rand);
					Double[] doubTemp = keyHash(new Double[]{(double)(message.charAt(i))*10+(Math.round((r.nextDouble()*0.999999) * 1e7) / 1e7),(double)(message.charAt(i))*10+(Math.round((r.nextDouble()*0.999999) * 1e7) / 1e7)});
//					System.out.println(((double)(message.charAt(i))*10+(Math.round((r.nextDouble()*0.999999) * 1e7) / 1e7))+" "+((double)(message.charAt(i))*10+(Math.round((r.nextDouble()*0.999999) * 1e7) / 1e7)));
//					Double[] doubTemp = keyHash(SpecialSymbols.get(message.charAt(i)));
					OutputEncryptionPanel.setOutput(String.valueOf(doubTemp[0]).replace(".", "x")+" "+String.valueOf(doubTemp[1]).replace(".", "x"));
				}
				if((i+1)%4 == 0)
					OutputEncryptionPanel.setOutput("\n");
				else
					OutputEncryptionPanel.setOutput(" ");
//				System.out.println(listOfHashedCoordinates.get(listOfHashedCoordinates.size()-1)[0]+" "+listOfHashedCoordinates.get(listOfHashedCoordinates.size()-1)[1]);
//				System.out.println(listOfHashedCoordinates.get(listOfHashedCoordinates.size()-1)[0]+" "+listOfHashedCoordinates.get(listOfHashedCoordinates.size()-1)[1]);
		}
//		System.out.println(listOfHashedCoordinates.size() == this.getMessage().length());
//		OutputPanel.clearOutput();
//		for(int i=0;i<listOfHashedCoordinates.size();i++){
//			if((i+1)%4 == 0)
//				OutputEncryptionPanel.setOutput(listOfHashedCoordinates.get(i)+"\n");
//			else
//				OutputEncryptionPanel.setOutput(listOfHashedCoordinates.get(i)+" ");
//			}
		
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
	public Double[] keyHash(Double[] cord){
		Double[] newCord = new Double[]{cord[0],cord[1]};
		int hashedKey = key.hashCode();
		//(int)(Math.log10(doub)+1)
//		System.out.println(hashedKey);
//		System.out.println(((int)Math.log10(hashedKey)+1));
		if(((int)Math.log10(Math.abs(hashedKey))+1) > 8)
			hashedKey = hashedKey/1000;
		
		for(int i=0;i<2;i++){
			double temp = newCord[i];
//			System.out.println("before removing the key: "+temp);
//			System.out.println("The Key: "+hashedKey);
			double afterPoint = Math.abs(newCord[i])-Math.floor(Math.abs(newCord[i]));
			afterPoint = afterPoint*Math.signum(temp);
			temp = (int)temp;
//			System.out.println("set x.0: "+temp);
			temp = temp + hashedKey;
//			System.out.println("sum with the key: "+temp);
//			double afterPoint = Math.abs(newCord[i])-Math.floor(Math.abs(newCord[i]));
//			System.out.println("after point: "+afterPoint);
			afterPoint = Math.round(afterPoint * 1e9) / 1e9;
//			System.out.println("after point + 1e9: "+afterPoint);
//			System.out.println((Math.signum(temp))*afterPoint+temp);
			newCord[i] = afterPoint+temp;
		}
//		System.out.println(hashedKey);
//		double doubKey = hashedKey/(double)Math.pow(10, ((int)Math.log10(Math.abs(hashedKey))+1)/2);
//		System.out.println(doubKey);
//		System.out.println("cord after hashing: "+newCord[0]+" "+newCord[1]);
//		System.out.println("cord after hashing: "+(cord[0]+hashedKey));
		return new Double[]{newCord[0],newCord[1]};
	}
}
