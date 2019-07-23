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
   public java.util.Set<Service> service = new HashSet<>();
   public InternalNetwork internalNetwork;

   public C2Connected c2Connected;

   public C2Server() {
      super();
      AttackStep.allAttackSteps.remove(c2Connected);
      c2Connected = new C2Connected(this.name);
      assetClassName = "C2Server";
   }

   public C2Server(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(c2Connected);
      c2Connected = new C2Connected(this.name);
      assetClassName = "C2Server";
   }


   public class C2Connected extends AttackStepMin {
   public C2Connected(String name) {
      super(name);
      assetClassName = "C2Server";
   }
@Override
public void setExpectedParents() {
if (internalNetwork != null) {
addExpectedParent(internalNetwork.c2Connexion);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("C2Server.c2Connected");
      }

   }

      public void addService(Service service) {
         this.service.add(service);
         service.c2Server = this;
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.c2Server = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("service")) {
         for (Object o: service) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("service")  && service != null) {
         assets.addAll(service);
         return assets;
      }
      if (roleName.equals("internalNetwork")  && internalNetwork != null) {
         assets.add(internalNetwork);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(service);
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
