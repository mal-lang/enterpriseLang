package core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConstraintChecker {

   public ConstraintChecker(Boolean enforce) {
      for (Asset asset : Asset.allAssets) {

         Set<String> conditionalRoles = new HashSet<>();
         Set<String> secondRoles = new HashSet<>();
         Set<String> thirdRoles = new HashSet<>();

         List<String> navigationPath = new ArrayList<>();
         conditionalRoles.add("executor");
         navigationPath.add("rootAccount");
         navigationPath.add("assignedSoftwares");
         asset.cycleRequirement("Software", conditionalRoles, navigationPath, enforce);

         conditionalRoles.clear();
         secondRoles.clear();
         thirdRoles.clear();
         conditionalRoles.add("readData");
         secondRoles.add("machines");
         thirdRoles.add("rootAccounts");
         thirdRoles.add("userAccounts");
         asset.cycleRequirement("Account", conditionalRoles, secondRoles, thirdRoles, true);

         Set<String> requiredTargetAssets = new HashSet<>();
         requiredTargetAssets.add("PhysicalMachine");
         requiredTargetAssets.add("VirtualMachine");
         asset.counterPartTypeRequirement("OperatingSystem", "executor", requiredTargetAssets, enforce);

         requiredTargetAssets.clear();
         requiredTargetAssets.add("PhysicalMachine");
         asset.counterPartTypeRequirement("HypervisorTypeI", "executor", requiredTargetAssets, enforce);

         asset.prohibitAssociation("Wifi", "trafficRouters", enforce);
         asset.prohibitAssociation("WifiRouter", "trafficNetworks", enforce);

         requiredTargetAssets.clear();
         requiredTargetAssets.add("HypervisorTypeI");
         requiredTargetAssets.add("HypervisorTypeII");
         asset.counterPartTypeRequirement("VirtualMachine", "executor", requiredTargetAssets, enforce);

         requiredTargetAssets.clear();
         requiredTargetAssets.add("OperatingSystem");
         requiredTargetAssets.add("Container");
         asset.counterPartTypeRequirement("Application", "executor", requiredTargetAssets, enforce);

         requiredTargetAssets.clear();
         requiredTargetAssets.add("Browser");
         asset.counterPartTypeRequirement("WebApplicationClient", "executor", requiredTargetAssets, enforce);

         requiredTargetAssets.clear();
         requiredTargetAssets.add("WebServer");
         asset.counterPartTypeRequirement("WebApplicationService", "executor", requiredTargetAssets, enforce);
      }
   }

}