package com.cpeeterprise;

import java.util.List;

import javax.ejb.Remote;

import model.Message;

@Remote
public interface BeanMessageRemote {

	public Message persist (Message message);
	public void delete (Message message);
	public void update (Message message);
	public List <Message> findMessages ();
	public Message findMessage (String id);
	public List <Message> findOlderMessages (int senderId, int receiverId, int messageId);
}
