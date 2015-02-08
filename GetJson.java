package postG.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class GetJson  implements Database {
	private Connection conn = null;
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement pst =null ; 
	 private int id ;
	
	 public  String  GetJsonByID(int id ){
		 String result = "";
		 
		  openConnection();
		  try {
			pst= conn.prepareStatement("select *  from \"JSON\" where \"JSONID\"="+id+";");
			rs = pst.executeQuery(); 
			if(rs.next()){
				String  jsn  = rs.getString(2);
				result  += jsn ; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return result ;
	 }
	 public  void openConnection(){	
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url + dbName, userName, "02030203");
				Statement st=conn.createStatement();
			} catch (SQLException  | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}
	public  void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
