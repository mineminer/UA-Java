/* Copyright (c) 1996-2015, OPC Foundation. All rights reserved.
   The source code in this file is covered under a dual-license scenario:
     - RCL: for OPC Foundation members in good-standing
     - GPL V2: everybody else
   RCL license terms accompanied with this source code. See http://opcfoundation.org/License/RCL/1.00/
   GNU General Public License as published by the Free Software Foundation;
   version 2 of the License are accompanied with this source code. See http://opcfoundation.org/License/GPLv2
   This source code is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
*/
package org.opcfoundation.ua.transport.endpoint;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.opcfoundation.ua.application.Server;
import org.opcfoundation.ua.transport.Endpoint;
import org.opcfoundation.ua.transport.EndpointBinding;
import org.opcfoundation.ua.transport.EndpointServer;
import org.opcfoundation.ua.utils.EndpointUtil;

public class EndpointBindingCollection {

	List<EndpointBinding> bindings;
	
	CopyOnWriteArrayList<EndpointBindingListener> listeners = new CopyOnWriteArrayList<EndpointBindingListener>(); 
	
	public EndpointBindingCollection() {
		bindings = new CopyOnWriteArrayList<EndpointBinding>();
	}
	
	public EndpointBindingCollection(List<EndpointBinding> bindings) {
		this.bindings = Collections.synchronizedList( bindings );
	}
	
	public void add(EndpointBinding binding) {
		if ( bindings.contains(binding) ) return; 
//			throw new RuntimeException("Collection already contains the endpoint binding");
		bindings.add( binding );
	}
	
	public void remove(EndpointBinding binding) {
		bindings.remove( binding );
	}
	
	public boolean contains(EndpointBinding binding) {
		return bindings.contains(binding);				
	}
	
	public boolean isEmpty() 
	{
		return bindings.isEmpty();
	}
	
	public int size() 
	{
		return bindings.size();
	}

	public EndpointBinding getDefault(String url) {
		if (url == null)
			throw new NullPointerException("url must be defined");
		try {
			URI requestedUri = new URI(url);
			for (EndpointBinding b : bindings)
				 {
					try {
						URI uri = new URI( b.endpointAddress.getEndpointUrl());
						if (EndpointUtil.urlEqualsHostIgnoreCase(uri, requestedUri))
							return b;
					} catch (URISyntaxException e) {
					}
				}
		} catch (URISyntaxException e1) {
		}
		return null;
	}	
	
	public List<EndpointBinding> getAll() {
		return bindings;
	}
	
	// Query functions - all 6 permutations
	public List<EndpointBinding> get( Endpoint endpointAddress )
	{
		List<EndpointBinding> result = new ArrayList<EndpointBinding>();
		
		for ( EndpointBinding b : bindings ) {
			if ( b.endpointAddress.equals(endpointAddress) ) result.add(b);
		}
		
		return result;
	}

	public List<EndpointBinding> get( String endpointUrl )
	{
		List<EndpointBinding> result = new ArrayList<EndpointBinding>();
		
		for ( EndpointBinding b : bindings ) {
			if ( b.endpointAddress.getEndpointUrl().equals(endpointUrl) ) result.add(b);
		}
		
		return result;
	}
	
	public List<EndpointBinding> get( EndpointServer endpointServer )
	{
		List<EndpointBinding> result = new ArrayList<EndpointBinding>();
		
		for ( EndpointBinding b : bindings ) {
			if ( b.endpointServer.equals(endpointServer) ) result.add(b);
		}
		
		return result;
	}
	
	public List<EndpointBinding> get( Server serviceServer )
	{
		List<EndpointBinding> result = new ArrayList<EndpointBinding>();
		
		for ( EndpointBinding b : bindings ) {
			if ( b.serviceServer.equals(serviceServer) ) result.add(b);
		}
		
		return result;
	}
	
	public List<EndpointBinding> get( EndpointServer endpointServer, Endpoint endpointAddress )
	{
		List<EndpointBinding> result = new ArrayList<EndpointBinding>();
		
		for ( EndpointBinding b : bindings ) {
			if ( b.endpointAddress.equals(endpointAddress) &&
				 b.endpointServer.equals(endpointServer)	
				 ) result.add(b);
		}
		
		return result;
	}

	public EndpointBinding getSingle( EndpointServer endpointServer, Endpoint endpointAddress )
	{
		for ( EndpointBinding b : bindings ) {
			if ( b.endpointAddress.equals(endpointAddress) &&
				 b.endpointServer.equals(endpointServer)	
				 ) return b;
		}
		
		return null;
	}
	
	
	public List<EndpointBinding> get( Endpoint endpointAddress, Server serviceServer )
	{
		List<EndpointBinding> result = new ArrayList<EndpointBinding>();
		
		for ( EndpointBinding b : bindings ) {
			if ( b.endpointAddress.equals(endpointAddress) &&
					b.serviceServer.equals(serviceServer)
					) result.add(b);
		}
		
		return result;
	}
	
	public List<EndpointBinding> get( EndpointServer endpointServer, Server serviceServer )
	{
		List<EndpointBinding> result = new ArrayList<EndpointBinding>();
		
		for ( EndpointBinding b : bindings ) {
			if ( b.endpointServer.equals(endpointServer) &&
					b.serviceServer.equals(serviceServer) 
					) result.add(b);
		}
		
		return result;
	}

	public List<Endpoint> getEndpointAddresses() {
		return getEndpointAddresses( bindings );
	}
	
	public List<Server> getServiceServers() {
		return getServiceServers( bindings );
	}
	
	public List<EndpointServer> getEndpointServers() {
		return getEndpointServers( bindings );
	}
	
	/**
	 * Get a list of service servers in an bindingList
	 * @param bindingList
	 * @return
	 */
	public static List<Server> getServiceServers(List<EndpointBinding> bindingList) 
	{
		List<Server> result = new ArrayList<Server>();
		for (EndpointBinding binding : bindingList) {
			if ( !result.contains( binding.serviceServer )) result.add(binding.serviceServer);
		}
		return result;
	}
	
	/**
	 * Get a list of endpoint servers in an bindingList
	 * @param bindingList
	 * @return
	 */
	public static List<EndpointServer> getEndpointServers(List<EndpointBinding> bindingList) 
	{
		List<EndpointServer> result = new ArrayList<EndpointServer>();
		for (EndpointBinding binding : bindingList) {
			if ( !result.contains( binding.endpointServer )) result.add(binding.endpointServer);
		}
		return result;
	}

	/**
	 * Get a list of endpoint addresses in an bindingList
	 * @param bindingList
	 * @return
	 */
	public static List<Endpoint> getEndpointAddresses(List<EndpointBinding> bindingList) 
	{
		List<Endpoint> result = new ArrayList<Endpoint>();
		for (EndpointBinding binding : bindingList) {
			if ( !result.contains( binding.endpointAddress )) result.add(binding.endpointAddress);
		}
		return result;
	}

	public void clear() {
		bindings.clear();
	}
	
	/// Listener
	
	public interface EndpointBindingListener {
		
		void onAddingEndpoint(EndpointBinding endpointBinding);
		
	}
	
	public void addListener(EndpointBindingListener listener) 
	{
		listeners.add(listener);
	}
	
	public void removeListener(EndpointBindingListener listener)
	{
		listeners.remove(listener);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for ( EndpointBinding eb : bindings ) {
			sb.append( eb.toString() );
			sb.append( "\n" );
		}
		return sb.toString();
	}

}
