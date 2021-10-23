package searching_sorting;
import java.util.*;
public class find_first_last {
    public static int[] find(int[]arr,int target) {


        int res[] ={-1,-1};

        // first method (o(n))

    /*    int first=-1,last=-1;
        for(int i=0;i<arr.length;i++){
            if(target!=arr[i]){
                continue;
            }
            if(first==-1){
                first=i;
                res[0]=first;
            }else{
                last=i;
                res[1]=last;
            }
            
        }
        
      */ 
      // optimal solution (log(n))
      
      int low=0;
      int high=arr.length-1;
      // to find first index
      
      while(low<=high){
          int mid=(low+high)/2;
          if(arr[mid]==target){
              res[0]=mid;
              high=mid-1;
          }else if(arr[mid]<target){
              low=mid+1;
          }else{
              high=mid-1;
          }
      }
      
       low=0;
       high=arr.length-1;
      // to find last index
      
      while(low<=high){
          int mid=(low+high)/2;
          if(arr[mid]==target){
              res[1]=mid;
              low=mid+1;
          }else if(arr[mid]<target){
              low=mid+1;
          }else{
              high=mid-1;
          }
      }
      return res;
        
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0;i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        int[]ans = find(arr,target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
