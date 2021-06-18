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
import java.util.Scanner;

class credit_card
{
    String credit, type, mii, iin, a, account;
    char ch;
    int first, second, len, s=0, c, x;
    boolean b1, b2, b3bool;
    String input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter\n1 for American Express\n2 for Diners Club/ Carte Blance\n3 for Discover\n4 for Master\n5 for Visa\n");
        ch=sc.nextChar();
        bool=False;
        while (!bool)
        {
            System.out.println("Enter Credit Card Number:");
            credit=sc.nextLine(); 
            len=credit.length();
            if(len>=13 && len<=19)
                bool=True;
            else
            {
                System.out.println("Length of Credit Card Number should be 13-19 digits!");
                bool=False;
                continue;
            }
            for(i=0; i<len; i++)
            {
                if(!(credit[i].isdigit()))
                {
                    System.out.println("All characters should be digits!");
                    bool=False;
                    break;
                }
            }
        }
        switch(ch)
        {
            case '1':
                type = "American Express"
                b1 = credit.charAt(0) == '3' 
                b2 = credit.charAt(1) == '4' || credit.charAt(1) == '7'
                b3 = len==15
                bool = b1 && b2 && b3
                if(bool)
                    success(type);
                else
                    error(type);
                break;
            case '2':
                type = "Diners Club/ Carte Blance"
                b1 = credit.charAt(0) == '3' 
                b2 = credit.charAt(1) == '0' || credit.charAt(1) == '6' || credit.charAt(1) == '8'
                b3 = len==14
                bool = b1 && b2 && b3
                if(bool)
                    success(type);
                else
                    error(type);
                break;
            case '3':
                type = "Discover"
                b1 = credit.charAt(0) == '6' 
                b2 = len==16
                bool = b1 && b2
                if(credit.charAt(0)=='6' && credit.length() == 16)
                    success(type);
                else
                    error(type);
                break;
            case '4':
                type = "Master"
                b1 = credit.charAt(0) == '5' 
                b2 = len==16
                if(credit.charAt(0)=='5' && credit.length() == 16)
                    success(type);
                else
                    error(type);
                break;
            case '5':
                type = "Visa"
                b1 = credit.charAt(0) == '4' 
                b2 = len==13 || len==16
                bool = b1 && b2
                if(bool)
                    success(type);
                else
                    error(type);
                break;
            default:
                System.out.println("Invalid Entry!");
        }
        return credit;
    }
    void success(String type)
    {
        System.out.println("Given Credit Card Number might be of " + type + " Card");
    }
    void err(String type)
    {
        System.out.println("Given Credit Card Number is not of " + type + " Card");
    }
    void mi(credit)
    {
        first=credit.charAt(0);
        switch(first)
        {
            case '0':
                mii = "ISO/TC 68 and other industry assignments"
                break;
            case '1':
                mii = "Airlines"
                break;
            case '2':
                mii = "Airlines, financial and other future industry assignments"
                break;
            case '3':
                mii = "Travel and entertainment"
                break;
            case '4':
            case '5':
                mii = "Banking and financial"
                break;
            case '6':
                mii = "Merchandising and banking/financial"
                break;
            case '7':
                mii = "Petroleum and other future industry assignments"
                break;
            case '8':
                mii = "Healthcare, telecommunications and other future industry assignments"
                break;
            case '9':
                mii = "For assignment by national standards bodies"
                break;
        }
        /*
        if(first == '1' || first == '2')
            mii= "Airlines";
        else if (first == '3')
            mii = "Travel";
        else if (first == '4' || first == '5')
            mii="Banking and Financial";
        else if (first == '6')
            mii="Merchandising and Banking/Finanacial";
        else if (first == '7')
            mii="Petroleum";
        else if (first =='8')
            mii="Healthcare,Telecommunications";
        else
            mii = "Unknown";
        */
    }
    /*
    void check()
    {
        for(x=0; x<=credit.length(); x+=2)
        {
            x=x*2;
        }
        if(x>9)
        {
            while(x>0)
            {
            int r=x%10;
            s=s+r;
            x=x/10;
            }
            c=s;
        }
        for (int y=1;y<=credit.length();y+=2)
        {
            int ans=x+c+y;
            if(ans%10==0)
            {
                System.out.println("It is a valid credit card");
                System.out.println("Major Issuer Number is "+mii);
                System.out.println("Issuer Identification Number is "+iin);
                System.out.println("Account Number is "+account);
            }
            else
                System.out.println("Invalid card no.");
        }
    }*/
    void main()
    {
        credit = input();
        System.out.println(credit);
    }
}