package Model;

public class yetkiVer implements YetkiInterface{

	User user;
	
	public yetkiVer(User user){
		this.user=user;
	}
	
	@Override
	public void execute() {
		this.user.yetkiVer();
	}

}
