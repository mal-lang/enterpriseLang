# [Indicator Removal On Host](https://attack.mitre.org/techniques/T1070/)

## Context
>Adversaries may delete or alter generated artifacts on a host system, including logs or captured files such as quarantined malware. Locations and format of logs are platform or product-specific, however standard operating system logs are captured as Windows events or Linux/macOS files such as Bash History and /var/log/*.

## Findings
In the Red Canary top 50 ATT&CK techniques (private google sheets document), they find that this attack step is part of 0.73% of all threat volume.

In [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/), they find that this attack step is foudn in  8 out of 951 malware samples. This is ~0.84%. 

In ["A 2019 Mid-Year Review From the CrowdStrike Falcon OverWatch Team"](https://www.crowdstrike.com/resources/reports/observations-from-the-front-lines-of-threat-hunting-2019/) "Indicator Removal On Host" has a color hue saturation of 33% (in the chart "OBSERVATIONS FROM THE FRONT LINES OF THREAT HUNTING" on the last page), and the most commonly observed technique ("Command Line Interface") was observed 52 times, and has a hue saturation of 85%. We previously found that "command line interface" had a prevalence of 24%. 33/85 = ~38.8%, so to extrapolate from this, 0.388*0.24 ~= 0.09312, or 9.312%.   

In the [FireEye 2020 Mtrends report](https://content.fireeye.com/m-trends/rpt-m-trends-2020), they find that this attack step is included in 5.29% of all attack lifecycles.

Taking the average of these yields (0.73 + 0.84 + 9.312 + 5.29) / 4 = ~4%

This is ```Bernoulli(0.04)```. 

## Time to compromise
In an example, the malware [RTM](https://www.welivesecurity.com/wp-content/uploads/2017/02/Read-The-Manual.pdf) can:

>clean all the files and the registry entries created during the execution of RTM on the victim’s machine

Similarly, [Leviathan](https://www.proofpoint.com/us/threat-insight/post/leviathan-espionage-actor-spearphishes-maritime-and-defense-targets) can do:

>Overwriting registry settings to reduce malware visibility on system

It's not clear exactly how long this would take, but assuming it's just deleting registry keys, I don't see how this would take longer than a few seconds at most. I'm estimating instant TTC.

## Result
```Bernoulli(0.04)```. 
