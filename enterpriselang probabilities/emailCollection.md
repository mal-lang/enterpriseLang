# Email Collection 

## Context https://attack.mitre.org/techniques/T1114/

Adversaries may target user email to collect sensitive information. Emails may contain sensitive data, including trade secrets or personal information, that can prove valuable to adversaries. Adversaries can collect or forward email from mail servers or clients.

### Email Forwarding Rule

Adversaries may setup email forwarding rules to collect sensitive information. Adversaries may abuse email-forwarding rules to monitor the activities of a victim, steal information, and further gain intelligence on the victim or the victim’s organization to use as part of further exploits or operations. Outlook and Outlook Web App (OWA) allow users to create inbox rules for various email functions, including forwarding to a different recipient. Messages can be forwarded to internal or external recipients, and there are no restrictions limiting the extent of this rule. Administrators may also create forwarding rules for user accounts with the same considerations and outcomes.

Any user or administrator within the organization (or adversary with valid credentials) can create rules to automatically forward all received messages to another recipient, forward emails to different locations based on the sender, and more.

### Local Email Collection

Adversaries may target user email on local systems to collect sensitive information. Files containing email data can be acquired from a user’s local system, such as Outlook storage or cache files.

Outlook stores data locally in offline data files with an extension of .ost. Outlook 2010 and later supports .ost file sizes up to 50GB, while earlier versions of Outlook support up to 20GB. IMAP accounts in Outlook 2013 (and earlier) and POP accounts use Outlook Data Files (.pst) as opposed to .ost, whereas IMAP accounts in Outlook 2016 (and later) use .ost files. Both types of Outlook data files are typically stored in C:\Users\<username>\Documents\Outlook Files or C:\Users\<username>\AppData\Local\Microsoft\Outlook.

### Remote Email Collection

Adversaries may target an Exchange server or Office 365 to collect sensitive information. Adversaries may leverage a user's credentials and interact directly with the Exchange server to acquire information from within a network. Adversaries may also access externally facing Exchange services or Office 365 to access email using credentials or access tokens. Tools such as MailSniper can be used to automate searches for specific keywords.


## Relevant findings & Associated results

https://www.echoworx.com/email-security-sensitive-information/
One out of every four corporate emails contain attachments that include sensitive personal or business data. The majority of emails are openly sent without any form of encryption; 61 percent of employees admit sending confidential information through open email channel. 

### Email Forwarding Rule

https://www.textrequest.com/blog/how-many-emails-do-people-get-every-day/
The average mail user receives an average of 88 emails per day, but they only send 34 emails per day. (total: 122)

Considering 1/4 emails contain sensitive data, that means one sensitive email is sent or received every ~0.79 hour.

Any user or administrator within the organization (or adversary with valid credentials) can create rules to automatically forward all received messages to another recipient, forward emails to different locations based on the sender, and more.

The probability distribution for this sub technique is [Exponential(30.38)] but this only represents the time needed to collect 1 sensitive mail whereas other sub technique might give a lot more data. 

In order to collect the same amount of sensitive data that with other sub technique it would take several days, even weeks. We'll arbitrarily assume that the adversary will be satistifed with 15GB of data collected (based on the total size of smaller email accounts (see below)). It would take ~1639 days -> [Exponential(0.00061)]. This technique is significantly slower when it comes to collection of great amounts of data.


### Local Email Collection

Outlook stores data locally in offline data files with an extension of .ost. Outlook 2010 and later supports .ost file sizes up to 50GB, while earlier versions of Outlook support up to 20GB. IMAP accounts in Outlook 2013 (and earlier) and POP accounts use Outlook Data Files (.pst) as opposed to .ost, whereas IMAP accounts in Outlook 2016 (and later) use .ost files. Both types of Outlook data files are typically stored in C:\Users\<username>\Documents\Outlook Files or C:\Users\<username>\AppData\Local\Microsoft\Outlook.

https://www.lifewire.com/what-is-the-average-size-of-an-email-message-1171208#:~:text=Email%20size%20is%20determined%20by%20much%20more%20than%20just%20the%20message&text=The%20average%20size%20of%20an,text%20or%20about%2037.5%20pages.
The average size of an email file is about 75 KB. 

https://www.litmus.com/blog/the-2017-email-client-market-share-infographic/
Outlook 2016 has replaced Outlook 2010 as the most popular Outlook version, with 37% of all emails opened on an Outlook desktop client now being opened on Outlook 2016. That means more than 37% of people use Outlook 2010. We couldn't find more precise data so we'll assume all Outlook users use Outlook 2010 or older. 

These 2 results help us assess that local files may store about 666667 emails. Considering 1/4 emails are sensitive, we'll assume that the adversary will find sensitive data in any local mail storage.

These directories are accessible with simple user rights with no restriction. 

Using the results from the [automatedCollection.md] file, we can estimate the time it would take to identify and collect sensitive data in those files. Assuming the directory is full, it would take ~904.4 s to collect this data (with the S3 software as reference). 

That can be represented via the [Bernoulli(0.892)*Exponential(95.58)] distribution. 

### Remote Email Collection

https://www.lifewire.com/what-is-the-average-size-of-an-email-message-1171208#:~:text=Email%20size%20is%20determined%20by%20much%20more%20than%20just%20the%20message&text=The%20average%20size%20of%20an,text%20or%20about%2037.5%20pages.
Storage Limits for Email Clients
Most email providers have generous storage policies as well as methods to see how much space your storage allotment has remaining. Still, popular email providers have different size limits, such as those listed below:

- Gmail accounts receive 15 GB of storage space, but that space is shared by Gmail, Google Drive, and other Google services you may use. Storage space doubles to 30GB on the Basic plan. 
- Yahoo Mail accounts come with 1 TB of storage. Yahoo claims this capacity can accommodate 6,000 years of inbox usage for the average user.
- *Free* Outlook.com accounts come with 15 GB of email storage. Upgrading to Office 365 gets you an ad-free inbox, 50GB mail storage and a vast 1TB of OneDrive storage (https://www.techradar.com/news/best-email-provider)
- AOL offers 25 GB of storage for new messages, 100 GB of storage for old messages, and 100 GB for sent messages.
- https://support.apple.com/en-us/HT203093#:~:text=With%20Mail%20Drop%2C%20you%20can,count%20against%20your%20iCloud%20storage. You reached the 1 TB Mail Drop storage limit. 

https://www.litmus.com/blog/infographic-the-2019-email-client-market-share/
- Gmail, 27.8%
- Apple iPhone, 27.6% 
- Outlook, 9.1%
- Apple iPad, 8.5%
- Apple Mail, 7.5%
- Yahoo! Mail, 6.3%
- Google Android, 2.5%
- Outlook.com, 2.3%
- Samsung Mail, 1.6%
- Thunderbird, 0.5%

When computing that's an average of 135.76 GB storage size per mail account. That would take 2455.56 s to process using the technique mentioned in the [automatedCollection.md] file. That can be represented by the [Bernoulli(0.892)*Exponential(35.19)] distribution

## Discussion

The Email Forwarding Rule distribution in particular may be improved. It's significantly different from others and a lucky adversary may find relevant data quickly but it's still much slower than the 2 others.