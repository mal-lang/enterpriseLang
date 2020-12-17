# [Scheduled Task](https://attack.mitre.org/techniques/T1053/)
From MITRE ATT&CK: "Can be used to schedule programs or scripts to be executed at a date and time. A task can also be scheduled on a remote system, provided the proper authentication is met to use RPC and file and printer sharing is turned on. Scheduling a task on a remote system typically required being a member of the Administrators group on the remote system." It uses some of windows built in functionailty to schedule tasks like [at](https://docs.microsoft.com/en-us/previous-versions/windows/it-pro/windows-xp/bb490866(v=technet.10)?redirectedfrom=MSDN). This procedure in and of itself is not necessarily malicious but can be abused. 

From [Red Canary's Threat Detection Report 2020](https://redcanary.com/threat-detection-report/techniques/scheduled-task/), "Scheduled Tasks allow adversaries to carry out certain actions at pre-specified times, enabling execution, persistence, and privilege escalation. Like many of techniques analyzed in this report, Scheduled Tasks are a functionally necessary component of the Windows operating system. They executes routinely, and malicious tasks readily blend in with benign ones."

## Prevalence
Red Canary's report finds that 33% of organizations are affected by Scheduled Task techniques. This corresponds to a probability distribution of ```Bernoulli(0.33)```. 

## Time to compromise
There are numerous attacks that use Scheduled Tasks. Two prominent ones are TrickBot and Emotet. These are discussed already in ```disablingSecurityTools.md```, and the following text is from those findings. There appears to be a few different version of this malware. According to one source, this malware will attempt trigger a task that repeats [every 11 minutes](https://labs.sentinelone.com/trickbot-update-brief-analysis-of-a-recent-trickbot-payload/). [Another source](https://www.wilbursecurity.com/2020/03/trickbot-to-ryuk-in-two-hours/) states that it occurs every 20 minutes. [Yet another source](https://www.trustwave.com/en-us/resources/blogs/spiderlabs-blog/tale-of-the-two-payloads-trickbot-and-nitol/) finds that it executes every 3 minutes. Emotet. According to an [intelligence report from esentire.com](https://www.esentire.com/assets/resourcefiles/eSentire-2019-Annual-Threat-Intelligence-Report-2019-Perspectives-and-2020-Predictions.pdf), emotet took 15 minutes to move to two additional hosts after compromising the initial patient zero. I think this could be interpreted as the time it needs to compromise a system in the first place.

There are numerous other malwares that make use of scheduled tasks. One is ```dlclient```, that according to [malwarebytes](https://blog.malwarebytes.com/cybercrime/2015/03/scheduled-tasks/) schedules to trigger every 10 minutes. 
Another type of malware that uses scheduled tasks is [dexphot](https://www.zdnet.com/article/microsoft-says-new-dexphot-malware-infected-more-than-80000-computers/). This runs every 90 or 110 minutes -> on average every 100 minutes.
Really, the TTC with malware making use of scheduled tasks can be highly variable because they depend on how often the malware's programmer wants it to run. As such I will simply use the average of those listed here for an estimate. (11+20+3+15+10+100) / 6 = 26.5 minutes. This is 54.3 times per day, so ```Exponential(54.3)```. 

## Results
This comes out to ```Bernoulli(0.33)*Exponential(54.3)```. 

