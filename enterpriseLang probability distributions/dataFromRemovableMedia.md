# data From Removable Media

## Context https://attack.mitre.org/techniques/T1025/

Adversaries may search connected removable media on computers they have compromised to find files of interest. Sensitive data can be collected from any removable media (optical disk drive, USB memory, etc.) connected to the compromised system prior to Exfiltration. Interactive command shells may be in use, and common functionality within cmd may be used to gather information.

Some adversaries may also use Automated Collection on removable media.

## Relevant Findings

https://www.darkreading.com/risk/nearly-40-percent-of-it-decision-makers-report-unintentional-exposure-of-corporate-data-through-theft-or-loss-of-removable-devices/d/d-id/1137235
According to the survey, 37 percent of IT decision makers reported that their business had unintentionally exposed corporate data through theft or loss of removable devices in the past two years. Despite this, only 34 percent enforce encryption on all removable devices allowed on their networks (25 percent in the U.S. and 51 percent in Canada). 91 percent of IT decision makers report that their company allows the use of removable storage devices on the corporate network. These devices allowed include, USB flash drives (83 percent), smartphones (72 percent), external hard drives (65 percent), tablets (62 percent), optical media (49 percent) and memory cards (56 percent).
For complete survey methodology, including weighting variables, please contact imation@schwartzmsl.com.

We assume the results of this survey can be used for all companies (not only US and Canada ones)

91% of companies allow usage of removable devices but only 34% of them enforce encryption (0.34x0.91=0.31). Taht means that (0.91-0.31=0.60) 60% of companies are exposed to Data collection From Removable Media. Using the Automated Collection technique described in the [automatedCollection.md] file, we assess the prevalence for this technique to be represented by the [Bernoulli(0.5352)] distribution (0.60x0.892).

Using the previous result, we may assess the average size of removable devices used. We assume that these devices are used equally 
| Device | Average Size | Source |
|---|---|---|
|USB Drive | 64 GB | https://recoverit.wondershare.com/flashdrive-recovery/usb-flash-drive-size.html (we assume the mid range for USB drives to be the average size)|
|Smartphones | 117 GB | https://www.counterpointresearch.com/average-storage-capacity-smartphones-cross-80gb-end-2019/#:~:text=In%20terms%20of%20storage%20in,memory%20capacity%20keeps%20going%20higher. |
| External Hard Drive | 4100 GB | https://www.statista.com/statistics/795748/worldwide-seagate-average-hard-disk-drive-capacity/#:~:text=Seagate%3A%20average%20hard%20disk%20drive%20capacity%20worldwide%202015%2D2020&text=This%20statistic%20shows%20the%20average,size%20was%20approximately%204.1%20terabyte. | 
| Tablets | 64 GB | https://www.laptopmag.com/articles/tablet-buying-guide#:~:text=Storage%20and%20Expandability,256GB%20of%20storage%20or%20more. (we assume the mid range for tablets to be the average size) |
| Optical Media | 64 GB | https://en.wikipedia.org/wiki/Optical_storage#:~:text=Optical%20storage%20can%20range%20from,layered%20can%20hold%208.5%20GB.  (we assume the mid range for optical media to be the average size)  |
| Memory Cards | 4GB | https://www.electronics-notes.com/articles/electronic_components/semiconductor-ic-memory/flash-memory-card-buying-guide-best-one.php#:~:text=The%20standard%20SD%20card%20has,SD%20memory%20card%20mentioned%20below. |

On average, that's a 735.5 GB size for removable media. This means it would take about 13359 s to process this data with the S3 software (described in the[automatedCollection.md] file).

## Results

[Bernoulli(0.5352)*Exponential(6.47)]

## Discussion

The values for TTC could be improved with further work and investigation. We consider it acceptable for now.