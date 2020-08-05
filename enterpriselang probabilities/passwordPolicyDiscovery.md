# Password Policy Discovery

## Context https://attack.mitre.org/techniques/T1201/

Adversaries may attempt to access detailed information about the password policy used within an enterprise network. Password policies for networks are a way to enforce complex passwords that are difficult to guess or crack through Brute Force. This would help the adversary to create a list of common passwords and launch dictionary and/or brute force attacks which adheres to the policy (e.g. if the minimum password length should be 8, then not trying passwords such as 'pass123'; not checking for more than 3-4 passwords per account if the lockout is set to 6 as to not lock out accounts).

Password policies can be set and discovered on Windows, Linux, and macOS systems via various command shell utilities such as net accounts (/domain), chage -l , cat /etc/pam.d/common-password, and pwpolicy getaccountpolicies.

## Results

https://superuser.com/questions/150675/how-to-display-password-policy-information-for-a-user-ubuntu / https://www.jamf.com/jamf-nation/discussions/18574/user-password-policies-on-non-ad-machines
Adversaries can perform this technique in no time with User Rights. 

We assess the probability distribution for this technique as binary. 
We added a probability for the bruteForceWithPasswordPolicy using the following source : https://press.avast.com/83-of-americans-are-using-weak-passwords We assumed the results on american users could be expanded to all users. 83% of users have weak passwords.

We improved the probability distribution for brute force using the following source : https://www.itprotoday.com/identity-management-and-access-control/most-organizations-have-password-policies-half-dont-enforce
According to OneLogin, less than half (49 percent) of respondents require their internal users to follow a basic password complexity policy. We'll use this value to represent how policy discovery helps brute forcing. 0.51*0.83= 0.42
We assumed that with policies, the adversary know whether or not they can try brute Forcing and what technique to use, wwhich is represented by a better likelihood of success. 