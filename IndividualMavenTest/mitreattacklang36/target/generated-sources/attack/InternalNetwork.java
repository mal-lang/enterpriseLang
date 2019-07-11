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
public class InternalNetwork extends Asset {
   public java.util.Set<Computer> computer = new HashSet<>();
   public java.util.Set<User> user = new HashSet<>();

   public ExchangeServerCollection exchangeServerCollection;
   public DataEncryption dataEncryption;
   public TwoFactorsAuthentication twoFactorsAuthentication;

   public InternalNetwork(Boolean dataEncryptionState, Boolean twoFactorsAuthenticationState) {
      super();
      if (dataEncryption != null) {
         AttackStep.allAttackSteps.remove(dataEncryption.disable);
      }
      Defense.allDefenses.remove(dataEncryption);
      dataEncryption = new DataEncryption(this.name, dataEncryptionState);
      if (twoFactorsAuthentication != null) {
         AttackStep.allAttackSteps.remove(twoFactorsAuthentication.disable);
      }
      Defense.allDefenses.remove(twoFactorsAuthentication);
      twoFactorsAuthentication = new TwoFactorsAuthentication(this.name, twoFactorsAuthenticationState);
      AttackStep.allAttackSteps.remove(exchangeServerCollection);
      exchangeServerCollection = new ExchangeServerCollection(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name, Boolean dataEncryptionState, Boolean twoFactorsAuthenticationState) {
      super(name);
      if (dataEncryption != null) {
         AttackStep.allAttackSteps.remove(dataEncryption.disable);
      }
      Defense.allDefenses.remove(dataEncryption);
      dataEncryption = new DataEncryption(this.name, dataEncryptionState);
      if (twoFactorsAuthentication != null) {
         AttackStep.allAttackSteps.remove(twoFactorsAuthentication.disable);
      }
      Defense.allDefenses.remove(twoFactorsAuthentication);
      twoFactorsAuthentication = new TwoFactorsAuthentication(this.name, twoFactorsAuthenticationState);
      AttackStep.allAttackSteps.remove(exchangeServerCollection);
      exchangeServerCollection = new ExchangeServerCollection(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork() {
      this(false, false);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name) {
      this(name, false, false);
      assetClassName = "InternalNetwork";
   }


   public class ExchangeServerCollection extends AttackStepMax {
   public ExchangeServerCollection(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (User user_SXQUo : user) {
addExpectedParent(user_SXQUo.userCredentials);
}
addExpectedParent(dataEncryption.disable);
addExpectedParent(twoFactorsAuthentication.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_WpWar : computer) {
computer_WpWar.dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.exchangeServerCollection");
      }

   }

   public class DataEncryption extends Defense {
   public DataEncryption(String name, Boolean enabled) {
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
            return "internalNetwork.dataEncryption";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exchangeServerCollection.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class TwoFactorsAuthentication extends Defense {
   public TwoFactorsAuthentication(String name, Boolean enabled) {
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
            return "internalNetwork.twoFactorsAuthentication";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exchangeServerCollection.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.internalNetwork = this;
      }

      public void addUser(User user) {
         this.user.add(user);
         user.internalNetwork = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("computer")) {
         for (Object o: computer) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
      if (roleName.equals("user")  && user != null) {
         assets.addAll(user);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(computer);
      assets.addAll(user);
      return assets;
   }
}
