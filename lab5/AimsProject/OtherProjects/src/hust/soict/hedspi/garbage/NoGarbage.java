package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws Exception {
        String filename = "E:/OOPLab/OOP.Lab.20242.20235795.ToMinhNghia/lab3/OtherProjects/src/hust/soict/hedspi/garbage/test";
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        StringBuffer outputBuffer = new StringBuffer();

        long start = System.currentTimeMillis();
        for (byte b : inputBytes) {
            outputBuffer.append((char) b);
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time (StringBuffer): " + (end - start) + "ms");
    }
}
