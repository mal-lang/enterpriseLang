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
public class InternalNetwork extends Asset {
   public C2Server c2Server;
   public Firewall firewall;
   public java.util.Set<ExternalNetwork> externalNetwork = new HashSet<>();
   public java.util.Set<User> user = new HashSet<>();
   public java.util.Set<Administrator> administrator = new HashSet<>();
   public java.util.Set<Computer> computer = new HashSet<>();
   public java.util.Set<Windows> windows = new HashSet<>();
   public java.util.Set<MacOS> macOS = new HashSet<>();
   public java.util.Set<Service> service = new HashSet<>();

   public ApplicationLayerConnexion applicationLayerConnexion;
   public DataExfiltration dataExfiltration;
   public FirewallExists firewallExists;
   public NetworkIntrusionDetection networkIntrusionDetection;
   public BypassNetworkDetection bypassNetworkDetection;
   public BypassProxies bypassProxies;
   public UsertransmittedDataManipulation usertransmittedDataManipulation;
   public AdmintransmittedDataManipulation admintransmittedDataManipulation;
   public DataEncrypted dataEncrypted;
   public SecureCommunication secureCommunication;
   public Whitelisting whitelisting;
   public C2Connexion c2Connexion;
   public ExchangeServerCollection exchangeServerCollection;
   public DataEncryption dataEncryption;
   public TwoFactorsAuthentication twoFactorsAuthentication;
   public NetworkShareDiscovery networkShareDiscovery;

   public InternalNetwork(Boolean networkIntrusionDetectionState, Boolean dataEncryptedState, Boolean secureCommunicationState, Boolean whitelistingState, Boolean dataEncryptionState, Boolean twoFactorsAuthenticationState) {
      super();
      if (firewallExists != null) {
         AttackStep.allAttackSteps.remove(firewallExists.disable);
      }
      Defense.allDefenses.remove(firewallExists);
      firewallExists = new FirewallExists(this.name);
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      if (dataEncrypted != null) {
         AttackStep.allAttackSteps.remove(dataEncrypted.disable);
      }
      Defense.allDefenses.remove(dataEncrypted);
      dataEncrypted = new DataEncrypted(this.name, dataEncryptedState);
      if (secureCommunication != null) {
         AttackStep.allAttackSteps.remove(secureCommunication.disable);
      }
      Defense.allDefenses.remove(secureCommunication);
      secureCommunication = new SecureCommunication(this.name, secureCommunicationState);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (dataEncryption != null) {
         AttackStep.allAttackSteps.remove(dataEncryption.disable);
      }
      Defense.allDefenses.remove(dataEncryption);
      dataEncryption = new DataEncryption(this.name, dataEncryptionState);
      if (twoFactorsAuthentication != null) {
         AttackStep.allAttackSteps.remove(twoFactorsAuthentication.disable);
      }
      Defense.allDefenses.remove(twoFactorsAuthentication);
      twoFactorsAuthentication = new TwoFactorsAuthentication(this.name, twoFactorsAuthenticationState);
      AttackStep.allAttackSteps.remove(applicationLayerConnexion);
      applicationLayerConnexion = new ApplicationLayerConnexion(this.name);
      AttackStep.allAttackSteps.remove(dataExfiltration);
      dataExfiltration = new DataExfiltration(this.name);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      AttackStep.allAttackSteps.remove(bypassProxies);
      bypassProxies = new BypassProxies(this.name);
      AttackStep.allAttackSteps.remove(usertransmittedDataManipulation);
      usertransmittedDataManipulation = new UsertransmittedDataManipulation(this.name);
      AttackStep.allAttackSteps.remove(admintransmittedDataManipulation);
      admintransmittedDataManipulation = new AdmintransmittedDataManipulation(this.name);
      AttackStep.allAttackSteps.remove(c2Connexion);
      c2Connexion = new C2Connexion(this.name);
      AttackStep.allAttackSteps.remove(exchangeServerCollection);
      exchangeServerCollection = new ExchangeServerCollection(this.name);
      AttackStep.allAttackSteps.remove(networkShareDiscovery);
      networkShareDiscovery = new NetworkShareDiscovery(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name, Boolean networkIntrusionDetectionState, Boolean dataEncryptedState, Boolean secureCommunicationState, Boolean whitelistingState, Boolean dataEncryptionState, Boolean twoFactorsAuthenticationState) {
      super(name);
      if (firewallExists != null) {
         AttackStep.allAttackSteps.remove(firewallExists.disable);
      }
      Defense.allDefenses.remove(firewallExists);
      firewallExists = new FirewallExists(this.name);
      if (networkIntrusionDetection != null) {
         AttackStep.allAttackSteps.remove(networkIntrusionDetection.disable);
      }
      Defense.allDefenses.remove(networkIntrusionDetection);
      networkIntrusionDetection = new NetworkIntrusionDetection(this.name, networkIntrusionDetectionState);
      if (dataEncrypted != null) {
         AttackStep.allAttackSteps.remove(dataEncrypted.disable);
      }
      Defense.allDefenses.remove(dataEncrypted);
      dataEncrypted = new DataEncrypted(this.name, dataEncryptedState);
      if (secureCommunication != null) {
         AttackStep.allAttackSteps.remove(secureCommunication.disable);
      }
      Defense.allDefenses.remove(secureCommunication);
      secureCommunication = new SecureCommunication(this.name, secureCommunicationState);
      if (whitelisting != null) {
         AttackStep.allAttackSteps.remove(whitelisting.disable);
      }
      Defense.allDefenses.remove(whitelisting);
      whitelisting = new Whitelisting(this.name, whitelistingState);
      if (dataEncryption != null) {
         AttackStep.allAttackSteps.remove(dataEncryption.disable);
      }
      Defense.allDefenses.remove(dataEncryption);
      dataEncryption = new DataEncryption(this.name, dataEncryptionState);
      if (twoFactorsAuthentication != null) {
         AttackStep.allAttackSteps.remove(twoFactorsAuthentication.disable);
      }
      Defense.allDefenses.remove(twoFactorsAuthentication);
      twoFactorsAuthentication = new TwoFactorsAuthentication(this.name, twoFactorsAuthenticationState);
      AttackStep.allAttackSteps.remove(applicationLayerConnexion);
      applicationLayerConnexion = new ApplicationLayerConnexion(this.name);
      AttackStep.allAttackSteps.remove(dataExfiltration);
      dataExfiltration = new DataExfiltration(this.name);
      AttackStep.allAttackSteps.remove(bypassNetworkDetection);
      bypassNetworkDetection = new BypassNetworkDetection(this.name);
      AttackStep.allAttackSteps.remove(bypassProxies);
      bypassProxies = new BypassProxies(this.name);
      AttackStep.allAttackSteps.remove(usertransmittedDataManipulation);
      usertransmittedDataManipulation = new UsertransmittedDataManipulation(this.name);
      AttackStep.allAttackSteps.remove(admintransmittedDataManipulation);
      admintransmittedDataManipulation = new AdmintransmittedDataManipulation(this.name);
      AttackStep.allAttackSteps.remove(c2Connexion);
      c2Connexion = new C2Connexion(this.name);
      AttackStep.allAttackSteps.remove(exchangeServerCollection);
      exchangeServerCollection = new ExchangeServerCollection(this.name);
      AttackStep.allAttackSteps.remove(networkShareDiscovery);
      networkShareDiscovery = new NetworkShareDiscovery(this.name);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork() {
      this(false, false, false, false, false, false);
      assetClassName = "InternalNetwork";
   }

   public InternalNetwork(String name) {
      this(name, false, false, false, false, false, false);
      assetClassName = "InternalNetwork";
   }


   public class ApplicationLayerConnexion extends AttackStepMax {
   public ApplicationLayerConnexion(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
addExpectedParent(networkIntrusionDetection.disable);
for (Computer computer_cbKdf : computer) {
addExpectedParent(computer_cbKdf.infectedComputer);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
c2Connexion.updateTtc(this, ttc, activeAttackSteps);
bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
for (ExternalNetwork externalNetwork_pYBVK : externalNetwork) {
externalNetwork_pYBVK.bypassNetworkDetection.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.applicationLayerConnexion");
      }

   }

   public class DataExfiltration extends AttackStepMax {
   public DataExfiltration(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
addExpectedParent(networkIntrusionDetection.disable);
if (firewall != null) {
addExpectedParent(firewall._bypassFirewall);
}
for (Computer computer_AwEXp : computer) {
addExpectedParent(computer_AwEXp.exfiltrationOverAternativeProtocol);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (ExternalNetwork externalNetwork_FLFhP : externalNetwork) {
externalNetwork_FLFhP.dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.dataExfiltration");
      }

   }

   public class FirewallExists extends Defense {
   public FirewallExists(String name) {
      super(name);
      disable = new Disable(name);
   }

   @Override
   public boolean isEnabled() {
      return firewall == null;
   }
   public class Disable extends AttackStepMin {
         public Disable(String name) {
            super(name);
         }

         @Override
         public String fullName() {
            return "internalNetwork.firewallExists";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (firewall != null) {
firewall._bypassFirewall.updateTtc(this, ttc, activeAttackSteps);
}
}
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
            return "internalNetwork.networkIntrusionDetection";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
dataExfiltration.updateTtc(this, ttc, activeAttackSteps);
if (c2Server != null) {
c2Server.dataExfiltrated.updateTtc(this, ttc, activeAttackSteps);
}
applicationLayerConnexion.updateTtc(this, ttc, activeAttackSteps);
for (Computer computer_nEvoY : computer) {
computer_nEvoY.networkServiceScan.updateTtc(this, ttc, activeAttackSteps);
}
c2Connexion.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class BypassNetworkDetection extends AttackStepMin {
   public BypassNetworkDetection(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
addExpectedParent(applicationLayerConnexion);
for (Computer computer_gkKju : computer) {
addExpectedParent(computer_gkKju.commonlyUsedPortsConnection);
}
if (c2Server != null) {
addExpectedParent(c2Server.obfuscatedData);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.bypassNetworkDetection");
      }

   }

   public class BypassProxies extends AttackStepMin {
   public BypassProxies(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Computer computer_fQpev : computer) {
addExpectedParent(computer_fQpev.uncommonlyUsedPortsConnection);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.bypassProxies");
      }

   }

   public class UsertransmittedDataManipulation extends AttackStepMax {
   public UsertransmittedDataManipulation(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (User user_IJluU : user) {
addExpectedParent(user_IJluU.userRights);
}
addExpectedParent(dataEncrypted.disable);
addExpectedParent(secureCommunication.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.usertransmittedDataManipulation");
      }

   }

   public class AdmintransmittedDataManipulation extends AttackStepMax {
   public AdmintransmittedDataManipulation(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Administrator administrator_rMkDy : administrator) {
addExpectedParent(administrator_rMkDy.adminRights);
}
addExpectedParent(dataEncrypted.disable);
addExpectedParent(secureCommunication.disable);
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.admintransmittedDataManipulation");
      }

   }

   public class DataEncrypted extends Defense {
   public DataEncrypted(String name, Boolean enabled) {
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
            return "internalNetwork.dataEncrypted";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
usertransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
admintransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class SecureCommunication extends Defense {
   public SecureCommunication(String name, Boolean enabled) {
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
            return "internalNetwork.secureCommunication";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
usertransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
admintransmittedDataManipulation.updateTtc(this, ttc, activeAttackSteps);
}
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
            return "internalNetwork.whitelisting";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_Hrisl : computer) {
computer_Hrisl.networkServiceScan.updateTtc(this, ttc, activeAttackSteps);
}
}
   }
}

   public class C2Connexion extends AttackStepMax {
   public C2Connexion(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (Service service_nCgWF : service) {
addExpectedParent(service_nCgWF.remoteAccessTools);
}
addExpectedParent(applicationLayerConnexion);
addExpectedParent(networkIntrusionDetection.disable);
if (firewall != null) {
addExpectedParent(firewall._bypassFirewall);
}
for (Computer computer_zGONz : computer) {
addExpectedParent(computer_zGONz.commonlyUsedPortsConnection);
}
for (Computer computer_iYKoO : computer) {
addExpectedParent(computer_iYKoO.uncommonlyUsedPortsConnection);
}
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
if (c2Server != null) {
c2Server.c2Connected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.c2Connexion");
      }

   }

   public class ExchangeServerCollection extends AttackStepMax {
   public ExchangeServerCollection(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (User user_xQUrL : user) {
addExpectedParent(user_xQUrL.userCredentials);
}
addExpectedParent(dataEncryption.disable);
addExpectedParent(twoFactorsAuthentication.disable);
}
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
for (Computer computer_eaNxD : computer) {
computer_eaNxD.dataCollected.updateTtc(this, ttc, activeAttackSteps);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.exchangeServerCollection");
      }

   }

   public class DataEncryption extends Defense {
   public DataEncryption(String name, Boolean enabled) {
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
            return "internalNetwork.dataEncryption";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exchangeServerCollection.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class TwoFactorsAuthentication extends Defense {
   public TwoFactorsAuthentication(String name, Boolean enabled) {
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
            return "internalNetwork.twoFactorsAuthentication";
         }
@Override
public void updateChildren(java.util.Set<AttackStep> activeAttackSteps) {
exchangeServerCollection.updateTtc(this, ttc, activeAttackSteps);
}
   }
}

   public class NetworkShareDiscovery extends AttackStepMin {
   public NetworkShareDiscovery(String name) {
      super(name);
      assetClassName = "InternalNetwork";
   }
@Override
public void setExpectedParents() {
for (MacOS macOS_kTHtO : macOS) {
addExpectedParent(macOS_kTHtO.networkShareDiscovery);
}
for (Windows windows_ocZSf : windows) {
addExpectedParent(windows_ocZSf.networkShareDiscovery);
}
}
      @Override
      public double localTtc() {
         return ttcHashMap.get("InternalNetwork.networkShareDiscovery");
      }

   }

      public void addC2Server(C2Server c2Server) {
         this.c2Server = c2Server;
         c2Server.internalNetwork = this;
      }

      public void addFirewall(Firewall firewall) {
         this.firewall = firewall;
         firewall.internalNetwork = this;
      }

      public void addExternalNetwork(ExternalNetwork externalNetwork) {
         this.externalNetwork.add(externalNetwork);
         externalNetwork.internalNetwork = this;
      }

      public void addUser(User user) {
         this.user.add(user);
         user.internalNetwork = this;
      }

      public void addAdministrator(Administrator administrator) {
         this.administrator.add(administrator);
         administrator.internalNetwork = this;
      }

      public void addComputer(Computer computer) {
         this.computer.add(computer);
         computer.internalNetwork = this;
      }

      public void addWindows(Windows windows) {
         this.windows.add(windows);
         windows.internalNetwork = this;
      }

      public void addMacOS(MacOS macOS) {
         this.macOS.add(macOS);
         macOS.internalNetwork = this;
      }

      public void addService(Service service) {
         this.service.add(service);
         service.internalNetwork = this;
      }

   @Override
   public String getAssociatedAssetClassName(String roleName) {
      if (roleName.equals("c2Server")) {
         return c2Server.getClass().getName();
      }
      if (roleName.equals("firewall")) {
         return firewall.getClass().getName();
      }
      if (roleName.equals("externalNetwork")) {
         for (Object o: externalNetwork) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("user")) {
         for (Object o: user) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("administrator")) {
         for (Object o: administrator) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("computer")) {
         for (Object o: computer) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("windows")) {
         for (Object o: windows) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("macOS")) {
         for (Object o: macOS) {
            return o.getClass().getName();
         }
      }
      if (roleName.equals("service")) {
         for (Object o: service) {
            return o.getClass().getName();
         }
      }
      return null;
   }
   @Override
   public java.util.Set<Asset> getAssociatedAssets(String roleName) {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (roleName.equals("c2Server")  && c2Server != null) {
         assets.add(c2Server);
         return assets;
      }
      if (roleName.equals("firewall")  && firewall != null) {
         assets.add(firewall);
         return assets;
      }
      if (roleName.equals("externalNetwork")  && externalNetwork != null) {
         assets.addAll(externalNetwork);
         return assets;
      }
      if (roleName.equals("user")  && user != null) {
         assets.addAll(user);
         return assets;
      }
      if (roleName.equals("administrator")  && administrator != null) {
         assets.addAll(administrator);
         return assets;
      }
      if (roleName.equals("computer")  && computer != null) {
         assets.addAll(computer);
         return assets;
      }
      if (roleName.equals("windows")  && windows != null) {
         assets.addAll(windows);
         return assets;
      }
      if (roleName.equals("macOS")  && macOS != null) {
         assets.addAll(macOS);
         return assets;
      }
      if (roleName.equals("service")  && service != null) {
         assets.addAll(service);
         return assets;
      }
      assertTrue("The asset " + this.toString() + " does not feature the role name " + roleName + ".", false);
      return null;
   }
   @Override
   public java.util.Set<Asset> getAllAssociatedAssets() {
      java.util.Set<Asset> assets = new java.util.HashSet<>();
      if (c2Server != null) {
         assets.add(c2Server);
      }
      if (firewall != null) {
         assets.add(firewall);
      }
      assets.addAll(externalNetwork);
      assets.addAll(user);
      assets.addAll(administrator);
      assets.addAll(computer);
      assets.addAll(windows);
      assets.addAll(macOS);
      assets.addAll(service);
      return assets;
   }
}
