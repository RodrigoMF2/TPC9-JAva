package sample;
import java.sql.Connection;
import java.sql.DriverManeger;
public class DatabaseConection {
    public Connection databaselink;

    public Connection getConnection() {
        String databaseName = "pocBase";
        String databaseUser = "";
        String databasePassorrd = "";
        String url ="jdbc :mysql://localhost/" + databaseName;

        try{
            class.forName("com.mysql.cj.jbdc.driver");
            databaselink = DriverManager.getConnection(url, databaseUser, databasePassorrd);

        }catch (Exception e){
           e.printStackTrace();
        }

        return databaselink;
    }
}
