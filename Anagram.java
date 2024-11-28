/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		System.out.println(DeleteChar("silent",'e'));
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// function count number of timer char shown in str
	public static int countOfChar(String str , char ch){
		int count =0;
		for ( int i=0; i< str.length(); i++){
			char letter = str.charAt(i);
			if( letter == ch){
				count++;
			}
		}
		return count;
	}


	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		String string1 = preProcess(str1);
		String string2 = preProcess(str2);
		boolean flag = true; // if found not match 
		int checked = -1;// if letter checked in str

		if(countOfChar(string1, ' ')>0 || countOfChar(string2, ' ')>0){
			string1 = DeleteChar(string1, ' ');
			string2 = DeleteChar(string2, ' ');
		}
		else if( string1.length() != string2.length()){
			flag = false;
		} else{
			for ( int i=0; i<string1.length() && flag; i++){
				char c1= string1.charAt(i);
				int timesCount1 = countOfChar(string1, c1);
				if(timesCount1!=checked){
					int timesCount2 = countOfChar(string2, c1);
					if(timesCount1==timesCount2){
						checked= timesCount1;
					} else{
						flag=false;
					}
				}
			}
		}
		return flag;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String strOutput = "";
		for (int i=0; i< str.length(); i++){
			char inStr = str.charAt(i);
			if(inStr >= 65 && inStr<=90){
				inStr = (char)(inStr+32);
				strOutput+= inStr;
			}
			else if (inStr >= 97 && inStr <= 122){
				strOutput+= inStr;
			}
			if (str.charAt(i) == ' '){  // keeping spaces
				strOutput += inStr; // 
			  }
		}
		return strOutput;
	} 

	public static String DeleteChar(String str, char ch){
		int index= str.indexOf(ch);
		String toIndex=str.substring(0, index);
		String fromIndex = str.substring(index+1, str.length());
		
		return toIndex+fromIndex;

	}
	
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String str1=preProcess(str);
		int strLength = str1.length();
		String newStr="";

		for( int i=0; i< strLength; i++){
			int randomIndex = (int) (Math.random()* str1.length());
			//char ch=str1.charAt(randomIndex);
			newStr+= str1.charAt(randomIndex);
			str1 = DeleteChar(str1, str1.charAt(randomIndex));
		}
		return newStr;
	}
}
