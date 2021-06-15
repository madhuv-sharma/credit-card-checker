import java.util.Scanner;
class creditcard
{
    String credit,mii,iin,a,account; char first;int len,s=0,c,x;
    boolean b1;
    void input()
    {
        Scanner in=new scanner(System.in);
        System.out.println("Enter credit card number");
        credit=in.nextLine();     
        for(int k=0;k<=credit.length();k++)
            if(credit.length()<=12 && credit.length()>=19)
                break;
            {
                System.out.println("Enter valid card no. with digits between 12 and 19");
            }
             b1=Character.isDigit(k);
            if(b1==false)
            break;
            {
                System.out.println("Enter valid card no. with all the digits numeric and no special character");
            }      
    }
    void mi()
    {
        first=charAt(0);
        if(first == '1'|| first =='2' )
            mii= "Airlines";
        else if (first == '3')
            mii = "Travel";
        else if (first == '4'|| first == '5')
            mii="Banking and Financial";
        else if (first=='6')
            mii="Merchandising and Banking/Finanacial";
        else if (first =='7')
            mii="Petroleum";
        }
        else if (first=='8')
        {
            mii="Healthcare,Telecommunications";
        }
        else 
        mii = "Unknown";
    }
    void isuerno()
    {
         a=credit.substring(0,6);
         if (first=='3' && second == '4'||'7')
         {
             iin="Amex";
            }
            else if(first=='4')
            {
                iin="visa";
            }
            else if (first== '5' && second == '1'||'5')
            {
                iin="Master card";
            }
            else if (credit.substring(0,3)=="6011"||credit.substring(0,2)=="644"||credit.substring(0,1)=="65")
            {
                iin="Discover";
        }
        else
        iin="Unknown";
    }
          void acc()
        {
           len=credit.length();
           account=credit.substring(7,len-1);
        }
       void check()
       {
           for( x=0;x<=credit.length();x+=2)
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
                c=s;}
                for (int y=1;y<=credit.length();y+=2)
                {
                 int ans=x+c+y;{
                 if(ans%10==0)
                 {
                      System.out.println("It is a valid credit card");
                       System.out.println("Major Issuer Number is "+mii);
                        System.out.println("Issuer Identification Number is "+iin);
                         System.out.println("Account Number is "+account);
                    }
                    else 
                     System.out.println("Invalid card no.");}}}}
                
