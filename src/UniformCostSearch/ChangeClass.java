import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Scanner;

public class ChangeClass {

    static ArrayList<Integer> resultSet = new ArrayList<Integer>();

    public static void main(String[] args){

        Scanner input  = new Scanner(System.in);
        int []coins = {1,5,10,25};

        System.out.println("Change Control Algorithim \n\n");

        System.out.println("Enter the amount you want change for: ");
        int amount = input.nextInt();

        greedyAlgorithim(amount,coins);
        
        printResult();
    }
    
//////////////////////////////////////////////////////////////////////////////
    
    public static int greedyAlgorithim(int amount,int[] coins){

        for(int i=coins.length-1; i >= 0 && amount > 0;i--){
            int n = amount / coins[i];
            for(int j=0; j<n; j++){
                amount -=coins[i];
                resultSet.add(coins[i]);
            }
        }
        return resultSet.size();
    }
    
/////////////////////////////////////////////////////////////////////////////////
    
    public static void printResult(){
        System.out.println("Number of coins = " + resultSet.size());
        for ( int i =0;i<resultSet.size();i++){
            System.out.println(resultSet.get(i));
        }
    }


}
