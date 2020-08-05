# [Browser Bookmark Discovery](https://attack.mitre.org/techniques/T1217/)

## Context
>Adversaries may enumerate browser bookmarks to learn more about compromised hosts. Browser bookmarks may reveal personal information about users (ex: banking sites, interests, social media, etc.) as well as details about internal network resources such as servers, tools/dashboards, or other related infrastructure.

## Findings

### Calisto
According to the MITRE ATT&CK page on this attack step, [Calisto](https://attack.mitre.org/software/S0274/) uses this attack step. In [this technical analysis of Calisto by Securelist](https://securelist.com/calisto-trojan-for-macos/86543/) they find that this particular malware is not able to be installed on Mac PCs with System Integrity Protection enabled. According to the Wikipedia page on [System Integrity Protection (SIP)](https://en.wikipedia.org/wiki/System_Integrity_Protection), this is enabled by default on Mac PCs version [OSX 10.11 (el capitan)](https://en.wikipedia.org/wiki/OS_X_El_Capitan) and later. Apparently, it can be disabled, but I will for simplicity's sake assume that everyone with that version has it enabled. According to [stacounter.com](https://gs.statcounter.com/macos-version-market-share/desktop/worldwide/#monthly-201906-202006), Only 2.92% of Mac OS users use version 10.10, every other user is on a newer version. According to [statista](https://www.statista.com/statistics/944559/worldwide-macos-version-market-share/), on the latest datapoint that includes 100% of users was september 2019, where 8.44% of users used an earlier version. [netmarketshare.com](https://netmarketshare.com/operating-system-market-share.aspx?options=%7B%22filter%22%3A%7B%22%24and%22%3A%5B%7B%22deviceType%22%3A%7B%22%24in%22%3A%5B%22Desktop%2Flaptop%22%5D%7D%7D%2C%7B%22platform%22%3A%7B%22%24in%22%3A%5B%22Mac%20OS%22%5D%7D%7D%5D%7D%2C%22dateLabel%22%3A%22Trend%22%2C%22attributes%22%3A%22share%22%2C%22group%22%3A%22platformVersion%22%2C%22sort%22%3A%7B%22share%22%3A-1%7D%2C%22id%22%3A%22platformsDesktopVersions%22%2C%22dateInterval%22%3A%22Monthly%22%2C%22dateStart%22%3A%222019-07%22%2C%22dateEnd%22%3A%222020-06%22%2C%22segments%22%3A%22-1000%22%7D) gets it to 4.5%. If we use the average of these, we find that (4.5 + 8.44 + 2.92) / 3 = ~5.29% of Mac OS users will be vulnerable to this malware which includes the Browser Bookmark Discovery attack step. 

Another thing I will do to estimate how common this attack step is use the number of example software procedures against all the software procedures listed by MITRE ATT&CK. There are [4](https://attack.mitre.org/techniques/T1217/) example procedures and [477](https://attack.mitre.org/software/) total. ~0.84%. 

(5.29 + 0.84) / 2 = 3.065. 

## Time to compromise
In [ESET's](https://www.welivesecurity.com/wp-content/uploads/2019/08/ESET_Machete.pdf) analysis of a malware called Machete, they find that the browser bookmark discovery portion occurs in a process called `_clypes.pyw`. This process occurs at 9 am, 1 pm, 6 pm, 9 pm, so 4 times per day. It checks for Chrome, Firefox, Opera and Internet Explorer. I will use this as the TTC for this attack step. -> ```Exponential(4)```. 

## Result
```Bernoulli(0.03065)*Exponential(4)```. 
