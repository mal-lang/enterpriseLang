# [NTFS File Attributes ](https://attack.mitre.org/techniques/T1564/004/)

## Context
>Adversaries may use NTFS file attributes to hide their malicious data in order to evade detection. Every New Technology File System (NTFS) formatted partition contains a Master File Table (MFT) that maintains a record for every file/directory on the partition. Within MFT entries are file attributes, such as Extended Attributes (EA) and Data [known as Alternate Data Streams (ADSs) when more than one Data attribute is present], that can be used to store arbitrary data (and even complete files). 

## Findings
The Red Canary ATT&CK technique percentages (private google sheets document) finds that this attack technique makes up 0.49% of threat volume. 

In the [FireEye Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) they find that this attack step is included in 0.88% of attack lifecycles. 

In [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/), they find that this technique is exhibited in 7 out of 951 malware samples. This is ~0.736%. 

Taking the average of all of these findings, we get (0.49 + 0.88 + 0.736) / 3 = 0.702%. 

## Time to compromise
As an example, [APT32](https://cdn2.hubspot.net/hubfs/3354902/Cybereason%20Labs%20Analysis%20Operation%20Cobalt%20Kitty.pdf) used NTFS Alternate Data streams to hide their payloads. As far as I understand, this hiding is typically done before an attack begins and is retrieved from here once the attack is in session. As such I assume an instant TTC. Another malware that hides some payloads this way is [PowerDuke](https://www.volexity.com/blog/2016/11/09/powerduke-post-election-spear-phishing-campaigns-targeting-think-tanks-and-ngos/)

## Result
```Bernoulli(0.00702)```. 