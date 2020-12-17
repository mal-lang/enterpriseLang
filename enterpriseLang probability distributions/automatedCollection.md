# Automated Collection

## Context (https://attack.mitre.org/techniques/T1119/)

Once established within a system or network, an adversary may use automated techniques for collecting internal data. Methods for performing this technique could include use of a Command and Scripting Interpreter to search for and copy information fitting set criteria such as file type, location, or name at specific time intervals. This functionality could also be built into remote access tools.

This technique may incorporate use of other techniques such as File and Directory Discovery and Lateral Tool Transfer to identify and move files.

## Relevant findings 

https://link.springer.com/article/10.1186/s42400-018-0011-x
This paper relates the findings of a researcher team which developped a software called S3 which identifies sensitive data. S3 classifies sensitive data as multiple categories such as credential data, profile data and financial data, in a more fine-grained way, so that users and developers are able to choose different categories of sensitive data on demand for further protection.
According to their report, S3 achieves an average precision of 89.2%, and average recall 95.8% in identifying sensitive data.
Besides, in the experiment carried out, the total time of processing 20,000 texts was 8682.4 s. The average time for each text is 0.43 s.
We could assume that a professional adversary could use such a software to detect and identify sensitive data. 

https://blog.online-convert.com/average-file-sizes/
https://superuser.com/questions/351791/what-is-a-general-rule-of-thumb-for-file-sizes-in-kb-mb-gb-etc#:~:text=For%20text%20files%2C%20it%20depends,1%20to%204%20bytes%2Fchar.
https://www.lehman.cuny.edu/faculty/hoffmann/itc/techteach/files/filesize.html
According to several sources, the average size of text files is ~26kB. Combined with the previous results that means S3 analyzed roughly 480GB in   4s. 

https://www.spiceworks.com/marketing/reports/storage-trends-in-2020-and-beyond/
This survey lists the Data Storage needs for small&medium size business and enterprises. We'll use that to roughly estimate the amount of data storage available to 1 employee. We'll assume that small business have 50employees, medium ones 500 and bigger ones 5000. We'll take the middle value for all ranges in the report too. This gives us the following : 
``5/(0.45*50+0.2*500+0.06*5000)+25/(0.34*50+0.43*500+0.08*5000)+75/(0.11*50+0.15*500+0.14*5000)+150/(0.03*50+0.07*500+0.14*5000)+350/(0.07*50+0.14*500+0.49*5000)``

With that value in mind,  ~478 GB is the average amount of data available to an average network user in a company. This value is close enough to the 480GB found for the 20000 files processed by S3. We'll use the finding as a result.

## Results

We assess the probability distribution for this technique to be [Bernoulli(0.892)*Exponential(9.952)]

## Discussion

The results here are rough estimations based on the findings. A lot of assumptions are made and the value may be discussed with better findings. One of the main assumptions that can be discussed is that the files on clouds or peripheral devices aren't taken into consideration.