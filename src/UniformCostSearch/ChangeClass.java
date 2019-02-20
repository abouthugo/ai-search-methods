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

        System.out.println("Press \n"
                + "1: Greedy Algorithm \n"
                + "2: Dynamic Programming");

        int choice = input.nextInt();

        switch(choice){
            case 1:
                greedyAlgorithim(amount,coins);
                break;
            case 2 :
                dynamicPogrammingAlgorithim(amount,coins);
                break;
        }

        printResult();
    }

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

    public static void printResult(){
        System.out.println("Number of coins = " + resultSet.size());
        for ( int i =0;i<resultSet.size();i++){
            System.out.println(resultSet.get(i));
        }
    }

    public static int dynamicPogrammingAlgorithim(int amount,int[] coins){

        int[] tempArray = new int[amount+1];
        int[] prev = new int[amount+1];
        tempArray[0]=0;
        for(int j=1;j<=amount;j++){
            tempArray[j]=Integer.MAX_VALUE;
            for(int i=0;i<coins.length;i++){
                if(coins[i]<=j && (1+tempArray[j-coins[i]] < tempArray[j]) ){
                    tempArray[j]=1+tempArray[j-coins[i]];
                    prev[j]=coins[i];
                }
            }
        }
        int result = tempArray[amount];
        for(int i=amount;i>=1;){
            resultSet.add(prev[i]);
            int j=i;
            i=amount-prev[i];
            amount = amount - prev[j];
        }
        return resultSet.size();
    }


}
