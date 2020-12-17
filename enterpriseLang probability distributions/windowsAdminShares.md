# [Windows Admin Shares](https://attack.mitre.org/techniques/T1077/)
Windows systems have hidden network shares that are accessible only to administrators and provide the ability for remote file copy and other administrative functions. Example network shares include C$, ADMIN$, and IPC$. 

According to [Red Canary's Threat Detection Report 2020](https://redcanary.com/threat-detection-report/techniques/windows-admin-shares/), "Windows Admin Shares are enabled by default on most Windows systems, and administrators regularly use them to conduct remote host management. Since Windows Admin Share activity is so common, it provides adversaries with a powerful, discreet way to move laterally within an environment. Self-propagating ransomware and cryptocurrency miners, both rapidly emerging threats, rely on Windows Admin Shares."
## Prevalence
Also according to the source by Red Canary is the prevalence of this threat. Reportedly, 28% of organizations are affected. This corresponds to ```Bernoulli(0.28)```.

## Time to compromise
One tool that leverages Windows Admin Shares, is PsExec. In [this article published in 2018 by Daniel Muñoz on contextis.com](https://www.contextis.com/us/blog/lateral-movement-a-deep-look-into-psexec), the entire process of using PsExec takes a mere 21 seconds from start to finish (as can be seen in the pictures of the process in wireshark in the article). This is a very short time and corresponds to ```Exponential(4114)```. 

## Results
The result of these findings indicate that Windows Admin Shares gets a probability distribution of ```Bernoulli(0.28)*Exponential(4114)```

## Discussion
The TTC is so fast, that maybe it can be ignored and interpreted as occuring instantly. 

It also does require the need of administrator credentials, the time to acquire these is not included in this distribution. This is taken care of already in enterpriselang.mal, because the only way to get to this attack step is if you already have gone through the steps of acquiring these credentials. 

Also, there are a lot of different ways to achieve this attack step, other than just PsExec. Perhaps other tools leveraging Windows Admin Shares are a lot slower? I could not find information of this though. That said the other tools seem to be similar in their function and I expect they should take similar time to use. 