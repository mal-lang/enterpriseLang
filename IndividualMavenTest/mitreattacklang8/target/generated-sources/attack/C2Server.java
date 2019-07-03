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
public class C2Server extends Asset {
   public ExternalNetwork externalNetwork;

   public C2Connexion c2Connexion;
   public ObfuscatedData obfuscatedData;

   public C2Server() {
      super();
      AttackStep.allAttackSteps.remove(c2Connexion);
      c2Connexion = new C2Connexion(this.name);
      AttackStep.allAttackSteps.remove(obfuscatedData);
      obfuscatedData = new ObfuscatedData(this.name);
      assetClassName = "C2Server";
   }

   public C2Server(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(c2Connexion);
      c2Connexion = new C2Connexion(this.name);
      AttackStep.allAttackSteps.remove(obfuscatedData);
      obfuscatedData = new ObfuscatedData(this.name);
      assetClassName = "C2Server";
   }


   public class C2Connexion extends AttackStepMin {
   public C2Connexion(String name) {
      super(name);
      assetClassName = "C2Server";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
obfuscatedData.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("C2Server.c2Connexion");
      }

   }

   public class ObfuscatedData extends AttackStepMax {
   public ObfuscatedData(String name) {
      super(name);
      assetClassName = "C2Server";
   }
@Override
public void setExpectedParents() {
if (externalNetwork != null) {
addExpectedParent(externalNetwork.intrusionDetection.disable);
}
if (externalNetwork != null) {
addExpectedParent(externalNetwork.signatureIdentification.disable);
}
addExpectedParent(c2Connexion);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (externalNetwork != null) {
externalNetwork.bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("C2Server.obfuscatedData");
      }

   }

      public void addExternalNetwork(ExternalNetwork externalNetwork) {
         this.externalNetwork = externalNetwork;
         externalNetwork.c2Server = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("externalNetwork")) {
         return externalNetwork.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("externalNetwork")  && externalNetwork != null) {
         assets.add(externalNetwork);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (externalNetwork != null) {
         assets.add(externalNetwork);
      }
      return assets;
   }
}
