# [Permission Groups Discovery](https://attack.mitre.org/techniques/T1069/)

## Context
>Adversaries may attempt to find local system or domain-level groups and permissions settings. 

## Findings
Red Canary ATT&CK technique percentages (Top 50) finds that 7% of their customers are affected by this attack step. [FireEyes M-Trends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) finds that 3.52% of attack lifecycles use this step. I will use the average of these two to find the prevalence of this attack step. (7 + 3.52) / 2 = 5.26%. -> ```Bernoulli(0.0526)```. 

## Time to compromise
All this step requires is to [type the following commands](https://attack.mitre.org/techniques/T1069/):
### Windows
```net group /domain``` or ```net localgroup``` for example
### Linux
```groups``` for local groups, ```ldapsearch``` for domain groups
### Mac
```dscacheutil -q group ``` for domain, ```dscl . -list /Groups``` for local groups
### Office 365 and Azure AD
```Get-MsolRole``` obtain roles and permission groups

From this I will estimate that the total TTC for this attack step, is the time it would take an attacker to type any of these commands, so at most a few seconds, which I will estimate as instant. 

## Result
```Bernoulli(0.0526)```