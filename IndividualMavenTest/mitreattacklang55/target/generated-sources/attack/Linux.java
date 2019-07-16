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
public class Linux extends OS {
   public java.util.Set<User> linuxUser = new HashSet<>();
   public Administrator linuxAdministrator;
   public Employee employee;

   public Bootkit bootkit;
   public SecureBootProcess secureBootProcess;
   public Persistance persistance;
   public SpaceAfterFileName spaceAfterFileName;
   public FileMonitoring fileMonitoring;

   public Linux(Boolean secureBootProcessState, Boolean fileMonitoringState, Boolean whitelistingState, Boolean lockoutPoliciesState, Boolean antivirusState, Boolean restricedScriptingState, Boolean sandboxingState) {
      super(whitelistingState, lockoutPoliciesState, antivirusState, restricedScriptingState, sandboxingState);
      if (secureBootProcess != null) {
         AttackStep.allAttackSteps.remove(secureBootProcess.disable);
      }
      Defense.allDefenses.remove(secureBootProcess);
      secureBootProcess = new SecureBootProcess(this.name, secureBootProcessState);
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
      AttackStep.allAttackSteps.remove(bootkit);
      bootkit = new Bootkit(this.name);
      AttackStep.allAttackSteps.remove(persistance);
      persistance = new Persistance(this.name);
      AttackStep.allAttackSteps.remove(spaceAfterFileName);
      spaceAfterFileName = new SpaceAfterFileName(this.name);
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
      assetClassName = "Linux";
   }

   public Linux(String name, Boolean secureBootProcessState, Boolean fileMonitoringState, Boolean whitelistingState, Boolean lockoutPoliciesState, Boolean antivirusState, Boolean restricedScriptingState, Boolean sandboxingState) {
      super(name, whitelistingState, lockoutPoliciesState, antivirusState, restricedScriptingState, sandboxingState);
      if (secureBootProcess != null) {
         AttackStep.allAttackSteps.remove(secureBootProcess.disable);
      }
      Defense.allDefenses.remove(secureBootProcess);
      secureBootProcess = new SecureBootProcess(this.name, secureBootProcessState);
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
      AttackStep.allAttackSteps.remove(bootkit);
      bootkit = new Bootkit(this.name);
      AttackStep.allAttackSteps.remove(persistance);
      persistance = new Persistance(this.name);
      AttackStep.allAttackSteps.remove(spaceAfterFileName);
      spaceAfterFileName = new SpaceAfterFileName(this.name);
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
      assetClassName = "Linux";
   }

   public Linux() {
      this(false, false, false, false, false, false, false);
      assetClassName = "Linux";
   }

   public Linux(String name) {
      this(name, false, false, false, false, false, false, false);
      assetClassName = "Linux";
   }


   public class Bootkit extends AttackStepMax {
   public Bootkit(String name) {
      super(name);
      assetClassName = "Linux";
   }
@Override
public void setExpectedParents() {
if (linuxAdministrator != null) {
addExpectedParent(linuxAdministrator.adminRights);
}
addExpectedParent(secureBootProcess.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
persistance.updateTtc(this, ttc, activeAttackSteps);
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
            return "linux.secureBootProcess";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
bootkit.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class Persistance extends AttackStepMin {
   public Persistance(String name) {
      super(name);
      assetClassName = "Linux";
   }
@Override
public void setExpectedParents() {
addExpectedParent(bootkit);
}
   }

   public class SpaceAfterFileName extends AttackStepMax {
   public SpaceAfterFileName(String name) {
      super(name);
      assetClassName = "Linux";
   }
@Override
public void setExpectedParents() {
for (User user_SRhqs : linuxUser) {
addExpectedParent(user_SRhqs.userRights);
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
            return "linux.fileMonitoring";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
spaceAfterFileName.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class AccountDiscovery extends OS.AccountDiscovery {
   public AccountDiscovery(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class DomainDiscovery extends OS.DomainDiscovery {
   public DomainDiscovery(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class ApplicationWindowDiscovery extends OS.ApplicationWindowDiscovery {
   public ApplicationWindowDiscovery(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class RunningProcessDiscovery extends OS.RunningProcessDiscovery {
   public RunningProcessDiscovery(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class DetailedRunningProcessDiscovery extends OS.DetailedRunningProcessDiscovery {
   public DetailedRunningProcessDiscovery(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class RemoteSystemDiscovery extends OS.RemoteSystemDiscovery {
   public RemoteSystemDiscovery(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class DetailedRemoteSystemDiscovery extends OS.DetailedRemoteSystemDiscovery {
   public DetailedRemoteSystemDiscovery(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class AdminCommandLineInterface extends OS.AdminCommandLineInterface {
   public AdminCommandLineInterface(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class UserCommandLineInterface extends OS.UserCommandLineInterface {
   public UserCommandLineInterface(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class SystemInformationDiscovery extends OS.SystemInformationDiscovery {
   public SystemInformationDiscovery(String name) {
      super(name);
      assetClassName = "Linux";
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
            return "linux.whitelisting";
         }
   }
}

   public class ProcessInjection extends OS.ProcessInjection {
   public ProcessInjection(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class BypassAntivirus extends OS.BypassAntivirus {
   public BypassAntivirus(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class BypassWhitelisting extends OS.BypassWhitelisting {
   public BypassWhitelisting(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class PasswordPolicyDiscovery extends OS.PasswordPolicyDiscovery {
   public PasswordPolicyDiscovery(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class BruteForceWithPasswordPolicy extends OS.BruteForceWithPasswordPolicy {
   public BruteForceWithPasswordPolicy(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class BruteForce extends OS.BruteForce {
   public BruteForce(String name) {
      super(name);
      assetClassName = "Linux";
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
            return "linux.lockoutPolicies";
         }
   }
}

   public class CodeDelivered extends OS.CodeDelivered {
   public CodeDelivered(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class AntivirusCheck extends OS.AntivirusCheck {
   public AntivirusCheck(String name) {
      super(name);
      assetClassName = "Linux";
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
            return "linux.antivirus";
         }
   }
}

   public class RunCode extends OS.RunCode {
   public RunCode(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class SpearphishingAttachmentDownload extends OS.SpearphishingAttachmentDownload {
   public SpearphishingAttachmentDownload(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class SpearphishingLinkDownload extends OS.SpearphishingLinkDownload {
   public SpearphishingLinkDownload(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class Scripting extends OS.Scripting {
   public Scripting(String name) {
      super(name);
      assetClassName = "Linux";
   }
   }

   public class _scripting extends OS._scripting {
   public _scripting(String name) {
      super(name);
      assetClassName = "Linux";
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
            return "linux.restricedScripting";
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
            return "linux.sandboxing";
         }
   }
}

      public void addLinuxUser(User linuxUser) {
         this.linuxUser.add(linuxUser);
         linuxUser.linux = this;
      }

      public void addLinuxAdministrator(Administrator linuxAdministrator) {
         this.linuxAdministrator = linuxAdministrator;
         linuxAdministrator.linux.add(this);
      }

      public void addEmployee(Employee employee) {
         this.employee = employee;
         employee.linux.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("linuxUser")) {
         for (Object o: linuxUser) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("linuxAdministrator")) {
         return linuxAdministrator.getClass().getName();
      }
      if (roleName.equals("employee")) {
         return employee.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("linuxUser")  && linuxUser != null) {
         assets.addAll(linuxUser);
         return assets;
      }
      if (roleName.equals("linuxAdministrator")  && linuxAdministrator != null) {
         assets.add(linuxAdministrator);
         return assets;
      }
      if (roleName.equals("employee")  && employee != null) {
         assets.add(employee);
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
      assets.addAll(linuxUser);
      if (linuxAdministrator != null) {
         assets.add(linuxAdministrator);
      }
      if (employee != null) {
         assets.add(employee);
      }
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
