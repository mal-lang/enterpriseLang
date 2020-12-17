# [Remote Services](https://attack.mitre.org/techniques/T1021/)

## Context
>Adversaries may use Valid Accounts to log into a service specifically designed to accept remote connections, such as telnet, SSH, and VNC. The adversary may then perform actions as the logged-on user.

This technique has 6 sub techniques:

* [Remote Desktop Protocol](https://attack.mitre.org/techniques/T1021/001/)
* [SMB/Windows Admin Shares](https://attack.mitre.org/techniques/T1021/002/)
* [Distributed Component Model](https://attack.mitre.org/techniques/T1021/003/)
* [SSH](https://attack.mitre.org/techniques/T1021/004/)
* [VNC](https://attack.mitre.org/techniques/T1021/005/)
* [Windows Remote Management](https://attack.mitre.org/techniques/T1021/006/)


## Findings
In the [FireEye Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that this attack step is included in 2.2% of all attack lifecycles. 

In ["A 2019 Mid-Year Review From the CrowdStrike Falcon OverWatch Team"](https://www.crowdstrike.com/resources/reports/observations-from-the-front-lines-of-threat-hunting-2019/) Remote Services has a color hue saturation of 23% (in the chart "OBSERVATIONS FROM THE FRONT LINES OF THREAT HUNTING" on the last page), and the most commonly observed technique ("Command Line Interface") was observed 52 times, and has a hue saturation of 85%. We previously found that "command line interface" had a prevalence of 24%. 23/85 = ~27,05%, so to extrapolate from this, 0.2705*0.24 ~=6.492%. 

The average of these findings (2.2 + 6.492) / 2 = 4.346%. 

## Time to compromise
Since this technique has 6 sub-techniques, it might be better to have the TTC on those techniques since they might be different between each other. As such, I will leave out a TTC estimate on this attack technique. 

## Result
```Bernoulli(0.04346)```. 