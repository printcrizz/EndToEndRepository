package utils;
import com.mysql.jdbc.Driver;
import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;
import java.sql.PreparedStatement;
import  java.sql.SQLException;
import java.util.Date;

public class SqlConnector {

    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void ExecuteQueryDB(String value, String table, String conditions)throws Exception {

            try {
                resultSet = CreateConnection()
                        .executeQuery("SELECT"+value+"\n" +
                                "  FROM "+table+"\n" +
                                "  Where "+conditions+"\n" +
                                "  and PAPEL = 'GCF';"); //Modificar por distintas querys
                writeMetaData(resultSet);
                writeResultSet(resultSet);

            } catch (Exception e) {
                throw e;
            } finally {
                close();
            }
        }

        private Statement CreateConnection()throws Exception{
            try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();;
            String dbUrl = System.getProperty("DbUrl");
            String username = System.getProperty("DbUser");
            String password = System.getProperty("DbPassword");

            connect = DriverManager.getConnection(dbUrl,username,password);

            statement = connect.createStatement();

            return statement;
            } catch (Exception e) {
                throw e;
            }
        }
    // You need to close the resultSet
    private void close() throws Exception{
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    private void writeMetaData(ResultSet resultSet) throws SQLException {
        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {

            String user = resultSet.getString("PAPEL");
            String website = resultSet.getString("ULTIMO");
            String summary = resultSet.getString("HORA");
            //Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("VARIACAO");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
            //System.out.println("Date: " + date);
            System.out.println("Comment: " + comment);
        }
    }
}
