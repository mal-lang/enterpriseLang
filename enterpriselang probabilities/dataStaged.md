# [Data Staged](https://attack.mitre.org/techniques/T1074/)

## Context
>Adversaries may stage collected data in a central location or directory prior to Exfiltration. Data may be kept in separate files or combined into one file through techniques such as [Archive Collected Data](https://attack.mitre.org/techniques/T1560/). Interactive command shells may be used, and common functionality within [cmd](https://attack.mitre.org/software/S0106/) and bash may be used to copy data into a staging location.

## Findings
In the Red Canary top 50 att&ck techniques (private google sheets document) they find that this attack technique accounts for 1.21% of all threat volume. 

In [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/), they find that this technique occured in 8 malware samples out of 951 total. This is ~0.84%. 

The average of these findings is (1.21 + 0.84) / 2 = 1.025%

## Time to compromise
Due to the fact that there is "common functionality within cmd and bash may be used to copy data into a staging location", I'm assuming that this attack step can be accomplished with a few commands, and perhaps can be estimated as instantaneous. In any case I'm not able to find information supporting any actualy time, so I assume instant.

## Result
```Bernoulli(0.01025)```. 