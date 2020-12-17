# [Data Backup](https://attack.mitre.org/mitigations/M1053/) [Mitigation]
## Context
"Take and store data backups from end user systems and critical servers. Ensure backup and storage systems are hardened and kept separate from the corporate network to prevent compromise."

## Findings
An annual survey conducted by [helpnetsecurity](https://www.helpnetsecurity.com/2020/04/03/back-up-data/) suggests that nearly 90% of companies back up data. Out of all companies, 15% back up data multiple times per day, 26% daily, 28% weekly, 20% monthly, and 10% are not at all backing up data. I will assume that backing up data at least once per day is good enough to prevent a loss of data from occuring. Thus 15+26=41%. However, if the attack occurs on the same day as the weekly or monthly back ups occur, then they are also safe. So, we add (28/7=4) + (20/30=2/3) + 41 = ~45.67%. 

As such, the probability of having data backed up is 45.67%. As such, the probability distribution is ```Bernoulli(0.4567)```. 