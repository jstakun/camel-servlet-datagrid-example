package com.redhat.waw.ose.model;

import java.io.IOException;

import org.infinispan.protostream.MessageMarshaller;

public class CustomerTransactionMarshaller implements MessageMarshaller<CustomerTransaction> {

	/*required string transactionid = 1;
   
   required string customerid = 2;
   
   required double amount = 3;
   
   required int64 transactionDate = 4;*/
	
	public Class<? extends CustomerTransaction> getJavaClass() {
		return CustomerTransaction.class;
	}

	public String getTypeName() {
		return "protony.CustomerTransaction";
	}

	public CustomerTransaction readFrom(ProtoStreamReader reader) throws IOException {
		CustomerTransaction t = new CustomerTransaction(); 
		t.setTransactionid(reader.readString("transactionid"));
		t.setCustomerid(reader.readString("customerid"));
		t.setAmount(reader.readDouble("amount"));
		t.setTransactionDate(reader.readLong("transactionDate"));
		return t;
	}

	public void writeTo(ProtoStreamWriter writer, CustomerTransaction t) throws IOException {
		writer.writeString("transactionid", t.getTransactionid());
		writer.writeString("customerid", t.getCustomerid());
		writer.writeDouble("amount", t.getAmount());
		writer.writeLong("transactionDate", t.getTransactionDate());
	}

	/*required string transactionid = 1;
   
   required string customerid = 2;
   
   required double amount = 3;
   
   required int64 date = 4;*/
	
}

 