# [Shortcut Modification](https://attack.mitre.org/techniques/T1547/009/)

## Context
>Adversaries may create or edit shortcuts to run a program during system boot or user login. Shortcuts or symbolic links are ways of referencing other files or programs that will be opened or executed when the shortcut is clicked or executed by a system startup process.

>Adversaries could use shortcuts to execute their tools for persistence. They may create a new shortcut as a means of indirection that may use Masquerading to look like a legitimate program. Adversaries could also edit the target path or entirely replace an existing shortcut so their tools will be executed instead of the intended legitimate program.

## Findings
In the [FireEye Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), shortcut modification is said to occur in 0.44% of all attack lifecycles. 

In the [2018 Mid-Year Review From the CrowdStrike Falcon OverWatch Team](https://www.crowdstrike.com/resources/reports/observations-from-the-front-lines-of-threat-hunting/) they provide a version of the att&ck matrix with prevalence filled in. Unfortunately percentages are not provided, but with the information that the most prevalent threat was "Command Line Interface" which occured 52 times, and a [color picker](https://annystudio.com/software/colorpicker/#download) tool, that finds that the saturation for "Command Line Interface" was 85%, while the saturation for "Shortcut Modification" was 13%. 13/85= ~15.3%, so "Shortcut Modification" occured 13% as often as "Command Line Interface" did. In previous findings in enterpriselang.mal, we found that the prevalence of Command Line Interface was 24%, so 0.13*0.27 = 3.51%. 

On windows, shortcuts are in the form of [.LNK](https://fileinfo.com/extension/lnk) files. A report from [Kaspersky in 2017](https://ics-cert.kaspersky.com/reports/2019/09/30/threat-landscape-for-industrial-automation-systems-h1-2019/) finds that out of all malicious objects blocked, 5.16% were malicious .LNK files. 

The average of these three findings is (0.44 + 3.51 + 5.16) / 3 = ~3%. -> ```Bernoulli(0.03)```

## Time to compromise
A piece of malware dubbed [GreyEnergy](https://www.welivesecurity.com/wp-content/uploads/2018/10/ESET_GreyEnergy.pdf) by ESET uses a .LNK file like this: "the dropper creates a .LNK file, using a blank filename, in the Startup folder in the Start Menu with an entry that executes rundll32.exe with the path to [a malicious DLL] as a command line argument". Just creating a tiny file seems like it would be very quick. 

Another operation called cloud hopper, investigated [here](https://www.pwc.co.uk/cyber-security/pdf/cloud-hopper-annex-b-final.pdf) by pwc.co.uk, where a .LNK file is used to contain a shell script which sends a request to download another script. This too seems like a quick process... 

Based on this, I will assume the TTC is instant. 

## Result
```Bernoulli(0.03)```