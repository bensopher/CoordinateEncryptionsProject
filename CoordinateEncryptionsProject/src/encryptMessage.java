import java.util.ArrayList;


public class encryptMessage {
	private ArrayList<Double[]> listOfHashedCoordinates = new ArrayList<Double[]>();
	private String message;
	public encryptMessage(String message){
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
	public void Encrypting(){
		for(int i=0;i<this.getMessage().length();i++){
			
		}
	}
}
