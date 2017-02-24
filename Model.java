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
			printTimesForMovie(movies.getFirst());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileMovieMaker.FormatException e) {
			e.printStackTrace();
		}	
	}
	
	public void printTimesForMovie(Movie movie) {
		String line = movie.getTitle() + " - " + "Rated " + movie.getRating() +", " + Model.getProperTime(movie.getMinutes());
		System.out.println(line);
		LinkedList<String> times = getTimes(movie, 480, 1379);
		for (String time : times) {
			System.out.println(time);
		}
	}
	
	public LinkedList<String> getTimes(Movie movie, int open, int endTime) {
		LinkedList<String> times = new LinkedList<String>();
		
		int duration = movie.getMinutes();
		int startTime = endTime - duration;
		
		while(startTime > open + 60) {
			String line = "  " + Model.getProperTime(startTime) + " - " + Model.getProperTime(endTime);
			times.addFirst(line);
			
			endTime = startTime - 36;
			startTime = endTime - duration;
		}
		
		return times;
	}
		
	public static String getProperTime(int minutes) {
		int hours = minutes / 60;
		int min = minutes % 60;
		
		String strHr = Integer.toString(hours);
		String strMin = Integer.toString(min);
		
		if (min < 10) {
			strMin = "0" + strMin;
		}
		
//		if (hours < 10) {
//			strHr = "0" + strHr;
//		}
		
		return strHr + ":" + strMin;
	}
	
	
	
}
