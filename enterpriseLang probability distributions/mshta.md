# [Mshta](https://attack.mitre.org/techniques/T1170/)

## Prevalence
According to [this site](https://lolbas-project.github.io/lolbas/Binaries/Mshta/), this mshta exploit does not work on Windows 10 versions 1903 or later (which was the May 2019 update). I couldn't find specific windows version usage share data, but according to [netmarketshare.com](https://netmarketshare.com/operating-system-market-share.aspx?options=%7B%22filter%22%3A%7B%22%24and%22%3A%5B%7B%22deviceType%22%3A%7B%22%24in%22%3A%5B%22Desktop%2Flaptop%22%5D%7D%7D%2C%7B%22platform%22%3A%7B%22%24in%22%3A%5B%22Windows%22%5D%7D%7D%5D%7D%2C%22dateLabel%22%3A%22Trend%22%2C%22attributes%22%3A%22share%22%2C%22group%22%3A%22platformVersion%22%2C%22sort%22%3A%7B%22share%22%3A-1%7D%2C%22id%22%3A%22platformsDesktopVersions%22%2C%22dateInterval%22%3A%22Monthly%22%2C%22dateStart%22%3A%222019-06%22%2C%22dateEnd%22%3A%222020-05%22%2C%22pageLength%22%3A100%2C%22segments%22%3A%22-1000%22%7D), 66.71% of windows users use windows 10. Combine this with the fact that windows 10 has automatic updates, I will assume that all windows 10 users are on an updated version with this vulnerability patched. This means that at least 33.29% of windows users are vulnerable to this attack (using versions of windows other than windows 10). This makes the prevalence of this attack come out to ```Bernoulli(0.3329)```. 

## Time to compromise
In this [blogpost by a member of Red Canary's Detection and Response Team Keith McCammon](https://redcanary.com/blog/microsoft-html-application-hta-abuse-part-deux/), we see how the first process that leads up to mshta.exe being called upon occurs at 18:33:04, and mshta.exe is triggered at 18:36:00, 2 minutes and 56 seconds later. We can use this to estimate the TTC. This becomes ~```Exponential(491)```. 

## Results
The probability distribution comes out to ```Bernoulli(0.3329)*Exponential(491)```.

## Discussion 
Here I assume that all windows 10 users are on version 1903 or later, probably there are some that have not updated to this version or beyond (despite the fact that windows 10 updates are automatic these days), so the true number of vulnerable users is probably higher. 