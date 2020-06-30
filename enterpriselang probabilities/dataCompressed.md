# [Data Compressed](https://attack.mitre.org/techniques/T1002/)

## Context
>An adversary may compress data (e.g., sensitive documents) that is collected prior to exfiltration in order to make it portable and minimize the amount of data sent over the network. The compression is done separately from the exfiltration channel and is performed using a custom program or algorithm, or a more common compression library or utility such as 7zip, RAR, ZIP, or zlib.

## Findings
From the sources I've found, it doesn't seem entirely clear exactly how common this technique is, however most sources seem to agree that it's at least more common to use it, than it is to **not** use it. For example, [this source from University of Toronto called "Communities @ Risk"](https://targetedthreats.net/media/4-Glossary.pdf), says that "Attackers will traditionally encrypt and compress data before exfiltration.". In [this book, on page 560](https://www.wiley.com/en-se/The+Art+of+Memory+Forensics%3A+Detecting+Malware+and+Threats+in+Windows%2C+Linux%2C+and+Mac+Memory-p-9781118824993), using tools like winRAR to compress files is a technique "commonly" used by attackers. As an assumption, I will assume that out of all malware that exfiltrate data, 75%, or 3/4ths, will compress it before. -> ```Bernoulli(0.75)```. 


## Time to compromise
I found one source from google's cloud service out that looks at what to monitor for when trying to prevent data exfiltration. ["If the average user sends 5 megabytes of data on average per day, a user sending 500 megabytes should trigger an alert."](https://cloud.google.com/security/data-loss-prevention/preventing-data-exfiltration) I decided to use this as a guideline, assuming that for an attacker to go undetected, they would have to use a file smaller than 500Mb in size. I used my own computer as a test (with 16GBs of RAM and a 2.7GHz i7-7500 CPU), and found that an approximately 500MB .mkv file I had took ~20 seconds to compress using 7zip's "Normal" compression setting. This is quite quick, as it is less than one minute of time, I am assuming it's instant. 

## Result
```Bernoulli(0.75)```

## Discussion
This is quite an uncertain assumption, and if other, better and more consistent sources are found then they should be used instead. 