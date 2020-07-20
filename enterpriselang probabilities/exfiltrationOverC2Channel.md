# Exfiltration Over C2 Channel

## Context (https://attack.mitre.org/techniques/T1041/)

Adversaries may steal data by exfiltrating it over an existing command and control channel. Stolen data is encoded into the normal communications channel using the same protocol as command and control communications.

## Relevant findings

https://www.sans.org/blog/the-importance-of-command-and-control-analysis-for-incident-response/
The C2 Channel is the Channel allowing the adversary to execute commands on the enterprise network. This channel can also be used to exfiltrate data using the current protocol. Or the data may also be sent to an alternate network location from the main command and control server, or using an alternative protocol (Exfiltration Over Alternative Protocol).

https://www.mcafee.com/enterprise/en-us/assets/reports/rp-data-exfiltration.pdf
This report allow us to compute the generic average success rate of exfiltration attaxks, regardless of the protocol or medium being used. We'll use its result for the probability distribution for this technique. [Bernoulli(0.79224)]

https://repo.zenk-security.com/Techniques%20d.attaques%20%20.%20%20Failles/Exfiltration%20Techniques%20-%20An%20examination%20And%20Emulation.pdf
There doesn't seem to be any preferred protocol mentioned in any of the findings wo we decided to use the average result given by this paper in order to assess an average TTC for this technique.[Exponential(1878)]

## Results

We assess the probability distribution for this technique to be [Bernoulli(0.79224)*Exponential(1878)].

## Discussion

I couldn't find a preferred/default protocol used in C2 Channel. This data could be of use in order to assess more accurately the TTC and prevalence for this technique.

