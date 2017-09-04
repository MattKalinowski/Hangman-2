package Hangman.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Database {
    
    List<String> namesList = new LinkedList<>();
    List<Integer> pointsList = new LinkedList<>();
    
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:scores.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS leaderboard (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	points real\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private Connection connect() {
        createNewTable();
        // SQLite connection string
        String url = "jdbc:sqlite:scores.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void insert(String name, int points) {
        String sql = "INSERT INTO leaderboard(name,points) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, points);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void update(String name, int points) {
        String sql = "UPDATE leaderboard SET points = ? "
                + "WHERE name = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, points);
            pstmt.setString(2, name);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectAll(){
        String sql = "SELECT name, points FROM leaderboard ORDER BY points DESC";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                namesList.add(rs.getString("name"));
                pointsList.add(rs.getInt("points"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<String> getNamesList() {
        return namesList;
    }
    public List<Integer> getPointsList() {
        return pointsList;
    }

    public void fillTheListWithSampleData() {
        int amountOfSampleData = 20 - namesList.size();
        while (namesList.size() < amountOfSampleData) {
            namesList.add("");
            pointsList.add(0);
        }
    }
    public void clearLeaderboard() {
        namesList.clear();
        pointsList.clear();
    }
}