# Exfiltration Over Alternative Protocol 

## Context (https://attack.mitre.org/techniques/T1048/)

Adversaries may steal data by exfiltrating it over a different protocol than that of the existing command and control channel. The data may also be sent to an alternate network location from the main command and control server.

Alternate protocols include FTP, SMTP, HTTP/S, DNS, SMB, or any other network protocol not being used as the main command and control channel. Different protocol channels could also include Web services such as cloud storage. Adversaries may also opt to encrypt and/or obfuscate these alternate channels.

Exfiltration Over Alternative Protocol can be done using various common operating system utilities such as Net/SMB or FTP

## Relevant findings 

### TTC 

https://repo.zenk-security.com/Techniques%20d.attaques%20%20.%20%20Failles/Exfiltration%20Techniques%20-%20An%20examination%20And%20Emulation.pdf
(Page 39) : The average time it took to exfiltrate 500MB files over Alternative protocols in this paper was on average 46 seconds, which is represented by the following distribution : [Exponential(1878)].
(Page 40) : there might be some data loss with some protocols but no precise success rate is given in this paper.

### Prevalence
https://www.mcafee.com/enterprise/en-us/assets/reports/rp-data-exfiltration.pdf
In this report, we find out that internally caught incidents are also less likely to result in actual data exfiltration, with a 70% probability compared to 92% for those found externally. ( More than 90% of security breaches in Asia-Pacific resulted in actual exfiltration of data, compared to 84% in North America and 80% in the UK.)
Besides, discovery of breaches by external actors was split almost 50/50 between internal security and external agents, while over two-thirds of insider thefts were caught by internal security teams. 
Considering, internal actors were responsible for more than 40% of the serious data breach incidents experienced by the respondents, and external actors were responsible for just under 60% of data breaches, we might compute the actual prevalence of all data exfiltration attacks :
0.4x(0.66x0.7+0.33x0.92)+0.6x(0.5x0.7+0.5x0.92) = 0.79224

## Results

We assess the probability distribution for this technique to be [Bernoulli(0.79224)*Exponential(1878)].

## Discussion

Sub-techniques deal with the symettry/encryption of the alternative protocols. For efficiency purposes, I decided to take them all into account in the main technique and not to find a probability for each sub technique, assuming the TTC and prevalence would likely be the same. Further investigation may lead to more detailed results. However, the first source states that sessions with certain symmetry ratios can signify malicious activity which may impact the success rate. Encryption on the other hand might help adversaries bypass certain defenses.