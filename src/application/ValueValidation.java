package application;
/**
 * ValueValidation class centralizes several error message constants and methods for the validation of input values
 * @author steph
 *
 */
public class ValueValidation {
	
	final static String checkStringErrorMsg = "Enter a string at least one character in length";
	final static String checkNaturalNumErrorMsg = "Enter an integer greater than or equal to 1";
	final static String checkValidMoneyErrorMsg = "Enter a value greater than or equal to 0";
	final static String checkWholeNumErrorMsg = "Enter an integer greater than or equal to 1";
	final static String checkTagRepeatsErrorMsg = "Tag already used for another item. Enter a unique tag";
	final static String checkItemRepeatsErrorMsg = "Name already used for another item. Enter a unique name";
	
	/**
	 * checkString verifies that the input string is not null and has a character length of at least one
	 * @param string is the String being verified
	 * @return true the input string is not null and of length at least one, false if not
	 */
	public static boolean checkString(String string) {
		if (string != null && string != "")
			return true;
		else
			return false;
	}

	/**
	 * checkNaturalNum checks that the input string is a natural number
	 * @param naturalNumber is the input to be verified
	 * @return true if naturalNumber is a natural number, false if not
	 */
	public static boolean checkNaturalNum(String naturalNumber) { 
		try {
			if (Integer.parseInt(naturalNumber) > 0) {
				return true;
			} else {
				return false;
			}
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * checkValidMoney checks that the String is (or can be converted to) a valid double
	 * @param moneyValue is the input String to be verified
	 * @return true if the string can be parsed as a double and is a whole number, false if not
	 */
	public static boolean checkValidMoney(String moneyValue) {
		try {
			if (Double.parseDouble(moneyValue) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch(NumberFormatException e) {
			return false;
		}
	}

	/**
	 * checkWholeNum checks that the input string is a valid whole number
	 * @param wholeNumber is the input String being verified	
	 * @return true if the string can be parsed to an integer greater than or equal to zero, false if not
	 */
	public static boolean checkWholeNum(String wholeNumber) {
		try {
			if (Integer.parseInt(wholeNumber) >= 0) {
				return true;
			} else {
				return false;
			}
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * checkNameRepeats checks that the input string is not the name of an item in the inventory list
	 * @param inputName is the name being searched for
	 * @return true if an item sharing the same name is found, false if not
	 */
	public static boolean checkNameRepeats(String inputName) {
		boolean repeatFound = false;
		if (Inventory.getListInventory().size() > 0 && checkString(inputName)) {
			for (Integer i = 0; i < Inventory.getListInventory().size(); i++) {
				if (Inventory.getListInventory().get(i).getItem().equals(inputName))
					repeatFound = true;
			}
		}
		return repeatFound;
	}
	
	/** 
	 * checkTagRepeats checks that the input tag is not the tag of an item in the inventory list
	 * @param inputTag is the tag being searched for
	 * @return true if an item sharing the same tag is found, false if not
	 */
	public static boolean checkTagRepeats(String inputTag) {
		boolean repeatFound = false;
		if (Inventory.getListInventory().size() > 0 && checkNaturalNum(inputTag)) {
			for (Integer i = 0; i < Inventory.getListInventory().size(); i++) {
				if (Inventory.getListInventory().get(i).getTag() == Integer.parseInt(inputTag))
					repeatFound = true;
			}
		}
		return repeatFound;
	}
	
	/**
	 * checkInteger checks that the input string can be parse as an integer
	 * @param inputString is the String being checked 
	 * @return true if the string can be parsed to integer, false if not
	 */
	public static boolean checkInteger(String inputString) {
		try {
			Integer.parseInt(inputString);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
}
