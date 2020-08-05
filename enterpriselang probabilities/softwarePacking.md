# [Software Packing](https://attack.mitre.org/techniques/T1045/)

## Context
>Software packing is a method of compressing or encrypting an executable. Packing an executable changes the file signature in an attempt to avoid signature-based detection. Most decompression techniques decompress the executable code in memory.

## Findings
According to vmware's Carbon Black [2020 Cyber Security Outlook Report](https://content.carbonblack.com/c/vmwcb-threat-report-?x=f_lWMB), 26% of malware exhibited Software Packing. Another source, a research paper called [Entropy analysis to classify unknown packing algorithms for malware detection](https://www.researchgate.net/publication/301902892_Entropy_analysis_to_classify_unknown_packing_algorithms_for_malware_detection) finds that 80% of malware use packing. Yet another research paper called [Obfuscation: The Hidden Malware](https://www.academia.edu/7383312/Obfuscation_The_Hidden_Malware) finds that 48.92% of malware files are packed. Yet another [source](https://www.lastline.com/labsblog/malware-packing/) finds that 37% of malware used some kind of packing. Yet another [source](www.blackhat.com/presentations/bh-usa-06/BH-US-06-Morgenstern.pdf) (albeit a bit old from 2006) found that at least 92% of malware they sampled was packed. These are all quite different, but I will use a normal distribution to estimate the probabilities. The average of these values is 56.784. The standard deviation is ~25.219. So, ```TruncatedNormal(0.56784,0.25219)```. 

## Time to compromise
According to the MITRE ATT&CK page on software packing, one utility that is commonly used to pack software is called [MPRESS](http://www.matcode.com/mpress.htm). This can apparently achieve the following: "Very fast decompression: ~210 MB/sec on an AMD 2500+". Another packing utility according to MITRE ATT&CK is called [UPX](https://upx.github.io/). This can achieve "~200 MB/sec on an Athlon XP 2000+". The two processors used to measure the speed are according to [cpuboss.com](http://cpuboss.com/cpus/AMD-Athlon-XP-M-2500-vs-AMD-Athlon-XP-2000) around the same speed, with a difference of only 0.2GHz in clock speed. According to research by [fortiguard](https://d3gpjj9d20n0p3.cloudfront.net/fortiguard/research/DetectingMalwareThreats.pdf), malware is typically "found within files that are less than one MB in size." So it seems that most semi-modern processors can achieve software packing in a fraction of a second. Thus I will assume TTC is instant.

## Update
### 1
The TruncatedNormal distribuiton output is days in the MAL. The only distribution that supports  "success rate" is Bernoulli.

## Result
```Bernoulli(0.56784)```

## Discussion
The white paper from fortiguard is quite old, being published in late 2006, but I think as an estimate it should still be OK for our TTC as even if it was 100x that size, it would still result in a TTC of less than a second. 