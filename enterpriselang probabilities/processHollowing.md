# [Process Hollowing](https://attack.mitre.org/techniques/T1055/012/)

## Context
>Adversaries may inject malicious code into suspended and hollowed processes in order to evade process-based defenses. Process hollowing is a method of executing arbitrary code in the address space of a separate live process. 

## Findings
In [Red Canary's Threat Detection Report](https://redcanary.com/threat-detection-report/techniques/) they find that Process Hollowing makes up 2% of all threat volume. 

In [FireEye's 2020 Mtrends report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that process hollowing is used in 0.44% of all attack lifecycles. 

[This blog on code injection](https://adalogics.com/blog/the-state-of-advanced-code-injections) finds that code injection functionality was found in 13.5% of malware, and MITRE ATT&CK lists 11 total different code injection techniques. Assuming they are equally used, 13.5/11 = 1.227. 

The average of these two is: (0.44 + 2 + 1.227) / 3 = ~1.22% -> ```Bernoulli(0.0122)```. 

This value only gives the % of attacks in which this technique is being used. Considering code updates and process injection findings, we'll not assess any prevalence for any process injection sub techniques.

## Time to compromise
I found a video tutorial [here](https://www.youtube.com/watch?v=G6AoZ5F4CH8) where the process hollowing seems to take approximately ~90 seconds to complete. Another tutorial [here](https://www.youtube.com/watch?v=k2pLF56gXXw&feature=youtu.be&t=106) seems to take ~45 seconds. I will estimate 60 seconds as the TTC. -> ```Exponential(1440)```. 

## Result
```Exponential(1440)```