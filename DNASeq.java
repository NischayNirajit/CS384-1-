package greedyalgos;

import java.util.Scanner;

public class DNASeq {
    int L[][];
    int L3[][][];
  int lcs( char[] X, char[] Y, int m, int n )
  {
   L = new int[m+1][n+1];
 
   
    for (int i=0; i<=m; i++)
    {
      for (int j=0; j<=n; j++)
      {
        if (i == 0 || j == 0)
            L[i][j] = 0;
        else if (X[i-1] == Y[j-1])
            L[i][j] = L[i-1][j-1] + 1;
        else
            L[i][j] = max(L[i-1][j], L[i][j-1]);
      }
    }
  return L[m][n];
  }
  
  int lcs3(int m,int n,int o,char[] X,char[] Y,char[] Z)
    {
        L3=new int[m+1][n+1][o+1];
        for(int i=0;i<=m;i++)
        {
            for(int j=0;j<=n;j++)
            {
                for(int k=0;k<=o;k++)
                {
                    if(i==0 || j==0 || k==0)
                        L3[i][j][k]=0;
                    else if((X[i-1]==Y[j-1]) && (Y[j-1]==Z[k-1]))
                        L3[i][j][k]=L3[i-1][j-1][k-1] + 1;
                    else
                        L3[i][j][k] = (int)Math.max(Math.max(L3[i-1][j][k],L3[i][j-1][k]), L3[i][j][k-1]);
                }
            }
            
        }
        return L3[m][n][o];
    }
  
  String printLCS3(int m,int n,int o,char[] X,char[] Y,char[] Z)
    {
       String S="";
       int i=m,j=n,k=o;
       while(i>0 && j>0 && k>0) 
       {
           if((X[i-1]==Y[j-1]) && (X[i-1]==Z[k-1]))
           {
               S=S+X[i-1];
               i=i-1;
               j=j-1;
               k=k-1;
           }
           else if((L3[i-1][j][k]>L3[i][j][k-1]) || (L3[i-1][j][k]>L3[i][j-1][k]))
               i=i-1;
           else if((L3[i][j-1][k]>L3[i][j][k-1]) || (L3[i][j-1][k]>L3[i-1][j][k]))
               j=j-1;
           else 
               k=k-1;
       }
       
       StringBuilder in=new StringBuilder();
       in.append(S);
       
       //System.out.println("LCS for 3 strings is:"+in.reverse());
       return in.reverse().toString();
    }
    
    
   String printLCS(int m,int n,char[] X,char[] Y)
  {
     int lim=n*m;
     int i=m,j=n;
     String str="";
     while(i>0 && j>0)
     {
         if(X[i-1] == Y[j-1])
         {
             str=str+X[i-1];
             j=j-1;
             i=i-1;
         }
         else if (L[i-1][j] > L[i][j-1])
                i--;
         else
                j--;
     }
     StringBuilder in=new StringBuilder();
     in.append(str);
     //System.out.println("String is:"+in.reverse());
     return in.reverse().toString();
  }
  
  int max(int a, int b)
  {
    return (a > b)? a : b;
  }
    
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        DNASeq obj=new DNASeq();
        System.out.println("Input String1:");
        String s1=sc.next().trim();
        System.out.println("Input String2:");
        String s2=sc.next().trim();
        System.out.println("Input String3:");
        String s3=sc.next().trim();
        System.out.println("Input String3:");
        String s4=sc.next().trim();
        System.out.println("Input String3:");
        String s5=sc.next().trim();
        
        char X[]=s1.toCharArray();
        char Y[]=s2.toCharArray();
        char Z[]=s3.toCharArray();
        char V[]=s2.toCharArray();
        char W[]=s5.toCharArray();
        
        int m=X.length;
        int n=Y.length;
        int o=Z.length;
        int p=V.length;
        int q=W.length;
        
        int len1=obj.lcs(X, Y, m, n);
        int len2=obj.lcs3(m, n, o, X, Y, Z);
        String Sp1=obj.printLCS(m, n, X, Y);
        String Sp2=obj.printLCS3(m, n, o, X, Y, Z);
        char X1[]=Sp1.toCharArray();
        char Y1[]=Sp2.toCharArray();
        int lf=obj.lcs(X1, Y1, len1, len2);
        String Sf=obj.printLCS(len1, len2, X1, Y1);
        System.out.println("Length of the largest common string is "+lf+" and the string is "+Sf);
    }
    
}
