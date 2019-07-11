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
public class Windows extends Asset {
   public java.util.Set<User> user = new HashSet<>();
   public Computer computer;

   public PeripheralDeviceDiscovery peripheralDeviceDiscovery;

   public Windows() {
      super();
      AttackStep.allAttackSteps.remove(peripheralDeviceDiscovery);
      peripheralDeviceDiscovery = new PeripheralDeviceDiscovery(this.name);
      assetClassName = "Windows";
   }

   public Windows(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(peripheralDeviceDiscovery);
      peripheralDeviceDiscovery = new PeripheralDeviceDiscovery(this.name);
      assetClassName = "Windows";
   }


   public class PeripheralDeviceDiscovery extends AttackStepMin {
   public PeripheralDeviceDiscovery(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
for (User user_CVcAd : user) {
addExpectedParent(user_CVcAd.userRights);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer.peripheralDeviceDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.peripheralDeviceDiscovery");
      }

   }

      public void addUser(User user) {
         this.user.add(user);
         user.windows = this;
      }

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.windows = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("computer")) {
         return computer.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("user")  && user != null) {
         assets.addAll(user);
         return assets;
      }
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
      assets.addAll(user);
      if (computer != null) {
         assets.add(computer);
      }
      return assets;
   }
}
