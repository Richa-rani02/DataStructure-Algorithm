import java.util.*;
public class MajorityElement_I {

    public static int validCandidate(int arr[]){
        int val=arr[0];
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(val==arr[i]){
                count++;
            }else{
                count--;
            }
            if(count==0){
                val=arr[i];
                count=1;
            }
        }
        return val;
    }

    public static void printMajorityElement(int[] arr) {

         // third  method timecomplexity -o(n) spacecomplexity-o(1) using Moore’s Voting 
         int value=validCandidate(arr);
         int count=0;
         for(int i=0;i<arr.length;i++){
             if(value==arr[i])
             {
                 count++;
             }
         }
         if(count>arr.length/2){
             System.out.println(value+" ");
         }else{
             System.out.println("No Majority Element exist");
         }

     // first method timecomplexity -o(n2) spacecomplexity-o(1)
     /*   
        int maxcount=0;
        int index=0;
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
                if(arr[j]==arr[i]){
                    count++;
                }
            }
            if(count>maxcount){
                maxcount=count;
                index=i;
            }
            
            
        }
        if(maxcount>arr.length/2){
            System.out.println(arr[index]+" ");
        }else{
            System.out.println("No Majority Element exist");
        }
        */
     // second  method timecomplexity -o(n) spacecomplexity-o(n) using hashmap 

    /* HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int count=map.get(arr[i])+1;
                if(count>arr.length/2){
                    System.out.println(arr[i]+" ");
                    return;
                }else{
                    map.put(arr[i],count);
                }
                
            }else{
                map.put(arr[i],1);
            }
        }
        System.out.println("No Majority Element exist");
*/


    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        printMajorityElement(arr);
    }
}