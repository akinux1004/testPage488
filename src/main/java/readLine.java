import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class readLine {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("src\\main\\webapp\\WEB-INF\\views\\sample\\editTags.txt");
		if(file.exists()) {
			BufferedReader inFile = new BufferedReader(new FileReader(file));
			String line = null;
			String prefix = "str += '     ";
			String suffix = "';";
			
			
			while((line = inFile.readLine()) != null) {
				System.out.println(prefix + line + suffix);
				
			}
			
			inFile.close();
			
			
		}
		
		
	}

}
