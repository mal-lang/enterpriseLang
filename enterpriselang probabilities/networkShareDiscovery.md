# [Network Share Discovert](https://attack.mitre.org/techniques/T1135/)

## Context
> Adversaries may look for folders and drives shared on remote systems as a means of identifying sources of information to gather as a precursor for Collection and to identify potential systems of interest for Lateral Movement. Networks often contain shared network drives and folders that enable users to access file directories on various systems across a network. 

## Findings
The [FireEye M-trends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) lists Network Share Discovery as occuring in 1.32% of all attack lifecycles. 

The [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/), puts 12 samples out of 951 as using Network Share Discovery as an attack technique. This is ~1.261%. 

If we take the average of these two findings, (1.32 + 1.261) / 2 = ~1.29%. This corresponds to ```Bernoulli(0.0129)```. 

## Time to comproise
According to the MITRE ATT&CK page, this attack step can be carried out by doing the following: 
>[Net](https://attack.mitre.org/software/S0039/) can be used to query a remote system for available shared drives using the `net view \remotesystem `command. It can also be used to query shared drives on the local system using `net share`. Since this attack step can be accomplished by simply typing some queries into a command line using a built in utility, I will assume the TTC is instant.


## Results
```Bernoulli(0.0129)```