# File System Permissions Weakness 

## Context (https://attack.mitre.org/techniques/T1044/)

Processes may automatically execute specific binaries as part of their functionality or to perform other actions. If the permissions on the file system directory containing a target binary, or permissions on the binary itself, are improperly set, then the target binary may be overwritten with another binary using user-level permissions and executed by the original process. If the original process and thread are running under a higher permissions level, then the replaced binary will also execute under higher-level permissions, which could include SYSTEM.

Adversaries may use this technique to replace legitimate binaries with malicious ones as a means of executing code at a higher permissions level. If the executing process is set to run at a specific time or during a certain event (e.g., system bootup) then this technique can also be used for persistence.

### Services
Manipulation of Windows service binaries is one variation of this technique. Adversaries may replace a legitimate service executable with their own executable to gain persistence and/or privilege escalation to the account context the service is set to execute under (local/domain account, SYSTEM, LocalService, or NetworkService). Once the service is started, either directly by the user (if appropriate access is available) or through some other means, such as a system restart if the service starts on bootup, the replaced executable will run instead of the original service executable.

### Executable Installers
Another variation of this technique can be performed by taking advantage of a weakness that is common in executable, self-extracting installers. During the installation process, it is common for installers to use a subdirectory within the %TEMP% directory to unpack binaries such as DLLs, EXEs, or other payloads. When installers create subdirectories and files they often do not set appropriate permissions to restrict write access, which allows for execution of untrusted code placed in the subdirectories or overwriting of binaries used in the installation process. This behavior is related to and may take advantage of DLL Search Order Hijacking. Some installers may also require elevated privileges that will result in privilege escalation when executing adversary controlled code. This behavior is related to Bypass User Account Control. Several examples of this weakness in existing common installers have been reported to software vendors.

## Relevant findings 

https://www.csoonline.com/article/3390663/check-your-access-control-permissions-before-hackers-do.html
Roger A. Grimes states that among all the security reviews he made, he always found incorrectly set permissions at some point. 

https://www.varonis.com/blog/data-breach-statistics/
According to the Varonis data brach statistics,  80% of companies with over 1 million folders found over 50,000 folders open to every employee, 53% of companies found over 1,000 sensitive files accessible to every employee, and 58% of companies found over 1,000 folders that had inconsistent permissions, 15% of companies found more than 1 million folders open to every employee . These statistics suggest that most companies have weak file system permissions. 

We can assume, based on those figures that nearly 100% of companies are vulnerable to the File System Permissions Weakness technique.

https://capec.mitre.org/data/definitions/17.html
In the MITRE framework, this technique is mapped to the general CAPEC-17: Using Malicious Files technique, which is said to have a High likelihood of attack and a low Skill Required. 

https://github.com/mal-lang/malcompiler/wiki/Supported-distribution-functions
Looking at the ordinal distributions supported by the MAL, we could assess that the results found in the CAPEC framework can be reprensented by the EasyAndCertain probability distribution.

## Results 

Based on the previous results, we assess the probability distribution for this technique to be [Exponential(1)]

## Discussion

We can't be certain that each and every company are exposed with the same severity to this technique. However the findings are general and suggest that most companies are vulnerable to it. We assumed that a professional adversary will eventually manage to abuse this technique. More findings on the topic are welcome and could update the probability distribution. 

