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
   public WindowsAdmin windowsAdmin;
   public java.util.Set<User> user = new HashSet<>();
   public java.util.Set<Windows> windows = new HashSet<>();
   public java.util.Set<Linux> linux = new HashSet<>();
   public java.util.Set<Computer> computer = new HashSet<>();
   public java.util.Set<OS> os = new HashSet<>();
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
public void setExpectedParents() {
if (windowsAdmin != null) {
addExpectedParent(windowsAdmin.systemRights);
}
for (OS oS_iaybm : os) {
addExpectedParent(oS_iaybm.processInjection);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (User user_XqRfK : user) {
user_XqRfK.userRights.updateTtc(this, ttc, activeAttackSteps);
}
for (Windows windows_DgbBm : windows) {
windows_DgbBm.createService.updateTtc(this, ttc, activeAttackSteps);
}
for (Computer computer_CoDYQ : computer) {
computer_CoDYQ.adminDataDestruction.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_eueRb : os) {
oS_eueRb.detailedRunningProcessDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_rEfJu : os) {
oS_rEfJu.detailedRemoteSystemDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_jPjTT : os) {
oS_jPjTT.adminCommandLineInterface.updateTtc(this, ttc, activeAttackSteps);
}
for (Windows windows_qFpml : windows) {
windows_qFpml.bootkit.updateTtc(this, ttc, activeAttackSteps);
}
for (Linux linux_UEhzb : linux) {
linux_UEhzb.bootkit.updateTtc(this, ttc, activeAttackSteps);
}
if (internalNetwork != null) {
internalNetwork.admintransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
for (Service service_LrDyT : service) {
service_LrDyT.admintransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
for (Computer computer_rObzI : computer) {
computer_rObzI.networkServiceScan.updateTtc(this, ttc, activeAttackSteps);
}
for (Windows windows_FQFuC : windows) {
windows_FQFuC.scheduledTask.updateTtc(this, ttc, activeAttackSteps);
}
for (Computer computer_vVnGa : computer) {
computer_vVnGa.automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
for (Computer computer_OQUDJ : computer) {
computer_OQUDJ.sensitiveDataCollected.updateTtc(this, ttc, activeAttackSteps);
}
for (Computer computer_PHPid : computer) {
computer_PHPid.diskStructureWipe.updateTtc(this, ttc, activeAttackSteps);
}
for (Computer computer_pcsMa : computer) {
computer_pcsMa.adminDiskWiped.updateTtc(this, ttc, activeAttackSteps);
}
for (Computer computer_uBDoZ : computer) {
computer_uBDoZ.adminDataEncryptedForImpact.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Administrator.adminRights");
      }

   }

      public void addWindowsAdmin(WindowsAdmin windowsAdmin) {
         this.windowsAdmin = windowsAdmin;
         windowsAdmin.administrator = this;
      }

      public void addUser(User user) {
         this.user.add(user);
         user.administrator = this;
      }

      public void addWindows(Windows windows) {
         this.windows.add(windows);
         windows.windowsAdministrator = this;
      }

      public void addLinux(Linux linux) {
         this.linux.add(linux);
         linux.linuxAdministrator = this;
      }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.administrator = this;
      }

      public void addOs(OS os) {
         this.os.add(os);
         os.administrator = this;
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
      if (roleName.equals("windowsAdmin")) {
         return windowsAdmin.getClass().getName();
      }
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("windows")) {
         for (Object o: windows) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("linux")) {
         for (Object o: linux) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("computer")) {
         for (Object o: computer) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("os")) {
         for (Object o: os) {
            return o.getClass().getName();
         }
      }
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
      if (roleName.equals("windowsAdmin")  && windowsAdmin != null) {
         assets.add(windowsAdmin);
         return assets;
      }
      if (roleName.equals("user")  && user != null) {
         assets.addAll(user);
         return assets;
      }
      if (roleName.equals("windows")  && windows != null) {
         assets.addAll(windows);
         return assets;
      }
      if (roleName.equals("linux")  && linux != null) {
         assets.addAll(linux);
         return assets;
      }
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
      if (roleName.equals("os")  && os != null) {
         assets.addAll(os);
         return assets;
      }
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
      if (windowsAdmin != null) {
         assets.add(windowsAdmin);
      }
      assets.addAll(user);
      assets.addAll(windows);
      assets.addAll(linux);
      assets.addAll(computer);
      assets.addAll(os);
      assets.addAll(service);
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      return assets;
   }
}
