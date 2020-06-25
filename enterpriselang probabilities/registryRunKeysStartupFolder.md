# [Registry Run Keys / Startup Folder](https://attack.mitre.org/techniques/T1060/)

## Context
>Adding an entry to the "run keys" in the Registry or startup folder will cause the program referenced to be executed when a user logs in. These programs will be executed under the context of the user and will have the account's associated permissions level.

## Findings
According to unpublished data on the top 50 MITRE ATT&CK threat techniques compiled by Red Canary, this particular technique affects 13% of organizations. As such, we can infer that the estimated probability of on average being vulnerable to this attack, is also 13%. Another source from [Barkly](https://dsimg.ubm-us.net/envelope/395823/551993/Fileless%20Attack%20Survival%20Guide.pdf) states that "42 percent of organizations experienced one or more fileless attacks that successfully
compromised their data or IT infrastructure in 2017." Now, fileless attacks are quite a bit more broad, and using registry run keys is just one type of fileless attack. To make a rough estimate on how many of these were registry run key type attacks specifically, the same source from barkly states that there are generally 4 types of fileless attacks, where registry run keys is one of them. So I will estimate that 1/4th of this 42% was registry run keys being used specifically. 42/4 = 10.5%. To get an average of these 2 values, (13 + 10.5) / 2 = 11.75. So I will estimate that in total, 11.75% of users will be vulnerable to this kind of attack. ```Bernoulli(0.1175)```

## Time to compromise
Since this attack only changes values in the windows registry, it could probably safely be assumed to be an instantaneous operation. Thus TTC is estimated to be instant. 

## Result
```Bernoulli(0.1175)```. 

