# [Remote Desktop Protocol](https://attack.mitre.org/techniques/T1076/)

## Context
Remote desktop is a common feature in operating systems. It allows a user to log into an interactive session with a system desktop graphical user interface on a remote system. Microsoft refers to its implementation of the Remote Desktop Protocol (RDP) as Remote Desktop Services (RDS). There are other implementations and third-party tools that provide graphical access Remote Services similar to RDS.

## Findings
[FireEye M-trends 2020 report](https://www.fireeye.com/blog/threat-research/2020/02/mtrends-2020-insights-from-the-front-lines.html) finds that 18.94% of malware attack lifecycles make use of this technique. One [source](https://duo.com/decipher/attackers-combine-attacks-against-rdp-with-ransomware) finds that concerning ransomware specifically, RDP is used in 63.5% of ransomware infections. This [source from securitymagazine.com](https://www.securitymagazine.com/articles/90983-percent-of-organizations-exhibit-malicious-remote-desktop-protocol-rdp-behaviors) states that 90% of organizations exhibit Remote Desktop Protocol behaviours. Another [source also specifically concerning ransomware](https://medium.com/enterprise-nxt/2020-ransomware-attacks-still-mostly-through-unsecured-rdp-b167fefcd490) has RDP being used in "over 50%" of attacks. These are all very different numbers, but I will average them to find a rough estimate on how prevalent this attack technique is. (18.94 + 63.5 + 90 + 50) / 4 = 55.61%. ```Bernoulli(0.5561)```

## Time to compromise
As an estimate for the time needed to compromise a system with this attack, I refer to an example [video](https://www.youtube.com/watch?v=Olgso_oXQa8) showing how to set up RDP. It takes 3 minutes, or 180 seconds for this to be done. I will use this as an estimate for the TTC of this attack step. This is ```Exponential(480)```.

## Result 
```Bernoulli(0.5561)*Exponential(480)```