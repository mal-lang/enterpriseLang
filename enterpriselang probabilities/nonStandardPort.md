# [Non Standard Port](https://attack.mitre.org/techniques/T1571/)

## Context
>Adversaries may communicate using a protocol and port paring that are typically not associated. For example, HTTPS over port 8088[1] or port 587[2] as opposed to the traditional port 443. Adversaries may make changes to the standard port used by a protocol to bypass filtering or muddle analysis/parsing of network data.

## Findings
According to [nexustek.org](https://www.nexustek.com/blog/cyber-security-tip-detecting-attacks-over-low-traffic-ports/), research from SonicWall shows that 19.2% percent of malware attacks now use non-standard ports. 

According to [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/) "uncommonly used ports" as an attack technique, were found in 67 out of 951 malware samples. This corresponds to ~7%. 

Research from [Palo Alto Networks](https://media.paloaltonetworks.com/documents/The-Modern-Malware-Review-March-2013.pdf) finds that regarding malware on non-standard ports, FTP applications used them 97% of the time, web browsing 10%, custom TCP 43%, and HTTP-proxy 17%. 

The report [A View on Current Malware Behaviours](https://www.usenix.org/event/leet09/tech/full_papers/bayer/bayer.pdf) finds that out of 30059 IRC bots and 4722 HTTP bots, a total of 27716 were communicating over non-standard ports. This is ~79.7%. 

[securityweek.com](https://www.securityweek.com/rise-malware-using-encryption-shows-importance-network-traffic-inspection) reports that of the malware samples they investigated communicates over standard port 443, 44% of the time. So this means that up to 56% are using non-standard ports. 

The average of these values is (19.2 + 7 + 10 + 97 + 43 + 17 + 79.7 + 56)/8 = ~41.11%. The standard deviation is ~31.68. So I will use the TruncatedNormal() with 41.11 average, and 31.68 standard deviation. This is ```TruncatedNormal(41.11,31.68)```.

## Time to compromise
This attack step is about which ports are chosen to communicate over. I think TTC could either be interpreted as how long it would take to finish communications over the port, or how long it would take for the software to begin using the port. The latter is probably instant, and this is the TTC I will use. For findings regarding the former TTC, I have listed further down below. 

## Results
```TruncatedNormal(41.11,31.68)```

## Discussion
It doesn't feel great to me that all the values are so different. Using a normal distribution probably isn't ideal because of this, but it's the best idea I have at the moment. If this is deemed too poor, perhaps we could just use the average. 

## Time to compromise option 2: How long will the malware use communications over the (non-standard) port?
Since it might be of interest, I will list some findings on how long other malware attacks can last. 

### General presence on network
One [source, "Command & Control Understanding, Denying and Detecting"](https://arxiv.org/pdf/1408.1136) finds that the median time that attackers are able to maintain a presence on a network is 243 days. 

### Ransomware duration
Another [source](https://www.zdnet.com/article/ransomware-attacks-are-causing-more-downtime-than-ever-before/) from ZDnet dealing with ransomware finds that the average ransomware incident lasts 16.2 days. 

### Time to detect data breach
Another [source](https://www.cybintsolutions.com/cyber-security-facts-stats/) from cybintsolutions finds that it takes companies on average 6 months to detect a data breach. . 
