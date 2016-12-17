# MathConversions 
This program contains a simple algorithm to convert a number to decimal from any base from binary to 35. 

The MathConversion.java algorithm essentially boils down to the getDecimal function. This function takes a string “number” and an integer “base” as arguments. It begins by building a hash map that can convert the string to integers. This is necessary to convert any letters in the string used in bases greater than base 10. For example, if the string entered was A67B9, the hash map would convert the “A” to 10, and the “B” to 11, as each character was called by symbolValues.get(number.charAt(i)) in Line 17.

Then, it takes the value of each place in the original number and multiplies it times the value of that base. For example, if the number were 1001 in base 2, the algorithm would take the first numeral, 1, and multiply the value of its place, here 23, to get the value, also in Line 17.

Next, the program adds each value as it loops through the string to the integer “dec.” After the for loop finishes, the function returns the value of dec. 

### Run tests

```
> gradle test
```

## Usage


```java
import com.mcnally.MathConversions;

int decimal = MathConversions.toDecimal("100", 16);  // decimal == 256
```
