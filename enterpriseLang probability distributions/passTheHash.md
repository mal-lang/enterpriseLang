# [Pass the Hash](https://attack.mitre.org/techniques/T1075/)

## Context
Pass the hash (PtH) is a method of authenticating as a user without having access to the user's cleartext password. This method bypasses standard authentication steps that require a cleartext password, moving directly into the portion of the authentication that uses the password hash. In this technique, valid password hashes for the account being used are captured using a Credential Access technique. Captured hashes are used with PtH to authenticate as that user. Once authenticated, PtH may be used to perform actions on local or remote systems. 

## Findings
In an article from [securityweek.com](https://www.securityweek.com/pass-hash-remains-poorly-defended-threat-vector), they find that 13% of respondents in a study have no plans to combat Pass the hash attacks. The same source reports that in larger companies (>5000 employees), 26% have definitely or probably been affected by the attack, medium companies (2500 to 5000 employees) 19% have definitely or probably, and smaller (<2500 employees) 12%. If we find the average of the different sizes of companies, we get that (26 + 19 + 12) / 3 = 19%. So, now we have a value for those with no plans to combat pass the hash attacks, i.e. those that are vulnerable to the attack, and those that have probably been affected by the attack. I think if we get the average of these two, it would be a decent representation of the prevalence of this attack. (19 + 13) / 2 = 16. I will as such estimate that the prevalence is 16% -> ```Bernoulli(0.16)```. 

## Time to compromise
In [this video](https://www.youtube.com/watch?v=6em5TUASfHM), they perform a pass the hash attack from about 2:30 to 8:30, so 6 minutes. Since it is a tutorial, the speaker is probably going a lot slower than she would if she was doing the attack in a real scenario. I will thus assume that it takes 3 minutes, half that time, to actually perform the attack fully. In another [video tutorial](https://www.youtube.com/watch?v=bTYR_xYSDIk), the time taken to perform the attack is just under 3 minutes. Overall, I will estimate a TTC for 3 minutes, which is ```Exponential(480)```. 

## Result
```Bernoulli(0.16)*Exponential(480)```