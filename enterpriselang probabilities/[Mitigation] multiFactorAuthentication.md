# [Mitigation, Multi-Factor Authentication](https://attack.mitre.org/mitigations/M1032/)

## Context
>Use two or more pieces of evidence to authenticate to a system; such as username and password in addition to a token from a physical smart card or token generator.

## Findings
I will attempt to find how effective multi factor authentication is at preventing AUTOMATED attacks. 

Google's Security Blog on ["New research: How effective is basic account hygiene at preventing hijacking "](https://security.googleblog.com/2019/05/new-research-how-effective-is-basic.html) finds that when it comes to using [SMS codes sent to a recovery phone number](https://www.google.com/intl/en/landing/2step/), this blocked 100% of automated bots, 96% of bulk phishing attacks. They also found [on device prompts](https://support.google.com/accounts/answer/7026266?co=GENIE.Platform%3DAndroid&hl=en) to be able to prevent 100% of bots, 99% of bulk phishing attacks. So according to google, on average multi factor authentication will prevent (100+100+99+96)/4 = 98.75% of automated attacks (all automated + bulk phishing).

[Another source from ZDNet](https://www.zdnet.com/article/microsoft-using-multi-factor-authentication-blocks-99-9-of-account-hacks/), reporting on findings from Microsoft finds that multi factor authentication is 99.9% effective against automated attacks. 

So the average of automated attacks comes out to [98.75 (google) + 99.9 (microsoft)]/2 = 99.325% of automated attacks. 

## Result
```Bernoulli(0.99325)```.

## Additional findings
I only included automated attacks here, but google's research includes data for targeted attacks as well (like spearphising). But I can't find spearphishing in MITRE ATT&CKs page on multi factor authentication, so I do not include it here. 