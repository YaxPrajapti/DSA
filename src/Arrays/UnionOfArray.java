package Arrays;

import java.util.ArrayList;

public class UnionOfArray {
    public static void main(String[] args) {
        int[] arr1 = { 1,2,3,4,5 };
        int[] arr2 = { 1,2,3 };
        // int union = doUnion(arr1, arr2);
        // for (int i : union) {
        //     System.out.print(i + " ");
        // }
        // System.out.println(union);
        ArrayList<Integer> union = findUnion(arr1, arr2, arr1.length, arr2.length); 
        System.out.println(union);
    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m){
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (union.size() == 0|| union.get(union.size()-1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;

            } else {
                if (union.size() == 0 || union.get(union.size()-1) != arr2[j]) {
                    union.add(arr2[j]); 
                }
                j++;
            } 
        }
        while (i < n) {
            if (union.size() == 0 || union.get(union.size()-1) != arr1[i]) {
                union.add(arr1[i]); 
            }
            i++;
        }
        while (j < m) {
            if (union.size() == 0 || union.get(union.size()-1) != arr2[j]) {
                union.add(arr2[j]); 
            }
            j++;
        }
        return union;
    }

    public static int doUnion(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] union = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;
        int count = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                if (k == 0 || union[k - 1] != arr1[i]) {
                    union[k] = arr1[i];
                    k++;
                    count = count + 1;
                }
                i++;

            } else if (arr2[j] < arr1[i]) {
                if (k == 0 || union[k - 1] != arr2[j]) {
                    union[k] = arr2[j];
                    k++;
                    count = count + 1;
                }
                j++;
            } else {
                union[k] = arr1[i];
                count++;
                i++;
                j++;
                k++;
            }
        }
        while (i < n1) {
            if (k == 0 || union[k - 1] != arr1[i]) {
                union[k] = arr1[i];
                k++;
                count = count + 1; 
            }
            i++;
        }
        while (j < n2) {
            if (k == 0 || union[k - 1] != arr2[j]) {
                union[k] = arr2[j];
                k++;
                count = count + 1; 
            }
            j++;
        }
        return count;
    }
}
