import java.util.Scanner;
public class Main {

    public static void Merge(int[] Arr,int low,int mid,int high){
        int left = low;
        int right=mid+1;
        int[] temp = new int[high-low+1];
        int k=0;
        while(left<=mid &&right<=high){
            if(Arr[left]<Arr[right]){
                temp[k] = Arr[left];
                k++;
                left++;
            }else{
                temp[k]=Arr[right];
                k++;
                right++;
            }
        }
        while(left<=mid){
            temp[k] = Arr[left];
            k++;
            left++;
        }
        while(right<=high){
            temp[k]=Arr[right];
            k++;
            right++;
        }
        for(int i=0;i<temp.length;i++){
            Arr[low+i] = temp[i];
        }
    }

    public static void MergeSort(int[] Arr, int low,int high){
        if(low>=high){
            return;
        }
        int mid = (low+high)/2;
        MergeSort(Arr,low,mid);
        MergeSort(Arr,mid+1,high);
        Merge(Arr,low,mid,high);
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("enter no of elements : ");
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("enter elements :");
        for(int i=0;i<n;i++){
            arr[i] = input.nextInt();
        }
        int l =0;
        int h = n-1;
        MergeSort(arr,l,h);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }



    }
}