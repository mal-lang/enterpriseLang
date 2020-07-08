# [Modify Registry](https://attack.mitre.org/techniques/T1112/)

## Context
Adversaries may interact with the Windows Registry to hide configuration information within Registry keys, remove information as part of cleaning up, or as part of other techniques to aid in Persistence and Execution.

## Findings
In the [mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) from FireEye, they report that the attack "modify registry' is part of 6.61% of all attack lifecycles, while in the [SoK: ATT&CK Techniques and Trends in
Windows Malware](https://krisk.io/post/sok-attack-securecomm19.pdf) they find that out of 951 malware samples, modfiy registry was found in 50 samples, which corresponds to ~5.26%. 

Curiously, another source, [A View on Current Malware Behaviors](https://www.usenix.org/legacyurl/view-current-malware-behaviors), finds that 74.59% of all malware samples they analyzed "modified a registry value". This large difference in prevalence might be explained by the difference in time of publishing, "A view on current malware behaviours" was published in 2009. 

To disregard the huge disrepancy in value in the data I found, I will use the median of these values. median(5.26, 6.61, 74.59) = 6.61. 

## Time to compormise
The utility [Reg](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2012-R2-and-2012/cc732643(v=ws.11)?redirectedfrom=MSDN) is a built in tool in windows that can modify registry values. Usage example: 
```
REG ADD HKLM\Software\MyCo /v Data /t REG_BINARY /d fe340ead
```
Since this attack seems to only include a few lines of code when it comes to modifying some regisitries, I will assume the time is instant. 

## Results
```Bernoulli(0.0661)```. 

## Discussion 
the huge disrepancy in value in the findings should probably be investigated further. Either this is a very common technique, as the third source would indicate, or low-medium in how common it is. At the moment I am unable to find more sources providing proof though. 