# [Rootkit](https://attack.mitre.org/techniques/T1014/)

## Context
Rootkits are programs that hide the existence of malware by intercepting (i.e., Hooking) and modifying operating system API calls that supply system information. Rootkits or rootkit enabling functionality may reside at the user or kernel level in the operating system or lower, to include a Hypervisor, Master Boot Record, or the System Firmware.

## Findings
One source from [csoonline](https://www.csoonline.com/article/3222066/how-to-detect-and-remove-a-rootkit-in-windows-10.html) states that out of all malware output, rootkits constituted "less than 1 percent". I will assume that this is ~0.75% (although it could be anywhere from 0-1%).  [FireEye's M-trends 2020 report](https://investors.fireeye.com/static-files/56c2c6ec-3cdc-4fd2-967e-29205d2e982e) has rootkits being used in 1.76% of all malware attack lifecycles. With these two numbers, I will use the average of the two to find an estimate on how prevalent rootkits are. (0.75 + 1.76) / 2 =  1.255% -> ```Bernoulli(0.01255)```. 

## Time to install
From [this technical analysis of a rootkit](https://intezer.com/blog/linux/hiddenwasp-malware-targeting-linux-systems/), we can see break down the installation process of a rootkit into a few steps. The script starts off with defining some environment variables, where it also creates credentials of a user, which is used to provide initial persistence. It then cleans the system for potential older versions of the malware. Then it downloads a compressed archive, which is what actually contains the rookit (and some other components). The script executes a trojan, which adds the rootkit to an environment variable called LD_PRELOAD. It's not entirely clear to me how much time this entire process would take, but there doesn't seem to be anything that would take longer than a few seconds, so I will assume it to be instant. 

## Result
```Bernoulli(0.01255)```

## Discussion
Perhaps more types of rootkits could be investigated to get a better idea of TTC, my sample includes only one rootkit. 