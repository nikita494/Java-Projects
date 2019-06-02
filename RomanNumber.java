import java.util.*;
import java.lang.Math;
import java.util.stream.IntStream;
class RomanNumber{
  int decimalValue;
  String romanValue;
  RomanNumber(String romanValue){
    if (!romanValue.matches("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"))
     throw new IllegalArgumentException();
    this.romanValue = romanValue;
    this.decimalValue = romanToArabic(romanValue);
  } 
  RomanNumber(int decimalValue){
    if (x<=0 || x>3999)
     throw new IllegalArgumentException();
    this.decimalValue = decimalValue;
    this.romanValue = arabicToRoman(decimalValue);
  } 
  static private  HashMap<Integer,String> arabic_roman= new HashMap<Integer,String>();
   static private  HashMap<Character,Integer> roman_arabic= new HashMap<Character,Integer>();
   static{
    arabic_roman.put(1,"I");
    arabic_roman.put(4,"IV");
    arabic_roman.put(5,"V");
    arabic_roman.put(9,"IX");
    arabic_roman.put(10,"X");
    arabic_roman.put(40,"XL");
    arabic_roman.put(50,"X");
    arabic_roman.put(90,"XC");
    arabic_roman.put(100,"C");
    arabic_roman.put(400,"CD");
    arabic_roman.put(500,"D");
    arabic_roman.put(900,"CM");
    arabic_roman.put(1000,"M");
    roman_arabic.put('I',1);
    roman_arabic.put('V',5);
    roman_arabic.put('X',10);
    roman_arabic.put('L',50);
    roman_arabic.put('C',100);
    roman_arabic.put('D',500);
    roman_arabic.put('M',1000);
   }
  static String arabicToRoman(int x){
    if(x<=0 || x>3999 ){
      throw new IllegalArgumentException();
    }
StringBuilder str = new StringBuilder(); 
     int y =0;
 do{
       final int fx =x;
      y = IntStream.of(1,4,5,9,10,40,50,90,100,400,500,900,1000).filter((e)-> e<=fx ).max().getAsInt();
      str.append(arabic_roman.get(y));
      x=x-y;
}while(x !=0); 
 return str.toString();
  }
  static int romanToArabic(String roman_number){
   if (!roman_number.matches("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"))
     throw new IllegalArgumentException();
  int answer =0;
  for(int i=0; i<roman_number.length(); i++){
    if(i != roman_number.length()-1 ){
      if(roman_arabic.get(roman_number.charAt(i)) >= roman_arabic.get(roman_number.charAt(i+1)))
        answer=answer+roman_arabic.get(roman_number.charAt(i));
      else{
        answer=answer+(roman_arabic.get(roman_number.charAt(i+1))-roman_arabic.get(roman_number.charAt(i)));
        i++;
      }
    }
    else
      answer=answer+roman_arabic.get(roman_number.charAt(i));
  }
return answer;
}
 
}