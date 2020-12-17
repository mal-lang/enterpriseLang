# [Execution Through API](https://attack.mitre.org/techniques/T1106/)

## Context
>Adversary tools may directly use the Windows application programming interface (API) to execute binaries. Functions such as the Windows API CreateProcess will allow programs and scripts to start other processes with proper path and argument parameters. 

## Findings
In [this](https://krisk.io/post/sok-attack-securecomm19.pdf) article on ATT&CK Techniques and Trends in Windows Malware, with a sample size of 951 the authors find that 562 samples use some kind of execution through API. This corresponds to ~59.1%. 

Another study published by Recorded Future called [MITRE Attack Tactics](https://www.recordedfuture.com/mitre-attack-tactics/) in 2019, they found that the volume of threats associated with security software discovery was 13,805 out of 26,057 total. This corresponds to ~52.9%. 

If we find the average of these two, (59.1 + 52.9) / 2 = 56, we can estimate that the prevalence of malware using this attack step is 56%, or ```Bernoulli(0.56)```. 

## Time to compromise
The MITRE ATT&CK page lists several different Windows native API calls that can be used to execute binaries, these include: 
*   CreateProcessA() and CreateProcessW(),
*   CreateProcessAsUserA() and CreateProcessAsUserW(),
*   LoadLibraryExA() and LoadLibraryExW(),
*   LoadModule(),
*   LoadPackagedLibrary(),
*   WinExec(),
*   ShellExecuteA() and ShellExecuteW(),
*   ShellExecuteExA() and ShellExecuteExW()

It seems this attack step is just about calling various windows API functions, as such I will estimate that the Time to compromise to be instant. 

## Result
```Bernoulli(0.56)```. 