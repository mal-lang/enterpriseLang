# Video Capture

## Context https://attack.mitre.org/techniques/T1125/

An adversary can leverage a computer's peripheral devices (e.g., integrated cameras or webcams) or applications (e.g., video call services) to capture video recordings for the purpose of gathering information. Images may also be captured from devices or applications, potentially in specified intervals, in lieu of video files.

Malware or scripts may be used to interact with the devices through an available API provided by the operating system or an application to capture video or images. Video or image files may be written to disk and exfiltrated later. This technique differs from Screen Capture due to use of specific devices or applications for video recording rather than capturing the victim's screen.

In macOS, there are a few different malware samples that record the user's webcam such as FruitFly and Proton.

## Relevant findings

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


