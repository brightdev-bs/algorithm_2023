package baekjoon.string;

import java.util.Scanner;

public class Q1543 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String searchString = sc.nextLine();
//
//        int count = 0;
//        for(int i = 0; i < s.length() - searchString.length() + 1; i++) {
//            if(searchString.equals(s.substring(i, i + searchString.length()))) {
//                count++;
//                i = i + searchString.length() - 1;
//            }
//        }
//
//        System.out.println(count);
//
//    }

    // indexOf를 이용한 풀이
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String searchString = sc.nextLine();
//
//        int startIndex = 0;
//        int count = 0;
//        while(true) {
//            int index = s.indexOf(searchString, startIndex);
//            if(index == -1) break;
//            startIndex = index + searchString.length();
//            count++;
//        }
//
//        System.out.println(count);
//    }

    // replace를 이용한 방법
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dic = sc.nextLine();
        String word = sc.nextLine();

        String replace = dic.replace(word, "");
        System.out.println((dic.length() - replace.length()) / word.length() );
    }
}
