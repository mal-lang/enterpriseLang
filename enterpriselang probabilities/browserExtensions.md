# [Browser Extensions](https://attack.mitre.org/techniques/T1176/)
"Browser extensions or plugins are small programs that can add functionality and customize aspects of internet browsers. They can be installed directly or through a browser's app store. Extensions generally have access and permissions to everything that the browser can access.

Malicious extensions can be installed into a browser through malicious app store downloads masquerading as legitimate extensions, through social engineering, or by an adversary that has already compromised a system"

## Prevalence
According to [Cisco's 2016 Annual Security Report](https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwjQuta00ojqAhVGUZoKHT9YAygQFjAAegQIARAB&url=http%3A%2F%2Fmkto.cisco.com%2Frs%2F564-whv-323%2Fimages%2Fcisco-asr-2016.pdf&usg=AOvVaw1nLayTNlhdlV3tF_LfCxLf), an estimated 85 percent of organizations are affected by malicious browser extensions. This corresponds to ```Bernoulli(0.85)```. 

## Time to compromise
I'm not sure if this should be interpreted as:
* The time for an average user to install a new malicious extension, or
* The time needed for a malicious extension on a machine to execute its functions
For now, I've left out the time to compromise and will only use the probability of a malicious extension being present in an organization at all. 

## Result
The probability distribution for this attack step comes out to ```Bernoulli(0.85)```.