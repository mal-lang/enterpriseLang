# [Network Sniffing](https://attack.mitre.org/techniques/T1040/)

## Context
Network sniffing refers to using the network interface on a system to monitor or capture information sent over a wired or wireless connection. An adversary may place a network interface into promiscuous mode to passively access data in transit over the network, or use span ports to capture a larger amount of data.

## Findings
According to [FireEye's M-trends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), Network sniffing is part of 0.44% of all attack lifecycles. 

## Time to compromise
VICE conveniently has an article called [How to go from 0 to sniffing packets in 10 minutes](https://www.vice.com/en_us/article/jpgmxp/how-to-go-from-0-to-sniffing-packets-in-10-minutes). There are also a wide variety of video tutorials on how to sniff packets. For reference: https://www.youtube.com/watch?v=xW9GDAJXB-I, https://www.youtube.com/watch?v=r0l_54thSYU, https://www.youtube.com/watch?v=1O-JUaK1-wE, https://www.youtube.com/watch?v=kTcFUenYsyw https://www.youtube.com/watch?v=_WQe36pZ3mA, These range in length from ~3 to ~20 minutes. As an estimate, I'll use 10 minutes as the time to complete network sniffing. 

## Results
```Bernoulli(0.0044)*Exponential(144)```

## Discussion
Unfortunately I could only find a single source for how common network sniffing is, which is not ideal. This distribution should be updated in the future with more sources.