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
   public C2Server c2Server;

   public DataCollected dataCollected;
   public DataSizedTransfer dataSizedTransfer;

   public Computer() {
      super();
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      AttackStep.allAttackSteps.remove(dataSizedTransfer);
      dataSizedTransfer = new DataSizedTransfer(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      AttackStep.allAttackSteps.remove(dataSizedTransfer);
      dataSizedTransfer = new DataSizedTransfer(this.name);
      assetClassName = "Computer";
   }


   public class DataCollected extends AttackStepMin {
   public DataCollected(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataSizedTransfer.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataCollected");
      }

   }

   public class DataSizedTransfer extends AttackStepMin {
   public DataSizedTransfer(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(dataCollected);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (c2Server != null) {
c2Server.dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataSizedTransfer");
      }

   }

      public void addC2Server(C2Server c2Server) {
         this.c2Server = c2Server;
         c2Server.computer = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("c2Server")) {
         return c2Server.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("c2Server")  && c2Server != null) {
         assets.add(c2Server);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (c2Server != null) {
         assets.add(c2Server);
      }
      return assets;
   }
}
