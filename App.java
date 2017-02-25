import java.io.File;

public class App {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length > 0) {
			File file = new File(args[0]);
			
			Model model = new Model(file);
			model.printAllShowtimesForDate("Sunday");
			model.printAllShowtimesForDate("Monday");
			model.printAllShowtimesForDate("Tuesday");
			model.printAllShowtimesForDate("Wednesday");
			model.printAllShowtimesForDate("Thursday");
			model.printAllShowtimesForDate("Friday");
			model.printAllShowtimesForDate("Saturday");

		}
	}
	

}
