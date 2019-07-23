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
public class OS extends Asset {
   public Adversary adversary;
   public User user;
   public Administrator administrator;
   public Employee employee;
   public java.util.Set<Browser> browser = new HashSet<>();
   public java.util.Set<Computer> computer = new HashSet<>();

   public AccountDiscovery accountDiscovery;
   public DomainDiscovery domainDiscovery;
   public ApplicationWindowDiscovery applicationWindowDiscovery;
   public RunningProcessDiscovery runningProcessDiscovery;
   public DetailedRunningProcessDiscovery detailedRunningProcessDiscovery;
   public RemoteSystemDiscovery remoteSystemDiscovery;
   public DetailedRemoteSystemDiscovery detailedRemoteSystemDiscovery;
   public AdminCommandLineInterface adminCommandLineInterface;
   public UserCommandLineInterface userCommandLineInterface;
   public SystemInformationDiscovery systemInformationDiscovery;
   public Whitelisting whitelisting;
   public ProcessInjection processInjection;
   public BypassAntivirus bypassAntivirus;
   public BypassWhitelisting bypassWhitelisting;
   public PasswordPolicyDiscovery passwordPolicyDiscovery;
   public BruteForceWithPasswordPolicy bruteForceWithPasswordPolicy;
   public BruteForce bruteForce;
   public LockoutPolicies lockoutPolicies;
   public CodeDelivered codeDelivered;
   public AntivirusCheck antivirusCheck;
   public Antivirus antivirus;
   public RunCode runCode;
   public SpearphishingAttachmentDownload spearphishingAttachmentDownload;
   public SpearphishingLinkDownload spearphishingLinkDownload;
   public Scripting scripting;
   public _scripting _scripting;
   public RestricedScripting restricedScripting;
   public Sandboxing sandboxing;

   public OS(Boolean whitelistingState, Boolean lockoutPoliciesState, Boolean antivirusState, Boolean restricedScriptingState, Boolean sandboxingState) {
      super();
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
      assetClassName = "OS";
   }

   public OS(String name, Boolean whitelistingState, Boolean lockoutPoliciesState, Boolean antivirusState, Boolean restricedScriptingState, Boolean sandboxingState) {
      super(name);
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
      assetClassName = "OS";
   }

   public OS() {
      this(false, false, false, false, false);
      assetClassName = "OS";
   }

   public OS(String name) {
      this(name, false, false, false, false, false);
      assetClassName = "OS";
   }


   public class AccountDiscovery extends AttackStepMax {
   public AccountDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.accountDiscovery");
      }

   }

   public class DomainDiscovery extends AttackStepMax {
   public DomainDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.domainDiscovery");
      }

   }

   public class ApplicationWindowDiscovery extends AttackStepMax {
   public ApplicationWindowDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.applicationWindowDiscovery");
      }

   }

   public class RunningProcessDiscovery extends AttackStepMax {
   public RunningProcessDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
processInjection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.runningProcessDiscovery");
      }

   }

   public class DetailedRunningProcessDiscovery extends AttackStepMax {
   public DetailedRunningProcessDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.detailedRunningProcessDiscovery");
      }

   }

   public class RemoteSystemDiscovery extends AttackStepMax {
   public RemoteSystemDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.remoteSystemDiscovery");
      }

   }

   public class DetailedRemoteSystemDiscovery extends AttackStepMax {
   public DetailedRemoteSystemDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.detailedRemoteSystemDiscovery");
      }

   }

   public class AdminCommandLineInterface extends AttackStepMax {
   public AdminCommandLineInterface(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_jaIvW : computer) {
computer_jaIvW.dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.adminCommandLineInterface");
      }

   }

   public class UserCommandLineInterface extends AttackStepMax {
   public UserCommandLineInterface(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_ZeHSC : computer) {
computer_ZeHSC.dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.userCommandLineInterface");
      }

   }

   public class SystemInformationDiscovery extends AttackStepMax {
   public SystemInformationDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.systemInformationDiscovery");
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
            return "oS.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
accountDiscovery.updateTtc(this, ttc, activeAttackSteps);
domainDiscovery.updateTtc(this, ttc, activeAttackSteps);
applicationWindowDiscovery.updateTtc(this, ttc, activeAttackSteps);
runningProcessDiscovery.updateTtc(this, ttc, activeAttackSteps);
detailedRunningProcessDiscovery.updateTtc(this, ttc, activeAttackSteps);
remoteSystemDiscovery.updateTtc(this, ttc, activeAttackSteps);
detailedRemoteSystemDiscovery.updateTtc(this, ttc, activeAttackSteps);
adminCommandLineInterface.updateTtc(this, ttc, activeAttackSteps);
userCommandLineInterface.updateTtc(this, ttc, activeAttackSteps);
processInjection.updateTtc(this, ttc, activeAttackSteps);
systemInformationDiscovery.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class ProcessInjection extends AttackStepMax {
   public ProcessInjection(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(runningProcessDiscovery);
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (administrator != null) {
administrator.adminRights.updateTtc(this, ttc, activeAttackSteps);
}
bypassAntivirus.updateTtc(this, ttc, activeAttackSteps);
bypassWhitelisting.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.processInjection");
      }

   }

   public class BypassAntivirus extends AttackStepMin {
   public BypassAntivirus(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(processInjection);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.bypassAntivirus");
      }

   }

   public class BypassWhitelisting extends AttackStepMin {
   public BypassWhitelisting(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(processInjection);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.bypassWhitelisting");
      }

   }

   public class PasswordPolicyDiscovery extends AttackStepMin {
   public PasswordPolicyDiscovery(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
bruteForceWithPasswordPolicy.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.passwordPolicyDiscovery");
      }

   }

   public class BruteForceWithPasswordPolicy extends AttackStepMax {
   public BruteForceWithPasswordPolicy(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(passwordPolicyDiscovery);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (user != null) {
user.userCredentials.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.bruteForceWithPasswordPolicy");
      }

   }

   public class BruteForce extends AttackStepMax {
   public BruteForce(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
addExpectedParent(lockoutPolicies.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (user != null) {
user.userCredentials.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.bruteForce");
      }

   }

   public class LockoutPolicies extends Defense {
   public LockoutPolicies(String name, Boolean enabled) {
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
            return "oS.lockoutPolicies";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
bruteForce.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class CodeDelivered extends AttackStepMin {
   public CodeDelivered(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
for (Browser browser_RtoRs : browser) {
addExpectedParent(browser_RtoRs.checkBrowser);
}
for (Browser browser_fhypz : browser) {
addExpectedParent(browser_fhypz.checkPlugin);
}
for (Browser browser_KiUlC : browser) {
addExpectedParent(browser_KiUlC.compromisedBrowser);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
antivirusCheck.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.codeDelivered");
      }

   }

   public class AntivirusCheck extends AttackStepMax {
   public AntivirusCheck(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(codeDelivered);
addExpectedParent(antivirus.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
runCode.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.antivirusCheck");
      }

   }

   public class Antivirus extends Defense {
   public Antivirus(String name, Boolean enabled) {
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
            return "oS.antivirus";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
antivirusCheck.updateTtc(this, ttc, activeAttackSteps);
spearphishingAttachmentDownload.updateTtc(this, ttc, activeAttackSteps);
spearphishingLinkDownload.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class RunCode extends AttackStepMin {
   public RunCode(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(antivirusCheck);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_lWZam : computer) {
computer_lWZam.infectedComputer.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.runCode");
      }

   }

   public class SpearphishingAttachmentDownload extends AttackStepMax {
   public SpearphishingAttachmentDownload(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(antivirus.disable);
for (Browser browser_EIFIy : browser) {
addExpectedParent(browser_EIFIy.spearphishingAttachment);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (employee != null) {
employee.userExecution.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.spearphishingAttachmentDownload");
      }

   }

   public class SpearphishingLinkDownload extends AttackStepMax {
   public SpearphishingLinkDownload(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(antivirus.disable);
for (Browser browser_dKYAF : browser) {
addExpectedParent(browser_dKYAF.spearphishingLink);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (employee != null) {
employee.userExecution.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.spearphishingLinkDownload");
      }

   }

   public class Scripting extends AttackStepMin {
   public Scripting(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
if (user != null) {
addExpectedParent(user.userRights);
}
if (employee != null) {
addExpectedParent(employee.userExecution);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_scripting.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.scripting");
      }

   }

   public class _scripting extends AttackStepMax {
   public _scripting(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
addExpectedParent(scripting);
addExpectedParent(restricedScripting.disable);
addExpectedParent(sandboxing.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_kIsCd : computer) {
computer_kIsCd.automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS._scripting");
      }

   }

   public class RestricedScripting extends Defense {
   public RestricedScripting(String name, Boolean enabled) {
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
            return "oS.restricedScripting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_scripting.updateTtc(this, ttc, activeAttackSteps);
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
            return "oS.sandboxing";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_scripting.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addAdversary(Adversary adversary) {
         this.adversary = adversary;
         adversary.os.add(this);
      }

      public void addUser(User user) {
         this.user = user;
         user.os.add(this);
      }

      public void addAdministrator(Administrator administrator) {
         this.administrator = administrator;
         administrator.os.add(this);
      }

      public void addEmployee(Employee employee) {
         this.employee = employee;
         employee.os.add(this);
      }

      public void addBrowser(Browser browser) {
         this.browser.add(browser);
         browser.os = this;
      }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.os = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("adversary")) {
         return adversary.getClass().getName();
      }
      if (roleName.equals("user")) {
         return user.getClass().getName();
      }
      if (roleName.equals("administrator")) {
         return administrator.getClass().getName();
      }
      if (roleName.equals("employee")) {
         return employee.getClass().getName();
      }
      if (roleName.equals("browser")) {
         for (Object o: browser) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("computer")) {
         for (Object o: computer) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
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
