# Data from Network Shared Drive

## Context https://attack.mitre.org/techniques/T1039/

Adversaries may search network shares on computers they have compromised to find files of interest. Sensitive data can be collected from remote systems via shared network drives (host shared directory, network file server, etc.) that are accessible from the current system prior to Exfiltration. Interactive command shells may be in use, and common functionality within cmd may be used to gather information.

## Relevant findings

The main findings are the ones from the [automatedCollection.md] file. I couldn't find specific data on the average size of network shared drive accessible to an average employee as it may vary a lot between companies and jobs. We'll use the results from the previous findings to assess the probability distribution for this technique.

More detail in the [automatedCollection.md] file.

## Results

[Bernoulli(0.892)*Exponential(9.952)]

## Discussion

This probability distribution could be improved by finding the average size of network shared drive accessible to the average  employee.