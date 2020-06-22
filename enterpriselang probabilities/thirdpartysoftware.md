# Third-Party Software

## Context

Third-party applications and software deployment systems may be in use in the network environment for administration purposes (e.g., SCCM, VNC, HBSS, Altiris, etc.). If an adversary gains access to these systems, then they may be able to execute code.

Adversaries may gain access to and use third-party systems installed within an enterprise network, such as administration, monitoring, and deployment systems as well as third-party gateways and jump servers used for managing other systems. Access to a third-party network-wide or enterprise-wide software system may enable an adversary to have remote code execution on all systems that are connected to such a system. The access may be used to laterally move to other systems, gather information, or cause a specific effect, such as wiping the hard drives on all endpoints.

The permissions required for this action vary by system configuration; local credentials may be sufficient with direct access to the third-party system, or specific domain credentials may be required. However, the system may require an administrative account to log in or to perform it's intended purpose.

Insecure Third-Party software may allow the adversary to perform lateral movement or code execution once they get access to the software.

## Relevant findings 

https://www.infoworld.com/article/2626167/third-party-code-putting-companies-at-risk.html
Between 30 percent to 70 percent of the code in applications come from third parties, which fail to achieve an acceptable level of security up to 81 percent of the time, according to the study. In general, third-party applications are less secure than internally developed ones on the first submission.
This source suggests that 81% of third party software aren't secure enough. 


https://threatpost.com/third-party-applications-blame-87-percent-vulnerabilities-last-year-031513/77633/
Eighty-seven percent of the vulnerabilities found in the top 50 programs affected third-party programs such as Adobe Flash and Reader, Java, Skype, various media players and others outside the Microsoft ecosystem. That means the remaining 13 percent “stem from operating systems and Microsoft programs,” according to Secunia’s Vulnerability Review report, released yesterday.
The firm detected nearly 10,000 vulnerabilities during the last year across 421 vendors, a fifth of which Secunia deemed “highly critical.”
This report suggests that third-party programs are accountable for 87% of software vulnerabilities which supports the previous result.

https://www.helpnetsecurity.com/2018/11/20/third-party-risks/
According to the findings, 59 percent of companies said they have experienced a data breach caused by one of their vendors or third parties.  Only 37 percent indicate that they have sufficient resources to manage third-party relationships and only 35 percent rate their third-party risk management program as highly effective.
This survey suggests that at least 59% of companies are vulnerable to third-party software attacks. 

## Unused but interesting findings

### About Software Update

https://threatpost.com/third-party-applications-blame-87-percent-vulnerabilities-last-year-031513/77633/
The report goes on to describe the efficiency of patching processes, writing that last year 80 percent of vulnerabilities had a patch available on the day they were disclosed, up from 72 percent in the year prior.

https://www.kaseya.com/blog/2018/06/07/third-party-software-at-center-of-growing-vulnerability-risk/
The 2018 Kaseya MSP Benchmark Survey found that only 67 percent of MSPs provide third-party software patching and updates to their customers. And many are doing so manually.

## Time To Compromise

If the Third-Party Software is available in the current session, it can instantly be reached by the adversary, provided he has the rights to use it.

## Result

The 3 findings we found suggest that overall, the probability distribution for this attack step is [Bernoulli(0.757)]

## Discussion

The third finding provides a lower prevalence for this attack step whouch could be explained by the fact that some companies didn't find the source of the breach or didn't even notice it and could potentially be neglected.