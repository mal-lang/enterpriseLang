# [Resource Hijacking](https://attack.mitre.org/techniques/T1496/)

## Context
>Adversaries may leverage the resources of co-opted systems in order to solve resource intensive problems which may impact system and/or hosted service availability. 

## Findings
In the [FireEye M-Trends 2020 report](https://www.fireeye.com/current-threats/annual-threat-report/mtrends.html), they find that resource hijacking has been part of 2.2% of all attack lifecycles. 

A form of resource hijacking is cryptojacking, which according to [Positive Technologies](https://www.ptsecurity.com/ww-en/analytics/cybersecurity-threatscape-2019-q1/) accounts for 7% of all attacks. 

If we use the average of these two sources, we find that (2.2+7)/2 = 4.6. I will use this as my estimate of how prevalent this attack step is. -> ```Bernoulli(0.046)```. 

## Time to compromise
In a report on the threat group [APT41](https://content.fireeye.com/apt-41/rpt-apt41), this threat includes the capability of installing [XMRig](https://github.com/xmrig/xmrig), an open source cryptocurrency miner which they use to mine [Monero](https://www.getmonero.org/). For this particular attack, with this cryptominer and cryptocurrency, I found [one source](https://steemit.com/utopian-io/@afterglow/tutorial-how-to-install-configure-and-use-xmrig-cryptocurrency-miner-for-monero-on-your-computer) which states that "After mining for about 30 minutes you should see the words: ACCEPTED which means your mining job is accepted by the pool". I will estimate then that in order for the resource hijacking to be completed at least once, it needs ~30 minutes. This is ```Exponential(48)```

## Result
```Bernoulli(0.046)*Exponential(48)```. 

## Discussion
The TTC here is quite variable, and also depends on when you assume the step is completed. I have assumed that the resource hijacking needs to contribute something to the attacker in order to be complete, but it could also instead be how long it takes to install some software that performs the resource hijacking. 