# [Credentials In Files](https://attack.mitre.org/techniques/T1552/001/)

## Context
>Adversaries may search local file systems and remote file shares for files containing insecurely stored credentials. These can be files created by users to store their own credentials, shared credential stores for a group of individuals, configuration files containing passwords for a system or service, or source code/binary files containing embedded passwords.

## Findings
In the [FireEye Mtrends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that 0.44% of all attack lifecycles include the "Credentials In Files" attack step. 

In the [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/publication/mitre-attack-securecomm19/), they find 12 malware samples that utilize the "credentials in files attack step", out of 951 total malware samples. This comes out to ~1.26%. 

In ["A 2019 Mid-Year Review From the CrowdStrike Falcon OverWatch Team"](https://www.crowdstrike.com/resources/reports/observations-from-the-front-lines-of-threat-hunting-2019/) has a color hue saturation of 13% (in the chart "OBSERVATIONS FROM THE FRONT LINES OF THREAT HUNTING" on the last page), and the most commonly observed technique ("Command Line Interface") was observed 52 times, and has a hue saturation of 85%. We previously found that "command line interface" had a prevalence of 24%. 13/85 = ~15.3%, so to extrapolate from this, 0.153*0.24 ~=0.0367. 

The average of these findings is (0.44 + 1.26 + 3.67) / 3 = 1.79%. -> ```Bernoulli(0.0179)```. 

## Time to compromise
According to the MITRE page, many malware recursively search through systems to find certain credentials in files. An example is [smoke loader](https://blog.talosintelligence.com/2018/07/smoking-guns-smoke-loader-learned-new.html#more), which is analyzed by talos intelligence, where they find that this malware recursively searches for, `logins.json` files. I tried to search through a 256GB SSD, with 176GB used up with the linux command `time find . -name "login*"` to try to simulate this behaviour. On my PC (with an intel i7 7500U 2.7Ghz CPU) this took 1 minute and 29 seconds to search through the entire C:\ drive for this term. According to [this](https://www.statista.com/statistics/751847/worldwide-seagate-western-digital-average-hard-drive-capacity/) statistic, the average HDD size is closer to 1.4TB, which would be 1400/256 = ~5.5, so 89 seconds * 5.5 =  ~490 seconds. however this doesn't include SSDs. According to [this](https://www.hardware-revolution.com/how-much-storage-capacity-do-i-need-for-my-computer-2020/), the average prize per GB for an SSD is about 4x that of an HDD, so let's estimate that the average SSd size is 1.4TB/4 = 350GB. 350/256 = 1.3671875, 89 * 1.3671875 = ~122 seconds.

So, the average time to complete this attack step on an HDD would be 490 seconds, and 122 seconds on an SSD... Let's take the average time between these two, (490 + 122)/ = 306. 1 day / 306 seconds = ~282, so ```Exponential(282)```. 

## Result
```Bernoulli(0.0179)*Exponential(282)```.