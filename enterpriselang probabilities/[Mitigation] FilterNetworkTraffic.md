# [Filter Network Traffic](https://attack.mitre.org/mitigations/M1037/)

## Context
>Use network appliances to filter ingress or egress traffic and perform protocol-based filtering. Configure software on endpoints to filter network traffic.

## Findings
Here I will attempt to find how effective the mitigation "Filter Network Traffic" is to prevent attacks. 

One type of software that filters network traffic is a firewall. [One article](https://www.itproportal.com/2011/04/19/firewalls-only-60-cent-effective-against-malware/) finds that a well configured firewall will still let ~20% of malware through, which means that it is about 80% effective. 

In an [article by securenetconsulting](http://www.securenetconsulting.co.uk/2016/06/why-you-need-dns-firewall-in-your.html), they state that "...DNS firewalls likely would have prevented the success of more than 80 percent of these attacks", in this case "these attacks" are spear phishing attacks. 

A specialized device for protecting the whole home network called the Trend Micro Home Network Security (which can filter/block network traffic) was reviewed in [an article by pcmag](https://uk.pcmag.com/encryption/127134/trend-micro-home-network-security) where they found it only blocked 61% of the malware hosting URLs they tested.

Research by [Ponemon Institute & Akamai technologies](https://www.akamai.com/us/en/multimedia/documents/report/trends-in-the-cost-of-web-application-ddos-attacks-apac-ponemon-report.pdf) finds that 9% of web borne malware "frequently" bypasses their web application firewalls. This means that these firewalls prevented 91%. 

When it comes to protecting against DDoS attacks, the firewall type of filtering is usually not effective. Instead, other types of network filtering are used. In one [paper they propose filtering with Bloom filters](https://www.researchgate.net/publication/220240884_An_Effective_DDoS_Attack_Detection_and_Packet-Filtering_Scheme), where the results point to network throughput (ratio successfully delivered traffic to the sent traffic) with the defense mechanism in place is ~0.95, while without the defense the throughput was only between ~0.45. This implies that this kind of network filtering will be about ~91% effective against a DDoS attack. (0.55 of traffic possible to save, 0.5 actually saved, 0.5/0.55 = 0.90909...)

One paper called [Breaking the DDoS Attack Chain](https://www.cmu.edu/mits/files/breaking-the-ddos-attack-chain.pdf) they state that DDoS protection company cloudflare is "... able to filter approximately 90% of application attack traffic". 

I will summarize these findings by calculating an average value for the effectiveness of using Filter Network Traffic as a mitigation. (80+80+61+91+91+90)/6= ~82.17%.

## Results
```Bernoulli(0.8217)```. 

## Discussion

There are probably many more sources out there, since there are many different ways to filter network traffic and many attacks against which filtering network traffic can prevent. As such this should not be regarded as a fully complete probability distribution and updates are encouraged.