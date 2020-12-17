# [Mutli-Hop Proxy](https://attack.mitre.org/techniques/T1090/003/)

## Context
>To disguise the source of malicious traffic, adversaries may chain together multiple proxies. Typically, a defender will be able to identify the last proxy traffic traversed before it enters their network; the defender may or may not be able to identify any previous proxies before the last-hop proxy. This technique makes identifying the original source of the malicious traffic even more difficult by requiring the defender to trace malicious traffic through several proxies to identify its source.

## Findings
According to [FireEyes Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), Multi-hop proxies are used in 2.2% of all attack lifecycles. 

In [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/) they find that mutli-hop proxies are used in 10 samples out of 951 total, which is ~1.05%. 

In ["A 2019 Mid-Year Review From the CrowdStrike Falcon OverWatch Team"](https://www.crowdstrike.com/resources/reports/observations-from-the-front-lines-of-threat-hunting-2019/) this attack technique is observed once, and the most commonly observed technique ("Command Line Interface") was observed 52 times. We previously found that "command line interface" had a prevalence of 24%. 1/52 is 1.923%, so to extrapolate from this, 0.01923*0.24 =0.46%. 

To estimate the prevalence of this attack step I use the average of these three findings is (2.2 + 1.05 + 0.46) / 3 = ~1.24%. -> ```Bernoulli(0.0124)```. 

## Time to compromise
One of the pieces of malware that make use of a multi-hop proxy is [Dok](https://attack.mitre.org/software/S0281/). It does this, according to a blog called [objective-see.com](https://objective-see.com/blog/blog_0x25.html), by first installing Homebrew which is in turn used to install TOR (which is used for this attack step). [Homebrew](https://github.com/Homebrew/brew) itself is 2.6MB at the time of writing. [TOR](https://www.torproject.org/download/) is 63.9 MB. Combined, Dok needs to download (and install) 63.9 + 2.6 = 66.5 MBs in order to achieve multi-hop proxy functionality. According to [cable.co.uk](https://www.cable.co.uk/broadband/speed/worldwide-speed-league/) the global average internet speed is 11.03 Mbps, which is 1.37875 MB/s, so 66.5MB would take ~48 seconds to download. For estimates sake, I will assume it takes another 12 seconds to install everything, so this comes out to 60 seconds in total to perform this attack step. 

Another malware that uses Tor is [WannaCry](https://www.secureworks.com/research/wcry-ransomware-analysis). It seemingly doesn't install homebrew, which Dok does, but since Tor is the vast majority of the install size I will assume that the TTC for WannaCry (and other malwares using this attack step) is also ~ 1 minute. This comes out to ```Exponential(1440)```. 

Of course, this is the estimated time necessary to **set up** this attack step. Another way to look at the time to compromise could be how long the multi-hop proxy is in place before it's discovered and removed. 

## Result
```Bernoulli(0.0124)*Exponential(1440)```