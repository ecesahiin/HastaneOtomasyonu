package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Bashekim extends User implements BashekimInterface{
	public static Bashekim instance;
	public DBOPS dbops;

	private Bashekim(int id, String tcno, String name, String password, String type) {
		super(id, tcno, name, password, type);
	}
	
	public Bashekim() {}
	public Bashekim(DBOPS dbops) {
		this.dbops=dbops;
	}
	
	public static Bashekim getInstance(int id, String tcno, String name, String password, String type) {
		if(instance == null) {
			instance=new Bashekim(id,  tcno,  name,  password,  type);
		}
		return instance;
	}
	
	@Override
	public boolean Insert() {
		return this.dbops.Insert(this);
	}

}