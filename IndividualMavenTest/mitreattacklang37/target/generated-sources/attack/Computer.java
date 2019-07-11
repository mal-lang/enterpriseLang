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
public class Computer extends Asset {
   public Windows windows;
   public MacOS macOS;
   public java.util.Set<VideoCallApplication> videoCallApplication = new HashSet<>();
   public Webcam webcam;

   public WebcamExists webcamExists;
   public VideoCallApplicationExists videoCallApplicationExists;
   public CollectVideo collectVideo;
   public _collectVideo _collectVideo;
   public Whitelisting whitelisting;
   public DataCollected dataCollected;

   public Computer(Boolean whitelistingState) {
      super();
      if (webcamExists != null) {
         AttackStep.allAttackSteps.remove(webcamExists.disable);
      }
      Defense.allDefenses.remove(webcamExists);
      webcamExists = new WebcamExists(this.name);
      if (videoCallApplicationExists != null) {
         AttackStep.allAttackSteps.remove(videoCallApplicationExists.disable);
      }
      Defense.allDefenses.remove(videoCallApplicationExists);
      videoCallApplicationExists = new VideoCallApplicationExists(this.name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(collectVideo);
      collectVideo = new CollectVideo(this.name);
      AttackStep.allAttackSteps.remove(_collectVideo);
      _collectVideo = new _collectVideo(this.name);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name, Boolean whitelistingState) {
      super(name);
      if (webcamExists != null) {
         AttackStep.allAttackSteps.remove(webcamExists.disable);
      }
      Defense.allDefenses.remove(webcamExists);
      webcamExists = new WebcamExists(this.name);
      if (videoCallApplicationExists != null) {
         AttackStep.allAttackSteps.remove(videoCallApplicationExists.disable);
      }
      Defense.allDefenses.remove(videoCallApplicationExists);
      videoCallApplicationExists = new VideoCallApplicationExists(this.name);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      AttackStep.allAttackSteps.remove(collectVideo);
      collectVideo = new CollectVideo(this.name);
      AttackStep.allAttackSteps.remove(_collectVideo);
      _collectVideo = new _collectVideo(this.name);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      assetClassName = "Computer";
   }

   public Computer() {
      this(false);
      assetClassName = "Computer";
   }

   public Computer(String name) {
      this(name, false);
      assetClassName = "Computer";
   }


   public class WebcamExists extends Defense {
   public WebcamExists(String name) {
      super(name);
      disable = new Disable(name);
   }

   @Override
   public boolean isEnabled() {
      return webcam == null;
   }
   public class Disable extends AttackStepMin {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "computer.webcamExists";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (webcam != null) {
webcam.collectVideo.updateTtc(this, ttc, activeAttackSteps);
}
}
   }
}

   public class VideoCallApplicationExists extends Defense {
   public VideoCallApplicationExists(String name) {
      super(name);
      disable = new Disable(name);
   }

   @Override
   public boolean isEnabled() {
      return videoCallApplication.isEmpty();
   }
   public class Disable extends AttackStepMin {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "computer.videoCallApplicationExists";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (VideoCallApplication videoCallApplication_HBeGa : videoCallApplication) {
videoCallApplication_HBeGa.collectVideo.updateTtc(this, ttc, activeAttackSteps);
}
}
   }
}

   public class CollectVideo extends AttackStepMin {
   public CollectVideo(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (windows != null) {
addExpectedParent(windows.webcamCollection);
}
if (macOS != null) {
addExpectedParent(macOS.webcamCollection);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_collectVideo.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.collectVideo");
      }

   }

   public class _collectVideo extends AttackStepMax {
   public _collectVideo(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (VideoCallApplication videoCallApplication_ZVIpO : videoCallApplication) {
addExpectedParent(videoCallApplication_ZVIpO.collectVideo);
}
addExpectedParent(collectVideo);
addExpectedParent(whitelisting.disable);
if (webcam != null) {
addExpectedParent(webcam.collectVideo);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer._collectVideo");
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
            return "computer.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_collectVideo.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class DataCollected extends AttackStepMin {
   public DataCollected(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(_collectVideo);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataCollected");
      }

   }

      public void addWindows(Windows windows) {
         this.windows = windows;
         windows.computer.add(this);
      }

      public void addMacOS(MacOS macOS) {
         this.macOS = macOS;
         macOS.computer.add(this);
      }

      public void addVideoCallApplication(VideoCallApplication videoCallApplication) {
         this.videoCallApplication.add(videoCallApplication);
         videoCallApplication.computer = this;
      }

      public void addWebcam(Webcam webcam) {
         this.webcam = webcam;
         webcam.computer = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("windows")) {
         return windows.getClass().getName();
      }
      if (roleName.equals("macOS")) {
         return macOS.getClass().getName();
      }
      if (roleName.equals("videoCallApplication")) {
         for (Object o: videoCallApplication) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("webcam")) {
         return webcam.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("windows")  && windows != null) {
         assets.add(windows);
         return assets;
      }
      if (roleName.equals("macOS")  && macOS != null) {
         assets.add(macOS);
         return assets;
      }
      if (roleName.equals("videoCallApplication")  && videoCallApplication != null) {
         assets.addAll(videoCallApplication);
         return assets;
      }
      if (roleName.equals("webcam")  && webcam != null) {
         assets.add(webcam);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (windows != null) {
         assets.add(windows);
      }
      if (macOS != null) {
         assets.add(macOS);
      }
      assets.addAll(videoCallApplication);
      if (webcam != null) {
         assets.add(webcam);
      }
      return assets;
   }
}
