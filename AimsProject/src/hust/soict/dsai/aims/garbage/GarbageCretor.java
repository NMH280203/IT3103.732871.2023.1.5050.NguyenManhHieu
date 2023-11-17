package AimsProject.src.hust.soict.dsai.aims.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// Nguyen Manh Hieu 20215050
public class GarbageCretor {
    public static void main(String[] args) throws IOException {
        String filename = "test.exe";
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        String outpuString = "";
        for (byte b : inputBytes) {
            outpuString +=(char) b;
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
