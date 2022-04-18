package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Helper.DBConnection;

public class DB extends DBConnection implements DBOPS {

	@Override
	public boolean Insert(Bashekim bashekim) {
		PreparedStatement pst;
		String query = "INSERT INTO user" + "(tcno,password,name,type) VALUES" + "(?,?,?,?)";
		boolean key = false;
		try {
			pst = this.connDb().prepareStatement(query);
			pst.setString(1, bashekim.getTcno());
			pst.setString(2, bashekim.getPassword());
			pst.setString(3, bashekim.getName());
			pst.setString(4, "doktor");
			pst.executeUpdate();
			key = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (key)
			return true;
		else
			return false;
	}

}
