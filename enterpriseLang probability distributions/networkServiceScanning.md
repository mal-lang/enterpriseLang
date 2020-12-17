# Network Service Scanning

## Context  https://attack.mitre.org/techniques/T1046/

Adversaries may attempt to get a listing of services running on remote hosts, including those that may be vulnerable to remote software exploitation. Methods to acquire this information include port scans and vulnerability scans using tools that are brought onto a system.

Within cloud environments, adversaries may attempt to discover services running on other cloud hosts. Additionally, if the cloud environment is connected to a on-premises environment, adversaries may be able to identify services running on non-cloud systems as well.

## Relevant findings

### TTC

https://www.acunetix.com/blog/docs/how-long-does-a-scan-take-to-complete/#:~:text=The%20duration%20of%20a%20scan,between%202%20and%204%20hours.
According to Acunetix, the average time to perform a network scan is 20 minutes. 

https://nmap.org/book/reduce-scantime.html
There are means of reducing the time taken to scan the network for some tools but these means would result in an information loss. We will use the aforementioned value given by Acunetix.

### Prevalence

When it comes to prevalence, scanning in itself cannot really fail but can rather be detected. We could estimate the probability for network scanning to be detected (using this source for instance :https://www.ncbi.nlm.nih.gov/pmc/articles/PMC6156027/) but the probability we are looking for is the probability that the Network Scanning is going to successfully display a list of remote services. 

## Results

We assess the probability distribution for this technique to be [Exponential(72)]

