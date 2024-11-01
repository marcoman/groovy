// $Id: sumcol.java,v 1.5 2007-06-20 03:32:39 bfulgham Exp $
// http://www.bagley.org/~doug/shootout/

import io.github.pixee.security.BoundedLineReader;
import java.io.*;
import java.util.*;
import java.text.*;

public class sumcol {
   public static void main(String[] args) {
      int sum = 0;
      String line;
      try {
         BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         while ((line = BoundedLineReader.readLine(in, 5_000_000)) != null) {
            sum = sum + Integer.parseInt(line);
         }
      } catch (IOException e) {
         System.err.println(e);
         return;
      }
      System.out.println(Integer.toString(sum));
   }
}
