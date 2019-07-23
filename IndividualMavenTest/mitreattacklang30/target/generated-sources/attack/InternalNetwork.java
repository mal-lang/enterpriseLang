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
   public java.util.Set<User> user = new HashSet<>();
   public java.util.Set<Administrator> administrator = new HashSet<>();

   public UsertransmittedDataManipulation usertransmittedDataManipulation;
   public AdmintransmittedDataManipulation admintransmittedDataManipulation;
   public DataEncrypted dataEncrypted;
   public SecureCommunication secureCommunication;

   public InternalNetwork(Boolean dataEncryptedState, Boolean secureCommunicationState) {
      super();
      if (dataEncrypted != null) {
         AttackStep.allAttackSteps.remove(dataEncrypted.disable);
      }
      Defense.allDefenses.remove(dataEncrypted);
      dataEncrypted = new DataEncrypted(this.name, dataEncryptedState);
      if (secureCommunication != null) {
         AttackStep.allAttackSteps.remove(secureCommunication.disable);
      }
      Defense.allDefenses.remove(secureCommunication);
      secureCommunication = new SecureCommunication(this.name, secureCommunicationState);
      AttackStep.allAttackSteps.remove(usertransmittedDataManipulation);
      usertransmittedDataManipulation = new UsertransmittedDataManipulation(this.name);
      AttackStep.allAttackSteps.remove(admintransmittedDataManipulation);
      admintransmittedDataManipulation = new AdmintransmittedDataManipulation(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name, Boolean dataEncryptedState, Boolean secureCommunicationState) {
      super(name);
      if (dataEncrypted != null) {
         AttackStep.allAttackSteps.remove(dataEncrypted.disable);
      }
      Defense.allDefenses.remove(dataEncrypted);
      dataEncrypted = new DataEncrypted(this.name, dataEncryptedState);
      if (secureCommunication != null) {
         AttackStep.allAttackSteps.remove(secureCommunication.disable);
      }
      Defense.allDefenses.remove(secureCommunication);
      secureCommunication = new SecureCommunication(this.name, secureCommunicationState);
      AttackStep.allAttackSteps.remove(usertransmittedDataManipulation);
      usertransmittedDataManipulation = new UsertransmittedDataManipulation(this.name);
      AttackStep.allAttackSteps.remove(admintransmittedDataManipulation);
      admintransmittedDataManipulation = new AdmintransmittedDataManipulation(this.name);
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


   public class UsertransmittedDataManipulation extends AttackStepMax {
   public UsertransmittedDataManipulation(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (User user_CKHWG : user) {
addExpectedParent(user_CKHWG.userRights);
}
addExpectedParent(dataEncrypted.disable);
addExpectedParent(secureCommunication.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.usertransmittedDataManipulation");
      }

   }

   public class AdmintransmittedDataManipulation extends AttackStepMax {
   public AdmintransmittedDataManipulation(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Administrator administrator_iaxpV : administrator) {
addExpectedParent(administrator_iaxpV.adminRights);
}
addExpectedParent(dataEncrypted.disable);
addExpectedParent(secureCommunication.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.admintransmittedDataManipulation");
      }

   }

   public class DataEncrypted extends Defense {
   public DataEncrypted(String name, Boolean enabled) {
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
            return "internalNetwork.dataEncrypted";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
usertransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
admintransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class SecureCommunication extends Defense {
   public SecureCommunication(String name, Boolean enabled) {
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
            return "internalNetwork.secureCommunication";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
usertransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
admintransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addUser(User user) {
         this.user.add(user);
         user.internalNetwork = this;
      }

      public void addAdministrator(Administrator administrator) {
         this.administrator.add(administrator);
         administrator.internalNetwork = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("administrator")) {
         for (Object o: administrator) {
            return o.getClass().getName();
         }
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
      if (roleName.equals("administrator")  && administrator != null) {
         assets.addAll(administrator);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(user);
      assets.addAll(administrator);
      return assets;
   }
}
