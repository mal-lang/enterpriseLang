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
public class VideoCallApplication extends Service {
   public Computer computer;

   public CollectVideo collectVideo;

   public VideoCallApplication(Boolean dataEncryptedState, Boolean secureCommunicationState, Boolean whitelistingState, Boolean softwareUpdatedState, Boolean sandboxingState) {
      super(dataEncryptedState, secureCommunicationState, whitelistingState, softwareUpdatedState, sandboxingState);
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
      AttackStep.allAttackSteps.remove(collectVideo);
      collectVideo = new CollectVideo(this.name);
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
      assetClassName = "VideoCallApplication";
   }

   public VideoCallApplication(String name, Boolean dataEncryptedState, Boolean secureCommunicationState, Boolean whitelistingState, Boolean softwareUpdatedState, Boolean sandboxingState) {
      super(name, dataEncryptedState, secureCommunicationState, whitelistingState, softwareUpdatedState, sandboxingState);
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
      AttackStep.allAttackSteps.remove(collectVideo);
      collectVideo = new CollectVideo(this.name);
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
      assetClassName = "VideoCallApplication";
   }

   public VideoCallApplication() {
      this(false, false, false, false, false);
      assetClassName = "VideoCallApplication";
   }

   public VideoCallApplication(String name) {
      this(name, false, false, false, false, false);
      assetClassName = "VideoCallApplication";
   }


   public class CollectVideo extends AttackStepMin {
   public CollectVideo(String name) {
      super(name);
      assetClassName = "VideoCallApplication";
   }
@Override
public void setExpectedParents() {
if (computer != null) {
addExpectedParent(computer.videoCallApplicationExists.disable);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer._collectVideo.updateTtc(this, ttc, activeAttackSteps);
}
}
   }

   public class UsertransmittedDataManipulation extends Service.UsertransmittedDataManipulation {
   public UsertransmittedDataManipulation(String name) {
      super(name);
      assetClassName = "VideoCallApplication";
   }
   }

   public class AdmintransmittedDataManipulation extends Service.AdmintransmittedDataManipulation {
   public AdmintransmittedDataManipulation(String name) {
      super(name);
      assetClassName = "VideoCallApplication";
   }
   }

   public class DataEncrypted extends Service.DataEncrypted {
   public DataEncrypted(String name, Boolean enabled) {
      super(name, enabled);
      disable = new Disable(name);
   }

   public class Disable extends Service.DataEncrypted.Disable {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "videoCallApplication.dataEncrypted";
         }
   }
}

   public class SecureCommunication extends Service.SecureCommunication {
   public SecureCommunication(String name, Boolean enabled) {
      super(name, enabled);
      disable = new Disable(name);
   }

   public class Disable extends Service.SecureCommunication.Disable {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "videoCallApplication.secureCommunication";
         }
   }
}

   public class RemoteAccessTools extends Service.RemoteAccessTools {
   public RemoteAccessTools(String name) {
      super(name);
      assetClassName = "VideoCallApplication";
   }
   }

   public class Whitelisting extends Service.Whitelisting {
   public Whitelisting(String name, Boolean enabled) {
      super(name, enabled);
      disable = new Disable(name);
   }

   public class Disable extends Service.Whitelisting.Disable {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "videoCallApplication.whitelisting";
         }
   }
}

   public class ExploitationForDefenseEvasion extends Service.ExploitationForDefenseEvasion {
   public ExploitationForDefenseEvasion(String name) {
      super(name);
      assetClassName = "VideoCallApplication";
   }
   }

   public class _exploitationForDefenseEvasion extends Service._exploitationForDefenseEvasion {
   public _exploitationForDefenseEvasion(String name) {
      super(name);
      assetClassName = "VideoCallApplication";
   }
   }

   public class SoftwareUpdated extends Service.SoftwareUpdated {
   public SoftwareUpdated(String name, Boolean enabled) {
      super(name, enabled);
      disable = new Disable(name);
   }

   public class Disable extends Service.SoftwareUpdated.Disable {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "videoCallApplication.softwareUpdated";
         }
   }
}

   public class Sandboxing extends Service.Sandboxing {
   public Sandboxing(String name, Boolean enabled) {
      super(name, enabled);
      disable = new Disable(name);
   }

   public class Disable extends Service.Sandboxing.Disable {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "videoCallApplication.sandboxing";
         }
   }
}

   public class BypassAntivirus extends Service.BypassAntivirus {
   public BypassAntivirus(String name) {
      super(name);
      assetClassName = "VideoCallApplication";
   }
   }

   public class BypassSystemAccessControls extends Service.BypassSystemAccessControls {
   public BypassSystemAccessControls(String name) {
      super(name);
      assetClassName = "VideoCallApplication";
   }
   }

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.videoCallApplication.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("computer")) {
         return computer.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("computer")  && computer != null) {
         assets.add(computer);
         return assets;
      }
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
      if (computer != null) {
         assets.add(computer);
      }
      assets.addAll(user);
      assets.addAll(administrator);
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
