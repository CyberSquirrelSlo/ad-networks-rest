# ad-networks-rest
IT is a Jersey Rest application which is running on Wildfly server and  MSSQL database
to to configure database connection please edit persistence.xml


Sample adding one ad netowrk
<br>
http://localhost:8080/ad-networks-rest/webapi/networks/network
<br> wiht verb POST

```json
 {
        "description": "CPA Affiliate Network with high payouts and the best deals.",
        "details": {
            "additionalInformation": "t is our mission to guarantee simple account management, daily support, best CPA offers and to always, always keep a step ahead of competitors when it comes to affiliate payments. It is our goal to make our partners comfortable, rich and happy.  ",
            "networkType": "Affiliate",
            "our_targeting_options_type": "Geographic",
            "paymentType": "CPA",
            "we_are_a_type": "Exchange"
        },
        "name": "Rainmaker"
    }
```

Sample updating a single network
<br>
http://localhost:8080/ad-networks-rest/webapi/networks/network
<br>
with verb PUT 

```json
{
    "description": "CPA Affiliate Network with high payouts and the best deals.",
    "details": {
        "additionalInformation": "t is our mission to guarantee simple account management, daily support, best CPA offers and to always, always keep a step ahead of competitors when it comes to affiliate payments. It is our goal to make our partners comfortable, rich and happy.  ",
        "id": "d709bc9f-b596-4c08-aed6-373ba58c3f8c",
        "networkType": "Affiliate",
        "paymentType": "CPA"
    },
    "id": "3daf13d3-c362-445f-9187-54d1ec23938b",
    "name": "Rainmaker UPDATED"
}
```

Sample adding list of networks
<br>
localhost:8080/ad-networks-rest/webapi/networks
<br>
with verb POST 
```json
[
    {
        "description": "888 Media is a digital marketing solutions company that provides cost-effective ad solutions for advertisers to reach targeted consumers.",
        "details": {
            "additionalInformation": "We focus on result measurement and technology development to deliver products that add value both to advertisers and publishers. Founded in 2011, 152 has headquarters ",
            "networkType": "Affiliate",
            "our_targeting_options_type": "Demographic",
            "paymentType": "CPA",
            "we_are_a_type": "Exchange"
        },
        "name": "888 Media"
    },
     {
        "description": "ad2games is CPA ad network dedicated to online gaming. We work with the top game publishers to bring you the best games with the highest CPAs worldwide.",
        "details": {
            "additionalInformation": "We focus on result measurement and technology development to deliver products that add value both to advertisers and publishers. Founded in 2011, 152 has headquarters ",
            "networkType": "Standard",
            "our_targeting_options_type": "Demographic",
            "paymentType": "CPA",
            "we_are_a_type": "Exchange"
        },
        "name": "ad2games"
    },
    {
        "description": "AdGaem is a Premium Affiliate Network 100% focused on free-to-play Mobile and Desktop Games.We generate quality gamers internationally for the world’s leading F2P Game Publishers.",
        "details": {
            "additionalInformation": "We focus on result measurement and technology development to deliver products that add value both to advertisers and publishers. Founded in 2011, 152 has headquarters ",
            "networkType": "Standard",
            "our_targeting_options_type": "Demographic",
            "paymentType": "CPM",
            "we_are_a_type": "Exchange"
        },
        "name": "AdGaem"
    }
]
```

For update localhost:8080/ad-networks-rest/webapi/networks with PUT
<br>
First we do GET to get list to be updated (importatnt IDs must be in)
<br>
then we copy the returned json list and correct changes ...
```json

[
    {
        "description": "888 Media is a digital marketing solutions company that provides cost-effective ad solutions for advertisers to reach targeted consumers.",
        "details": {
            "additionalInformation": "We focus on result measurement and technology development to deliver products that add value both to advertisers and publishers. Founded in 2011, 152 has headquarters ",
            "id": "c5e97fb8-b7b3-464b-9e48-1c2eb8740228",
            "networkType": "Affiliate",
            "paymentType": "CPA"
        },
        "id": "ef103195-8d67-4682-8efe-5ff8bb5dc09c",
        "name": "888 Media new"
    },
    {
        "description": "ad2games is CPA ad network dedicated to online gaming. We work with the top game publishers to bring you the best games with the highest CPAs worldwide.",
        "details": {
            "additionalInformation": "We focus on result measurement and technology development to deliver products that add value both to advertisers and publishers. Founded in 2011, 152 has headquarters ",
            "id": "c4c6f577-04b0-487f-9b0d-c8de98b6f42d",
            "networkType": "Standard",
            "paymentType": "CPA"
        },
        "id": "48705a3f-a57e-49cf-9efe-b5bc8cb5e098",
        "name": "ad2games new"
    },
    {
        "description": "AdGaem is a Premium Affiliate Network 100% focused on free-to-play Mobile and Desktop Games.We generate quality gamers internationally for the world’s leading F2P Game Publishers.",
        "details": {
            "additionalInformation": "We focus on result measurement and technology development to deliver products that add value both to advertisers and publishers. Founded in 2011, 152 has headquarters ",
            "id": "65c4c4be-e747-4bdd-b4e8-3f990f67ba93",
            "networkType": "Standard",
            "paymentType": "CPM"
        },
        "id": "d4882c12-d61e-4519-8796-2b3606ee5e25",
        "name": "AdGaem  new"
    },
    {
        "description": "Relax. Our ads work for you! We deliver ad solutions to make your websites and ad campaigns more valuable. Want to advertise? Visit cidewalk.com to get our self-serve ad platform.",
        "details": {
            "additionalInformation": "Chitika gives publishers the tools they need to make money with their websites, fast. Get paid on both clicks and impressions. Our text and display ads, powered by our smart ad technology, will only show to your users when we predict it will make you money. ",
            "id": "7f2fb172-6b5d-458e-abed-d967ccbb653a",
            "networkType": "Standard",
            "our_targeting_options": "Demographic",
            "paymentType": "CPA",
            "we_are_a": "Exchange"
        },
        "id": "28dfe8e0-9368-48ed-a7d5-7deb3bc33c9f",
        "name": "Chitika"
    },
    {
        "description": "Kimia is the leading network for online mobile performance. We are a premium network that only partners with top advertisers and top affiliates.",
        "details": {
            "additionalInformation": "We go beyond our competitors with world class technology, constant optimisation and dedicated account management. Test us now and let the numbers talk. ",
            "id": "1bcbc71a-9e72-4b2d-a227-189067820a41",
            "networkType": "Standard",
            "our_targeting_options": "Demographic",
            "paymentType": "CPM",
            "we_are_a": "DSP"
        },
        "id": "0d4575ec-6dba-4ea2-8412-d3ff67c4c1f4",
        "name": "Kimia"
    },
    {
        "description": "152 Media is an Adnetwork focused in results. We specialize in performance, branding and social media advertising.",
        "details": {
            "additionalInformation": "We focus on result measurement and technology development to deliver products that add value both to advertisers and publishers. Founded in 2011, 152 has headquarters in US and offices in Latin America. Monetizing over 10 billion monthly impressions we are considered one of the fastest growing companies, covering all aspects of the online advertising experience. \n Our core values are: payments 100% on time, service orientated, 24hs support.",
            "id": "dd4096c9-d56f-45e0-bc7b-f66b545bfcf3",
            "networkType": "Affiliate",
            "our_targeting_options": "Demographic",
            "paymentType": "CPA",
            "we_are_a": "Exchange"
        },
        "id": "7f42eea0-0c72-4894-a93b-e836eefb82f5",
        "name": "Media"
    }
]
```
