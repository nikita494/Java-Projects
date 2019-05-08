import java.util.stream.IntStream;
class NivenFounder {
  public static void main(String args[]){
   IntStream.range(0,1001).filter((x)-> x==0 ? false : x%String.valueOf(x).chars().map(Character::getNumericValue).sum()==0).forEach((x)->System.out.println(x));
  
  } 
}