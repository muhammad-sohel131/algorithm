package Dynamic_Programming;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sohel
 */
public class LCS {
    static List<String> strings = new ArrayList<>();
    static int matrix[][];
    static int selected[][];
    static void printTheSubsequence(int row, int col){
        if(row == 0 || col == 0){
            return;
        }
        
        if(selected[row][col] == 1){
            printTheSubsequence(row-1,col-1);
            System.out.print(strings.get(0).charAt(row - 1));
        }else {
            if(matrix[row][col - 1] >= matrix[row - 1][col]){
                printTheSubsequence(row,col-1);
            }else {
                printTheSubsequence(row - 1, col);
            }
        }
        
    }
    public static void main(String[] args) {
        String filePath = "C:/Users/Sohel/Desktop/daynamic/lcs.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String str;

            while ((str = reader.readLine()) != null) {
                strings.add(str);
            }

            int lengthOfStrOne = strings.get(0).length();
            int lengthOfStrTwo = strings.get(1).length();
            
            matrix = new int[lengthOfStrOne + 1][lengthOfStrTwo + 1];
            selected = new int[lengthOfStrOne + 1][lengthOfStrTwo + 1];
            for(int i = 0; i <= lengthOfStrOne; i++){
                matrix[i][0] = 0;
            }
            
            for(int i = 0; i <= lengthOfStrTwo; i++){
                matrix[0][i] = 0;
            }
            
            for(int row = 1; row <= lengthOfStrOne; row++){
                for(int col = 1; col <= lengthOfStrTwo; col++){
                    if(strings.get(0).charAt(row - 1) == strings.get(1).charAt(col - 1)){
                        matrix[row][col] = 1 + matrix[row - 1][col - 1];
                        selected[row][col] = 1;
                    }else{
                        matrix[row][col] = Math.max(matrix[row][col - 1], matrix[row - 1][col]);
                    }
                }
            }
          
            System.out.println("LCS = " + matrix[lengthOfStrOne][lengthOfStrTwo]);
            printTheSubsequence(lengthOfStrOne, lengthOfStrTwo);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
