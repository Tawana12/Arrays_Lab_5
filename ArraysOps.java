
import java.util.Arrays;
import java.util.Scanner;
public class ArraysOps{
    public static void main(String[] args) {
        int[] numbers = {2,5,8,3,4,6,10,15,20,1,11};

        int index = 0;
        int searchNum;
        Scanner scanner = new Scanner(System.in);


        System.out.println("Original Array: " + Arrays.toString(numbers));   

        // Task 1
        System.out.print("Enter number to see index: ");
        searchNum = scanner.nextInt();


        for(int i = 0; i < numbers.length; i++){
            if (searchNum == numbers[i]){
                System.out.println("The index of "  + searchNum + " is " + i);
                break;
            }
        }


        // Task 2 - Swap numbers 

        System.out.println("Let's swap two numbers a and b: ");
    
        System.out.print("Enter the first number a: ");
        int a = scanner.nextInt();
        
        System.out.print("Enter the second number b: ");
        int b = scanner.nextInt();

        int firstIndex = -1, secondIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == a){
                firstIndex = i;
            }
            if (numbers[i] == b){
                secondIndex = i;
            }
        }
        if (firstIndex != -1 && secondIndex != -1){
            numbers[firstIndex] = b;
            numbers[secondIndex] = a;
        }

        
        int[] numberAscend = Arrays.copyOf(numbers, numbers.length);
        int[] numbersDescend  = Arrays.copyOf(numbers, numbers.length);
        System.out.println("The updated array is: " + Arrays.toString(numbers));

        for (int i = 0; i < numberAscend.length - 1; i++) {
                for (int j = 0 ; j <  (numberAscend.length - 1) - i; j++) {
                    if (numberAscend[j] > numberAscend[ j + 1] ){
                        index = numberAscend[j];
                        numberAscend[j] =  numberAscend[j + 1];
                        numberAscend[j+1] = index;
                    }
                    if (numbersDescend[j] < numbersDescend[ j + 1] ){
                        index = numbersDescend[j];
                        numbersDescend[j] =  numbersDescend[j + 1];
                        numbersDescend[j+1] = index;

                    }

                }

        }
        System.out.println("Ascending: " + Arrays.toString(numberAscend));
        System.out.println("Descending: " + Arrays.toString(numbersDescend));

        // Task 3 Linear Search Implementation

        System.out.print("Enter a number to lookup using Linear Search: ");
        int numLookup = scanner.nextInt();

        Boolean found = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numLookup == numbers[i]){
                System.out.println(numLookup + " Has been found");
                found = true;
            }
        }
        if (!found){
            System.out.println(numLookup + " Has not been found");

        }
        // Task 4  Binary Search Implementation

        System.out.print("Enter the number you are looking for in Binary Search: ");
        int numSearch = scanner.nextInt();


        Boolean foundBinary = false;
        int lower = 0;
        int higher = numberAscend.length - 1;
        while (lower <= higher){
            int binaryIndex = (lower + higher)/2;
            if (numberAscend[binaryIndex] == numSearch){
            
                foundBinary = true;
                break;
            }
            else{
                if (numSearch > numberAscend[binaryIndex]){
                    lower = binaryIndex + 1;
                    
                }
                else{
                    higher = binaryIndex - 1;
                }
            }
        }
        if (foundBinary){
            System.out.println("Number has been found");
        }
        else{
            System.out.println("Number was not found");
        }
    }
}