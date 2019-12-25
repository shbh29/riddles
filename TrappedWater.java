/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrappedWater;
import java.io.*;
/**
 *
 * @author krawler
 */
public class TrappedWater {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int noOfTest = Integer.parseInt(br.readLine());
            for(int test = 0; test < noOfTest; test++) {
                int n = Integer.parseInt(br.readLine());
                String[] input = br.readLine().split(" ");
                int[] arr = new int[n];
                for(int e = 0; e < n; e++) {
                    arr[e] = Integer.parseInt(input[e]);
                }
                /**
                 * Pgm for Trapped water units.
                 */
                int wu=0; //water units
                for(int ci = 0; ci < n; ci++) { // loop to calc wu
                    int maxi = getMax(arr, ci);
                    
                    if (maxi != -1) {
                        int sm = arr[maxi] < arr[ci] ? arr[maxi] : arr[ci];
                        int len = maxi - ci + 1;
                        int cost = getCost(arr, sm, ci, maxi);
                        wu += sm * len - cost;
                        ci = maxi - 1;
                    } else {
                        break;
                    }
                }
                System.out.println(wu);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static int getMax(int[] arr, int ci) {
        boolean isAvalange = true; // check avalange
        int maxi = -1;
        int n = arr.length;
        for (int i = ci + 1; i < n; i++) {
            if (isAvalange && arr[i - 1] < arr[i]) { // this runs only once
                isAvalange = false;
                maxi = i;
            }
            if (!isAvalange && arr[maxi] <= arr[i]) { // 
                maxi = i;
                if (arr[maxi] >= arr[ci]) { // break loop if greater than or equal to current element.
                    break;
                }
            }
        }
        return maxi;
    }
    static int getCost(int[] arr, int sm, int ci, int mi) {
        int cost = 0;
        for(int i = mi; i >=ci; i--) {
            cost += arr[i] < sm ? arr[i] : sm;
        }
        return cost;
    }
}
