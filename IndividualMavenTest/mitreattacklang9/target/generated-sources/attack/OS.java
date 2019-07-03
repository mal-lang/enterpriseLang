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
   public java.util.Set<Computer> computer = new HashSet<>();

   public CodeDelivered codeDelivered;
   public AntivirusCheck antivirusCheck;
   public Antivirus antivirus;
   public RunCode runCode;

   public OS(Boolean antivirusState) {
      super();
      if (antivirus != null) {
         AttackStep.allAttackSteps.remove(antivirus.disable);
      }
      Defense.allDefenses.remove(antivirus);
      antivirus = new Antivirus(this.name, antivirusState);
      AttackStep.allAttackSteps.remove(codeDelivered);
      codeDelivered = new CodeDelivered(this.name);
      AttackStep.allAttackSteps.remove(antivirusCheck);
      antivirusCheck = new AntivirusCheck(this.name);
      AttackStep.allAttackSteps.remove(runCode);
      runCode = new RunCode(this.name);
      assetClassName = "OS";
   }

   public OS(String name, Boolean antivirusState) {
      super(name);
      if (antivirus != null) {
         AttackStep.allAttackSteps.remove(antivirus.disable);
      }
      Defense.allDefenses.remove(antivirus);
      antivirus = new Antivirus(this.name, antivirusState);
      AttackStep.allAttackSteps.remove(codeDelivered);
      codeDelivered = new CodeDelivered(this.name);
      AttackStep.allAttackSteps.remove(antivirusCheck);
      antivirusCheck = new AntivirusCheck(this.name);
      AttackStep.allAttackSteps.remove(runCode);
      runCode = new RunCode(this.name);
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


   public class CodeDelivered extends AttackStepMin {
   public CodeDelivered(String name) {
      super(name);
      assetClassName = "OS";
   }
@Override
public void setExpectedParents() {
for (Browser browser_kwTJd : browser) {
addExpectedParent(browser_kwTJd.checkBrowser);
}
for (Browser browser_lykKG : browser) {
addExpectedParent(browser_lykKG.checkPlugin);
}
for (Browser browser_RaXPr : browser) {
addExpectedParent(browser_RaXPr.compromisedBrowser);
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
for (Computer computer_KkMGw : computer) {
computer_KkMGw.infectedComputer.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("OS.runCode");
      }

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
      assets.addAll(browser);
      assets.addAll(computer);
      return assets;
   }
}
