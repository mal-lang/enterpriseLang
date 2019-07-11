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
   public java.util.Set<Administrator> administrator = new HashSet<>();

   public UsertransmittedDataManipulation usertransmittedDataManipulation;
   public AdmintransmittedDataManipulation admintransmittedDataManipulation;
   public DataEncrypted dataEncrypted;
   public SecureCommunication secureCommunication;

   public Service(Boolean dataEncryptedState, Boolean secureCommunicationState) {
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
      assetClassName = "Service";
   }

   public Service(String name, Boolean dataEncryptedState, Boolean secureCommunicationState) {
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
      assetClassName = "Service";
   }

   public Service() {
      this(false, false);
      assetClassName = "Service";
   }

   public Service(String name) {
      this(name, false, false);
      assetClassName = "Service";
   }


   public class UsertransmittedDataManipulation extends AttackStepMax {
   public UsertransmittedDataManipulation(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
for (User user_vkOMf : user) {
addExpectedParent(user_vkOMf.userRights);
}
addExpectedParent(dataEncrypted.disable);
addExpectedParent(secureCommunication.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service.usertransmittedDataManipulation");
      }

   }

   public class AdmintransmittedDataManipulation extends AttackStepMax {
   public AdmintransmittedDataManipulation(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
for (Administrator administrator_uSFJk : administrator) {
addExpectedParent(administrator_uSFJk.adminRights);
}
addExpectedParent(dataEncrypted.disable);
addExpectedParent(secureCommunication.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service.admintransmittedDataManipulation");
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
            return "service.dataEncrypted";
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
            return "service.secureCommunication";
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
         user.service.add(this);
      }

      public void addAdministrator(Administrator administrator) {
         this.administrator.add(administrator);
         administrator.service.add(this);
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
