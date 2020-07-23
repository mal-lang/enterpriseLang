# System Network Connections Discovery

## Context https://attack.mitre.org/techniques/T1016/

Adversaries may look for details about the network configuration and settings of systems they access or through information discovery of remote systems. Several operating system administration utilities exist that can be used to gather this information. Examples include Arp, ipconfig/ifconfig, nbtstat, and route.

Adversaries may use the information from System Network Configuration Discovery during automated discovery to shape follow-on behaviors, including whether or not the adversary fully infects the target and/or attempts specific actions.

## Relevant findings

These command and utilities can be executed in no time (if installed) and give a list of data that takes a few minutes to process.

Note that having admin rights may provide more info.

## Results

We assume that it would take on average 10 minutes to process the data provided by the utilities and command listed. -> [Exponential(144)]

## Discussion

The TTC assumed is a rough approximation based on observations of the different utilities and commands listed on the MITRE description on my own device.  