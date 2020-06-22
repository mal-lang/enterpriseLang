# [PowerShell](https://attack.mitre.org/techniques/T1086/)
PowerShell is a powerful interactive command-line interface and scripting environment included in the Windows operating system. Adversaries can use PowerShell to perform a number of actions, including discovery of information and execution of code. Examples include the Start-Process cmdlet which can be used to run an executable and the Invoke-Command cmdlet which runs a command locally or on a remote computer. 

The range of things that PowerShell can do is very wide, but according to [Red Canary's 2020 Threat Detection Report](https://redcanary.com/threat-detection-report/techniques/powershell/), this vulnerability is most commonly used to remotely execute scripts and payloads. 

## Prevalence of vulnerabilities posed by PowerShell 
Also in [Red Canary's 2020 Threat Detection Report](https://redcanary.com/threat-detection-report/techniques/powershell/), 55% of organizations are affected by it. -> ```Bernoulli(0.55)```.

## Time to compromise
Since this vulnerability is used in so many different types of attacks, I will look at the time needed to execute scripts and payloads and find some kind of average. 

To remotely execute scripts, the time to compromise is the time it takes to run the script/payload. This is of course highly variable depending on the script used. According to one source from [ArcticWolf](https://arcticwolf.com/resources/white-papers/ransomware-infection-to-encryption-three-seconds), a security operations organization, that time is only 3 seconds. Even if you include the time it would take for a hacker to type the powershell commands needed to execute the script remotely, this is still just a few seconds total. Compared to the time scale used, days, this is nearly instant. 3 seconds is 3.472×10^-5. This is essentially instantaneous. 

this step focuses only on how powershell is utilized as an attack step. For those purposes, this step can be seen as only concerning the time it takes to type commands into powershell, which would also be a few seconds which can be seen as instant. 

## Result
The TTC seems to be (nearly) instant, so the total probability distribution is ```Bernoulli(0.55)```. If you want, you can add an ```Exponential(28800)``` to it, but I don't think this is necessary. 