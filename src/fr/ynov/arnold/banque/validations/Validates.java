package fr.ynov.arnold.banque.validations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Validates {

	@Test
	void goodLength()
	{
		assertEquals(PasswordValidations.goodLength(""), false);
		assertEquals(PasswordValidations.goodLength("AAA"), false);
		assertEquals(PasswordValidations.goodLength("AAAAAAAA"), true);
	}
	
	@Test
	void hasAnumlber() {
		assertEquals(PasswordValidations.numberExists(""), false);
		assertEquals(PasswordValidations.numberExists("abcd"), false);
		assertEquals(PasswordValidations.numberExists("abcd4"), true);
		assertEquals(PasswordValidations.numberExists("abcd9"), true);
		assertEquals(PasswordValidations.numberExists("0"), true);
	}
	
	@Test
	void hasAmaj() {
		assertEquals(PasswordValidations.majExists(""), false);
		assertEquals(PasswordValidations.majExists("123"), false);
		assertEquals(PasswordValidations.majExists("abc"), false);
		assertEquals(PasswordValidations.majExists("Abc"), true);
		assertEquals(PasswordValidations.majExists("aCb"), true);
	}
//	@Test
//	void hasSpecialChar() {
//		assertEquals(PasswordValidations.specialCharExists(""), false);
//		assertEquals(PasswordValidations.specialCharExists("abc"), false);
//		assertEquals(PasswordValidations.specialCharExists("abc&"), true);
//		assertEquals(PasswordValidations.specialCharExists("&"), true);
//		assertEquals(PasswordValidations.specialCharExists("&&"), true);
//	}
	@Test
	void hasAccent() {
		assertEquals(PasswordValidations.accentExists(""), false);
		assertEquals(PasswordValidations.accentExists("abc"), false);
		assertEquals(PasswordValidations.accentExists("aיי"), true);
		assertEquals(PasswordValidations.accentExists("ייי"), true);
	}
	@Test
	void valideByReggex() {
		assertEquals(PasswordValidations.valideInput("1234"), false);
		assertEquals(PasswordValidations.valideInput("12345678"), false);
		assertEquals(PasswordValidations.valideInput("A2345678"), false);
		assertEquals(PasswordValidations.valideInput("A@345678"), false);
		assertEquals(PasswordValidations.valideInput("A@י45678"), true);
	}

}
