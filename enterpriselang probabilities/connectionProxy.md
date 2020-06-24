# [Connection Proxy](https://attack.mitre.org/techniques/T1090/)

## Context
>Adversaries may use a connection proxy to direct network traffic between systems or act as an intermediary for network communications to a command and control server to avoid direct connections to their infrastructure. Many tools exist that enable traffic redirection through proxies or port redirection, including HTRAN, ZXProxy, and ZXPortMap. Adversaries use these types of proxies to manage command and control communications, to reduce the number of simultaneous outbound network connections, to provide resiliency in the face of connection loss, or to ride over existing trusted communications paths between victims to avoid suspicion.

## Findings
One such tool is [htran](https://jpcertcc.github.io/ToolAnalysisResultSheet/details/Htran.htm#ExecCondition). This works with (seemingly) any version of windows. So of all the operating systems, according to [statcounter](https://gs.statcounter.com/os-market-share/desktop/worldwide/#monthly-201905-202005) 77.04% of all desktop PCs run windows. According to [netmarketshare](https://netmarketshare.com/operating-system-market-share.aspx?options=%7B%22filter%22%3A%7B%22%24and%22%3A%5B%7B%22deviceType%22%3A%7B%22%24in%22%3A%5B%22Desktop%2Flaptop%22%5D%7D%7D%5D%7D%2C%22dateLabel%22%3A%22Trend%22%2C%22attributes%22%3A%22share%22%2C%22group%22%3A%22platform%22%2C%22sort%22%3A%7B%22share%22%3A-1%7D%2C%22id%22%3A%22platformsDesktop%22%2C%22dateInterval%22%3A%22Monthly%22%2C%22dateStart%22%3A%222019-06%22%2C%22dateEnd%22%3A%222020-05%22%2C%22segments%22%3A%22-1000%22%7D) the numbers are a little different, they show 87.97% of desktop PCs to use windows. 

The average of these two gives us (77.04 + 87.97) / 2 = 82.505. 

Another source we can use for estimating is [red canary's threat detection report from 2019](https://www.scribd.com/document/406643981/Threat-Detection-Report). Here unfortunately they do not present concrete values on the prevalence of Connection proxy specifically, but they do provide a graph, where they state that powershell threats were discovered 1774 times. This graph is 1296 pixels wide, and the connection proxy graph is 444 pixels wide. If we use this information (1774/1296 as a factor to multiply 444 with) we can conclude that connection proxy threats occured ~608 times. Now looking at red canary's website, we can conclude that [powershell related vulnerabilities affect 55% of organizations](https://redcanary.com/threat-detection-report/techniques/powershell/). Doing a rough and dirty estimate by correlating affected organizations with amount of threats detected, using these values we can estimate that roughly 19%(18.84%) of organizations are affected by connection proxy vulnerabilities. 1296 / 0.55 = 2356.36, so 444 / 2356.36 = ~ 18.84. This is not an ideal way of estimating prevalence but due to lack of reliable data this might be ok. 

To get an average of these two, (82.505 / 18.84) / 2 = 50.6725. -> ~```Bernoulli(0.507)```

## Time to compromise
According to one report on [publicly available hacking tools](https://s3.eu-west-1.amazonaws.com/ncsc-content/files/Joint%20report%20on%20publicly%20available%20hacking%20tools%20%28NCSC%29.pdf), htran is used to used to intercept and redirect Transmission Control Protocol (TCP) connections from the local host to a remote host. The process of doing this, as described in the source above, is to first install htran into the ProgramData directory. The actor then issues a command to start htran as a client, initiates a connection to a server on the internet over port 80, which forwards RDP traffic from the local interface. This seems like it would at most take a few seconds to accomplish and as such I will assume the TTC is instant. However, the time that this tool can stay on a computer can be potentially indefinite. In the source described above htran was forwarding traffic for months before being discovered. 

## Result
```Bernoulli(0.507)```

## Discussion
As the 2 prevalence values are so different, I find it hard to believe they are entirely accurate. As such, we might need more data. 