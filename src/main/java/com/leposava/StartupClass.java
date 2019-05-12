package com.leposava;

import com.leposava.model.*;
import com.leposava.repository.AdNetworksDAO;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class StartupClass {

    @PostConstruct
    public void init() {
        populateDB();
    }

    private void populateDB() {

        AdNetwork adNetwork1 = new AdNetwork();
        adNetwork1.setName("152 Media");
        adNetwork1.setDescription("152 Media is an Adnetwork focused in results. We specialize in performance, branding and social media advertising.");
        Detail detail = new Detail();
        detail.setAdditionalInformation("We focus on result measurement and technology development to deliver products that add value both to advertisers and publishers." +
                " Founded in 2011, 152 has headquarters in US and offices in Latin America. Monetizing over 10 billion monthly impressions" +
                " we are considered one of the fastest growing companies, covering all aspects of the online advertising experience. \n" +
                " Our core values are: payments 100% on time, service orientated, 24hs support.");
        detail.setNetworkType(NetworkType.Affiliate);
        detail.setPaymentType(PaymentType.CPA);
        detail.setOur_targeting_options(OUR_TARGETING_OPTIONS_Type.Demographic);
        detail.setWe_are_a(WE_ARE_A_Type.Exchange);
        adNetwork1.setDetails(detail);
        AdNetworksDAO.getInstance().saveNetwork(adNetwork1);

        AdNetwork adNetwork2 = new AdNetwork();
        adNetwork2.setName("Chitika");
        adNetwork2.setDescription("Relax. Our ads work for you! We deliver ad solutions to make your websites and ad campaigns more valuable. Want to advertise? Visit cidewalk.com to get our self-serve ad platform.");
        Detail detail2 = new Detail();
        detail2.setAdditionalInformation("Chitika gives publishers the tools they need to make money with their websites, fast. Get paid on both clicks and impressions. Our text and display ads, powered by our smart ad technology, will only show to your users when we predict it will make you money. ");
        detail2.setNetworkType(NetworkType.Standard);
        detail2.setPaymentType(PaymentType.CPA);
        detail2.setOur_targeting_options(OUR_TARGETING_OPTIONS_Type.Demographic);
        detail2.setWe_are_a(WE_ARE_A_Type.Exchange);
        adNetwork2.setDetails(detail2);
        AdNetworksDAO.getInstance().saveNetwork(adNetwork2);

        AdNetwork adNetwork3 = new AdNetwork();
        adNetwork3.setName("Kimia");
        adNetwork3.setDescription("Kimia is the leading network for online mobile performance. We are a premium network that only partners with top advertisers and top affiliates.");
        Detail detail3 = new Detail();
        detail3.setAdditionalInformation("We go beyond our competitors with world class technology, constant optimisation and dedicated account management. Test us now and let the numbers talk. ");
        detail3.setNetworkType(NetworkType.Standard);
        detail3.setPaymentType(PaymentType.CPM);
        detail3.setOur_targeting_options(OUR_TARGETING_OPTIONS_Type.Demographic);
        detail3.setWe_are_a(WE_ARE_A_Type.DSP);
        adNetwork3.setDetails(detail3);
        AdNetworksDAO.getInstance().saveNetwork(adNetwork3);

    }

}
