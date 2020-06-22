# [Firmware Couruption](https://attack.mitre.org/techniques/T1495/)

## Context
"Adversaries may overwrite or corrupt the flash memory contents of system BIOS or other firmware in devices attached to a system in order to render them inoperable or unable to boot."

## Findings
[One source](http://www.baselinemag.com/c/a/Security/Disaster-Recovery-Weaknesses-Are-Pervasive-480167) states that 20% of organizations suffered from firmware corruption. This corresponds to ```Bernoulli(0.2)```. 


## Time to compromise
 One somewhat informal [source from a data recovery firm](https://www.gillware.com/hard-drive-data-recovery/data-recovery-101-firmware/) states how this process might take 30 seconds. I will consider this instant. 

## Result
The probability distribution for this attack becomes ```Bernoulli(0.2)```. 