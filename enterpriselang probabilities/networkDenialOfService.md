# [Network Denial of Service](https://attack.mitre.org/techniques/T1498/)
## Context
https://attack.mitre.org/techniques/T1498/
The point is to "degrade or block the availability of targeted resources to users". That places this tactic in the "Impact" category of the MITRE ATT&CK matrix. Network DoS can be performed by exhausting the network bandwidth services rely on. Example resources include:
* specific websites
* email services
* DNS
* web-based applications

## Probability of being affected by a (D)DoS attack
According to [netscout.com in 2018](https://www.netscout.com/news/press-release/complexity-ddos-attacks), 57% of enterprises and 45% of data center operators saw their internet bandwidth saturated due to DDoS attacks through the year 2017. According to a study by [Arne Holst](https://www.statista.com/statistics/500458/worldwide-datacenter-and-it-sites/), in 2017 there were 8.4 million data centers worldwide. According to [this study from 2014](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwjlgOjt7vnpAhU16KYKHXbRAvwQFjAAegQIMhAB&url=https%3A%2F%2Fwww.oecd-ilibrary.org%2Fenterprises-by-size_5jfnl5hdgq8x.pdf%3FcontentType%3D%26itemId%3D%25252Fcontent%25252Fchapter%25252Fentrepreneur_aag-2017-5-en%26mimeType%3Dapplication%25252Fpdf%26containerItemId%3D%25252Fcontent%25252Fserial%25252F22266941%26accessItemIds%3D&usg=AOvVaw2O_d7TEWnFY-n3zTigTuzZ), the total sum of all enterprises out of the countries they included was 49,290,298. This study unfortunately leaves out some huge countries such as China, India and Indonesia. According to another study, there were [34.7 million](https://www.statista.com/statistics/1008055/china-number-of-registered-companies/) companies in China in 2018. In India in 2018, [1.9 million](https://www.livemint.com/Companies/S7Ri5aQEAMIaiikRpMYRNI/Only-66-of-registered-companies-in-India-are-active-Govt-d.html). As a rough estimate, considering many smaller countries are not counted here, I estimate that there are 100 million companies worldwide. This is most likely not 100% correct but should be OK as an estimate. So that means that 57% of 100 million is 57 million, and 45% of 8.4 million is 3.78 million. Combine these and you get that 60.78 out of 108.4 can be expected to be affected by DoS attacks. This is ~56%. 

To get a more accurate number, I found another sources by [Radwire](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiXp_SN8_npAhUp7KYKHeBfDPEQFjANegQICxAB&url=https%3A%2F%2Fwww.radware.com%2Fpleaseregister.aspx%3FreturnUrl%3D6442459502&usg=AOvVaw0ORU2iDOSV_yg6FUl6v6wp) that states that ~36% of organizations suffered from DDoS attacks in 2016. 

Another source from [GlobalDots](https://www.globaldots.com/ddos-distributed-denial-of-service-explained) states that at least 55% of all cyber crime constitute DoS and DDoS attacks. Combine this with a number from the same Radwire report above which states that 98% of all organizations suffered from cyber crime in 2016, you get that 53.9% of organizations are expected to suffer from DoS/DDoS attacks. 

Taking the average of these 3 sources/calculations, you get that the expected chance to be vulnerable to DoS type attacks is (56+36+53.9)/3 = 48.6333...%. This is ```Bernoulli(0.4863)```. 

## Time to compromise

I found one source saying the [average length of a DDoS attack was 218 minutes](https://securelist.com/ddos-attacks-in-q4-2018/89565/), which is roughly
```Exponential(6.6)```. Note that this is to be interpreted as "how long is the attack expected to last". 

## Result
These findings indicate that the TTC for the attack step "Network Denial Of Service" is `` Bernoulli(0.4863)*Exponential(6.6) ``. 

## Discussion

It isn't entirely clear to me how these findings are different from anything concerning the similar attack also listed in the ATT&CK matrix, known as Endpoint Denial of Service https://attack.mitre.org/techniques/T1499/. Right now it seems to me like they are the same general kind of attack but with different targets. Endpoint is about " availability of services to users " while Network is about " availability of targeted resources ". 

It can also be discussed if it is reasonable that 3% of all websites suffering from a DoS attack means that every website has the same exponential distribution, since some networks/sites are going to be targeted more often than others. Presumably, the larger and more well known the website or service is, the higher the chance of a DoS attack to be attempted. However, the more well known sites and services are also presumably going to have better defenses against these attacks, so maybe the total difference is not huge. 

## Unused sources

A study [from 2017 on a Macroscopic Characterization of the DoS Ecosystem](https://www.caida.org/publications/papers/2017/millions_targets_under_attack/millions_targets_under_attack.pdf) found that on average, 3% of websites were involved in a DoS attack per day. 