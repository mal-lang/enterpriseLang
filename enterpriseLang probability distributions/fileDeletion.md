# [File Deletion](https://attack.mitre.org/techniques/T1107/)

## Context
>Malware, tools, or other non-native files dropped or created on a system by an adversary may leave traces behind as to what was done within a network and how. Adversaries may remove these files over the course of an intrusion to keep their footprint low or remove them at the end as part of the post-intrusion cleanup process.

## Findings
In a report called [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/post/sok-attack-securecomm19.pdf), they examined 951 malware families, and found that file deletion occurs in 135 samples. -> ~14.19%.

In [FireEye's M-Trends 2020](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) they find that file deletion is exhibited in 10.57% of all malware. 

If we find the average time between these two sources, we get (14.19 + 10.57) / 2 = 12.38. -> ```Bernoulli(0.1238)```.

## Time to compromise
I tried to delete a several gigabytes large file (5GB) with the windows utility [SDelete](https://docs.microsoft.com/en-us/sysinternals/downloads/sdelete), and it took less than 1 second. I think we can safely assume this attack step to be instant. 

## Result
```Bernoulli(0.1238)```