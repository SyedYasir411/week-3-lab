import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of Students : " );
        int n = input.nextInt();
        int[] arr = new int[n];
        System.out.println("enter marks of the students : ");
        for(int i=0;i<n;i++){
            arr[i]=input.nextInt();
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
    public static void swap(int[] arr,int n1,int n2){
        int temp=arr[n1];
        arr[n1]=arr[n2];
        arr[n2] = temp;
    }
}