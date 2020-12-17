# [Deobfuscate/Decode Files or Information](https://attack.mitre.org/techniques/T1140/)

## Context
>Adversaries may use Obfuscated Files or Information to hide artifacts of an intrusion from analysis. They may require separate mechanisms to decode or deobfuscate that information depending on how they intend to use it. Methods for doing that include built-in functionality of malware or by using utilities present on the system.

## Findings
In the [Fireeye Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that this attack step is used in 1.32% of all attack lifecycles. 

In the [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/), they find that this attack step is found in 378 out of 951 malware families. This is ~39.748%. 

The Red Canary ATT&CK technique percentages top 50 (private google sheets document), they find that this attack step is successfully used against 22% of organizations. 

If we find the average of these findings, we get that this attack step has a prevalence of (1.32 + 39.748 + 22) / 3 = ~21.02%.

## Time to compromise
According to MITRE ATT&CK, one way of accomplishing this attack step is to do the following: 

>use of [certutil](https://attack.mitre.org/software/S0160/) to decode a remote access tool portable executable file that has been hidden inside a certificate file.

This software has been used with the `-decode` verb to decode binaries hidden inside certificate files as Base64 information. It seems to be an essentially instant operation. To verify, I tried this on a small text file (2KB) that I first encoded and then decoded using `certutil` and the `Measure-Command` to measure the time, and it took only ~60 milliseconds. 

Another example is using the Windows `copy /b` command to reassemble binary fragments into a malicious payload. I will assume that this runtime is similar to the above, so overall I estimate this attack step is instant.

## Result
```Bernoulli(0.2102)```. 

## Discussion
This is yet another case of the prevalence percentages being quite different from one another. These findings should be decent as an estimate though.  