# 08/06 Replication through Removable Media

## Context 
Adversaries may move onto systems, possibly those on disconnected or air-gapped networks, by copying malware to removable media and taking advantage of Autorun features when the media is inserted into a system and executes. In the case of Lateral Movement, this may occur through modification of executable files stored on removable media or by copying malware and renaming it to look like a legitimate file to trick users into executing it on a separate system. In the case of Initial Access, this may occur through manual manipulation of the media, modification of systems used to initially format the media, or modification to the media's firmware itself.

We will focus on the Initial Access and will separate this step for both Initial Access and Lateral Movement tactics.

## Findings 

(Time to plug a found USB device)
https://threatpost.com/never-trust-a-found-usb-drive-black-hat-demo-shows-why/119653/ 
 The average time it took for someone to plug the USB drive and click on an HTML file that phoned home was about seven hours with 20 percent of USB connections occurring within one hour from when the drive was dropped.

Based on Lina's findings on the probability for an actor to pick up and plug the USB device in their computer, we can asses the following probability distribution ``[Bernoulli(0.45)*Exponential(3.429)]`` 

## Discussion

https://www.supplychaindive.com/news/internal-actors-cyberattacks-manufacturing/572832/#:~:text=External%20actors%20account%20for%20the,2019%20Data%20Breach%20Investigations%20Report.
internal actors (people working in the targeted entreprise) carry out 30% of attacks. Internal actors have physical access to the network and can thus easily use an infected USB device for the adversary to get initial compromise. The internal actor has malicious intents and so the attack will have a 100% success rate in this case. We can assume that this attack will be performed almost instantly by an internal actor (~30 minutes). Maybe we should take that into consideration or create a new attack step with a probability distribution ``[Bernoulli(0.3)*Exponential(48)]``

