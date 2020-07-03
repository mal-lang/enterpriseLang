# [DLL Side-Loading](https://attack.mitre.org/techniques/T1073/)

## Context
>Programs may specify DLLs that are loaded at runtime. Programs that improperly or vaguely specify a required DLL may be open to a vulnerability in which an unintended DLL is loaded. Side-loading vulnerabilities specifically occur when Windows Side-by-Side (WinSxS) manifests are not explicit enough about characteristics of the DLL to be loaded. Adversaries may take advantage of a legitimate program that is vulnerable to side-loading to load a malicious DLL.

## Findings
In a report called [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/post/sok-attack-securecomm19.pdf), they examined 951 malware families, and found DLL Side-Loading to have occured in 106 samples. -> ~11.14%.

In [FireEye's M-Trends 2020](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) they find that DLL side-loading is exhibited in 3.96% of all malware. 

If we find the average time between these two sources, we get (11.14 + 3.96) / 2 = 7.55. -> ```Bernoulli(0.0755)```.

## Time to compromise
I think this TTC can be interpreted in two ways. Either as the time it takes to actually load the malicious DLL into memory (which would be interpreted as instant for our use cases), or as the time it takes from that the malicious DLL is placed in such a way that it can be loaded, until the time that it actually is loaded. For this attack technique, I will use the first, and assume it's instant, because I don't know how to find the second, or if it's even possible. 

## Result
```Bernoulli(0.0755)```