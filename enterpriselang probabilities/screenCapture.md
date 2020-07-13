# [Screen Capture](https://attack.mitre.org/techniques/T1113/)

## Context
>Adversaries may attempt to take screen captures of the desktop to gather information over the course of an operation. Screen capturing functionality may be included as a feature of a remote access tool used in post-compromise operations. Taking a screenshot is also typically possible through native utilities or API calls, such as `CopyFromScreen`, `xwd`, or `screencapture`.

## Findings
There are 100 pieces of software that can do this attack step listed on MITRE ATT&CK. Out of 477 total, we can estimate that 100/477 = ~20.96% of all malware have this capability. -> ```Bernoulli(0.2096)```

## Time to compromise
Since this attack step is possible to complete through "native utilities or API calls", I estimate that this is instant.

## Result
```Bernoulli(0.2096)```

## Discussion
This attack prevalence is not complete and should be updated with new information, however I am unable to find any prevalence information at the moment. 