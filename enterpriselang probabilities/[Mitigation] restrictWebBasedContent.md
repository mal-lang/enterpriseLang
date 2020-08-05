# [Mitigation, Restrict Web Based Content](https://attack.mitre.org/mitigations/M1021/)

## Context

>Restrict use of certain websites, block downloads/attachments, block Javascript, restrict browser extensions, etc.

## Findings
According to [research done by Spiceworks](https://community.spiceworks.com/blog/3073-data-snapshot-how-web-filtering-affects-workplace-security-and-productivity), 89% will "block or limit the use of one or more online service/site, such as social media, streaming services, or online shopping.". 

But what is actually interesting is how **effective** it is to block/restrict/limit web based content, when it comes to protecting against malware/intrustions/security incidents. The same study from spiceworks finds that "38 percent of organizations experienced one or more security incidents originating on non-work-related sites in the past 12 months". So if these non-work related sites had been blocked, it would mean that these 38% of organizations would not have had those security incidents. The same research finds that 

According to [internetsociety.org](https://www.internetsociety.org/resources/doc/2017/internet-content-blocking/), one type of content blocking is blocking phishing messages from appearing in employees' inboxes. According to [this site on phishing statistics](https://www.phishingbox.com/resources/phishing-facts), 32% of breaches involve phishing (excluding spearphishing which has a much higher percent chance of success). These 32% would be prevented with the restriction of web based content. 

An article on [darkreading.com](https://www.darkreading.com/vulnerabilities---threats/social-media-platforms-double-as-major-malware-distribution-centers/d/d-id/1333973) reports on how common it is for infections to occur from social media sites. It cites research from Bromium, where they found that one in five (20%) organizations have been infected with malware distributed via a social media platform. This would be prevented if social media was blocked. 

I will combine these percentages, (38 + 32 + 20) / 3 = 30%. So, by restricting web based content, 30% of all attacks can be prevented. 

## Result

```Bernoulli(0.3)```. 