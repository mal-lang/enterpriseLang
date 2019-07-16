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
public class Webcam extends Asset {
   public Computer computer;

   public CollectVideo collectVideo;

   public Webcam() {
      super();
      AttackStep.allAttackSteps.remove(collectVideo);
      collectVideo = new CollectVideo(this.name);
      assetClassName = "Webcam";
   }

   public Webcam(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(collectVideo);
      collectVideo = new CollectVideo(this.name);
      assetClassName = "Webcam";
   }


   public class CollectVideo extends AttackStepMin {
   public CollectVideo(String name) {
      super(name);
      assetClassName = "Webcam";
   }
@Override
public void setExpectedParents() {
if (computer != null) {
addExpectedParent(computer.webcamExists.disable);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer._collectVideo.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Webcam.collectVideo");
      }

   }

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.webcam = this;
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
