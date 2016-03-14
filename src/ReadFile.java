import java.io.*;

public class ReadFile{

	public static void main (String[] args){
	}
	public ReadFile (Window2 Reader)
	
	{
		String path;
		path = "C:\\Users\\Jon\\Documents\\Career\\FightingGame\\CompCulm\\src";
		try{
			BufferedReader input = new BufferedReader(new FileReader (path + "TierOneDatabase.txt"));
			String str;
			while ((str = input.readLine()) !=null) {
				System.out.println(str);
			}
			input.close();
		}catch (Exception e) {
			System.err.println ("Error: " + e.getMessage());{
			}
		}
	}
}
