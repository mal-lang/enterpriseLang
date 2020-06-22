# [Transmitted Data Manipulation](https://attack.mitre.org/techniques/T1493/)

## Context
"Adversaries may alter data en route to storage or other systems in order to manipulate external outcomes or hide activity. By manipulating transmitted data, adversaries may attempt to affect a business process, organizational understanding, and decision making."

## Findings
One notable use of this technique is the North Korean threat group APT38, who used a malware known as DYEPACK to manipulate SWIFT messages on its way to a printer, in order to cover their tracks. SWIFT stands for Society for Worldwide Interbank Financial Telecommunication, and is the network that banks use for transferring information securely. I was unable to find any data on how prevalent this particular vulnerability, however the mitigation stated is "Encrypt Sensitive Information". This was previously investigated as a mitigation and can be found in the Dropbox folder in the file "[Mitigation] encryptSensitiveInformation.md". For convenience I will paste the findings here:

>According to a 2019 [Thales Data Threat Report Survey](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwiW28Dmk4vqAhXS4KYKHZvADy4QFjABegQIAhAB&url=https%3A%2F%2Fgo.thalesesecurity.com%2Frs%2F480-LWA-970%2Fimages%2F2019-DTR-Global-USL-Web.pdf&usg=AOvVaw2rKeGVWQgkIV7M0vjnCo1g), "Despite the recognition of the importance of protecting sensitive data, encryption rates throughout the enterprise are surprisingly low. Fewer than 30% of enterprises say they use encryption for the vast majority of use cases studied". 

>Another study from [nakedsecurity.com](https://secure2.sophos.com/en-us/medialibrary/Gated%20Assets/white%20papers/the-state-of-encryption-today-wpna.pdf?cmp=701j0000001WskZAAS), states that "44% of organizations are making extensive use of encryption to secure their data". 

>Yet another [study conducted by egress in 2018](www.businesswire.com/news/home/20190221005061/en/Survey-83-Percent-U.S.-Organizations-Accidentally-Exposed) states that 79% percent of organizations share sensitive business data internally without encryption, and 64 percent of organizations share sensitive business data externally without encryption, so on average (100-(79+64)/2) = 28.5% of data is encrypted. 
>If you get the average of these studies, you find that (30 + 44 + 28.5)/3 = 34.1666...% of organizations are encrypting sensitive information.

What this means is that 1 - 0.34167 = 0.65833 are vulnerable to Transmitted Data Manipulation. 

## Time to compromise
According to a report on [APT38 by fireeye](https://content.fireeye.com/apt/rpt-apt38), they "allowed the utility [DYEPACK] to run for more than hour, processing and gathering information on hundreds of local SWIFT transaction messages." We will use this to estimate TTC as one hour -> ```Exponential(24)```.

## Result

 -> ```Bernoulli(0.65833)*Exponential(24)```.