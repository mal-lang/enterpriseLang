# Privilege Escalation (https://attack.mitre.org/tactics/TA0004/)

The word "review" is normally used when the code related to a technique might need some review.
The word "note" is normally used when a side idea is given.
the word "needs" is normally used whenever a technique needs a probability or time distribution.

## This file is meant to list all attack steps in the Privilege escalation Tactic and the related steps in order to assess which ones need a probability distribution

The adversary is trying to gain higher-level permissions.

Privilege Escalation consists of techniques that adversaries use to gain higher-level permissions on a system or network. Adversaries can often enter and explore a network with unprivileged access but require elevated permissions to follow through on their objectives. Common approaches are to take advantage of system weaknesses, misconfigurations, and vulnerabilities. Examples of elevated access include: • SYSTEM/root level • local administrator • user account with admin-like access • user accounts with access to specific system or perform specific function These techniques often overlap with Persistence techniques, as OS features that let an adversary persist can execute in an elevated context.

## Techniques

|ID| Name|	Description| Parents | Children |Mitigations | Needs probability? |
|---|---|---|---|---|---|---|
|T1134	| Access Token Manipulation	| Windows uses access tokens to determine the ownership of a running process. A user can manipulate access tokens to make a running process appear as though it belongs to someone other than the user that started the process. When this occurs, the process also takes on the security context associated with the new token. For example, Microsoft promotes the use of access tokens as a security best practice. Administrators should log in as a standard user but run their tools with administrator privileges using the built-in access token manipulation command runas. | user/adminRights (depending on the type of account),logon scripts |_exploitationForPrivilegeEscalation|User/Privileged Account Management|Probably|
|T1015 |	Accessibility Features	| Windows contains accessibility features that may be launched with a key combination before a user has logged in (for example, when the user is on the Windows logon screen). An adversary can modify the way these programs are launched to get a command prompt or backdoor without logging in to the system. |adminRights, fileAndDirectoryPermissionsModification|executeCode, systemRights,_remoteDesktopProtocol|executionPrevention (2 others for RDP)|Yes|
|T1182	| AppCert DLLs| Dynamic-link libraries (DLLs) that are specified in the AppCertDLLs Registry key under HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager are loaded into every process that calls the ubiquitously used application programming interface (API) functions CreateProcess, CreateProcessAsUser, CreateProcessWithLoginW, CreateProcessWithTokenW, or WinExec. |admin/systemRights |persistence,systemRights,adminRights|executionPrevention|Probably|
|T1103	|AppInit DLLs	| Dynamic-link libraries (DLLs) that are specified in the AppInit_DLLs value in the Registry keys HKEY_LOCAL_MACHINE\Software\Microsoft\Windows NT\CurrentVersion\Windows or HKEY_LOCAL_MACHINE\Software\Wow6432Node\Microsoft\Windows NT\CurrentVersion\Windows are loaded by user32.dll into every process that loads user32.dll. In practice this is nearly every program, since user32.dll is a very common library. Similar to Process Injection, these values can be abused to obtain persistence and privilege escalation by causing a malicious DLL to be loaded and run in the context of separate processes on the computer.| adminRights | systemRights, persistence |updateSoftware, prevent Execution |Yes|
| T1138	|Application Shimming	| The Microsoft Windows Application Compatibility Infrastructure/Framework (Application Shim) was created to allow for backward compatibility of software as the operating system codebase changes over time. For example, the application shimming feature allows developers to apply fixes to applications (without rewriting code) that were created for Windows XP so that it will work with Windows 10. Within the framework, shims are created to act as a buffer between the program (or more specifically, the Import Address Table) and the Windows OS. When a program is executed, the shim cache is referenced to determine if the program requires the use of the shim database (.sdb). If so, the shim database uses Hooking to redirect the code as necessary in order to communicate with the OS.|REVIEW|REVIEW|REVIEW|REVIEW|
|T1088|	Bypass User Account Control	|Windows User Account Control (UAC) allows a program to elevate its privileges to perform a task under administrator-level permissions by prompting the user for confirmation. The impact to the user ranges from denying the operation under high enforcement to allowing the user to perform the action if they are in the local administrators group and click through the prompt or allowing them to enter an administrator password to complete the action. | REVIEW|REVIEW|User Account Control, privilege account management, audit |Yes|
| T1038|	DLL Search Order Hijacking| Windows systems use a common method to look for required DLLs to load into a program. Adversaries may take advantage of the Windows DLL search order and programs that ambiguously specify DLLs to gain privilege escalation and persistence. |user/admin/systemRights, searchOrderHijacking|bypassProcessWhitelisting, bypassUserAccountControl, sysAdmin.systemRights, userAccount.userRights, adminAccount.windowsAdmin.adminRights, attemptlSASS_Driver |Audit, executionPrevention, Restrict Library Loading|Yes|
| T1157	| Dylib Hijacking | macOS and OS X use a common method to look for required dynamic libraries (dylib) to load into a program based on search paths. Adversaries can take advantage of ambiguous paths to plant dylibs to gain privilege escalation or persistence.|userRights|exploitation for privilege escalation|restrictFileAndDirectoryPermissions, userAccountManagement|Yes| 
|T1514	|Elevated Execution with Prompt| Adversaries may leverage the AuthorizationExecuteWithPrivileges API to escalate privileges by prompting the user for credentials. The purpose of this API is to give application developers an easy way to perform operations with root privileges, such as for application installation or updating. This API does not validate that the program requesting root privileges comes from a reputable source or has been maliciously modified. Although this API is deprecated, it still fully functions in the latest releases of macOS. When calling this API, the user will be prompted to enter their credentials but no checks on the origin or integrity of the program are made. The program calling the API may also load world writable files which can be modified to perform malicious behavior with elevated privileges. |userRights|adminRights|executionPrevention|Maybe not (REVIEW)|
|T1519|	Emond	| Adversaries may use Event Monitor Daemon (emond) to establish persistence by scheduling malicious commands to run on predictable event triggers. Emond is a Launch Daemon that accepts events from various services, runs them through a simple rules engine, and takes action. The emond binary at /sbin/emond will load any rules from the /etc/emond.d/rules/ directory and take action once an explicitly defined event takes place. The rule files are in the plist format and define the name, event type, and action to take. Some examples of event types include system startup and user authentication. Examples of actions are to run a system command or send an email. The emond service will not launch if there is no file present in the QueueDirectories path /private/var/db/emondClients, specified in the Launch Daemon configuration file at/System/Library/LaunchDaemons/com.apple.emond.plist.|adminRights|persistence, exploitation for privilege escalation |diableorRemoveFeatureOrProgram|Yes|
| T1068|	Exploitation for Privilege Escalation |Exploitation of a software vulnerability occurs when an adversary takes advantage of a programming error in a program, service, or within the operating system software or kernel itself to execute adversary-controlled code. Security constructs such as permission levels will often hinder access to information and use of certain techniques, so adversaries will likely need to perform Privilege Escalation to include use of software exploitation to circumvent those restrictions. |many parents|admin/systemRights, useThirdPartySoftware|Application Isolation and Sandboxing, Exploit Protection, Threat Intelligence Program, Update Software|Yes|
|T1181	|Extra Window Memory Injection| Before creating a window, graphical Windows-based processes must prescribe to or register a windows class, which stipulate appearance and behavior (via windows procedures, which are functions that handle input/output of data). Registration of new windows classes can include a request for up to 40 bytes of extra window memory (EWM) to be appended to the allocated memory of each instance of that class. This EWM is intended to store data specific to that window and has specific application programming interface (API) functions to set and get its value.|admin/systemRights|processInjection|none|REVIEW|
|T1044|	File System Permissions Weakness	| Processes may automatically execute specific binaries as part of their functionality or to perform other actions. If the permissions on the file system directory containing a target binary, or permissions on the binary itself, are improperly set, then the target binary may be overwritten with another binary using user-level permissions and executed by the original process. If the original process and thread are running under a higher permissions level, then the replaced binary will also execute under higher-level permissions, which could include SYSTEM. |userRights, adminRights, bypassUAC??|executeCode, admin/systemRights|audit, UAC, User Account Management|Yes|
| T1179	|Hooking| Windows processes often leverage application programming interface (API) functions to perform tasks that require reusable system resources. Windows API functions are typically stored in dynamic-link libraries (DLLs) as exported functions.|admin/systemRights, rootkit|executeCode, captureAPICalls|none|Yes|
| T1183	| Image File Execution Options Injection| Image File Execution Options (IFEO) enable a developer to attach a debugger to an application. When a process is created, a debugger present in an application’s IFEO will be prepended to the application’s name, effectively launching the new process under the debugger (e.g., “C:\dbg\ntsd.exe -g notepad.exe”).|admin/systemRights|bypassAutorunsAnalysis, persistence, service._exploitationForPrivilegeEscalation|none|Yes|
| T1160	 | Launch Daemon | Per Apple’s developer documentation, when macOS and OS X boot up, launchd is run to finish system initialization. This process loads the parameters for each launch-on-demand system-level daemon from the property list (plist) files found in /System/Library/LaunchDaemons and /Library/LaunchDaemons . These LaunchDaemons have property list files which point to the executables that will be launched. |adminrights|presistence, ecploitationforprivilegeescalation |User Account Management|Yes|
| T1050|	New Service| When operating systems boot up, they can start programs or applications called services that perform background system functions. A service's configuration information, including the file path to the service's executable, is stored in the Windows Registry. |adminRights, serviceexecution|masquerading, exploitationforPrivilegeEscalation|user Account Management|Yes|
| T1502	| Parent PID Spoofing	| Adversaries may spoof the parent process identifier (PPID) of a new process to evade process-monitoring defenses or to elevate privileges. New processes are typically spawned directly from their parent, or calling, process unless explicitly specified. One way of explicitly assigning the PPID of a new process is via the CreateProcess API call, which supports a parameter that defines the PPID to use. This functionality is used by Windows features such as User Account Control (UAC) to correctly set the PPID after a requested elevated process is spawned by SYSTEM (typically via svchost.exe or consent.exe) rather than the current user context. |adminRights|bypassHostForensicAnalysis,   bypassHeuristicDetection, service._exploitationForPrivilegeEscalation|none|REVIEW|
| T1034	| Path Interception	| Path interception occurs when an executable is placed in a specific path so that it is executed by an application instead of the intended target. One example of this was the use of a copy of cmd in the current working directory of a vulnerable application that loads a CMD or BAT file with the CreateProcess function. | user/admin/systemRights |unquotedPath, pathEnvironmentVariableMisconfiguration, earchOraderHijacking | userAccountManagement, audit, executionPrevention, restrictFileAndDirectoryPermisions | Maybe not |
| T1150	| Plist Modification | Property list (plist) files contain all of the information that macOS and OS X uses to configure applications and services. These files are UTF-8 encoded and formatted like XML documents via a series of keys surrounded by < >. They detail when programs should execute, file paths to the executables, program arguments, required OS permissions, and many others. plists are located in certain locations depending on their purpose such as /Library/Preferences (which execute with elevated privileges) and ~/Library/Preferences (which execute with a user's privileges). |user/adminRights |bypassApplicationWhitelisting, bypassProcessWhitelisting,  bypassFileOrPathWhitelisting, executeCode, persistence
|restrictFileAndDirectoryPermissions| Yes |
| T1013	| Port Monitors | A port monitor can be set through the API call to set a DLL to be loaded at startup. This DLL can be located in C:\Windows\System32 and will be loaded by the print spooler service, spoolsv.exe, on boot. The spoolsv.exe process also runs under SYSTEM level permissions. Alternatively, an arbitrary DLL can be loaded if permissions allow writing a fully-qualified pathname for that DLL to HKLM\SYSTEM\CurrentControlSet\Control\Print\Monitors. | admin/systemRights|executeCode, exploitationForPrivilegeEscalation, persistence|none|Yes|
| T1504	| PowerShell Profile | Adversaries may gain persistence and elevate privileges in certain situations by abusing PowerShell profiles. A PowerShell profile (profile.ps1) is a script that runs when PowerShell starts and can be used as a logon script to customize user environments. PowerShell supports several profiles depending on the user or host program. For example, there can be different profiles for PowerShell host programs such as the PowerShell console, PowerShell ISE or Visual Studio Code. An administrator can also configure a profile that applies to all users and host programs on the local computer.|user/adminRights  |exploitationforPrivilegeEscalation, persistence|codeSigning, restrictRegistryPermissions, softwareConfiguration|Yes|
| T1055	| Process Injection | Process injection is a method of executing arbitrary code in the address space of a separate live process. Running code in the context of another process may allow access to the process's memory, system/network resources, and possibly elevated privileges. Execution via process injection may also evade detection from security products since the execution is masked under a legitimate process. |userRights, processDiscovery, systemInformationDiscovery, componentObjectModelHijacking, executionThroughAPI, extraWindowMemoryInjection |exploitationforPrivilegeEscalation, bypassAntivirus, bypassProcessWhitelisting|behaviourPreventionOnEndpoint, executionPrevention |Yes|
|T1053	|Scheduled Task| Utilities such as at and schtasks, along with the Windows Task Scheduler, can be used to schedule programs or scripts to be executed at a date and time. A task can also be scheduled on a remote system, provided the proper authentication is met to use RPC and file and printer sharing is turned on. Scheduling a task on a remote system typically required being a member of the Administrators group on the remote system.|systemTimeDiscovery, user/adminRights, groupPolicyModification|executeCode, service.exploitationForPrivilegeEscalation, persistence|audit, operationSystemConfiguration, privileged/userAccountManagement|Yes|
| T1058	| Service Registry Permissions Weakness	| Windows stores local service configuration information in the Registry under HKLM\SYSTEM\CurrentControlSet\Services. The information stored under a service's Registry keys can be manipulated to modify a service's execution parameters through tools such as the service controller, sc.exe, PowerShell, or Reg. Access to Registry keys is controlled through Access Control Lists and permissions. |admin/systemRights|persistence, exploitationForPrivilegeEscalation|restrictfileAndDirectoryPermissions|Maybe not|
| T1166	| Setuid and Setgid	| When the setuid or setgid bits are set on Linux or macOS for an application, this means that the application will run with the privileges of the owning user or group respectively . Normally an application is run in the current user’s context, regardless of which user or group owns the application. There are instances where programs need to be executed in an elevated context to function properly, but the user running them doesn’t need the elevated privileges. Instead of creating an entry in the sudoers file, which must be done by root, any user can specify the setuid or setgid flag to be set for their own applications. These bits are indicated with an "s" instead of an "x" when viewing a file's attributes via ls -l. The chmod program can set these bits with via bitmasking, chmod 4777 [file] or via shorthand naming, chmod u+s [file]. |userRights|exploitationforPrivilegeEscalation, persistence|OSconfig|Maybe not|
|T1178	|SID-History Injection	| The Windows security identifier (SID) is a unique value that identifies a user or group account. SIDs are used by Windows security in both security descriptors and access tokens. An account can hold additional SIDs in the SID-History Active Directory attribute , allowing inter-operable account migration between domains (e.g., all values in SID-History are included in access tokens). |dcShadow, admin/systemRights|adminRemoteServicesLogin, windowsAdminShares, windowsRemoteManagement, persistence|Active Directory configuration |Maybe not|
| T1165	| Startup Items	| Per Apple’s documentation, startup items execute during the final phase of the boot process and contain shell scripts or other executable files along with configuration information used by the system to determine the execution order for all startup items . This is technically a deprecated version (superseded by Launch Daemons), and thus the appropriate folder, /Library/StartupItems isn’t guaranteed to exist on the system by default, but does appear to exist by default on macOS Sierra. A startup item is a directory whose executable and configuration property list (plist), StartupParameters.plist, reside in the top-level directory. |adminRights|persistence, exploitationforPrivilegeEscalation|userAccountManagement, restrictFileAndDirectoryPermissions|Yes|
| T1169| 	Sudo| The sudoers file, /etc/sudoers, describes which users can run which commands and from which terminals. This also describes which commands users can run as other users or groups. This provides the idea of least privilege such that users are running in their lowest possible permissions for most of the time and only elevate to other users or permissions as needed, typically by prompting for a password. However, the sudoers file can also specify when to not prompt users for passwords with a line like user1 ALL=(ALL) NOPASSWD: ALL . |userRights|exploitationForPrivilegeEscalation|restrictFileAndDirectoryPermissions, privilegedAccountManagement, |Maybe Not|
| T1206| 	Sudo Caching	| The sudo command "allows a system administrator to delegate authority to give certain users (or groups of users) the ability to run some (or all) commands as root or another user while providing an audit trail of the commands and their arguments." Since sudo was made for the system administrator, it has some useful configuration features such as a timestamp_timeout that is the amount of time in minutes between instances of sudo before it will re-prompt for a password. This is because sudo has the ability to cache credentials for a period of time. Sudo creates (or touches) a file at /var/db/sudo with a timestamp of when sudo was last run to determine this timeout. Additionally, there is a tty_tickets variable that treats each new tty (terminal session) in isolation. This means that, for example, the sudo timeout of one tty will not affect another tty (you will have to type the password again).|userRights|exploitationforPrivilegeEscalation|privilegedAccountManagement, OSConfig |Yes|
|T1078 |	Valid Accounts| Adversaries may steal the credentials of a specific user or service account using Credential Access techniques or capture credentials earlier in their reconnaissance process through social engineering for means of gaining Initial Access. |user/adminCredentials, externalRemoteServices, trustedRelationship, bypassMFA, inputCapture, redudantAccess, dataencryptedforimpact |service.userRemoteServicesLogin, service.adminRemoteServicesLogin, computer.router.internalNetwork.bypassFirewall, computer.router.internalNetwork.bypassNetworkIntrusionDetection, bypassHostIntrusionPrevention, bypassProcessWhitelisting, bypassSystemAccessControls,  bypassAntivirus, graphicalUserInterface, kerberoasting |user/privilegedAccountManagement,MFA, passwordPolicies, audit,filterNetworkTraffic, applicationDeveloperGuidance|No|
| T1100 |	Web Shell	| A Web shell is a Web script that is placed on an openly accessible Web server to allow an adversary to use the Web server as a gateway into a network. A Web shell may provide a set of functions to execute or a command-line interface on the system that hosts the Web server. In addition to a server-side script, a Web shell may have a client interface program that is used to talk to the Web server (see, for example, China Chopper Web shell client).|none?|redudantAccess, persistence|privileged Account Management, updateSoftware|| 


## Probability Assessment

### User & Admin Access Token Manipulation (needs)

Adversaries may use access tokens to operate under a different user or system security context to perform actions and evade detection. An adversary can use built-in Windows API functions to copy access tokens from existing processes; this is known as token stealing. An adversary must already be in a privileged user context (i.e. administrator) to steal a token. However, adversaries commonly use token stealing to elevate their security context from the administrator level to the SYSTEM level. An adversary can use a token to authenticate to a remote system as the account for that token if the account has appropriate permissions on the remote system.

Access tokens can be leveraged by adversaries through three methods:

*Token Impersonation/Theft *- An adversary creates a new access token that duplicates an existing token using DuplicateToken(Ex). The token can then be used with ImpersonateLoggedOnUser to allow the calling thread to impersonate a logged on user's security context, or with SetThreadToken to assign the impersonated token to a thread. This is useful for when the target user has a non-network logon session on the system.

*Create Process with a Token* - An adversary creates a new access token with DuplicateToken(Ex) and uses it with CreateProcessWithTokenW to create a new process running under the security context of the impersonated user. This is useful for creating a new process under the security context of a different user.

*Make and Impersonate Token* - An adversary has a username and password but the user is not logged onto the system. The adversary can then create a logon session for the user using the LogonUser function. The function will return a copy of the new session's access token and the adversary can use SetThreadToken to assign the token to a thread.

Any standard user can use the runas command, and the Windows API functions, to create impersonation tokens; it does not require access to an administrator account.

*Metasploit’s Meterpreter payload allows arbitrary token manipulation and uses token impersonation to escalate privileges.The Cobalt Strike beacon payload allows arbitrary token impersonation and can also create tokens.*

This might need to be *split into 3* and given a probability distribution for each of them. 

You might also wanna *change* the children for admin vs user access token manipulation since an adversary must already have administrator level access on the local system to make full use of this technique.

### Accessibility Features (needs prevalence)

Two common accessibility programs are C:\Windows\System32\sethc.exe, launched when the shift key is pressed five times and C:\Windows\System32\utilman.exe, launched when the Windows + U key combination is pressed. The sethc.exe program is often referred to as "sticky keys", and has been used by adversaries for unauthenticated access through a remote desktop login screen. 

*Depending on the version of Windows*, an adversary may take advantage of these features in different ways because of code integrity enhancements. In newer versions of Windows, the replaced binary needs to be digitally signed for x64 systems, the binary must reside in %systemdir%\, and it must be protected by Windows File or Resource Protection (WFP/WRP). The debugger method was likely discovered as a potential workaround because it does not require the corresponding accessibility feature binary to be replaced. Examples for both methods:

For simple binary replacement on Windows XP and later as well as and Windows Server 2003/R2 and later, for example, the program (e.g., C:\Windows\System32\utilman.exe) may be replaced with "cmd.exe" (or another program that provides backdoor access). Subsequently, pressing the appropriate key combination at the login screen *while sitting at the keyboard or when connected over Remote Desktop Protocol* will cause the replaced file to be executed with SYSTEM privileges.

For the debugger method on Windows Vista and later as well as Windows Server 2008 and later, for example, a Registry key may be modified that configures "cmd.exe," or another program that provides backdoor access, as a "debugger" for the accessibility program (e.g., "utilman.exe"). After the Registry is modified, pressing the appropriate key combination at the login screen while at the keyboard or when connected with RDP will cause the "debugger" program to be executed with SYSTEM privileges. 

Other accessibility features exist that may also be leveraged in a similar fashion: 

On-Screen Keyboard: C:\Windows\System32\osk.exe
Magnifier: C:\Windows\System32\Magnify.exe
Narrator: C:\Windows\System32\Narrator.exe
Display Switcher: C:\Windows\System32\DisplaySwitch.exe
App Switcher: C:\Windows\System32\AtBroker.exe

Remote Desktop Protcol seems to be a | parent (Having remote access to execute) and not a child. *CHECK THAT*

This technique (once you have RDP or physical access) takes no time to pull out. However, since the outcome depends on the version of Windows, it will need a probability distribution.
 
### AppCert DLLs (probably needs)

This is based on the execution of malicious DLLs via CreateProcess API.

*Similar to Process Injection*, this value can be abused to obtain persistence and privilege escalation by causing a malicious DLL to be loaded and run in the context of separate processes on the computer.

### AppInit DLL (needs)

The AppInit DLL functionality is disabled in Windows 8 and later versions when secure boot is enabled.

This then needs a probability distribution.

### Application Shimming (needs review)

To keep shims secure, Windows designed them to run in user mode so they cannot modify the kernel and you must have administrator privileges to install a shim. However, certain shims can be used to Bypass User Account Control (UAC) (RedirectEXE), inject DLLs into processes (InjectDLL), disable Data Execution Prevention (DisableNX) and Structure Exception Handling (DisableSEH), and intercept memory addresses (GetProcAddress). *Similar to Hooking*, utilizing these shims may allow an adversary to perform several malicious acts such as elevate privileges, install backdoors, disable defenses like Windows Defender, etc.

This one looks much more complex than it currently is in the entreprise.mal and needs to be reviewed. BypassExecutionPrevention?

### Bypass user Account Control (needs review)

Probability found by Love

This might need a | helper step considering how many parents it has. This needs review.

### DLL Search Order Hijacking 

Probability found by Love

### dylibHijacking 

macOS and OS X use a common method to look for required dynamic libraries (dylib) to load into a program based on search paths. Adversaries can take advantage of ambiguous paths to plant dylibs to gain privilege escalation or persistence.

A common method is to see what dylibs an application uses, then plant a malicious version with the same name higher up in the search path. This typically results in the dylib being in the same folder as the application itself.

If the program is configured to run at a higher privilege level than the current user, then when the dylib is loaded into the application, the dylib will also run at that elevated level. This can be used by adversaries as a privilege escalation technique.

This technique is similar to *DLL Search Order Hijacking*, on macOS and OS X. We'll assume that the probability distribution for dylibHijacking is the same as the one for DLL Search Order Hijacking.

### Elevated Execution with Prompt (needs review)

Adversaries may leverage the AuthorizationExecuteWithPrivileges API to escalate privileges by prompting the user for credentials.The purpose of this API is to give application developers an easy way to perform operations with root privileges, such as for application installation or updating. This API does not validate that the program requesting root privileges comes from a reputable source or has been maliciously modified. Although this API is deprecated, it still fully functions in the latest releases of macOS. *When calling this API, the user will be prompted to enter their credentials* but no checks on the origin or integrity of the program are made. The program calling the API may also load world writable files which can be modified to perform malicious behavior with elevated privileges.

Adversaries may abuse AuthorizationExecuteWithPrivileges to obtain root privileges in order to install malicious software on victims and install *persistence* mechanisms. This technique may be combined with *Masquerading* to trick the user into granting escalated privileges to malicious code. This technique has also been shown to work by modifying legitimate programs present on the machine that make use of this API.

This suggests that the masquerading technique may be used before calling the API in order to execute malicious code with privilege. Masquerading should then be a parent for this technique. Persistence might be a child too.

This needs review.

### Emond (needs)

Adversaries may abuse this service by writing a rule to execute commands when a defined event occurs, such as system start up or user authentication. Adversaries may also be able to escalate privileges from administrator to root as the emond service is executed with root privileges by the Launch Daemon service.

This at least needs a time distribution. 

### Exploitation For Privilege Escalation 

*Exploitation of a software vulnerability* occurs when an adversary takes advantage of a programming error in a program, service, or within the operating system software or kernel itself to execute adversary-controlled code. Security constructs such as permission levels will often hinder access to information and use of certain techniques, so adversaries will likely need to perform Privilege Escalation to include use of software exploitation to circumvent those restrictions.

When initially gaining access to a system, an adversary may be operating within a lower privileged process which will prevent them from accessing certain resources on the system. Vulnerabilities may exist, usually in operating system components and software commonly running at higher permissions, that can be exploited to gain higher levels of access on the system. This could enable someone to move from unprivileged or user level permissions to SYSTEM or root permissions depending on the component that is vulnerable. This may be a necessary step for an adversary compromising a endpoint system that has been properly configured and limits other privilege escalation methods.

This is the general technique that is the final goal of this tactic. This doesn't need a probability distribution, all the techniques leading to it do however.

### Extra Window Memory Injection (needs review)

Although small, the EWM is large enough to store a 32-bit pointer and is often used to point to a windows procedure. Malware may possibly utilize this memory location in part of an attack chain that includes writing code to shared sections of the process’s memory, placing a pointer to the code in EWM, then invoking execution by returning execution control to the address in the process’s EWM.

Execution granted through EWM injection may take place in the address space of a separate live process. *Similar to Process Injection*, this may allow access to both the target process's memory and possibly elevated privileges. Writing payloads to shared sections also avoids the use of highly monitored API calls such as WriteProcessMemory and CreateRemoteThread. More sophisticated malware samples may also potentially bypass protection mechanisms such as data execution prevention (DEP) by triggering a combination of windows procedures and other system functions that will rewrite the malicious payload inside an executable portion of the target process.

Process Injection is the only child but according to the mitre description it's not and there are others.

This needs review.

### File System Permission Weakness

persistence might be a child.

This needs a probability distribution (TTC too if persistence) and maybe some review.

About Executable Installers

*This behavior is related to and may take advantage of DLL Search Order Hijacking*. Some installers may also require elevated privileges that will result in privilege escalation when executing adversary controlled code. *This behavior is related to Bypass User Account Control*. Several examples of this weakness in existing common installers have been reported to software vendors.

### Hooking

Hooking involves redirecting calls to these functions and can be implemented via:

Hooks procedures, which intercept and execute designated code in response to events such as messages, keystrokes, and mouse inputs.
Import address table (IAT) hooking, which use modifications to a process’s IAT, where pointers to imported API functions are stored.
Inline hooking, which overwrites the first bytes in an API function to redirect code flow. 
*Similar to Process Injection*, adversaries may use hooking to load and execute malicious code within the context of another process, masking the execution while also allowing access to the process's memory and *possibly elevated privileges*. Installing hooking mechanisms *may also provide Persistence via continuous invocation when the functions are called through normal use*.

Malicious hooking mechanisms may also *capture API calls* that include parameters that reveal user authentication credentials for Credential Access. 

Hooking is commonly *utilized by Rootkits* to conceal files, processes, Registry keys, and other objects in order *to hide* malware and associated behaviors

This needs a probability distribution, might need a small review too.

### IFEO injection

*Similar to Process Injection*, these values may be abused to obtain persistence and privilege escalation by causing a malicious executable to be loaded and run in the context of separate processes on the computer. Installing IFEO mechanisms may also provide Persistence via continuous invocation.

Malware may also use IFEO for Defense Evasion by registering invalid debuggers that redirect and effectively disable various system and security applications.

This type of attack technique cannot be easily mitigated with preventive controls since it is based on the abuse of system features.

This needs a probability distribution.

This is the third technique I believe that is "similar to process injection". Maybe we could assume that all those techniques have the same probability (at least as a first approximation).

### Launch Daemon

Adversaries may install a new launch daemon that can be configured to execute at startup by using launchd or launchctl to load a plist into the appropriate directories. The daemon name may be disguised by using a name from a related operating system or benign software. Launch Daemons may be created with administrator privileges, but are executed under root privileges, so an adversary may also use a service to escalate privileges from administrator to root.

The plist file permissions must be root:wheel, but the script or program that it points to has no such requirement. So, it is possible for poor configurations to allow an adversary to modify a current Launch Daemon’s executable and gain persistence or Privilege Escalation.

This should have a TTC (persistence) and prevalence (rather low according to the MITRE description)

REVIEW link with lanchd and launchctl

### New Service  

Masquerading might be a parent rather than a child. serviceExecution might be a child rather than a parent.

This needs a probability distribution.

Link with Launch Daemon and Launch ctl? (CAPEC)

### Parent PID spoofing 

This type of attack technique cannot be easily mitigated with preventive controls since it is based on the abuse of system features.

Adversaries may abuse these mechanisms to evade defenses, such as those blocking processes spawning directly from Office documents, and analysis targeting unusual/potentially malicious parent-child process relationships, such as spoofing the PPID of PowerShell/Rundll32 to be explorer.exe rather than an Office document delivered as part of Spearphishing Attachment. *This spoofing could be executed via VBA Scripting within a malicious Office document or any code that can perform Execution through API.*

Explicitly assigning the PPID may also enable Privilege Escalation (given appropriate access rights to the parent process). For example, an adversary in a privileged user context (i.e. administrator) may spawn a new process and assign the parent as a process running as SYSTEM (such as lsass.exe), causing the new process to be elevated via the inherited access token.

This needs REVIEW.

### Path interception

Probability found by Love 

Looking at the children and the technique in the MITRE framework, this specific technique might not need a probability since it can be split into the 3 children. The children should rather have a probability. (Love found one for DLL Search Order Hijacking already)

These techniques can be used for persistence, REVIEW them to check they actually do in the code.

### Plist Modification

This needs a probability distribution, the probability that a simple user has write access to the plist.

### Port Monitors

This type of attack technique cannot be easily mitigated with preventive controls since it is based on the abuse of system features.

An arbitrary DLL can be loaded if permissions allow writing a fully-qualified pathname for that DLL to HKLM\SYSTEM\CurrentControlSet\Control\Print\Monitors

Setting up the port monitor to execute the chosen DLL at startup doesn't seem to take much time https://docs.microsoft.com/fr-fr/windows/win32/printdocs/addmonitor?redirectedfrom=MSDN.

This needs a probability distribution, the probability that the permissions will allow writing a fully-qualified pathname for that DLL to HKLM\SYSTEM\CurrentControlSet\Control\Print\Monitors. 

### PowerShell Profile

An administrator can also configure a profile that applies to all users and host programs on the local compute

Adversaries may modify these profiles to include arbitrary commands, functions, modules, and/or PowerShell drives to gain persistence. Every time a user opens a PowerShell session the modified script will be executed unless the -NoProfile flag is used when it is launched. 

An adversary may also be able to escalate privileges if a script in a PowerShell profile is loaded and executed by an account with higher privileges, such as a domain administrator.

This needs both a time distribution and a probability distribution. The time one will be based on the frequency of profile loading and the probability will be based on the probability that the profile will be loaded by an admin. (Maybe we can neglect the probability that the -NoProfile flag will be used)

This one might actually be a bit tricky, because the exploit for persistence only requires a user level account but the exploit for privilege escalation requires an admin level account. 

### Process injection

Probability found by Love 

Note : Privilege Account Management is a mitigation but isn't in the code whereas execution Prevention isn't listed in the Mitre framework but is in the code.

### Scheduled Task

Probability found by Love

Note: Admin Rights are required for remote execution via Scheduled Tasks.

### Service Registry Permission Weakness

If the permissions for users and groups are not properly set and allow access to the Registry keys for a service, then adversaries can change the service binPath/ImagePath to point to a different executable under their control. When the service starts or is restarted, then the adversary-controlled program will execute, allowing the adversary to gain persistence and/or privilege escalation to the account context the service is set to execute under (local/domain account, SYSTEM, LocalService, or NetworkService).

Adversaries may also alter Registry keys associated with service failure parameters (such as FailureCommand) that may be executed in an elevated context anytime the service fails or is intentionally corrupted.

With proper Registry Permissions, this attack can be blocked. 

This needs a probability distribution or at least the Restrict Registry Permissions needs one.

We could assess this probability distribution to be binary if we find one for thee mitigation.

Note: The mitigation isn't named as it is in the MITRE framework, I don't know if it's a different one or if it was just renamed. This needs a short review.

In the code, this attack step is *split into 2*, on part for persistence, the other for privilege escalation, which is a good thing to do for other attack steps that work similarly and might have a different succes rate for privilege escalation and persistence.

### Setuid & Setgid

An adversary can take advantage of this to either do a shell escape or exploit a vulnerability in an application with the setsuid or setgid bits to get code running in a different user’s context. Additionally, adversaries can use this mechanism on their own malware to make sure they're able to execute in elevated contexts in the future.

With proper OS Configuration, this attack can be blocked.

We could assess this probability distribution to be binary if we find one for the mitigation.

### SID-History Injection

Adversaries may use this mechanism for privilege escalation. With Domain Administrator (or equivalent) rights, harvested or well-known SID values may be inserted into SID-History to enable impersonation of arbitrary users/groups such as Enterprise Administrators. This manipulation may result in elevated access to local resources and/or access to otherwise inaccessible domains via lateral movement techniques such as Remote Services, Windows Admin Shares, or Windows Remote Management.

SID Filtering via Active Directory Configuration may entirely block this attack.

We could assess this probability distribution to be binary if we find one for the mitigation.

Note : This isn't the first technique that seems to be used for Lateral Movement too but isn't listed in the Lateral Movement Tactic.

### Startup Items

An adversary can create the appropriate folders/files in the StartupItems directory to register their own persistence mechanism. Additionally, since StartupItems run during the bootup phase of macOS, they will run as root. If an adversary is able to modify an existing Startup Item, then they will be able to Privilege Escalate as well.

There are 2 points here :
Creating the files only requires writing permissions to the directory and gives persistence to the adversary.
If the adversary has permission to modify existing files in this directory, they might then get privilege escaltion.

This needs a probability distribution.

### Sudo 

Adversaries can take advantage of these configurations to execute commands as other users or spawn processes with higher privileges. You must have elevated privileges to edit this file though.

With proper management, this attack can be blocked.

We could assess this probability distribution to be binary if we find one for the mitigations.

Many exploits of commands that can be executed via sudo can be found and performed in no time.

### Sudo Caching 

Adversaries can abuse poor configurations of this to escalate privileges without needing the user's password. /var/db/sudo's timestamp can be monitored to see if it falls within the timestamp_timeout range. If it does, then malware can execute sudo commands without needing to supply the user's password. When tty_tickets is disabled, adversaries can do this from any tty for that user.

The OSX Proton Malware has disabled tty_tickets to potentially make scripting easier by issuing echo \'Defaults !tty_tickets\' >> /etc/sudoers [2]. In order for this change to be reflected, the Proton malware also must issue killall Terminal. As of macOS Sierra, the sudoers file has tty_tickets enabled by default.

This needs a probability distribution, the probability that the configuration is so bad that you'll not need to enter user password to execute sudo commands. This might also need a TTC, time before the user actually uses sudo and, if the timeout isn't 0 you may use the given timeout to execute commands as root.

### Valid Accounts

This has already been assessed as binary. once the adversary has valid account use them with no restriction.

Note: There currently is no distinction between valid user/admin/system account.

Note 2 : Some of the mitigations listed in the MITRE framework only aim at mitigating further steps that could be performed by an adversary who has valid credentials

### Web Shell

A Web shell is a Web script that is placed on an openly accessible Web server to allow an adversary to use the Web server as a gateway into a network. A Web shell may provide a set of functions to execute or a command-line interface on the system that hosts the Web server. In addition to a server-side script, a Web shell may have a client interface program that is used to talk to the Web server (see, for example, China Chopper Web shell client). [1]

Web shells may serve as Redundant Access or as a persistence mechanism in case an adversary's primary access methods are detected and removed.

Note: There is no sign that this technique can be used for privilege Escalation.

This needs a probability distribution and further investigation.