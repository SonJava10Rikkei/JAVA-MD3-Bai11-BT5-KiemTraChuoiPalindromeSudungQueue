package Palindrome;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    static Stack<String> strStack = new Stack<>();
    static ArrayDeque<String> strQueue = new ArrayDeque<>();

    public static void checkPalidrome(Scanner scanner) {
        System.out.println("Nhập vào chuỗi ký tự: ");
        String str = scanner.nextLine();
        String[] strArray = str.split("");
        System.out.println("After Split strArray: " + Arrays.toString(strArray));
        putValueInStackAnhQueue(strArray);
        boolean flag = checkMatchPalidrome(strArray);
        if (flag)
            System.out.println("Đây là chuỗi Palidrome !");
        else
            System.out.println("Đây không phải là chuỗi Palidrome !");
    }

    private static void putValueInStackAnhQueue(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            strStack.push(strArray[i]);
            strQueue.add(strArray[i]);
        }
    }

    private static boolean checkMatchPalidrome(String[] strArray) {
        boolean flag = true;
        for (int i = 0; i < strArray.length; i++) {
            String stackCharacter = strStack.pop();
            String queueCharacter = strQueue.poll();

            boolean equalsCheck = stackCharacter.equalsIgnoreCase(queueCharacter);
            if (!equalsCheck) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
