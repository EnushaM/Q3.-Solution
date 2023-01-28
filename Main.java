import java.io.*;
import java.util.*;
public class Main
{
    static String[] LESS_THAN_20 = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static String[] TENS = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "sighty", "ninety"};   
    static String NumberToWords(int num) 
    {
        if (num == 0) return "zero";
        String words = "";
        if(num<1000)
        {
            while (num > 0) 
            {
                if (num % 1000 != 0)
                {
                    words = helper(num % 1000) + " "+ words;
                    num /= 1000;
                }
            }
        }
        else 
        {
            words=helper(num)+" "+words;
        }
        return words.trim();
    }

    static String helper(int num)
    {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100 && (num%10==0))
            return TENS[num / 10] + " ";
        else if (num < 100)
            return TENS[num / 10] + "-" + helper(num % 10);
        else if(num<1000)
            return LESS_THAN_20[num / 100] + " hundred " + helper(num % 100);
        else if(num>1000 &&(num%1000==0))
            return TENS[num / 1000]+" "+LESS_THAN_20[(num%1000)/100]+"hundred " + helper(num % 100);
        else
            return TENS[num / 1000]+"-"+LESS_THAN_20[(num%1000)/100]+" hundred " + helper(num % 100);
    }
    public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
		System.out.println(NumberToWords(n));
	}
}