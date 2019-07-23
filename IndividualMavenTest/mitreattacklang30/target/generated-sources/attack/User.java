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
public class User extends Asset {
   public java.util.Set<Service> service = new HashSet<>();
   public InternalNetwork internalNetwork;

   public UserRights userRights;

   public User() {
      super();
      AttackStep.allAttackSteps.remove(userRights);
      userRights = new UserRights(this.name);
      assetClassName = "User";
   }

   public User(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(userRights);
      userRights = new UserRights(this.name);
      assetClassName = "User";
   }


   public class UserRights extends AttackStepMin {
   public UserRights(String name) {
      super(name);
      assetClassName = "User";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (internalNetwork != null) {
internalNetwork.usertransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
for (Service service_AVWoA : service) {
service_AVWoA.usertransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("User.userRights");
      }

   }

      public void addService(Service service) {
         this.service.add(service);
         service.user.add(this);
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.user.add(this);
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
