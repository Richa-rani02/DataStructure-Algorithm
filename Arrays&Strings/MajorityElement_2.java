import java.util.*;
public class MajorityElement_2 {
    public static ArrayList<Integer> majorityElement2(int[] arr) {
        // first and second method will be same as majority element 1 
        // third and optimal solution
        
        ArrayList<Integer> res=new ArrayList<>();
        int val1=arr[0];
        int count1=1;
        int val2=arr[0];
        int count2=0;
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]==val1){
                count1++;
            }else if(arr[i]==val2){
                count2++;
            }else{
                if(count1==0){
                    val1=arr[i];
                    count1=1;
                }else if(count2==0){
                    val2=arr[i];
                    count2=1;
                }else{
                    count1--;
                    count2--;
                }
            }
        }
        int countval1=0;
        int countval2=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==val1){
                countval1++;
                
            }else if(arr[i]==val2){
                countval2++;
            }
        }
        if(countval1>arr.length/3){
            res.add(val1);
        }
        if(countval2>arr.length/3){
            res.add(val2);
        }
        
        return res;
    }
   
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> res = majorityElement2(arr);
        System.out.println(res);
    }
}
