package application;

public abstract class ValueValidation {
	
	final static String checkStringErrorMsg = "Enter a string at least one character in length";
	final static String checkNaturalNumErrorMsg = "Enter an integer greater than or equal to 1";
	final static String checkValidMoneyErrorMsg = "Enter a value greater than or equal to 0";
	final static String checkWholeNumErrorMsg = "Enter an integer greater than or equal to 1";
	final static String checkTagRepeatsErrorMsg = "Tag already used for another item. Enter a unique tag";
	final static String checkItemRepeatsErrorMsg = "Name already used for another item. Enter a unique name";
	
	public static boolean checkString(String string) {
		if (string != null && string != "")
			return true;
		else
			return false;
	}

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
	
	public static boolean checkInteger(String inputString) {
		try {
			Integer.parseInt(inputString);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
}
