import java.io.File;

public class App {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length > 0) {
			File file = new File(args[0]);
			
			Model model = new Model(file);
			
		}
	}
	

}
