
package com.qiangge.webservice.client.wsdl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.qiangge.webservice.client.wsdl package.
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

    private final static QName _GetAlLUser_QNAME = new QName("http://service.webservicedemo.qiangge.com/", "getAlLUser");
    private final static QName _GetAlLUserResponse_QNAME = new QName("http://service.webservicedemo.qiangge.com/", "getAlLUserResponse");
    private final static QName _GetName_QNAME = new QName("http://service.webservicedemo.qiangge.com/", "getName");
    private final static QName _GetNameResponse_QNAME = new QName("http://service.webservicedemo.qiangge.com/", "getNameResponse");
    private final static QName _GetUser_QNAME = new QName("http://service.webservicedemo.qiangge.com/", "getUser");
    private final static QName _GetUserResponse_QNAME = new QName("http://service.webservicedemo.qiangge.com/", "getUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.qiangge.webservice.client.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAlLUser }
     * 
     */
    public GetAlLUser createGetAlLUser() {
        return new GetAlLUser();
    }

    /**
     * Create an instance of {@link GetAlLUserResponse }
     * 
     */
    public GetAlLUserResponse createGetAlLUserResponse() {
        return new GetAlLUserResponse();
    }

    /**
     * Create an instance of {@link GetName }
     * 
     */
    public GetName createGetName() {
        return new GetName();
    }

    /**
     * Create an instance of {@link GetNameResponse }
     * 
     */
    public GetNameResponse createGetNameResponse() {
        return new GetNameResponse();
    }

    /**
     * Create an instance of {@link GetUser }
     * 
     */
    public GetUser createGetUser() {
        return new GetUser();
    }

    /**
     * Create an instance of {@link GetUserResponse }
     * 
     */
    public GetUserResponse createGetUserResponse() {
        return new GetUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAlLUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservicedemo.qiangge.com/", name = "getAlLUser")
    public JAXBElement<GetAlLUser> createGetAlLUser(GetAlLUser value) {
        return new JAXBElement<GetAlLUser>(_GetAlLUser_QNAME, GetAlLUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAlLUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservicedemo.qiangge.com/", name = "getAlLUserResponse")
    public JAXBElement<GetAlLUserResponse> createGetAlLUserResponse(GetAlLUserResponse value) {
        return new JAXBElement<GetAlLUserResponse>(_GetAlLUserResponse_QNAME, GetAlLUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservicedemo.qiangge.com/", name = "getName")
    public JAXBElement<GetName> createGetName(GetName value) {
        return new JAXBElement<GetName>(_GetName_QNAME, GetName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservicedemo.qiangge.com/", name = "getNameResponse")
    public JAXBElement<GetNameResponse> createGetNameResponse(GetNameResponse value) {
        return new JAXBElement<GetNameResponse>(_GetNameResponse_QNAME, GetNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservicedemo.qiangge.com/", name = "getUser")
    public JAXBElement<GetUser> createGetUser(GetUser value) {
        return new JAXBElement<GetUser>(_GetUser_QNAME, GetUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.webservicedemo.qiangge.com/", name = "getUserResponse")
    public JAXBElement<GetUserResponse> createGetUserResponse(GetUserResponse value) {
        return new JAXBElement<GetUserResponse>(_GetUserResponse_QNAME, GetUserResponse.class, null, value);
    }

}
