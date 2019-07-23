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
public class MacOS extends OS {
   public java.util.Set<User> macOSUser = new HashSet<>();
   public Employee employee;
   public java.util.Set<Computer> computer = new HashSet<>();
   public InternalNetwork internalNetwork;
   public java.util.Set<Root> root = new HashSet<>();

   public VideoCollection videoCollection;
   public SpaceAfterFileName spaceAfterFileName;
   public FileMonitoring fileMonitoring;
   public NetworkShareDiscovery networkShareDiscovery;
   public UserSecuritySoftwareDiscovery userSecuritySoftwareDiscovery;
   public AdminSecuritySoftwareDiscovery adminSecuritySoftwareDiscovery;

   public MacOS(Boolean fileMonitoringState, Boolean whitelistingState, Boolean lockoutPoliciesState, Boolean antivirusState, Boolean restricedScriptingState, Boolean sandboxingState) {
      super(whitelistingState, lockoutPoliciesState, antivirusState, restricedScriptingState, sandboxingState);
      if (fileMonitoring != null) {
         AttackStep.allAttackSteps.remove(fileMonitoring.disable);
      }
      Defense.allDefenses.remove(fileMonitoring);
      fileMonitoring = new FileMonitoring(this.name, fileMonitoringState);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (lockoutPolicies != null) {
         AttackStep.allAttackSteps.remove(lockoutPolicies.disable);
      }
      Defense.allDefenses.remove(lockoutPolicies);
      lockoutPolicies = new LockoutPolicies(this.name, lockoutPoliciesState);
      if (antivirus != null) {
         AttackStep.allAttackSteps.remove(antivirus.disable);
      }
      Defense.allDefenses.remove(antivirus);
      antivirus = new Antivirus(this.name, antivirusState);
      if (restricedScripting != null) {
         AttackStep.allAttackSteps.remove(restricedScripting.disable);
      }
      Defense.allDefenses.remove(restricedScripting);
      restricedScripting = new RestricedScripting(this.name, restricedScriptingState);
      if (sandboxing != null) {
         AttackStep.allAttackSteps.remove(sandboxing.disable);
      }
      Defense.allDefenses.remove(sandboxing);
      sandboxing = new Sandboxing(this.name, sandboxingState);
      AttackStep.allAttackSteps.remove(videoCollection);
      videoCollection = new VideoCollection(this.name);
      AttackStep.allAttackSteps.remove(spaceAfterFileName);
      spaceAfterFileName = new SpaceAfterFileName(this.name);
      AttackStep.allAttackSteps.remove(networkShareDiscovery);
      networkShareDiscovery = new NetworkShareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(userSecuritySoftwareDiscovery);
      userSecuritySoftwareDiscovery = new UserSecuritySoftwareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(adminSecuritySoftwareDiscovery);
      adminSecuritySoftwareDiscovery = new AdminSecuritySoftwareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(accountDiscovery);
      accountDiscovery = new AccountDiscovery(this.name);
      AttackStep.allAttackSteps.remove(domainDiscovery);
      domainDiscovery = new DomainDiscovery(this.name);
      AttackStep.allAttackSteps.remove(applicationWindowDiscovery);
      applicationWindowDiscovery = new ApplicationWindowDiscovery(this.name);
      AttackStep.allAttackSteps.remove(runningProcessDiscovery);
      runningProcessDiscovery = new RunningProcessDiscovery(this.name);
      AttackStep.allAttackSteps.remove(detailedRunningProcessDiscovery);
      detailedRunningProcessDiscovery = new DetailedRunningProcessDiscovery(this.name);
      AttackStep.allAttackSteps.remove(remoteSystemDiscovery);
      remoteSystemDiscovery = new RemoteSystemDiscovery(this.name);
      AttackStep.allAttackSteps.remove(detailedRemoteSystemDiscovery);
      detailedRemoteSystemDiscovery = new DetailedRemoteSystemDiscovery(this.name);
      AttackStep.allAttackSteps.remove(adminCommandLineInterface);
      adminCommandLineInterface = new AdminCommandLineInterface(this.name);
      AttackStep.allAttackSteps.remove(userCommandLineInterface);
      userCommandLineInterface = new UserCommandLineInterface(this.name);
      AttackStep.allAttackSteps.remove(systemInformationDiscovery);
      systemInformationDiscovery = new SystemInformationDiscovery(this.name);
      AttackStep.allAttackSteps.remove(processInjection);
      processInjection = new ProcessInjection(this.name);
      AttackStep.allAttackSteps.remove(bypassAntivirus);
      bypassAntivirus = new BypassAntivirus(this.name);
      AttackStep.allAttackSteps.remove(bypassWhitelisting);
      bypassWhitelisting = new BypassWhitelisting(this.name);
      AttackStep.allAttackSteps.remove(passwordPolicyDiscovery);
      passwordPolicyDiscovery = new PasswordPolicyDiscovery(this.name);
      AttackStep.allAttackSteps.remove(bruteForceWithPasswordPolicy);
      bruteForceWithPasswordPolicy = new BruteForceWithPasswordPolicy(this.name);
      AttackStep.allAttackSteps.remove(bruteForce);
      bruteForce = new BruteForce(this.name);
      AttackStep.allAttackSteps.remove(codeDelivered);
      codeDelivered = new CodeDelivered(this.name);
      AttackStep.allAttackSteps.remove(antivirusCheck);
      antivirusCheck = new AntivirusCheck(this.name);
      AttackStep.allAttackSteps.remove(runCode);
      runCode = new RunCode(this.name);
      AttackStep.allAttackSteps.remove(spearphishingAttachmentDownload);
      spearphishingAttachmentDownload = new SpearphishingAttachmentDownload(this.name);
      AttackStep.allAttackSteps.remove(spearphishingLinkDownload);
      spearphishingLinkDownload = new SpearphishingLinkDownload(this.name);
      AttackStep.allAttackSteps.remove(scripting);
      scripting = new Scripting(this.name);
      AttackStep.allAttackSteps.remove(_scripting);
      _scripting = new _scripting(this.name);
      assetClassName = "MacOS";
   }

   public MacOS(String name, Boolean fileMonitoringState, Boolean whitelistingState, Boolean lockoutPoliciesState, Boolean antivirusState, Boolean restricedScriptingState, Boolean sandboxingState) {
      super(name, whitelistingState, lockoutPoliciesState, antivirusState, restricedScriptingState, sandboxingState);
      if (fileMonitoring != null) {
         AttackStep.allAttackSteps.remove(fileMonitoring.disable);
      }
      Defense.allDefenses.remove(fileMonitoring);
      fileMonitoring = new FileMonitoring(this.name, fileMonitoringState);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (lockoutPolicies != null) {
         AttackStep.allAttackSteps.remove(lockoutPolicies.disable);
      }
      Defense.allDefenses.remove(lockoutPolicies);
      lockoutPolicies = new LockoutPolicies(this.name, lockoutPoliciesState);
      if (antivirus != null) {
         AttackStep.allAttackSteps.remove(antivirus.disable);
      }
      Defense.allDefenses.remove(antivirus);
      antivirus = new Antivirus(this.name, antivirusState);
      if (restricedScripting != null) {
         AttackStep.allAttackSteps.remove(restricedScripting.disable);
      }
      Defense.allDefenses.remove(restricedScripting);
      restricedScripting = new RestricedScripting(this.name, restricedScriptingState);
      if (sandboxing != null) {
         AttackStep.allAttackSteps.remove(sandboxing.disable);
      }
      Defense.allDefenses.remove(sandboxing);
      sandboxing = new Sandboxing(this.name, sandboxingState);
      AttackStep.allAttackSteps.remove(videoCollection);
      videoCollection = new VideoCollection(this.name);
      AttackStep.allAttackSteps.remove(spaceAfterFileName);
      spaceAfterFileName = new SpaceAfterFileName(this.name);
      AttackStep.allAttackSteps.remove(networkShareDiscovery);
      networkShareDiscovery = new NetworkShareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(userSecuritySoftwareDiscovery);
      userSecuritySoftwareDiscovery = new UserSecuritySoftwareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(adminSecuritySoftwareDiscovery);
      adminSecuritySoftwareDiscovery = new AdminSecuritySoftwareDiscovery(this.name);
      AttackStep.allAttackSteps.remove(accountDiscovery);
      accountDiscovery = new AccountDiscovery(this.name);
      AttackStep.allAttackSteps.remove(domainDiscovery);
      domainDiscovery = new DomainDiscovery(this.name);
      AttackStep.allAttackSteps.remove(applicationWindowDiscovery);
      applicationWindowDiscovery = new ApplicationWindowDiscovery(this.name);
      AttackStep.allAttackSteps.remove(runningProcessDiscovery);
      runningProcessDiscovery = new RunningProcessDiscovery(this.name);
      AttackStep.allAttackSteps.remove(detailedRunningProcessDiscovery);
      detailedRunningProcessDiscovery = new DetailedRunningProcessDiscovery(this.name);
      AttackStep.allAttackSteps.remove(remoteSystemDiscovery);
      remoteSystemDiscovery = new RemoteSystemDiscovery(this.name);
      AttackStep.allAttackSteps.remove(detailedRemoteSystemDiscovery);
      detailedRemoteSystemDiscovery = new DetailedRemoteSystemDiscovery(this.name);
      AttackStep.allAttackSteps.remove(adminCommandLineInterface);
      adminCommandLineInterface = new AdminCommandLineInterface(this.name);
      AttackStep.allAttackSteps.remove(userCommandLineInterface);
      userCommandLineInterface = new UserCommandLineInterface(this.name);
      AttackStep.allAttackSteps.remove(systemInformationDiscovery);
      systemInformationDiscovery = new SystemInformationDiscovery(this.name);
      AttackStep.allAttackSteps.remove(processInjection);
      processInjection = new ProcessInjection(this.name);
      AttackStep.allAttackSteps.remove(bypassAntivirus);
      bypassAntivirus = new BypassAntivirus(this.name);
      AttackStep.allAttackSteps.remove(bypassWhitelisting);
      bypassWhitelisting = new BypassWhitelisting(this.name);
      AttackStep.allAttackSteps.remove(passwordPolicyDiscovery);
      passwordPolicyDiscovery = new PasswordPolicyDiscovery(this.name);
      AttackStep.allAttackSteps.remove(bruteForceWithPasswordPolicy);
      bruteForceWithPasswordPolicy = new BruteForceWithPasswordPolicy(this.name);
      AttackStep.allAttackSteps.remove(bruteForce);
      bruteForce = new BruteForce(this.name);
      AttackStep.allAttackSteps.remove(codeDelivered);
      codeDelivered = new CodeDelivered(this.name);
      AttackStep.allAttackSteps.remove(antivirusCheck);
      antivirusCheck = new AntivirusCheck(this.name);
      AttackStep.allAttackSteps.remove(runCode);
      runCode = new RunCode(this.name);
      AttackStep.allAttackSteps.remove(spearphishingAttachmentDownload);
      spearphishingAttachmentDownload = new SpearphishingAttachmentDownload(this.name);
      AttackStep.allAttackSteps.remove(spearphishingLinkDownload);
      spearphishingLinkDownload = new SpearphishingLinkDownload(this.name);
      AttackStep.allAttackSteps.remove(scripting);
      scripting = new Scripting(this.name);
      AttackStep.allAttackSteps.remove(_scripting);
      _scripting = new _scripting(this.name);
      assetClassName = "MacOS";
   }

   public MacOS() {
      this(false, false, false, false, false, false);
      assetClassName = "MacOS";
   }

   public MacOS(String name) {
      this(name, false, false, false, false, false, false);
      assetClassName = "MacOS";
   }


   public class VideoCollection extends AttackStepMin {
   public VideoCollection(String name) {
      super(name);
      assetClassName = "MacOS";
   }
@Override
public void setExpectedParents() {
for (User user_ftgmf : macOSUser) {
addExpectedParent(user_ftgmf.userRights);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_fcBGZ : computer) {
computer_fcBGZ.collectVideo.updateTtc(this, ttc, activeAttackSteps);
}
}
   }

   public class SpaceAfterFileName extends AttackStepMax {
   public SpaceAfterFileName(String name) {
      super(name);
      assetClassName = "MacOS";
   }
@Override
public void setExpectedParents() {
for (User user_rPELm : macOSUser) {
addExpectedParent(user_rPELm.userRights);
}
addExpectedParent(fileMonitoring.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (employee != null) {
employee.userExecution.updateTtc(this, ttc, activeAttackSteps);
}
}
   }

   public class FileMonitoring extends Defense {
   public FileMonitoring(String name, Boolean enabled) {
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
            return "macOS.fileMonitoring";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
spaceAfterFileName.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class NetworkShareDiscovery extends AttackStepMax {
   public NetworkShareDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
@Override
public void setExpectedParents() {
for (User user_kBSGw : macOSUser) {
addExpectedParent(user_kBSGw.userRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (internalNetwork != null) {
internalNetwork.networkShareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
}
   }

   public class UserSecuritySoftwareDiscovery extends AttackStepMax {
   public UserSecuritySoftwareDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
@Override
public void setExpectedParents() {
for (User user_JeHUy : macOSUser) {
addExpectedParent(user_JeHUy.userRights);
}
addExpectedParent(whitelisting.disable);
}
   }

   public class AdminSecuritySoftwareDiscovery extends AttackStepMax {
   public AdminSecuritySoftwareDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
@Override
public void setExpectedParents() {
for (Root root_crOAL : root) {
addExpectedParent(root_crOAL.rootRights);
}
addExpectedParent(whitelisting.disable);
}
   }

   public class Whitelisting extends OS.Whitelisting {
   public Whitelisting(String name, Boolean enabled) {
      super(name, enabled);
      disable = new Disable(name);
   }

   public class Disable extends OS.Whitelisting.Disable {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "macOS.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
networkShareDiscovery.updateTtc(this, ttc, activeAttackSteps);
userSecuritySoftwareDiscovery.updateTtc(this, ttc, activeAttackSteps);
adminSecuritySoftwareDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class AccountDiscovery extends OS.AccountDiscovery {
   public AccountDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class DomainDiscovery extends OS.DomainDiscovery {
   public DomainDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class ApplicationWindowDiscovery extends OS.ApplicationWindowDiscovery {
   public ApplicationWindowDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class RunningProcessDiscovery extends OS.RunningProcessDiscovery {
   public RunningProcessDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class DetailedRunningProcessDiscovery extends OS.DetailedRunningProcessDiscovery {
   public DetailedRunningProcessDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class RemoteSystemDiscovery extends OS.RemoteSystemDiscovery {
   public RemoteSystemDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class DetailedRemoteSystemDiscovery extends OS.DetailedRemoteSystemDiscovery {
   public DetailedRemoteSystemDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class AdminCommandLineInterface extends OS.AdminCommandLineInterface {
   public AdminCommandLineInterface(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class UserCommandLineInterface extends OS.UserCommandLineInterface {
   public UserCommandLineInterface(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class SystemInformationDiscovery extends OS.SystemInformationDiscovery {
   public SystemInformationDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class ProcessInjection extends OS.ProcessInjection {
   public ProcessInjection(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class BypassAntivirus extends OS.BypassAntivirus {
   public BypassAntivirus(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class BypassWhitelisting extends OS.BypassWhitelisting {
   public BypassWhitelisting(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class PasswordPolicyDiscovery extends OS.PasswordPolicyDiscovery {
   public PasswordPolicyDiscovery(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class BruteForceWithPasswordPolicy extends OS.BruteForceWithPasswordPolicy {
   public BruteForceWithPasswordPolicy(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class BruteForce extends OS.BruteForce {
   public BruteForce(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class LockoutPolicies extends OS.LockoutPolicies {
   public LockoutPolicies(String name, Boolean enabled) {
      super(name, enabled);
      disable = new Disable(name);
   }

   public class Disable extends OS.LockoutPolicies.Disable {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "macOS.lockoutPolicies";
         }
   }
}

   public class CodeDelivered extends OS.CodeDelivered {
   public CodeDelivered(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class AntivirusCheck extends OS.AntivirusCheck {
   public AntivirusCheck(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class Antivirus extends OS.Antivirus {
   public Antivirus(String name, Boolean enabled) {
      super(name, enabled);
      disable = new Disable(name);
   }

   public class Disable extends OS.Antivirus.Disable {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "macOS.antivirus";
         }
   }
}

   public class RunCode extends OS.RunCode {
   public RunCode(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class SpearphishingAttachmentDownload extends OS.SpearphishingAttachmentDownload {
   public SpearphishingAttachmentDownload(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class SpearphishingLinkDownload extends OS.SpearphishingLinkDownload {
   public SpearphishingLinkDownload(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class Scripting extends OS.Scripting {
   public Scripting(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class _scripting extends OS._scripting {
   public _scripting(String name) {
      super(name);
      assetClassName = "MacOS";
   }
   }

   public class RestricedScripting extends OS.RestricedScripting {
   public RestricedScripting(String name, Boolean enabled) {
      super(name, enabled);
      disable = new Disable(name);
   }

   public class Disable extends OS.RestricedScripting.Disable {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "macOS.restricedScripting";
         }
   }
}

   public class Sandboxing extends OS.Sandboxing {
   public Sandboxing(String name, Boolean enabled) {
      super(name, enabled);
      disable = new Disable(name);
   }

   public class Disable extends OS.Sandboxing.Disable {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "macOS.sandboxing";
         }
   }
}

      public void addMacOSUser(User macOSUser) {
         this.macOSUser.add(macOSUser);
         macOSUser.macOS = this;
      }

      public void addEmployee(Employee employee) {
         this.employee = employee;
         employee.macOS.add(this);
      }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.macOS = this;
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.macOS.add(this);
      }

      public void addRoot(Root root) {
         this.root.add(root);
         root.macOS = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("macOSUser")) {
         for (Object o: macOSUser) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("employee")) {
         return employee.getClass().getName();
      }
      if (roleName.equals("computer")) {
         for (Object o: computer) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
      }
      if (roleName.equals("root")) {
         for (Object o: root) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("macOSUser")  && macOSUser != null) {
         assets.addAll(macOSUser);
         return assets;
      }
      if (roleName.equals("employee")  && employee != null) {
         assets.add(employee);
         return assets;
      }
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
      if (roleName.equals("internalNetwork")  && internalNetwork != null) {
         assets.add(internalNetwork);
         return assets;
      }
      if (roleName.equals("root")  && root != null) {
         assets.addAll(root);
         return assets;
      }
      if (roleName.equals("adversary")  && adversary != null) {
         assets.add(adversary);
         return assets;
      }
      if (roleName.equals("user")  && user != null) {
         assets.add(user);
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
      if (roleName.equals("browser")  && browser != null) {
         assets.addAll(browser);
         return assets;
      }
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(macOSUser);
      if (employee != null) {
         assets.add(employee);
      }
      assets.addAll(computer);
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      assets.addAll(root);
      if (adversary != null) {
         assets.add(adversary);
      }
      if (user != null) {
         assets.add(user);
      }
      if (administrator != null) {
         assets.add(administrator);
      }
      if (employee != null) {
         assets.add(employee);
      }
      assets.addAll(browser);
      assets.addAll(computer);
      return assets;
   }
}
