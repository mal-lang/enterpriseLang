# [System Time Discovery](https://attack.mitre.org/techniques/T1124/)

## Context
>An adversary may gather the system time and/or time zone from a local or remote system. The system time is set and stored by the Windows Time Service within a domain to maintain time synchronization between systems and services in an enterprise network.

## Findings
In the [FireEye Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that System Time Discovery as an attack step happens in 0.44% of all attack lifecycles. 

In ["A 2019 Mid-Year Review From the CrowdStrike Falcon OverWatch Team"](https://www.crowdstrike.com/resources/reports/observations-from-the-front-lines-of-threat-hunting-2019/) System Time Discovery has a color hue saturation of 23% (in the chart "OBSERVATIONS FROM THE FRONT LINES OF THREAT HUNTING" on the last page), and the most commonly observed technique ("Command Line Interface") was observed 52 times, and has a hue saturation of 85%. We previously found that "command line interface" had a prevalence of 24%. 23/85 = ~27,05%, so to extrapolate from this, 0.2705*0.24 ~=6.492%. 

In [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/), they find this attack step in 506 samples out of 951 total. This is 53.2%. 

The average of all of these (suspiciously different) values is (0.44+6.492+52.3) / 3 = 19.744. -> ```Bernoulli(0.19744)```. 

## Time to compromise
The MITRE ATT&CK page for this attack step states the following: 

>System time information may be gathered in a number of ways, such as with [Net](https://attack.mitre.org/software/S0039/) on Windows by performing `net time \hostname` to gather the system time on a remote system.

Due to the simplicity of this attack (because really, all you are doing is querying a utility with very simple commands), I will assume the TTC is instant.

## Result
```Bernoulli(0.19744)```