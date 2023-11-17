package AimsProject.src.hust.soict.dsai.aims.garbage;

import java.util.Random;
// Nguyen Manh Hieu 20215050
public class ConcatenationInLoops {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s= "";
        for( int i = 0; i < 65536; i++)
            s +=r.nextInt(2);
            System.out.println(System.currentTimeMillis() - start);
            //this prints roughly 541

            r = new Random(123);
            start = System.currentTimeMillis();
            StringBuilder sb = new StringBuilder();
            int i;
            for (i = 0; i < 65536; i++) sb.append(r.nextInt(2));
            s = sb.toString();
            System.out.println(System.currentTimeMillis() - start);
            // this prints 3.
        }
    
}
