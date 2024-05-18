package com.maan.eway.config;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
 

@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_SINGLETON)
@PropertySource("classpath:digtalsign.properties")
public class DigitalSignatureGenerator  {
	
	@Value("${digital.tirmas.load.each}")
    private String isloadYn;
	
	@Value("${digital.tirams.privatekey.file}")
	private String privatekey; 
	
	@Value("${digital.tirams.privatekey.password}")
	private String password;
			
	private static KeyStore keyStore;
	
	private void initKeyStore() {
		if(keyStore==null) {
			load();
		}else if("Y".equalsIgnoreCase(isloadYn)) {
			load();
		}
	}
	
	private  KeyStore load() {
		try {
			 keyStore = KeyStore.getInstance("PKCS12");
			 File file = ResourceUtils.getFile(privatekey);
			 InputStream is = new ClassPathResource("tiramisclientprivate.pfx").getInputStream();
			 keyStore.load(is, password.toCharArray());
			 return keyStore;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String collectMsgSignature(String xmlString) {
		try {
			initKeyStore();
			 
			//String alias = keyStore.aliases().nextElement();
			/*while(keyStore.aliases().hasMoreElements())
			{
				System.out.println("Key::: "+keyStore.aliases().nextElement()); //keyStore.aliases().nextElement();
			}*/
			 //xmlString="<CoverNoteVerificationReq><VerificationHdr><RequestId>EWAY270920220079</RequestId><CompanyCode>ICC105</CompanyCode><SystemCode>LSYS_EWAYINSURANCE_001</SystemCode></VerificationHdr><VerificationDtl><CoverNoteReferenceNumber>42424-246767-65768</CoverNoteReferenceNumber><StickerNumber>13143-14145-12412</StickerNumber><MotorRegistrationNumber>T241QWA</MotorRegistrationNumber><MotorChassisNumber>NCP314345436334</MotorChassisNumber></VerificationDtl></CoverNoteVerificationReq>";
			 Key key = keyStore.getKey("tiramisclient", password.toCharArray());
			  byte[] decoded = Base64.getDecoder().decode(Base64.getEncoder().encodeToString(key.getEncoded()));
			 
			  
			 KeySpec keySpec  = new PKCS8EncodedKeySpec(decoded);
			 KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			 PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
			 
			byte[] messageBytes = xmlString.getBytes(StandardCharsets.US_ASCII);
			
			
			Signature signature = Signature.getInstance("SHA1withRSA");//SHA256withRSA,SHA1withRSA
			signature.initSign(privateKey);
			signature.update(messageBytes);
			byte[] sign = signature.sign();
			String encodeToString = Base64.getEncoder().encodeToString(sign);
			//String result = new String(sign,StandardCharsets.UTF_8);
			return encodeToString;
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	} 
	
}
