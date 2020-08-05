# [Bootkit]()

## Context

## Findings
There are several types of malware that use bootkits to achieve persisitence. One such malware is Downdelph, deployed by threat group APT28. In a [very comprehensive source from ESET](https://www.eset.com/afr/about/newsroom/press-releases-afr/research/dissection-of-sednit-espionage-group-1/), they state that Downdelph "... has the ability to infect Microsoft Windows versions from Windows XP to Windows 7, on both 32-bit and 64-bit architectures". This means that any other windows OS is safe from this particular malware. According to [statcounter.com](https://gs.statcounter.com/os-version-market-share/windows/desktop/worldwide), at the time of writing this (june 2020):
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

I'm not sure which of these is more trustworthy, so to get an estimate I will use the average of the two. (21.26 + 34.07) / 2 = 27.665% is the chance of being vulnerable to Downdelph. 

Another type of bootkit malware is BOOTRASH, detailed [here](https://www.fireeye.com/blog/threat-research/2015/12/fin1-targets-boot-record.html) in a post by FireEye on the malware. They state that a prerequisite of the malware is Microsofts .NET version 3.5. I found an old source, from 2010 stating that [65% of PCs have .NET 3.5](https://www.hanselman.com/blog/HowManyPCsInTheWorldHaveTheNETFrameworkInstalled.aspx) installed. This might be out of date at this point, however, I will use this as an estimate. 

Combining these two different bootkits and how likely they are to work, you get (27.665 + 65)/2 = 46.3325%. I will use this as the likelihood of being vulnerable to bootkits. This corresponds to ~```Bernoulli(0.46)```

## Time to compromise
In the installation process detailed in [ESET's dissection of the malware](https://www.eset.com/afr/about/newsroom/press-releases-afr/research/dissection-of-sednit-espionage-group-1/), we can see how the Downdelph malware will first establish device access, then call a windows API function (WriteFile) to overwrite the hard drives sectors. The installer also stores a DLL in a newly created windows registry key, and stores Downdelph itself in the same registry path. And that's basically it, it seems like the entire process would take a few seconds at most, so I will assume the TTC to be instant. 

## Result
```Bernoulli(0.46)```

## Discussion
Some of the data used to sample probabilities here is a bit old, and you could also sample more bootkits to get better distribution results. For now I think this is a decent enough estimate. 