package core;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class Component {
   public List<Component>        subComponents = new ArrayList<>();
   public List<Asset>            assets        = new ArrayList<>();
   public String                 name          = "Anonymous";
   public static List<Component> allComponents = new ArrayList<>();

   public Component(String name) {
      this.name = name;
      allComponents.add(this);
   }

   public Component() {
      this("Anonymous");
   }

   public static List<Component> getComponents(String className) {
      List<Component> allComponentsOfClass = new ArrayList<>();
      try {
         Class<?> cls = Class.forName("oldComponentsOnlyGoodForExistingTestCases." + className);
         
         for (Component component : Component.allComponents) {
            if (cls.isAssignableFrom(component.getClass())) {
               allComponentsOfClass.add(component);
            }
         }
      }
      catch (Exception e) {
         assertTrue("Can't find component called " + className + ".", false);
      }
      return allComponentsOfClass;
   }

}
