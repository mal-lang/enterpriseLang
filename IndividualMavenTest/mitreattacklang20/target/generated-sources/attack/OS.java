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
   public java.util.Set<Browser> browser = new HashSet<>();

   public SpearphishingLinkDownload spearphishingLinkDownload;
   public Antivirus antivirus;

   public OS(Boolean antivirusState) {
      super();
      if (antivirus != null) {
         AttackStep.allAttackSteps.remove(antivirus.disable);
      }
      Defense.allDefenses.remove(antivirus);
      antivirus = new Antivirus(this.name, antivirusState);
      AttackStep.allAttackSteps.remove(spearphishingLinkDownload);
      spearphishingLinkDownload = new SpearphishingLinkDownload(this.name);
      assetClassName = "OS";
   }

   public OS(String name, Boolean antivirusState) {
      super(name);
      if (antivirus != null) {
         AttackStep.allAttackSteps.remove(antivirus.disable);
      }
      Defense.allDefenses.remove(antivirus);
      antivirus = new Antivirus(this.name, antivirusState);
      AttackStep.allAttackSteps.remove(spearphishingLinkDownload);
      spearphishingLinkDownload = new SpearphishingLinkDownload(this.name);
      assetClassName = "OS";
   }

   public OS() {
      this(false);
      assetClassName = "OS";
   }

   public OS(String name) {
      this(name, false);
      assetClassName = "OS";
   }


   public class SpearphishingLinkDownload extends AttackStepMax {
   public SpearphishingLinkDownload(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
for (Browser browser_ojehT : browser) {
addExpectedParent(browser_ojehT.spearphishingLink);
}
addExpectedParent(antivirus.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.spearphishingLinkDownload");
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
spearphishingLinkDownload.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

      public void addBrowser(Browser browser) {
         this.browser.add(browser);
         browser.os = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("browser")) {
         for (Object o: browser) {
            return o.getClass().getName();
         }
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
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(browser);
      return assets;
   }
}
