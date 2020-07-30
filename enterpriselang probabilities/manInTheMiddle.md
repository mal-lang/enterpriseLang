# Man In The Middle

## Context https://attack.mitre.org/techniques/T1557/

Adversaries may attempt to position themselves between two or more networked devices using a man-in-the-middle (MiTM) technique to support follow-on behaviors such as Network Sniffing or Transmitted Data Manipulation. By abusing features of common networking protocols that can determine the flow of network traffic (e.g. ARP, DNS, LLMNR, etc.), adversaries may force a device to communicate through an adversary controlled system so they can collect information or perform additional actions.

Adversaries may leverage the MiTM position to attempt to modify traffic, such as in Transmitted Data Manipulation. Adversaries can also stop traffic from flowing to the appropriate destination, causing denial of service.


## Relevant findings

https://capec.mitre.org/data/definitions/94.html
CAPEC relevant info
Likelihood Of Attack : High
Skills Required : [Level: Medium] This attack can get sophisticated since the attack may use cryptography.

https://www.csoonline.com/article/3340117/what-is-a-man-in-the-middle-attack-how-mitm-attacks-work-and-how-to-prevent-them.html#:~:text=Though%20not%20as%20common%20as,are%20difficult%20to%20come%20by.
IBM X-Force’s Threat Intelligence Index 2018 says that 35 percent of exploitation activity involved attackers attempting to conduct MitM attacks, but hard numbers are difficult to come by. We assume that this value can be used to assess the prevalence for this technique.

Several techniques may be used to perform MitM attacks and this type of attack is used over time. Setting up the MitM attack can be done in a few minutes (depending on the protocol and the sophistication of the technique used) but what's interesting is how much time it can stay on, intercepting data or denying service.

## Results

Without any more relevant findings we'll use one of the ordinal distributions for the TTC for this technique, assuming it could be detected and stopped within a day.
[Bernoulli(0.35)*Exponential(1)]

## Discussion

The prevalence here is the percentage of attempts to conduct MitM attacks, not the success rate. This may be improved with more raw data.
The TTC is arbitrarily defined and might need some improvement too.
