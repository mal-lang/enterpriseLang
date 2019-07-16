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
public class OS extends Asset {
   public Computer computer;

   public UserCommandLineInterface userCommandLineInterface;
   public AdminCommandLineInterface adminCommandLineInterface;

   public OS() {
      super();
      AttackStep.allAttackSteps.remove(userCommandLineInterface);
      userCommandLineInterface = new UserCommandLineInterface(this.name);
      AttackStep.allAttackSteps.remove(adminCommandLineInterface);
      adminCommandLineInterface = new AdminCommandLineInterface(this.name);
      assetClassName = "OS";
   }

   public OS(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(userCommandLineInterface);
      userCommandLineInterface = new UserCommandLineInterface(this.name);
      AttackStep.allAttackSteps.remove(adminCommandLineInterface);
      adminCommandLineInterface = new AdminCommandLineInterface(this.name);
      assetClassName = "OS";
   }


   public class UserCommandLineInterface extends AttackStepMax {
   public UserCommandLineInterface(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer.dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.userCommandLineInterface");
      }

   }

   public class AdminCommandLineInterface extends AttackStepMax {
   public AdminCommandLineInterface(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer.dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.adminCommandLineInterface");
      }

   }

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.os = this;
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
