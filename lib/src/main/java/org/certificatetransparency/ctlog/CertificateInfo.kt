@file:JvmName("CertificateInfo")

package org.certificatetransparency.ctlog

import org.certificatetransparency.ctlog.serialization.CTConstants.POISON_EXTENSION_OID
import org.certificatetransparency.ctlog.serialization.CTConstants.PRECERTIFICATE_SIGNING_OID
import org.certificatetransparency.ctlog.serialization.CTConstants.SCT_CERTIFICATE_OID

import java.security.cert.Certificate
import java.security.cert.CertificateParsingException
import java.security.cert.X509Certificate

/** Helper class for finding out all kinds of information about a certificate.  */

fun Certificate.isPreCertificateSigningCert(): Boolean {
    this as X509Certificate

    try {
        return extendedKeyUsage?.contains(PRECERTIFICATE_SIGNING_OID) == true
    } catch (e: CertificateParsingException) {
        throw CertificateTransparencyException("Error parsing signer cert: ${e.message}", e)
    }
}

fun Certificate.isPreCertificate(): Boolean {
    this as X509Certificate
    return criticalExtensionOIDs?.contains(POISON_EXTENSION_OID) == true
}

fun Certificate.hasEmbeddedSCT(): Boolean {
    this as X509Certificate
    return nonCriticalExtensionOIDs?.contains(SCT_CERTIFICATE_OID) == true
}