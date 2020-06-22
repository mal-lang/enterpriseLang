# Supply Chain Compromise

## Context
Supply chain compromise is the manipulation of products or product delivery mechanisms prior to receipt by a final consumer for the purpose of data or system compromise.

Supply chain compromise can take place at any stage of the supply chain including:

- Manipulation of development tools
- Manipulation of a development environment
- Manipulation of source code repositories (public or private)
- Manipulation of source code in open-source dependencies
- Manipulation of software update/distribution mechanisms
- Compromised/infected system images (multiple cases of removable media infected at the factory) 
- Replacement of legitimate software with modified versions
- Sales of modified/counterfeit products to legitimate distributors
- Shipment interdiction


While supply chain compromise can impact any component of hardware or software, attackers looking to gain execution have often focused on malicious additions to legitimate software in software distribution or update channels. Targeting may be specific to a desired victim set or malicious software may be distributed to a broad set of consumers but only move on to additional tactics on specific victims. Popular open source projects that are used as dependencies in many applications may also be targeted as a means to add malicious code to users of the dependency

In order for the adversary to perform this attackStep, they have to have an access at some point in the supply chain (most of the time to compromise a software maker). We can assume that the adversary has knowledge of the tools used by the target, and we can therefore assess that the probability we are looking for is the probability for the adversary to compromise the supply chain at some point, and the time it would take for them to do that.

## Relevant findings 

### Mitigations 

https://www.crowdstrike.com/blog/global-survey-reveals-supply-chain-as-a-rising-and-critical-new-threat-vector/
Organizations aren’t adequately prepared and feel vulnerable: Almost 90 percent of the survey respondents believe they are at risk for a supply chain attack, yet companies are still slow to detect, remediate and respond to threats. 

#### Vulnerability Scanning

https://static.tenable.com/marketing/research-reports/Research-Report-Ponemon-Institute-Measuring_and_Managing_the_Cyber_Risks_to_Business_Operations.pdf
But according to the Phonemon report (2018), 59% of the surveyed companies weren't scanning or had no specific plan for vulnerbility scanning 

We can thus assess that the probability for vulnerabilityScanning is [Bernoulli(0.41)]

#### Update Software
(https://www.eweek.com/security/software-patches-could-prevent-most-breaches-study-finds
Approximately 80 percent of companies that had either a breach or a failed audit could have prevented the issue with a software patch or a configuration change, according to a security-automation survey of 318 firms.
The survey, conducted by research firm Voke Media in late 2016, found that 27 percent of companies reported a failed audit in the prior 18 months, of which 81 percent could have been prevented with a patch or configuration change. Similarly, 26 percent reported a breach, of which 79 percent could have been prevented with those two measures.)

However this is not what we are looking for. A patch management process should be implemented to check unused dependencies, unmaintained and/or previously vulnerable dependencies, unnecessary features, components, files, and documentation. 
https://www.usenix.org/system/files/conference/soups2015/soups15-paper-ion.pdf
This paper suggests that 36% of experts and 66% of standard users don't update software quickly enough.
Smaller companies don't have security experts as IT managers.

We can thus assess that the probability for updateSoftware mitigation to be enabled is [Bernoulli(0.34)]

#### Comparison 
The results for both mitigations is similar to the overall vulnerability to supply chain compromise.
https://www.computerweekly.com/news/252462476/Most-businesses-vulnerable-to-supply-chain-cyber-attacks#:~:text=Seven%20in%2010%20businesses%20may,to%20research%20commissioned%20by%20Accenture
Seven in 10 businesses may be particularly vulnerable to cyber attacks through their supply chains, according to research commissioned by Accenture (meaning that ~30% have proper defenses/mitigation for this attack)
### Supply Chain Compromise

Assuming that the professsional adversary has previously done some research, they know which devices/software are used by the target, they can then try to compromise those in order to perform a supply chain compromise. Thus, the TTC we are looking for depends on the time it would take for the adversary to compromise and the time before an update is published.

https://savvyapps.com/blog/how-often-should-you-update-your-app#:~:text=Most%20successful%20apps%20release%201,updates%20with%20longer%20feature%20releases.
Most popular apps are updated 1-4 times a month, that is to say once every 8-30 days. We can thus assess that the distribution for the TTC will be [Uniform(8,30)]



Thus the distribution law for supplyChainCompromise is [Uniform(8,30)]
## Discussion 

I couldn't find relevant data to assess the time to compromise a software maker in order to add malicious code to the software before an update so at this time, it is still considered as instantenious.  
