# External Remote Service 

## Context
Remote services such as VPNs, Citrix, and other access mechanisms allow users to connect to internal enterprise network resources from external locations. There are often remote service gateways that manage connections and credential authentication for these services. Services such as Windows Remote Management can also be used externally.

Adversaries may use remote services to initially access and/or persist within a network. Access to Valid Accounts to use the service is often a requirement, which could be obtained through credential pharming or by obtaining the credentials from users after compromising the enterprise network. Access to remote services may be used as part of Redundant Access during an operation.

Non exhaustive List of external remote services : VPN, Citrix, OWA, SSH, VNC, DynDNS, FTP, RAdmin, TeamViewer, Ammyy Admin ...
(Remote Desktop Protocol isn't a service)
RDP is the protocole used in remote access, if the port is insecure, an adversary may access the internal network of the company.

## Relevant findings
https://blog.reposify.com/127-increase-in-exposed-rdps-due-to-surge-in-remote-work 
4.7 million RDPs that are exposed to the internet

https://blog.reposify.com/is-your-enterprise-vpn-secure
How easy is it to find exposed vulnerable VPNs on the internet? 
Exposed VPNs can be found with just a few clicks. Attackers use internet scanners to discover VPN servers that run on a vulnerable software version. Once detected, they leverage known vulnerabilities and off the shelf proof-of-concept codes that can be found online. Reposify’s internet scanners detected millions of VPNs servers currently exposed to the internet, of which thousands are unpatched and vulnerable.

https://www.securitymetrics.com/blog/remote-access-attacks-how-protect-against-malware
It is estimated that the average hacker could scan the entire internet for possible remote access vulnerabilities once every eight hours. This statistic is exactly why vulnerability scanning is crucial to merchant security. Vulnerability scanning should be an ongoing, or at least conducted quarterly to help locate vulnerabilities, including any remote access problems.

https://cdn2.hubspot.net/hubfs/4595665/Acunetix_web_application_vulnerability_report_2019.pdf
Perimeter Network Vulnerabilities > 19% of sampled targets were found to be
vulnerable to SSH-related vulnerabilities

https://securitybrief.com.au/story/15-000-companies-still-critically-vulnerable-from-citrix-security-flaws-report
Overall, the vulnerability is being fixed relatively quickly, but 19% of companies are still at risk. 


## Unused data
https://www.ptsecurity.com/ww-en/analytics/network-traffic-analysis-2020/#id8
https://www.securityweek.com/remote-access-hidden-weak-spot-cyberattacks
Round 70% of companies use a remote access service. 

https://trustwave.azureedge.net/media/13167/2015-trustwave-global-security-report.pdf?rnd=131657083010000000
28% of breaches result from weak remote access security

Some research has suggested that remote access usage increased by 150% by the end of March.
https://blog.reposify.com/127-increase-in-exposed-rdps-due-to-surge-in-remote-work

## Results

According to the data we collected, it would take on average 8 hours for an adversary to find and exploit a vulnerability on an external remote service. On average 19% of companies are vulnerable to an attack on external remote service. Considering those companies wouldn't be vulnerable with a fully updated network and well configured, we assess that the probability distribution for this attack step (without taking into account any mitigation) is ``` Bernoulli(0.19)*Exponential(3) ``` 