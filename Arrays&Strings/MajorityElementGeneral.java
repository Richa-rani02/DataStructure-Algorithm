import java.util.*;

public class MajorityElementGeneral {
    public static ArrayList<Integer> majorityElement(int[] arr, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
                
            }
        }
        for(int key:map.keySet()){
            if(map.get(key)>arr.length/k){
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;
     }
     
          public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
         int[] arr = new int[n];
         for(int i = 0; i < n; i++) {
             arr[i] = scn.nextInt();
         }
         int k = scn.nextInt();
         ArrayList<Integer> res = majorityElement(arr, k);
         System.out.println(res);
     }
}
