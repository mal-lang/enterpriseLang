# Data Transfer Size Limits (dataSizedTransfer)

## Context (https://attack.mitre.org/techniques/T1030/)

An adversary may exfiltrate data in fixed size chunks instead of whole files or limit packet sizes below certain thresholds. This approach may be used to avoid triggering network data transfer threshold alerts.

## Relevant fidings

https://www.computerhope.com/unix/usplit.htm
Users can break large files into pieces using commands such as ``split`` in Linux. 
https://stackoverflow.com/questions/31786287/how-to-split-large-text-file-in-windows
According to users, this process might take several minutes for larger files. However, we couldn't file more precise and relevant data on the actual time it would take for the adversary to perform this. Assuming the adversary is trying to exfiltrate a 500Mo file, we arbitratily assume it would take 5 minutes on average to split the file into smaller pieces. 
We also assume that this technique is being used in combination with other Exfiltration technique in order to transfer the files out of the enterprise network.

## Results

We assess the TTC for this technique to be [Exponential(288)]

## Discussion

The TTC value has been assumed arbitrarily and might be improved by further tests and/or research.