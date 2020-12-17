# [Domain Trust Discovery](https://attack.mitre.org/techniques/T1482/)
"Adversaries may attempt to gather information on domain trust relationships that may be used to identify Lateral Movement opportunities in Windows multi-domain/forest environments"
## Prevalence
According to [Red Canary's Threat Detection Report](https://redcanary.com/threat-detection-report/techniques/domain-trust-discovery/), 13% of organizations of affected. -> ```Bernoulli(0.13)```. 

## Time to compromise
The majority of Domain Trust Discovery activity reported by Red Canary comes from TrickBot. We have previously found TrickBots time to compromise when researching other attack steps. This is the findings regarding TrickBot: "There appears to be a few different version of this malware, each with different TTCs, so I will combine them into one average value. According to one source, this malware will attempt trigger a task that repeats [every 11 minutes](https://labs.sentinelone.com/trickbot-update-brief-analysis-of-a-recent-trickbot-payload/). [Another source](https://www.wilbursecurity.com/2020/03/trickbot-to-ryuk-in-two-hours/) states that it executes every 20 minutes. [Yet another source](https://www.trustwave.com/en-us/resources/blogs/spiderlabs-blog/tale-of-the-two-payloads-trickbot-and-nitol/) finds that it executes every 3 minutes. The average becomes (3 + 11 + 20) / 3 = 11.333... minutes. This corresponds to ```Exponential(127.1)```."

## Results
Domain Trust Discovery gets a probability distribution result of: ```Bernoulli(0.13)*Exponential(127.1)```.

## Discussion
A lot of attack steps seem to be influenced by TrickBot - is it really reasonable that so many attacks are by TrickBot? Or does this indicate a skewed dataset. For now, it should be OK as an estimate but further research should be done on all attack steps that base their TTC on trickbots times. 