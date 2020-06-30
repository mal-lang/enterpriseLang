# [Implant Container Image](https://attack.mitre.org/techniques/T1525/)

## Context
>Amazon Web Service (AWS) Amazon Machine Images (AMI), Google Cloud Platform (GCP) Images, and Azure Images as well as popular container runtimes such as Docker can be implanted or backdoored to include malicious code. Depending on how the infrastructure is provisioned, this could provide persistent access if the infrastructure provisioning tool is instructed to always use the latest image.

>A tool has been developed to facilitate planting backdoors in cloud container images. If an attacker has access to a compromised AWS instance, and permissions to list the available container images, they may implant a backdoor such as a web shell. Adversaries may also implant Docker images that may be inadvertently used in cloud deployments, which has been reported in some instances of cryptomining botnets.

## Findings
According to the findings, in order for this exploit to work an attacker needs access to a compromised AWS instance. One [source](https://www.eweek.com/security/five-security-defenses-every-containerized-application-needs) finds that as much as 60 percent of containers are "completely open to attack". This corresponds to ```Bernoulli(0.60)```. 

## Time to compromise
According to one [video](https://www.youtube.com/watch?v=12zEXfCxIrk&feature=youtu.be) made to display the possibilities of a tool called [Cloud Container Attack Tool](https://github.com/RhinoSecurityLabs/ccat), this example session took a little over 8 minutes. I will assume that the average time to compromise then is 8 minutes which is 180 times in one day, so this corresponds to ```Exponential(180)```. 

## Result
```Bernoulli(0.60)*Exponential(180)```