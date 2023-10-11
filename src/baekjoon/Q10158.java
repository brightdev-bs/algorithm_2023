package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Q10158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        int w = Integer.parseInt(temp.split(" ")[0]);
        int h = Integer.parseInt(temp.split(" ")[1]);
        temp = br.readLine();
        int p = Integer.parseInt(temp.split(" ")[0]);
        int q = Integer.parseInt(temp.split(" ")[1]);
        int t = Integer.parseInt(br.readLine());
//        int deltaX = 1;
//        int timeX = t % (2 * w);
//        for(int i = 0; i < timeX; i++) {
//            if(p == w) deltaX = -1;
//            if(p == 0) deltaX = 1;
//            p += deltaX;
//        }
//
//        int deltaY = 1;
//        int timeY = t % (2 * h);
//        for(int i = 0; i < timeY; i++) {
//            if(q == h) deltaY = -1;
//            if(q == 0) deltaY = 1;
//            q += deltaY;
//        }
//
//        System.out.println(p + " " + q);
        int currentX = (p + t) % (2 * w);
        int currentY = (q + t) % (2 * h);
        if(currentX > w) currentX = w - (currentX - w);
        if(currentY > h) currentY = h - (currentY - h);

        StringBuilder sb = new StringBuilder();
        sb.append(currentX).append(" ").append(currentY);
        System.out.println(sb);
    }
}
