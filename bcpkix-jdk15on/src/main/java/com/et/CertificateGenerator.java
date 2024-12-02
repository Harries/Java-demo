package com.et;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

public class CertificateGenerator {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static X509Certificate generateSelfSignedCertificate(KeyPair keyPair) throws Exception {
        X500Name issuer = new X500Name("CN=Test Certificate");
        BigInteger serial = BigInteger.valueOf(System.currentTimeMillis());
        Date notBefore = new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24);
        Date notAfter = new Date(System.currentTimeMillis() + 1000L * 60 * 60 * 24 * 365);

        JcaX509v3CertificateBuilder certBuilder = new JcaX509v3CertificateBuilder(
                issuer, serial, notBefore, notAfter, issuer, keyPair.getPublic());

        ContentSigner signer = new JcaContentSignerBuilder("SHA256WithRSAEncryption")
                .setProvider("BC").build(keyPair.getPrivate());

        X509CertificateHolder certHolder = certBuilder.build(signer);
        return new JcaX509CertificateConverter().setProvider("BC").getCertificate(certHolder);
    }

    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            X509Certificate certificate = generateSelfSignedCertificate(keyPair);
            System.out.println("Generated Certificate: " + certificate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}