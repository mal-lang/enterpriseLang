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
public class Employee extends Asset {
   public java.util.Set<Browser> browser = new HashSet<>();
   public Adversary adversary;

   public PageVisited pageVisited;
   public AdLinkClicked adLinkClicked;

   public Employee() {
      super();
      AttackStep.allAttackSteps.remove(pageVisited);
      pageVisited = new PageVisited(this.name);
      AttackStep.allAttackSteps.remove(adLinkClicked);
      adLinkClicked = new AdLinkClicked(this.name);
      assetClassName = "Employee";
   }

   public Employee(String name) {
      super(name);
      AttackStep.allAttackSteps.remove(pageVisited);
      pageVisited = new PageVisited(this.name);
      AttackStep.allAttackSteps.remove(adLinkClicked);
      adLinkClicked = new AdLinkClicked(this.name);
      assetClassName = "Employee";
   }


   public class PageVisited extends AttackStepMin {
   public PageVisited(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
if (adversary != null) {
addExpectedParent(adversary.maliciousWebsite);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Browser browser_vQtme : browser) {
browser_vQtme.maliciousWebsite.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.pageVisited");
      }

   }

   public class AdLinkClicked extends AttackStepMin {
   public AdLinkClicked(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
if (adversary != null) {
addExpectedParent(adversary.maliciousAds);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Browser browser_rHtyT : browser) {
browser_rHtyT.maliciousAds.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.adLinkClicked");
      }

   }

      public void addBrowser(Browser browser) {
         this.browser.add(browser);
         browser.employee = this;
      }

      public void addAdversary(Adversary adversary) {
         this.adversary = adversary;
         adversary.employee.add(this);
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("browser")) {
         for (Object o: browser) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("adversary")) {
         return adversary.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("browser")  && browser != null) {
         assets.addAll(browser);
         return assets;
      }
      if (roleName.equals("adversary")  && adversary != null) {
         assets.add(adversary);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(browser);
      if (adversary != null) {
         assets.add(adversary);
      }
      return assets;
   }
}
