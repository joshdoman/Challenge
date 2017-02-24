import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;

public class Model {
	
	private LinkedList<Movie> movies;
	
	public Model(File file) {
		
		try {				
			FileMovieMaker fmm = FileMovieMaker.make(file);
			movies = fmm.getMovies();
			getTimes(movies.getFirst(), 1379);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileMovieMaker.FormatException e) {
			e.printStackTrace();
		}	
	}
	
	public LinkedList<String> getTimes(Movie movie, int endTime) {
		int duration = movie.getMinutes();
		int startTime = endTime - duration;
		
		String line = "  " + Model.getProperTime(startTime) + " - " + Model.getProperTime(endTime);
		System.out.println(line);
		return null;
	}
		
	public static String getProperTime(int minutes) {
		int hours = minutes / 60;
		int min = minutes % 60;
		return Integer.toString(hours) + ":" + Integer.toString(min);
	}
	
	
	
}
