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
public class Computer extends Asset {
   public User user;

   public UploadRemoteFile uploadRemoteFile;
   public DownloadRemoteFile downloadRemoteFile;
   public NetworkIntrusionDetection networkIntrusionDetection;

   public Computer(Boolean networkIntrusionDetectionState) {
      super();
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      AttackStep.allAttackSteps.remove(uploadRemoteFile);
      uploadRemoteFile = new UploadRemoteFile(this.name);
      AttackStep.allAttackSteps.remove(downloadRemoteFile);
      downloadRemoteFile = new DownloadRemoteFile(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name, Boolean networkIntrusionDetectionState) {
      super(name);
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      AttackStep.allAttackSteps.remove(uploadRemoteFile);
      uploadRemoteFile = new UploadRemoteFile(this.name);
      AttackStep.allAttackSteps.remove(downloadRemoteFile);
      downloadRemoteFile = new DownloadRemoteFile(this.name);
      assetClassName = "Computer";
   }

   public Computer() {
      this(false);
      assetClassName = "Computer";
   }

   public Computer(String name) {
      this(name, false);
      assetClassName = "Computer";
   }


   public class UploadRemoteFile extends AttackStepMax {
   public UploadRemoteFile(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(networkIntrusionDetection.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.uploadRemoteFile");
      }

   }

   public class DownloadRemoteFile extends AttackStepMax {
   public DownloadRemoteFile(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(networkIntrusionDetection.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.downloadRemoteFile");
      }

   }

   public class NetworkIntrusionDetection extends Defense {
   public NetworkIntrusionDetection(String name, Boolean enabled) {
      super(name);
      defaultValue = enabled;
      disable = new Disable(name);
   }

   public class Disable extends AttackStepMin {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "computer.networkIntrusionDetection";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
uploadRemoteFile.updateTtc(this, ttc, activeAttackSteps);
downloadRemoteFile.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addUser(User user) {
         this.user = user;
         user.computer = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         return user.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("user")  && user != null) {
         assets.add(user);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (user != null) {
         assets.add(user);
      }
      return assets;
   }
}
