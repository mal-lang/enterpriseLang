# [Disabling Security Tools](https://attack.mitre.org/techniques/T1089/)
Adversaries may disable security tools to avoid possible detection of their tools and activities. This can take the form of killing security software or event logging processes, deleting Registry keys so that tools do not start at run time, or other methods to interfere with security scanning or event reporting.

## Prevalence
According to [Red Canary's Threat Detection Report 2020](https://redcanary.com/threat-detection-report/techniques/disabling-security-tools/), this vulnerability affects 23% of organizations. This corresponds to ```Bernoulli(0.23)```. 

## Time to compromise
Also according to Red Canary's Threat Detection Report, one of the ways to perform this attack is through the malware TrickBot. There appears to be a few different version of this malware. According to one source, this malware will attempt trigger a task that repeats [every 11 minutes](https://labs.sentinelone.com/trickbot-update-brief-analysis-of-a-recent-trickbot-payload/). [Another source](https://www.wilbursecurity.com/2020/03/trickbot-to-ryuk-in-two-hours/) states that it occurs every 20 minutes. [Yet another source](https://www.trustwave.com/en-us/resources/blogs/spiderlabs-blog/tale-of-the-two-payloads-trickbot-and-nitol/) finds that it executes every 3 minutes. The average becomes (3 + 11 + 20) / 3 = 11.333... minutes. This corresponds to ```Exponential(127.1)```. Another common way of performing this attack is a malware called emotet. According to an [intelligence report from esentire.com](https://www.esentire.com/assets/resourcefiles/eSentire-2019-Annual-Threat-Intelligence-Report-2019-Perspectives-and-2020-Predictions.pdf), emotet took 15 minutes to move to two additional hosts after compromising the initial patient zero. I think this could be interpreted as the time it needs to compromise a system in the first place. 15 minutes corresponds to ```Exponential(96)```. If you take the average of these two TTC:s, you get (127.1 + 96) / 2 = 111.55. So ```Exponential(111.55)```

## Results
The resulting probability distribution looks like this: ```Bernoulli(0.23)*Exponential(111.55)```. 

## Discussion
This particular type of attack is very broad and includes any attack where security tools are disabled, so there are a lot of different procedures and malwares using this tactic. MITRE ATT&CK lists 41 different procedures for example. So, using just two examples to find an average TTC is probably not as good of an estimate as it could be. However I think for now it's decent. 