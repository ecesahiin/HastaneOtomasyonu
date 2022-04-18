package Model;

public class Invoker {
	
	    private YetkiInterface yetki_interface;

	    public void setCommand(YetkiInterface yetki_interface){
	        this.yetki_interface=yetki_interface;
	    }

	    public void Execute(){
	    	yetki_interface.execute();
	    }
}

