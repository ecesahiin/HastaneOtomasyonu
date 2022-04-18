package Helper;

import javax.swing.JOptionPane;

public class Helper {
	
	public static void showMsg(String str) {
		String msg;
		
		switch (str) {
		case "fill":
			msg= "Lütfen tüm alanlarý doldurunuz.";
			break;
		case "success"	:
			msg="Ýþlem baþarýlý !";
			break;
		default:
			msg=str;
		}
		JOptionPane.showMessageDialog(null, msg,"Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}

	public static boolean confirm(String string) {
		// TODO Auto-generated method stub
		return false;
	}

}
