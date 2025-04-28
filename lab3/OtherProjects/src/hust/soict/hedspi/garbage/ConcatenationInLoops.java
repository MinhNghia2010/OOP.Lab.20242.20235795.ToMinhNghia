package hust.soict.hedspi.garbage;

import java.util.Random;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        String filename = "E:/OOPLab/OOP.Lab.20242.20235795.ToMinhNghia/lab3/OtherProjects/src/hust/soict/hedspi/garbage/test";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("Không thể đọc file: " + e.getMessage());
        }

        Random r = new Random(123);
        startTime = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time using String: " + (endTime - startTime) + " ms");

        r = new Random(123);
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        endTime = System.currentTimeMillis();
        System.out.println("Time using StringBuilder: " + (endTime - startTime) + " ms");
    }
}
