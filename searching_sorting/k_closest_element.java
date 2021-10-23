package searching_sorting;
import java.util.*;
public class k_closest_element {
   /* public static class Pair implements Comparable <Pair>{
        int val;
        int gap;
        
        Pair(){
            
        }
        Pair(int val,int gap){
            this.val=val;
            this.gap=gap;
        }
        public int compareTo(Pair o){
            if(this.gap==o.gap){
                return this.val-o.val;
            }
            else{
                return this.gap-o.gap;
            }
        }
       
    }
  */ 
  public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
   

    // first method complexity  nlogk
    /*
     ArrayList<Integer> list=new ArrayList<>();
    PriorityQueue<Pair> pq=new PriorityQueue<>(Collections.reverseOrder());
    
    for(int i=0;i<arr.length;i++){
        if(pq.size()<k){
            pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
        }else{
            if(pq.peek().gap>Math.abs(arr[i]-x)){
                pq.remove();
                pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
            }
        }
    }
    while(pq.size()>0){
        Pair rem=pq.remove();
        list.add(rem.val);
    }
    Collections.sort(list);
    */

     // second  method complexity  nlogk


     int lo=0;
      int hi=arr.length-1;
      int mid=0;
      
      
      while(lo<=hi){
          mid=(lo+hi)/2;
          
          if(arr[mid]==x){
              break;
          }else if(arr[mid]<x){
              lo=mid+1;
          }else{
              hi=mid-1;
          }
      }
      int l=mid-1;
      int r=mid;
      
      ArrayList<Integer> list=new ArrayList<>();
      while(l>=0 && r< arr.length && k>0){
          if(Math.abs(arr[l]-x)<=Math.abs(arr[r]-x)){
              list.add(arr[l]);
              l--;
          }else{
              list.add(arr[r]);
              r++;
          }
          k--;
          
      }
      while(k>0 && l>=0){
          list.add(arr[l]);
          l--;
          k--;
      }
       while(k>0 && r<arr.length){
          list.add(arr[r]);
          r++;
          k--;
      }
      
      Collections.sort(list);
        return list;
     
  }

  public static void main(String[]args) {

      //input work
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();

      int[]arr = new int[n];

      for(int i=0; i < n;i++) {
          arr[i] = scn.nextInt();
      }

      int k = scn.nextInt();
      int x = scn.nextInt();

      ArrayList<Integer>ans = findClosest(arr,k,x);

      for(int val : ans) {
          System.out.print(val + " ");
      }

  }
}
