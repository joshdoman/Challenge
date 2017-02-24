import org.junit.Before;  
import org.junit.Test;

import static org.junit.Assert.*;

public class ModelTests {
	
	String line1 = "There's Something About Mary, 1998, R, 2:14";
	String line2 = "How to Lose a Guy in 10 Days, 2003, PG-13, 1:56";
	
	@Before
    public void setUp() {

    }
	
	@Test
	public void testParseMovie() {
		Movie movie1 = new Movie("There's Something About Mary", 1998, "R", 134);
		assertEquals(movie1, FileMovieMaker.getMovieFromLine(line1));
		
		Movie movie2 = new Movie("How to Lose a Guy in 10 Days", 2003, "PG-13", 116);
		assertEquals(movie2, FileMovieMaker.getMovieFromLine(line2));
	}
	
	@Test
	public void testProperMinutes() {
		String str = Model.getProperTime(646);
		assertEquals(str, "10:46");
	}
	
}