# Privileged and User Account Management

## Privileged Account Management

### Context 
Manage the creation, modification, use, and permissions associated to privileged accounts, including SYSTEM and root.
### Relevant findings 
https://user-assets-unbounce-com.s3.amazonaws.com/6766c3ae-2136-11e4-bdef-22000ac464fa/7642bd17-721e-4387-88dc-876a8c9010d2/2018-global-state-of-pam-risk-and-compliance.original.pdf?x-amz-security-token=IQoJb3JpZ2luX2VjEFsaDGV1LWNlbnRyYWwtMSJHMEUCIQDdcZKxpHFwZaxhbnR5hEgg2hKdVuoST3VxzFAgPkh1iAIgSenff7pYC6njzQ9rW%2BnoK4YsrWSNKl4tTiv3Vebx1XYqwgMI1P%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FARAAGgwwMDI2ODI4MTk5MzMiDOCH7G1kdjOpU5psByqWA%2BF2%2BAtv4oSLMfgZqaPZxu64PRbFAusODwreiOY0cAawqeSC4Rejgd4tHYZDGgHJKJZRuTU86LPmmGs9ljuDxWzs9IagcJcYL60ShALgCPrabaVJDRLx1DMpxWWgBkZhPplC8ydWmZf0e985euigl799d158qXC7MtAyQ%2FrrfZNNAuI17gcE%2Bg9k%2FQLyFWAajcyagi4IiucuRjxRAOcBjboF3whDBUYHqL4jKzY8MeAniBj0dkqCdSnSMA4v9B9C0br%2FPnO5zC3mZtY3tVe%2FKg%2FjjGw6GbfHArv9YQilbMRb%2FubUlIjwDsecHeE2dz52KBJjZi0ov0mq36loeekyVXbrV7m%2FKj3D4sxLhauLpQA4NIYqECf1%2FBCwMrD4W0%2BL80lnbkSNV%2B%2FGeu8rWX2gxQWj5CGJESpUWyNYsTO8lWjrmWlxB4yonaM41Q0YNApQy91RSxLouPCC0L7dbICZ4I%2FHq2X8RS9o8Dxb%2BBk%2FmgAPnXdCYZptN4abdUI2E0wKbQSYRyPhN2DPbMEAzNsnfHfcGEvRR2ownuyn9wU67AFa3PqmZGBsOgFaKDhJJGKJpWFmZRaRhMSKzmH04cwas0cVFsLOvnDBUlaLjrJUDa9tV6HMaJ3DvBAD3plIgP1HAnJAGG0aN6LlMTRpwJpKHI1dY2ZEtr9tSPnS7meMq%2Bn1q0EjswGHh1U6uoIut2Og9leHd%2Bwzo%2F1elq0DxG%2BK0GTYG7j%2BomOsjVT%2F6QKcCHif1Gs20Qkp3H79gbiRSzPa%2B4DfaywVHH%2Fo2SxtR8jk9ywU2jnTNiyb3x1RzhHsVxh1Y20fViU56eo2Hyz3xz49sSXMgmO7knbSWaUPvDmP2SBtam%2FYaoZGeYYmhA%3D%3D&AWSAccessKeyId=ASIAQBH7ISVOQ2GD65JS&Expires=1592397675&Signature=t0z%2FwXGG6FQgxYvB1em8gGpK928%3D
https://lp.alpha-gen.co.uk/2018-global-state-of-pam/
According to this report 70% of companies don't have a proper Privileged Account Management.

### Results

We can thus assess that the probability distribution for Privileged Account Management is [Bernoulli(0.30)]

## User Account Management

### Context 
Manage the creation, modification, use, and permissions associated to user accounts.

### Results
We can assume that a company that has a proper Privileged Account Management has proper User Account Management and vice versa.

We can thus assess that the probability distribution for User Account Management is [Bernoulli(0.30)]