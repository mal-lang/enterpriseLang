# [Query Registry](https://attack.mitre.org/techniques/T1012/)

## Context
>Adversaries may interact with the Windows Registry to gather information about the system, configuration, and installed software.

## Findings
In the [FireEye 2020 mtrends report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that 3.96% of attack lifecycles include this attack step. 


In ["A 2019 Mid-Year Review From the CrowdStrike Falcon OverWatch Team"](https://www.crowdstrike.com/resources/reports/observations-from-the-front-lines-of-threat-hunting-2019/) has a color hue saturation of 23% (in the chart "OBSERVATIONS FROM THE FRONT LINES OF THREAT HUNTING" on the last page), and the most commonly observed technique ("Command Line Interface") was observed 52 times, and has a hue saturation of 85%. We previously found that "command line interface" had a prevalence of 24%. 23/85 = ~27,05%, so to extrapolate from this, 0.2705*0.24 ~=6.492%. 

The average prevalence is (3.96 + 6.492) / 2

## Time to compromise
On the MITRE ATT&CK page, they state that "Information can easily be queried using the [Reg](https://attack.mitre.org/software/S0075/) utility". An example of how this can be used can be seen below: 
```
REG QUERY HKLM\Software\Microsoft\ResKit /v Version
```
This will display the value of the name value Version in the `HKLM\Software\Microsoft\ResKit` key. ([source](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-server-2012-R2-and-2012/cc742028(v=ws.11)))

Another example is [COMRAT, which according to welivesecurity](https://www.welivesecurity.com/wp-content/uploads/2020/05/ESET_Turla_ComRAT.pdf), can check for a default browser by checking
```
HKCR\http\shell\open\command
``` 
These findings seem to indicate that this attack step is near instantaneous, since it seems to only include simple registry queries from a command line shell. As such I assume instant TTC.

## Result
```Bernoulli(0.05226)```.