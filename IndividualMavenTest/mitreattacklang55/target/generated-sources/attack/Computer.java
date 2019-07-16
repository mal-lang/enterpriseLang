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
   public java.util.Set<User> user = new HashSet<>();
   public Administrator administrator;
   public Employee employee;
   public java.util.Set<RemovableMedia> removableMedia = new HashSet<>();
   public C2Server c2Server;
   public OS os;
   public Windows windows;
   public MacOS macOS;
   public ExternalNetwork externalNetwork;
   public InternalNetwork internalNetwork;
   public Firewall firewall;
   public java.util.Set<VideoCallApplication> videoCallApplication = new HashSet<>();
   public Webcam webcam;
   public Microphone microphone;

   public InfectedComputer infectedComputer;
   public CommonlyUsedPortsConnection commonlyUsedPortsConnection;
   public UncommonlyUsedPortsConnection uncommonlyUsedPortsConnection;
   public FileDiscovery fileDiscovery;
   public DirectoryDiscovery directoryDiscovery;
   public FileDeletion fileDeletion;
   public BypassHostForensicAnalysisDetection bypassHostForensicAnalysisDetection;
   public DiskStructureWipe diskStructureWipe;
   public Backup backup;
   public UserDiskWiped userDiskWiped;
   public AdminDiskWiped adminDiskWiped;
   public UserDataEncryptedForImpact userDataEncryptedForImpact;
   public AdminDataEncryptedForImpact adminDataEncryptedForImpact;
   public Whitelisting whitelisting;
   public UploadRemoteFile uploadRemoteFile;
   public AutomatedCollection automatedCollection;
   public _automatedCollection _automatedCollection;
   public DownloadRemoteFile downloadRemoteFile;
   public NetworkIntrusionDetection networkIntrusionDetection;
   public UserDataDestruction userDataDestruction;
   public AdminDataDestruction adminDataDestruction;
   public SensitiveDataCollected sensitiveDataCollected;
   public DataCollected dataCollected;
   public _dataCollected _dataCollected;
   public DataCompressed dataCompressed;
   public DataEncrypted dataEncrypted;
   public _dataEncrypted _dataEncrypted;
   public DataStaged dataStaged;
   public _dataStaged _dataStaged;
   public AutomatedExfiltration automatedExfiltration;
   public ExfiltrationOverC2 exfiltrationOverC2;
   public ScheduledExfiltration scheduledExfiltration;
   public _automatedExfiltration _automatedExfiltration;
   public ExfiltrationOverAternativeProtocol exfiltrationOverAternativeProtocol;
   public DataSizedTransfer dataSizedTransfer;
   public ExfiltrationOverPhysicalMedium exfiltrationOverPhysicalMedium;
   public InfectedWindowsComputer infectedWindowsComputer;
   public MicrophoneExists microphoneExists;
   public CollectAudio collectAudio;
   public PeripheralDeviceDiscovery peripheralDeviceDiscovery;
   public PermissionGroupsDiscovery permissionGroupsDiscovery;
   public NetworkServiceScan networkServiceScan;
   public WebcamExists webcamExists;
   public VideoCallApplicationExists videoCallApplicationExists;
   public CollectVideo collectVideo;
   public _collectVideo _collectVideo;

   public Computer(Boolean backupState, Boolean whitelistingState, Boolean networkIntrusionDetectionState) {
      super();
      if (backup != null) {
         AttackStep.allAttackSteps.remove(backup.disable);
      }
      Defense.allDefenses.remove(backup);
      backup = new Backup(this.name, backupState);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      if (microphoneExists != null) {
         AttackStep.allAttackSteps.remove(microphoneExists.disable);
      }
      Defense.allDefenses.remove(microphoneExists);
      microphoneExists = new MicrophoneExists(this.name);
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
      AttackStep.allAttackSteps.remove(infectedComputer);
      infectedComputer = new InfectedComputer(this.name);
      AttackStep.allAttackSteps.remove(commonlyUsedPortsConnection);
      commonlyUsedPortsConnection = new CommonlyUsedPortsConnection(this.name);
      AttackStep.allAttackSteps.remove(uncommonlyUsedPortsConnection);
      uncommonlyUsedPortsConnection = new UncommonlyUsedPortsConnection(this.name);
      AttackStep.allAttackSteps.remove(fileDiscovery);
      fileDiscovery = new FileDiscovery(this.name);
      AttackStep.allAttackSteps.remove(directoryDiscovery);
      directoryDiscovery = new DirectoryDiscovery(this.name);
      AttackStep.allAttackSteps.remove(fileDeletion);
      fileDeletion = new FileDeletion(this.name);
      AttackStep.allAttackSteps.remove(bypassHostForensicAnalysisDetection);
      bypassHostForensicAnalysisDetection = new BypassHostForensicAnalysisDetection(this.name);
      AttackStep.allAttackSteps.remove(diskStructureWipe);
      diskStructureWipe = new DiskStructureWipe(this.name);
      AttackStep.allAttackSteps.remove(userDiskWiped);
      userDiskWiped = new UserDiskWiped(this.name);
      AttackStep.allAttackSteps.remove(adminDiskWiped);
      adminDiskWiped = new AdminDiskWiped(this.name);
      AttackStep.allAttackSteps.remove(userDataEncryptedForImpact);
      userDataEncryptedForImpact = new UserDataEncryptedForImpact(this.name);
      AttackStep.allAttackSteps.remove(adminDataEncryptedForImpact);
      adminDataEncryptedForImpact = new AdminDataEncryptedForImpact(this.name);
      AttackStep.allAttackSteps.remove(uploadRemoteFile);
      uploadRemoteFile = new UploadRemoteFile(this.name);
      AttackStep.allAttackSteps.remove(automatedCollection);
      automatedCollection = new AutomatedCollection(this.name);
      AttackStep.allAttackSteps.remove(_automatedCollection);
      _automatedCollection = new _automatedCollection(this.name);
      AttackStep.allAttackSteps.remove(downloadRemoteFile);
      downloadRemoteFile = new DownloadRemoteFile(this.name);
      AttackStep.allAttackSteps.remove(userDataDestruction);
      userDataDestruction = new UserDataDestruction(this.name);
      AttackStep.allAttackSteps.remove(adminDataDestruction);
      adminDataDestruction = new AdminDataDestruction(this.name);
      AttackStep.allAttackSteps.remove(sensitiveDataCollected);
      sensitiveDataCollected = new SensitiveDataCollected(this.name);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      AttackStep.allAttackSteps.remove(_dataCollected);
      _dataCollected = new _dataCollected(this.name);
      AttackStep.allAttackSteps.remove(dataCompressed);
      dataCompressed = new DataCompressed(this.name);
      AttackStep.allAttackSteps.remove(dataEncrypted);
      dataEncrypted = new DataEncrypted(this.name);
      AttackStep.allAttackSteps.remove(_dataEncrypted);
      _dataEncrypted = new _dataEncrypted(this.name);
      AttackStep.allAttackSteps.remove(dataStaged);
      dataStaged = new DataStaged(this.name);
      AttackStep.allAttackSteps.remove(_dataStaged);
      _dataStaged = new _dataStaged(this.name);
      AttackStep.allAttackSteps.remove(automatedExfiltration);
      automatedExfiltration = new AutomatedExfiltration(this.name);
      AttackStep.allAttackSteps.remove(exfiltrationOverC2);
      exfiltrationOverC2 = new ExfiltrationOverC2(this.name);
      AttackStep.allAttackSteps.remove(scheduledExfiltration);
      scheduledExfiltration = new ScheduledExfiltration(this.name);
      AttackStep.allAttackSteps.remove(_automatedExfiltration);
      _automatedExfiltration = new _automatedExfiltration(this.name);
      AttackStep.allAttackSteps.remove(exfiltrationOverAternativeProtocol);
      exfiltrationOverAternativeProtocol = new ExfiltrationOverAternativeProtocol(this.name);
      AttackStep.allAttackSteps.remove(dataSizedTransfer);
      dataSizedTransfer = new DataSizedTransfer(this.name);
      AttackStep.allAttackSteps.remove(exfiltrationOverPhysicalMedium);
      exfiltrationOverPhysicalMedium = new ExfiltrationOverPhysicalMedium(this.name);
      AttackStep.allAttackSteps.remove(infectedWindowsComputer);
      infectedWindowsComputer = new InfectedWindowsComputer(this.name);
      AttackStep.allAttackSteps.remove(collectAudio);
      collectAudio = new CollectAudio(this.name);
      AttackStep.allAttackSteps.remove(peripheralDeviceDiscovery);
      peripheralDeviceDiscovery = new PeripheralDeviceDiscovery(this.name);
      AttackStep.allAttackSteps.remove(permissionGroupsDiscovery);
      permissionGroupsDiscovery = new PermissionGroupsDiscovery(this.name);
      AttackStep.allAttackSteps.remove(networkServiceScan);
      networkServiceScan = new NetworkServiceScan(this.name);
      AttackStep.allAttackSteps.remove(collectVideo);
      collectVideo = new CollectVideo(this.name);
      AttackStep.allAttackSteps.remove(_collectVideo);
      _collectVideo = new _collectVideo(this.name);
      assetClassName = "Computer";
   }

   public Computer(String name, Boolean backupState, Boolean whitelistingState, Boolean networkIntrusionDetectionState) {
      super(name);
      if (backup != null) {
         AttackStep.allAttackSteps.remove(backup.disable);
      }
      Defense.allDefenses.remove(backup);
      backup = new Backup(this.name, backupState);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      if (microphoneExists != null) {
         AttackStep.allAttackSteps.remove(microphoneExists.disable);
      }
      Defense.allDefenses.remove(microphoneExists);
      microphoneExists = new MicrophoneExists(this.name);
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
      AttackStep.allAttackSteps.remove(infectedComputer);
      infectedComputer = new InfectedComputer(this.name);
      AttackStep.allAttackSteps.remove(commonlyUsedPortsConnection);
      commonlyUsedPortsConnection = new CommonlyUsedPortsConnection(this.name);
      AttackStep.allAttackSteps.remove(uncommonlyUsedPortsConnection);
      uncommonlyUsedPortsConnection = new UncommonlyUsedPortsConnection(this.name);
      AttackStep.allAttackSteps.remove(fileDiscovery);
      fileDiscovery = new FileDiscovery(this.name);
      AttackStep.allAttackSteps.remove(directoryDiscovery);
      directoryDiscovery = new DirectoryDiscovery(this.name);
      AttackStep.allAttackSteps.remove(fileDeletion);
      fileDeletion = new FileDeletion(this.name);
      AttackStep.allAttackSteps.remove(bypassHostForensicAnalysisDetection);
      bypassHostForensicAnalysisDetection = new BypassHostForensicAnalysisDetection(this.name);
      AttackStep.allAttackSteps.remove(diskStructureWipe);
      diskStructureWipe = new DiskStructureWipe(this.name);
      AttackStep.allAttackSteps.remove(userDiskWiped);
      userDiskWiped = new UserDiskWiped(this.name);
      AttackStep.allAttackSteps.remove(adminDiskWiped);
      adminDiskWiped = new AdminDiskWiped(this.name);
      AttackStep.allAttackSteps.remove(userDataEncryptedForImpact);
      userDataEncryptedForImpact = new UserDataEncryptedForImpact(this.name);
      AttackStep.allAttackSteps.remove(adminDataEncryptedForImpact);
      adminDataEncryptedForImpact = new AdminDataEncryptedForImpact(this.name);
      AttackStep.allAttackSteps.remove(uploadRemoteFile);
      uploadRemoteFile = new UploadRemoteFile(this.name);
      AttackStep.allAttackSteps.remove(automatedCollection);
      automatedCollection = new AutomatedCollection(this.name);
      AttackStep.allAttackSteps.remove(_automatedCollection);
      _automatedCollection = new _automatedCollection(this.name);
      AttackStep.allAttackSteps.remove(downloadRemoteFile);
      downloadRemoteFile = new DownloadRemoteFile(this.name);
      AttackStep.allAttackSteps.remove(userDataDestruction);
      userDataDestruction = new UserDataDestruction(this.name);
      AttackStep.allAttackSteps.remove(adminDataDestruction);
      adminDataDestruction = new AdminDataDestruction(this.name);
      AttackStep.allAttackSteps.remove(sensitiveDataCollected);
      sensitiveDataCollected = new SensitiveDataCollected(this.name);
      AttackStep.allAttackSteps.remove(dataCollected);
      dataCollected = new DataCollected(this.name);
      AttackStep.allAttackSteps.remove(_dataCollected);
      _dataCollected = new _dataCollected(this.name);
      AttackStep.allAttackSteps.remove(dataCompressed);
      dataCompressed = new DataCompressed(this.name);
      AttackStep.allAttackSteps.remove(dataEncrypted);
      dataEncrypted = new DataEncrypted(this.name);
      AttackStep.allAttackSteps.remove(_dataEncrypted);
      _dataEncrypted = new _dataEncrypted(this.name);
      AttackStep.allAttackSteps.remove(dataStaged);
      dataStaged = new DataStaged(this.name);
      AttackStep.allAttackSteps.remove(_dataStaged);
      _dataStaged = new _dataStaged(this.name);
      AttackStep.allAttackSteps.remove(automatedExfiltration);
      automatedExfiltration = new AutomatedExfiltration(this.name);
      AttackStep.allAttackSteps.remove(exfiltrationOverC2);
      exfiltrationOverC2 = new ExfiltrationOverC2(this.name);
      AttackStep.allAttackSteps.remove(scheduledExfiltration);
      scheduledExfiltration = new ScheduledExfiltration(this.name);
      AttackStep.allAttackSteps.remove(_automatedExfiltration);
      _automatedExfiltration = new _automatedExfiltration(this.name);
      AttackStep.allAttackSteps.remove(exfiltrationOverAternativeProtocol);
      exfiltrationOverAternativeProtocol = new ExfiltrationOverAternativeProtocol(this.name);
      AttackStep.allAttackSteps.remove(dataSizedTransfer);
      dataSizedTransfer = new DataSizedTransfer(this.name);
      AttackStep.allAttackSteps.remove(exfiltrationOverPhysicalMedium);
      exfiltrationOverPhysicalMedium = new ExfiltrationOverPhysicalMedium(this.name);
      AttackStep.allAttackSteps.remove(infectedWindowsComputer);
      infectedWindowsComputer = new InfectedWindowsComputer(this.name);
      AttackStep.allAttackSteps.remove(collectAudio);
      collectAudio = new CollectAudio(this.name);
      AttackStep.allAttackSteps.remove(peripheralDeviceDiscovery);
      peripheralDeviceDiscovery = new PeripheralDeviceDiscovery(this.name);
      AttackStep.allAttackSteps.remove(permissionGroupsDiscovery);
      permissionGroupsDiscovery = new PermissionGroupsDiscovery(this.name);
      AttackStep.allAttackSteps.remove(networkServiceScan);
      networkServiceScan = new NetworkServiceScan(this.name);
      AttackStep.allAttackSteps.remove(collectVideo);
      collectVideo = new CollectVideo(this.name);
      AttackStep.allAttackSteps.remove(_collectVideo);
      _collectVideo = new _collectVideo(this.name);
      assetClassName = "Computer";
   }

   public Computer() {
      this(false, false, false);
      assetClassName = "Computer";
   }

   public Computer(String name) {
      this(name, false, false, false);
      assetClassName = "Computer";
   }


   public class InfectedComputer extends AttackStepMin {
   public InfectedComputer(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (employee != null) {
addExpectedParent(employee.userExecution);
}
if (os != null) {
addExpectedParent(os.runCode);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (RemovableMedia removableMedia_mrGRE : removableMedia) {
removableMedia_mrGRE.infectedMedia.updateTtc(this, ttc, activeAttackSteps);
}
commonlyUsedPortsConnection.updateTtc(this, ttc, activeAttackSteps);
if (internalNetwork != null) {
internalNetwork.applicationLayerConnexion.updateTtc(this, ttc, activeAttackSteps);
}
uncommonlyUsedPortsConnection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.infectedComputer");
      }

   }

   public class CommonlyUsedPortsConnection extends AttackStepMax {
   public CommonlyUsedPortsConnection(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(infectedComputer);
addExpectedParent(networkIntrusionDetection.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (internalNetwork != null) {
internalNetwork.c2Connexion.updateTtc(this, ttc, activeAttackSteps);
}
if (firewall != null) {
firewall.bypassFirewall.updateTtc(this, ttc, activeAttackSteps);
}
if (externalNetwork != null) {
externalNetwork.bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
}
if (internalNetwork != null) {
internalNetwork.bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.commonlyUsedPortsConnection");
      }

   }

   public class UncommonlyUsedPortsConnection extends AttackStepMax {
   public UncommonlyUsedPortsConnection(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (firewall != null) {
addExpectedParent(firewall.uncommonlyUsedPortsLimitation.disable);
}
addExpectedParent(infectedComputer);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (internalNetwork != null) {
internalNetwork.c2Connexion.updateTtc(this, ttc, activeAttackSteps);
}
if (firewall != null) {
firewall.bypassFirewall.updateTtc(this, ttc, activeAttackSteps);
}
if (internalNetwork != null) {
internalNetwork.bypassProxies.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.uncommonlyUsedPortsConnection");
      }

   }

   public class FileDiscovery extends AttackStepMax {
   public FileDiscovery(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_sYTZi : user) {
addExpectedParent(user_sYTZi.userRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.fileDiscovery");
      }

   }

   public class DirectoryDiscovery extends AttackStepMax {
   public DirectoryDiscovery(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_dYcRq : user) {
addExpectedParent(user_dYcRq.userRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.directoryDiscovery");
      }

   }

   public class FileDeletion extends AttackStepMax {
   public FileDeletion(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_JTSmO : user) {
addExpectedParent(user_JTSmO.userRights);
}
addExpectedParent(whitelisting.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
bypassHostForensicAnalysisDetection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.fileDeletion");
      }

   }

   public class BypassHostForensicAnalysisDetection extends AttackStepMin {
   public BypassHostForensicAnalysisDetection(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(fileDeletion);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.bypassHostForensicAnalysisDetection");
      }

   }

   public class DiskStructureWipe extends AttackStepMax {
   public DiskStructureWipe(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
addExpectedParent(backup.disable);
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.diskStructureWipe");
      }

   }

   public class Backup extends Defense {
   public Backup(String name, Boolean enabled) {
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
            return "computer.backup";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
diskStructureWipe.updateTtc(this, ttc, activeAttackSteps);
userDiskWiped.updateTtc(this, ttc, activeAttackSteps);
adminDiskWiped.updateTtc(this, ttc, activeAttackSteps);
userDataDestruction.updateTtc(this, ttc, activeAttackSteps);
adminDataDestruction.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class UserDiskWiped extends AttackStepMax {
   public UserDiskWiped(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_KAgOL : user) {
addExpectedParent(user_KAgOL.userRights);
}
addExpectedParent(backup.disable);
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.userDiskWiped");
      }

   }

   public class AdminDiskWiped extends AttackStepMax {
   public AdminDiskWiped(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
addExpectedParent(backup.disable);
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.adminDiskWiped");
      }

   }

   public class UserDataEncryptedForImpact extends AttackStepMax {
   public UserDataEncryptedForImpact(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_SmMGM : user) {
addExpectedParent(user_SmMGM.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.userDataEncryptedForImpact");
      }

   }

   public class AdminDataEncryptedForImpact extends AttackStepMax {
   public AdminDataEncryptedForImpact(String name) {
      super(name);
      assetClassName = "Computer";
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
         return ttcHashMap.get("Computer.adminDataEncryptedForImpact");
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
fileDiscovery.updateTtc(this, ttc, activeAttackSteps);
directoryDiscovery.updateTtc(this, ttc, activeAttackSteps);
fileDeletion.updateTtc(this, ttc, activeAttackSteps);
userDataDestruction.updateTtc(this, ttc, activeAttackSteps);
adminDataDestruction.updateTtc(this, ttc, activeAttackSteps);
dataCompressed.updateTtc(this, ttc, activeAttackSteps);
collectAudio.updateTtc(this, ttc, activeAttackSteps);
_automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
_dataEncrypted.updateTtc(this, ttc, activeAttackSteps);
peripheralDeviceDiscovery.updateTtc(this, ttc, activeAttackSteps);
permissionGroupsDiscovery.updateTtc(this, ttc, activeAttackSteps);
_dataStaged.updateTtc(this, ttc, activeAttackSteps);
_collectVideo.updateTtc(this, ttc, activeAttackSteps);
_automatedCollection.updateTtc(this, ttc, activeAttackSteps);
diskStructureWipe.updateTtc(this, ttc, activeAttackSteps);
userDiskWiped.updateTtc(this, ttc, activeAttackSteps);
adminDiskWiped.updateTtc(this, ttc, activeAttackSteps);
userDataEncryptedForImpact.updateTtc(this, ttc, activeAttackSteps);
adminDataEncryptedForImpact.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class UploadRemoteFile extends AttackStepMax {
   public UploadRemoteFile(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_JogJz : user) {
addExpectedParent(user_JogJz.userRights);
}
addExpectedParent(networkIntrusionDetection.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (employee != null) {
employee.userExecution.updateTtc(this, ttc, activeAttackSteps);
}
automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.uploadRemoteFile");
      }

   }

   public class AutomatedCollection extends AttackStepMin {
   public AutomatedCollection(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_MhEiC : user) {
addExpectedParent(user_MhEiC.userRights);
}
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
if (os != null) {
addExpectedParent(os._scripting);
}
addExpectedParent(fileDiscovery);
addExpectedParent(directoryDiscovery);
addExpectedParent(uploadRemoteFile);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_automatedCollection.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.automatedCollection");
      }

   }

   public class _automatedCollection extends AttackStepMax {
   public _automatedCollection(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(whitelisting.disable);
addExpectedParent(automatedCollection);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataCollected.updateTtc(this, ttc, activeAttackSteps);
sensitiveDataCollected.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer._automatedCollection");
      }

   }

   public class DownloadRemoteFile extends AttackStepMax {
   public DownloadRemoteFile(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_PRsiJ : user) {
addExpectedParent(user_PRsiJ.userRights);
}
addExpectedParent(networkIntrusionDetection.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.downloadRemoteFile");
      }

   }

   public class NetworkIntrusionDetection extends Defense {
   public NetworkIntrusionDetection(String name, Boolean enabled) {
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
            return "computer.networkIntrusionDetection";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
uploadRemoteFile.updateTtc(this, ttc, activeAttackSteps);
downloadRemoteFile.updateTtc(this, ttc, activeAttackSteps);
commonlyUsedPortsConnection.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class UserDataDestruction extends AttackStepMax {
   public UserDataDestruction(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_kjFtR : user) {
addExpectedParent(user_kjFtR.userRights);
}
addExpectedParent(backup.disable);
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.userDataDestruction");
      }

   }

   public class AdminDataDestruction extends AttackStepMax {
   public AdminDataDestruction(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
addExpectedParent(backup.disable);
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.adminDataDestruction");
      }

   }

   public class SensitiveDataCollected extends AttackStepMax {
   public SensitiveDataCollected(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
addExpectedParent(_automatedCollection);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataCompressed.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverPhysicalMedium.updateTtc(this, ttc, activeAttackSteps);
dataSizedTransfer.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
scheduledExfiltration.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverC2.updateTtc(this, ttc, activeAttackSteps);
automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
dataEncrypted.updateTtc(this, ttc, activeAttackSteps);
dataStaged.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.sensitiveDataCollected");
      }

   }

   public class DataCollected extends AttackStepMin {
   public DataCollected(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (os != null) {
addExpectedParent(os.adminCommandLineInterface);
}
if (os != null) {
addExpectedParent(os.userCommandLineInterface);
}
if (windows != null) {
addExpectedParent(windows.emailStorageCollection);
}
if (windows != null) {
addExpectedParent(windows.outlookEmailCollection);
}
if (internalNetwork != null) {
addExpectedParent(internalNetwork.exchangeServerCollection);
}
addExpectedParent(_automatedCollection);
addExpectedParent(collectAudio);
addExpectedParent(_collectVideo);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataCollected");
      }

   }

   public class _dataCollected extends AttackStepMax {
   public _dataCollected(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(dataCollected);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataCompressed.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverPhysicalMedium.updateTtc(this, ttc, activeAttackSteps);
dataSizedTransfer.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
scheduledExfiltration.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverC2.updateTtc(this, ttc, activeAttackSteps);
automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
dataEncrypted.updateTtc(this, ttc, activeAttackSteps);
dataStaged.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer._dataCollected");
      }

   }

   public class DataCompressed extends AttackStepMax {
   public DataCompressed(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(whitelisting.disable);
addExpectedParent(sensitiveDataCollected);
addExpectedParent(_dataCollected);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exfiltrationOverPhysicalMedium.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
scheduledExfiltration.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverC2.updateTtc(this, ttc, activeAttackSteps);
automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
dataEncrypted.updateTtc(this, ttc, activeAttackSteps);
dataStaged.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataCompressed");
      }

   }

   public class DataEncrypted extends AttackStepMin {
   public DataEncrypted(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(sensitiveDataCollected);
addExpectedParent(_dataCollected);
addExpectedParent(dataCompressed);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_dataEncrypted.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataEncrypted");
      }

   }

   public class _dataEncrypted extends AttackStepMax {
   public _dataEncrypted(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(whitelisting.disable);
addExpectedParent(dataEncrypted);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exfiltrationOverPhysicalMedium.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
scheduledExfiltration.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverC2.updateTtc(this, ttc, activeAttackSteps);
automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
dataStaged.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer._dataEncrypted");
      }

   }

   public class DataStaged extends AttackStepMin {
   public DataStaged(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(sensitiveDataCollected);
addExpectedParent(_dataCollected);
addExpectedParent(dataCompressed);
addExpectedParent(_dataEncrypted);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_dataStaged.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataStaged");
      }

   }

   public class _dataStaged extends AttackStepMax {
   public _dataStaged(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(whitelisting.disable);
addExpectedParent(dataStaged);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exfiltrationOverPhysicalMedium.updateTtc(this, ttc, activeAttackSteps);
dataSizedTransfer.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
scheduledExfiltration.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverC2.updateTtc(this, ttc, activeAttackSteps);
automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer._dataStaged");
      }

   }

   public class AutomatedExfiltration extends AttackStepMin {
   public AutomatedExfiltration(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(sensitiveDataCollected);
addExpectedParent(_dataCollected);
addExpectedParent(dataCompressed);
addExpectedParent(_dataEncrypted);
addExpectedParent(_dataStaged);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
_automatedExfiltration.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.automatedExfiltration");
      }

   }

   public class ExfiltrationOverC2 extends AttackStepMin {
   public ExfiltrationOverC2(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(sensitiveDataCollected);
addExpectedParent(_dataCollected);
addExpectedParent(dataCompressed);
addExpectedParent(_dataEncrypted);
addExpectedParent(_dataStaged);
addExpectedParent(scheduledExfiltration);
addExpectedParent(_automatedExfiltration);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (c2Server != null) {
c2Server.dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.exfiltrationOverC2");
      }

   }

   public class ScheduledExfiltration extends AttackStepMin {
   public ScheduledExfiltration(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(sensitiveDataCollected);
addExpectedParent(_dataCollected);
addExpectedParent(dataCompressed);
addExpectedParent(_dataEncrypted);
addExpectedParent(_dataStaged);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exfiltrationOverC2.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.scheduledExfiltration");
      }

   }

   public class _automatedExfiltration extends AttackStepMax {
   public _automatedExfiltration(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(whitelisting.disable);
addExpectedParent(automatedExfiltration);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exfiltrationOverAternativeProtocol.updateTtc(this, ttc, activeAttackSteps);
exfiltrationOverC2.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer._automatedExfiltration");
      }

   }

   public class ExfiltrationOverAternativeProtocol extends AttackStepMin {
   public ExfiltrationOverAternativeProtocol(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(sensitiveDataCollected);
addExpectedParent(_dataCollected);
addExpectedParent(dataCompressed);
addExpectedParent(_dataEncrypted);
addExpectedParent(_dataStaged);
addExpectedParent(scheduledExfiltration);
addExpectedParent(_automatedExfiltration);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (internalNetwork != null) {
internalNetwork.dataExfiltration.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.exfiltrationOverAternativeProtocol");
      }

   }

   public class DataSizedTransfer extends AttackStepMin {
   public DataSizedTransfer(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(sensitiveDataCollected);
addExpectedParent(_dataCollected);
addExpectedParent(_dataStaged);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (c2Server != null) {
c2Server.dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.dataSizedTransfer");
      }

   }

   public class ExfiltrationOverPhysicalMedium extends AttackStepMin {
   public ExfiltrationOverPhysicalMedium(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
addExpectedParent(sensitiveDataCollected);
addExpectedParent(_dataCollected);
addExpectedParent(dataCompressed);
addExpectedParent(_dataEncrypted);
addExpectedParent(_dataStaged);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (RemovableMedia removableMedia_IRscn : removableMedia) {
removableMedia_IRscn.dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.exfiltrationOverPhysicalMedium");
      }

   }

   public class InfectedWindowsComputer extends AttackStepMin {
   public InfectedWindowsComputer(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (employee != null) {
addExpectedParent(employee.userExecution);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.infectedWindowsComputer");
      }

   }

   public class MicrophoneExists extends Defense {
   public MicrophoneExists(String name) {
      super(name);
      disable = new Disable(name);
   }

   @Override
   public boolean isEnabled() {
      return microphone == null;
   }
   public class Disable extends AttackStepMin {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "computer.microphoneExists";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (microphone != null) {
microphone.collectAudio.updateTtc(this, ttc, activeAttackSteps);
}
}
   }
}

   public class CollectAudio extends AttackStepMax {
   public CollectAudio(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_GgtoG : user) {
addExpectedParent(user_GgtoG.userRights);
}
addExpectedParent(whitelisting.disable);
if (microphone != null) {
addExpectedParent(microphone.collectAudio);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.collectAudio");
      }

   }

   public class PeripheralDeviceDiscovery extends AttackStepMax {
   public PeripheralDeviceDiscovery(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (windows != null) {
addExpectedParent(windows.peripheralDeviceDiscovery);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.peripheralDeviceDiscovery");
      }

   }

   public class PermissionGroupsDiscovery extends AttackStepMax {
   public PermissionGroupsDiscovery(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
for (User user_NOcZY : user) {
addExpectedParent(user_NOcZY.userRights);
}
addExpectedParent(whitelisting.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.permissionGroupsDiscovery");
      }

   }

   public class NetworkServiceScan extends AttackStepMax {
   public NetworkServiceScan(String name) {
      super(name);
      assetClassName = "Computer";
   }
@Override
public void setExpectedParents() {
if (administrator != null) {
addExpectedParent(administrator.adminRights);
}
if (internalNetwork != null) {
addExpectedParent(internalNetwork.networkIntrusionDetection.disable);
}
if (internalNetwork != null) {
addExpectedParent(internalNetwork.whitelisting.disable);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("Computer.networkServiceScan");
      }

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
for (VideoCallApplication videoCallApplication_EEFvp : videoCallApplication) {
videoCallApplication_EEFvp.collectVideo.updateTtc(this, ttc, activeAttackSteps);
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
if (macOS != null) {
addExpectedParent(macOS.videoCollection);
}
if (windows != null) {
addExpectedParent(windows.videoCollection);
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
for (VideoCallApplication videoCallApplication_JLwsW : videoCallApplication) {
addExpectedParent(videoCallApplication_JLwsW.collectVideo);
}
addExpectedParent(whitelisting.disable);
addExpectedParent(collectVideo);
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

      public void addUser(User user) {
         this.user.add(user);
         user.computer = this;
      }

      public void addAdministrator(Administrator administrator) {
         this.administrator = administrator;
         administrator.computer.add(this);
      }

      public void addEmployee(Employee employee) {
         this.employee = employee;
         employee.computer.add(this);
      }

      public void addRemovableMedia(RemovableMedia removableMedia) {
         this.removableMedia.add(removableMedia);
         removableMedia.computer = this;
      }

      public void addC2Server(C2Server c2Server) {
         this.c2Server = c2Server;
         c2Server.computer = this;
      }

      public void addOs(OS os) {
         this.os = os;
         os.computer.add(this);
      }

      public void addWindows(Windows windows) {
         this.windows = windows;
         windows.computer = this;
      }

      public void addMacOS(MacOS macOS) {
         this.macOS = macOS;
         macOS.computer.add(this);
      }

      public void addExternalNetwork(ExternalNetwork externalNetwork) {
         this.externalNetwork = externalNetwork;
         externalNetwork.computer.add(this);
      }

      public void addInternalNetwork(InternalNetwork internalNetwork) {
         this.internalNetwork = internalNetwork;
         internalNetwork.computer.add(this);
      }

      public void addFirewall(Firewall firewall) {
         this.firewall = firewall;
         firewall.computer.add(this);
      }

      public void addVideoCallApplication(VideoCallApplication videoCallApplication) {
         this.videoCallApplication.add(videoCallApplication);
         videoCallApplication.computer = this;
      }

      public void addWebcam(Webcam webcam) {
         this.webcam = webcam;
         webcam.computer = this;
      }

      public void addMicrophone(Microphone microphone) {
         this.microphone = microphone;
         microphone.computer = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("administrator")) {
         return administrator.getClass().getName();
      }
      if (roleName.equals("employee")) {
         return employee.getClass().getName();
      }
      if (roleName.equals("removableMedia")) {
         for (Object o: removableMedia) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("c2Server")) {
         return c2Server.getClass().getName();
      }
      if (roleName.equals("os")) {
         return os.getClass().getName();
      }
      if (roleName.equals("windows")) {
         return windows.getClass().getName();
      }
      if (roleName.equals("macOS")) {
         return macOS.getClass().getName();
      }
      if (roleName.equals("externalNetwork")) {
         return externalNetwork.getClass().getName();
      }
      if (roleName.equals("internalNetwork")) {
         return internalNetwork.getClass().getName();
      }
      if (roleName.equals("firewall")) {
         return firewall.getClass().getName();
      }
      if (roleName.equals("videoCallApplication")) {
         for (Object o: videoCallApplication) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("webcam")) {
         return webcam.getClass().getName();
      }
      if (roleName.equals("microphone")) {
         return microphone.getClass().getName();
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("user")  && user != null) {
         assets.addAll(user);
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
      if (roleName.equals("removableMedia")  && removableMedia != null) {
         assets.addAll(removableMedia);
         return assets;
      }
      if (roleName.equals("c2Server")  && c2Server != null) {
         assets.add(c2Server);
         return assets;
      }
      if (roleName.equals("os")  && os != null) {
         assets.add(os);
         return assets;
      }
      if (roleName.equals("windows")  && windows != null) {
         assets.add(windows);
         return assets;
      }
      if (roleName.equals("macOS")  && macOS != null) {
         assets.add(macOS);
         return assets;
      }
      if (roleName.equals("externalNetwork")  && externalNetwork != null) {
         assets.add(externalNetwork);
         return assets;
      }
      if (roleName.equals("internalNetwork")  && internalNetwork != null) {
         assets.add(internalNetwork);
         return assets;
      }
      if (roleName.equals("firewall")  && firewall != null) {
         assets.add(firewall);
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
      if (roleName.equals("microphone")  && microphone != null) {
         assets.add(microphone);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      assets.addAll(user);
      if (administrator != null) {
         assets.add(administrator);
      }
      if (employee != null) {
         assets.add(employee);
      }
      assets.addAll(removableMedia);
      if (c2Server != null) {
         assets.add(c2Server);
      }
      if (os != null) {
         assets.add(os);
      }
      if (windows != null) {
         assets.add(windows);
      }
      if (macOS != null) {
         assets.add(macOS);
      }
      if (externalNetwork != null) {
         assets.add(externalNetwork);
      }
      if (internalNetwork != null) {
         assets.add(internalNetwork);
      }
      if (firewall != null) {
         assets.add(firewall);
      }
      assets.addAll(videoCallApplication);
      if (webcam != null) {
         assets.add(webcam);
      }
      if (microphone != null) {
         assets.add(microphone);
      }
      return assets;
   }
}
