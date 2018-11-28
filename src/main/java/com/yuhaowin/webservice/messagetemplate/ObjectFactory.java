
package com.yuhaowin.webservice.messagetemplate;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.yuhaowin.webservice.messagetemplate package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WeChatMsgPushResponse_QNAME = new QName("http://facade.utc.js189.cn/", "weChatMsgPushResponse");
    private final static QName _WeChatMsgPush_QNAME = new QName("http://facade.utc.js189.cn/", "weChatMsgPush");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.yuhaowin.webservice.messagetemplate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WeChatMsgPush }
     * 
     */
    public WeChatMsgPush createWeChatMsgPush() {
        return new WeChatMsgPush();
    }

    /**
     * Create an instance of {@link WeChatMsgPushResponse }
     * 
     */
    public WeChatMsgPushResponse createWeChatMsgPushResponse() {
        return new WeChatMsgPushResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatMsgPushResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.utc.js189.cn/", name = "weChatMsgPushResponse")
    public JAXBElement<WeChatMsgPushResponse> createWeChatMsgPushResponse(WeChatMsgPushResponse value) {
        return new JAXBElement<WeChatMsgPushResponse>(_WeChatMsgPushResponse_QNAME, WeChatMsgPushResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeChatMsgPush }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://facade.utc.js189.cn/", name = "weChatMsgPush")
    public JAXBElement<WeChatMsgPush> createWeChatMsgPush(WeChatMsgPush value) {
        return new JAXBElement<WeChatMsgPush>(_WeChatMsgPush_QNAME, WeChatMsgPush.class, null, value);
    }

}
