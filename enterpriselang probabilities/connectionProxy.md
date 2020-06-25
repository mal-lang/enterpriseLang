# [Connection Proxy](https://attack.mitre.org/techniques/T1090/)

## Context
>Adversaries may use a connection proxy to direct network traffic between systems or act as an intermediary for network communications to a command and control server to avoid direct connections to their infrastructure. Many tools exist that enable traffic redirection through proxies or port redirection, including HTRAN, ZXProxy, and ZXPortMap. Adversaries use these types of proxies to manage command and control communications, to reduce the number of simultaneous outbound network connections, to provide resiliency in the face of connection loss, or to ride over existing trusted communications paths between victims to avoid suspicion.

## Findings
One such tool is [htran](https://jpcertcc.github.io/ToolAnalysisResultSheet/details/Htran.htm#ExecCondition). This works with (seemingly) any version of windows. So of all the operating systems, according to [statcounter](https://gs.statcounter.com/os-market-share/desktop/worldwide/#monthly-201905-202005) 77.04% of all desktop PCs run windows. According to [netmarketshare](https://netmarketshare.com/operating-system-market-share.aspx?options=%7B%22filter%22%3A%7B%22%24and%22%3A%5B%7B%22deviceType%22%3A%7B%22%24in%22%3A%5B%22Desktop%2Flaptop%22%5D%7D%7D%5D%7D%2C%22dateLabel%22%3A%22Trend%22%2C%22attributes%22%3A%22share%22%2C%22group%22%3A%22platform%22%2C%22sort%22%3A%7B%22share%22%3A-1%7D%2C%22id%22%3A%22platformsDesktop%22%2C%22dateInterval%22%3A%22Monthly%22%2C%22dateStart%22%3A%222019-06%22%2C%22dateEnd%22%3A%222020-05%22%2C%22segments%22%3A%22-1000%22%7D) the numbers are a little different, they show 87.97% of desktop PCs to use windows. 

The average of these two gives us (77.04 + 87.97) / 2 = 82.505. -> ~```Bernoulli(0.825)```

## Time to compromise
According to one report on [publicly available hacking tools](https://s3.eu-west-1.amazonaws.com/ncsc-content/files/Joint%20report%20on%20publicly%20available%20hacking%20tools%20%28NCSC%29.pdf), htran is used to used to intercept and redirect Transmission Control Protocol (TCP) connections from the local host to a remote host. The process of doing this, as described in the source above, is to first install htran into the ProgramData directory. The actor then issues a command to start htran as a client, initiates a connection to a server on the internet over port 80, which forwards RDP traffic from the local interface. This seems like it would at most take a few seconds to accomplish and as such I will assume the TTC is instant. However, the time that this tool can stay on a computer can be potentially indefinite. In the source described above htran was forwarding traffic for months before being discovered. 

## Result
```Bernoulli(0.825)```