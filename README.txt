ENSF 480
Group 21

Movie Theatre Ticket Reservation App
Setup Instructions
Follow these steps to set up and run the application:

Database Configuration

Open MySQL Workbench on your system.
Import the traDB.sql file located in the Database package within the src directory. This will set up the necessary database schema and initial data.
Database Password

The application uses Password as the database password by default.
If you prefer not to change your MySQL password to Password, update the password in the DatabaseManager.java file.
Locate the initialize function in DatabaseManager.java and replace the password with your own MySQL password.
Adding Dependencies

Download and include the MySQL Connector JAR file in your project.
Add this JAR file to your project's dependency list and place it in the appropriate library folder.
Run the Application

Once the above steps are complete, you can compile and run the application successfully.
