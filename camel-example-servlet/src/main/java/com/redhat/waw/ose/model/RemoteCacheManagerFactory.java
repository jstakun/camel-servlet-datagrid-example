package com.redhat.waw.ose.model;

import java.io.IOException;

import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.marshall.ProtoStreamMarshaller;
import org.infinispan.protostream.DescriptorParserException;
import org.infinispan.protostream.FileDescriptorSource;
import org.infinispan.protostream.SerializationContext;

public class RemoteCacheManagerFactory {
	 ConfigurationBuilder clientBuilder;
	 
	 private static final String PROTOBUF_DEFINITION_RESOURCE = "/protony/customer.proto";
	 
	 public RemoteCacheManagerFactory(String hostname, int port) {
		 clientBuilder = new ConfigurationBuilder();
		 clientBuilder.addServer()
		 .host(hostname).port(port)
		 .marshaller(new ProtoStreamMarshaller());
	 }
	 
	 public RemoteCacheManager newRemoteCacheManager() throws DescriptorParserException, IOException {
		 RemoteCacheManager cacheManager = new RemoteCacheManager(clientBuilder.build());
		 
		 SerializationContext ctx = ProtoStreamMarshaller.getSerializationContext(cacheManager);
		 ctx.registerProtoFiles(new FileDescriptorSource().addProtoFile("customer.proto", this.getClass().getResourceAsStream(PROTOBUF_DEFINITION_RESOURCE)));
		 ctx.registerMarshaller(new CustomerTransactionMarshaller());
		 
		 return cacheManager;
	 } 
}
