# [Bypass User Account Control](https://attack.mitre.org/techniques/T1088/)

## Context
Windows User Account Control (UAC) allows a program to elevate its privileges to perform a task under administrator-level permissions by prompting the user for confirmation. The impact to the user ranges from denying the operation under high enforcement to allowing the user to perform the action if they are in the local administrators group and click through the prompt or allowing them to enter an administrator password to complete the action.

## Findings
There are according to the MITRE ATT&CK matrix a LOT of different procedures that make use of this kind of vulnerability.

### AutoIt Backdoor
One of these is procedures is [autoIt backdoor](https://attack.mitre.org/software/S0129/). This was used by Monsoon, investigated by Forcepoint [here](https://www.forcepoint.com/sites/default/files/resources/files/forcepoint-security-labs-monsoon-analysis-report.pdf). Notably, in this report it seems like AutoIt backdoors are primarily dropped by weaponised documents using [CVE-2014-6352](https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2014-6352), which affects the following operating systems: Microsoft Windows Vista SP2, Windows Server 2008 SP2 and R2 SP1, Windows 7 SP1, Windows 8, Windows 8.1, Windows Server 2012 Gold and R2, and Windows RT Gold and 8.1. 

From this, we can use usage data on these windows versions to estimate the prevalence of being vulnerable to this particular attack. Unfortunately the sources I found does not include versions as specific as which service pack is used, and also doesn't include windows server data, so I will only include desktop versions of windows. 
According to [statcounter.com](https://gs.statcounter.com/os-version-market-share/windows/desktop/worldwide), at the time of writing this (june 2020):
| Windows Version | Percentage of windows users |
| ----------- | ----------- |
| Windows 7      | 19.95%       |
| Windows Vista   | 0.44%    |
| Windows 8   | 1.09%    |
| Windows 8.1  |   4.7% |
| Total | 26.18% |

In another source, [netmarketshare.com](https://netmarketshare.com/operating-system-market-share.aspx?options=%7B%22filter%22%3A%7B%22%24and%22%3A%5B%7B%22deviceType%22%3A%7B%22%24in%22%3A%5B%22Desktop%2Flaptop%22%5D%7D%7D%2C%7B%22platform%22%3A%7B%22%24in%22%3A%5B%22Windows%22%5D%7D%7D%5D%7D%2C%22dateLabel%22%3A%22Trend%22%2C%22attributes%22%3A%22share%22%2C%22group%22%3A%22platformVersion%22%2C%22sort%22%3A%7B%22share%22%3A-1%7D%2C%22id%22%3A%22platformsDesktopVersions%22%2C%22dateInterval%22%3A%22Monthly%22%2C%22dateStart%22%3A%222019-06%22%2C%22dateEnd%22%3A%222020-05%22%2C%22segments%22%3A%22-1000%22%7D), the shares look like this:
| Windows Version | Percentage of windows users |
| ----------- | ----------- |
| Windows 7      | 32.23%       |
| Windows Vista   | 0.15%    | 
| Windows 8   | 0.68%    |
| Windows 8.1  |   4.15% |
| Total | 37.21% |

The average becomes (26.18 + 37.21) / 2 = 31.695%. 

### Downdelph
Another malware that can perform UAC bypass is Downdelph. Downdelph has been seen deployed by threat group APT28. In a [very comprehensive source from ESET](https://www.eset.com/afr/about/newsroom/press-releases-afr/research/dissection-of-sednit-espionage-group-1/), they state that Downdelph "... has the ability to infect Microsoft Windows versions from Windows XP to Windows 7, on both 32-bit and 64-bit architectures". This means that any other windows OS is safe from this particular malware. According to [statcounter.com](https://gs.statcounter.com/os-version-market-share/windows/desktop/worldwide), at the time of writing this (june 2020):
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

I will use the average of the two to get an estimate. (21.26 + 34.07) / 2 = 27.665% is the chance of being vulnerable to Downdelph. 

The average of AutoIt backdoor and DownDelph, you get (31.695 + 27.665)/2 = 29.68 -> ```Bernoulli(0.2968)```.

## Time to compromise
### AutoIt backdoor
The previously mentioned [Forcepoint Monsoon investigation](https://www.forcepoint.com/sites/default/files/resources/files/forcepoint-security-labs-monsoon-analysis-report.pdf) has an overview of how the malware performs its Bypass User Account Control, and this is done in one of two ways depending on if the OS is 32 or 64 bit. If it's 64 bit, 
>"the malware will use the Windows Update Standalone Installer (WUSA) to copy its DLL into a protected folder (C:\Windows\System32\oobe) with the name wdscore.dll. It will then execute oobe.exe which will side-load the malicious wdscore.dll instead of the one from the system directory". 

If it's 32 bit, 
>"the CallWindowProcW API to jump into some shellcode that will inject the UAC bypass executable into Svchost.exe. Firstly, the legitimate Windows "Computer Management.lnk" file is overwritten with a new version using Leo Davidson's IFileOperation 14 code. This links to the original malware executable. Secondly, the malware will execute CompMgmtLauncher.exe which in turn will execute the copied shortcut as an elevated process."

These both seem like very quick processes and as such I estimate the TTC to be instant. 
### Downdelph
In the installation process detailed in [ESET's dissection of the malware](https://www.eset.com/afr/about/newsroom/press-releases-afr/research/dissection-of-sednit-espionage-group-1/), we can see how the Downdelph malware will first establish device access, then call a windows API function (WriteFile) to overwrite the hard drives sectors. The installer also stores a DLL in a newly created windows registry key, and stores Downdelph itself in the same registry path. It seems like the entire process would take a few seconds at most, so I will assume the TTC to be instant. 

TTC result: Instant

## Result
```Bernoulli(0.2968)```.

## Discussion
There are a vast number of ways, both historical and current, to perform Bypass User Account Control, and as such the likelihood of being affected by this particular attack step is probably much higher, see [UACMe](https://github.com/hfiref0x/UACME) for the various vulnerabilities. Also, in this text I simply got the average chance of downdelph and autoIt backdoor, in reality there may be no overlap between these two and the users vulnerable to each may be completely disjoint and as such the likelihood would be much higher. For now I'm using the result as an estimate, it should be decent but of course not perfect.  

## Additional Sources
[UACMe](https://github.com/hfiref0x/UACME) an open source assessment tool that contains many methods for bypassing Windows Account User Control. 