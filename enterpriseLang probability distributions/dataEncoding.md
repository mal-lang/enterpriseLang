# [Data Encoding](https://attack.mitre.org/techniques/T1132/)

## Context
Command and control (C2) information is encoded using a standard data encoding system. Use of data encoding may be to adhere to existing protocol specifications and includes use of ASCII, Unicode, Base64, MIME, UTF-8, or other binary-to-text and character encoding systems. Some data encoding systems may also result in data compression, such as gzip.

## Findings
There are many ways of encoding data, one common way is base-64. One source from symantec states that [5.7 percent used a BASE64-encoded string to hide their commands](https://symantec-enterprise-blogs.security.com/blogs/threat-intelligence/powershell-threats-grow-further-and-operate-plain-sight), while another from [broadcom](https://docs.broadcom.com/docs/increased-use-of-powershell-in-attacks-16-en) states that 6.58 percent used encoded powershell commands to execute code in powershell attacks. Taking the average of these two percentages, we get (5.7 + 6.58) / 2 = 6.14%. This corresponds to ```Bernoulli(0.0614)```. 

## Result
```Bernoulli(0.0614)```.

## Time to compromise
I don't think TTC is really applicable to this as the data encoding has already occured before the attack takes place. As such I will assume TTC is instant. 
