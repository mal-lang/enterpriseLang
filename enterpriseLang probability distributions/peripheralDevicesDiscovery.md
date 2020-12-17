# Peripheral Devices Discovery

## Context https://attack.mitre.org/techniques/T1120/

Adversaries may attempt to gather information about attached peripheral devices and components connected to a computer system. Peripheral devices could include auxiliary resources that support a variety of functionalities such as keyboards, printers, cameras, smart card readers, or removable storage. The information may be used to enhance their awareness of the system and network environment or may be used for further actions.

## Relevant findings

https://capec.mitre.org/data/definitions/646.html
It's hard to identify the prevalence or Time it would take for an adversary to list all the devices. The CAPEC framework suggests that this technique has a low likelyhood of attack meaning that adversaries are unlikely to even try to perform this technique. 

https://www.welivesecurity.com/wp-content/uploads/2016/10/eset-sednit-part-2.pdf
However there are some malware that can list connected devices to the current host. With some effort, such as delivering the payload and running the proper commands, a professional adversary should be able to eventually list all the peripheral devices connected to the host. In the CAPEC framework, it is also written that this requires some skill : 
[Level: Medium]
The adversary needs to be able to infect the victim system in a manner that gives him remote access.
[Level: Medium]
If analyzing the Windows registry, the adversary must understand the registry structure to know where to look for devices.

Without being able to find more relevant data on this specific technique, we are going to use one of the ordinal probability distributions listed on the MAL wiki page (https://github.com/mal-lang/malcompiler/wiki/Supported-distribution-functions)

## Results 

This technique appears to be quite Hard and Certain. We'll use the [Exponential(0.1)] distribution for this technique.

## Discussion

Further investigation could lead to better results for this distribution but considering that technique isn't so interesting for adversaries, we decided to leave it like that for now. One way of finding better results could be by experimenting on an actual host, looking into the system registry to identify peripheral devices (tty etc.), or with agreement (obviously), trying to compromise a host and install the aforementioned payload.