# Port Monitors 

## Context https://attack.mitre.org/techniques/T1547/010/

Adversaries may use port monitors to run an attacker supplied DLL during system boot for persistence or privilege escalation. A port monitor can be set through the AddMonitor API call to set a DLL to be loaded at startup. This DLL can be located in C:\Windows\System32 and will be loaded by the print spooler service, spoolsv.exe, on boot. The spoolsv.exe process also runs under SYSTEM level permissions.  Alternatively, an arbitrary DLL can be loaded if permissions allow writing a fully-qualified pathname for that DLL to HKLM\SYSTEM\CurrentControlSet\Control\Print\Monitors.

The Registry key contains entries for the following:

- Local Port
- Standard TCP/IP Port
- USB Monitor
- WSD Port

Adversaries can use this technique to load malicious code at startup that will persist on system reboot and execute as SYSTEM.

## Relevant findings 

http://techgenix.com/allowprintoperatorstoaddaprinter/
https://www.itprotoday.com/security/how-can-i-allow-members-printer-operators-group-add-printers
Both of these sources suggest that you need to be able to Modify File and/or Directory Permissions in order to perform this attack (being allowed to write a fully-qualified pathname for that DLL to HKLM\SYSTEM\CurrentControlSet\Control\Print\Monitors). We'll neglect the probability that a company has already by itself changed the permissions, and that it would thus be instantenous for the attacker to perform this technique.
The sources also suggest that you should restart the machine (which may take a few minutes) or alternatively the service provided you have access to a CLI. All in all we'll assume a low TTC represented by the following distribution: [Exponential(288)] (5 min average)

https://docs.microsoft.com/fr-fr/windows/win32/printdocs/addmonitor?redirectedfrom=MSDN
The time to create a monitor on the other hand seems instantenous and will be assumed as so.

## Result

We assess the probability distribution for this technique to be [Exponential(288)]

## Discussion

The TTC assumed here is arbitrary and may depend on the adversary having access or not to a CLI (it would then be much faster) and being able or not to restart the machine themselves (it would then take a bit longer). 