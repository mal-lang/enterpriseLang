# [Service Stop](https://attack.mitre.org/techniques/T1489/)

## Context
>Adversaries may stop or disable services on a system to render those services unavailable to legitimate users. Stopping critical services can inhibit or stop response to an incident or aid in the adversary's overall objectives to cause damage to the environment.

## Findings
In the [FireEye Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that Service Stop as an attack technique was included in 8.37% of all attack lifecycles. This corresponds to ```Bernoulli(0.0837)```. 

## Time to compromise
The malware [Olympic Destroyer](https://blog.talosintelligence.com/2018/02/olympic-destroyer.html) uses the API [ChangeServiceConfigW](https://docs.microsoft.com/en-us/windows/win32/api/winsvc/nf-winsvc-changeserviceconfigw) with the value 0x00000004, which disables the service. According to microsoft, "Attempts to start the service result in the error code ERROR_SERVICE_DISABLED.".

Similar to this process, [WannaCry](https://www.fireeye.com/blog/threat-research/2017/05/wannacry-malware-profile.html) will kill some services, for example Exchange with 

```
taskkill.exe /f /im Microsoft.Exchange.\*
```

in order to make it possible to encrypt their data stores. The malware [Ryuk](https://www.crowdstrike.com/blog/big-game-hunting-with-ryuk-another-lucrative-targeted-ransomware/) does something similar, with a batch file called `kill.bat`, which among other things stops services. It does this in order to "... ensure no open handles exist for files that will be encrypted", like WannaCry does too. An example command in `kill.bat` is
```
 net stop NetBackup BMR MTFTP Service /y
```

Since this is just using API calls to disable/stop services, I am assuming it to be an instantaneous attack step.

## Result
```Bernoulli(0.0837)```

## Discusison
Ideally we want another source for the prevalence, one is not really enough. 