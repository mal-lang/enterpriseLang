# [Data Encrypted for Impact](https://attack.mitre.org/techniques/T1486/)

## Context
>Adversaries may encrypt data on target systems or on large numbers of systems in a network to interrupt availability to system and network resources. They can attempt to render stored data inaccessible by encrypting files or data on local and remote drives and withholding access to a decryption key. This may be done in order to extract monetary compensation from a victim in exchange for decryption or a decryption key (ransomware) or to render data permanently inaccessible in cases where the key is not saved or transmitted. In the case of ransomware, it is typical that common user files like Office documents, PDFs, images, videos, audio, text, and source code files will be encrypted. In some cases, adversaries may encrypt critical system files, disk partitions, and the MBR.

## Findings
One of the most common ways this attack occurs is in conjunction with ransomware, which encrypts files on a targets computer and asks for a ransom to decrypt them. One report finds that [36 percent of organizations were victims of ransomware in 2017](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwje19GOp5rqAhXnl4sKHSJbDFcQFjANegQIMBAB&url=https%3A%2F%2Fwww.checkpoint.com%2Fdownloads%2Fproducts%2Fransomware-defense-survey-for-enterprise.pdf&usg=AOvVaw1Om5gqIJ3-Gcf7efzgIby9). Another study from [sophos in a report called "
The state of ransomware 2020"](https://news.sophos.com/en-us/2020/05/12/the-state-of-ransomware-2020/), they found that 51% of organizations were hit by a ransomware attack in the last year (2019), and their data was encrypted in 73% of these attacks. This corresponds to (0.51 * 0.73 =) 37.23% of organizations being vulnerable to getting their data encrypted. If we use the average of these two sources we get that (37.23 + 36) / 2 = 36.615%, so ~```Bernoulli(0.366)```. 

## Time to compromise
In a report from exabeam called [anatomy of a ransomware attack](https://www.exabeam.com/library/anatomy-ransomware-attack/), they state the time needed for a ransomware attack to complete. First, the infection and staging takes seconds each. Next, scanning and encryption takes "minutes to hours". This time depends on the amount of information that is encrypted. For personal computers, the source states that the entire process can be completed in minutes. For corporate networks, this process can take hours. As this language is aimed towards enterprises, I will use the "hours" metric to get a TTC, and I will assume that 2 hours is the time needed to finish encrypting all the necessary files. This gives ut a ```Exponential(12)``` probability distribution. 

## Result
```Bernoulli(0.366)*Exponential(12)```

## Discussion
The TTC needs to be reviewed, it's a very rough estimate at the momented. Could probably be improved. 