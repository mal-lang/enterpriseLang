# System Network Connections Discovery

## Context https://attack.mitre.org/techniques/T1049/

Adversaries may attempt to get a listing of network connections to or from the compromised system they are currently accessing or from remote systems by querying for information over the network.

An adversary who gains access to a system that is part of a cloud-based environment may map out Virtual Private Clouds or Virtual Networks in order to determine what systems and services are connected. The actions performed are likely the same types of discovery techniques depending on the operating system, but the resulting information may include details about the networked cloud environment relevant to the adversary's goals. Cloud providers may have different ways in which their virtual networks operate.[1][2][3]

Utilities and commands that acquire this information include netstat, "net use," and "net session" with Net. In Mac and Linux, netstat and lsof can be used to list current connections. who -a and w can be used to show which users are currently logged in, similar to "net session".

## Relevant findings

https://alvinalexander.com/blog/post/linux-unix/linux-lsof-command/
These command and utilities can be executed in no time (if installed) and give a huge list of data that takes time to process. Some options may reduce the amout of data and help identify the most relevant ones only, but after trying those on my own device it already appears that it would take some time to process all the data (and this is only a personal device).

Note that having admin rights may provide more info than user rights according to the source (example of the lsof command).

## Results

We assume that it would take on average 1 our for the adversary to fully process the data provided by those commands. -> [Exponential(24)]

## Discussion

The TTC assumed is a rough approximation based on observations of the different utilities and commands listed on the MITRE description on my own device.  