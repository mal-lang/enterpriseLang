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
   public java.util.Set<Microphone> microphone = new HashSet<>();

   public MicrophoneExists microphoneExists;
   public CollectAudio collectAudio;
   public Whitelisting whitelisting;
   public DataCollected dataCollected;

   public Computer(Boolean whitelistingState) {
      super();
      if (microphoneExists != null) {
         AttackStep.allAttackSteps.remove(microphoneExists.disable);
      }
      Defense.allDefenses.remove(microphoneExists);
      microphoneExists = new MicrophoneExists(this.name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(collectAudio);
      collectAudio = new CollectAudio(this.name);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name, Boolean whitelistingState) {
      super(name);
      if (microphoneExists != null) {
         AttackStep.allAttackSteps.remove(microphoneExists.disable);
      }
      Defense.allDefenses.remove(microphoneExists);
      microphoneExists = new MicrophoneExists(this.name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(collectAudio);
      collectAudio = new CollectAudio(this.name);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
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


   public class MicrophoneExists extends Defense {
   public MicrophoneExists(String name) {
      super(name);
      disable = new Disable(name);
   }

   @Override
   public boolean isEnabled() {
      return microphone.isEmpty();
   }
   public class Disable extends AttackStepMin {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "computer.microphoneExists";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Microphone microphone_bVxgA : microphone) {
microphone_bVxgA.collectAudio.updateTtc(this, ttc, activeAttackSteps);
}
}
   }
}

   public class CollectAudio extends AttackStepMax {
   public CollectAudio(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(whitelisting.disable);
for (Microphone microphone_YMNDN : microphone) {
addExpectedParent(microphone_YMNDN.collectAudio);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.collectAudio");
      }

   }

   public class Whitelisting extends Defense {
   public Whitelisting(String name, Boolean enabled) {
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
            return "computer.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
collectAudio.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class DataCollected extends AttackStepMin {
   public DataCollected(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(collectAudio);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataCollected");
      }

   }

      public void addUser(User user) {
         this.user = user;
         user.computer = this;
      }

      public void addMicrophone(Microphone microphone) {
         this.microphone.add(microphone);
         microphone.computer = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         return user.getClass().getName();
      }
      if (roleName.equals("microphone")) {
         for (Object o: microphone) {
            return o.getClass().getName();
         }
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
      if (roleName.equals("microphone")  && microphone != null) {
         assets.addAll(microphone);
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
      assets.addAll(microphone);
      return assets;
   }
}
