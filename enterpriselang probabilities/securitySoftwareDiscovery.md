# [Security Software Discovery](https://attack.mitre.org/techniques/T1063/)

## Context
>Adversaries may attempt to get a listing of security software, configurations, defensive tools, and sensors that are installed on the system. This may include things such as local firewall rules and anti-virus. Adversaries may use the information from Security Software Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.

## Findings
In [this](https://krisk.io/post/sok-attack-securecomm19.pdf) article on ATT&CK Techniques and Trends in Windows Malware, with a sample size of 951 the authors find that 748 samples use some kind of security software discovery. This corresponds to 78.654%. 

Another study published by Recorded Future called [MITRE Attack Tactics](https://www.recordedfuture.com/mitre-attack-tactics/) in 2019, they found that the volume of threats associated with security software discovery was 22,961 out of 26,057 total. This corresponds to ~88.12%. 

If we find the average of these two, (78.654 + 88.12) / 2 = 83.387, we can estimate that the prevalence of malware using this attack step is 83.387%, or ```Bernoulli(0.83387)```. 

## Time to compromise
The MITRE ATT&CK page lists some samples of how this attack technique can be used on windows. They state the following: 
>Example commands that can be used to obtain security software information are [netsh](https://attack.mitre.org/software/S0108/), ```reg query``` with [Reg](https://attack.mitre.org/software/S0075/), ```dir``` with [cmd](https://attack.mitre.org/software/S0106/), and [Tasklist](https://attack.mitre.org/software/S0057/), but other indicators of discovery behavior may be more specific to the type of software or security system the adversary is looking for.
This indicates to me that the time to discover this security software can be as simple as typing a command into a terminal. This, I will assume is instant.

## Result

```Bernoulli(0.83387)```. 