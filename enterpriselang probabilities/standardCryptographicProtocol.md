# [Standard Cryptographic Protocol](https://attack.mitre.org/techniques/T1032/)

## Context
>Adversaries may explicitly employ a known encryption algorithm to conceal command and control traffic rather than relying on any inherent protections provided by a communication protocol. Despite the use of a secure algorithm, these implementations may be vulnerable to reverse engineering if necessary secret keys are encoded and/or generated within malware samples/configuration files.

## Findings
In [this](https://krisk.io/post/sok-attack-securecomm19.pdf) article on ATT&CK Techniques and Trends in Windows Malware, with a sample size of 951 the authors find that 104 samples use some kind of standard cryptographic protocol. This corresponds to ~10.9%

Another study published by Recorded Future called [MITRE Attack Tactics](https://www.recordedfuture.com/mitre-attack-tactics/) in 2019, they found that the volume of threats associated with standard cryptographic protocols was 13,603 out of 26,057 total. This corresponds to ~52.2%. 

We can also collect information on the usage of specific protocols that fall under the category of "standard cryptographic protocols". One of these is malware using Transport Layer Security (TLS). One [report from CISCO](https://blogs.cisco.com/security/malwares-use-of-tls-and-encryption) finds that 10-12% of malware makes use of TLS (I'll say 11% for simplicity's sake). [Sophos Labs](https://news.sophos.com/en-us/2020/02/18/nearly-a-quarter-of-malware-now-communicates-using-tls/) finds that 23% of malware that use an internet connection communicated over TLS. 

Another standard cryptographic protocol is HTTPS (which technically is HTTP, just using SSL/TLS for security), which [Cyren's researchers](https://www.cyren.com/blog/articles/over-one-third-of-malware-uses-https) finds to be used by 37% of all malware. 

I will use a truncated normal distribution. The average value is (10.9 + 52.2 + 11 + 23 + 37) / 5 = 26.82. We can calculate a normal distribution with these values which I get to be Normal(26.82,15.913), where the mean is 26.82 and the standard deviation is ~15.913. For MAL, I will use a truncated normal distribution -> ```TruncatedNormal(26.82,15.913)```. 

## Time to compromise
According to the site [istlsfastyet](https://istlsfastyet.com/), an employee from Google was quoted as saying: 

>On our production frontend machines, SSL/TLS accounts for less than 1% of the CPU load

And [a graphic from cloudflare](https://www.cloudflare.com/learning/ssl/what-happens-in-a-tls-handshake/) shows a TLS handshake taking approx. 110 milliseconds (~0.1s). I think it's safe to assume this as instant.

## Result
```TruncatedNormal(26.82,15.913)```

## Discussion
These data points are all quite from one another, which could indicate that one or more are using incorrect or inconsistent data. However I'm not qualified to assert which of these is less correct, and so I resorted to using all of them to find an estimated distribution that is hopefully correct enough. 