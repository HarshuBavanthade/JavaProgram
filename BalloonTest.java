import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalloonTest {

     public static void main(String[] args)throws IOException {
	    int N,M,intValue[];
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
		String s=br.readLine();
		String strArray[]=str.trim().split("\\s+");
		N=Integer.parseInt(strArray[0]);
		M=Integer.parseInt(strArray[1]);
		String sArray[]=s.trim().split("\\s+");
		intValue=new int[sArray.length];
		if(N==sArray.length)
		{
            for(int i = 0; i<N; i++)
		     {          
               intValue[i]=Integer.parseInt(sArray[i]);
             }
		}
	   	 br.close();
		 BalloonTest test =new BalloonTest();
		 System.out.println(test.getDestroy(intValue,M));
     }
	 public int getDestroy(int value[],int M)
	 {
	      int spos,epos,len;
		  String s, sArray[];
		  spos=M;
		  epos=M;  
		  len=0;
	      while(spos!=-1)
		   {
		      value=shrinkArray(value,spos-1,epos);
			  s=maxDestroyBallon(value);
			  sArray=s.trim().split("\\s+");
			  spos=Integer.parseInt(sArray[0]); 
			  epos=Integer.parseInt(sArray[1]);	  	  
		  }		  
         while(value[len]!=-1){ len++;}
		 len=value.length-len;
		 return  len;     		  	
	 }
	public int[] shrinkArray(int value[],int spos,int epos)
	  {
		   int min,destroy;	
			 min=spos;
	        for(int i=epos;i<value.length;i++)
			 {		 	
				 value[min]=value[i];
				 value[i]=-1;
				 min++;
			  }			
		   return value;
	  }
	public String maxDestroyBallon(int value[])
	 	 { 
		    int i,j,spos,c,epos,temp;
			int len=value.length;
			spos=0;
			epos=0;
			c=0;
			for(i=0;i<len-1;i++)
			 { 
			     j=i+1;
				 temp=value[i];
                 while(j<len&&temp==value[j]&&value[j]!=-1)
				 {
				    c++;
					j++;
				
				  }
				 if(c>=2)
				  {
			         spos=i+1;
					 epos=i+c+1;
					 break;	  	
				  }
				  spos=0;
				  epos=0;   
				  c=0;			 
			  }
			  	if(c==0){spos=-1; } 			
			 
		   return String.valueOf(spos)+" "+String.valueOf(epos);	 			 
		 }	
}
