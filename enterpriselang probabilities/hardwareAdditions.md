# Hardware Additions

## Context 
Adversaries may introduce computer accessories, computers, or networking hardware into a system or network that can be used as a vector to gain access. While public references of usage by APT groups are scarce, many penetration testers leverage hardware additions for initial access. Commercial and open source products are leveraged with capabilities such as passive network tapping, man-in-the middle encryption breaking, keystroke injection, kernel memory reading via DMA, adding new wireless access to an existing network, and others.

The examples of vulnerabilities presented in the MITRE ATT&CK framework https://attack.mitre.org/techniques/T1200/ suggest that in order to perform this type of attack, the adversary needs to have physical access to the company network. Once they get it, the time to compromise is almost instantenous.

## Relevant findings 
https://www.if-insurance.com/large-enterprises/insight/risk-consulting-magazine/risk-consulting-2019-1/physical-security-controls-of-it-and-ics
According to Verizon’s 2018 Data Breach Investigations Report (DBIR), about 11% of the breaches reported involved physical actions.
This result matches the crowdstrike report that suggests that Hardware Additions are observed in 5-20% of breaches. https://go.crowdstrike.com/rs/281-OBQ-266/images/Report2020CrowdStrikeGlobalThreatReport.pdf

## Result
We can then assess the probability distribution for Hardware Additions is ``[Bernoulli(0.11)]``
Taking into consideration the time it would take for the attacker to get the physical access, we assess an arbitrary average of 3 hours to get there, resulting in a ``[Bernoulli(0.11)*Exponential(8)]`` distribution.

## Discussion

The papers we found only give the % of breaches in which this physical access was used to perform the attack. However we may think that physical access was not leveraged every time it was possible which would result in a higher probability of success for HardwareAdditions. We may also assume that adversaries use physical access to get initial access only when it's possible considering the higher risk this implies.
The time to get physical access assessed isn't based on any scientific paper and is only a rough arbitrary estimation that has no reliable scientific basis to support it.
Research on this specific topic seems quite shallow and thus the results are up to discussion.