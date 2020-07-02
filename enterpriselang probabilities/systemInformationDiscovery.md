# [System Information Discovery](https://attack.mitre.org/techniques/T1082/)

## Context
>An adversary may attempt to get detailed information about the operating system and hardware, including version, patches, hotfixes, service packs, and architecture. Adversaries may use the information from System Information Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.

## Findings
Recorded Future's report ["Defense Evasion Dominant in Top MITRE ATT&CK Tactics of 2019"](https://www.recordedfuture.com/mitre-attack-tactics/) puts System Information Discovery as occuring in 18,842 malware samples out of 26,057 total. This is ~72.31%. 

In [this](https://krisk.io/post/sok-attack-securecomm19.pdf) article on ATT&CK Techniques and Trends in Windows Malware, with a sample size of 951 the authors find that 669 samples do some kind of System Information Discovery. This corresponds to ~70.35%

If we use the average of these two, we find that ~71.33% of malware exhibit this tactic. -> ```Bernoulli(0.7133)```. 

## Time to compromise
MITRE lists some examples of how this attack step can be performed. It seems quite quick and easy to gain this information. The info below is directly from https://attack.mitre.org/techniques/T1082/

### >Windows
Example commands and utilities that obtain this information include `ver`, `Systeminfo`, and `dir` within cmd for identifying information based on present files and directories.

### >Mac
On Mac, the `systemsetup` command gives a detailed breakdown of the system, but it requires administrative privileges. Additionally, the `system_profiler` gives a very detailed breakdown of configurations, firewall rules, mounted volumes, hardware, and many other things without needing elevated permissions.

### >AWS
In Amazon Web Services (AWS), the Application Discovery Service may be used by an adversary to identify servers, virtual machines, software, and software dependencies running.

### >GCP
On Google Cloud Platform (GCP)` GET /v1beta1/{{parent=organizations/}}/assets` or `POST /v1beta1/{{parent=organizations/}}/assets:runDiscovery` may be used to list an organizations cloud assets, or perform asset discovery on a cloud environment.

### >Azure
In Azure, the API request `GET https://management.azure.com/subscriptions/{{subscriptionId}}/resourceGroups/{{resourceGroupName}}/providers/Microsoft.Compute/virtualMachines/{{vmName}}?api-version=2019-03-01` may be used to retrieve information about the model or instance view of a virtual machine.

Seemingly, all of these are quite simple commands that could be typed by an attacker. I can't imagine it would take more than a few second to type even the longest command, and as such I will assume this attack step to be instant. 

## Result
```Bernoulli(0.7133)```