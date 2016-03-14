
import java.io.*;
import java.util.*;
class DataBase  

{
	String DataBaseFile;
	FileWriter outputraw;
	BufferedWriter output;
	public DataBase(String File){
		DataBaseFile = File;
		try{
			outputraw = new FileWriter (DataBaseFile, true);
			output = new BufferedWriter(outputraw);
			//output.write("hello");
			//output.close();
		}catch (Exception e) {
			//Catch exception if any 
			System.err.println ("Error: " + e.getMessage());
		}
	}
	//RecordR
	public Record Search(String Username){
		Record R = new Record();
		try{
			BufferedReader input = new BufferedReader(new FileReader (DataBaseFile));
			String str;
			String list[];
			while ((str = input.readLine()) !=null) {
				StringTokenizer st = new StringTokenizer (str);

				// first find out how many numbers there are in str
				int count = st.countTokens ();

				// now create an array to hold them
				list = new String [count];

				int i = 0;
				while (st.hasMoreTokens())
				{
					// get the numbers into list
					list [i++] = st.nextToken();
				}
				if (list [0].equals(Username)){
					R.Username = list [0];
					R.Password = list [1];
					R.kills = Integer.decode(list[2]);
					R.deaths = Integer.decode(list[3]);
				}

			}
			//input.close();
		}catch (Exception e) {
			System.err.println ("Error: " + e.getMessage());
		}
		return R;
	}


	public void Write (Record R){
		try{
			output = new BufferedWriter(outputraw);
			System.out.println (R.Username);
			output.write(R.Username + " ");
			//output.close();
			System.out.println (R.Password);
			output.write(R.Password + " ");
			//output.write (R.Username);
			//output.write (R.Password);
			output.write (R.kills + " ");
			output.write (R.deaths + "\n");
			output.close();
		}catch (Exception e) {
			//Catch exception if any 
			System.err.println ("Write Error: " + e.getMessage());
		}
	}
	public void close (){
		try{
			output.close();
		}catch (Exception e) {
			//Catch exception if any 
			System.err.println ("Error: " + e.getMessage());
		}
	}
}





