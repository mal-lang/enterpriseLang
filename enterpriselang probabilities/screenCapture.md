# [Screen Capture](https://attack.mitre.org/techniques/T1113/)

## Context
>Adversaries may attempt to take screen captures of the desktop to gather information over the course of an operation. Screen capturing functionality may be included as a feature of a remote access tool used in post-compromise operations. Taking a screenshot is also typically possible through native utilities or API calls, such as `CopyFromScreen`, `xwd`, or `screencapture`.

## Findings
There are 100 pieces of software that can do this attack step listed on MITRE ATT&CK. Out of 477 total, we can estimate that 100/477 = ~20.96% of all malware have this capability. -> ```Bernoulli(0.2096)```

## Update 
### 1
https://capec.mitre.org/data/definitions/648.html
This attack can be performed from a remote software installed by the adversary or through CLI. IT doesn't require any skill, as once the adversary has logical access (which can potentially require high knowledge and skill level), the adversary needs only to leverage the relevant command for screen capture.
No specialized resources are required to execute this type of attack either.

## Time to compromise
Since this attack step is possible to complete through "native utilities or API calls", I estimate that this is instant.

## Result
We assess this probability distribution as binary.