# Dynamic Data Exchange https://attack.mitre.org/techniques/T1173/

## Context 
Windows Dynamic Data Exchange (DDE) is a client-server protocol for one-time and/or continuous inter-process communication (IPC) between applications. Once a link is established, applications can autonomously exchange transactions consisting of strings, warm data links (notifications when a data item changes), hot data links (duplications of changes to a data item), and requests for command execution.

Object Linking and Embedding (OLE), or the ability to link data between documents, was originally implemented through DDE. Despite being superseded by COM, DDE may be enabled in Windows 10 and most of Microsoft Office 2016 via Registry keys. 

Adversaries may use DDE to execute arbitrary commands. Microsoft Office documents can be poisoned with DDE commands, directly or through embedded files, and used to deliver execution via phishing campaigns or hosted Web content, avoiding the use of Visual Basic for Applications (VBA) macros.  DDE could also be leveraged by an adversary operating on a compromised machine who does not have direct access to command line execution.

## Relevant findings

https://www.fortinet.com/blog/threat-research/cybercriminals-exploiting-microsoft-s-vulnerable-dynamic-data-exchange-protocol
This functionality can once again be exploited via spearphishing. 

## Result 

We assess the probability distribution to be the same as for Spearphishing Attachment [Bernoulli(0.93)*Exponential(1)].

## Discussion

Once again, this functionality can be exploited thanks to spearphishing, with user execution. (like Compiled HTML File and XSL Script Processing). I couldn't say for sure in the code whether or not this attack step was and indirect child of the Spearphishing Attachment one so I gave this time distribution while looking into it.