import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;

import org.json.simple.parser.ParseException;

public class main {
	public static void main(String[] args) throws ParseException, IOException {
		Double[] arrDouble = googleMapsAPI.getCordinates("Alvord, TX, Stati Uniti");
		long l = Long.valueOf(Double.doubleToLongBits(arrDouble[0])).hashCode();
		System.out.println(Arrays.toString(arrDouble));
//		System.out.println(Long.valueOf(Double.doubleToLongBits(42.5)).hashCode());
		Hashtable<Long, Double> hashTypes = new Hashtable<Long,Double>();
		hashTypes.put(l, arrDouble[0]);
		System.out.println(l);
		System.out.println(hashTypes.get(l));
	}
}
