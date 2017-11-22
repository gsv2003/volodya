import java.sql.*;

public class JavaToMySQL {

    private static final String url = "jdbc:mysql://localhost:3306/volodya";
    private static final String user = "root";
    private static final String password = "12345";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    private static PreparedStatement ps;

    public static void main(String args[]) {
        String query = "INSERT INTO Movies (born, country, genre, name, duration, rating)" +
                "VALUES (?, ?, ?, ?, ?, ?)";
        String query2 = "select name, duration, rating from movies";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // getting Statement object to execute query
            stmt = con.createStatement();
            // executing INSERT query
            ps = con.prepareStatement(query);
            ps.setString(1, "2017");
            ps.setString(2,"US");
            ps.setString(3, "мульт");
            ps.setString(4,"Тайна Коко");
            ps.setInt(5,109);
            ps.setDouble(6, 9.6);
            int n = ps.executeUpdate();
            // executing SELECT query
            rs = stmt.executeQuery(query2);

            while (rs.next()) {

                String nameMovie = rs.getString(1);
                int duration = rs.getInt(2);
                Float rating = rs.getFloat(3);

                System.out.printf("Название фильма: %20s, Длительность: %d, Рейтинг: %.2f %n", nameMovie, duration, rating);

            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
            try { ps.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }
}