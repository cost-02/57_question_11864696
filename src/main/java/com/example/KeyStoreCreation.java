package com.example;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.CertificateException;

public class KeyStoreCreation {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        KeyStore keyStore = KeyStore.getInstance("BKS", "BC"); // Bouncy Castle KeyStore
        keyStore.load(null, null); // Inizializza un KeyStore vuoto

        // Inserisci la tua chiave nel KeyStore qui
        // Ad esempio, carica la chiave privata e il certificato
        // keyStore.setKeyEntry(...);

        // Salva il KeyStore
        char[] password = "password".toCharArray();
        try (FileOutputStream fos = new FileOutputStream("mykeystore.bks")) {
            keyStore.store(fos, password);
        } catch (CertificateException e) {
            e.printStackTrace();
        }
    }
}
