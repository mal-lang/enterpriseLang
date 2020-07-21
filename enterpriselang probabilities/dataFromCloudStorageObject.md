# Data From Cloud storage Object

## Context https://attack.mitre.org/techniques/T1530/

Adversaries may access data objects from improperly secured cloud storage.

Many cloud service providers offer solutions for online data storage such as Amazon S3, Azure Storage, and Google Cloud Storage. These solutions differ from other storage solutions (such as SQL or Elasticsearch) in that there is no overarching application. Data from these solutions can be retrieved directly using the cloud provider's APIs. Solution providers typically offer security guides to help end users configure systems.

Misconfiguration by end users is a common problem. There have been numerous incidents where cloud storage has been improperly secured (*typically by unintentionally allowing public access by unauthenticated users or overly-broad access by all users*), allowing open access to credit cards, personally identifiable information, medical records, and other sensitive information. Adversaries may also obtain leaked credentials in source repositories, logs, or other means as a way to gain access to cloud storage objects that have access permission controls.

## Relevant findings

https://www.helpnetsecurity.com/2020/01/28/accessing-cloud-services/#:~:text=Shadow%20IT%20continues%20to%20expand,the%20cloud%20provider%20is%20breached.
According to a MacAfee survey from 2019, 52 percent of companies use cloud services that have had user data stolen in a breach.
Besides, 26 percent of files in the cloud contain sensitive data. Ninety-one percent of cloud services do not encrypt data at rest; meaning data isn’t protected if the cloud provider is breached.
Moreover, one in 10 files that contain sensitive data and are shared in the cloud use a publicly accessible link to the file.

https://go.netskope.com/rs/665-KFP-612/images/2020-02-February%20Cloud%20and%20Threat%20Report-WEB%20%281%29.pdf
89% of enterprise users are active in managed and unmanaged cloud services and apps 
This very interesting report also gives other statistics on cloud usgae that might be useful in other techniques, the percentage of users taht move sensitive data from managed to unmanaged cloud notably.

There are 2 ways for an adversary to get to sensitive data according to the MITRE description and the aforementioned report :
- The files shared in the cloud use a publicly accessible link (10% prevalence)
- The files are shared among all users and the adversary has access to a user account (0.52x0.26x0.89 -> 12% prevalence; we assume that cloud services that have had data stolen in a breach are vulnerable (52%), thus the (26%) sensitive files are vulnerable. These are assumed to be accessible to all users active on the cloud service (89%))

Overall we assess an average 11% prevalence for this technique to give access to sensitive data.

## Results 

``Bernoulli(0.11)``

## Discussion

Here we assessed the probability that with a random user access to a Cloud Service, an adversary is going to instantly (really quickly) find a sensitive file. However, these 10% sensitive files publicly available are here, they might simply take more time to find. Knowing if all users have access to these sensitive files would help assess the prevalence too. Further investigation is welcom to improve this distribution.