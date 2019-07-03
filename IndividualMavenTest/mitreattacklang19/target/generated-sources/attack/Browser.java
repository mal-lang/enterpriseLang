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

   public SpearphishingAttachment spearphishingAttachment;
   public BlockAttachmentsCheck blockAttachmentsCheck;
   public Phishingdetection phishingdetection;

   public Browser(Boolean blockAttachmentsCheckState, Boolean phishingdetectionState) {
      super();
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
      AttackStep.allAttackSteps.remove(spearphishingAttachment);
      spearphishingAttachment = new SpearphishingAttachment(this.name);
      assetClassName = "Browser";
   }

   public Browser(String name, Boolean blockAttachmentsCheckState, Boolean phishingdetectionState) {
      super(name);
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
      AttackStep.allAttackSteps.remove(spearphishingAttachment);
      spearphishingAttachment = new SpearphishingAttachment(this.name);
      assetClassName = "Browser";
   }

   public Browser() {
      this(false, false);
      assetClassName = "Browser";
   }

   public Browser(String name) {
      this(name, false, false);
      assetClassName = "Browser";
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
