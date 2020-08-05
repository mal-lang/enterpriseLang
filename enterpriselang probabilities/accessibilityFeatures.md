# Accessibility Features

## Context (https://attack.mitre.org/techniques/T1015/)

Windows contains accessibility features that may be launched with a key combination before a user has logged in (for example, when the user is on the Windows logon screen). An adversary can modify the way these programs are launched to get a command prompt or backdoor without logging in to the system.

Two common accessibility programs are C:\Windows\System32\sethc.exe, launched when the shift key is pressed five times and C:\Windows\System32\utilman.exe, launched when the Windows + U key combination is pressed. The sethc.exe program is often referred to as "sticky keys", and has been used by adversaries for unauthenticated access through a remote desktop login screen. 

*Depending on the version of Windows*, an adversary may take advantage of these features in different ways because of code integrity enhancements. In newer versions of Windows, the replaced binary needs to be digitally signed for x64 systems, the binary must reside in %systemdir%\, and it must be protected by Windows File or Resource Protection (WFP/WRP). The debugger method was likely discovered as a potential workaround because it does not require the corresponding accessibility feature binary to be replaced. Examples for both methods:

For simple *binary replacement on Windows XP and later as well as and Windows Server 2003/R2 and later*, for example, the program (e.g., C:\Windows\System32\utilman.exe) may be replaced with "cmd.exe" (or another program that provides backdoor access). Subsequently, pressing the appropriate key combination at the login screen while sitting at the keyboard or when connected over Remote Desktop Protocol will cause the replaced file to be executed with *LOCAL_SYSTEM privileges*.

For the *debugger method on Windows Vista and later as well as Windows Server 2008 and later*, for example, a Registry key may be modified that configures "cmd.exe," or another program that provides backdoor access, as a "debugger" for the accessibility program (e.g., "utilman.exe"). After the Registry is modified, pressing the appropriate key combination at the login screen while at the keyboard or when connected with RDP will cause the "debugger" program to be executed with *LOCAL_SYSTEM privileges*.

Other accessibility features exist that may also be leveraged in a similar fashion: 

- On-Screen Keyboard: C:\Windows\System32\osk.exe
- Magnifier: C:\Windows\System32\Magnify.exe
- Narrator: C:\Windows\System32\Narrator.exe
- Display Switcher: C:\Windows\System32\DisplaySwitch.exe
- App Switcher: C:\Windows\System32\AtBroker.exe

## Relevant findings

The different features can be leveraged for privileged escalation in different ways. Based on the examples listed in the MITRE framework (https://attack.mitre.org/techniques/T1015/), the most commonly used one is the "Sticky Keys" (sethc.exe) followed by utilman.exe and magnify.exe. There are many ways of replacing 

This report (https://www.spiceworks.com/marketing/network-security/pdf-report/) suggests that 32% of companies still used Windows XP on at least one device in 2019. No earlier version is mentioned so we assume that all companies use Windows XP or later. We can thus assume that all companies are vulnerable to this attack.

https://www.crowdstrike.com/blog/registry-analysis-with-crowdresponse/
According to the examples given in the MITRE framework, the attacks can be performed really quickly so we'll assume the TTC to be instantaneous.

## Results

We assess the probability distribution for this technique to be binary. 
## Discussion

I didn't dig deep into each method and each Windows version, and considering how frequently and easily this technique is used, I am surprised that there is no fix in later versions (as suggested by the MITRE framework). I couldn't find anything suggesting a fix in later Windows versions however.

