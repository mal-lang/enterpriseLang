# [Credentials From Web Browsers](https://attack.mitre.org/techniques/T1503/)
"Adversaries may acquire credentials from web browsers by reading files specific to the target browser.
Web browsers commonly save credentials such as website usernames and passwords so that they do not need to be entered manually in the future. Web browsers typically store the credentials in an encrypted format within a credential store; however, methods exist to extract plaintext credentials from web browsers."

## Prevalence
According to a book called [Services computing - João Eduardo Ferreira, George Spanoudakis, Yutao Ma, Liang-Jie Zhang](https://link.springer.com/book/10.1007/978-3-319-94376-3), 62.5% of users save at least some of their passwords in their browser. This corresponds to -> ```Bernoulli(0.625)``` being vulnerable to this attack step. 

## Time to compromise
According to MITRE's website on this attack, these are some steps to follow to fulfill this attack:
"For example, on Windows systems, encrypted credentials may be obtained from Google Chrome by reading a database file, ```AppData\Local\Google\Chrome\User Data\Default\Login Data``` and executing a SQL query: ```SELECT action_url, username_value, password_value FROM logins;```. The plaintext password can then be obtained by passing the encrypted credentials to the Windows API function ```CryptUnprotectData```, which uses the victim’s cached logon credentials as the decryption key."
This sequence of actions is quite short and would at most take a few seconds. 
Another source from proofpoint.com on a malware called [vega stealer](https://www.proofpoint.com/us/threat-insight/post/new-vega-stealer-shines-brightly-targeted-campaign) details the steps taken by the script. Seemingly, this would only take a split second to complete. Based on these 2 findings I will assume the TTC is instant. 

## Result
```Bernoulli(0.625)```
