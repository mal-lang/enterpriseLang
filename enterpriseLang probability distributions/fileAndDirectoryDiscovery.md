# [File and Directory Discovery](https://attack.mitre.org/techniques/T1083/)

## Context
>Adversaries may enumerate files and directories or may search in specific locations of a host or network share for certain information within a file system. Adversaries may use the information from File and Directory Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.

>Many command shell utilities can be used to obtain this information. Examples include `dir`, `tree`, `ls`, `find`, and `locate`. Custom tools may also be used to gather file and directory information and interact with the Native API.

## Findings
In the [FireEye 2020 mtrends report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that File and Directory Discovery was used in 3.08% of all attack lifecycles. 

In the [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/), they find that this attack step was used in 658 out of 951 malware families. This comes out to ~69.19%. 

In a presentation called [Quantify Your Hunt: Not Your Parent’s Red Teaming Redux](https://www.sans.org/cyber-security-summit/archives/file/summit_archive_1536351477.pdf), they counted 75 occurences of File and Directory Discovery, while at the same time, the most common one they found was "Remote File Copy", occuring 92 times. We previously found that Remote File Copy has a 29% prevalence. 75/92 = 81.52%. So if we interpret this as "file and directory discovery is ~81% as common as Remote file copy", then we get 0.29 * 0.8152 = 23.64% as the prevalence of file and directory discovery.

These are all very different in prevalence, but I will get the average of them. (3.08 + 69.19 + 23.64) / 3 = 31.97%. -> ```Bernoulli(0.3197)```. 

## Time to compromise
According to the 'context' section above, "Many command shell utilities can be used to obtain this information", and "Custom tools may also be used to gather file and directory information and interact with the Native API", doing simple API calls or single-word commands in a command shell seems like it would be instant to me. 

## Result
```Bernoulli(0.3197)```.

## Discussion
It's a little concerning that all the prevalence percentages are so different, it makes me wonder what could cause such a large disrepancy. In any case, with only 3 data points it's not enough to weed out which is the odd one out. Ideally more data wanted in the future. 