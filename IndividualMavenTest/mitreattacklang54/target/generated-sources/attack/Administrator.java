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
   public Computer computer;

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
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer.adminDataEncryptedForImpact.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Administrator.adminRights");
      }

   }

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.administrator.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("computer")) {
         return computer.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("computer")  && computer != null) {
         assets.add(computer);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (computer != null) {
         assets.add(computer);
      }
      return assets;
   }
}
