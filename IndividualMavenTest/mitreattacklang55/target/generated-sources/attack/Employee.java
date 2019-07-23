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
   public Adversary adversary;
   public java.util.Set<Browser> browser = new HashSet<>();
   public java.util.Set<Computer> computer = new HashSet<>();
   public java.util.Set<User> user = new HashSet<>();
   public java.util.Set<OS> os = new HashSet<>();
   public java.util.Set<MacOS> macOS = new HashSet<>();
   public java.util.Set<Linux> linux = new HashSet<>();
   public java.util.Set<RemovableMedia> removableMedia = new HashSet<>();

   public SpearphishingLinkClicked spearphishingLinkClicked;
   public PageVisited pageVisited;
   public AdLinkClicked adLinkClicked;
   public SpearphishingAttachmentDownload spearphishingAttachmentDownload;
   public TrainedEmployee trainedEmployee;
   public UserExecution userExecution;
   public InsertMedia insertMedia;
   public ManualManipulation manualManipulation;
   public MediaInserted mediaInserted;
   public _mediaInserted _mediaInserted;

   public Employee(Boolean trainedEmployeeState) {
      super();
      if (trainedEmployee != null) {
         AttackStep.allAttackSteps.remove(trainedEmployee.disable);
      }
      Defense.allDefenses.remove(trainedEmployee);
      trainedEmployee = new TrainedEmployee(this.name, trainedEmployeeState);
      AttackStep.allAttackSteps.remove(spearphishingLinkClicked);
      spearphishingLinkClicked = new SpearphishingLinkClicked(this.name);
      AttackStep.allAttackSteps.remove(pageVisited);
      pageVisited = new PageVisited(this.name);
      AttackStep.allAttackSteps.remove(adLinkClicked);
      adLinkClicked = new AdLinkClicked(this.name);
      AttackStep.allAttackSteps.remove(spearphishingAttachmentDownload);
      spearphishingAttachmentDownload = new SpearphishingAttachmentDownload(this.name);
      AttackStep.allAttackSteps.remove(userExecution);
      userExecution = new UserExecution(this.name);
      AttackStep.allAttackSteps.remove(insertMedia);
      insertMedia = new InsertMedia(this.name);
      AttackStep.allAttackSteps.remove(manualManipulation);
      manualManipulation = new ManualManipulation(this.name);
      AttackStep.allAttackSteps.remove(mediaInserted);
      mediaInserted = new MediaInserted(this.name);
      AttackStep.allAttackSteps.remove(_mediaInserted);
      _mediaInserted = new _mediaInserted(this.name);
      assetClassName = "Employee";
   }

   public Employee(String name, Boolean trainedEmployeeState) {
      super(name);
      if (trainedEmployee != null) {
         AttackStep.allAttackSteps.remove(trainedEmployee.disable);
      }
      Defense.allDefenses.remove(trainedEmployee);
      trainedEmployee = new TrainedEmployee(this.name, trainedEmployeeState);
      AttackStep.allAttackSteps.remove(spearphishingLinkClicked);
      spearphishingLinkClicked = new SpearphishingLinkClicked(this.name);
      AttackStep.allAttackSteps.remove(pageVisited);
      pageVisited = new PageVisited(this.name);
      AttackStep.allAttackSteps.remove(adLinkClicked);
      adLinkClicked = new AdLinkClicked(this.name);
      AttackStep.allAttackSteps.remove(spearphishingAttachmentDownload);
      spearphishingAttachmentDownload = new SpearphishingAttachmentDownload(this.name);
      AttackStep.allAttackSteps.remove(userExecution);
      userExecution = new UserExecution(this.name);
      AttackStep.allAttackSteps.remove(insertMedia);
      insertMedia = new InsertMedia(this.name);
      AttackStep.allAttackSteps.remove(manualManipulation);
      manualManipulation = new ManualManipulation(this.name);
      AttackStep.allAttackSteps.remove(mediaInserted);
      mediaInserted = new MediaInserted(this.name);
      AttackStep.allAttackSteps.remove(_mediaInserted);
      _mediaInserted = new _mediaInserted(this.name);
      assetClassName = "Employee";
   }

   public Employee() {
      this(false);
      assetClassName = "Employee";
   }

   public Employee(String name) {
      this(name, false);
      assetClassName = "Employee";
   }


   public class SpearphishingLinkClicked extends AttackStepMax {
   public SpearphishingLinkClicked(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
addExpectedParent(trainedEmployee.disable);
if (adversary != null) {
addExpectedParent(adversary.spearphishingLinkAttack);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Browser browser_UYtyE : browser) {
browser_UYtyE.spearphishingLink.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.spearphishingLinkClicked");
      }

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
for (Browser browser_mHJsu : browser) {
browser_mHJsu.maliciousWebsite.updateTtc(this, ttc, activeAttackSteps);
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
for (Browser browser_RaICO : browser) {
browser_RaICO.maliciousAds.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.adLinkClicked");
      }

   }

   public class SpearphishingAttachmentDownload extends AttackStepMax {
   public SpearphishingAttachmentDownload(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
addExpectedParent(trainedEmployee.disable);
if (adversary != null) {
addExpectedParent(adversary.spearphishingAttachmentAttack);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Browser browser_VMhfi : browser) {
browser_VMhfi.spearphishingAttachment.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.spearphishingAttachmentDownload");
      }

   }

   public class TrainedEmployee extends Defense {
   public TrainedEmployee(String name, Boolean enabled) {
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
            return "employee.trainedEmployee";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
spearphishingAttachmentDownload.updateTtc(this, ttc, activeAttackSteps);
spearphishingLinkClicked.updateTtc(this, ttc, activeAttackSteps);
userExecution.updateTtc(this, ttc, activeAttackSteps);
_mediaInserted.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class UserExecution extends AttackStepMax {
   public UserExecution(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
addExpectedParent(trainedEmployee.disable);
addExpectedParent(insertMedia);
for (OS oS_afHoE : os) {
addExpectedParent(oS_afHoE.spearphishingAttachmentDownload);
}
for (OS oS_Ixcvo : os) {
addExpectedParent(oS_Ixcvo.spearphishingLinkDownload);
}
for (Linux linux_KjrFI : linux) {
addExpectedParent(linux_KjrFI.spaceAfterFileName);
}
for (MacOS macOS_VfhfM : macOS) {
addExpectedParent(macOS_VfhfM.spaceAfterFileName);
}
for (Computer computer_PPWhH : computer) {
addExpectedParent(computer_PPWhH.uploadRemoteFile);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_oXJrI : computer) {
computer_oXJrI.infectedComputer.updateTtc(this, ttc, activeAttackSteps);
}
for (Computer computer_wVcgC : computer) {
computer_wVcgC.infectedWindowsComputer.updateTtc(this, ttc, activeAttackSteps);
}
for (OS oS_fltGN : os) {
oS_fltGN.scripting.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.userExecution");
      }

   }

   public class InsertMedia extends AttackStepMin {
   public InsertMedia(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
for (RemovableMedia removableMedia_eedic : removableMedia) {
addExpectedParent(removableMedia_eedic.infectedMedia);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
userExecution.updateTtc(this, ttc, activeAttackSteps);
manualManipulation.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.insertMedia");
      }

   }

   public class ManualManipulation extends AttackStepMin {
   public ManualManipulation(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
addExpectedParent(insertMedia);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (User user_VLHHV : user) {
user_VLHHV.userRights.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.manualManipulation");
      }

   }

   public class MediaInserted extends AttackStepMin {
   public MediaInserted(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_mediaInserted.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee.mediaInserted");
      }

   }

   public class _mediaInserted extends AttackStepMax {
   public _mediaInserted(String name) {
      super(name);
      assetClassName = "Employee";
   }
@Override
public void setExpectedParents() {
addExpectedParent(trainedEmployee.disable);
addExpectedParent(mediaInserted);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (RemovableMedia removableMedia_giyyj : removableMedia) {
removableMedia_giyyj.dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Employee._mediaInserted");
      }

   }

      public void addAdversary(Adversary adversary) {
         this.adversary = adversary;
         adversary.employee.add(this);
      }

      public void addBrowser(Browser browser) {
         this.browser.add(browser);
         browser.employee = this;
      }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.employee = this;
      }

      public void addUser(User user) {
         this.user.add(user);
         user.employee = this;
      }

      public void addOs(OS os) {
         this.os.add(os);
         os.employee = this;
      }

      public void addMacOS(MacOS macOS) {
         this.macOS.add(macOS);
         macOS.employee = this;
      }

      public void addLinux(Linux linux) {
         this.linux.add(linux);
         linux.employee = this;
      }

      public void addRemovableMedia(RemovableMedia removableMedia) {
         this.removableMedia.add(removableMedia);
         removableMedia.employee = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("adversary")) {
         return adversary.getClass().getName();
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
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("os")) {
         for (Object o: os) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("macOS")) {
         for (Object o: macOS) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("linux")) {
         for (Object o: linux) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("removableMedia")) {
         for (Object o: removableMedia) {
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
      if (roleName.equals("browser")  && browser != null) {
         assets.addAll(browser);
         return assets;
      }
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
      if (roleName.equals("user")  && user != null) {
         assets.addAll(user);
         return assets;
      }
      if (roleName.equals("os")  && os != null) {
         assets.addAll(os);
         return assets;
      }
      if (roleName.equals("macOS")  && macOS != null) {
         assets.addAll(macOS);
         return assets;
      }
      if (roleName.equals("linux")  && linux != null) {
         assets.addAll(linux);
         return assets;
      }
      if (roleName.equals("removableMedia")  && removableMedia != null) {
         assets.addAll(removableMedia);
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
      assets.addAll(browser);
      assets.addAll(computer);
      assets.addAll(user);
      assets.addAll(os);
      assets.addAll(macOS);
      assets.addAll(linux);
      assets.addAll(removableMedia);
      return assets;
   }
}
