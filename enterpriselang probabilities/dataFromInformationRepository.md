# Data from Information Repositories

## Context https://attack.mitre.org/techniques/T1213/

Adversaries may leverage information repositories to mine valuable information. Information repositories are tools that allow for storage of information, typically to facilitate collaboration or information sharing between users, and can store a wide variety of data that may aid adversaries in further objectives, or direct access to the target information.

Adversaries may also collect information from shared storage repositories hosted on cloud infrastructure or in software-as-a-service (SaaS) applications, as storage is one of the more fundamental requirements for cloud services and systems.

The following is a brief list of example information that may hold potential value to an adversary and may also be found on an information repository:

- Policies, procedures, and standards
- Physical / logical network diagrams
- System architecture diagrams
- Technical system documentation
- Testing / development credentials
- Work / project schedules
- Source code snippets
- Links to network shares and other internal resources

Information stored in a repository may vary based on the specific instance or environment. Specific common information repositories include Sharepoint, Confluence, and enterprise databases such as SQL Server.

More on Sharepoint and Confluence here : https://www.process.st/confluence-vs-sharepoint-intranet-software/

## Relevant findings

### Companies using Sharepoint 

https://www.quora.com/Whats-the-number-of-companies-actively-using-SharePoint-worldwide#:~:text=Microsoft%20is%20adding%20approximately%2020%2C000,on%20it%20for%20document%20management.
According to this wource, 80 percent of Fortune 500 companies use Microsoft SharePoint. 83 percent of companies using Microsoft SharePoint depend on it for document management. We assume that this value can be used to approximate SharePoint usage among all companies.

### Companies using Confluence

https://www.atlassian.com/customers
83% of Fortune 500 companies use Atlassian products (that is to say one or several among those 3 : Confluence for Document collaboration, Jira Software to Plan, track, and release, Jira Service Desk an IT service desk & customer service). Unable to find more precise values we assume that 
this value can be used to approximate Confluence usage among all companies.

### TTC 

#### SharePoint
https://office365itpros.com/2019/05/09/limiting-sharepoint-storage-teams/
By default, SharePoint Online uses a central pool of storage that all sites draw upon on an as-needed automatic basis up to a maximum of 25 TB per site. Sounds good, because who wants to keep a close eye on site storage quotas to adjust them whenever sites need more space to allow users to store documents and do other useful work. But the downside is that if you allow free creation of Office 365 groups and teams, the central pool can be absorbed quicker than you anticipate and force the tenant to buy more storage from Microsoft just to keep operations running.

Enterprise tenants get 1 TB of SharePoint storage plus 10 GB per licensed Office 365 account. The new SharePoint Online Admin Center makes it easy to see how much storage the tenant has and what sites are consuming most storage. You can also export details of sites to a CSV file to dice and slice the data as you want.

#### Confluence 

Here are the Confluence storage by user values for different subscriptions. Companies may spend more to get "unlimited storage".	
|Subscription|Storage|
|---|---|
|Free	|2 GB|
|Standard|	250 GB|
|Premium	|Unlimited|

#### Assumption
According to several sources, storage may vary a lot depending on the company's size and how much money they put into increasing storage. Without any precise value on the size available to one average user, we'll use the data storage for one user found in the [automatedCollection.md] file. We can assume that a professional user can use techniques similar to the one described in the [automatedCollection.md] in order to collect sensible data faster. 

## Results 

### Data from Information Repositories

The TTC will be carreid by this one. We'll use the [Exponential(9.952)] distribution.

### Confluence

This is the combination of the percentage of Confluence Users and the accuracy of the technique described in  [automatedCollection.md].
0.83*0.892 = 0.74
[Bernoulli(0.74)]

### SharePoint

This is the combination of the percentage of SharePoint Users and the accuracy of the technique described in  [automatedCollection.md].
0.8*0.892 = 0.71
[Bernoulli(0.71)]

## Discussion

### About Fortune 500 companies values 

We assumed that the usage in Fortune 500 companies can be used to approximate usage among all companies. Smaller companies with less budget and resource management needs might not use these softwares but we chose to use Fortune 500 values as a reference.

### About SQL databases 

SQL database isn't taken into account as a sub technique for the Data from Information Repositories technique. We decided to stick to the MITRE framework and not have it in the entrepriseLang.mal. 
Here is a useful source to assess SQL database usage in companies : https://www.itprotoday.com/sql-server/survey-shows-companies-now-have-more-sql-server-databases-oracle-databases

### About TTC

The TTC could be improved by finding more accurate values for storage per user.