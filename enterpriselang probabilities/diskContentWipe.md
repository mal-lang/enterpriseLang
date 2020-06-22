# Disk Content Wipe
https://attack.mitre.org/beta/techniques/T1561/001/
I've looked specifically at Disk Content Wipe, but it seems like maybe Disk Structure Wipe can fit into this same category with the same numbers. 
"Adversaries may erase the contents of storage devices on specific systems as well as large numbers of systems in a network to interrupt availability to system and network resources."

## Methodology
To find probabilities, I will look at how common the mitigation techniques are.

## Mitigations
MITRE ATT&CK Matrix suggests [Data Backup](https://attack.mitre.org/beta/mitigations/M1053/) as the only mitigation. An annual survey conducted by [helpnetsecurity](https://www.helpnetsecurity.com/2020/04/03/back-up-data/) suggests that nearly 90% of companies back up data. Out of all companies, 15% back up data multiple times per day, 26% daily, 28% weekly, 20% monthly, and 10% are not at all. I will assume that backing up data at least once per day is good enough to prevent a loss of data from occuring. Thus 15+26=41%. However, if the attack occurs on the same day as the weekly or monthly back ups occur, then they are also safe. So, we add (28/7=4) + (20/30=2/3) + 41 = ~45.67%. 

As such, the probability of having data backed up is 45.67%, which means that the total chance of being vulnerable to a disk content wipe attack is 54.33%. As such, the probability distribution is ```Bernoulli(0.5433)```

## Time to compromise
The time to complete this attack depends on:
* The technique used to wipe the disk
* How much data is on the disk
* The read/write speed of the disk

### The technique used to wipe the disk
There are numerous techniques used to wipe disks. Many of them use shortcuts and do not wipe all the data of the disk, just enough so that the files on it will be unusable. This is because it usually takes a long time to perform a complete disk wipe. Some wipers target specific files, and others all files in certain folders. This depends on the size of the files found and is too difficult to estimate, so for the TTC in this section I will disregard these specific techniques. The other techniques are more specific. For example, the malware can [the malware could write 100 kilobytes of data every five megabytes sequentially through the hard disk.](https://threatpost.com/secrets-of-the-wiper-inside-the-worlds-most-destructive-malware/131836/). This means the malware only has to work with 2% of all the data on the hard disk, significantly speeding up the process. 
### How much data is on the disk
According to a study on the average capacity of [Seagate hard disk drives](https://www.statista.com/statistics/795748/worldwide-seagate-average-hard-disk-drive-capacity/) shows that the latest average lands at 4.1 terabytes. This is of course the hard drives being produced, the capacity of disks in use is probably lower. However it should be good enough as an estimate. 
### Read/Write speed of the disk
The average according to [userbenchmark](https://hdd.userbenchmark.com/) seems to be around 120MB/s. So if you can wipe the disk 120 MB at a time, (4.1 terabytes) / (120 megabytes) = 34167 seconds. From previous numbers, we saw how a malware only had to work with 2% of the data to perform disk content wiping. 34167*0.02 = 683.34 seconds. This means an attack can finish in only 11.389 minutes. This corresponds to ```Exponential(126.437)```, since you can expect that the time to wipe a single drive is only ~0.0079 parts of one day. 

## Result
In total, this comes out to ```[Bernoulli(0.5433)*Exponential(126.437)]```.


## Discussion
Just because you have backed up your data, doesn't mean that your data is completely safe, because an advanced adversary could also locate the backup(s) and wipe those as well. This is not included in the probability distribution above. 

