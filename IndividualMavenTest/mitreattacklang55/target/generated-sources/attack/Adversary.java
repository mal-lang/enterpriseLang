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
public class Adversary extends Asset {
   public java.util.Set<Employee> employee = new HashSet<>();
   public java.util.Set<Browser> browser = new HashSet<>();
   public java.util.Set<OS> os = new HashSet<>();

   public MaliciousWebsite maliciousWebsite;
   public MaliciousAds maliciousAds;
   public SpearphishingAttachmentAttack spearphishingAttachmentAttack;
   public SpearphishingLinkAttack spearphishingLinkAttack;

   public Adversary() {
      super();
      AttackStep.allAttackSteps.remove(maliciousWebsite);
      maliciousWebsite = new MaliciousWebsite(this.name);
      AttackStep.allAttackSteps.remove(maliciousAds);
      maliciousAds = new MaliciousAds(this.name);
      AttackStep.allAttackSteps.remove(spearphishingAttachmentAttack);
      spearphishingAttachmentAttack = new SpearphishingAttachmentAttack(this.name);
      AttackStep.allAttackSteps.remove(spearphishingLinkAttack);
      spearphishingLinkAttack = new SpearphishingLinkAttack(this.name);
      assetClassName = "Adversary";
   }

   public Adversary(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(maliciousWebsite);
      maliciousWebsite = new MaliciousWebsite(this.name);
      AttackStep.allAttackSteps.remove(maliciousAds);
      maliciousAds = new MaliciousAds(this.name);
      AttackStep.allAttackSteps.remove(spearphishingAttachmentAttack);
      spearphishingAttachmentAttack = new SpearphishingAttachmentAttack(this.name);
      AttackStep.allAttackSteps.remove(spearphishingLinkAttack);
      spearphishingLinkAttack = new SpearphishingLinkAttack(this.name);
      assetClassName = "Adversary";
   }


   public class MaliciousWebsite extends AttackStepMin {
   public MaliciousWebsite(String name) {
      super(name);
      assetClassName = "Adversary";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Browser browser_jPyXA : browser) {
browser_jPyXA.maliciousWebsite.updateTtc(this, ttc, activeAttackSteps);
}
for (Employee employee_dVCXn : employee) {
employee_dVCXn.pageVisited.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Adversary.maliciousWebsite");
      }

   }

   public class MaliciousAds extends AttackStepMin {
   public MaliciousAds(String name) {
      super(name);
      assetClassName = "Adversary";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Browser browser_nGQzH : browser) {
browser_nGQzH.maliciousAds.updateTtc(this, ttc, activeAttackSteps);
}
for (Employee employee_SKrMm : employee) {
employee_SKrMm.adLinkClicked.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Adversary.maliciousAds");
      }

   }

   public class SpearphishingAttachmentAttack extends AttackStepMin {
   public SpearphishingAttachmentAttack(String name) {
      super(name);
      assetClassName = "Adversary";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Employee employee_rCLso : employee) {
employee_rCLso.spearphishingAttachmentDownload.updateTtc(this, ttc, activeAttackSteps);
}
for (Browser browser_QnfgE : browser) {
browser_QnfgE.spearphishingAttachment.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Adversary.spearphishingAttachmentAttack");
      }

   }

   public class SpearphishingLinkAttack extends AttackStepMin {
   public SpearphishingLinkAttack(String name) {
      super(name);
      assetClassName = "Adversary";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Employee employee_tEMGx : employee) {
employee_tEMGx.spearphishingLinkClicked.updateTtc(this, ttc, activeAttackSteps);
}
for (Browser browser_AfZHJ : browser) {
browser_AfZHJ.spearphishingLink.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Adversary.spearphishingLinkAttack");
      }

   }

      public void addEmployee(Employee employee) {
         this.employee.add(employee);
         employee.adversary = this;
      }

      public void addBrowser(Browser browser) {
         this.browser.add(browser);
         browser.adversary = this;
      }

      public void addOs(OS os) {
         this.os.add(os);
         os.adversary = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("employee")) {
         for (Object o: employee) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("browser")) {
         for (Object o: browser) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("os")) {
         for (Object o: os) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("employee")  && employee != null) {
         assets.addAll(employee);
         return assets;
      }
      if (roleName.equals("browser")  && browser != null) {
         assets.addAll(browser);
         return assets;
      }
      if (roleName.equals("os")  && os != null) {
         assets.addAll(os);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(employee);
      assets.addAll(browser);
      assets.addAll(os);
      return assets;
   }
}
