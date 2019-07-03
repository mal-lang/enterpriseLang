package attack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertTrue;

import core.Asset;
import core.AttackStep;
import core.AttackStepMax;
import core.AttackStepMin;
import core.Defense;
public class Administrator extends Asset {
   public java.util.Set<OS> os = new HashSet<>();

   public AdminRights adminRights;

   public Administrator() {
      super();
      AttackStep.allAttackSteps.remove(adminRights);
      adminRights = new AdminRights(this.name);
      assetClassName = "Administrator";
   }

   public Administrator(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(adminRights);
      adminRights = new AdminRights(this.name);
      assetClassName = "Administrator";
   }


   public class AdminRights extends AttackStepMin {
   public AdminRights(String name) {
      super(name);
      assetClassName = "Administrator";
   }
@Override
public void setExpectedParents() {
for (OS oS_AqMbt : os) {
addExpectedParent(oS_AqMbt.processInjection);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Administrator.adminRights");
      }

   }

      public void addOs(OS os) {
         this.os.add(os);
         os.administrator = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("os")) {
         for (Object o: os) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("os")  && os != null) {
         assets.addAll(os);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(os);
      return assets;
   }
}
