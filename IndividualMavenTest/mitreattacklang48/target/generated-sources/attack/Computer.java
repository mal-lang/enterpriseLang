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
   public Firewall firewall;
   public InternalNetwork internalNetwork;
   public java.util.Set<C2Server> c2Server = new HashSet<>();

   public InfectedComputer infectedComputer;
   public UncommonlyUsedPortsConnection uncommonlyUsedPortsConnection;

   public Computer() {
      super();
      AttackStep.allAttackSteps.remove(infectedComputer);
      infectedComputer = new InfectedComputer(this.name);
      AttackStep.allAttackSteps.remove(uncommonlyUsedPortsConnection);
      uncommonlyUsedPortsConnection = new UncommonlyUsedPortsConnection(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(infectedComputer);
      infectedComputer = new InfectedComputer(this.name);
      AttackStep.allAttackSteps.remove(uncommonlyUsedPortsConnection);
      uncommonlyUsedPortsConnection = new UncommonlyUsedPortsConnection(this.name);
      assetClassName = "Computer";
   }


   public class InfectedComputer extends AttackStepMin {
   public InfectedComputer(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
uncommonlyUsedPortsConnection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.infectedComputer");
      }

   }

   public class UncommonlyUsedPortsConnection extends AttackStepMax {
   public UncommonlyUsedPortsConnection(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(infectedComputer);
if (firewall != null) {
addExpectedParent(firewall.uncommonlyUsedPortsLimitation.disable);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (C2Server c2Server_IbDhW : c2Server) {
c2Server_IbDhW.c2Connexion.updateTtc(this, ttc, activeAttackSteps);
}
if (firewall != null) {
firewall.bypassFirewall.updateTtc(this, ttc, activeAttackSteps);
}
if (internalNetwork != null) {
internalNetwork.bypassProxies.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.uncommonlyUsedPortsConnection");
      }

   }

      public void addFirewall(Firewall firewall) {
         this.firewall = firewall;
         firewall.computer.add(this);
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.computer.add(this);
      }

      public void addC2Server(C2Server c2Server) {
         this.c2Server.add(c2Server);
         c2Server.computer.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("firewall")) {
         return firewall.getClass().getName();
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
      }
      if (roleName.equals("c2Server")) {
         for (Object o: c2Server) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("firewall")  && firewall != null) {
         assets.add(firewall);
         return assets;
      }
      if (roleName.equals("internalNetwork")  && internalNetwork != null) {
         assets.add(internalNetwork);
         return assets;
      }
      if (roleName.equals("c2Server")  && c2Server != null) {
         assets.addAll(c2Server);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (firewall != null) {
         assets.add(firewall);
      }
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      assets.addAll(c2Server);
      return assets;
   }
}
