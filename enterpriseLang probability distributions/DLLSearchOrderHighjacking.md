# [DLL Search Order Hijacking ](https://attack.mitre.org/techniques/T1038/)
"Windows systems use a common method to look for required DLLs to load into a program. [1] Adversaries may take advantage of the Windows DLL search order and programs that ambiguously specify DLLs to gain privilege escalation and persistence."

## Prevalence
[Red Canary's Threat Detection Report 2020](https://redcanary.com/threat-detection-report/techniques/dll-search-order-hijacking/) states that 16% of organizations are affected by this technique. -> ```Bernoulli(0.16)```. 

## Time to compromise
Also according to Red Canary, Dridex (a type of malware) infections are the main leverager of this technique. In a technical analysis of [Dridex on nsfocus.com](http://blog.nsfocus.net/dridex-banking-malware-sample-technical-analysis-solution/), apparently the entire procedure of DLL hijacking seems to take only 0.0000063 seconds. (Can be seen in an image near the end of the analysis). This seems like a very fast operation but, as an example of what this step does is it "copies a malicious DLL to the same directory as the legitimate executable, when executable is run, it will load the malicious DLL in the Roaming folder instead of the legitimate one from System32". ([source](https://threatresearch.ext.hp.com/dridex-threat-analysis-july-2019-variant/)). This probably does not take very long to do for a computer program. In any case I assume that the TTC is so near instant that I will not include an exponential distribution for time needed. 

## Result
```Bernoulli(0.16)```

## Discussion
Apparently it is common to make use of scheduled tasks to disguise the DLL search order hijacking as a legitimate event, this means that the actual time to perform this step may depend on the scheduled tasks, however I decided to focus strictly on the time needed to do the operation that performs the DLL search order hijacking. 