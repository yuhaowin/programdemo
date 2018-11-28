
package com.yuhaowin.webservice.messagetemplate;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "IWeChatPushService", targetNamespace = "http://facade.utc.js189.cn/", wsdlLocation = "http://132.224.218.19:8084/services/cn.js189.utc.facade.IWeChatPushService?wsdl")
public class IWeChatPushService
    extends Service
{

    private final static URL IWECHATPUSHSERVICE_WSDL_LOCATION;
    private final static WebServiceException IWECHATPUSHSERVICE_EXCEPTION;
    private final static QName IWECHATPUSHSERVICE_QNAME = new QName("http://facade.utc.js189.cn/", "IWeChatPushService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://132.224.218.19:8084/services/cn.js189.utc.facade.IWeChatPushService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        IWECHATPUSHSERVICE_WSDL_LOCATION = url;
        IWECHATPUSHSERVICE_EXCEPTION = e;
    }

    public IWeChatPushService() {
        super(__getWsdlLocation(), IWECHATPUSHSERVICE_QNAME);
    }

    public IWeChatPushService(WebServiceFeature... features) {
        super(__getWsdlLocation(), IWECHATPUSHSERVICE_QNAME, features);
    }

    public IWeChatPushService(URL wsdlLocation) {
        super(wsdlLocation, IWECHATPUSHSERVICE_QNAME);
    }

    public IWeChatPushService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, IWECHATPUSHSERVICE_QNAME, features);
    }

    public IWeChatPushService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IWeChatPushService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IWeChatPushServicePortType
     */
    @WebEndpoint(name = "IWeChatPushServicePort")
    public IWeChatPushServicePortType getIWeChatPushServicePort() {
        return super.getPort(new QName("http://facade.utc.js189.cn/", "IWeChatPushServicePort"), IWeChatPushServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IWeChatPushServicePortType
     */
    @WebEndpoint(name = "IWeChatPushServicePort")
    public IWeChatPushServicePortType getIWeChatPushServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://facade.utc.js189.cn/", "IWeChatPushServicePort"), IWeChatPushServicePortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (IWECHATPUSHSERVICE_EXCEPTION!= null) {
            throw IWECHATPUSHSERVICE_EXCEPTION;
        }
        return IWECHATPUSHSERVICE_WSDL_LOCATION;
    }

}