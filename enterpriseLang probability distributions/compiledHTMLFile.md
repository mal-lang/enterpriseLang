# Compiled HTML File

## Context 

https://attack.mitre.org/techniques/T1223/
Compiled HTML files (.chm) are commonly distributed as part of the Microsoft HTML Help system. CHM files are compressed compilations of various content such as HTML documents, images, and scripting/web related programming languages such VBA, JScript, Java, and ActiveX. CHM content is displayed using underlying components of the Internet Explorer browser loaded by the HTML Help executable program (hh.exe).

Adversaries may abuse this technology to conceal malicious code. A custom CHM file containing embedded payloads could be delivered to a victim then triggered by User Execution. CHM execution may also bypass application whitelisting on older and/or unpatched systems that do not account for execution of binaries through hh.exe.

## Time To Compromise

https://blog.rootshell.be/2017/12/19/malware-delivered-via-compiled-html-help-file/
Phishing is a way of delivering the malicious file to the victim. Assuming this as the most common and efficient way of delivering malicious file, we'll use the same probability distribution as for the Spearphishing Link technique.    

## Result 

We'll use the [Bernoulli(0.93)*Exponential(1)] probability distribution.

## Discussion

There are different ways of delivering a malicious file to the victim, however, phishing is the one which will most likely lead to a successful attack. If the file is delivered directly to the victim's session, they might not even notice that the file has been delivered.