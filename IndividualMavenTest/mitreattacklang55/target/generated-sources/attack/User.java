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
   public java.util.Set<OS> os = new HashSet<>();
   public java.util.Set<Windows> windows = new HashSet<>();
   public Computer computer;
   public java.util.Set<Service> service = new HashSet<>();
   public MacOS macOS;
   public Linux linux;
   public Administrator administrator;
   public Employee employee;
   public InternalNetwork internalNetwork;

   public UserRights userRights;
   public UserCredentials userCredentials;

   public User() {
      super();
      AttackStep.allAttackSteps.remove(userRights);
      userRights = new UserRights(this.name);
      AttackStep.allAttackSteps.remove(userCredentials);
      userCredentials = new UserCredentials(this.name);
      assetClassName = "User";
   }

   public User(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(userRights);
      userRights = new UserRights(this.name);
      AttackStep.allAttackSteps.remove(userCredentials);
      userCredentials = new UserCredentials(this.name);
      assetClassName = "User";
   }


   public class UserRights extends AttackStepMin {
   public UserRights(String name) {
      super(name);
      assetClassName = "User";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
if (employee != null) {
addExpectedParent(employee.manualManipulation);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (OS oS_myolp : os) {
oS_myolp.accountDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_NrpwP : os) {
oS_NrpwP.domainDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_gRTfA : os) {
oS_gRTfA.applicationWindowDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_ySyTv : os) {
oS_ySyTv.bruteForce.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_jkcVT : os) {
oS_jkcVT.passwordPolicyDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_oCNPc : os) {
oS_oCNPc.runningProcessDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_QpgJL : os) {
oS_QpgJL.remoteSystemDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_IaFsR : os) {
oS_IaFsR.userCommandLineInterface.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_EGwqS : os) {
oS_EGwqS.processInjection.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.userDataDestruction.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.fileDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.directoryDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.fileDeletion.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.uploadRemoteFile.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.downloadRemoteFile.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.collectAudio.updateTtc(this, ttc, activeAttackSteps);
}
if (internalNetwork != null) {
internalNetwork.usertransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
for (Service service_oqFca : service) {
service_oqFca.usertransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
for (Windows windows_GdymI : windows) {
windows_GdymI.peripheralDeviceDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.permissionGroupsDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (Service service_jqEjo : service) {
service_jqEjo.remoteAccessTools.updateTtc(this, ttc, activeAttackSteps);
}
for (Windows windows_tiUHD : windows) {
windows_tiUHD.emailStorageCollection.updateTtc(this, ttc, activeAttackSteps);
}
for (Windows windows_MMTLo : windows) {
windows_MMTLo.videoCollection.updateTtc(this, ttc, activeAttackSteps);
}
if (macOS != null) {
macOS.videoCollection.updateTtc(this, ttc, activeAttackSteps);
}
for (Service service_qqhhW : service) {
service_qqhhW._exploitationForDefenseEvasion.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_MNVzL : os) {
oS_MNVzL.systemInformationDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_CtSbz : os) {
oS_CtSbz.scripting.updateTtc(this, ttc, activeAttackSteps);
}
if (macOS != null) {
macOS.spaceAfterFileName.updateTtc(this, ttc, activeAttackSteps);
}
if (linux != null) {
linux.spaceAfterFileName.updateTtc(this, ttc, activeAttackSteps);
}
if (macOS != null) {
macOS.networkShareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (Windows windows_YiXhW : windows) {
windows_YiXhW.networkShareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
if (macOS != null) {
macOS.userSecuritySoftwareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (Windows windows_ImVln : windows) {
windows_ImVln.userSecuritySoftwareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.userDiskWiped.updateTtc(this, ttc, activeAttackSteps);
}
if (computer != null) {
computer.userDataEncryptedForImpact.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("User.userRights");
      }

   }

   public class UserCredentials extends AttackStepMin {
   public UserCredentials(String name) {
      super(name);
      assetClassName = "User";
   }
@Override
public void setExpectedParents() {
for (OS oS_cMFuP : os) {
addExpectedParent(oS_cMFuP.bruteForceWithPasswordPolicy);
}
for (OS oS_wGOPT : os) {
addExpectedParent(oS_wGOPT.bruteForce);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Windows windows_zBzhZ : windows) {
windows_zBzhZ.outlookEmailCollection.updateTtc(this, ttc, activeAttackSteps);
}
if (internalNetwork != null) {
internalNetwork.exchangeServerCollection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("User.userCredentials");
      }

   }

      public void addOs(OS os) {
         this.os.add(os);
         os.user = this;
      }

      public void addWindows(Windows windows) {
         this.windows.add(windows);
         windows.windowsUser = this;
      }

      public void addComputer(Computer computer) {
         this.computer = computer;
         computer.user.add(this);
      }

      public void addService(Service service) {
         this.service.add(service);
         service.user.add(this);
      }

      public void addMacOS(MacOS macOS) {
         this.macOS = macOS;
         macOS.macOSUser.add(this);
      }

      public void addLinux(Linux linux) {
         this.linux = linux;
         linux.linuxUser.add(this);
      }

      public void addAdministrator(Administrator administrator) {
         this.administrator = administrator;
         administrator.user.add(this);
      }

      public void addEmployee(Employee employee) {
         this.employee = employee;
         employee.user.add(this);
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.user.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("os")) {
         for (Object o: os) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("windows")) {
         for (Object o: windows) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("computer")) {
         return computer.getClass().getName();
      }
      if (roleName.equals("service")) {
         for (Object o: service) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("macOS")) {
         return macOS.getClass().getName();
      }
      if (roleName.equals("linux")) {
         return linux.getClass().getName();
      }
      if (roleName.equals("administrator")) {
         return administrator.getClass().getName();
      }
      if (roleName.equals("employee")) {
         return employee.getClass().getName();
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("os")  && os != null) {
         assets.addAll(os);
         return assets;
      }
      if (roleName.equals("windows")  && windows != null) {
         assets.addAll(windows);
         return assets;
      }
      if (roleName.equals("computer")  && computer != null) {
         assets.add(computer);
         return assets;
      }
      if (roleName.equals("service")  && service != null) {
         assets.addAll(service);
         return assets;
      }
      if (roleName.equals("macOS")  && macOS != null) {
         assets.add(macOS);
         return assets;
      }
      if (roleName.equals("linux")  && linux != null) {
         assets.add(linux);
         return assets;
      }
      if (roleName.equals("administrator")  && administrator != null) {
         assets.add(administrator);
         return assets;
      }
      if (roleName.equals("employee")  && employee != null) {
         assets.add(employee);
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
      assets.addAll(os);
      assets.addAll(windows);
      if (computer != null) {
         assets.add(computer);
      }
      assets.addAll(service);
      if (macOS != null) {
         assets.add(macOS);
      }
      if (linux != null) {
         assets.add(linux);
      }
      if (administrator != null) {
         assets.add(administrator);
      }
      if (employee != null) {
         assets.add(employee);
      }
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
