# [Data Encrypted](https://attack.mitre.org/techniques/T1022/)

## Context
>Data is encrypted before being exfiltrated in order to hide the information that is being exfiltrated from detection or to make the exfiltration less conspicuous upon inspection by a defender. The encryption is performed by a utility, programming library, or custom algorithm on the data itself and is considered separate from any encryption performed by the command and control or file transfer protocol. Common file archive formats that can encrypt files are RAR and zip.

## Findings
In [recorded future's report "Defense Evasion Dominant in Top MITRE ATT&CK Tactics of 2019"](https://www.recordedfuture.com/mitre-attack-tactics/), they find that out of 26,507 samples, 14,005 exhibited data encryption as a behavior. This corresponds to ~52.835%. 

In [SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/post/sok-attack-securecomm19.pdf), they examined 951 malware families, and found data encryption to have occured in 576 samples. This corresponds to ~60.57%.

If we find the average of these two values, we find that ~56.7% of all malware will encrypt data. -> ```Bernoulli(0.567)```. 

## Time to compromise
This attack step is an exfiltration one, so we should include both the time it takes to encrypt the data, and the time it takes to actually exfiltrate it. My method of doing this will be to find the average size of stolen data in previous data breaches, and then estimate the time it would take to actually send it over a network. 

|  Source | Amount of data exfiltrated (GB)
|---|---|
| https://www.zdnet.com/article/financial-apps-leak-425gb-in-company-data-through-open-database/ |  425 |
| https://www.safetydetectives.com/blog/antheus-leak-report/ |  16 |
| https://pagesix.com/2020/05/14/la-law-firm-hackers-double-ransom-demand-threaten-donald-trump/ | 756 |
| https://threatpost.com/target-attackers-took-11-gb-of-data-researchers-say/103691/ | 11 |
|  Pg. 47 of ICCWS 2016 11th International Conference on Cyber Warfare and Security | 9.7 |
| https://www.eenews.net/stories/1063112771 | 800 |
| https://www.synopsys.com/blogs/software-security/biggest-data-breaches-2019/ | 150 |
| https://www.synopsys.com/blogs/software-security/biggest-data-breaches-2019/ | 87 |
| https://www.bankinfosecurity.com/alarming-trend-more-ransomware-gangs-exfiltrating-data-a-13612 | 14.1 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 11 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 1.5 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 1.7 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 1.9 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 5.9 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 2.1 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 3.6 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 3.5 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 0.18 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 1.8 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 1.7 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 0.67 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 0.08 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 1.5 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 2.7 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 2.9 |
| https://www.theregister.com/2019/02/11/620_million_hacked_accounts_dark_web/ | 11 |
| https://www.theverge.com/2013/11/7/5078560/over-150-million-breached-records-from-adobe-hack-surface-online | 10 |
| https://www.reuters.com/article/us-northkorea-cybercrime-southkorea/north-korea-hackers-stole-south-korea-u-s-military-plans-to-wipe-out-north-korea-leadership-lawmaker-idUSKBN1CF1WT | 235 |
| https://digitalguardian.com/blog/top-10-biggest-data-breaches-2015 | 21 | 
| https://thehackernews.com/2020/06/law-enforcement-data-breach.html | 269 |
| https://www.newsbytesapp.com/timeline/Science/56931/264872/dozens-of-un-servers-compromised-in-serious-hack | 400 |
| https://www.bbc.co.uk/news/technology-40483201 | 13 |
| https://blog.storagecraft.com/7-infamous-cloud-security-breaches/ | 5 |
| https://in.mashable.com/tech/13873/microsoft-github-account-reportedly-suffered-a-cyberattack-over-500-gb-data-stolen | 500 |
| https://www.identityforce.com/blog/2020-data-breaches | 296 |
| https://meterpreter.org/new-data-leak-with-over-845-gigabytes-of-stolen-data-and-25-billion-records/ | 845 |
|---|---|
| Total | 4916.63 |
| Average | 136.57 | 

Now, according to [statista.com](https://www.statista.com/statistics/896779/average-mobile-fixed-broadband-download-upload-speeds/) the average fixed broadband upload speed was 41.09Mb/s, or 5.13625 MB/s. So the average data in a data breach would take 26589 seconds to exfiltrate over the average fixed broadband network, which is ~7.39 hours. I will use ```Exponential(3.25)``` as the estimated TTC.
## Results
```Bernoulli(0.567)*Exponential(3.25)```

## Discussion
Regarding the TTC, it's possible that the larger the data breach, the higher the chance is that it will get reported. In reality, maybe the data exfiltrated is of a much smaller amount than what I found. Also, the upload speeds may vary greatly depending on several factors, presumably a company in a first world nation would have a lot faster upload than 41mb/s. Combine these two factors, and the actual TTC is **probably** a lot faster, although I will leave it at ```Exponential(3.25)``` as an estimate because that's the data I have found. But in many cases it might be even 10x faster.   
