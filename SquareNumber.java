import java.util.stream.IntStream;
import java.lang.Math;
import java.lang.StringBuffer;
class SquareNumber{
  public static void main(String args[]){
    IntStream.range(9999,99999).filter((e)->{
      if(Math.sqrt(e)%1==0)return true; return false; 
    }).filter((e)->{
     int i1[] = String.valueOf(e).chars().map(Character::getNumericValue).toArray();
      
     for(int i = 0; i<i1.length; i++){
       for(int j= 0; j<i1.length; j++){
         if(i1[i]==i1[j] && j !=i)
           return false;
       }
    }
     return true;
    }).forEach(System.out::println);
  
  }
}