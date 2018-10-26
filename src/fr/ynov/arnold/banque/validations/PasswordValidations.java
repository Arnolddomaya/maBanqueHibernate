package fr.ynov.arnold.banque.validations;

import java.util.regex.Pattern;

public class PasswordValidations {
	
	public static boolean check(String ppass, String confirm) {
		return valideInput(ppass) && goodConfirmation(ppass, confirm);
	}
	
	public static boolean valideInput(String ppass) {
		return numberExists(ppass) && majExists(ppass) && accentExists(ppass) && goodLength(ppass);
	}
	
	public static boolean goodConfirmation(String ppass, String confirm) {
		return ppass.equals(confirm);
	}
	
	public static boolean goodLength(String ppass) {
		return ppass.length() >= 8;
	}
	
	public static boolean numberExists(String ppass) {
		return Pattern.matches(".*[0-9].*", ppass);
	}
	public static boolean majExists(String ppass) {
		return Pattern.matches(".*[A-Z].*", ppass);
	}
	
//	public static boolean specialCharExists(String ppass) {
//		return Pattern.matches(".*[///§/&//"//'].*", ppass);
//	}
	public static boolean accentExists(String ppass) {
		return Pattern.matches(".*[йизащофкв].*", ppass);
	}
	public static boolean passMatchConfirm(String ppass, String pconfirm) {
		return false;
	}
}
