import java.lang.Math;

class PerfectNumberFinder{
  public static void main(String args[]){
    int j=0;
    int p =0;
    do{
      p++;
      if(getAmountOfDivisors((int)Math.pow(2,p+1)-1)==0){
        j++;
       System.out.println(Math.pow(2,p)*(Math.pow(2,p+1)-1));
      }
    }while(j<5);
    
   
}
  static int getAmountOfDivisors(int n) 
    { 
        int cnt = 0; 
        for (int i = 2; i <= Math.sqrt(n); i++) 
        { 
            if (n % i == 0) { 
                if (n / i == i) 
                    cnt++; 
  
                else 
                    cnt = cnt + 2; 
            } 
        } 
        return cnt; 
    } 
}