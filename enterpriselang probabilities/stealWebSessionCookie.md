# Steal Web Session Cookie 

## Context (https://attack.mitre.org/techniques/T1539/)

An adversary may steal web application or service session cookies and use them to gain access web applications or Internet services as an authenticated user without needing credentials. Web applications and services often use session cookies as an authentication token after a user has authenticated to a website.

Cookies are often valid for an extended period of time, even if the web application is not actively used. Cookies can be found on disk, in the process memory of the browser, and in network traffic to remote systems. Additionally, other applications on the targets machine might store sensitive authentication cookies in memory (e.g. apps which authenticate to cloud services). Session cookies can be used to bypasses some multi-factor authentication protocols.

There are several examples of malware targeting cookies from web browsers on the local system. There are also open source frameworks such as Evilginx 2 and Muraena that can gather session cookies through a man-in-the-middle proxy that can be set up by an adversary and used in phishing campaigns.

After an adversary acquires a valid cookie, they can then perform a Web Session Cookie technique to login to the corresponding web application.

## Relevant findings

https://www.researchgate.net/publication/220496661_Session_Management_Vulnerabilities_in_Today's_Web
According to this source, web cookies can be stolen either through Cache Sniffing or XSS Cookie sniffing. 
The following vulnerabilities identify where an adversary might be able to steal Web Session Cookies
4. Session ID in cookies but without the secure flag : Although HTTPS is used, the cookie can also be transmitted on unciphered connections. 93%
5. Session ID in cookies without the HTTPOnly flag : The cookie can be read with client-side scripts, through cross-site scripting (XSS) attacks. 76%
18. Session ID represented by a cookie with the wrong scope and path : The application uses a cookie as a session ID with a domain scope and path that are larger than the application’s. 22%
Assuming the worst case scenario, we'll use the [Bernoulli(0.93)] distribution in order to represent the probability for an adversary to steal Web Session Cookies.

https://owasp.org/www-community/attacks/Session_hijacking_attack
Cookies seem to be easy to steal if vulnerable so we'll assume the TTC to be instant.

## Results

We assess the probability distribution for this technique to be [Bernoulli(0.93)]
