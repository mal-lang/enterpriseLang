package core;

import java.util.HashSet;
import java.util.Random;

public class AnySet<E> extends HashSet<E> {
    
   private static final long serialVersionUID = 4652143016700815479L;
   Random random = new Random();

   public E any() {
      int i = 0;
      int iSelectedObject = random.nextInt(this.size());
      for (E object : this) {
         // System.out.println("i = " + Integer.toString(i) + " of " +
         // Integer.toString(this.size()) + ". Stopping at " +
         // Integer.toString(iSelectedObject));
         if (i <= iSelectedObject) {
            return object;
         }
         i++;
      }
      return null;
   }

}
