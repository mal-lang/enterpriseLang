# [Data Obfuscation](https://attack.mitre.org/techniques/T1001/)

## Context
>Command and control (C2) communications are hidden (but not necessarily encrypted) in an attempt to make the content more difficult to discover or decipher and to make the communication less conspicuous and hide commands from being seen. This encompasses many methods, such as adding junk data to protocol traffic, using steganography, commingling legitimate traffic with C2 communications traffic, or using a non-standard data encoding system, such as a modified Base64 encoding for the message body of an HTTP request.

## Findings
One source, [Obfuscation: the hidden malware](https://www.academia.edu/7383312/Obfuscation_The_Hidden_Malware) states that there are several different methods of obfuscation. One of these is packing. According to the paper, three different sources had a few different rates of use when it comes to packing. One of them says 48.92% uses packing, another 60%, and a last one suggests that 92% of malware are packed. One book, [Risks and Security of Internet and Systems: 9th International Conference ](https://books.google.se/books?id=tHK6CAAAQBAJ&pg=PA175&lpg=PA175&dq=percent+of+malware+using+obfuscation&source=bl&ots=uAffxqpZX2&sig=ACfU3U2kkIrqzLLQ8ipOR2RwkRPzc8Jp1A&hl=en&sa=X&ved=2ahUKEwio69vRhZrqAhVMEncKHYwLAwsQ6AEwC3oECGQQAQ#v=onepage&q=percent%20of%20malware%20using%20obfuscation&f=false), has a table with distributions of different malware samples. It looks like this: 

| Malware Type  | No. of samples| Not-obfuscated | Obfuscated |
| ------------- |:-------------:| :-----:| :-----:|
| Virus | 13,509 | 3,053 | 10456 |
| Worm    | 10,150 | 2,741 | 7409 |
| Rookit | 257 | 130 | 127 |
| Backdoor | 4,688 | 1,876 | 2,812 |
| Exploit | 1,206 | 262 | 944 |
| Trojan | 10,302 | 2,782 | 7,520 |
| **Total** | 40,112 | 10,844 | 29,268 | 

29268 / 40112 = 0.7296569... ~= 72.9%. 

If we use the average of these 4 values, we get (48.92 + 60 + 92 + 72.9) / 4 = 68.455%. -> ~```Bernoulli(0.685)```. 

## Time to compromise
I don't think TTC is really applicable on this category, mainly because the obfuscation usually occurs before the malware payload is delivered. As such, the obfuscation is already there when the malware is executing. As such, there is no TTC -> Instant. 

## Result
```Bernoulli(0.685)```.