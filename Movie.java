
public class Movie {

	final private String title;
	final private int year;
	final private String rating;
	final private int minutes;
	
	public Movie(String title, int year, String rating, int minutes) {
		this.title = title;
		this.year = year;
		this.rating = rating;
		this.minutes = minutes;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getRating() {
		return rating;
	}
	
	public int getMinutes() {
		return minutes;
	}
	
	//http://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (!Movie.class.isAssignableFrom(obj.getClass())) {
	        return false;
	    }
	    final Movie other = (Movie) obj;
	    if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
	        return false;
	    }
	    if ((this.rating == null) ? (other.rating != null) : !this.rating.equals(other.rating)) {
	        return false;
	    }
	    if (this.year != other.year) {
	        return false;
	    }
	    if (this.minutes != other.minutes) {
	        return false;
	    }
	    return true;
	}

	@Override
	public int hashCode() {
	    int hash = 3;
	    hash = 53 * hash + (this.title != null ? this.title.hashCode() : 0);
	    hash = 53 * hash + this.year;
	    return hash;
	}
	
}
