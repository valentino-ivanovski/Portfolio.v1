import com.sun.source.tree.ArrayAccessTree;

import java.util.*;
public class project {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the size of the array: ");
        int n=scan.nextInt();
        int[] a1=new int[n];

        for (int i=0; i<a1.length; i++){
            a1[i]=scan.nextInt();           //giving values to each element in the array
        }

        System.out.println("Values entered: " + Arrays.toString(a1));

        reversearray(a1, n);

        System.out.println();

        System.out.println("Number of elements ✨ " + a1.length);

        System.out.println("Number of different numbers in the array: " + differentel(a1));

        System.out.println("Number of even numbers: " + even(a1));

        System.out.println("Number of odd numbers: " + odd(a1));

        frequency(a1);

        System.out.println("The number that occurs the most is: " + mostOccurrence(a1));

        System.out.println("Largest number in the array: " + largest(a1) );

        System.out.println("Second smallest number is: " + secondsmallest(a1));

        System.out.println("The average of all the numbers is: " + average(a1));

        System.out.println("Standard deviation of the numbers: " + deviation(a1));

        if(a1.length % 2 != 0) {
            System.out.println("The median number is: " + medianodd(a1));
        }
        else{
            System.out.println("The median of the number is: " + medianeven(a1) + " (The sum of both middle numbers divided by two.)");
        }

        System.out.println("The sum of all numbers is: " + sum(a1));

        System.out.println("Number of palindromes: " + countPalindromicDigits(a1));

        System.out.println("Largest palindrome smaller than largest number is: " + largestPalindrome(a1));



    }//mainend

    public static int differentel (int[] a) {
        int count = 1;
        Arrays.sort(a);                     //we sort the array, so we can use the if statement
        for (int i = 0; i < a.length-1; i++)//we do -1 on length because array starting from 0 and when the loop goes to the a.length for a[i+1], it would
        {                                   //exceed its value by 1. the counter starts from 1 because we have the first element, and it is logical that it starts from 1.
            if(a[i] != a[i+1]){             //we check if the values of first element and the one after it are the same and if they are distinct, we add one to the counter.
                count++;
            }
        }
        return count;                       //we return the number of distinct elements in the array.
    }

    public static int even (int[] a) {
        int count=0;
        for (int i=0; i<a.length; i++){
            if(a[i]%2==0)               //we do an "if" statement that checks the module of the array element.
                count++;                //if the module of the element is 0, then the number is even, and we return it.
        }
        return count;
    }

    public static int odd (int[] a){
        int count=0;
        for (int i=0; i<a.length; i++){   //very similar to the even program, just one small change in the if statement, if the module of 2 of the number is not equal to 0.
            if(a[i]%2!=0)
                count++;
        }
        return count;
    }

    public static void frequency (int[] a){
        Arrays.sort(a);
        float count=1;                          //we start the counter from 1 because the first number already exists, so we continue from it onward.
        for (int i=0; i<a.length-1; i++){
            if(a[i] == a[i+1]){                 //if te first number in the array is the same as the next one, then we add one into the counter.
                count++;
            }                                   //then when we spot a distinct number, we print out the number of occurrences of the first number divided by its length. That's how we get the percentage.
            else{                               //after that we just reset the counter back to 1 to check for the next number. if the next number only occurs once, then the counter is unchanged and is being divided by the length.
                System.out.println("The number " + a[i] + " appears in the array this much: " + count/a.length * 100 + "%");
                count=1;
            }
        }                                       //because the for loop goes until a.length-2, and it is i<a.length and not i<=a.length, we have to print the last element of the array separately.
        System.out.println("The number " + a[a.length-1] + " appears in the array this much: " + count/a.length * 100 + "%");
    }

    public static int mostOccurrence(int[] a) {
        Arrays.sort(a);
        int count = 1;
        int count1=1;
        int mostAppeared = a[0];
        for (int i = 0; i < (a.length - 1); i++) { //first, we sort the array.
            if (a[i]==a[i+1]) { //then, it checks if the first number is the same as the next, if it is, then it counts 1 and is stored in count1.
                count1++;       //and then it checks if count1 is bigger than count, and if it is the value of count is the same as count1.
            }                   //then when there is another different number, the count1 variable resets and is counted again if there are same numbers
            else{               //and then that count1 is being compared to count, which is equal to the value of the first couple of numbers,
                count1=1;       //and if the new count1 is bigger than count, then that number is the most frequent one.
            }
            if (count1 > count) {
                mostAppeared = a[i+1];
                count = count1;
            }
        }
        return mostAppeared;
    }

    public static int largest (int[] a){
        int large=a[0];                    //this variable starts from the first element in the array, and it checks if every next element
        for (int i=0; i<a.length; i++){    //is smaller than the initial one. if it is, then the large variable gets the value of the element that was larger than the initial one.
            if (large<a[i]){
                large=a[i];
            }
        }
        return large;
    }

    public static int secondsmallest (int[] a) {
        Arrays.sort(a);                             //here, we sort the array, and tell the for loop to go decrease from the highest number down to the lowest.
        int number = 0;                             //i starts from a.length-1 because example if a.length was 5, i would go from 0 to 5, which are 6 elements, and that is out of bounds
        for (int i = a.length-1; i > 0; i--) {      //i > 0 because we have a[i-1] on the next line which checks for the smallest number
            if(a[i]!=a[i-1]) {                      //the for loop stops at the second to last number, and then it is checked if it is distinct from the last number.
                number = a[i];                      //we do the if statement in oder to avoid certain errors by entering repeating numbers, for example when we enter 1, 1, 1, 2 , 2.
            }
        }
        return number;
    }

    public static float average (int[] a){
        float sum=0;
        float avrg=0;                       //this program is self-explanatory.
        for (int i=0; i<a.length; i++){
            sum+=a[i];
            avrg= sum/a.length;
        }
        return avrg;
    }

    public static double deviation (int[] a){
        double sum=0;
        double dev=0;
        double length=a.length;
        for (int i=0; i<a.length; i++){                  //over here, we basically created the formula for standard deviation.
            sum+=((a[i]-average(a))*(a[i]-average(a)));  //to cut ourselves some slack, we just used the previously made average method in the formula.
            dev=Math.sqrt(sum/length);                   //here we use the math.sqrt method, to find the root of the sum/length.
        }
        return dev;
    }

    public static int medianodd (int[] a) {
        Arrays.sort(a);
        int med = 0;                        //in order to find the median number, we have to sort the array first.
        int length = a.length;              //this is relatively easy to achieve if the length of the array is odd.
        int replace=0;
        for (int i=1; i<a.length; i++){
            med = (length / 2);
            replace=a[med];
        }
        return replace;
    }

    public static float medianeven (int[] a) {
        Arrays.sort(a);
        int med=0;                              //since the length of the array is even, we have to find the two middle numbers,
        float median=0;                         //sum them up, and then divide them by 2. that is how we get the average of those two numbers, which is the median of the even array.
        int length = (a.length-1);
        float mediann=0;
        for (int i=1; i<a.length; i++){
            med = length/2;
            median=(a[med]+a[med+1]);
            mediann=median/2;
        }
        return mediann;
    }

    public static int sum (int[] a){
        int sum1=0;
        for (int i=0; i<a.length; i++){     //this program is self-explanatory
            sum1+=a[i];
        }
        return sum1;
    }

    public static int reverse (int a){
        int reverse = 0;
        while (a > 0) {
            int d = a % 10;
            reverse = reverse * 10 + d;     //in order to check if a number is a palindrome, we have to create a method that will define a palindrome.
            a = a / 10;                     //we do that by the help of a while loop, where we do a module of 10 on the number to get the first digit of the palindrome,
        }                                   //then we multiply reverse with 10 (that would be 0 because reverse has an initial value of 0) and add the first digit from the palindrome.
        return reverse;                     //then we divide the number by 10, so we can remove the last digit. in the next iteration, reverse is for example 4, and then we get 40, then add up the second number, and we start building the palindrome.
    }

    public static boolean checkifpalindrome (int a){
        return (a==reverse(a));                  //this method simply checks if the number is a palindrome. ust to cut some typing in the next methods.
    }

    public static int countPalindromicDigits(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (checkifpalindrome(a[i])) {  //over here we check if the number is a palindrome, thanks to our previously created methods, and if so then we add 1 to the counter.
                sum++;
            }
        }
        return sum;
    }

    public static int largestPalindrome (int[] a){
        Arrays.sort(a);
        int number=0;
        int number1=0;
        for(int i=0; i<a.length-1; i++){
            if (checkifpalindrome(a[i]))
                number=a[i];
            if (checkifpalindrome(a[i+1]))      //this is basically checking the biggest palindrome, similar to the largest method above, but it stops at the second to last number of the array.
                number1=a[i+1];                 //of course this will only work if the array is sorted.
            if (number<number1 && number1 < a[a.length-1]) //it's a.length-1 because array starts from 0.
                number = number1;
        }
        return number;
    }

    public static void reversearray (int[] a, int n) {
        System.out.print("Array reversed: ");
        for (int i = n-1; i >= 0; i--) {
            if(i==n-1){
                System.out.print("["+a[i]+", ");
            }
            if(i<n-1 && i!=0) {
                System.out.print(a[i] + ", ");  //over here we reverse the array thanks to a for loop, and we write ", " if the index is not 0. (not 0 because the array is reversed.)
            }
            if(i==0){
                System.out.print(a[i] + "]");
            }
        }
    }
}



