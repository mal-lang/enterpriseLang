# [Hidden Windows](https://attack.mitre.org/techniques/T1143/)

## Context
>Adversaries may implement hidden windows to conceal malicious activity from the plain sight of users. In some cases, windows that would typically be displayed when an application carries out an operation can be hidden. This may be utilized by system administrators to avoid disrupting user work environments when carrying out administrative tasks. Adversaries may abuse operating system functionality to hide otherwise visible windows from users so as not to alert the user to adversary activity on the system.

## Findinfs
According to vmware's Carbon Black [2020 Cyber Security Outlook Report](https://content.carbonblack.com/c/vmwcb-threat-report-?x=f_lWMB), 22% of malware exhibited the behaviour Hidden Windows. This corresponds to ```Bernoulli(0.22)```

## Time to Compromise
This behaviour is achieved very easily, in powershell to hide the windows simply use the following command: ```powershell.exe -WindowStyle Hidden```. This makes me estimate that the time to compromise is instant. 

## Result
```Bernoulli(0.22)```