# [Windows Management Instrumentation (WMI)](https://attack.mitre.org/techniques/T1047/)
"Windows Management Instrumentation (WMI) is a Windows administration feature that provides a uniform environment for local and remote access to Windows system components. It relies on the WMI service for local and remote access and the server message block (SMB) and Remote Procedure Call Service (RPCS) for remote access. RPCS operates over port 135."

## Prevalence
According to [Red Canary's Threat Detection Report 2020](https://redcanary.com/threat-detection-report/techniques/windows-management-instrumentation/), 26% of organizations are affected. -> ```Bernoulli(0.26)```.

## Time to compromise
There are lots of different threats making use of this technique. 

One example of malware using WMI is SEADADDY, outlined in an example in a [report from FireEye in 2015](https://www.fireeye.com/content/dam/fireeye-www/global/en/current-threats/pdfs/wp-windows-management-instrumentation.pdf) mentions that this particular type of malware is set to trigger between 200 and 320 seconds after system startup, or 260 seconds on average. (4.333 minutes)

NotPetya: According to [microsoft](https://www.microsoft.com/security/blog/2017/06/27/new-ransomware-old-techniques-petya-adds-worm-capabilities/), this malware apparently schedules a shutdown after 10-60 minutes, so I am assuming that before then, the attack using WMI is carried out. The average of this is 35 minutes. 

Olympic Destroyer also used WMI in their attacks. [Securelist.com](https://securelist.com/olympicdestroyer-is-here-to-trick-the-industry/84295/) states that once it has "run for 60 minutes it cleans Windows event logs, resets backups, deletes shadow copies from the file system, disables the recovery item in the Windows boot menu, disables all the services on the system and reboots the computer". So the TTC regarding WMI is at most 60 minutes in this case. 

Using an average of these grants us a TTC of (4.33 + 35 + 60)/3 = 33.11 minutes, or ~43.49 times per day -> ```Exponential(43.49)```. Note that this is an upper bound, and the likely time to carry out this attack step is probably a lot lower. 

## Result
The end result for the probability distribution is ```Bernoulli(0.26)*Exponential(43.49)```.

## Discussion
The actual TTC is probably a lot lower - this text assumes an upper bound of the TTC. 