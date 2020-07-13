# [Component Firmware](https://attack.mitre.org/techniques/T1542/002/)

## Context
>Adversaries may modify component firmware to persist on systems. Some adversaries may employ sophisticated means to compromise computer components and install malicious firmware that will execute adversary code outside of the operating system and main system firmware or BIOS. This technique may be similar to System Firmware but conducted upon other system components/devices that may not have the same capability or level of integrity checking.

## Findings
In one report called [When Firmware Modifications Attack: A case study of Embedded Exploitation](http://ids.cs.columbia.edu/sites/default/files/ndss-2013.pdf), they find that potentially up to 11.9 million HP LaserJet printers shipped in in quarter of 2010 are vulnerable to firmware modifications. [125 million printers were shipped that year worldwide](https://www.statista.com/statistics/272071/global-shipments-of-hardcopy-peripherals/), so in 2010, potentially (11.9/125)=9.52% of printers were vulnerable to this attack... Vulnerability though is not a good measure of how prevalent something is, so I will not use this to estimate prevalence.

Out of the [107](https://attack.mitre.org/groups/) total groups listed by MITRE, only one utilizes the Component Firmware modification technique. I will use this as an estimate for prevalence, so ~0.934% of attacking groups use this kind of attack. 

In one [source](https://media.kasperskycontenthub.com/wp-content/uploads/sites/43/2018/03/08064459/Equation_group_questions_and_answers.pdf) from kaspersky investigating the Equation group, they stated that "The EQUATION group’s HDD firmware reprogramming module is extremely rare." This would indicate that even out of those infected by a malware that have the ability to modify firmware, even then actually doing so is rare. They unfortunately don't include exactly how rare this is, so I will estimate that 1% of those infected by this malware are actually also being attacked by the component firmware attack step. 

1% of 0.934% is 0.00934%. This means that the estimated prevalence of this attack step is ```Bernoulli(0.0000934)```. 

## Time to compromise
One source on [the anatomy of a firmware attack](https://eclypsium.com/2019/12/20/anatomy-of-a-firmware-attack/) finds that "Malicious firmware within a USB device can be used to compromise the firmware of a victim system within minutes..." They demonstrate this attack in a [5 minute long youtube video](https://www.youtube.com/watch?v=loBX_vEXxVA&feature=youtu.be), where the actual attack takes just under 4 minutes. As such I will assume a component firmware modification attack can be completed in 4 minutes. ->```Exponential(360)```. 

## Results
```Bernoulli(0.0000934)*Exponential(360)```

## Discussion
These findings are probably not correct due to how widely I'm using various estimates, but it does seem to be a very rare attack step in any case. 