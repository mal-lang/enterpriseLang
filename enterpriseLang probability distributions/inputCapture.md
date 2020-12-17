# [Input Capture](https://attack.mitre.org/techniques/T1056/)

## Context
>Adversaries can use methods of capturing user input for obtaining credentials for Valid Accounts and information Collection that include keylogging and user input field interception.

>Keylogging is the most prevalent type of input capture, with many different ways of intercepting keystrokes, but other methods exist to target information for specific purposes, such as performing a UAC prompt or wrapping the Windows default credential provider.

## Findings
One report on statista.com called [Most commonly encountered types of malware used in industrial cyber attacks worldwide in 2019 ](https://www.statista.com/statistics/271037/distribution-of-most-common-malware-file-types/) states that 6.5% of all malware used are keyloggers. 

Another source from [rsaconference.com](https://www.rsaconference.com/industry-topics/blog/do-malware-authors-dream-of-original-code) states that 46% of malware observed over a one year period fell into the category of "Backdoor", of which input capture is a common feature included in backdoors. They state that categories included in "Backdoor" are : sleep, file transfer, credential stealing, keylogging, reverse shells and process manipulation. So to estimate how many of these are keyloggers, I will use 46% / (amount of different types of backdoors). So 46% / 6 = ~7.6667%. 

I will now average the two, (7.6667 + 6.5) / 2 = 7.08335% ~= 7.1%. This corresponds to ```Bernoulli(0.071)```.  

## TTC
One installation guide from a site called [keyllama.com](http://keyllama.com/KeyLlamaUSB.pdf) states that the installation process takes just a few seconds. I will assume TTC is instant.  

## Result
```Bernoulli(0.071)```