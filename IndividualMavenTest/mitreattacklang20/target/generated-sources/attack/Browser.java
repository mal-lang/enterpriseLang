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
   public Employee employee;
   public Adversary adversary;
   public OS os;

   public SpearphishingLink spearphishingLink;
   public PhishingDetection phishingDetection;

   public Browser(Boolean phishingDetectionState) {
      super();
      if (phishingDetection != null) {
         AttackStep.allAttackSteps.remove(phishingDetection.disable);
      }
      Defense.allDefenses.remove(phishingDetection);
      phishingDetection = new PhishingDetection(this.name, phishingDetectionState);
      AttackStep.allAttackSteps.remove(spearphishingLink);
      spearphishingLink = new SpearphishingLink(this.name);
      assetClassName = "Browser";
   }

   public Browser(String name, Boolean phishingDetectionState) {
      super(name);
      if (phishingDetection != null) {
         AttackStep.allAttackSteps.remove(phishingDetection.disable);
      }
      Defense.allDefenses.remove(phishingDetection);
      phishingDetection = new PhishingDetection(this.name, phishingDetectionState);
      AttackStep.allAttackSteps.remove(spearphishingLink);
      spearphishingLink = new SpearphishingLink(this.name);
      assetClassName = "Browser";
   }

   public Browser() {
      this(false);
      assetClassName = "Browser";
   }

   public Browser(String name) {
      this(name, false);
      assetClassName = "Browser";
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
addExpectedParent(phishingDetection.disable);
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

   public class PhishingDetection extends Defense {
   public PhishingDetection(String name, Boolean enabled) {
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
            return "browser.phishingDetection";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
spearphishingLink.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addEmployee(Employee employee) {
         this.employee = employee;
         employee.browser.add(this);
      }

      public void addAdversary(Adversary adversary) {
         this.adversary = adversary;
         adversary.browser.add(this);
      }

      public void addOs(OS os) {
         this.os = os;
         os.browser.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("employee")) {
         return employee.getClass().getName();
      }
      if (roleName.equals("adversary")) {
         return adversary.getClass().getName();
      }
      if (roleName.equals("os")) {
         return os.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("employee")  && employee != null) {
         assets.add(employee);
         return assets;
      }
      if (roleName.equals("adversary")  && adversary != null) {
         assets.add(adversary);
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
      if (employee != null) {
         assets.add(employee);
      }
      if (adversary != null) {
         assets.add(adversary);
      }
      if (os != null) {
         assets.add(os);
      }
      return assets;
   }
}
