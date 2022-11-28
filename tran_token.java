// https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient/4.0
implementation 'org.apache.httpcomponents:httpclient'

// tranToken make value
String tranToken = "KMV1" + ':' + (new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()) + ':' + hMac(secretKey, message);

// hMac Method
import org.apache.commons.codec.digest.HmacAlgorithms
import org.apache.commons.codec.digest.HmacUtils
import org.apache.commons.codec.binary.*


public String hMac(String secretKey, String message){
    Charset charset = Charsets.UTF_8;
    HmacAlgorithms algorithm = HmacAlgorithms.HMAC_SHA_256;
    byte[] secretKeyByte = secretKey.getBytes(charset);
    byte[] bodyByte = body.getBytes(charset);
    Mac mac = HmacUtils.getInitializedMac(algorithm, secretKeyByte).doFinal(bodyByte);
    byte[] encodeBase64 = Base64.encodeBase64(macByte);
    return new String(encodeBase64, charset);
}