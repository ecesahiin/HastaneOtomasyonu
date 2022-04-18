package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Helper.DBConnection;
import Model.Bashekim;
import Model.Clinic;
import Model.User;
import Model.releationship;

public class SQLOperations extends DBConnection{
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement preparedStatement = null;

	public ArrayList<User>getDoctorList() throws SQLException{
		ArrayList<User>list = new ArrayList<>();
		
	
		
		User obj;
		try {
			st= this.connDb().createStatement();
		
		rs=st.executeQuery("SELECT * FROM user WHERE type = 'doktor' ");
		while(rs.next()) {
			obj= new User(rs.getInt("id"),rs.getString("tcno"),rs.getString("name"),rs.getString("password"),rs.getString("type"));
			list.add(obj);
		}
		
	} catch (SQLException e) {
		
	
	
	}
	return list;
 

  }
	
	public User findUser(int id) {
		User user = null;
		try {
			PreparedStatement pst=this.connDb().prepareStatement("select * from user where id=?");
			ResultSet rsx=pst.executeQuery();
			while(rsx.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setTcno(rs.getString("tcno"));
				user.setType(rs.getString("type"));
				
			}
			return user;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return user;
	}
	
	

	public Clinic getClinicList(int x) throws SQLException{
		ArrayList<Clinic>list = new ArrayList<>();
		try {
		st= this.connDb().createStatement();
		rs=st.executeQuery("SELECT * FROM clinic");
		
		while(rs.next()) {
			Clinic c= new Clinic(rs.getInt("id"),rs.getString("name"));
			list.add(c);
		}
		
	} catch (SQLException e) {
		
	
	
	}
	return list.get(x);
 

  }
	public ArrayList<releationship> GetClinics() throws SQLException{
		ArrayList<releationship>list = new ArrayList<>();
		try {
		st= this.connDb().createStatement();
		rs=st.executeQuery("SELECT * FROM releationship");
		ResultSet rs2;
		while(rs.next()) {
			
			releationship c= new releationship();
			c.setClinic_id(rs.getInt("clinic_id"));
			c.setDoctor_id(rs.getInt("user_id"));
			list.add(c);
		}
		int i=0;
		for(i=0;i<list.size();i++) {
			rs2=st.executeQuery("select * from clinic where id = "+list.get(i).getClinic_id());
			while(rs2.next()) {
				list.get(i).setClinic_name(rs2.getString("name"));
			}
		}
		for(i=0;i<list.size();i++) {
			rs2=st.executeQuery("select * from user where id = "+list.get(i).getDoctor_id());
			while(rs2.next()) {
				list.get(i).setDoctor_name(rs2.getString("name"));
			}
		}
		
	} catch (SQLException e) {
		
	
	
	}
	return list;
 

  }
	
	public void Yetki(int yetki,int id) {
		
		try {
			PreparedStatement pst=this.connDb().prepareStatement("update user set yetki=? where id=?");
			pst.setInt(1, yetki);
			pst.setInt(2, id);
			pst.executeUpdate();
		} catch (SQLException e) {
		}
		
	}
	
	
	public void Delete(int id) {
		try {
			PreparedStatement pst = this.connDb().prepareStatement("DELETE FROM user WHERE id=?");
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public void asd(int a,int b) {
		try {
			PreparedStatement pst = this.connDb().prepareStatement("insert into releationship (user_id,clinic_id) values (?,?)");
			pst.setInt(1, a);
			pst.setInt(2, b);
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		
		
		
	}
	
	public boolean addWorker(int user_id , int clinic_id) throws SQLException {
	    String query = "INSERT INTO worker" + "(user_id,clinic_id) VALUES" + "(?,?)" ;
	    boolean key =false;
	    int count=0;
	    try {
	        st = this.connDb().createStatement();
	        rs = st.executeQuery("SELECT * FROM worker WHERE clinic_id="+clinic_id+ "AND user_id" + user_id );
	        while(rs.next()) {
	        	count++;
	        }
	        if(count==0) {
	        	 preparedStatement = this.connDb().prepareStatement(query);
	             preparedStatement.setInt(1, user_id);
	             preparedStatement.setInt(2, clinic_id);
	             preparedStatement.executeUpdate();
	        	
	        }
	       
	        key =true;
	    }catch (Exception e) {
	    }
	    if(key)
	    	return true;
	    else
	    	return false;
	    
	    
	 }
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
