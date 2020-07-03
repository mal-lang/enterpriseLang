# [Credential Dumping](https://attack.mitre.org/techniques/T1003/)

## context
>Credential dumping is the process of obtaining account login and password information, normally in the form of a hash or a clear text password, from the operating system and software. Credentials can then be used to perform Lateral Movement and access restricted information.

## Findings
Picus security lists ["the top 10 MITRE attack techniques"](https://www.picussecurity.com/picus-10-critical-mitre-attck-techniques), where they find that this technique is in use by 15% of all malware. 

[FireEyes 2020 M-Trends](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) finds that 9.25% of all malware attack lifecycles make use of this technique. 

In a report called [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/post/sok-attack-securecomm19.pdf), they examined 951 malware families, and found Credential Dumping to be a part of 56 malware families, which is ~5.89%. 

Red Canary's [2020 threat detection report](https://redcanary.com/threat-detection-report/techniques/credential-dumping/) finds that credential dumping is included in 5% of all threat volume. 

I will use the average of all of these values to find how prevalent credential dumping is. (15 + 9.25 + 5.89 + 5) / 4 = 8.785. 

## Time to compromise
One tool well known to be able to do credential dumping is [mimikatz](https://github.com/gentilkiwi/mimikatz). For me, downloading and running some of the example commands took less than a minute. Running the actual commands took just a split second. As such I will assume instant time to compromise. 

## Result
```Bernoulli(0.08785)```