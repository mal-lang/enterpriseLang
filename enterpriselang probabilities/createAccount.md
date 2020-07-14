# [Create Account](https://attack.mitre.org/techniques/T1136/)

## Context
>Adversaries may create an account to maintain access to victim systems. With a sufficient level of access, creating such accounts may be used to establish secondary credentialed access that do not require persistent remote access tools to be deployed on the system.

>Accounts may be created on the local system or within a domain or cloud tenant. In cloud environments, adversaries may create accounts that only have access to specific services, which can reduce the chance of detection.

## Findings
In the [FireEye Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that creating accounts is part of 4.85% of all attack lifecycles. 

In the [2018 Mid-Year Review From the CrowdStrike Falcon OverWatch Team](https://www.crowdstrike.com/resources/reports/observations-from-the-front-lines-of-threat-hunting/) they provide a version of the att&ck matrix with prevalence filled in. Unfortunately percentages are not provided, but with the information that the most prevalent threat was "Command Line Interface" which occured 52 times, and a [color picker](https://annystudio.com/software/colorpicker/#download) tool, that finds that the saturation for "Command Line Interface" was 85%, while the saturation for "Create Account" was 23%. 23/85=27%, so "create account" occured 27% as often as "Command Line Interface" did. In previous findings in enterpriselang.mal, we found that the prevalence of Command Line Interface was 24%, so 0.24*0.27 = 6.48%. 

Taking the average of these two, we get (4.85 + 6.48)/2 = 5.665%. -> ```Bernoulli(0.05665)```. 

## Time to compromise
On windows, By following the instructions [here](https://support.microsoft.com/en-us/help/4026923/windows-10-create-a-local-user-or-administrator-account) you can create an account in just under a minute if you're quick. 

On linux (Ubuntu 18.04 to be specific), [this tutorial](https://www.youtube.com/watch?v=Ym0JJ5NGdrA) takes just about a minute to create a new user account. 

On [Mac OS](https://www.youtube.com/watch?v=SRqxIb_ETEQ) it also seems to take about 1 minute. 

In the end I will estimate it takes 1 minute which is ```Exponential(1440)```. 

## Result
```Bernoulli(0.05665)*Exponential(1440)```
