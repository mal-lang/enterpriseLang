# [Credentials In Registry](https://attack.mitre.org/techniques/T1552/002/)

## Context
>Adversaries may search the Registry on compromised systems for insecurely stored credentials. The Windows Registry stores configuration information that can be used by the system or other programs. Adversaries may query the Registry looking for credentials and passwords that have been stored for use by other programs or services. Sometimes these credentials are used for automatic logons.

## Findings
In the [FireEye Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) they find that this attack step is part of 0.44% of all attack lifecycles. 

In ["A 2019 Mid-Year Review From the CrowdStrike Falcon OverWatch Team"](https://www.crowdstrike.com/resources/reports/observations-from-the-front-lines-of-threat-hunting-2019/) "Credentials In Registry" has a color hue saturation of 13% (in the chart "OBSERVATIONS FROM THE FRONT LINES OF THREAT HUNTING" on the last page), and the most commonly observed technique ("Command Line Interface") was observed 52 times, and has a hue saturation of 85%. We previously found that "command line interface" had a prevalence of 24%. 13/85 = ~15,29%, so to extrapolate from this, 0.1529*0.24 ~= 0.0367, or 3.67%.   

Average of these two: (0.44 + 3.67) / 2 = 2.055%. This corresponds to ```Bernoulli(0.02055)```. 
## Time to compromise
The [MITRE ATT&CK page](https://attack.mitre.org/techniques/T1552/002/) for this attack step lists some examples of how this step can used to find registry keys related to password information:

Local Machine Hive: `reg query HKLM /f password /t REG_SZ /s`

Running the above command on my own PC with Measure-Command {} to time it, it took 63 seconds.

And

Current User Hive: `reg query HKCU /f password /t REG_SZ /s`

Running the above command on my own PC with Measure-Command {} to time it, it took 3 seconds.

Average runtime: (63+3)/2 = 33 seconds. ~> ```Exponential(2618)```. 

## Result
These findings indicate that the resulting distribution looks like this: 

```Bernoulli(0.02055)*Exponential(2618)```