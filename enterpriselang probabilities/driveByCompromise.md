# Summary of findings on speaphishing via service

I worked on Drive-By Compromise attackStep.

Assuming the prefesionnal adversary has knowledge of the target's most visited websites, there are 3 main attacks to consider in this attack step : 
 - A legitimate website is compromised where adversaries have injected some form of malicious code such as JavaScript, iFrames, and cross-site scripting.
 - Malicious ads are paid for and served through legitimate ad providers.
 - Built-in web application interfaces are leveraged for the insertion of any other kind of object that can be used to display web content or contain a script that executes on the visiting client (e.g. forum posts, comments, and other user controllable web content).

## Legitimate website injected code (XSS)

http://www.ijiser.com/paper/2017/vol4issue8/Aug2017p101.1.pdf
If website has previously been compromised by the adversary, they can inject malicious script on the website to get the user's cookies and comprise the user. The probability for this attack to succeed is 1 : as soon as the user arrives on the website, the code executes. 
Considering the targeted website is one of the most visited by the target, we assume that the user checks it on average once a day. We'll use the `` [Exponential(1)] `` probability distribution to represent the time it will take for the target to visit the website. 

However we could try to find a probability distribution for the defacement attackStep. (compromising the targeted website(s)) or add a Bernoulli distribution to represent the fact that the website compromise will not always be successful

https://www.acunetix.com/acunetix-web-application-vulnerability-report-2019/#xss / https://cdn2.hubspot.net/hubfs/4595665/Acunetix_web_application_vulnerability_report_2019.pdf
According to the Acunetix Web Application Vulnerability Report 2019, about 32% of websites and web apps are vulnerable to XSS attacks. 

We can then use the `` [Bernoulli(0.32)*Exponential(1)] `` probability distribution for this attack step.

## Malvertising

If the adversary buys advertising space on the targeted website(s), his malicious ad (in which malicious script is hidden) might be seen by the user. Given the low CPM (Cost Per Mille (cost paid by the adversary every 1000 impressions) https://www.adstage.io/resources/q1-2020-ppc-benchmark-report/), and the assumption that the adversary is professional, we assume that this attack will eventually succeed (the adversary has a lot of money). However what may vary is the time it will take for the user to actually see the ad.

This time will depend on the time it takes for the ad to be in the ad provider's database, and the probability of the ad being displayed as the user visits the website. 

https://www.youtube.com/watch?v=rTg9l4d8MU4 > However ads are served if a campaign is targeting someone and bidders can bid to get their ad to be served, thus we can assume that the professional adversary will be able to create a targeted ad at the target, and put the price so that their ad is served to the target.


Based on what we found, ads are usually reviewed within 24 hours before being served (for facebook : https://www.facebook.com/business/help/204798856225114?id=649869995454285). With enough investment from the attacker, and a well targeted ad, the ad will be 100% sure to be displayed the next time the target visits the website. We can thus assume, based on the time before the ad is served and the average time before checking most visited websites, that the ad will be seen between 1 to 2 days after being submitted to the ad provider. We can represent that with either a `` Uniform(1,2) `` or a `` Gamma(9,0.167) `` probability distribution.


## Built-in interface compromise

If the website uses unmoderated interactive forum or comment interface (look for Bernoulli distribution?, however this attack can only be performed in this scenario so maybe it doesn't make sense), the attacker may inject hidden code/script to a post. Therefore, as soon as the post is loaded on any visitor's screen, the malicious script executes and the user is compromised.

The probability distribution for this depends on the likelihood of the user seeing the post and the time it will take for him to do so. Assuming that the user sees the post as soon as he visits the website we only have to worry about a visit time. (We assume that since this is their most visited website, the target will load the post) So the probability will be the same as for injected code on legitimate website `` [Exponential(1)] ``

This technique is performed via cross-site scripting (XSS), just like legitimate code injection. We can thus asses the probability to be the same as in the first point :   `` [Bernoulli(0.32)*Exponential(1)] `` 



## Discussion 

Maybe the malvertising attack can fail if the ad provider is able to filter malicious ads, in which case we should research for the probability that a malicious ad is successfully displayed by the provider and maybe add it as a Bernoulli distribution. So maybe we could add a probability for the adversary to compromise/fool the ad provider.
