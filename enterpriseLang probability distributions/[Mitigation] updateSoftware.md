# [[Mitigation] Update Software](https://attack.mitre.org/mitigations/M1051/)

## Context
>Perform regular software updates to mitigate exploitation risk.

These findings are concerned with how prevalent updating software is among organizations. This means that for example, a value of Bernoulli(0.5) would mean that 50% of organizations do have up to date software, and this should not be interpreted as "how likely is up to date software to work, when it comes to preventing vulnerabilities". 

## Findings
In a [report](https://www.bitsight.com/press-releases/thousands-organizations-run-majority-of-computers-onoutdated-operating-systems) published by bitsight in 2017, they find that ~40% use the (at the time of writing the report, march 2017) latest major release of the Mac OSX operating system.

In another [report](https://cdn2.hubspot.net/hubfs/486579/Avast_PC_Trends_Report_2019.pdf) published by Avast, they find that 55% of all users use out of date software on their PCs, which makes them vulnerable to security issues, which means that 45% are using updated systems. 

Regarding windows, [netmarketshare](https://netmarketshare.com/operating-system-market-share.aspx?options=%7B%22filter%22%3A%7B%22%24and%22%3A%5B%7B%22deviceType%22%3A%7B%22%24in%22%3A%5B%22Desktop%2Flaptop%22%5D%7D%7D%2C%7B%22platform%22%3A%7B%22%24in%22%3A%5B%22Windows%22%5D%7D%7D%5D%7D%2C%22dateLabel%22%3A%22Trend%22%2C%22attributes%22%3A%22share%22%2C%22group%22%3A%22platformVersion%22%2C%22sort%22%3A%7B%22share%22%3A-1%7D%2C%22id%22%3A%22platformsDesktopVersions%22%2C%22dateInterval%22%3A%22Monthly%22%2C%22dateStart%22%3A%222019-07%22%2C%22dateEnd%22%3A%222020-06%22%2C%22segments%22%3A%22-1000%22%7D) finds that 62.36% of windows PCs are running the latest major windows release, windows 10. 

Meanwhile, [statcounter](https://gs.statcounter.com/windows-version-market-share/desktop/worldwide/#monthly-201906-202006) finds that 73.34% of windows PCs are running windows 10. These two sources regarding windows display some disrepancy in their results, so To find the average amount of users running up to date windows versions, (73.34 + 62.36) / 2 = 67.85. 

A [study of web browsers](https://www.darkreading.com/mobile/more-than-half-of-android-devices-run-outdated-browsers/d/d-id/1327483) finds that 42% of devices studied had out of date web browsers, which means 58% were up to date. 

A study from [google](https://www.usenix.org/system/files/conference/soups2015/soups15-paper-ion.pdf) found that 64% of experts had installed software updates automatically or immediately, while non-experts had the same statistic at 34%. 

A study from Kaspersky, published in [pcworld](https://www.pcworld.com/article/2013737/out-of-date-vulnerable-browsers-put-users-at-risk.html) finds that 77% of browsers are current/up to date.

I will use all of these data points to create a normal distribution to find how many are using up to date software, meaning how prevalent is this mitigation. 

The average of all these data points is 56.7125. The standard deviation is ~14.6. Since MAL only supports a truncated version of the normal distribution, I will use that. This means we get ```TruncatedNormal(56.7125,14.6)``` as the prevalence for this mitigation. 

## result
```TruncatedNormal(56.7125,14.6)```

## Discussion 
As I stated in the context section, for this mitigation I used the total prevalence of the mitigation existing, rather than the likelihood of the prevalence working as a mitigation. This is because I am assuming that each updated version of a software is released with the specific function of mitigating a particular vulnerability, so the updated software has an assumed 100% chance to work as a mitigation. Of course this probably is not entirely in line with reality, it's probably not quite 100% since sometimes the updated software might not work as intended and still leave the same security holes, but I felt that this was a more interesting statistic to gather. 