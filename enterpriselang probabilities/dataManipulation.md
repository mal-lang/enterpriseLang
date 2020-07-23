# Data Manipulation

## Context https://attack.mitre.org/techniques/T1565/001/

Adversaries may insert, delete, or manipulate data at rest in order to manipulate external outcomes or hide activity. By manipulating stored data, adversaries may attempt to affect a business process, organizational understanding, and decision making.

Stored data could include a variety of file formats, such as Office files, databases, stored emails, and custom file formats. The type of modification and the impact it will have depends on the type of data as well as the goals and objectives of the adversary. *For complex systems, an adversary would likely need special expertise and possibly access to specialized software related to the system that would typically be gained through a prolonged information gathering campaign in order to have the desired impact.*

## Relevant findings

https://threatpost.com/what-is-a-data-manipulation-attack-and-how-to-mitigate-against-them/141563/
Data Manipulation is a rather stealthy attack that is hard to pull out but hard to detect as well. It can also be very effective depending on the goal of the adversary (business disruption mainly). 
As mentioned in the MITRE description, the form of this technique can vary a lot and the adversary must have some kind of expertise in order to pull this out.

https://www.lexology.com/library/detail.aspx?g=2cbd967d-0dcc-4adb-a16f-417b7479cec7
The manipulation could be use to modify figures in a company, and may have disastrous impact. For instance, the modification of medical data could result in wrong treatments to patients causing their death. 

Other findings suggest the same, with enough time, patience and expertise, and adversary could achieve their intended goal through Data Manipulation. Moreover, this type of attack is said to be very hard to detect and is performed over time.

It's hard to find relevant papers on this technique considering how abstract it is. However, all findings agree on the fact that it's really hard to detect and can achieve disastrous goals if the adversary puts enough time in it.

We'll use the findings for the main mitigation to this technique, Encryption, to estimate 

## Results

We'll use one of the ordinal distributions that can be found on the MAL wiki page. This technique seems to be Very Hard and Certain, so we'll use the [Bernoulli(0.65833)*Exponential(0.02)] distribution.
We use 0.02 instead of 0.01 because securiCAD results are only shown over 100 days, so a 50 days mean seems reasonable to represent the time necessary to best perform this technique. 

## Discussion

Data Encryption isn't the only mitigation for this technique and its sub techniques but it's the main and more effective one so we used its results in order to assess the prevalence. Further work on this technique is welcome.