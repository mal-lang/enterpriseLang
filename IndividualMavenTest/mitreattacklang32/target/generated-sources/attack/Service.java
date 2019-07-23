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
public class Service extends Asset {
   public java.util.Set<User> user = new HashSet<>();
   public C2Server c2Server;
   public InternalNetwork internalNetwork;

   public RemoteAccessTools remoteAccessTools;
   public Whitelisting whitelisting;

   public Service(Boolean whitelistingState) {
      super();
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(remoteAccessTools);
      remoteAccessTools = new RemoteAccessTools(this.name);
      assetClassName = "Service";
   }

   public Service(String name, Boolean whitelistingState) {
      super(name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(remoteAccessTools);
      remoteAccessTools = new RemoteAccessTools(this.name);
      assetClassName = "Service";
   }

   public Service() {
      this(false);
      assetClassName = "Service";
   }

   public Service(String name) {
      this(name, false);
      assetClassName = "Service";
   }


   public class RemoteAccessTools extends AttackStepMin {
   public RemoteAccessTools(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
for (User user_OwquL : user) {
addExpectedParent(user_OwquL.userRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (internalNetwork != null) {
internalNetwork.c2Connexion.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service.remoteAccessTools");
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
            return "service.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
remoteAccessTools.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addUser(User user) {
         this.user.add(user);
         user.service.add(this);
      }

      public void addC2Server(C2Server c2Server) {
         this.c2Server = c2Server;
         c2Server.service.add(this);
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.service.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("c2Server")) {
         return c2Server.getClass().getName();
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
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
      if (roleName.equals("c2Server")  && c2Server != null) {
         assets.add(c2Server);
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
      assets.addAll(user);
      if (c2Server != null) {
         assets.add(c2Server);
      }
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
