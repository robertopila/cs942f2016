//DEC to HEX/BIN Converter
//by Jeff Strom
import java.util.Scanner;
import static java.lang.Math.*;

class HexConverter 
{	
  
	//Main loop
public static void main(String[] args) {
	int dec;
	Scanner keyboard = new Scanner(System.in);
	System.out.print("Enter a decimal integer: ");     
	dec = keyboard.nextInt();     
	String bin = decToBin(dec);
	System.out.print("Binary equivalent: "); 
	System.out.println(bin);
	System.out.print("Hexadecimal equivalent: "); 
	String hex = decToHex(bin);
	System.out.println(hex);
	}

//=================METHODS=====================
static String decToBin(int dec) {  
	  int val = dec;			//make a shallow copy of dec value that we can alter
	  String reversebinaryValue = "";
	  int bit = 0;
	  
	//algorithm -- convert decimal to binary by modular arithmetic
	  while(val>1){	
		  bit = val%2;
		  reversebinaryValue += bit;
		  val = (int) Math.floor((val/2));
	  }
	//get last digit of binary value, as well
	  bit = val%2;		
	  reversebinaryValue+=bit;	  
	  	  
	  //Since bit sequence is now reversed from right to left, write output to String in reverse order
	  String output="";	
	  for (int i = 0; i < reversebinaryValue.length(); i++) {
		    output+=(reversebinaryValue.charAt(reversebinaryValue.length()-i-1));
	  }
	  return output;
	}

static String decToHex(String bin) { 
	char[] hexDigits = { 
		    '0', '1', '2', '3', '4', '5', '6', '7', 
		    '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'  };	//array of all characters in hexadecimal number system
	
	  String reverseHexValue = "";
	  int val=0;
	  int counter=0;
	  
	  //algorithm -- convert binary to hex by turning groups of 4 binary digits into one hex value
	  for (int i = 0; i < bin.length(); i++) {
		    val+=(((bin.charAt(bin.length()-i-1))-48)*pow(2,counter));
		    counter++;
		    if(counter==4){
		    	reverseHexValue+=hexDigits[val];
		    	val = counter = 0;
		    }    
	  }
	  if(counter != 0){			//capture any remaining hex values
		  reverseHexValue+=val;
		  val = counter = 0;}
	  
	  //finally, turn the string of hex values around so it's correct
	  String output = "";
	  for (int i = 0; i < reverseHexValue.length(); i++) {
		    output+=(reverseHexValue.charAt(reverseHexValue.length()-i-1));
	  }
	  
	  return output;
	  
}

}