import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystems;


public class Main {



	public static void main(String[] args) throws Exception  {

		String path = FileSystems.getDefault().getPath("test.txt").toString();
		doesFileExist(path);

		printDictionary(path);
	}

	public static void doesFileExist(String path) throws Exception  {
		File f = new File(path);
		if (!f.exists()) {
			String message = "Cannot find file!";
			System.out.println(message);
			throw new Exception (message);
		}else
			System.out.println("The file exists!");
	}

	public static void printDictionary(String path) throws IOException{
		// Open the file
		FileInputStream fstream = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
			// Print the content on the console
			System.out.println (strLine);
			printLine(strLine);
		}

		//Close the input stream
		fstream.close();
	}

	public static void printLine(String strLine) {
		// TODO Auto-generated method stub
		String[] arrOfStr = strLine.split(" – ");
		String[] arrMeaning = arrOfStr[1].split(",");

		if(arrMeaning.length>0){
			System.out.println(arrOfStr[0]);
			for (String a : arrMeaning) 
				System.out.println(a);
		}
		else{  
			for (String a : arrOfStr) 
				System.out.println(a);
		}
	}
}
