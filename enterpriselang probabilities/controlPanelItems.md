# [Control Panel Items](https://attack.mitre.org/techniques/T1196/)

## Context
>Windows Control Panel items are utilities that allow users to view and adjust computer settings. Control Panel items are registered executable (.exe) or Control Panel (.cpl) files, the latter are actually renamed dynamic-link library (.dll) files that export a CPlApplet function. Control Panel items can be executed directly from the command line, programmatically via an application programming interface (API) call, or by simply double-clicking the file.

## Findings
According to MITRE ATT&CK, the only procedure example of this kind of attack is by a malware family known as [reaver](https://attack.mitre.org/software/S0172/). According to one technical analysis of the virus, by [cylance threatvector](https://threatvector.cylance.com/en_us/home/reaver-mapping-connections-between-disparate-chinese-apt-groups.html), they found that an exploit document leveraging [CVE-2017-11882](https://nvd.nist.gov/vuln/detail/CVE-2017-11882#vulnConfigurationsArea) was used to deliver the payload. And the [payload is in the form of a control panel item](https://unit42.paloaltonetworks.com/unit42-new-malware-with-ties-to-sunorcal-discovered/). This CVE affects microsoft office 2007, 2010, 2013, and 2016. So if we find how common it is for an organization to use at least one of these versions of microsoft office, we can find out how likely this malware is to be able to run, and thus how vulnerable the system is to the control panel items attack step to be realized. One study finds that [82%](https://community.spiceworks.com/software/articles/2873-data-snapshot-the-state-of-productivity-suites-in-the-workplace) of organizations "are using an on-premises version of Microsoft Office". Unfortunately this data also includes office versions older than 2007, **BUT** what we can do instead is use the fact that the same source states that 83% of organizatins use microsoft office 2010 in some capacity on their networks, and since this is the highest % of office versions being used that are affected by CVE-2017-11882, it means that this is the % of organizations vulnerable to reaver. 

So using this, we can estimate that 83% of organizations are vulnerable to Control Panel Items being abused. -> ```Bernoulli(0.83)```.

## Time to compromise
According to the analysis from [palo alto networks](https://unit42.paloaltonetworks.com/unit42-new-malware-with-ties-to-sunorcal-discovered/), the malware does this: (very simplified): execute malware, which launches two processes, one which creates an LNK file for persistence, and one which decodes the embedded payload. It then drops the embedded payload as cabinet file, extracts the control panel item payload from the cabinet file, and then loads TCP reaver payload. The part where control panel items are used isn't clear how much time it would take, but it seems like it would be near instant. 

However, this attack step relies on user execution (the user has to double click the item for the malicious code to execute). Without relevant data on Control Panel usage (frequency of use), we assumed this TTC to be instant.

## Result 
```Bernoulli(0.83)```

## Discussion
Apparently this kind of attack is very rare, palo alto networks reported that only 0.006% of all malware samples analyzed by them used this method. This means that there simply is not a lot of research on this malware yet, so the data and information here might not be entirely accurate. For now it's a simple estimate. 
With data on the frequency of Control Panel use, we could assess a TTC.