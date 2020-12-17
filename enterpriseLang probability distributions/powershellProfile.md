# Powershell Profile

## Context (https://attack.mitre.org/versions/v6/techniques/T1504/)

Adversaries may gain persistence and elevate privileges in certain situations by abusing PowerShell profiles. A PowerShell profile (profile.ps1) is a script that runs when PowerShell starts and can be used as a logon script to customize user environments. PowerShell supports several profiles depending on the user or host program. For example, there can be different profiles for PowerShell host programs such as the PowerShell console, PowerShell ISE or Visual Studio Code. An administrator can also configure a profile that applies to all users and host programs on the local computer.

Adversaries may modify these profiles to include arbitrary commands, functions, modules, and/or PowerShell drives to gain persistence. Every time a user opens a PowerShell session the modified script will be executed unless the -NoProfile flag is used when it is launched.

An adversary may also be able to escalate privileges if a script in a PowerShell profile is loaded and executed by an account with higher privileges, such as a domain administrator.

We identify 2 different aspects of the technique. The adversary may obtain persistence as soon as a user opens a PowerShell session. However, the adversary needs an admin (or any user with higher privilege) to open a PowerShell session in order to achieve privilege escalation. Besides, if the PowerShell session is launched with the -NoProfile flag (which can be specified in Software Configuration), the attack will fail. Moreover, the attack may not always succeed if there is a mitigation that restricts profile modification (Code Signing or Restrict File or Directory Permissions).

We might need to separate the code into 2 parts, one for any user (which is more likely to succeed, take less time and only gives persistence), and one for admin users (which is less likely to succeed, might take more time and give both persistence and privilege escalation).

## Assumptions and relevant findings

### Share of PowerShell session execution between Users and Admins

Assuming admins use PowerShell more often than simple users in most companies, we assume that when a user launches a PowerShell session, there is a 50% chance that the next user that will open a session will have admin rights.
Many factors may influence this value (the type of company, the infected computer ...) which is why it's hard to find relevant data on it, and why we will assume that this value can be used for the powerShellAdminProfile

### Time it takes for user to connect

https://www.quora.com/ITs-how-often-do-you-use-PowerShell-And-what-do-you-think-about-it
IT professionals use PowerShell daily and often open it several times a day or continuously have one open. We can thus assume that it would take on average half a day for them to open Powershell session, which is represented by [Exponential(2)].
We assume that this time is a good approximation for both admin and user profiles and we'll thus use this time distribution for both of the aforementioned sub techniques.

### Mitigations

We assume that Software Configuration carries the probability that the powerShell session will be opened with the -NoProfile flag and that other restrictions on PowerShell Profile modification are carreid by Code Signing or Restrict File and Directory Permissions mitigations.

## Results

We assume the probability for the User Profile exploit to be [Exponential(2)] and for the Admin Profile exploit to be [Bernoulli(0.5)*Exponential(2)]

## Discussion

The values for probabilities are rough and arbitrary approximations which do not rely on any scientific paper. They may very well be wrong and should be further investigated. The values are mostly indicative and should be treated cautiously.