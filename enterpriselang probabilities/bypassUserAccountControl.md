# [Bypass User Account Control](https://attack.mitre.org/techniques/T1088/)

## Context
Windows User Account Control (UAC) allows a program to elevate its privileges to perform a task under administrator-level permissions by prompting the user for confirmation. The impact to the user ranges from denying the operation under high enforcement to allowing the user to perform the action if they are in the local administrators group and click through the prompt or allowing them to enter an administrator password to complete the action.

## Findings
There are according to the MITRE ATT&CK matrix a LOT of different procedures that make use of this kind of vulnerability. I will investigate the prevalence of one software called downdelph, and assume this % of vulnerable users also hold for the entire "Bypass user account control". 

### Downdelph
Downdelph has been seen deployed by threat group APT28. In a [very comprehensive source from ESET](https://www.eset.com/afr/about/newsroom/press-releases-afr/research/dissection-of-sednit-espionage-group-1/), they state that Downdelph "... has the ability to infect Microsoft Windows versions from Windows XP to Windows 7, on both 32-bit and 64-bit architectures". This means that any other windows OS is safe from this particular malware. According to [statcounter.com](https://gs.statcounter.com/os-version-market-share/windows/desktop/worldwide), at the time of writing this (june 2020):
| Windows Version | Percentage of windows users |
| ----------- | ----------- |
| Windows 7      | 19.95%       |
| Windows Vista   | 0.44%    |
| Windows XP  | 0.87%      | 
| Total | 21.26% |

Another source, [netmarketshare.com](https://netmarketshare.com/operating-system-market-share.aspx?options=%7B%22filter%22%3A%7B%22%24and%22%3A%5B%7B%22deviceType%22%3A%7B%22%24in%22%3A%5B%22Desktop%2Flaptop%22%5D%7D%7D%2C%7B%22platform%22%3A%7B%22%24in%22%3A%5B%22Windows%22%5D%7D%7D%5D%7D%2C%22dateLabel%22%3A%22Trend%22%2C%22attributes%22%3A%22share%22%2C%22group%22%3A%22platformVersion%22%2C%22sort%22%3A%7B%22share%22%3A-1%7D%2C%22id%22%3A%22platformsDesktopVersions%22%2C%22dateInterval%22%3A%22Monthly%22%2C%22dateStart%22%3A%222019-06%22%2C%22dateEnd%22%3A%222020-05%22%2C%22segments%22%3A%22-1000%22%7D), the shares look like this:
| Windows Version | Percentage of windows users |
| ----------- | ----------- |
| Windows 7      | 32.23%       |
| Windows Vista   | 0.15%    |
| Windows XP  | 1.69%      | 
| Total | 34.07% |

I will use the average of the two to get an estimate. (21.26 + 34.07) / 2 = 27.665% is the chance of being vulnerable to Downdelph. -> ~```Bernoulli(0.277)```.

## Time to compromise
### Downdelph
In the installation process detailed in [ESET's dissection of the malware](https://www.eset.com/afr/about/newsroom/press-releases-afr/research/dissection-of-sednit-espionage-group-1/), we can see how the Downdelph malware will first establish device access, then call a windows API function (WriteFile) to overwrite the hard drives sectors. The installer also stores a DLL in a newly created windows registry key, and stores Downdelph itself in the same registry path. It seems like the entire process would take a few seconds at most, so I will assume the TTC to be instant. 

TTC result: Instant

## Result
```Bernoulli(0.277)```.

## Discussion
There are a vast number of ways, both historical and current, to perform Bypass User Account Control, and as such the likelihood of being affected by this particular attack step is probably much higher, see [UACMe](https://github.com/hfiref0x/UACME) for the various vulnerabilities. Also, in this text I simply got the average chance of downdelph and autoIt backdoor, in reality there may be no overlap between these two and the users vulnerable to each may be completely disjoint and as such the likelihood would be much higher. For now I'm using the result as an estimate, it should be decent but of course not perfect.  

## Additional Sources
[UACMe](https://github.com/hfiref0x/UACME) an open source assessment tool that contains many methods for bypassing Windows Account User Control. 