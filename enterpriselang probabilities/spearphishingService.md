# Summary of findings on speaphishing via service

I worked on Spearphishing via Service attackStep. [1]

There are 2 main spearphishing attacks to consider in this attack steps : spear phishing via personal email service and spear phishing via social media (others are neglected).

## Spearphishing via personal email service
For spear phising via personal email, I didn't find anything that would suggest different results from what Lina found on spearphishing via email (corporate service), only papers supporting her results [6]. Her findings can be used to assess the probability of a successful spearphishing attack and are supported by another research paper I found. The only difference between those two services are that corporate email services may filter more spam and standard phishing emails but spearphishing emails are highly likely to avoid this filter. Users on average check email once a day so the average time to compromise will be 1 day. We'll use the `` [Bernoulli(0.712)*Exponential(1)] `` distribution for personal email service.

## Spearphishing via social media

As for social media, the success rate of a spearphishing attack may depend on usage frequency (how often people use social media) [4], and users trust [5] in the different social media. This study [2] suggested a success rate for attack on Facebook of 44.75% with a standard deviation of 24,25%.
As far as Twitter is concerned, this study [3] suggests a 30-66% success rate of spearphishing attacks which can be compared to the results for Facebook and supports them.
Those results can be supported by the trust factor on these social media and considered as similar on other social media (WhatsApp, Snapchat, Instagram...)

LinkedIn being the most trusted social media, and the one on which a lot of professional info is exchanged, it is suggested in findings that the success rate of spearphishing attacks on LinkedIn is significantly higher than on other social media, however I didn't find enough reliable data to draw a conclusion on the success rate of attacks via LinkedIn.

Users on average check social media once a week so the average time to compromise will be 3.5 days 

From what we collected we'll use the `` [Bernoulli(0.4475)*Exponential(0.286)] ``  


## Discussion 
(I couldn't find substantial data on on which social media these attacks happen the most, nor on wether it happens more on personal email or social media even though reports suggest that the amount of spearphishing attacks via social media is drastically increasing each year (+500% in 2016) and spearphishing via personal email isn't increasing as fast. Lacking data to assess the share of each probability distribution we could give half of the weight to each probability distribution.)

The social media probability distribution could be enhanced with more data on each social media and by giving a weight to each social media based on how many attacks are conduted through them. 


[1] : https://attack.mitre.org/techniques/T1194/

[2] : https://academic.oup.com/jcmc/article/20/1/83/4067561

[3] : https://www.blackhat.com/docs/us-16/materials/us-16-Seymour-Tully-Weaponizing-Data-Science-For-Social-Engineering-Automated-E2E-Spear-Phishing-On-Twitter-wp.pdf

[4] : https://www.pewresearch.org/internet/2016/11/11/social-media-update-2016/

[5] : https://www.businessinsider.com/linkedin-pinterest-instagram-top-spots-2019-digital-trust-report-facebook-stays-last?IR=T 

[6] : https://www.researchgate.net/publication/261384277_Towards_understanding_phishing_victims%27_profile#pf4