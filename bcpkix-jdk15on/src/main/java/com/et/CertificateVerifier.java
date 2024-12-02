package com.et;

import java.security.KeyPairGenerator;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.ByteArrayInputStream;

public class CertificateVerifier {

    public static boolean verifyCertificate(X509Certificate certificate) {
        try {
            certificate.checkValidity();
            certificate.verify(certificate.getPublicKey());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            // 假设我们已经生成了一个证书
            X509Certificate certificate = CertificateGenerator.generateSelfSignedCertificate(
                    KeyPairGenerator.getInstance("RSA").generateKeyPair());

            boolean isValid = verifyCertificate(certificate);
            System.out.println("Certificate is valid: " + isValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}