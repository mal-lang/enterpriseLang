# Audio Capture

## Context  https://attack.mitre.org/techniques/T1123/

An adversary can leverage a computer's peripheral devices (e.g., microphones and webcams) or applications (e.g., voice and video call services) to capture audio recordings for the purpose of listening into sensitive conversations to gather information.

Malware or scripts may be used to interact with the devices through an available API provided by the operating system or an application to capture audio. Audio files may be written to disk and exfiltrated later.

https://capec.mitre.org/data/definitions/634.html
In the CAPEC framwork, this technique is related to the Video Capture one. We assume taht the malware used for Video Capture is the same or very similar to the one that can be leveraged for audio Capture. We'll use the same probability distribution for both techniques in this regard.

## Findings from Video Capture 

### Prevalence
http://www.storiprotection.fr/EagleEye.pdf
In January 2017, in a ransomware cyber attack, cyber criminals infected 70 percent of the 187 video storage
devices that record data from federal surveillance cameras in Washington D.C., taking video recording offline for
about four days, just prior to the presidential inauguration.

We assume that the cyber attackers only infected 70% because they didn't manage to infect all of the devices. We also assume that infecting the video storage device grants them access to stored recordings and control over cameras (since they managed to shut them down for 4 days). 

http://zugara.com/webcam-penetration-rates-adoption
According to Zugara research 78% of users have webcams. 

We can use those 2 values to assess the prevalence of this technique (74%).

### TTC 

When it comes to webcam video blackmailing, several sources say that once the adversary has watched "long enough"  they have sufficient data to start blackmailing victims. There is no more detailed to be found on the net. We will use the ordinal distribution [Exponential(0.1)] (~10 days) which seems like a reasonable time to collect sensitive data via Video Capture.

## Results

[Bernoulli(0.74)*Exponential(0.1)]




