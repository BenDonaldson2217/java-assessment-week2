package main;

import java.util.ArrayList;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") → "TTThhheee"
	// multChar("AAbb") → "AAAAAAbbbbbb"
	// multChar("Hi-There") → "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		
		ArrayList<String> words= new ArrayList<String>();
		for (int i=0; i<input.length(); i++) {
			for (int j = 0; j <3; j++) {
				words.add(input.substring(i, i+1));
			}
		}
		String answer= "";
		
		for (String i: words) {
			answer = answer + i;
		}
		
		return answer;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") → "evilc"
	// getBert("xxbertfridgebertyy") → "egdirf"
	// getBert("xxBertfridgebERtyy") → "egdirf"
	// getBert("xxbertyy") → ""
	// getBert("xxbeRTyy") → ""

	public String getBert(String input) {
		
		boolean appearsTwice = false;
		int first = -1;
		int last = -1;
		for (int i = 0; i < input.length() - 3; i++) {
			if (input.substring(i, i+4).equalsIgnoreCase("bert")) {
				first = i;
				break;
			}
			
		}
		for (int j = input.length() - 4; j>=0; j--) {
			if (input.substring(j, j+4).equalsIgnoreCase("bert")) {
				last = j;
				break;
			}
		}
		
		if (first != last) {
			appearsTwice= true;
		}
		
		if (!appearsTwice) {
			return "";
		}
		

		else {
			input = input.substring(first+4, last);
			ArrayList<String> words= new ArrayList<String>();
			for (int i=0; i<input.length(); i++) {
				words.add(input.substring(i, i+1));
			}
			ArrayList<String> answer= new ArrayList<String>();
			for (int i = words.size()-1; i>=0; i--) {
				answer.add(words.get(i));
			}
			System.out.println(answer);
			String result = "";
			for (String i: answer) {
				result = result + i;
			}
			System.out.println(result);
			return result;
		}
		
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false
	// evenlySpaced(4, 60, 9) → false

	public boolean evenlySpaced(int a, int b, int c) {
		int small;
		int medium;
		int large;
		if (a<b && a<c) {
			small = a; 
			if (b<c) {
				medium = b;
				large = c;
			}
			else {
				medium = c;
				large = b;
				
			}
		}
		else if (a <b && c <a) {
			small = c;
			medium = a;
			large = b;
		}
		else if (a < c && b<a) {
			small = b;
			medium = a;
			large = c;
		}
		else if (b< c) {
			small = b;
			medium=c;
			large = a;
		}
		else {
			small = c;
			medium = b;
			large=a;
		}
		
		if ( (large-medium) == (medium-small) ) {
			return true;
		
		}
		else {
			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) → "Ho"
	// nMid("Chocolate", 3) → "Choate"
	// nMid("Chocolate", 1) → "Choclate"

	public String nMid(String input, int a) {
		
		ArrayList<String> words= new ArrayList<String>();
		int length = input.length();
		int startSkip = (length -a)/2;
		int endSkip = startSkip+a;
		for (int i=0; i<length; i++) {
			
			if ( i>= startSkip  && i < endSkip) {
				continue;
			}
			words.add(input.substring(i, i+1));
			
		}
		String answer= "";
		
		for (String i: words) {
			answer = answer + i;
		}
		
		return answer;
	}

	// Given a string, return true if it ends in "dev". Ignore Case

	// endsDev("ihatedev") → true
	// endsDev("wehateDev") → true
	// endsDev("everoyonehatesdevforreal") → false
	// endsDev("devisnotcool") → false

	public boolean endsDev(String input) {
		
		int length = input.length();
		if (length<3) {
			return false;
		}
		String finalThree = input.substring(length-3);
		if (finalThree.equalsIgnoreCase("dev")) {
			return true;
		}
		else {
			return false;
		}
	}



	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") → 2
	// superBlock("abbCCCddDDDeeEEE") → 3
	// superBlock("") → 0

	public int superBlock(String input) {
		
		if (input.length() == 0) {
			return 0;
		}
		
		ArrayList<Integer> lengths= new ArrayList<Integer>();
		
		
		
		for(int i=0; i<input.length(); i++) {
			String letter = input.substring(i, i+1);
			int length = 1;
			for (int j=i+1; j<input.length(); j++) {
				if (input.substring(j,j+1).equals(input.substring(i,i+1))) {
					length = length + 1;;
				}
				lengths.add(length);
			}
		}
		
		int maximum = lengths.get(0);
		
		for (int i =1; i< lengths.size(); i++) {
			if(lengths.get(i) > maximum) {
				maximum = lengths.get(i);
			}
		}
		
		
		return maximum;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") → 1
	//amISearch("I am in Amsterdam am I?") → 2
	//amISearch("I have been in Amsterdam") → 0

	public int amISearch(String arg1) {
		
		int length = arg1.length();
		int counter = 0;
		if (length == 0) {
			return counter;
		}
		
		String firstThree = arg1.substring(0, 3);
		
		if (firstThree.equalsIgnoreCase("am ")) {
			counter = counter +1;
		}
		
		String lastThree = arg1.substring(length-3);
		
		if (lastThree.equalsIgnoreCase(" am")) {
			counter = counter +1;
		}
		
		for (int i = 1; i< length-4; i++) {
			String toBeChecked = arg1.substring(i,i+4);
			if (toBeChecked.equalsIgnoreCase(" am ")) {
				counter = counter +1;
			}
		}
		return counter;
		
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) → "fizz"
	//fizzBuzz(10) → "buzz"
	//fizzBuzz(15) → "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		
		if ((arg1 % 15) == 0) {
			return "fizzbuzz";
		}
		else if ((arg1 % 3) == 0) {
			return "fizz";
		}
		else if ((arg1 % 5) == 0) {
			return "buzz";
		}
		return null;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") → 14
	//largest("15 72 80 164") → 11
	//largest("555 72 86 45 10") → 15
	
	public int largest(String arg1) {
		
		ArrayList<Integer> numbers= new ArrayList<Integer>();
		ArrayList<String> numberStrings= new ArrayList<String>();
		String number="";
		
		for (int i = 0; i<arg1.length();i++) {
			if ((arg1.substring(i, i+1).equals(" "))) {
				numberStrings.add(number);
				number="";
			}
			else {
				number = number + arg1.substring(i,i+1);
			}
		}
		numberStrings.add(number);
		
		for (int i=0; i<numberStrings.size(); i++) {
			String stringNumber = numberStrings.get(i);
			if (stringNumber.equals(" ")) {
				
				continue;
			}
			else {
				int num=0;
				int length = stringNumber.length();
				for (int j =0; j<length; j++) {
					int numRep=0;
					String strRep = stringNumber.substring(length - j -1, length -j);
					if (strRep.equals("0")) {
						numRep = 0;
					}
					else if (strRep.equals("1")){
						numRep=1;
					}
					else if (strRep.equals("2")){
						numRep=2;
					}
					else if (strRep.equals("3")){
						numRep=3;
					}
					else if (strRep.equals("4")){
						numRep=4;
					}
					else if (strRep.equals("5")){
						numRep=5;
					}
					else if (strRep.equals("6")){
						numRep=6;
					}
					else if (strRep.equals("7")){
						numRep=7;
					}
					else if (strRep.equals("8")){
						numRep=8;
					}
					else if (strRep.equals("9")){
						numRep=9;
					}
					num = num + numRep * (int) (Math.pow(10, j));
				}
				numbers.add(num);
			}
			
		}
		ArrayList<Integer> totals= new ArrayList<Integer>();
		
		for (int k=0; k<numbers.size(); k++) {
			int total = 0;
			for (int l = 0; l < 5; l++) {
				total = total + (numbers.get(k) / ( (int) Math.pow(10, l) ) % 10);
			}
			totals.add(total);
		}
		
		
		
		int maximum = totals.get(0);
		
		for (int i =1; i< totals.size(); i++) {
			if(totals.get(i) > maximum) {
				maximum = totals.get(i);
			}
		}
		
		
		return maximum;

		
	}
	
	
}
