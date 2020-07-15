# [Web Service](https://attack.mitre.org/techniques/T1102/)

## Context
>Adversaries may use an existing, legitimate external Web service as a means for relaying data to/from a compromised system. Popular websites and social media acting as a mechanism for C2 may give a significant amount of cover due to the likelihood that hosts within a network are already communicating with them prior to a compromise. Using common services, such as those offered by Google or Twitter, makes it easier for adversaries to hide in expected noise. Web service providers commonly use SSL/TLS encryption, giving adversaries an added level of protection.

There are also three sub techniques:

* [Web Service: Dead Drop Resolver ](https://attack.mitre.org/techniques/T1102/001/)
* [ Web Service: Bidirectional Communication ](https://attack.mitre.org/techniques/T1102/002/)
* [ Web Service: One-Way Communication ](https://attack.mitre.org/techniques/T1102/003/)

## Findings
In the [FireEye Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that this attack step is included in 3.96% of all attack lifecycles. 

In the [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/), they find that this attack step is included in 47 out of 951 malware samples. This is (47/951) = 4.94%. 

The average of these two findings comes out to (3.96 + 4.94) / 2 = 4.45%. 

```Bernoulli(0.0445)```

## Time to compromise
This is the kind of attack step that is usually set up before an attack is started. As an example, [FIN6](https://www.fireeye.com/blog/threat-research/2019/04/pick-six-intercepting-a-fin6-intrusion.html) uses pastebin to host content. So before the attack associated with FIN6 started, those behind the attack would have uploaded the content to the website, so this entire attack step is just about the fact that a web service is used as a means for relaying data. Even data downloaded seems to be in the case of FIN6 a couple hundred KB at most. The time to set this up would then be before the attack itself and as such I assume this attack step to be instant. 

## Result
```Bernoulli(0.0445)```
