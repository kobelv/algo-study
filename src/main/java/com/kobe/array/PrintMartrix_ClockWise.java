package com.kobe.array;

public class PrintMartrix_ClockWise {

    public static void main(String[] args) {

        //int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},
          //     {11,12,13,14,15}};

    int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},
            {10,11,12},{13,14,15}};
        printCircle(matrix);
    }


    public static void printCircle(int[][] arr){
        if(arr == null){
            System.out.println("invalid input.");
        }

        int colNum = arr[0].length;
        int rowNum = arr.length;
        int top = 0, left = 0, down = rowNum-1, right = colNum-1;

        while(top <= down && left <= right){

            //left--right
            for(int i=left; i<=right; i++){
                System.out.print(arr[top][i] + " ");
            }

            //top--down
            for(int i=top+1; i<=down; i++){
                System.out.print(arr[i][right] + " ");
            }

            if(left < right && top < down){
                //right--left
                for(int i=right-1; i>=left; i--){
                    System.out.print(arr[down][i] + " ");
                }

                //down--up
                for(int i=down-1; i>top; i--){
                    System.out.print(arr[i][left] + " ");
                }
            }

            top++;
            left++;
            right--;
            down--;
        }

    }
}
