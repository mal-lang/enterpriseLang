# [BITS Jobs](https://attack.mitre.org/techniques/T1197/)

## Context
>Windows Background Intelligent Transfer Service (BITS) is a low-bandwidth, asynchronous file transfer mechanism exposed through Component Object Model (COM). BITS is commonly used by updaters, messengers, and other applications preferred to operate in the background (using available idle bandwidth) without interrupting other networked applications. File transfer tasks are implemented as BITS jobs, which contain a queue of one or more file operations.

## Findings
According to the MITRE ATT&CK matrix, most of the malicious procedure examples seem to make use of a Windows software called BITSAdmin. Two of the attacking groups that have made malicious use of this software are Leviathan and Tropic Trooper. In one [security intelligence report about Tropic Trooper](https://blog.trendmicro.com/trendlabs-security-intelligence/tropic-trooper-new-strategy/) we can find out that this malware relies on a windows feature called [Gadgets](https://en.wikipedia.org/wiki/Windows_Desktop_Gadgets). Gadgets is launched from a BITSAdmin command. So if we find the probability that Gadgets is abused, we can infer the probability that BITSAdmin can be successfully used to compromise a system. Gadgets was introduced in windows vista, and discontinued with the release of windows 8, so only exists in windows vista and windows 7. From this, we can use usage data on these windows versions to estimate the prevalence of being vulnerable to this particular attack. 
According to [statcounter.com](https://gs.statcounter.com/os-version-market-share/windows/desktop/worldwide), at the time of writing this (june 2020):
| Windows Version | Percentage of windows users |
| ----------- | ----------- |
| Windows 7      | 19.95%       |
| Windows Vista   | 0.44%    |
| Total | 20.39% |

In another source, [netmarketshare.com](https://netmarketshare.com/operating-system-market-share.aspx?options=%7B%22filter%22%3A%7B%22%24and%22%3A%5B%7B%22deviceType%22%3A%7B%22%24in%22%3A%5B%22Desktop%2Flaptop%22%5D%7D%7D%2C%7B%22platform%22%3A%7B%22%24in%22%3A%5B%22Windows%22%5D%7D%7D%5D%7D%2C%22dateLabel%22%3A%22Trend%22%2C%22attributes%22%3A%22share%22%2C%22group%22%3A%22platformVersion%22%2C%22sort%22%3A%7B%22share%22%3A-1%7D%2C%22id%22%3A%22platformsDesktopVersions%22%2C%22dateInterval%22%3A%22Monthly%22%2C%22dateStart%22%3A%222019-06%22%2C%22dateEnd%22%3A%222020-05%22%2C%22segments%22%3A%22-1000%22%7D), the shares look like this:
| Windows Version | Percentage of windows users |
| ----------- | ----------- |
| Windows 7      | 32.23%       |
| Windows Vista   | 0.15%    | 
| Total | 32.38% |

These are quite different, so we will use the average of the two. (20.39 + 32.38) / 2 = 26.385%. 

The information available about how Leviathan abuses BITSAdmin is much less detailed, and typically only states that [BITSAdmin is used to "download additional tools"](https://www.fireeye.com/blog/threat-research/2018/03/suspected-chinese-espionage-group-targeting-maritime-and-engineering-industries.html). As such I will use only the probability from Tropic Troopers prevalence. -> ~```Bernoulli(0.264)```. 

## Time to compromise
The attack chain that Tropic Trooper uses looks like [this](https://blog.trendmicro.com/trendlabs-security-intelligence/tropic-trooper-new-strategy/):
>1. Execute a command that exploits security flaws in (somewhat older versions of) microsoft office.
>2. download an installer package
>3. A system config file will drop a backdoor installer(userinstall.exe), then delete itself. The backdoor installer will drop a sidebar.exe file (a Windows Gadget Tool) and a malicious loader. **Userinstall.exe will abuse the BITSAdmin command-line tool to create a job and launch sidebar.exe.** (this is the part we care about when it comes to TTC!)
>4. The malicious loader will use dynamic-link library (DLL) hijacking — injecting malicious code into a process of a file/application — on sidebar.exe and launch dllhost.exe (a normal file). The loader will then inject a DLL backdoor into dllhost.exe.

From this, the only part where BITSAdmin is used is to create a job and launch sidebar.exe. This seems like it would be an essentially instantaneous operation. As such I will estimate the TTC for BITSJobs to be instant.

## Result
```Bernoulli(0.264)```