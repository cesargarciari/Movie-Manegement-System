

package Database;

import java.sql.*;
import java.util.ArrayList;

import TRA.Domain.*;

/**
 * 
 * @author Logan, Nurullo, Jayden, Roland
 * 
 * Database manager class meant to access and interact with the supplied TRA database.
 */
public class DatabaseManager {
	  static Connection connection=null;
/**
 * 		
 * @param args
 *  Initialization class in order to create the database connection
 *  IMPORTANT: ensure password on line 46 is correct in relation to the local connection password
 */
public static void initialize(String[] args) {
	
	
	try {
	
	// Load the MySQL JDBC driver
	
	String driverName = "com.mysql.cj.jdbc.Driver";
	
	Class.forName(driverName);
	
	
	// Create a connection to the database
	
	String serverName = "localhost:3306";
	
	String schema = "tra";
	
	String url = "jdbc:mysql://" + serverName +  "/" + schema;
	
	String username = "root";
	
	String password = "Password";
	
	connection = DriverManager.getConnection(url, username, password);
	
	 
	
	System.out.println("Successfully Connected to the database!");
	
	 
	  } catch (ClassNotFoundException e) {
	
	System.out.println("Could not find the database driver " + e.getMessage());
	  } catch (SQLException e) {
	
	System.out.println("Could not connect to the database " + e.getMessage());
	  }
	
	}
	 /**
	  * 
	  * @return returns all movies from the database
	  */
	 public static ArrayList<Movie> getMovies() {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
			 
			  // For each row of the result set ...
			  ArrayList<Movie> movieResults = new ArrayList<Movie>();
			  while (results.next()) {
			 
			 
			  // Get the data from the current row using the column name - column data are in the VARCHAR format
			  String movieTitle = results.getString(1);
			  String dateReleased = results.getString(2);
			  int movieLength = results.getInt(3);
			  String genre = results.getString(4);
			 
			  movieResults.add(new Movie(movieTitle, dateReleased, movieLength, genre));
			
			}
				 return movieResults;
	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 /**
	  * 
	  * @return returns all theatres from the database
	  */
	 public static ArrayList<Theatre> getTheatres() {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Theatre");
			 
			  // For each row of the result set ...
			  ArrayList<Theatre> theatreResults = new ArrayList<Theatre>();
			  while (results.next()) {
			 
			 
			  // Get the data from the current row using the column name - column data are in the VARCHAR format
			  String theatreName = results.getString(1);

			 
			  theatreResults.add(new Theatre(theatreName));
			 
			 
			  }
				 return theatreResults;
	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 /**
	  * 
	  * @return returns all showings from the database
	  */
	 public static ArrayList<Showing> getShowings() {
		 try {
			 ArrayList<Integer> id = new ArrayList<>();
			 ArrayList<String> movieTitles = new ArrayList<>();
			 ArrayList<Theatre> t = new ArrayList<>();
			 ArrayList<Integer> seatMapID = new ArrayList<>();
			 ArrayList<String> showtime = new ArrayList<>();

			 Statement statement = connection.createStatement();
			 ResultSet results = statement.executeQuery("SELECT * FROM showing");

			 ArrayList<Showing> showings = new ArrayList<>();
			 while(results.next()) {
				 id.add(results.getInt(1));
				 movieTitles.add(results.getString(2));
				 t.add(new Theatre(results.getString(3)));
				 seatMapID.add(results.getInt(4));
				 showtime.add(results.getString(5));
			 }

			 for(int i = 0; i < id.size(); i++) {
				 results = statement.executeQuery("SELECT * FROM seat WHERE seatMapID = " + seatMapID.get(i));

				 ArrayList<Seat> seats = new ArrayList<>();
				 while (results.next()) {
					 seats.add(new Seat(results.getInt(1), results.getInt(2), results.getBoolean(3)));
				 }
				 ResultSet r = statement.executeQuery("SELECT * FROM seatmap WHERE seatMapID = " + seatMapID.get(i));
				 r.next();
				 SeatMap s = new SeatMap(r.getInt(1), r.getInt(2), r.getInt(3), r.getInt(4), seats);

				 r = statement.executeQuery("SELECT * FROM movie WHERE movie.movieTitle = '" + movieTitles.get(i) + "'");
				 r.next();
				 Movie m = new Movie(r.getString(1), r.getString(2), r.getInt(3), r.getString(4));

				 showings.add(new Showing(id.get(i), m, t.get(i), s, showtime.get(i)));
			 }


			 return showings;
		 } catch (SQLException e) {

			 System.out.println("Could not retrieve data from the database " + e.getMessage());
		 }
		 return null;
	 }
	 
	 /**
	  * 
	  * @return returns all seats from the database
	  */
	 public static ArrayList<Seat> getSeats() {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
			 
			  // For each row of the result set ...
			  String data;
			  ArrayList<Seat> seatResults = new ArrayList<Seat>();
			  while (results.next()) {
			 
			 
			  // Get the data from the current row using the column name - column data are in the VARCHAR format
			  Boolean vacant = results.getBoolean(3);
			  int seatNumber = results.getInt(2);
			  int seatMapID = results.getInt(1);
			 
			  seatResults.add(new Seat(seatMapID, seatNumber, vacant));
			 
			 
			}
				 return seatResults;
	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		 return null;
	 }
	 
	 /**
	  * returns all seats belonging to a specific seatMap
	  * 
	  * @param seatMapID the ID of the seatMap used to find the seats
	  * @return list of seats belonging to given seatmap
	  */
	public static ArrayList<Seat> getSeats(int seatMapID) {
		try {

			// Get a result set containing all data from test_table

			Statement statement = connection.createStatement();

			ResultSet results = statement.executeQuery("SELECT * FROM Movie");

			// For each row of the result set ...
			String data;
			ArrayList<Seat> seatResults = new ArrayList<Seat>();
			while (results.next()) {


				// Get the data from the current row using the column name - column data are in the VARCHAR format
				Boolean vacant = results.getBoolean(0);
				int seatNumber = results.getInt(1);

				seatResults.add(new Seat(seatMapID, seatNumber, vacant));


			}
			return seatResults;

		} catch (SQLException e) {

			System.out.println("Could not retrieve data from the database " + e.getMessage());
		}
		return null;
	}
	 
	/**
	 * returns all seatMaps from the database
	 * 
	 * @return array list of all seatmaps
	 */
	 public static ArrayList<SeatMap> getSeatMaps() {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Movie");
			 
			  // For each row of the result set ...
			  String data;
			  ArrayList<SeatMap> seatMapResults = new ArrayList<SeatMap>();
			  while (results.next()) {
			 
			 
			  // Get the data from the current row using the column name - column data are in the VARCHAR format
			  int seatMapID = results.getInt(1);
			  int reservedSeatCount = results.getInt(2);
			  int numberOfRows = results.getInt(3);
			  int numberOfAvailableSeats = results.getInt(4);

			  results = statement.executeQuery("SELECT * FROM seat WHERE seatMapID = " + seatMapID);
			  ArrayList<Seat> seats = new ArrayList<>();
			  while (results.next()) {
			  	  seats.add(new Seat(results.getInt(1), results.getInt(2), results.getBoolean(3)));
			  }
			 
			  seatMapResults.add(new SeatMap(seatMapID, reservedSeatCount, numberOfRows, numberOfAvailableSeats, seats));
			 
			 
			}
				 return seatMapResults;
	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		 return null;
	 }
	 
	 /**
	  * 
	  * returns a specific movie from the database given the title
	  * 
	  * @param movieTitle title of the movie to be returned
	  * @return  movie to be returned
	  */
	 public static Movie getMovie(String movieTitle) {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Showing WHERE movieTitle = " + movieTitle);

			  return new Movie(results.getString(1), results.getString(2), results.getInt(3), results.getString(4));
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 /**
	  * 
	  * returns a specific theatre from the database given its name
	  * 
	  * @param theatreName name of the theatre to be returned
	  * @return theatre to be returned

	  */
	 public static Theatre getTheatre(String theatreName) {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Showing WHERE showingID = " + theatreName);

			  return new Theatre(results.getString(1));
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 /**
	  *  
	  *  Returns a specific showing from the database given its ID
	  *  
	  * @param showingID ID of the showing to be returned
	  * @return showing to be returned
	  */
	 public Showing getShowing(int showingID) {
		 try {

			 // Get a result set containing all data from test_table

			 Statement statement = connection.createStatement();

			 ResultSet results = statement.executeQuery("SELECT * FROM showing WHERE showingID = "+showingID);

			 results.next();
			 int id = results.getInt(1);
			 String movieTitle = results.getString(2);
			 Theatre t = new Theatre(results.getString(3));
			 int seatMapID = results.getInt(4);
			 String st = results.getString(5);

			 results = statement.executeQuery("SELECT * FROM movie WHERE movieTitle = '" + movieTitle + "'");
			 results.next();
			 Movie m = new Movie(results.getString(1), results.getString(2), results.getInt(3), results.getString(4));
			 results = statement.executeQuery("SELECT * FROM seat WHERE seatMapID = '" + seatMapID + "'");

			 ArrayList<Seat> seats = new ArrayList<>();
			 while (results.next()) {
				 seats.add(new Seat(results.getInt(1), results.getInt(2), results.getBoolean(3)));
			 }
			 results = statement.executeQuery("SELECT * FROM seatmap WHERE seatMapID = '" + seatMapID + "'");
			 results.next();
			 SeatMap s = new SeatMap(results.getInt(1), results.getInt(2), results.getInt(3), results.getInt(4), seats);


			 return new Showing(id, m, t, s, st);
		 } catch (SQLException e) {

			 System.out.println("Could not retrieve data from the database " + e.getMessage());
		 }
		 return null;
	 }
	 
	 /**
	  * returns a specific seat from the database given the ID of its seatMap and the seat's number
	  * 
	  * @param seatMapID ID of the seat map the eat belongs to
	  * @param seatNumber Number of the seat to be returned
	  * @return seat to be returned
	  */
	 public static Seat getSeat(String seatMapID, String seatNumber) {
		 try {
			 
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();
			 
			  ResultSet results = statement.executeQuery("SELECT * FROM Seat WHERE seatMapID = "+seatMapID+" AND seatNumber = "+seatNumber);
			 
			  return new Seat(results.getInt(1), results.getInt(2), results.getBoolean(3));
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		return null;
	 }
	 
	 /**
	  * Retrieves a seatMap given a movie title, theatre name and show time
	  * @param m movie title
	  * @param t theatre name
	  * @param st show time
	  * @return returns found seatmap
	  */
	 public static SeatMap getSeatMap(String m, String t, String st) {
		 try {
			  // Get a result set containing all data from test_table
			 
			  Statement statement = connection.createStatement();

			  ResultSet results = statement.executeQuery("SELECT * FROM showing WHERE showing.movieTitle = '" + m + "' AND showing.theatreName = '" + t + "' AND showing.showtime = '" + st + "'");

			  results.next();
			  int seatMapID = results.getInt(4);

			  results = statement.executeQuery("SELECT * FROM seat WHERE seatMapID = " + seatMapID);
			  ArrayList<Seat> seats = new ArrayList<>();
			  while (results.next()) {
				 seats.add(new Seat(results.getInt(2), results.getInt(1), results.getBoolean(3)));
			  }

			  results = statement.executeQuery("SELECT * FROM seatmap WHERE seatMapID = " + seatMapID);
			  results.next();

			  return new SeatMap(results.getInt(1),results.getInt(2),results.getInt(3),results.getInt(4), seats);

	
			    } catch (SQLException e) {
			 
			  System.out.println("Could not retrieve data from the database " + e.getMessage());
			    }
		 return null;
	 }
	 
	 /**
	  * Adds a movie to the database.
	  * 
	  * @param theMovie movie to be added
	  */
	 public static void insertMovie(Movie theMovie) {
		 try {
			 
				 	Statement statement = connection.createStatement();	 
				  	statement.executeUpdate("INSERT INTO Movie " + "VALUES ('"+theMovie.getMovieTitle()+"', '"+theMovie.getDateReleased()+"', "
				 	+theMovie.getMovieLength()+", '"+theMovie.getGenre()+"')");
				  	return;	
				  	
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    
			    }
	 }
	 
	 /**
	  * Adds a theatre to the database.
	  * 
	  * @param theTheatre theatre to be added
	  */
	 public static void insertTheatre(Theatre theTheatre) {
		 try {
			 
				  Statement statement = connection.createStatement();
				  statement.executeUpdate("INSERT INTO Theatre " + "VALUES ('"+theTheatre.getTheatreName()+"')");
				  return;
				  
			  } catch (SQLException e) {
			 
				  System.out.println("Could not retrieve data from the database " + e.getMessage());
			  
			  }
	 }
	 
	 /**
	  * Adds a showing to the database.
	  * 
	  * @param theShowing showing to be added
	  */
	 public static void insertShowing(Showing theShowing) {
		 try {
			 
			 	Statement statement = connection.createStatement();
			 	statement.executeUpdate("INSERT INTO Showing " + "VALUES ("+theShowing.getShowingID()+", '"+theShowing.getMovie().getMovieTitle()+"', '"
			 	+theShowing.getTheatre().getTheatreName()+"', "+theShowing.getSeatMap().getSeatMapID()+", "+theShowing.getShowtime()+")");
			 	return;
			  
		 	} catch (SQLException e) {
			 
		 		System.out.println("Could not retrieve data from the database " + e.getMessage());
		 	
		 	}
	 }
	 
	 /**
	  * Adds a seat to the database.
	  * 
	  * @param theSeat seat to be added.
	  */
	 public static void insertSeat(Seat theSeat) {
		 try {
			 
				 	Statement statement = connection.createStatement();	 
				  	statement.executeUpdate("INSERT INTO Seat " + "VALUES ('"+theSeat.getSeatMapID()+"', '"+theSeat.getSeatNumber()+"', "
				 	+theSeat.isVacant()+")");
				  	return;	
				  	
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    
			    }
	 }
	 
	 /**
	  * adds a seatMap to the database.
	  * 
	  * @param theMap map to be inserted.
	  */
	 public static void insertSeatMap(SeatMap theMap) {
		 try {
			 
				 	Statement statement = connection.createStatement();	 
				  	statement.executeUpdate("INSERT INTO SeatMap " + "VALUES ('"+theMap.getSeatMapID()+"', '"+theMap.getReservedSeatCount()+"', '"
				 	+theMap.getNumberOfRows()+"', '"+theMap.getNumberOfAvailableSeats()+"')");
				  	return;	
				  	
			    } catch (SQLException e) {
			 
			    	System.out.println("Could not retrieve data from the database " + e.getMessage());
			    
			    }
	 }
	 
	 /**
	  * Updates a theatre within the database
	  * 
	  * @param theTheatre theatre whose information will be updated
	  */
	public static void updateTheatre(Theatre theTheatre) {
		try {

			PreparedStatement st = connection.prepareStatement("UPDATE Theatre SET TheatreName = ?, WHERE theatreName = ?");
			st.setString(1,theTheatre.getTheatreName());
			st.setString(2, theTheatre.getTheatreName());
			st.executeUpdate();
			return;

		} catch (SQLException e) {

			System.out.println("Could not retrieve data from the database " + e.getMessage());

		}
	}
	
	/**
	 * Updates a showing within the database.
	 * 
	 * @param theShowing Showing to be updated
	 */
	public static void updateShowing(Showing theShowing) {
		try {

			PreparedStatement st = connection.prepareStatement("UPDATE Showing SET movieTitle = ?, theatreName = ?, seatMapID = ?, showTime = ?, WHERE showingID = ?");
			st.setString(1, theShowing.getMovie().getMovieTitle());
			st.setString(2, theShowing.getTheatre().getTheatreName());
			st.setInt(3, theShowing.getSeatMap().getSeatMapID());
			st.setString(4, theShowing.getShowtime());
			st.setInt(5, theShowing.getShowingID());
			st.executeUpdate();
			return;

		} catch (SQLException e) {

			System.out.println("Could not retrieve data from the database " + e.getMessage());

		}
	}
	
	/**
	 * Updates a seat within the database.
	 * 
	 * @param theMap map of the seat to be updated
	 * @param theSeat seat to be updated
	 */
	public static void updateSeat(SeatMap theMap, Seat theSeat) {
		try {

			PreparedStatement st = connection.prepareStatement("UPDATE seat SET seat.vacant = ? WHERE seat.seatMapID = ? AND seat.seatNumber = ?");
			st.setInt(3, theSeat.getSeatNumber());
			st.setBoolean(1, theSeat.isVacant());
			st.setInt(2, theMap.getSeatMapID());
			st.executeUpdate();
			return;

		} catch (SQLException e) {

			System.out.println("Could not retrieve data from the database " + e.getMessage());

		}
	}
	
	/**
	 * Updates a seatMap within the database.
	 * 
	 * @param theMap seatMap to be updated.
	 */
	public static void updateSeatMap(SeatMap theMap) {
		try {
			PreparedStatement st = connection.prepareStatement("UPDATE SeatMap SET reservedSeatCount = ?, NumberOfRows = ?, numberOfAvailableSeats = ?, WHERE seatMapID = ?");
			st.setInt(1, theMap.getReservedSeatCount());
			st.setInt(2, theMap.getNumberOfRows());
			st.setInt(3, theMap.getNumberOfAvailableSeats());
			st.setInt(4, theMap.getSeatMapID());
			st.executeUpdate();
			return;

		} catch (SQLException e) {

			System.out.println("Could not retrieve data from the database " + e.getMessage());

		}
	}
	
	/**
	 * Updates the vacancy of a seat in the database.
	 * 
	 * @param seatNumber number of the seat to be updated
	 * @param seatMapID ID of the seatMap containing the seat
	 * @param vacant vacancy of the seat to be updated.
	 */
	 public void updateSeatStatus(int seatNumber, int seatMapID, boolean vacant) {
	     try {
	     	System.out.println("number = " + seatNumber + " map id = " + seatMapID);
			 Statement statement = connection.createStatement();
			 statement.executeUpdate("UPDATE seat " + " SET vacant = " + vacant + "WHERE seat.seatMapID = '" + seatMapID + "' AND seat.seatNumber = '" + seatNumber + "'");
		 } catch (SQLException e) {
	     	System.out.println("Could not update seat status " + e.getMessage());
		 }
	 }
	 
	 /**
	  * Returns a list of showings from the database given the movie and theatre.
	  * 
	  * @param m title of the movie
	  * @param t name of the theatre
	  * @return array list of showings matching the parameters
	  */
	 public ArrayList<Showing> getShowingList(String m, String t) {
		 try {
			 ArrayList<Integer> id = new ArrayList<>();
			 ArrayList<Integer> seatMapID = new ArrayList<>();
			 ArrayList<String> showtime = new ArrayList<>();
			 Movie movie;
			 Theatre theatre = new Theatre(t);

			 Statement statement = connection.createStatement();
			 ResultSet results = statement.executeQuery("SELECT * FROM movie WHERE movie.movieTitle = '" + m + "'");

			 results.next();
			 movie = new Movie(results.getString(1), results.getString(2), results.getInt(3), results.getString(4));

			 results = statement.executeQuery("SELECT * FROM showing WHERE showing.movieTitle = '" + m + "'" + " AND showing.theatreName = '" + t + "'");

			 ArrayList<Showing> showings = new ArrayList<>();
			 while(results.next()) {
				 id.add(results.getInt(1));
				 seatMapID.add(results.getInt(4));
				 showtime.add(results.getString("showtime"));
			 }

			 for(int i = 0; i < id.size(); i++) {
				 results = statement.executeQuery("SELECT * FROM seat WHERE seatMapID = " + seatMapID.get(i));

				 ArrayList<Seat> seats = new ArrayList<>();
				 while (results.next()) {
					 seats.add(new Seat(results.getInt(1), results.getInt(2), results.getBoolean(3)));
				 }
				 ResultSet r = statement.executeQuery("SELECT * FROM seatmap WHERE seatMapID = " + seatMapID.get(i));
				 r.next();
				 SeatMap s = new SeatMap(r.getInt(1), r.getInt(2), r.getInt(3), r.getInt(4), seats);

				 showings.add(new Showing(id.get(i), movie, theatre, s, showtime.get(i)));
			 }


			 return showings;
		 } catch (SQLException e) {

			 System.out.println("Could not retrieve data from the database " + e.getMessage());
		 }
		 return null;
	 }
	 
	 /**
	  * Registers a new user within the database if the user does not already exist.
	  * 
	  * @param u User to be added
	  * @return Returns ID of the new user or -1 if failed
	  */
	 public int registerUser(RegisteredUser u) {
		 try {
		 	 int id = 0;

			 Statement statement = connection.createStatement();
			 ResultSet results = statement.executeQuery("SELECT MAX(accountID) FROM user");

			 if(results.next()) {
			 	id = results.getInt(1) + 1;
			 }

			 statement.executeUpdate("INSERT INTO user " + "VALUES ('" + id + "', '" + u.getUserAccount().getEmailAddress() +"', '"+ u.getUserAccount().getFirstName() +"', '"
					 + u.getUserAccount().getLastName() +"', '"+ u.getUserAccount().getPassword() +"', '"+ u.getUserAccount().getCard().getCardNumber() +"', '"+ u.getUserAccount().getCard().getExpiryDate() +"', '"+ u.getUserAccount().getCard().getCsv() +"')");
			 return id;

		 } catch (SQLException e) {

			 System.out.println("Could not register user " + e.getMessage());

		 }
		 return -1;
	 }
	 
	 /**
	  * checks if an eamil already exists in the databse
	  * 
	  * @param email email address to be checked
	  * @return returns true if the email is available
	  */
	 public boolean checkEmailAvailability(String email) {
		 try {

			 Statement statement = connection.createStatement();
			 ResultSet results = statement.executeQuery("SELECT email FROM user WHERE user.email = '" + email + "'");

			 if (results.next()) {
				 return false;
			 }

			 return true;
		 } catch (SQLException e) {

			 System.out.println("Could not retrieve data from the database " + e.getMessage());
		 }
		 return false;
	 }

	 /**
	  *  Checks if a given email and password combination are correct in order to log a user in
	  * @param email email address of user
	  * @param password password of user
	  * @return returns true if login successful
	  */
	 public boolean validateLogin(String email, String password) {
		 try {

			 Statement statement = connection.createStatement();
			 ResultSet results = statement.executeQuery("SELECT email FROM user WHERE user.email = '" + email + "' AND user.password = '" + password + "'");

			 if (results.next()) {
				 return true;
			 }

			 return false;
		 } catch (SQLException e) {

			 System.out.println("Could not retrieve data from the database " + e.getMessage());
		 }
		 return false;
	 }
	 
	 /**
	  * Finds a user given their email and password
	  * 
	  * @param email
	  * @param password
	  * @return
	  */
	 public RegisteredUser getUser(String email, String password) {
		 try {

			 Statement statement = connection.createStatement();
			 ResultSet results = statement.executeQuery("SELECT * FROM user WHERE user.email = '" + email + "' AND user.password = '" + password + "'");

			 results.next();
			 RegisteredUser ru = new RegisteredUser(results.getInt(1), results.getString(6), results.getString(7), results.getInt(8), results.getString(2), results.getString(3), results.getString(4), results.getString(5));

			 return ru;
		 } catch (SQLException e) {

			 System.out.println("Could not retrieve data from the database " + e.getMessage());
		 }
		 return null;
	 }
	 
	 /**
	  * Finds a user in the database given their email
	  * @param email email of the user
	  * @return returns a user from the database
	  */
	 public RegisteredUser getUser(String email) {
		 try {

			 Statement statement = connection.createStatement();
			 ResultSet results = statement.executeQuery("SELECT * FROM user WHERE user.email = '" + email + "'");

			 results.next();
			 RegisteredUser ru = new RegisteredUser(results.getInt(1), results.getString(6), results.getString(7), results.getInt(8), results.getString(2), results.getString(3), results.getString(4), results.getString(5));

			 return ru;
		 } catch (SQLException e) {

			 System.out.println("Could not retrieve data from the database " + e.getMessage());
		 }
		 return null;
	 }
	 
	 /**
	  * Creates an order within the databse
	  * 
	  * @param tickets tickets in the order
	  * @param email email of the order
	  */
	 public void createOrder(ArrayList<Ticket> tickets, String email) {
		 try {
			 int ticketID = 0;
			 int orderID = 0;
			 int showingID = 0;

			 Statement statement = connection.createStatement();

			 ResultSet results = statement.executeQuery("SELECT MAX(orderID) FROM list_orders");

			 if(results.next()) {
				 orderID = results.getInt(1) + 1;
			 }

			 results = statement.executeQuery("SELECT MAX(ticketID) FROM ticket");

			 if(results.next()) {
				 ticketID = results.getInt(1) + 1;
			 }

			 for(int i = 0; i < tickets.size(); i++) {
				 results = statement.executeQuery("SELECT showingID FROM showing WHERE showing.movieTitle = '" + tickets.get(i).getMovie().getMovieTitle() + "'" + " AND showing.theatreName = '" + tickets.get(i).getTheatre().getTheatreName() + "'" + " AND showing.showtime = '" + tickets.get(i).getShowtime() + "'");

				 if(results.next()) {
					 showingID = results.getInt(1);
				 }
				 statement.executeUpdate("INSERT INTO ticket " + "VALUES ('" + ticketID + "', '" + showingID +"', '"+ tickets.get(i).getSeat().getSeatNumber() +"', '"
						 + tickets.get(i).getCost() +"')");
				 statement.executeUpdate("INSERT INTO order_ticket_list " + "VALUES ('" + orderID + "', '" + ticketID +"')");
			 }
			 statement.executeUpdate("INSERT INTO list_orders " + "VALUES ('" + orderID + "', '" + email +"')");

		 } catch (SQLException e) {

			 System.out.println("Could not create order " + e.getMessage());

		 }
	 }
	 
	 /**
	  * Returns all emails from the database
	  * 
	  * @return list of all emails in the database
	  */
	 public ArrayList<String> getEmails() {
		 try {

			 Statement statement = connection.createStatement();
			 ResultSet results = statement.executeQuery("SELECT user.email FROM user");

			 ArrayList<String> emailList = new ArrayList<>();

			 while (results.next()) {
			 	emailList.add(results.getString("email"));
			 }

			 return emailList;
		 } catch (SQLException e) {

			 System.out.println("Could not retrieve data from the database " + e.getMessage());
		 }
		 return null;
	 }
	 
	 /**
	  * Finds the ID of a ticket in the database givin the ticket and its showing
	  * 
	  * @param s Showing of the ticket
	  * @param t Ticket to be examined
	  * @return returns id of the ticket
	  */
	 public int getTicketID(Showing s, Ticket t) {
		 try {

		 	 int ticketID = 0;
			 int showingID = 0;

			 Statement statement = connection.createStatement();
			 ResultSet results = statement.executeQuery("SELECT showing.showingID FROM showing WHERE showing.movieTitle = '" + s.getMovie().getMovieTitle() + "' AND showing.theatreName = '" + s.getTheatre().getTheatreName() + "' AND showing.seatMapID = '" + s.getSeatMap().getSeatMapID() + "' AND showing.showtime = '" + s.getShowtime() + "'");

			 results.next();
			 showingID = results.getInt("showingID");

			 results = statement.executeQuery("SELECT ticket.ticketID FROM ticket WHERE ticket.showingID = '" + showingID + "' AND ticket.seatNumber = '" + t.getSeat().getSeatNumber() + "'");

			 results.next();
			 ticketID = results.getInt("ticketID");

			 return ticketID;
		 } catch (SQLException e) {

			 System.out.println("Could not retrieve data from the database " + e.getMessage());
		 }
		 return -1;
	 }
	 
	 /**
	  * Removes a ticket from the database
	  * 
	  * @param ticketID ID of the ticket to be removed
	  * @return returns ID of the order
	  */
	 public int cancelTicket(int ticketID) {
		 try {

		 	 String query = "DELETE FROM ticket WHERE ticketID = '" + ticketID + "'";
			 PreparedStatement statement = connection.prepareStatement(query);

			 statement.execute();

			 ResultSet results = statement.executeQuery("SELECT order_ticket_list.orderID FROM order_ticket_list WHERE order_ticket_list.ticketID = '" + ticketID + "'");
			 results.next();
			 int orderID = results.getInt("orderID");

			 query = "DELETE FROM order_ticket_list WHERE ticketID = '" + ticketID + "'";
			 statement = connection.prepareStatement(query);

			 statement.execute();

			 return orderID;
		 } catch (SQLException e) {

			 System.out.println("Could not delete ticket " + e.getMessage());
		 }
		 return -1;
	 }
	 
	 /**
	  * finds all of the tickets within an order
	  * 
	  * @param email email of the order
	  * @return returns a list of tickets from the order
	  */
	 public ArrayList<Ticket> getOrder(String email) {
	     ArrayList<Ticket> t = new ArrayList<>();
		 try {

		 	 ArrayList<Integer> orderID = new ArrayList<>();
			 Statement statement = connection.createStatement();
			 ResultSet results = statement.executeQuery("SELECT list_orders.orderID FROM list_orders WHERE list_orders.email = '" + email + "'");

			 while(results.next()) {
			 	orderID.add(results.getInt("orderID"));
			 }

			 ArrayList<Integer> ticketID = new ArrayList<>();
			 for(int i = 0; i < orderID.size(); i++) {
				 results = statement.executeQuery("SELECT order_ticket_list.ticketID FROM order_ticket_list WHERE order_ticket_list.orderID = '" + orderID.get(i) + "'");

				 while(results.next()) {
				 	ticketID.add(results.getInt("ticketID"));
				 }
			 }

			 ArrayList<Integer> showingID = new ArrayList<>();
			 ArrayList<Integer> seatNumber = new ArrayList<>();
			 ArrayList<Integer> cost = new ArrayList<>();

			 for(int i = 0; i < ticketID.size(); i++) {
				 results = statement.executeQuery("SELECT * FROM ticket WHERE ticket.ticketID = '" + ticketID.get(i) + "'");

				 while(results.next()) {
				 	 showingID.add(results.getInt("showingID"));
				 	 seatNumber.add(results.getInt("seatNumber"));
				 	 cost.add(results.getInt("cost"));
				 }
			 }

			 for(int i = 0; i < ticketID.size(); i++) {
				 Showing s = getShowing(showingID.get(i));
				 t.add(new Ticket(s.getMovie(), s.getTheatre(), new Seat(s.getSeatMap().getSeatMapID(), seatNumber.get(i), false), cost.get(i), ticketID.get(i), s.getShowtime()));
			 }

			 return t;
		 } catch (SQLException e) {

			 System.out.println("Could not retrieve data from the database " + e.getMessage());
		 }
		 return null;
	 }
	 
	 /**
	  * Checks to see if an email has associated orders
	  * 
	  * @param email email to be checked
	  * @return returns true if the email exists in orders
	  */
	public boolean emailExistsInOrders(String email) {
		try {
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SELECT list_orders.email FROM list_orders WHERE list_orders.email = '" + email + "'");

			if(results.next()) {
				return true;
			}

			return false;
		} catch (SQLException e) {

			System.out.println("Could not retrieve data from the database " + e.getMessage());
		}
		return false;
	}
	
	/**
	 * checks the status of an order given its ID
	 * 
	 * @param orderID ID of the order
	 */
	public void checkOrderStatus(int orderID) {
		try {

			Statement s = connection.createStatement();

			ResultSet results = s.executeQuery("SELECT order_ticket_list.orderID FROM order_ticket_list WHERE order_ticket_list.orderID = '" + orderID + "'");

			if (results.next()) {
				return;
			}
			else {
				s.close();

				String query = "DELETE FROM list_orders WHERE orderID = '" + orderID + "'";
				PreparedStatement statement = connection.prepareStatement(query);

				statement.execute();
			}


		} catch (SQLException e) {

			System.out.println(e.getMessage());
		}
	}

}