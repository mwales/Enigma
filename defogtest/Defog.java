import java.util.Base64;
import java.util.List;

class Defog
{
	public static void main(String args[])
	{
		String test = "VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wZWQgb3ZlciB0aGUgbGF6eSBicm93biBkb2cK";

		System.out.println("Test : " + test);

		Base64.Decoder dec = Base64.getDecoder();
		byte decBytes[] = dec.decode(test);

		String sol = new String(decBytes);

		System.out.println("Decoded: " + sol);


		String test2 = "HWAAESMVGgU6QiwDDiwVDTdBCCAUKiaFO14gLQk=";
		String sol2 = defog(test2, 2);
		String sol3 = defog(test2, 1);
		
		System.out.println("Test 2 = " + sol2);
		System.out.println("Test 2 = " + sol3);	
	}

	public static String key1 = "I Love Android";
	public static String key2 = "Y9*PI8B#gD^6Yhd1";

	public static String defog(String fogged, int keyIndex)
	{
		Base64.Decoder b64Dec = Base64.getDecoder();
		byte decBytes[] = b64Dec.decode(fogged);

		
		String key = "";
		if (keyIndex == 1)
		{
			key = key1;
		}
		else
		{
			key = key2;
		}
		int keyLenMod = key.length() / 2;

		System.out.println(fogged + " decoded into " + Integer.toString(decBytes.length) + " bytes");

		//List<byte> solBytes = new List<byte>();
		byte solBytes[] = new byte[decBytes.length];

		for(int curByte = 0; curByte < decBytes.length; curByte++)
		{
			byte keyByte = key.getBytes()[curByte % keyLenMod * 2];
			solBytes[curByte] = (byte) (decBytes[curByte] ^ keyByte);

			System.out.println("Single = " + Integer.toString(decBytes[curByte] ^ keyByte) + " = " + Integer.toString(solBytes[curByte]));
		}

		System.out.println("Together = " + solBytes);

		return new String(solBytes);
			
	}

}

