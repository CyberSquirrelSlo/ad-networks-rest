package com.leposava.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity(name = "details")
public class Detail {

    @Id
    @GeneratedValue(generator = "system-uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;
//    @XmlElement(name="network")
    private NetworkType networkType;
//    @XmlElement(name="payment")
    private PaymentType paymentType;
//    @XmlElement(name="we_are_a")
    private WE_ARE_A_Type we_are_a;
    private  OUR_TARGETING_OPTIONS_Type our_targeting_options;
    @Column(length = 10000)
    private String additionalInformation;
    @OneToOne(mappedBy = "details")
    private AdNetwork adNetwork;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NetworkType getNetworkType() {
        return networkType;
    }

    public void setNetworkType(NetworkType networkType) {
        this.networkType = networkType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public AdNetwork getAdNetwork() {
        return adNetwork;
    }

    public void setAdNetwork(AdNetwork adNetwork) {
        this.adNetwork = adNetwork;
    }

    public OUR_TARGETING_OPTIONS_Type getOur_targeting_options() {
        return our_targeting_options;
    }

    public void setOur_targeting_options(OUR_TARGETING_OPTIONS_Type our_targeting_options) {
        this.our_targeting_options = our_targeting_options;
    }

    public WE_ARE_A_Type getWe_are_a() {
        return we_are_a;
    }

    public void setWe_are_a(WE_ARE_A_Type we_are_a) {
        this.we_are_a = we_are_a;
    }
}
