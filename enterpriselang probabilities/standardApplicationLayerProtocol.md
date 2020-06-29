# [Standard Application Layer Protocol](https://attack.mitre.org/techniques/T1071/)

## Context
> Adversaries may communicate using a common, standardized application layer protocol such as HTTP, HTTPS, SMTP, or DNS to avoid detection by blending in with existing traffic. Commands to the remote system, and often the results of those commands, will be embedded within the protocol traffic between the client and server.

## Findings
According to vmware's Carbon Black [2020 Cyber Security Outlook Report](https://content.carbonblack.com/c/vmwcb-threat-report-?x=f_lWMB), 20% of malware uses Standard Application Layer Protocol. This corresponds to ```Bernoulli(0.20)```. 

## Time to compromise
This attack step in and of itself does not take time, as it's about choosing which protocol to communicate over. The actual time needed to communicate does take time, but this attack step itself, I am assuming is instant.

## Result
```Bernoulli(0.20)```. 