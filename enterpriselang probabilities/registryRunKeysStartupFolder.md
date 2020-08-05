# [Registry Run Keys / Startup Folder](https://attack.mitre.org/techniques/T1060/)

## Context
>Adding an entry to the "run keys" in the Registry or startup folder will cause the program referenced to be executed when a user logs in. These programs will be executed under the context of the user and will have the account's associated permissions level.

## Findings
One source from [Barkly](https://dsimg.ubm-us.net/envelope/395823/551993/Fileless%20Attack%20Survival%20Guide.pdf) states that "77 percent of successful compromises in 2017 involved fileless techniques." This means that 77% of all successful malware uses fileless techniques in some way, and using registry run keys is just one type of fileless attack. To make a rough estimate on how many of these were registry run key type attacks specifically, the same source from barkly states that there are generally 4 types of fileless attacks, where registry run keys is one of them. So I will estimate that 1/4th of this 77% was registry run keys being used specifically. 77/4 = 19.25%. So for this source I will estimate that in total, 19.25% of attacks will use registry run keys or startup folder to propagate their attacks. 

Another source from vmware's Carbon Black [2020 Cyber Security Outlook Report](https://content.carbonblack.com/c/vmwcb-threat-report-?x=f_lWMB), 15% of malware uses Registry Run Keys in the Startup Folder for Persistence. This corresponds to ```Bernoulli(0.15)```. Getting the average of these two results in (0.15+0.1925)/2 = 17.125 -> ```Bernoulli(0.17125)```

## Time to compromise
Since this attack only changes values in the windows registry, it could probably safely be assumed to be an instantaneous operation. Thus TTC is estimated to be instant. 

## Result
```Bernoulli(0.17125)```. 

