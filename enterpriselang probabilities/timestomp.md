# [Timestomp](https://attack.mitre.org/techniques/T1099/)

## Context
>Timestomping is a technique that modifies the timestamps of a file (the modify, access, create, and change times), often to mimic files that are in the same folder. This is done, for example, on files that have been modified or created by the adversary so that they do not appear conspicuous to forensic investigators or file analysis tools. Timestomping may be used along with file name Masquerading to hide malware and tools.

## Findings
According to [FireEyes 2020 M-trends report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), timestomping as a technique was used in 3.96% of all attack lifecycles. -> ```Bernoulli(0.0396)```. 

## Time to compromise
This attack technique seems to be essentially instant. From [this github repo](https://github.com/jackson5sec/timestomp), we can see that example usage looks like this:

```
ts.exe -m C:\users\user\sample.exe
```

This is a single line command, and I will thus assume TTC is instant. 

## Result
```Bernoulli(0.0396)```

## Discussion
Ideally we want more sources for the prevalence findings. At the time of writing I was unable to find any more. 