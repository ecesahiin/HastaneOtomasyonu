package Helper;
import java.sql.*;


public class DBConnection {
	Connection c = null;
	
	
	public DBConnection() {}
	
	public Connection connDb (){
		
		try {
			if(this.c==null||this.c.isClosed()) {
				this.c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/hospital?user=root&password=");
				return c;
			}else {
				return c;
			}	
		}catch(SQLException e) {
			e.getStackTrace();
		}
		return c;
	}
}
