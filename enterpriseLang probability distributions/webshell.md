# [Web Shell](https://attack.mitre.org/techniques/T1100/)

## Context
>A Web shell is a Web script that is placed on an openly accessible Web server to allow an adversary to use the Web server as a gateway into a network. A Web shell may provide a set of functions to execute or a command-line interface on the system that hosts the Web server. In addition to a server-side script, a Web shell may have a client interface program that is used to talk to the Web server (see, for example, China Chopper Web shell client).

## Findings
In the report [M-trends 2020](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) by FireEye, they find that Web shells are utilized by malware in 15.86% of all malware attack cycles. 

## Time to compromise
The time to install a webshell on a vulnerable website can be as low as 24 hours according to [this source](https://media.defense.gov/2020/Jun/09/2002313081/-1/-1/0/CSI-DETECT-AND-PREVENT-WEB-SHELL-MALWARE-20200422.PDF). 

## Result
These findings indicate that we can estimate that webshells have a probability distribution that looks like this: ```Bernoulli(0.1586)*Exponential(1)```

## Discussion
I was unable to find another source detailing the prevalence of web shells, but ideally we probably want another source. 