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
public class Windows extends Asset {
   public User windowsUser;
   public Administrator windowsAdministrator;
   public java.util.Set<WindowsAdmin> windowsAdmin = new HashSet<>();
   public Computer computer;
   public InternalNetwork internalNetwork;

   public CreateService createService;
   public QueryRegistery queryRegistery;
   public NetworkShareDiscovery networkShareDiscovery;
   public UserSecuritySoftwareDiscovery userSecuritySoftwareDiscovery;
   public AdminSecuritySoftwareDiscovery adminSecuritySoftwareDiscovery;
   public Whitelisting whitelisting;
   public ExecuteService executeService;
   public Persistance persistance;
   public Bootkit bootkit;
   public SecureBootProcess secureBootProcess;
   public PeripheralDeviceDiscovery peripheralDeviceDiscovery;
   public EmailStorageCollection emailStorageCollection;
   public OutlookEmailCollection outlookEmailCollection;
   public DataEncryption dataEncryption;
   public VideoCollection videoCollection;
   public ScheduledTask scheduledTask;
   public SystemTimeDiscovery systemTimeDiscovery;

   public Windows(Boolean whitelistingState, Boolean secureBootProcessState, Boolean dataEncryptionState) {
      super();
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (secureBootProcess != null) {
         AttackStep.allAttackSteps.remove(secureBootProcess.disable);
      }
      Defense.allDefenses.remove(secureBootProcess);
      secureBootProcess = new SecureBootProcess(this.name, secureBootProcessState);
      if (dataEncryption != null) {
         AttackStep.allAttackSteps.remove(dataEncryption.disable);
      }
      Defense.allDefenses.remove(dataEncryption);
      dataEncryption = new DataEncryption(this.name, dataEncryptionState);
      AttackStep.allAttackSteps.remove(createService);
      createService = new CreateService(this.name);
      AttackStep.allAttackSteps.remove(queryRegistery);
      queryRegistery = new QueryRegistery(this.name);
      AttackStep.allAttackSteps.remove(networkShareDiscovery);
      networkShareDiscovery = new NetworkShareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(userSecuritySoftwareDiscovery);
      userSecuritySoftwareDiscovery = new UserSecuritySoftwareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(adminSecuritySoftwareDiscovery);
      adminSecuritySoftwareDiscovery = new AdminSecuritySoftwareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(executeService);
      executeService = new ExecuteService(this.name);
      AttackStep.allAttackSteps.remove(persistance);
      persistance = new Persistance(this.name);
      AttackStep.allAttackSteps.remove(bootkit);
      bootkit = new Bootkit(this.name);
      AttackStep.allAttackSteps.remove(peripheralDeviceDiscovery);
      peripheralDeviceDiscovery = new PeripheralDeviceDiscovery(this.name);
      AttackStep.allAttackSteps.remove(emailStorageCollection);
      emailStorageCollection = new EmailStorageCollection(this.name);
      AttackStep.allAttackSteps.remove(outlookEmailCollection);
      outlookEmailCollection = new OutlookEmailCollection(this.name);
      AttackStep.allAttackSteps.remove(videoCollection);
      videoCollection = new VideoCollection(this.name);
      AttackStep.allAttackSteps.remove(scheduledTask);
      scheduledTask = new ScheduledTask(this.name);
      AttackStep.allAttackSteps.remove(systemTimeDiscovery);
      systemTimeDiscovery = new SystemTimeDiscovery(this.name);
      assetClassName = "Windows";
   }

   public Windows(String name, Boolean whitelistingState, Boolean secureBootProcessState, Boolean dataEncryptionState) {
      super(name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (secureBootProcess != null) {
         AttackStep.allAttackSteps.remove(secureBootProcess.disable);
      }
      Defense.allDefenses.remove(secureBootProcess);
      secureBootProcess = new SecureBootProcess(this.name, secureBootProcessState);
      if (dataEncryption != null) {
         AttackStep.allAttackSteps.remove(dataEncryption.disable);
      }
      Defense.allDefenses.remove(dataEncryption);
      dataEncryption = new DataEncryption(this.name, dataEncryptionState);
      AttackStep.allAttackSteps.remove(createService);
      createService = new CreateService(this.name);
      AttackStep.allAttackSteps.remove(queryRegistery);
      queryRegistery = new QueryRegistery(this.name);
      AttackStep.allAttackSteps.remove(networkShareDiscovery);
      networkShareDiscovery = new NetworkShareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(userSecuritySoftwareDiscovery);
      userSecuritySoftwareDiscovery = new UserSecuritySoftwareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(adminSecuritySoftwareDiscovery);
      adminSecuritySoftwareDiscovery = new AdminSecuritySoftwareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(executeService);
      executeService = new ExecuteService(this.name);
      AttackStep.allAttackSteps.remove(persistance);
      persistance = new Persistance(this.name);
      AttackStep.allAttackSteps.remove(bootkit);
      bootkit = new Bootkit(this.name);
      AttackStep.allAttackSteps.remove(peripheralDeviceDiscovery);
      peripheralDeviceDiscovery = new PeripheralDeviceDiscovery(this.name);
      AttackStep.allAttackSteps.remove(emailStorageCollection);
      emailStorageCollection = new EmailStorageCollection(this.name);
      AttackStep.allAttackSteps.remove(outlookEmailCollection);
      outlookEmailCollection = new OutlookEmailCollection(this.name);
      AttackStep.allAttackSteps.remove(videoCollection);
      videoCollection = new VideoCollection(this.name);
      AttackStep.allAttackSteps.remove(scheduledTask);
      scheduledTask = new ScheduledTask(this.name);
      AttackStep.allAttackSteps.remove(systemTimeDiscovery);
      systemTimeDiscovery = new SystemTimeDiscovery(this.name);
      assetClassName = "Windows";
   }

   public Windows() {
      this(false, false, false);
      assetClassName = "Windows";
   }

   public Windows(String name) {
      this(name, false, false, false);
      assetClassName = "Windows";
   }


   public class CreateService extends AttackStepMax {
   public CreateService(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (windowsAdministrator != null) {
addExpectedParent(windowsAdministrator.adminRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
executeService.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.createService");
      }

   }

   public class QueryRegistery extends AttackStepMax {
   public QueryRegistery(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
for (WindowsAdmin windowsAdmin_IuRAx : windowsAdmin) {
addExpectedParent(windowsAdmin_IuRAx.systemRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.queryRegistery");
      }

   }

   public class NetworkShareDiscovery extends AttackStepMax {
   public NetworkShareDiscovery(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (windowsUser != null) {
addExpectedParent(windowsUser.userRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (internalNetwork != null) {
internalNetwork.networkShareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.networkShareDiscovery");
      }

   }

   public class UserSecuritySoftwareDiscovery extends AttackStepMax {
   public UserSecuritySoftwareDiscovery(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (windowsUser != null) {
addExpectedParent(windowsUser.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.userSecuritySoftwareDiscovery");
      }

   }

   public class AdminSecuritySoftwareDiscovery extends AttackStepMax {
   public AdminSecuritySoftwareDiscovery(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
for (WindowsAdmin windowsAdmin_cpxcO : windowsAdmin) {
addExpectedParent(windowsAdmin_cpxcO.systemRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.adminSecuritySoftwareDiscovery");
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
            return "windows.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
createService.updateTtc(this, ttc, activeAttackSteps);
scheduledTask.updateTtc(this, ttc, activeAttackSteps);
systemTimeDiscovery.updateTtc(this, ttc, activeAttackSteps);
queryRegistery.updateTtc(this, ttc, activeAttackSteps);
networkShareDiscovery.updateTtc(this, ttc, activeAttackSteps);
userSecuritySoftwareDiscovery.updateTtc(this, ttc, activeAttackSteps);
adminSecuritySoftwareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class ExecuteService extends AttackStepMax {
   public ExecuteService(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
for (WindowsAdmin windowsAdmin_QgYxC : windowsAdmin) {
addExpectedParent(windowsAdmin_QgYxC.systemRights);
}
addExpectedParent(createService);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
persistance.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.executeService");
      }

   }

   public class Persistance extends AttackStepMin {
   public Persistance(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
addExpectedParent(executeService);
addExpectedParent(bootkit);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.persistance");
      }

   }

   public class Bootkit extends AttackStepMax {
   public Bootkit(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (windowsAdministrator != null) {
addExpectedParent(windowsAdministrator.adminRights);
}
addExpectedParent(secureBootProcess.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
persistance.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.bootkit");
      }

   }

   public class SecureBootProcess extends Defense {
   public SecureBootProcess(String name, Boolean enabled) {
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
            return "windows.secureBootProcess";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
bootkit.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class PeripheralDeviceDiscovery extends AttackStepMin {
   public PeripheralDeviceDiscovery(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (windowsUser != null) {
addExpectedParent(windowsUser.userRights);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer.peripheralDeviceDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.peripheralDeviceDiscovery");
      }

   }

   public class EmailStorageCollection extends AttackStepMax {
   public EmailStorageCollection(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (windowsUser != null) {
addExpectedParent(windowsUser.userRights);
}
addExpectedParent(dataEncryption.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer.dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.emailStorageCollection");
      }

   }

   public class OutlookEmailCollection extends AttackStepMax {
   public OutlookEmailCollection(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (windowsUser != null) {
addExpectedParent(windowsUser.userCredentials);
}
addExpectedParent(dataEncryption.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer.dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.outlookEmailCollection");
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
            return "windows.dataEncryption";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
emailStorageCollection.updateTtc(this, ttc, activeAttackSteps);
outlookEmailCollection.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class VideoCollection extends AttackStepMin {
   public VideoCollection(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (windowsUser != null) {
addExpectedParent(windowsUser.userRights);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (computer != null) {
computer.collectVideo.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.videoCollection");
      }

   }

   public class ScheduledTask extends AttackStepMax {
   public ScheduledTask(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
if (windowsAdministrator != null) {
addExpectedParent(windowsAdministrator.adminRights);
}
addExpectedParent(whitelisting.disable);
addExpectedParent(systemTimeDiscovery);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.scheduledTask");
      }

   }

   public class SystemTimeDiscovery extends AttackStepMax {
   public SystemTimeDiscovery(String name) {
      super(name);
      assetClassName = "Windows";
   }
@Override
public void setExpectedParents() {
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
scheduledTask.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Windows.systemTimeDiscovery");
      }

   }

      public void addWindowsUser(User windowsUser) {
         this.windowsUser = windowsUser;
         windowsUser.windows.add(this);
      }

      public void addWindowsAdministrator(Administrator windowsAdministrator) {
         this.windowsAdministrator = windowsAdministrator;
         windowsAdministrator.windows.add(this);
      }

      public void addWindowsAdmin(WindowsAdmin windowsAdmin) {
         this.windowsAdmin.add(windowsAdmin);
         windowsAdmin.windows = this;
      }

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.windows = this;
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.windows.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("windowsUser")) {
         return windowsUser.getClass().getName();
      }
      if (roleName.equals("windowsAdministrator")) {
         return windowsAdministrator.getClass().getName();
      }
      if (roleName.equals("windowsAdmin")) {
         for (Object o: windowsAdmin) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("computer")) {
         return computer.getClass().getName();
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("windowsUser")  && windowsUser != null) {
         assets.add(windowsUser);
         return assets;
      }
      if (roleName.equals("windowsAdministrator")  && windowsAdministrator != null) {
         assets.add(windowsAdministrator);
         return assets;
      }
      if (roleName.equals("windowsAdmin")  && windowsAdmin != null) {
         assets.addAll(windowsAdmin);
         return assets;
      }
      if (roleName.equals("computer")  && computer != null) {
         assets.add(computer);
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
      if (windowsUser != null) {
         assets.add(windowsUser);
      }
      if (windowsAdministrator != null) {
         assets.add(windowsAdministrator);
      }
      assets.addAll(windowsAdmin);
      if (computer != null) {
         assets.add(computer);
      }
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
