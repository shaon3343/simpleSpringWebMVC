#spring web mvc project.
#SSO (Single Sign On) configuration with spring security

add dependency in POM (Spring security, saml dependency etc ) 

add all configuration file + xml file

create account in a SSO provider (like https://idp.ssocircle.com/) 

Create key by keytool

keytool -genkeypair -alias shaon -keypass shaon3343 -keystore samlKeystoreShaon.jks

create xml  securityContext.xml by adding above key alias and password.

put these files in class path or location

get XML from ==> application_root/saml/metadata

add this xml as metadata in the idp provider (above SSOcircle) .
by the same entityID in metadataGeneratorFilter bean in SecurityContext.xml
