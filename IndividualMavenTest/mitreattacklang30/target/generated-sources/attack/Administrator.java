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
   public java.util.Set<Service> service = new HashSet<>();
   public InternalNetwork internalNetwork;

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
if (internalNetwork != null) {
internalNetwork.admintransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
for (Service service_YyPim : service) {
service_YyPim.admintransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Administrator.adminRights");
      }

   }

      public void addService(Service service) {
         this.service.add(service);
         service.administrator.add(this);
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.administrator.add(this);
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
