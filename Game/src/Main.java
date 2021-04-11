import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] input = br.readLine().split(" ");
      long x = Long.parseLong(input[0]);
      long y = Long.parseLong(input[1]);
      long z;
      int result = -1;
      z = (y * 100) / x;

      if (z >= 99) {
         result = -1;
      } else {
         int start = 0;
         int end = (int) x;
         
         while (end >= start) {
            int mid = (end + start) / 2;
            double tmp = ((y + mid) * 100) / (x + mid);

            if (tmp > z) {
               end = mid - 1;
            } else {
               start = mid + 1;
            }
         }
         result = start;
      }

      System.out.println(result);
   }
}
