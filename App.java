import java.io.File;
import java.io.IOException;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length > 0) {
			File file = new File(args[0]);
			
			try {				
				FileMovieMaker fmm = FileMovieMaker.make(file);		
			} catch (IOException e) {
				e.printStackTrace();
			} catch (FileMovieMaker.FormatException e) {
				e.printStackTrace();
			}
			
		}
	}
	

}
