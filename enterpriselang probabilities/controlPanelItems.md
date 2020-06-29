# [Control Panel Items](https://attack.mitre.org/techniques/T1196/)

## Context
>Windows Control Panel items are utilities that allow users to view and adjust computer settings. Control Panel items are registered executable (.exe) or Control Panel (.cpl) files, the latter are actually renamed dynamic-link library (.dll) files that export a CPlApplet function. Control Panel items can be executed directly from the command line, programmatically via an application programming interface (API) call, or by simply double-clicking the file.

## Findings
According to MITRE, one type of malware that uses control panel items is called reaver. Reaver is investigated by [group 42 of palo alto networks](https://unit42.paloaltonetworks.com/unit42-new-malware-with-ties-to-sunorcal-discovered/), and they state that only 0.006% of all malware seen them uses Control Panel items, indicating that it is quite rare. 0.006% corresponds to ```Bernoulli(0.00006)```. 

## Time to compromise
According to the analysis from [palo alto networks](https://unit42.paloaltonetworks.com/unit42-new-malware-with-ties-to-sunorcal-discovered/), the malware does this: (very simplified): execute malware, which launches two processes, one which creates an LNK file for persistence, and one which decodes the embedded payload. It then drops the embedded payload as cabinet file, extracts the control panel item payload from the cabinet file, and then loads TCP reaver payload. The part where control panel items are used isn't clear how much time it would take, but it seems like it would be near instant. 

However, this attack step relies on user execution (the user has to double click the item for the malicious code to execute). Without relevant data on Control Panel usage (frequency of use), we assumed this TTC to be instant.

## Result 
```Bernoulli(0.83)```

## Discussion
Apparently this kind of attack is very rare, palo alto networks reported that only 0.006% of all malware samples analyzed by them used this method. This means that there simply is not a lot of research on this malware yet, so the data and information here might not be entirely accurate. For now it's a simple estimate. 
With data on the frequency of Control Panel use, we could assess a TTC.
