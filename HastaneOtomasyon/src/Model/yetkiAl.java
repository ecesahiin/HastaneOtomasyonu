package Model;

public class yetkiAl implements YetkiInterface{

	User user;
	public yetkiAl(User user){
		this.user=user;
	}
	
	
	@Override
	public void execute() {
		this.user.yetkiAl();
		
		
	}

}
