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

package org.opcfoundation.ua.utils;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * 
 * 
 * @author Toni Kalajainen (toni.kalajainen@vtt.fi)
 */
public interface IStatefulObject<StateType, ErrorType extends Throwable> {

	/** 
	 * Add post-event notification listener. The prosessing thread is random. 
	 * The prosessing order is not guaranteed if the handling is not synchronized.
	 * 
	 * @param listener
	 */	
	void addStateNotifiable(StateListener<StateType> notifiable);
	void removeStateNotifiable(StateListener<StateType> notifiable);

	/** 
	 * Add on-event listener. 
	 * 
	 * @param listener
	 */	
	void addStateListener(StateListener<StateType> listener);
	void removeStateListener(StateListener<StateType> listener);
	
	StateType getState();
	
	/**
	 * Wait until state changes to one of the given states.
	 * 
	 * @param set states that ends waiting  
	 * @throws InterruptedException
	 * @return the state in the given set that broke the wait 
	 */
	StateType waitForState(Set<StateType> set) 
	throws InterruptedException, ErrorType;
	
	/**
	 * Wait until state changes to one of the given states.
	 * 
	 * @param set states that ends waiting  
	 * @return the state in the given set that broke the wait 
	 */
	StateType waitForStateUninterruptibly(Set<StateType> set) 
	throws ErrorType;	
	
	
	/**
	 * Wait until state changes to one of the given states or until
	 * time out occurs. 
	 * 
	 * @param set
	 * @param timeout
	 * @param unit
	 * @return state one in set
	 * @throws InterruptedException thread was interrupted
	 * @throws TimeoutException timeout occured
	 */
	StateType waitForState(Set<StateType> set, long timeout, TimeUnit unit) 
	throws InterruptedException, TimeoutException, ErrorType;

	/**
	 * Get error state or null
	 * @return error
	 */
	ErrorType getError();
	
}
