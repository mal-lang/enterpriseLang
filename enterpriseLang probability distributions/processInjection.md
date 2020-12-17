# [Process Injection](https://attack.mitre.org/techniques/T1055/)
"Process injection is a method of executing arbitrary code in the address space of a separate live process. Running code in the context of another process may allow access to the process's memory, system/network resources, and possibly elevated privileges. Execution via process injection may also evade detection from security products since the execution is masked under a legitimate process."

Definition from [Red Canary](https://redcanary.com/threat-detection-report/techniques/process-injection/): "Process Injection is a technique whereby an adversary is able to carry out some nefarious activity in the context of a legitimate process. In this way, malicious activity—whether it’s an overtly malicious binary or a process that’s been co-opted as such—blends in with routine operating system processes."

## Prevalence
Process Injection according to [Red Canary's Threat Detection Report 2020](https://redcanary.com/threat-detection-report/techniques/process-injection/) states that 35% of organizations are affected by Process Injection. This corresponds to a Bernoulli distribution of ```Bernoulli(0.35)```. 

## Time to compromise
Also according to Red Canary's report, TrickBot was responsible for the "vast majority" of Process Injection activity. The "disablingSecurityTools" attack step also uses TrickBot, the following findings are copied from the findings regarding that step:

The malware TrickBot. There appears to be a few different version of this malware, each with different TTCs, so I will combine them into one average value. According to one source, this malware will attempt trigger a task that repeats [every 11 minutes](https://labs.sentinelone.com/trickbot-update-brief-analysis-of-a-recent-trickbot-payload/). [Another source](https://www.wilbursecurity.com/2020/03/trickbot-to-ryuk-in-two-hours/) states that it executes every 20 minutes. [Yet another source](https://www.trustwave.com/en-us/resources/blogs/spiderlabs-blog/tale-of-the-two-payloads-trickbot-and-nitol/) finds that it executes every 3 minutes. The average becomes (3 + 11 + 20) / 3 = 11.333... minutes. This corresponds to ```Exponential(127.1)```.

## Result
Finally, the probability distribution for this attack step is: ```Bernoulli(0.35)*Exponential(127.1)```. 