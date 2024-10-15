import java.io.*;

public class TextFileManipulationBufferedReader {
    public static void main(String[] args) throws Exception {
	File myFile = new File("MyFile.txt");
        BufferedReader br = new BufferedReader(new FileReader(myFile));
        String st;
	    while((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }
}

