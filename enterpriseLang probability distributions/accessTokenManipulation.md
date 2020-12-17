# [Access Token Manipulation](https://attack.mitre.org/techniques/T1134/)

## Context
Windows uses access tokens to determine the ownership of a running process. A user can manipulate access tokens to make a running process appear as though it belongs to someone other than the user that started the process. When this occurs, the process also takes on the security context associated with the new token. For example, Microsoft promotes the use of access tokens as a security best practice. Administrators should log in as a standard user but run their tools with administrator privileges using the built-in access token manipulation command runas.

## Findings
One [source looking at ATT&CK techniques and trends in Windows Malware](https://krisk.io/post/sok-attack-securecomm19.pdf) finds that out of 951 samples, 197 use the technique Access Token Manipulation. This is ~20.715%. -> ```Bernoulli(0.20715)```

## Time to compromise
According to this article from [pentestlab](https://pentestlab.blog/2017/04/03/token-manipulation/), the process of actually manipulating access tokens seems to be only a few lines of code for some different scenarios. Due to this quick process, I will estimate TTC is instant. 

## Result
```Bernoulli(0.20715)```

## Discussion
Ideally some more sources with larger sample sizes would be useful to get a better estimate on prevalence of this attack technique. 