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

package org.opcfoundation.ua.core;

import org.opcfoundation.ua.builtintypes.Structure;
import org.opcfoundation.ua.builtintypes.ExpandedNodeId;
import org.opcfoundation.ua.core.Identifiers;
import org.opcfoundation.ua.utils.ObjectUtils;
import org.opcfoundation.ua.core.UserIdentityToken;



public class KerberosIdentityToken extends UserIdentityToken implements Structure, Cloneable {
	
	public static final ExpandedNodeId ID = new ExpandedNodeId(Identifiers.KerberosIdentityToken);
	public static final ExpandedNodeId BINARY = new ExpandedNodeId(Identifiers.KerberosIdentityToken_Encoding_DefaultBinary);
	public static final ExpandedNodeId XML = new ExpandedNodeId(Identifiers.KerberosIdentityToken_Encoding_DefaultXml);
	
    protected byte[] TicketData;
    
    public KerberosIdentityToken() {}
    
    public KerberosIdentityToken(String PolicyId, byte[] TicketData)
    {
        super(PolicyId);
        this.TicketData = TicketData;
    }
    
    public byte[] getTicketData()
    {
        return TicketData;
    }
    
    public void setTicketData(byte[] TicketData)
    {
        this.TicketData = TicketData;
    }
    
    /**
      * Deep clone
      *
      * @return cloned KerberosIdentityToken
      */
    public KerberosIdentityToken clone()
    {
        KerberosIdentityToken result = new KerberosIdentityToken();
        result.PolicyId = PolicyId;
        result.TicketData = TicketData;
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        KerberosIdentityToken other = (KerberosIdentityToken) obj;
        if (PolicyId==null) {
            if (other.PolicyId != null) return false;
        } else if (!PolicyId.equals(other.PolicyId)) return false;
        if (TicketData==null) {
            if (other.TicketData != null) return false;
        } else if (!TicketData.equals(other.TicketData)) return false;
        return true;
    }
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((PolicyId == null) ? 0 : PolicyId.hashCode());
        result = prime * result
                + ((TicketData == null) ? 0 : TicketData.hashCode());
        return result;
    }
    


	public ExpandedNodeId getTypeId() {
		return ID;
	}

	public ExpandedNodeId getXmlEncodeId() {
		return XML;
	}

	public ExpandedNodeId getBinaryEncodeId() {
		return BINARY;
	}
	
	public String toString() {
		return "KerberosIdentityToken: "+ObjectUtils.printFieldsDeep(this);
	}

}
