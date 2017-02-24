import java.util.LinkedList;
import java.util.TreeSet;
import java.io.* ;

public class FileMovieMaker {

  private LinkedList<Movie> movies;
	
  /** A special purpose exception class to indicate errors when reading 
   *  the input for the FileCorrector.
   */
  @SuppressWarnings("serial")
  public static class FormatException extends Exception {
    public FormatException(String msg) {
      super(msg);
    }
  }


  /**
   * @param r The sequence of characters to parse 
   * @throws IOException for an io error while reading
   * @throws FileMoveMaker.FormatException for an invalid line
   * @throws IllegalArgumentException if the provided reader is null
   */
  public FileMovieMaker(Reader r) throws IOException, FormatException {
	  if (r == null) throw new IllegalArgumentException();
	  BufferedReader br = new BufferedReader(r);
	  movies = new LinkedList<Movie>();
	  try {
		  br.readLine();
		  for(String line = br.readLine(); line != null; line = br.readLine()) {
			  Movie m = FileMovieMaker.getMovieFromLine(line);
			  movies.add(m);
		  }
	  } catch (IOException e) {
		  throw new IOException("Reading error");
	  } finally {
		  br.close();
	  }
  }
  
  //Constructs a Movie from a line in the input file
  public static Movie getMovieFromLine(String line) {
	  String str = line;
	  int index = str.indexOf(",");
	  String title = str.substring(0, index);
	  
	  str = str.substring(index + 2); //account for space after comma
	  
	  index = str.indexOf(",");
	  int year = Integer.valueOf(str.substring(0, index));
	  
	  str = str.substring(index + 2); //account for space after comma
	  
	  index = str.indexOf(",");
	  String rating = str.substring(0, index);
	  
	  str = str.substring(index + 2); //account for space after comma
	  
	  index = str.indexOf(":");
	  int hours = Integer.valueOf(str.substring(0, index));
	  int minutes = Integer.valueOf(str.substring(index+1));
	  int totalMinutes = 60*hours + minutes;
	  
	  return new Movie(title, year, rating, totalMinutes);
  }
  
  //returns a set of all movies
  public LinkedList<Movie> getMovies() {
	  return movies;
  }
  
  /** Construct a FileMovieMaker from a file.
   *
   * @param filename of file to read from
   * @throws IOException if error while reading
   * @throws FileMovieeMaker.FormatException for an invalid line
   * @throws FileNotFoundException if file cannot be opened
   */
  public static FileMovieMaker make(File file) throws IOException, FormatException {
	  if (file == null) throw new FormatException("improper file");
	  Reader r = new FileReader(file);
	  FileMovieMaker fc;
	  try {
			fc = new FileMovieMaker(r);
	  } finally {
	      if (r != null) { r.close(); }
     }
	  return fc;
  }

}