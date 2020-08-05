# [Firmware Couruption](https://attack.mitre.org/techniques/T1495/)

## Context
"Adversaries may overwrite or corrupt the flash memory contents of system BIOS or other firmware in devices attached to a system in order to render them inoperable or unable to boot."

## Findings
[One source states that 80% of PCs examined have firmware vulnerabilities](https://www.wired.com/2015/03/researchers-uncover-way-hack-bios-undermine-secure-operating-systems/). This implies that 80% are vulnerable to this attack step, since 80% could experience firmware corruption. Thus, -> ```Bernoulli(0.8)```. 


## Time to compromise
One somewhat informal [source from a data recovery firm](https://www.gillware.com/hard-drive-data-recovery/data-recovery-101-firmware/) states how this process might take 30 seconds. This is essentially instant when compared to one day but for the sake of clarity I will include ```Exponential(2880)``` as the TTC. 

## Result
The probability distribution for this attack becomes ```Bernoulli(0.8)*Exponential(2880)```. 