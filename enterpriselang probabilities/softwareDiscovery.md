# Software Discovery

## Context (https://attack.mitre.org/techniques/T1518/)

Adversaries may attempt to get a listing of software and software versions that are installed on a system or in a cloud environment. Adversaries may use the information from Software Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.

Adversaries may attempt to enumerate software for a variety of reasons, such as figuring out what security measures are present or if the compromised system has a version of software that is vulnerable to Exploitation for Privilege Escalation.

The only sub-technique for this technique is Security Software Discovery. There is no reason for the probability distribution to be different when attempting to Discover Software vs Security Software. We'll use the probability found by Love in the securitySoftwareDiscovery.md file as the probability for the Software Discovery main technique.

## Results 

```Bernoulli(0.83387)```.