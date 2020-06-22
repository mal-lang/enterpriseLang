# Trusted Relationship

## Context 

https://attack.mitre.org/techniques/T1199/
Adversaries may breach or otherwise leverage organizations who have access to intended victims. Access through trusted third party relationship exploits an existing connection that may not be protected or receives less scrutiny than standard mechanisms of gaining access to a network.

Organizations often grant elevated access to second or third-party external providers in order to allow them to manage internal systems as well as cloud-based environments. Some examples of these relationships include IT services contractors, managed security providers, infrastructure contractors (e.g. HVAC, elevators, physical security). The third-party provider's access may be intended to be limited to the infrastructure being maintained, but may exist on the same network as the rest of the enterprise. As such, Valid Accounts used by the other party for access to internal network systems may be compromised and used.

https://books.google.fr/books?id=zMNZDwAAQBAJ&pg=PA68&lpg=PA68&dq=indirect+cyber+attack+through+trusted+partner&source=bl&ots=IQ4e37zAlz&sig=ACfU3U3rn8PIeckxBU_qgLUYMzgXF-pCcg&hl=fr&sa=X&ved=2ahUKEwjxnYDNq_zpAhWDxIUKHVvPBRMQ6AEwAHoECAYQAQ#v=onepage&q=indirect%20cyber%20attack%20through%20trusted%20partner&f=false
In order to perform this attack step, the adversary has to get a compromised access to a company network which has access to the target's network  itself. Adversaries may use any of the tactics mentioned in the MITRE ATT&CK framework to compromise this trusted partners.

## Relevant findings

### Success rate
accenture.com/_acnmedia/PDF-116/Accenture-Cybersecurity-Report-2020.pdf
On average, cybersecurity
programs actively protect only about 60 percent
of an organization’s business ecosystem. Meaning that 40% of the business ecosystem is vulnerable. That is
an issue when 40 percent of breaches come via
this route. In such an environment, few
organizations have the luxury of standing still.
Fully 83 percent of our respondents agreed that
their organizations need to think beyond securing
their enterprises and take steps to secure their
ecosystems to be effective. 

### TTC
In order to find an average time to compromise for entire company networks (which we assume to be weaker than the target's, causing the adversary to use them to get access to the target's network), we can try and assess a "standard TTC" for weaker companies using the 2018 Verizon Report.
https://enterprise.verizon.com/resources/reports/DBIR_2018_Report_execsummary.pdf
This report suggest that most (87%) compromises take minutes or less, while others are rather equally distributed between hours, days, weeks and months. Based on that we can assess a "standard TTC" represented by the ``[TruncatedNormal(0.042,0.021)]`` (average of 1 hour, 95% of values between 0 and 2 hours)
## Additional findings 

About overall mitigation efficiency and overall attack success rate: 
accenture.com/_acnmedia/PDF-116/Accenture-Cybersecurity-Report-2020.pdf
With only a little more than half (55%) of their
organization covered by their cybersecurity
programs, non-leaders are at risk of having many
areas unprotected. This contrasts with leaders
who are able to cover 85 percent of their
organization with their cybersecurity programs.
The difference reflects a substantial gap in
protection between the two groups. 

The performance target for non-leaders is
to reduce the number of cyberattacks that
result in a security breach from 1-in-8 (12.5%) to
1-in-27 (3.7%) or better.
When attempting to reduce the number
of security breaches, leaders say they
benefit most from using the following
three cybersecurity technologies:
Next-Generation Firewall (NGF);
Security Orchestration Automation and
Response (SOAR) and Privileged Access
Management (PAM).

## Results 

Based on the findings and assuming that the professional adversary purposely attacks a weaker company, that has a trusted relationship with the target company, we can assume that the probability of success of an attack through trustedRelationship is ``[Bernoulli(0.40)*TruncatedNormal(0.042,0.021)]``. 