import java.util.Scanner;


public class PalindromeCounter {

	//This function will return the reverse of the input string
	static String reverse(String str){
		String rev="";
		for(int i=str.length()-1;i>=0;i--){
			rev=rev+str.charAt(i);
		}
		return rev;
	}
	
	//This function will return the substring of the given string between i and j
	static String getSubstrin(String str, int i, int j){
		if(j>i){
			return str.substring(i,j);
		}else{
			return str.substring(j,i);
		}
	}
	
	//This will return the no of palindromes that can be built from the given palindrome string
	static int countPalindromes(String inputPalindrom){
		int length=inputPalindrom.length();
		int substringLength=2;
		int count=length+1;
		//we create substrings to check for palindromes untill the substring length is less than the length of the given string
		while(substringLength<=length){
			for(int i=0;i<=length-substringLength;i++){
				String subString=getSubstrin(inputPalindrom,i,substringLength);
				//Only when the substring has more then one characters we check for palindrome
				if(subString.length()>1){
					String subStringReverse=""+subString.charAt(0);
					subStringReverse=subStringReverse+subString.charAt(subString.length()-1);
					subStringReverse=reverse(subStringReverse);
					char c=subString.charAt(0);
					int flag=0;
					for(int j=0;j<subString.length()/2;j++){
						if(subString.charAt(j)!=c ||subStringReverse.charAt(j)!=c){
							flag=1;
							break;
						}
					}
					if(flag==0){
						count++;
					}
				}
			}
			substringLength++;
		}
		return count;
		
	}
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		//The input string is taken
		String palindrome=input.next();
		System.out.println(countPalindromes(palindrome));
	}

}
