# [Account Discovery](https://attack.mitre.org/techniques/T1087/)

## Context
Adversaries may attempt to get a listing of local system or domain accounts. 

## Findings
[FireEyes M-trends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html) has this attack step occuring in 3.52% of attack lifecycles. 

Red Canary's ATT&CK technique percentages Top 50 show that Account Discovery accounts for 1.12% of all threat volume. 

[SoK: ATT&CK Techniques and Trends in Windows Malware](https://krisk.io/post/sok-attack-securecomm19.pdf) shows that out of 951 sampled windows malware families, 12 use account discovery. This is 12/951 = 1.26%

If we use the average prevalence of these 3 sources, we get: (3.52 + 1.12 + 1.26) / 3 = ~1.967%. This corresponds to ```Bernoulli(0.01967)```. 

## Time to compromise
MITRE's ATT&CK entry on this attack list various ways of performing this attack, and they all seem like quick commands typed into a terminal. 

### Windows

>Example commands that can acquire this information are `net user`, `net group` , and `net localgroup` using the [Net](https://attack.mitre.org/software/S0039/) utility or through use of [dsquery](https://attack.mitre.org/software/S0105/). If adversaries attempt to identify the primary user, currently logged in user, or set of users that commonly uses a system, [System Owner/User Discovery](https://attack.mitre.org/techniques/T1033/) may apply.

### Mac

>On Mac, groups can be enumerated through the `groups` and `id` commands. In mac specifically, `dscl . list /Groups` and `dscacheutil -q group` can also be used to enumerate groups and users.

### Linux

>On Linux, local users can be enumerated through the use of the `/etc/passwd` file which is world readable. In mac, this same file is only used in single-user mode in addition to the `/etc/master.passwd` file. Also, groups can be enumerated through the `groups` and `id` commands.

### Office 365 and Azure AD

>With authenticated access there are several tools that can be used to find accounts. The `Get-MsolRoleMember` PowerShell cmdlet can be used to obtain account names given a role or permissions group. Azure CLI (AZ CLI) also provides an interface to obtain user accounts with authenticated access to a domain. The command `az ad user list` will list all users within a domain. The `Get-GlobalAddressList` PowerShell cmdlet can be used to obtain email addresses and accounts from a domain using an authenticated session.

So from this, since this step is just about typing for example `net user`, I think it's safe to assume this attack step as instant. 

## Result
```Bernoulli(0.01967)```