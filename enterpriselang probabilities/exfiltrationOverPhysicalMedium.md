# Exfiltration Over Physical Medium

## Context (https://attack.mitre.org/techniques/T1052/)

Adversaries may attempt to exfiltrate data via a physical medium, such as a removable drive. In certain circumstances, such as an air-gapped network compromise, exfiltration could occur via a physical medium or device introduced by a user. Such media could be an external hard drive, USB drive, cellular phone, MP3 player, or other removable storage and processing device. The physical medium or device could be used as the final exfiltration point or to hop between otherwise disconnected systems.

## Relevant findings 

https://www.mcafee.com/enterprise/en-us/assets/reports/rp-data-exfiltration.pdf
Sixty percent of the reported data exfiltrations were achieved by direct electronic means, while the other 40% involved some type of physical media, such as stealing a laptop or downloading to a USB drive. Here's how those 40% are spread across all devices.

| Data exfiltration methods|  Internal Actors | External Actors |
|---|---|---|
|Physical Media|||
|Laptops/Tablets |11%| 13%|
|USB Drives |15%| 8%|
|Mobile Phones |3%| 6%|
|Printed Hardcopies |3% |4%|
|CDs/DVDs |4% |4%|
|Microphones/Webcams| 2% |4%|
|Faxes| 2% |3%|

However no data is given on the prevalence of exfiltration over physical medium. Without more material we'll use the generic succes rate for exiltration techniques which can be found in the exfiltrationOverAlternativeProtocol.md file : [Bernoulli(0.79224)]

On the TTC, the most commonly physical medium used by adversaries are Laptops/Tables, USB drives and Mobile Phones. Adversaries may either steal those medium or in the case of USB drives, use them to exfiltrate data live, or they may be internal actors with data on their own devices (40%). 20% of Data Exfiltration are accidentally by internal actors (getting their own device stolen). 20% are intentionally cause by internal actors. 60% are caused by external actors. 
We assume that it would take an hour for an external adversary to properly exfiltrate data from a stolen device and half a day for internal actors intentinally exfiltrating data (assuming they do their working hours). The few minutes it would take to download data on devices are neglected.
Thus we can assess the average TTC for this technique as 1/24x0.8+1/2x0.2 = 0.13 day. This can be represented by the Exponential(7.69) distribution

## Results 

We assess the probability distribution for this technique to be [Bernoulli(0.79224)*Exponential(7.69)]

## Discussion

The values chosen for TTC are totally arbitrary and could be updated with relevant papers.

