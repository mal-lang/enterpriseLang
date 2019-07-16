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
   public InternalNetwork internalNetwork;

   public UsertransmittedDataManipulation usertransmittedDataManipulation;
   public AdmintransmittedDataManipulation admintransmittedDataManipulation;
   public DataEncrypted dataEncrypted;
   public SecureCommunication secureCommunication;
   public RemoteAccessTools remoteAccessTools;
   public Whitelisting whitelisting;
   public ExploitationForDefenseEvasion exploitationForDefenseEvasion;
   public _exploitationForDefenseEvasion _exploitationForDefenseEvasion;
   public SoftwareUpdated softwareUpdated;
   public Sandboxing sandboxing;
   public BypassAntivirus bypassAntivirus;
   public BypassSystemAccessControls bypassSystemAccessControls;

   public Service(Boolean dataEncryptedState, Boolean secureCommunicationState, Boolean whitelistingState, Boolean softwareUpdatedState, Boolean sandboxingState) {
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
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (softwareUpdated != null) {
         AttackStep.allAttackSteps.remove(softwareUpdated.disable);
      }
      Defense.allDefenses.remove(softwareUpdated);
      softwareUpdated = new SoftwareUpdated(this.name, softwareUpdatedState);
      if (sandboxing != null) {
         AttackStep.allAttackSteps.remove(sandboxing.disable);
      }
      Defense.allDefenses.remove(sandboxing);
      sandboxing = new Sandboxing(this.name, sandboxingState);
      AttackStep.allAttackSteps.remove(usertransmittedDataManipulation);
      usertransmittedDataManipulation = new UsertransmittedDataManipulation(this.name);
      AttackStep.allAttackSteps.remove(admintransmittedDataManipulation);
      admintransmittedDataManipulation = new AdmintransmittedDataManipulation(this.name);
      AttackStep.allAttackSteps.remove(remoteAccessTools);
      remoteAccessTools = new RemoteAccessTools(this.name);
      AttackStep.allAttackSteps.remove(exploitationForDefenseEvasion);
      exploitationForDefenseEvasion = new ExploitationForDefenseEvasion(this.name);
      AttackStep.allAttackSteps.remove(_exploitationForDefenseEvasion);
      _exploitationForDefenseEvasion = new _exploitationForDefenseEvasion(this.name);
      AttackStep.allAttackSteps.remove(bypassAntivirus);
      bypassAntivirus = new BypassAntivirus(this.name);
      AttackStep.allAttackSteps.remove(bypassSystemAccessControls);
      bypassSystemAccessControls = new BypassSystemAccessControls(this.name);
      assetClassName = "Service";
   }

   public Service(String name, Boolean dataEncryptedState, Boolean secureCommunicationState, Boolean whitelistingState, Boolean softwareUpdatedState, Boolean sandboxingState) {
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
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (softwareUpdated != null) {
         AttackStep.allAttackSteps.remove(softwareUpdated.disable);
      }
      Defense.allDefenses.remove(softwareUpdated);
      softwareUpdated = new SoftwareUpdated(this.name, softwareUpdatedState);
      if (sandboxing != null) {
         AttackStep.allAttackSteps.remove(sandboxing.disable);
      }
      Defense.allDefenses.remove(sandboxing);
      sandboxing = new Sandboxing(this.name, sandboxingState);
      AttackStep.allAttackSteps.remove(usertransmittedDataManipulation);
      usertransmittedDataManipulation = new UsertransmittedDataManipulation(this.name);
      AttackStep.allAttackSteps.remove(admintransmittedDataManipulation);
      admintransmittedDataManipulation = new AdmintransmittedDataManipulation(this.name);
      AttackStep.allAttackSteps.remove(remoteAccessTools);
      remoteAccessTools = new RemoteAccessTools(this.name);
      AttackStep.allAttackSteps.remove(exploitationForDefenseEvasion);
      exploitationForDefenseEvasion = new ExploitationForDefenseEvasion(this.name);
      AttackStep.allAttackSteps.remove(_exploitationForDefenseEvasion);
      _exploitationForDefenseEvasion = new _exploitationForDefenseEvasion(this.name);
      AttackStep.allAttackSteps.remove(bypassAntivirus);
      bypassAntivirus = new BypassAntivirus(this.name);
      AttackStep.allAttackSteps.remove(bypassSystemAccessControls);
      bypassSystemAccessControls = new BypassSystemAccessControls(this.name);
      assetClassName = "Service";
   }

   public Service() {
      this(false, false, false, false, false);
      assetClassName = "Service";
   }

   public Service(String name) {
      this(name, false, false, false, false, false);
      assetClassName = "Service";
   }


   public class UsertransmittedDataManipulation extends AttackStepMax {
   public UsertransmittedDataManipulation(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
for (User user_TVDMe : user) {
addExpectedParent(user_TVDMe.userRights);
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
for (Administrator administrator_BpCZt : administrator) {
addExpectedParent(administrator_BpCZt.adminRights);
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

   public class RemoteAccessTools extends AttackStepMin {
   public RemoteAccessTools(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
for (User user_UZLoC : user) {
addExpectedParent(user_UZLoC.userRights);
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

   public class ExploitationForDefenseEvasion extends AttackStepMin {
   public ExploitationForDefenseEvasion(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
addExpectedParent(softwareUpdated.disable);
addExpectedParent(sandboxing.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_exploitationForDefenseEvasion.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service.exploitationForDefenseEvasion");
      }

   }

   public class _exploitationForDefenseEvasion extends AttackStepMax {
   public _exploitationForDefenseEvasion(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
for (User user_kOZDs : user) {
addExpectedParent(user_kOZDs.userRights);
}
addExpectedParent(exploitationForDefenseEvasion);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
bypassAntivirus.updateTtc(this, ttc, activeAttackSteps);
bypassSystemAccessControls.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service._exploitationForDefenseEvasion");
      }

   }

   public class SoftwareUpdated extends Defense {
   public SoftwareUpdated(String name, Boolean enabled) {
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
            return "service.softwareUpdated";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exploitationForDefenseEvasion.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class Sandboxing extends Defense {
   public Sandboxing(String name, Boolean enabled) {
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
            return "service.sandboxing";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exploitationForDefenseEvasion.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class BypassAntivirus extends AttackStepMin {
   public BypassAntivirus(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
addExpectedParent(_exploitationForDefenseEvasion);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service.bypassAntivirus");
      }

   }

   public class BypassSystemAccessControls extends AttackStepMin {
   public BypassSystemAccessControls(String name) {
      super(name);
      assetClassName = "Service";
   }
@Override
public void setExpectedParents() {
addExpectedParent(_exploitationForDefenseEvasion);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Service.bypassSystemAccessControls");
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
      if (roleName.equals("administrator")) {
         for (Object o: administrator) {
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
      if (roleName.equals("user")  && user != null) {
         assets.addAll(user);
         return assets;
      }
      if (roleName.equals("administrator")  && administrator != null) {
         assets.addAll(administrator);
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
      assets.addAll(administrator);
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
