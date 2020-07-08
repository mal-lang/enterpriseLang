# [System Service Discovery](https://attack.mitre.org/techniques/T1007/)

## Context
>Adversaries may try to get information about registered services. Commands that may obtain information about services using operating system utilities are "sc," "tasklist /svc" using Tasklist, and "net start" using Net, but adversaries may also use other tools as well. Adversaries may use the information from System Service Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.

## Findings
In the [FireEye 2020 Mtrends report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that 0.44% of all attack lifecycles include system service discovery. 

In [another report called "SoK: ATT&CK Techniques and Trends in Windows Malware"](https://krisk.io/publication/mitre-attack-securecomm19/), they find that 19 out of 951 malware samples use System Service Discovery. This is ~2%. 

The average of these two values is: (0.44 + 2) / 2 = 1.22%. 

## Time to compromise
According to the mitre att&ck page, this attack is based on windows system features such as `sc` and `tasklist /svc` using [tasklist](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-xp/bb491010(v=technet.10)?redirectedfrom=MSDN). Example command: 
```
tasklist /fi "USERNAME ne NT AUTHORITY\SYSTEM" /fi "STATUS eq running"
```
So since this attack step can seemingly be accoplished via single command line, I will assume that the TTC is instant. 

## Results.
```Bernoulli(0.0122)```. 