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
public class Browser extends Asset {
   public Adversary adversary;
   public Employee employee;
   public OS os;

   public MaliciousWebsite maliciousWebsite;
   public CheckBrowser checkBrowser;
   public NonVulnerableBrowser nonVulnerableBrowser;
   public CheckPlugin checkPlugin;
   public NonVulnerablePlugin nonVulnerablePlugin;
   public MaliciousAds maliciousAds;
   public CompromisedBrowser compromisedBrowser;
   public Adblocker adblocker;
   public SpearphishingLink spearphishingLink;
   public SpearphishingAttachment spearphishingAttachment;
   public BlockAttachmentsCheck blockAttachmentsCheck;
   public Phishingdetection phishingdetection;

   public Browser(Boolean nonVulnerableBrowserState, Boolean nonVulnerablePluginState, Boolean adblockerState, Boolean blockAttachmentsCheckState, Boolean phishingdetectionState) {
      super();
      if (nonVulnerableBrowser != null) {
         AttackStep.allAttackSteps.remove(nonVulnerableBrowser.disable);
      }
      Defense.allDefenses.remove(nonVulnerableBrowser);
      nonVulnerableBrowser = new NonVulnerableBrowser(this.name, nonVulnerableBrowserState);
      if (nonVulnerablePlugin != null) {
         AttackStep.allAttackSteps.remove(nonVulnerablePlugin.disable);
      }
      Defense.allDefenses.remove(nonVulnerablePlugin);
      nonVulnerablePlugin = new NonVulnerablePlugin(this.name, nonVulnerablePluginState);
      if (adblocker != null) {
         AttackStep.allAttackSteps.remove(adblocker.disable);
      }
      Defense.allDefenses.remove(adblocker);
      adblocker = new Adblocker(this.name, adblockerState);
      if (blockAttachmentsCheck != null) {
         AttackStep.allAttackSteps.remove(blockAttachmentsCheck.disable);
      }
      Defense.allDefenses.remove(blockAttachmentsCheck);
      blockAttachmentsCheck = new BlockAttachmentsCheck(this.name, blockAttachmentsCheckState);
      if (phishingdetection != null) {
         AttackStep.allAttackSteps.remove(phishingdetection.disable);
      }
      Defense.allDefenses.remove(phishingdetection);
      phishingdetection = new Phishingdetection(this.name, phishingdetectionState);
      AttackStep.allAttackSteps.remove(maliciousWebsite);
      maliciousWebsite = new MaliciousWebsite(this.name);
      AttackStep.allAttackSteps.remove(checkBrowser);
      checkBrowser = new CheckBrowser(this.name);
      AttackStep.allAttackSteps.remove(checkPlugin);
      checkPlugin = new CheckPlugin(this.name);
      AttackStep.allAttackSteps.remove(maliciousAds);
      maliciousAds = new MaliciousAds(this.name);
      AttackStep.allAttackSteps.remove(compromisedBrowser);
      compromisedBrowser = new CompromisedBrowser(this.name);
      AttackStep.allAttackSteps.remove(spearphishingLink);
      spearphishingLink = new SpearphishingLink(this.name);
      AttackStep.allAttackSteps.remove(spearphishingAttachment);
      spearphishingAttachment = new SpearphishingAttachment(this.name);
      assetClassName = "Browser";
   }

   public Browser(String name, Boolean nonVulnerableBrowserState, Boolean nonVulnerablePluginState, Boolean adblockerState, Boolean blockAttachmentsCheckState, Boolean phishingdetectionState) {
      super(name);
      if (nonVulnerableBrowser != null) {
         AttackStep.allAttackSteps.remove(nonVulnerableBrowser.disable);
      }
      Defense.allDefenses.remove(nonVulnerableBrowser);
      nonVulnerableBrowser = new NonVulnerableBrowser(this.name, nonVulnerableBrowserState);
      if (nonVulnerablePlugin != null) {
         AttackStep.allAttackSteps.remove(nonVulnerablePlugin.disable);
      }
      Defense.allDefenses.remove(nonVulnerablePlugin);
      nonVulnerablePlugin = new NonVulnerablePlugin(this.name, nonVulnerablePluginState);
      if (adblocker != null) {
         AttackStep.allAttackSteps.remove(adblocker.disable);
      }
      Defense.allDefenses.remove(adblocker);
      adblocker = new Adblocker(this.name, adblockerState);
      if (blockAttachmentsCheck != null) {
         AttackStep.allAttackSteps.remove(blockAttachmentsCheck.disable);
      }
      Defense.allDefenses.remove(blockAttachmentsCheck);
      blockAttachmentsCheck = new BlockAttachmentsCheck(this.name, blockAttachmentsCheckState);
      if (phishingdetection != null) {
         AttackStep.allAttackSteps.remove(phishingdetection.disable);
      }
      Defense.allDefenses.remove(phishingdetection);
      phishingdetection = new Phishingdetection(this.name, phishingdetectionState);
      AttackStep.allAttackSteps.remove(maliciousWebsite);
      maliciousWebsite = new MaliciousWebsite(this.name);
      AttackStep.allAttackSteps.remove(checkBrowser);
      checkBrowser = new CheckBrowser(this.name);
      AttackStep.allAttackSteps.remove(checkPlugin);
      checkPlugin = new CheckPlugin(this.name);
      AttackStep.allAttackSteps.remove(maliciousAds);
      maliciousAds = new MaliciousAds(this.name);
      AttackStep.allAttackSteps.remove(compromisedBrowser);
      compromisedBrowser = new CompromisedBrowser(this.name);
      AttackStep.allAttackSteps.remove(spearphishingLink);
      spearphishingLink = new SpearphishingLink(this.name);
      AttackStep.allAttackSteps.remove(spearphishingAttachment);
      spearphishingAttachment = new SpearphishingAttachment(this.name);
      assetClassName = "Browser";
   }

   public Browser() {
      this(false, false, false, false, false);
      assetClassName = "Browser";
   }

   public Browser(String name) {
      this(name, false, false, false, false, false);
      assetClassName = "Browser";
   }


   public class MaliciousWebsite extends AttackStepMin {
   public MaliciousWebsite(String name) {
      super(name);
      assetClassName = "Browser";
   }
@Override
public void setExpectedParents() {
if (employee != null) {
addExpectedParent(employee.pageVisited);
}
if (adversary != null) {
addExpectedParent(adversary.maliciousWebsite);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
checkPlugin.updateTtc(this, ttc, activeAttackSteps);
checkBrowser.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Browser.maliciousWebsite");
      }

   }

   public class CheckBrowser extends AttackStepMax {
   public CheckBrowser(String name) {
      super(name);
      assetClassName = "Browser";
   }
@Override
public void setExpectedParents() {
addExpectedParent(maliciousWebsite);
addExpectedParent(nonVulnerableBrowser.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (os != null) {
os.codeDelivered.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Browser.checkBrowser");
      }

   }

   public class NonVulnerableBrowser extends Defense {
   public NonVulnerableBrowser(String name, Boolean enabled) {
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
            return "browser.nonVulnerableBrowser";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
checkBrowser.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class CheckPlugin extends AttackStepMax {
   public CheckPlugin(String name) {
      super(name);
      assetClassName = "Browser";
   }
@Override
public void setExpectedParents() {
addExpectedParent(maliciousWebsite);
addExpectedParent(nonVulnerablePlugin.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (os != null) {
os.codeDelivered.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Browser.checkPlugin");
      }

   }

   public class NonVulnerablePlugin extends Defense {
   public NonVulnerablePlugin(String name, Boolean enabled) {
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
            return "browser.nonVulnerablePlugin";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
checkPlugin.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class MaliciousAds extends AttackStepMin {
   public MaliciousAds(String name) {
      super(name);
      assetClassName = "Browser";
   }
@Override
public void setExpectedParents() {
if (employee != null) {
addExpectedParent(employee.adLinkClicked);
}
if (adversary != null) {
addExpectedParent(adversary.maliciousAds);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
compromisedBrowser.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Browser.maliciousAds");
      }

   }

   public class CompromisedBrowser extends AttackStepMax {
   public CompromisedBrowser(String name) {
      super(name);
      assetClassName = "Browser";
   }
@Override
public void setExpectedParents() {
addExpectedParent(maliciousAds);
addExpectedParent(adblocker.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (os != null) {
os.codeDelivered.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Browser.compromisedBrowser");
      }

   }

   public class Adblocker extends Defense {
   public Adblocker(String name, Boolean enabled) {
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
            return "browser.adblocker";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
compromisedBrowser.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class SpearphishingLink extends AttackStepMax {
   public SpearphishingLink(String name) {
      super(name);
      assetClassName = "Browser";
   }
@Override
public void setExpectedParents() {
if (employee != null) {
addExpectedParent(employee.spearphishingLinkClicked);
}
if (adversary != null) {
addExpectedParent(adversary.spearphishingLinkAttack);
}
addExpectedParent(phishingdetection.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (os != null) {
os.spearphishingLinkDownload.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Browser.spearphishingLink");
      }

   }

   public class SpearphishingAttachment extends AttackStepMax {
   public SpearphishingAttachment(String name) {
      super(name);
      assetClassName = "Browser";
   }
@Override
public void setExpectedParents() {
if (employee != null) {
addExpectedParent(employee.spearphishingAttachmentDownload);
}
if (adversary != null) {
addExpectedParent(adversary.spearphishingAttachmentAttack);
}
addExpectedParent(blockAttachmentsCheck.disable);
addExpectedParent(phishingdetection.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (os != null) {
os.spearphishingAttachmentDownload.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Browser.spearphishingAttachment");
      }

   }

   public class BlockAttachmentsCheck extends Defense {
   public BlockAttachmentsCheck(String name, Boolean enabled) {
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
            return "browser.blockAttachmentsCheck";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
spearphishingAttachment.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class Phishingdetection extends Defense {
   public Phishingdetection(String name, Boolean enabled) {
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
            return "browser.phishingdetection";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
spearphishingAttachment.updateTtc(this, ttc, activeAttackSteps);
spearphishingLink.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addAdversary(Adversary adversary) {
         this.adversary = adversary;
         adversary.browser.add(this);
      }

      public void addEmployee(Employee employee) {
         this.employee = employee;
         employee.browser.add(this);
      }

      public void addOs(OS os) {
         this.os = os;
         os.browser.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("adversary")) {
         return adversary.getClass().getName();
      }
      if (roleName.equals("employee")) {
         return employee.getClass().getName();
      }
      if (roleName.equals("os")) {
         return os.getClass().getName();
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
      if (roleName.equals("employee")  && employee != null) {
         assets.add(employee);
         return assets;
      }
      if (roleName.equals("os")  && os != null) {
         assets.add(os);
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
      if (employee != null) {
         assets.add(employee);
      }
      if (os != null) {
         assets.add(os);
      }
      return assets;
   }
}
