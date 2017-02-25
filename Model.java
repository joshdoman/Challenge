import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;

public class Model {
	
	private LinkedList<Movie> movies;
	final private int weekday_open = 480;
	final private int weekday_close = 1380;
	final private int weekend_open = 630;
	final private int weekend_close = 1410;
	
	public Model(File file) {
		
		try {				
			FileMovieMaker fmm = FileMovieMaker.make(file);
			movies = fmm.getMovies();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileMovieMaker.FormatException e) {
			e.printStackTrace();
		}	
	}
	
	public void printAllShowtimesForDate(String date) {
		int open;
		int close;
		if (date.equals("Monday") || date.equals("Tuesday") || date.equals("Wednesday") 
			|| date.equals("Thursday")) {
			open = weekday_open;
			close = weekday_close;
		} else {
			open = weekend_open;
			close = weekend_close;
		}
		
		System.out.println(date);
		System.out.println("");
		
		for (Movie movie: movies) {
			printTimesForMovie(movie, open, close - 1);
			System.out.println("");
		}
	}
	
	//formats and prints the movie title and showing times given a 
	//movie, opening, and closing time
	public void printTimesForMovie(Movie movie, int open, int close) {
		String line = movie.getTitle() + " - " + "Rated " + movie.getRating() +", " + Model.getProperTime(movie.getMinutes());
		System.out.println(line);
		LinkedList<String> times = getTimes(movie, open, close);
		for (String time : times) {
			System.out.println(time);
		}
	}
	
	//given an opening time and closing time for the theatre
	//returns an ordered list of lines of consisting of showing times  
	public LinkedList<String> getTimes(Movie movie, int open, int close) {
		LinkedList<String> times = new LinkedList<String>();
		
		int duration = movie.getMinutes();
		int endTime = close;
		int startTime = close - duration;
		
		int adjustment = startTime % 5;
		
		endTime -= adjustment;
		startTime -= adjustment;
		
		while(startTime > open + 60) {
			String line = "  " + Model.getProperTime(startTime) + " - " + Model.getProperTime(endTime);
			times.addFirst(line);
			
			endTime = startTime - 36;
			startTime = endTime - duration;
			
			adjustment = startTime % 5;
			
			endTime -= adjustment;
			startTime -= adjustment;
		}
		
		return times;
	}
		
	//returns a formatted String corresponding to the number of minutes since 0:00
	//ex: 623 minutes -> "10:23"
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
