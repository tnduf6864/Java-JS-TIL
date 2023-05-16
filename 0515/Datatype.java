
public class Datatype {

	public static void main(String[] args) {		
		//byte, short, int, long, float, double, char, boolean
		
		byte b = 127;
		long lon = 2147483647L;
		float f = 123.4F;
		char c = '㉿';
		boolean flag = true;
		
	
		f = lon;
		lon = (long)f;
		
		lon = c;
		System.out.println(lon);
		
		
	}


}
