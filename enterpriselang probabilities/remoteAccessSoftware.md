# [Remote Access Software](https://attack.mitre.org/techniques/T1219/)

## Context
>An adversary may use legitimate desktop support and remote access software, such as Team Viewer, Go2Assist, LogMein, AmmyyAdmin, etc, to establish an interactive command and control channel to target systems within networks. These services are commonly used as legitimate technical support software, and may be allowed by application control within a target environment. Remote access tools like VNC, Ammyy, and Teamviewer are used frequently when compared with other legitimate software commonly used by adversaries.

## Findings
In the [FireEye 2020 M-trends report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that remote access tools/software are used in 2.2% of all attack lifecycles. 

In the [2018 Mid-Year Review From the CrowdStrike Falcon OverWatch Team](https://www.crowdstrike.com/resources/reports/observations-from-the-front-lines-of-threat-hunting/) they provide a version of the att&ck matrix with prevalence filled in. Unfortunately percentages are not provided, but with the information that the most prevalent threat was "Command Line Interface" which occured 52 times, and a [color picker](https://annystudio.com/software/colorpicker/#download) tool, that finds that the saturation for "Command Line Interface" was 85%, while the saturation for "Remote Access Tools" was 23%. 23/85=27%, so "Remote Access Tools" occured 27% as often as "Command Line Interface" did. In previous findings in enterpriselang.mal, we found that the prevalence of Command Line Interface was 24%, so 0.24*0.27 = 6.48%. 

A type of remote access tool/software is a remote access trojan (RAT). [One study from proofpoint](https://www.proofpoint.com/us/threat-insight/post/proofpoint-q3-2019-threat-report-emotets-return-rats-reign-supreme-and-more) finds that RATs consisted of 15% of all malicious payloads in Q3 2019. 

If we find the average of these 3 findings, we get (2.2 + 6.48 + 15) / 3 = ~7.89%. -> ```Bernoulli(0.0789)```. 

## Time to compromise
In [this](https://www.youtube.com/watch?v=RzVtc9i3mzs) video tutorial, the remote access trojan tool njRAT is set up and used. It's 11 minutes long. [Another](https://www.youtube.com/watch?v=om3OJWpZDGU) video tutorial sets up a RAT on an android device, taking 16 minutes. My estimated average time to compromise: 13.5 minutes. -> ```Exponential(106.67)```. 

## Results
```Bernoulli(0.0789)*Exponential(106.67)```


## Unused but perhaps interesting findings
In a [2016 report from Deloitte](https://www2.deloitte.com/content/dam/Deloitte/nl/Documents/risk/deloitte-nl-risk-trustwave-global-security-report.pdf) they find that out of all factors that contribute to a compromise, Insecure remote access software and policies was the most common at 13 percent. 