# SSH Hijacking 

## Context (https://attack.mitre.org/techniques/T1563/001/)

Adversaries may hijack a legitimate user's SSH session to move laterally within an environment. Secure Shell (SSH) is a standard means of remote access on Linux and macOS systems. It allows a user to connect to another system via an encrypted tunnel, commonly authenticating through a password, certificate or the use of an asymmetric encryption key pair.

In order to move laterally from a compromised host, adversaries may take advantage of trust relationships established with other systems via public key authentication in active SSH sessions by hijacking an existing connection to another system. This may occur through compromising the SSH agent itself or by having access to the agent's socket. If an adversary is able to obtain root access, then hijacking SSH sessions is likely trivial.

SSH Hijacking differs from use of SSH because it hijacks an existing SSH session rather than creating a new session using Valid Accounts.

## Relevant findings 

http://book.itep.ru/depository/security/vulnerability/AST-0125626_Ponemon_2014_SSH_Security_Vulnerability_Report.pdf
The Phonemon SSH Security report from 2014 states that 51 percent of companies have been impacted by SSH-key related compromise.

Once they found the private key (which are stored in a specific file), it takes no time for the adversary to compromise so we'll assum the TTC as instant.

## Results

We assess the probability distribution for this technique to be [Bernoulli(0.51)]

## Discussion

The report used to assess the prevalence of this technique is from 2014, figures may have changed, but I couldn't find the 2019 or 2020 version. 