# Scheduled Transfer

## Context (https://attack.mitre.org/techniques/T1029/)

Adversaries may schedule data exfiltration to be performed only at certain times of day or at certain intervals. This could be done to blend traffic patterns with normal activity or availability.

When scheduled exfiltration is used, other exfiltration techniques likely apply as well to transfer the information out of the network, such as Exfiltration Over C2 Channel or Exfiltration Over Alternative Protocol.

## Relevant findings

https://www.welivesecurity.com/wp-content/uploads/2016/10/eset-sednit-part-2.pdf
https://www.welivesecurity.com/wp-content/uploads/2020/05/ESET_Turla_ComRAT.pdf
Malware can be set up to send data every 10 minutes and only on working hours so that the data transfers are hidden within the normal network activity.
This could be used in association with Data Transfer Size Limits in order to hide the exfiltration very well. This will take time however.
Many factors may influence the actual time it would take for an adversary to exfiltrate a 500Mo file from the company's network. Assuming they only extract on working hours there is a 16 hours gap every day during which they cannot transfer anything. A 500Mo file would usually only take a few minutes to exfiltrate all at once (as seen in exfiltration Over C2 Channel and Alternative Protocols techniques) but if it's split into smaller pieces sent one by one every 10 minutes then it could take many hours. 
We'll assume that the 500Mo file is split into 125 smaller 4Mo files sent every 10 minutes in order to ensure the exfiltration is less likely to be identified. The adversary would transfer 48 small files a day meaning it would take ~2.6 days to exfiltratie the whole file. This can be represented by the [Exponential(0.384)] distribution. 

## Code Tweak

We removed the previous children of this technique : Exfiltration Over C2 Channel or Exfiltration Over Alternative Protocol. In order to better show that the adversary may sacrifice TTC in order to increase their exfiltration success rate.
https://www.mcafee.com/enterprise/en-us/assets/reports/rp-data-exfiltration.pdf
In order for the attack not to be 100% successful, we use the better success rate found in this report : [Bernoulli(0.92)] 
## Results

We assess the probability distribution for this technique to be [Bernoulli(0.92)*Exponential(0.384)]

## Discussion

Adversaries might chose faster ways of exfiltrating files, at the risk of being discovered more easily. We there assumed the professional adversary had time and was extremely cautious. This assumption might be discussed leading to a change in the TTC found.