# [Network Segmentation](https://attack.mitre.org/mitigations/M1030/) [Mitigation]

## Context
"Architect sections of the network to isolate critical systems, functions, or resources. Use physical and logical segmentation to prevent access to potentially sensitive systems and information. Use a DMZ to contain any internet-facing services that should not be exposed from the internal network."

## Findings 
According to one survey of [300 IT professionals](https://www.darkreading.com/application-security/few-firms-use-segmentation-despite-security-benefits/d/d-id/1336654), 19% of companies use network segmentation. There is also micro-segmentation, which is another type of network segmentation focusing on "east-to-west" movement rather than the traditional "north-to-south" of network segmentation. One study found that [micro-segmentation](https://www.securitymagazine.com/articles/91776-cisco-2020-ciso-benchmark-report-average-company-uses-20-security-technologies) had a usage rate of 17%. It's hard to say how large the overlap is between these two, but as an estimate I will simply take the average of these. (17%+19%)/2 = 18%. This comes out to a distribution of ```Bernoulli(0.18)```. 

## Result
```Bernoulli(0.18)```