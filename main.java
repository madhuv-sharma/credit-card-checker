/**
 * Source - https://www.creditcardinsider.com/learn/anatomy-of-a-credit-card/
    * MII Info
     * 0 – ISO/TC 68 and other industry assignments
     * 1 – Airlines
     * 2 – Airlines, financial and other future industry assignments
     * 3 – Travel and entertainment
     * 4 – Banking and financial
     * 5 – Banking and financial
     * 6 – Merchandising and banking/financial
     * 7 – Petroleum and other future industry assignments
     * 8 – Healthcare, telecommunications and other future industry assignments
     * 9 – For assignment by national standards bodies
     * 
    * Card Type, Starts with, Length
     * American Express, '34'or'37', '15'
     * Diners Club and Carte Blance, '30','36'or'38', '14'
     * Discover, '6', '16'
     * Master, '5', '16'
     * Visa, '4', '13'or'16'
     * */

import java.util.*;
import java.lang.*;

public class credit_card
{
    public String input()
    {
        String credit, type;
        int len, i;
        boolean b1=true, b2=true, b3=true, bool=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter\n1 for American Express\n2 for Diners Club/ Carte Blance\n3 for Discover\n4 for Master\n5 for Visa\n");
        char ch=sc.next().charAt(0);
        while (!bool)
        {
            System.out.println("Enter Credit Card Number:");
            credit=(sc.nextLine()).strip(); 
            len=credit.length();
            if(len>=13 && len<=19)
                bool=true;
            else
            {
                System.out.println("Length of Credit Card Number should be 13-19 digits!");
                bool=false;
                continue;
            }
            for(i=0; i<len; i++)
                if(!(Character.isDigit(credit.charAt(i))))
                {
                    System.out.println("All characters should be digits!");
                    bool=false;
                    break;
                }
        }
        switch(ch)
        {
            case '1':
                type = "American Express";
                b1 = credit.charAt(0) == '3';
                b2 = credit.charAt(1) == '4' || credit.charAt(1) == '7';
                b3 = len==15;
                break;
            case '2':
                type = "Diners Club/ Carte Blance";
                b1 = credit.charAt(0) == '3';
                b2 = credit.charAt(1) == '0' || credit.charAt(1) == '6' || credit.charAt(1) == '8';
                b3 = len==14;
                break;
            case '3':
                type = "Discover";
                b1 = credit.charAt(0) == '6';
                b2 = len==16;
                break;
            case '4':
                type = "Master";
                b1 = credit.charAt(0) == '5';
                b2 = len==16;
                break;
            case '5':
                type = "Visa";
                b1 = credit.charAt(0) == '4';
                b2 = len==13 || len==16;
                break;
            default:
                System.out.println("Invalid Entry!");
        }
        bool = b1 && b2 && b3;
        if(bool)
            success(type);
        else
            error(type);
        return credit;
    }
    public void success(String type)
    {
        System.out.println("Given Credit Card Number might be of " + type + " Card");
    }
    public void err(String type)
    {
        System.out.println("Given Credit Card Number is not of " + type + " Card");
    }
    public String getMII(String credit)
    {
        char first=credit.charAt(0);
        switch(first)
        {
            case '1':
            case '2':
                return "Airlines, financial and other future industry assignments";
            case '3':
                return "Travel and entertainment";
            case '4':
            case '5':
                return "Banking and financial";
            case '6':
                return "Merchandising and Banking/Financial";
            case '7':
                return "Petroleum and other future industry assignments";
            case '8':
                return "Healthcare, telecommunications and other future industry assignments";
            default:
                return "Unknown";
        }
    }
    public boolean check(String credit)
    {
        int len = credit.length();
        int c = (int) credit;
        int d=0, sum=0, x;
        for(int i=0; c!=0; i++, c/=10, d = d*10 + x, sum += x)
        {
            if(i%2==0)
                x=c%10;
            else
            {
                x = 2*(c%10);
                if(x>9)
                    x = x/10 + x%10;
            }
        }
        if(sum%10==0)
            return true;
        return false;
    }
    public void main()
    {
        String credit = input();
        String mii = getMII(credit);
        char iin = credit.charAt(0);
        if(check(credit))
            System.out.println("Credit Card Number - " + credit + "\nMII - " + mii + "\nIIN - " + iin);
        else
            System.out.println("Invalid Credit Card Number!");
    }
}